package com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers.xml;

import com.benjaminwicks.structureddatademo.model.Species;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * This took ~20 minutes to write.
 */
public final class SpeciesListHandler extends DefaultHandler {

    private boolean currentElement = false;
    private String currentValue = "";
    private Species.Builder speciesBuilder = null;
    private List<Species> speciesList = new ArrayList<>();

    public List<Species> getSpeciesList() {
        return speciesList;
    }

    @Override public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = true;
        currentValue = "";
        if (localName.equals(Species.ITEM_TAG)) {
            speciesBuilder = new Species.Builder();
        }
    }

    @Override public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = false;
        switch (localName) {
            case Species.KINGDOM_TAG:
                speciesBuilder.setKingdom(currentValue);
                break;
            case Species.PARENT_TAG:
                speciesBuilder.setParent(currentValue);
                break;
            case Species.FAMILY_TAG:
                speciesBuilder.setFamily(currentValue);
                break;
            case Species.IMAGE_URL_TAG:
                speciesBuilder.setImageUrl(currentValue);
                break;
            case Species.LAST_INTERPRETED_TAG:
                try {
                    speciesBuilder.setLastInterpreted(Species.DATE_FORMAT.parse(currentValue));
                } catch (ParseException e) {
                    throw new SAXException("Failed to parse " + Species.LAST_INTERPRETED_TAG);
                }
                break;
            case Species.ACCORDING_TO_TAG:
                speciesBuilder.setAccordingTo(currentValue);
                break;
            case Species.SPECIES_KEY_TAG:
                speciesBuilder.setSpeciesKey(Integer.valueOf(currentValue));
                break;
            case Species.CANONICAL_NAME_TAG:
                speciesBuilder.setCanonicalName(currentValue);
                break;
            case Species.ORDER_TAG:
                speciesBuilder.setOrder(currentValue);
                break;
            case Species.PHYLUM_TAG:
                speciesBuilder.setPhylum(currentValue);
                break;
            case Species.SCIENTIFIC_NAME_TAG:
                speciesBuilder.setScientificName(currentValue);
                break;
            case Species.SPECIES_TAG:
                speciesBuilder.setSpecies(currentValue);
                break;
            case Species.AUTHORSHIP_TAG:
                speciesBuilder.setAuthorship(currentValue);
                break;
            case Species.GENUS_TAG:
                speciesBuilder.setGenus(currentValue);
                break;
            case Species.PARENT_KEY_TAG:
                speciesBuilder.setParentKey(Integer.valueOf(currentValue));
                break;
            case Species.CLASS_TAG:
                speciesBuilder.setTheClass(currentValue);
                break;
            case Species.LAST_CRAWLED_TAG:
                try {
                    speciesBuilder.setLastCrawled(Species.DATE_FORMAT.parse(currentValue));
                } catch (ParseException e) {
                    throw new SAXException("Failed to parse " + Species.LAST_CRAWLED_TAG);
                }
                break;
            case Species.ITEM_TAG:
                speciesList.add(speciesBuilder.build());
                break;
        }
    }

    @Override public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement) {
            currentValue = currentValue + new String(ch, start, length);
        }
    }
}
