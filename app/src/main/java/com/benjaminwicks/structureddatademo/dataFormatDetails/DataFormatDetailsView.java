package com.benjaminwicks.structureddatademo.dataFormatDetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.benjaminwicks.structureddatademo.R;
import com.benjaminwicks.structureddatademo.ScreenManager;
import com.benjaminwicks.structureddatademo.speciesDetails.SpeciesDetailsScreen;
import com.jaynewstrom.concrete.Concrete;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

final class DataFormatDetailsView extends LinearLayout {

    @Inject DataFormat dataFormat;
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
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                screenManager.push(new SpeciesDetailsScreen(speciesAdapter.getItem(position)));
            }
        });
    }

    private void setupView() {
        dataFormatTextView.setText(dataFormat.name);
        dataParsingMethodTextView.setText(dataParsingMethod.name);
    }

    @OnClick(R.id.btn_decode) void onClickDecode() {

    }

    @OnClick(R.id.btn_encode) void onClickEncode() {

    }
}
