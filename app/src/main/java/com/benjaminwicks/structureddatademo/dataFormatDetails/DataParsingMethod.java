package com.benjaminwicks.structureddatademo.dataFormatDetails;

import android.content.res.AssetManager;

import com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers.DataParser;
import com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers.JacksonParser;
import com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers.WireParser;
import com.benjaminwicks.structureddatademo.model.Species;

import java.io.IOException;
import java.util.List;

public enum DataParsingMethod {
    SAX_XML_PARSER("SAX (javax.xml.parsers.SAXParser)", DataFormat.XML, null),
    XML_PULL_PARSER("Pull (org.xmlpull.v1.XmlPullParser)", DataFormat.XML, null),
    MOSHI_JSON_PARSER("Square Moshi", DataFormat.JSON, null),
    JACKSON_JSON_PARSER("FasterXML Jackson", DataFormat.JSON, JacksonParser.class),
    GSON_JSON_PARSER("Google Gson", DataFormat.JSON, null),
    GOOGLE_PROTOBUF_PARSER("Google Protobuf", DataFormat.PROTOBUF, null),
    SQUARE_WIRE_PROTOBUF_PARSER("Square Wire", DataFormat.PROTOBUF, WireParser.class);

    public final String name;
    public final DataFormat parent;
    private DataParser dataParser;

    DataParsingMethod(String name, DataFormat parent, Class<? extends DataParser> dataParserClass) {
        this.name = name;
        this.parent = parent;
        try {
            this.dataParser = dataParserClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Species> decode(AssetManager assetManager) throws IOException, NullPointerException {
        return dataParser.decode(assetManager.open("data" + parent.fileExtension));
    }

    public byte[] encode(List<Species> speciesList) throws IOException {
        return dataParser.encode(speciesList);
    }
}
