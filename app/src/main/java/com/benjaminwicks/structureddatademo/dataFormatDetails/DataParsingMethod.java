package com.benjaminwicks.structureddatademo.dataFormatDetails;

public enum DataParsingMethod {
    SAX_XML_PARSER("SAX (javax.xml.parsers.SAXParser)"),
    XML_PULL_PARSER("Pull (org.xmlpull.v1.XmlPullParser)"),
    MOSHI_JSON_PARSER("Square Moshi"),
    JACKSON_JSON_PARSER("FasterXML Jackson"),
    GSON_JSON_PARSER("Google Gson"),
    GOOGLE_PROTOBUF_PARSER("Google Protobuf"),
    SQUARE_WIRE_PROTOBUF_PARSER("Square Wire");

    public final String name;

    DataParsingMethod(String name) {
        this.name = name;
    }

    public long getAverageDecodeTime() {
        return (long) (Math.random() * 4000); // retrieve from DB and calculate in ms
    }

    public long getAverageEncodeTime() {
        return (long) (Math.random() * 3000); // retrieve from DB and calculate in ms
    }

    public int getRunCount() {
        return 0; // retrieve from DB
    }
}
