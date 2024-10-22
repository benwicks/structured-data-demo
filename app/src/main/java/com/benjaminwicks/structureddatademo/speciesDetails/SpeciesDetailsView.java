package com.benjaminwicks.structureddatademo.speciesDetails;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.benjaminwicks.structureddatademo.R;
import com.benjaminwicks.structureddatademo.model.Species;
import com.jaynewstrom.concrete.Concrete;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

final class SpeciesDetailsView extends LinearLayout {

    @Inject Species species;
    @Inject Picasso picasso;

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.iv_image) ImageView imageView;
    @Bind(R.id.tv_species_name) TextView speciesTextView;
    @Bind(R.id.tv_kingdom) TextView kingdomTextView;
    @Bind(R.id.tv_class) TextView classTextView;
    @Bind(R.id.tv_order) TextView orderTextView;
    @Bind(R.id.tv_phylum) TextView phylumTextView;
    @Bind(R.id.tv_genus) TextView genusTextView;
    @Bind(R.id.tv_scientific_name) TextView scientificNameTextView;
    @Bind(R.id.tv_according_to) TextView accordingToTextView;
    @Bind(R.id.tv_last_interpreted) TextView lastInterpretedTextView;
    @Bind(R.id.tv_last_crawled) TextView lastCrawledTextView;
    @Bind(R.id.tv_link) TextView linkTextView;

    private static final SimpleDateFormat NICE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    SpeciesDetailsView(Context context) {
        super(context);
        Concrete.inject(context, this);
        setBackgroundResource(android.R.color.white);
        LayoutInflater.from(context).inflate(R.layout.species_details, this);
        setOrientation(VERTICAL);
        ButterKnife.bind(this);
        setupView();
    }

    private void setupView() {
        toolbar.setTitle(species.canonicalName);
        picasso.load(species.imageUrl)
               .placeholder(android.R.drawable.ic_menu_gallery)
               .error(android.R.drawable.stat_notify_error)
               .into(imageView);
        speciesTextView.setText(species.species);
        kingdomTextView.setText(species.kingdom);
        classTextView.setText(species.theClass);
        orderTextView.setText(species.order);
        phylumTextView.setText(species.phylum);
        genusTextView.setText(species.genus);
        scientificNameTextView.setText(species.scientificName);
        accordingToTextView.setText(species.accordingTo);
        lastInterpretedTextView.setText(NICE_DATE_FORMAT.format(species.lastInterpreted));
        lastCrawledTextView.setText(NICE_DATE_FORMAT.format(species.lastCrawled));
        linkTextView.setText(getContext().getString(R.string.link_format, species.speciesKey));
    }

    @OnClick(R.id.iv_image) void onClickImage() {
        getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(species.imageUrl)));
    }
}
