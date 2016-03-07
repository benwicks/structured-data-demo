package com.benjaminwicks.structureddatademo.dataFormatDetails;

import java.text.DecimalFormat;

public final class BytesFormatHelper {

    private static final DecimalFormat FORMAT = new DecimalFormat("#.00");

    private BytesFormatHelper() {
    }

    public static String formatBytes(int bytesCount) {
        if (bytesCount > 999999) {
            return FORMAT.format(bytesCount / 1000000.0) + " MB";
        } else if (bytesCount > 999) {
            return bytesCount / 1000 + " KB";
        } else {
            return String.valueOf(bytesCount) + " bytes";
        }
    }
}
