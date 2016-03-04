package com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers;

import com.benjaminwicks.structureddatademo.model.Species;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class PullParser implements DataParser {

    @Override public byte[] encode(List<Species> speciesList) throws IOException {
        return new byte[0];
    }

    @Override public List<Species> decode(InputStream inputStream) throws IOException {
        try {
            return new XmlPullFeedParser(inputStream).parse();
        } catch (XmlPullParserException e) {
            throw new Error("Failed to parse XML", e);
        }
    }
}
