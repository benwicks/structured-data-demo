package com.benjaminwicks.structureddatademo.dataFormatDetails;

public final class TimeFormatHelper {

    private TimeFormatHelper() {
    }

    public static String formatMilliseconds(long averageDecodeTimeMs) {
        if (averageDecodeTimeMs > 999) {
            int seconds = (int) (averageDecodeTimeMs / 1000);
            int remainderMs = (int) (averageDecodeTimeMs % 1000);
            return String.valueOf(seconds) + "s " + String.valueOf(remainderMs) + "ms";
        } else {
            return String.valueOf(averageDecodeTimeMs) + "ms";
        }
    }
}
