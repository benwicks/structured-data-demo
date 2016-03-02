package com.benjaminwicks.structureddatademo.dataFormatDetails;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.benjaminwicks.structureddatademo.ForApplication;
import com.benjaminwicks.structureddatademo.R;
import com.benjaminwicks.structureddatademo.ScreenManager;
import com.benjaminwicks.structureddatademo.model.Species;
import com.benjaminwicks.structureddatademo.speciesDetails.SpeciesDetailsScreen;
import com.jaynewstrom.concrete.Concrete;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

final class DataFormatDetailsView extends LinearLayout {

    @Inject @ForApplication Context applicationContext;
    @Inject DataParsingMethod dataParsingMethod;
    @Inject ScreenManager screenManager;

    @Bind(R.id.tv_data_format) TextView dataFormatTextView;
    @Bind(R.id.tv_data_parsing_method) TextView dataParsingMethodTextView;
    @Bind(R.id.tv_decode_time) TextView decodeTimeTextView;
    @Bind(R.id.btn_decode) TextView decodeButton;
    @Bind(R.id.tv_encode_time) TextView encodeTimeTextView;
    @Bind(R.id.btn_encode) TextView encodeButton;
    @Bind(R.id.list_view) ListView listView;

    private final SpeciesAdapter speciesAdapter = new SpeciesAdapter();

    DataFormatDetailsView(Context context) {
        super(context);
        Concrete.inject(context, this);
        LayoutInflater.from(context).inflate(R.layout.data_format_details, this, true);

        setOrientation(VERTICAL);
        setBackgroundResource(android.R.color.white);
        ButterKnife.bind(this);
        setupView();
    }

    private void setupView() {
        dataFormatTextView.setText(dataParsingMethod.parent.name);
        dataParsingMethodTextView.setText(dataParsingMethod.name);
        listView.setAdapter(speciesAdapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                screenManager.push(new SpeciesDetailsScreen(speciesAdapter.getItem(position)));
            }
        });
    }

    @OnClick(R.id.btn_decode) void onClickDecode() {
        new DecodeTask().execute();
    }

    @OnClick(R.id.btn_encode) void onClickEncode() {
        Toast.makeText(getContext(), "Encode not enabled for " + dataParsingMethod.name + " yet.", Toast.LENGTH_SHORT).show();
    }

    private final class DecodeTask extends AsyncTask<Void, Void, List<Species>> {

        private Exception exception;

        private DecodeTask() {
            this.exception = null;
        }

        private long startTime;

        @Override protected void onPreExecute() {
            super.onPreExecute();
            setButtonsEnabled(false);
            startTime = System.nanoTime();
        }

        @Override protected List<Species> doInBackground(Void... params) {
            try {
                return dataParsingMethod.decode(applicationContext.getAssets());
            } catch (NullPointerException | IOException | IllegalAccessException | InstantiationException e) {
                this.exception = e;
            }
            return Collections.emptyList();
        }

        @Override protected void onPostExecute(List<Species> species) {
            super.onPostExecute(species);
            setButtonsEnabled(true);
            if (exception == null) {
                Toast.makeText(getContext(), "Decoded " + species.size() + " records", Toast.LENGTH_SHORT).show();
                speciesAdapter.setSpeciesList(species);
                listView.invalidate();
                long milliseconds = TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);
                decodeTimeTextView.setText(TimeFormatHelper.formatMilliseconds(milliseconds));
            } else {
                Log.e("Failed to decode", exception.getClass().toString());
                Toast.makeText(getContext(), "Decode not enabled for " + dataParsingMethod.name + " yet.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void setButtonsEnabled(boolean enabled) {
        decodeButton.setEnabled(enabled);
        encodeButton.setEnabled(enabled);
    }
}
