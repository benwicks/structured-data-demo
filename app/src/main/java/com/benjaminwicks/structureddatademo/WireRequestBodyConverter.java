package com.benjaminwicks.structureddatademo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

final class WireRequestBodyConverter<T extends Message<T, ?>> implements Converter<T, RequestBody> {

    private static final MediaType MEDIA_TYPE = MediaType.parse("application/x-protobuf;" +
            " messageType=\"com.benjaminwicks.structureddatademo.model.SpeciesList\"");

    private final ProtoAdapter<T> adapter;

    WireRequestBodyConverter(ProtoAdapter<T> adapter) {
        this.adapter = adapter;
    }

    @Override public RequestBody convert(T value) throws IOException {
        Buffer buffer = new Buffer();
        adapter.encode(buffer, value);
        return RequestBody.create(MEDIA_TYPE, buffer.snapshot());
    }
}
