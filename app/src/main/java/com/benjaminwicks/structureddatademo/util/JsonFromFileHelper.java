package com.benjaminwicks.structureddatademo.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build.VERSION_CODES;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.io.InputStream;

public final class JsonFromFileHelper {

    private JsonFromFileHelper() {
    }

    @TargetApi(VERSION_CODES.KITKAT) public static <T extends JsonNode> T loadJson(Context applicationContext, String jsonFilename) {
        try {
            AssetManager assetManager = applicationContext.getAssets();
            InputStream inputStream = assetManager.open(jsonFilename + ".json");
            //noinspection unchecked
            return (T) JacksonHelper.OBJECT_MAPPER.readTree(inputStream);
        } catch (IOException e) {
            throw new AssertionError("Invalid Json", e);
        }
    }
}
