package com.benjaminwicks.structureddatademo.dataFormatDetails;

import android.content.Context;
import android.support.v7.widget.Toolbar;
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
import com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers.EncodeTask;
import com.benjaminwicks.structureddatademo.dataFormatsList.DataParsingMethodListItemView;
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
    @Inject DataParsingMethodDetailsStateHolder stateHolder;

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.tv_decode_time) TextView decodeTimeTextView;
    @Bind(R.id.btn_decode) TextView decodeButton;
    @Bind(R.id.tv_encode_time) TextView encodeTimeTextView;
    @Bind(R.id.btn_encode) TextView encodeButton;
    @Bind(R.id.list_view) ListView listView;
    @Bind(R.id.tv_empty_list) TextView emptyTextView;

    private DataParsingMethodListItemView dataParsingMethodListItemView;

    DataFormatDetailsView(Context context, DataParsingMethodListItemView dataParsingMethodListItemView) {
        this(context);
        this.dataParsingMethodListItemView = dataParsingMethodListItemView;
    }

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
        toolbar.setTitle(dataParsingMethod.parent.name);
        toolbar.setSubtitle(dataParsingMethod.name);
        decodeTimeTextView.setText(stateHolder.getLastDecodeTimeText());
        encodeTimeTextView.setText(stateHolder.getLastEncodeTimeText());
        encodeButton.setEnabled(stateHolder.isEncodeEnabled());
        emptyTextView.setText(stateHolder.getLastEmptyText());
        listView.setEmptyView(emptyTextView);
        listView.setAdapter(stateHolder.getSpeciesAdapter());
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                screenManager.push(new SpeciesDetailsScreen(stateHolder.getSpeciesAtPosition(position)));
            }
        });
    }

    @OnClick(R.id.btn_decode) void onClickDecode() {
        new DecodeTask(this, dataParsingMethod, applicationContext.getAssets()).execute();
    }

    @OnClick(R.id.btn_encode) void onClickEncode() {
        new EncodeTask(this, dataParsingMethod, stateHolder.getSpeciesList()).execute();
    }

    private void setIsCurrentlyTranscoding(boolean isCurrentlyTranscoding) {
        stateHolder.setIsCurrentlyTranscoding(isCurrentlyTranscoding);
    }

    public void onDecodePreExecute() {
        stateHolder.setLastDecodeTimeText(getContext().getString(R.string.decoding));
        stateHolder.setSpeciesList(Collections.<Species>emptyList());
        stateHolder.setLastEmptyText(getContext().getString(R.string.decoding));
        setIsCurrentlyTranscoding(true);
    }

    public void onDecodePostExecute(long startTime, List<Species> species, Exception exception) {
        setIsCurrentlyTranscoding(false);
        if (exception == null) {
            long milliseconds = TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);
            Toast.makeText(getContext(), "Decoded " + species.size() + " records", Toast.LENGTH_SHORT).show();
            stateHolder.setSpeciesList(species);
            dataParsingMethod.recordDecodeTime(getContext(), milliseconds);
            if (dataParsingMethodListItemView != null) {
                dataParsingMethodListItemView.runStatsLoaderTask();
            }
            stateHolder.setLastDecodeTimeText(TimeFormatHelper.formatMilliseconds(milliseconds));
        } else {
            stateHolder.setLastDecodeTimeText(getContext().getString(R.string.decode_failed));
            stateHolder.setLastEmptyText(getContext().getString(R.string.empty_list));
            Log.e("Decode exception", exception.getClass().toString());
            Toast.makeText(getContext(), "Decode not enabled for " + dataParsingMethod.name + " yet.", Toast.LENGTH_SHORT).show();
        }
    }

    public void onEncodePreExecute() {
        stateHolder.setLastEncodeTimeText(getContext().getString(R.string.encoding));
        setIsCurrentlyTranscoding(true);
    }

    public void onEncodePostExecute(long startTime, Exception exception, Byte[] bytes) {
        setIsCurrentlyTranscoding(false);
        if (exception == null) {
            long milliseconds = TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);
            Toast.makeText(getContext(), "Encoded to " + BytesFormatHelper.formatBytes(bytes.length), Toast.LENGTH_SHORT).show();
            dataParsingMethod.recordEncodeTime(getContext(), milliseconds);
            if (dataParsingMethodListItemView != null) {
                dataParsingMethodListItemView.runStatsLoaderTask();
            }
            stateHolder.setLastEncodeTimeText(TimeFormatHelper.formatMilliseconds(milliseconds));
        } else {
            stateHolder.setLastEncodeTimeText(getContext().getString(R.string.encode_failed));
            Log.e("Encode exception", exception.getClass().toString());
            Toast.makeText(getContext(), "Encode not enabled for " + dataParsingMethod.name + " yet.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        stateHolder.setViewReference(this);
    }

    @Override protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stateHolder.dropViewReference();
    }
}
