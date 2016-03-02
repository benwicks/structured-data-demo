package com.benjaminwicks.structureddatademo.dataFormatDetails;

import static com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod.GOOGLE_PROTOBUF_PARSER;
import static com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod.GSON_JSON_PARSER;
import static com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod.JACKSON_JSON_PARSER;
import static com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod.MOSHI_JSON_PARSER;
import static com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod.SAX_XML_PARSER;
import static com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod.SQUARE_WIRE_PROTOBUF_PARSER;
import static com.benjaminwicks.structureddatademo.dataFormatDetails.DataParsingMethod.XML_PULL_PARSER;

public enum DataFormat {
    XML("XML", new DataParsingMethod[]{SAX_XML_PARSER, XML_PULL_PARSER}, "3.42 MB"),
    JSON("JSON", new DataParsingMethod[]{MOSHI_JSON_PARSER, JACKSON_JSON_PARSER, GSON_JSON_PARSER}, "2.87 MB"),
    PROTOBUF("Protocol Buffers", new DataParsingMethod[]{GOOGLE_PROTOBUF_PARSER, SQUARE_WIRE_PROTOBUF_PARSER}, "1.25 MB");

    public final String name;
    public final DataParsingMethod[] children;
    public final String fileSize;

    DataFormat(String name, DataParsingMethod[] children, String fileSize) {
        this.name = name;
        this.children = children;
        this.fileSize = fileSize;
    }
}
