package com.benjaminwicks.structureddatademo.dataFormatDetails;

import android.support.annotation.ColorRes;

import com.benjaminwicks.structureddatademo.R;

import java.util.ArrayList;
import java.util.List;

public enum DataFormat {
    XML("XML", 3417303, 256816, ".xml", R.color.red),
    JSON("JSON", 2868966, 245858, ".json", R.color.yellow),
    PROTOBUF("Protocol Buffers", 1247730, 177711, ".ser", R.color.green);

    public final String name;
    public final int fileSizeBytes;
    public final int gZippedFileSizeBytes;
    final String fileExtension;
    public final int colorRes;

    DataFormat(String name, int fileSizeBytes, int gZippedFileSizeBytes, String fileExtension, @ColorRes int colorRes) {
        this.name = name;
        this.fileSizeBytes = fileSizeBytes;
        this.gZippedFileSizeBytes = gZippedFileSizeBytes;
        this.fileExtension = fileExtension;
        this.colorRes = colorRes;
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
