package com.benjaminwicks.structureddatademo.dataFormatDetails;

import android.content.Context;
import android.content.res.AssetManager;

import com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers.DataParser;
import com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers.GsonParser;
import com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers.JacksonParser;
import com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers.MoshiParser;
import com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers.ProtobufParser;
import com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers.PullParser;
import com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers.WireParser;
import com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers.XmlSaxParser;
import com.benjaminwicks.structureddatademo.model.Species;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public enum DataParsingMethod {
    SAX_XML_PARSER("SAX (javax.xml.parsers.SAXParser)", DataFormat.XML, XmlSaxParser.class),
    XML_PULL_PARSER("Pull (org.xmlpull.v1.XmlPullParser)", DataFormat.XML, PullParser.class),
    MOSHI_JSON_PARSER("Square Moshi", DataFormat.JSON, MoshiParser.class),
    JACKSON_JSON_PARSER("FasterXML Jackson", DataFormat.JSON, JacksonParser.class),
    GSON_JSON_PARSER("Google Gson", DataFormat.JSON, GsonParser.class),
    GOOGLE_PROTOBUF_PARSER("Google Protobuf", DataFormat.PROTOBUF, ProtobufParser.class),
    SQUARE_WIRE_PROTOBUF_PARSER("Square Wire", DataFormat.PROTOBUF, WireParser.class);

    public static final long NO_TIME_RECORDED = -1;

    private static final String DECODE_FILE_SUFFIX = "_DECODE.txt";
    private static final String ENCODE_FILE_SUFFIX = "_ENCODE.txt";

    public final String name;
    public final DataFormat parent;

    private DataParser dataParser;

    DataParsingMethod(String name, DataFormat parent, Class<? extends DataParser> dataParserClass) {
        this.name = name;
        this.parent = parent;
        try {
            dataParser = dataParserClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean hasAnyStats(Context context) {
        for (DataParsingMethod method : values()) {
            if (method.hasStats(context)) {
                return true;
            }
        }
        return false;
    }

    public List<Species> decode(AssetManager assetManager) throws IOException, NullPointerException {
        return dataParser.decode(assetManager.open("data" + parent.fileExtension));
    }

    public byte[] encode(List<Species> speciesList) throws IOException {
        return dataParser.encode(speciesList);
    }

    public long getAverageDecodeTime(Context context) {
        return getAverageTime(context, name() + DECODE_FILE_SUFFIX);
    }

    public long getAverageEncodeTime(Context context) {
        return getAverageTime(context, name() + ENCODE_FILE_SUFFIX);
    }

    private long getAverageTime(Context context, String fileName) {
        long averageTime = NO_TIME_RECORDED;
        try {
            FileInputStream inputStream = context.openFileInput(fileName);
            StringBuilder fileContent = new StringBuilder();
            byte[] buffer = new byte[1024];
            int byteCount;
            while ((byteCount = inputStream.read(buffer)) != -1) {
                fileContent.append(new String(buffer, 0, byteCount));
            }
            inputStream.close();
            String fileContentString = fileContent.toString();
            if (fileContentString.contains("\n")) {
                String[] lines = fileContentString.split("\n");
                int count = lines.length;
                long sum = 0;
                for (String l : lines) {
                    sum += Long.valueOf(l);
                }
                return sum / count;
            } else if (fileContentString.length() > 0) {
                return Long.valueOf(fileContentString);
            }
        } catch (FileNotFoundException | NumberFormatException ignored) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        return averageTime;
    }

    public void recordDecodeTime(Context context, long time) {
        appendTime(context, DECODE_FILE_SUFFIX, time);
    }

    public void recordEncodeTime(Context context, long time) {
        appendTime(context, ENCODE_FILE_SUFFIX, time);
    }

    private void appendTime(Context context, String fileNameSuffix, long time) {
        try {
            FileOutputStream outputStream = context.openFileOutput(name() + fileNameSuffix, Context.MODE_APPEND);
            outputStream.write(String.valueOf(time).getBytes());
            outputStream.write('\n');
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hasStats(Context context) {
        return context.getFileStreamPath(name() + DECODE_FILE_SUFFIX).exists() ||
                context.getFileStreamPath(name() + ENCODE_FILE_SUFFIX).exists();
    }

    public boolean deleteStats(Context context) {
        File decodeStatsFile = context.getFileStreamPath(name() + DECODE_FILE_SUFFIX);
        File encodeStatsFile = context.getFileStreamPath(name() + ENCODE_FILE_SUFFIX);
        return (decodeStatsFile.exists() && decodeStatsFile.delete()) || (encodeStatsFile.exists() && encodeStatsFile.delete());
    }
}
