package com.benjaminwicks.structureddatademo.dataFormatDetails;

public enum DataParsingMethod {
    SAX_XML_PARSER("SAX (javax.xml.parsers.SAXParser)", DataFormat.XML),
    XML_PULL_PARSER("Pull (org.xmlpull.v1.XmlPullParser)", DataFormat.XML),
    MOSHI_JSON_PARSER("Square Moshi", DataFormat.JSON),
    JACKSON_JSON_PARSER("FasterXML Jackson", DataFormat.JSON),
    GSON_JSON_PARSER("Google Gson", DataFormat.JSON),
    GOOGLE_PROTOBUF_PARSER("Google Protobuf", DataFormat.PROTOBUF),
    SQUARE_WIRE_PROTOBUF_PARSER("Square Wire", DataFormat.PROTOBUF);

    public final String name;
    public final DataFormat parent;

    DataParsingMethod(String name, DataFormat parent) {
        this.name = name;
        this.parent = parent;
    }
}
