package com.benjaminwicks.structureddatademo.dataFormatDetails;

import android.content.Context;
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
import com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers.DecodeTask;
import com.benjaminwicks.structureddatademo.model.Species;
import com.benjaminwicks.structureddatademo.speciesDetails.SpeciesDetailsScreen;
import com.jaynewstrom.concrete.Concrete;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class DataFormatDetailsView extends LinearLayout {

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
    @Bind(R.id.tv_empty_list) TextView emptyTextView;

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
        listView.setEmptyView(emptyTextView);
        listView.setAdapter(speciesAdapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                screenManager.push(new SpeciesDetailsScreen(speciesAdapter.getItem(position)));
            }
        });
    }

    @OnClick(R.id.btn_decode) void onClickDecode() {
        new DecodeTask(this, dataParsingMethod, applicationContext.getAssets()).execute();
    }

    @OnClick(R.id.btn_encode) void onClickEncode() {
        new EncodeTask(this, dataParsingMethod, speciesAdapter.getSpeciesList()).execute();
    }

    private void setButtonsEnabled(boolean enabled) {
        decodeButton.setEnabled(enabled);
        encodeButton.setEnabled(enabled);
    }

    public void onDecodePreExecute() {
        decodeTimeTextView.setText(R.string.decoding);
        speciesAdapter.setSpeciesList(Collections.<Species>emptyList());
        emptyTextView.setText(R.string.decoding);
        listView.invalidate();
        setButtonsEnabled(false);
    }

    public void onDecodePostExecute(long startTime, List<Species> species, Exception exception) {
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

    public void onEncodePreExecute() {
        setButtonsEnabled(false);
    }

    public void onEncodePostExecute(long startTime, Exception exception, Byte[] bytes) {
        setButtonsEnabled(true);
        if (exception == null) {
            Toast.makeText(getContext(), "Encoded to " + bytes.length + " bytes", Toast.LENGTH_SHORT).show();
            long milliseconds = TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);
            encodeTimeTextView.setText(TimeFormatHelper.formatMilliseconds(milliseconds));
        } else {
            Toast.makeText(getContext(), "Encode not enabled for " + dataParsingMethod.name + " yet.", Toast.LENGTH_SHORT).show();
        }
    }
}
