package com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers;

import android.util.Xml;
import android.util.Xml.Encoding;

import com.benjaminwicks.structureddatademo.model.Species;

import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class PullParser implements DataParser {

    private static final String ROOT_TAG = "root";

    @Override public byte[] encode(List<Species> speciesList) throws IOException {
        XmlSerializer serializer = Xml.newSerializer();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        serializer.setOutput(outputStream, Encoding.UTF_8.name());
        serializer.startDocument(Encoding.UTF_8.name(), true);
        serializer.startTag(null, ROOT_TAG);
        for (Species s : speciesList) {
            serializer.startTag(null, Species.ITEM_TAG);
            serializer.startTag(null, Species.KINGDOM_TAG);
            serializer.text(s.kingdom);
            serializer.endTag(null, Species.KINGDOM_TAG);
            serializer.startTag(null, Species.PARENT_TAG);
            serializer.text(s.parent);
            serializer.endTag(null, Species.PARENT_TAG);
            serializer.startTag(null, Species.FAMILY_TAG);
            serializer.text(s.family);
            serializer.endTag(null, Species.FAMILY_TAG);
            serializer.startTag(null, Species.IMAGE_URL_TAG);
            serializer.text(s.imageUrl);
            serializer.endTag(null, Species.IMAGE_URL_TAG);
            serializer.startTag(null, Species.LAST_INTERPRETED_TAG);
            serializer.text(Species.DATE_FORMAT.format(s.lastInterpreted));
            serializer.endTag(null, Species.LAST_INTERPRETED_TAG);
            serializer.startTag(null, Species.ACCORDING_TO_TAG);
            serializer.text(s.accordingTo);
            serializer.endTag(null, Species.ACCORDING_TO_TAG);
            serializer.startTag(null, Species.SPECIES_KEY_TAG);
            serializer.text(String.valueOf(s.speciesKey));
            serializer.endTag(null, Species.SPECIES_KEY_TAG);
            serializer.startTag(null, Species.CANONICAL_NAME_TAG);
            serializer.text(s.canonicalName);
            serializer.endTag(null, Species.CANONICAL_NAME_TAG);
            serializer.startTag(null, Species.ORDER_TAG);
            serializer.text(s.order);
            serializer.endTag(null, Species.ORDER_TAG);
            serializer.startTag(null, Species.PHYLUM_TAG);
            serializer.text(s.phylum);
            serializer.endTag(null, Species.PHYLUM_TAG);
            serializer.startTag(null, Species.SCIENTIFIC_NAME_TAG);
            serializer.text(s.scientificName);
            serializer.endTag(null, Species.SCIENTIFIC_NAME_TAG);
            serializer.startTag(null, Species.SPECIES_TAG);
            serializer.text(s.species);
            serializer.endTag(null, Species.SPECIES_TAG);
            serializer.startTag(null, Species.AUTHORSHIP_TAG);
            serializer.text(s.authorship);
            serializer.endTag(null, Species.AUTHORSHIP_TAG);
            serializer.startTag(null, Species.GENUS_TAG);
            serializer.text(s.genus);
            serializer.endTag(null, Species.GENUS_TAG);
            serializer.startTag(null, Species.PARENT_KEY_TAG);
            serializer.text(String.valueOf(s.parentKey));
            serializer.endTag(null, Species.PARENT_KEY_TAG);
            serializer.startTag(null, Species.CLASS_TAG);
            serializer.text(s.theClass);
            serializer.endTag(null, Species.CLASS_TAG);
            serializer.startTag(null, Species.LAST_CRAWLED_TAG);
            serializer.text(Species.DATE_FORMAT.format(s.lastCrawled));
            serializer.endTag(null, Species.LAST_CRAWLED_TAG);
            serializer.endTag(null, Species.ITEM_TAG);
        }
        serializer.endTag(null, ROOT_TAG);
        serializer.endDocument();
        serializer.flush();
        outputStream.close();
        return outputStream.toByteArray();
    }

    @Override public List<Species> decode(InputStream inputStream) throws IOException {
        try {
            return new XmlPullFeedParser(inputStream).parse();
        } catch (XmlPullParserException e) {
            throw new Error("Failed to parse XML", e);
        }
    }
}
