package com.benjaminwicks.structureddatademo.dataFormatDetails;

import java.text.DecimalFormat;

final class BytesFormatHelper {

    private static final DecimalFormat FORMAT = new DecimalFormat("#.00");

    private BytesFormatHelper() {
    }

    static String formatBytes(int bytesCount) {
        if (bytesCount > 999999) {
            return FORMAT.format(bytesCount / 1000000.0) + " MB";
        } else {
            return String.valueOf(bytesCount) + " bytes";
        }
    }
}
