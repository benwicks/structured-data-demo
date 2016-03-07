package com.benjaminwicks.structureddatademo.dataFormatDetails;

import java.util.ArrayList;
import java.util.List;

public enum DataFormat {
    XML("XML", 3417303, 256816, ".xml"),
    JSON("JSON", 2868966, 245858, ".json"),
    PROTOBUF("Protocol Buffers", 1247730, 177711, ".ser");

    public final String name;
    public final int fileSizeBytes;
    public final int gZippedFileSizeBytes;
    final String fileExtension;

    DataFormat(String name, int fileSizeBytes, int gZippedFileSizeBytes, String fileExtension) {
        this.name = name;
        this.fileSizeBytes = fileSizeBytes;
        this.gZippedFileSizeBytes = gZippedFileSizeBytes;
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
