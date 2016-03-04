package com.benjaminwicks.structureddatademo.dataFormatDetails;

import java.util.ArrayList;
import java.util.List;

public enum DataFormat {
    XML("XML", "3.42 MB", "251 KB", ".xml"),
    JSON("JSON", "2.87 MB", "240 KB", ".json"),
    PROTOBUF("Protocol Buffers", "1.25 MB", "174 KB", ".ser");

    public final String name;
    public final String fileSize;
    public final String gZippedFileSize;
    final String fileExtension;

    DataFormat(String name, String fileSize, String gZippedFileSize, String fileExtension) {
        this.name = name;
        this.fileSize = fileSize;
        this.gZippedFileSize = gZippedFileSize;
        this.fileExtension = fileExtension;
    }

    public List<DataParsingMethod> getChildren() {
        List<DataParsingMethod> children = new ArrayList<>();
        for (DataParsingMethod parsingMethod : DataParsingMethod.values()) {
            if (equals(parsingMethod.parent)) {
                children.add(parsingMethod);
            }
        }
        return children;
    }
}
