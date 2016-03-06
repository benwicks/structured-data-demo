package com.benjaminwicks.structureddatademo.model.moshi;

import com.benjaminwicks.structureddatademo.model.Species;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import java.text.ParseException;
import java.util.Date;

public final class SpeciesDateAdapter {

    @ToJson String toJson(Date date) {
        return Species.DATE_FORMAT.format(date);
    }

    @FromJson Date fromJson(String date) throws ParseException {
        return Species.DATE_FORMAT.parse(date);
    }

}
