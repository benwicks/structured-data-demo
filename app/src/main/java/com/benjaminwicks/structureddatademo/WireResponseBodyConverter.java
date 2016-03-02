package com.benjaminwicks.structureddatademo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

final class WireResponseBodyConverter<T extends Message<T, ?>>
        implements Converter<ResponseBody, T> {

    private final ProtoAdapter<T> adapter;

    WireResponseBodyConverter(ProtoAdapter<T> adapter) {
        this.adapter = adapter;
    }

    @Override public T convert(ResponseBody value) throws IOException {
        try {
            return adapter.decode(value.source());
        } finally {
            value.close();
        }
    }
}
