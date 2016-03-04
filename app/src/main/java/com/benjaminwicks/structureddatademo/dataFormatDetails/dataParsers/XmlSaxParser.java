package com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers;

import com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers.xml.SpeciesListHandler;
import com.benjaminwicks.structureddatademo.model.Species;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public final class XmlSaxParser implements DataParser {

    @Override public byte[] encode(List<Species> speciesList) throws IOException {
        return new byte[0];
    }

    @Override public List<Species> decode(InputStream inputStream) throws IOException {
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            SpeciesListHandler defaultHandler = new SpeciesListHandler();
            parser.parse(inputStream, defaultHandler);
            return defaultHandler.getSpeciesList();
        } catch (ParserConfigurationException | SAXException e) {
            throw new Error("Failed to parse XML", e);
        }
    }
}
