package com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers;

import com.benjaminwicks.structureddatademo.model.Species;
import com.benjaminwicks.structureddatademo.model.Species.Builder;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

final class XmlPullFeedParser {

    private static final String LIST_END_TAG = "root";

    private final InputStream inputStream;

    XmlPullFeedParser(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    List<Species> parse() throws XmlPullParserException {
        List<Species> speciesList = new ArrayList<>();
        XmlPullParser xmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParser.setInput(inputStream, null);
        int eventType = xmlPullParser.getEventType();
        Species.Builder currentSpeciesBuilder = new Builder();
        boolean done = false;
        while (eventType != XmlPullParser.END_DOCUMENT && !done) {
            String name;
            try {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        name = xmlPullParser.getName();
                        switch (name) {
                            case Species.ITEM_TAG:
                                currentSpeciesBuilder = new Species.Builder();
                                break;
                            case Species.KINGDOM_TAG:
                                currentSpeciesBuilder.setKingdom(xmlPullParser.nextText());
                                break;
                            case Species.PARENT_TAG:
                                currentSpeciesBuilder.setParent(xmlPullParser.nextText());
                                break;
                            case Species.FAMILY_TAG:
                                currentSpeciesBuilder.setFamily(xmlPullParser.nextText());
                                break;
                            case Species.IMAGE_URL_TAG:
                                currentSpeciesBuilder.setImageUrl(xmlPullParser.nextText());
                                break;
                            case Species.LAST_INTERPRETED_TAG:
                                try {
                                    currentSpeciesBuilder.setLastInterpreted(Species.DATE_FORMAT.parse(xmlPullParser.nextText()));
                                } catch (ParseException e) {
                                    throw new IOException("Failed to parse " + Species.LAST_INTERPRETED_TAG);
                                }
                                break;
                            case Species.ACCORDING_TO_TAG:
                                currentSpeciesBuilder.setAccordingTo(xmlPullParser.nextText());
                                break;
                            case Species.SPECIES_KEY_TAG:
                                currentSpeciesBuilder.setSpeciesKey(Integer.valueOf(xmlPullParser.nextText()));
                                break;
                            case Species.CANONICAL_NAME_TAG:
                                currentSpeciesBuilder.setCanonicalName(xmlPullParser.nextText());
                                break;
                            case Species.ORDER_TAG:
                                currentSpeciesBuilder.setOrder(xmlPullParser.nextText());
                                break;
                            case Species.PHYLUM_TAG:
                                currentSpeciesBuilder.setPhylum(xmlPullParser.nextText());
                                break;
                            case Species.SCIENTIFIC_NAME_TAG:
                                currentSpeciesBuilder.setScientificName(xmlPullParser.nextText());
                                break;
                            case Species.SPECIES_TAG:
                                currentSpeciesBuilder.setSpecies(xmlPullParser.nextText());
                                break;
                            case Species.AUTHORSHIP_TAG:
                                currentSpeciesBuilder.setAuthorship(xmlPullParser.nextText());
                                break;
                            case Species.GENUS_TAG:
                                currentSpeciesBuilder.setGenus(xmlPullParser.nextText());
                                break;
                            case Species.PARENT_KEY_TAG:
                                currentSpeciesBuilder.setParentKey(Integer.valueOf(xmlPullParser.nextText()));
                                break;
                            case Species.CLASS_TAG:
                                currentSpeciesBuilder.setTheClass(xmlPullParser.nextText());
                                break;
                            case Species.LAST_CRAWLED_TAG:
                                try {
                                    currentSpeciesBuilder.setLastCrawled(Species.DATE_FORMAT.parse(xmlPullParser.nextText()));
                                } catch (ParseException e) {
                                    throw new IOException("Failed to parse " + Species.LAST_CRAWLED_TAG);
                                }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        name = xmlPullParser.getName();
                        if (name.equals(Species.ITEM_TAG)) {
                            speciesList.add(currentSpeciesBuilder.build());
                        } else if (name.equals(LIST_END_TAG)) {
                            done = true;
                        }
                        break;
                }
                eventType = xmlPullParser.next();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return speciesList;
    }
}
