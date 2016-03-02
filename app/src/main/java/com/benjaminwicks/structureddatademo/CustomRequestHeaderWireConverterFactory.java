package com.benjaminwicks.structureddatademo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

final class CustomRequestHeaderWireConverterFactory extends Converter.Factory {

    static CustomRequestHeaderWireConverterFactory create() {
        return new CustomRequestHeaderWireConverterFactory();
    }

    private CustomRequestHeaderWireConverterFactory() {
    }

    @Override public Converter<ResponseBody, ?> responseBodyConverter(
            Type type,
            Annotation[] annotations,
            Retrofit retrofit
    ) {
        if (!(type instanceof Class<?>)) {
            return null;
        }
        Class<?> c = (Class<?>) type;
        if (!Message.class.isAssignableFrom(c)) {
            return null;
        }
        //noinspection unchecked
        ProtoAdapter<? extends Message> adapter = ProtoAdapter.get((Class<? extends Message>) c);
        return new WireResponseBodyConverter<>(adapter);
    }

    @Override public Converter<?, RequestBody> requestBodyConverter(
            Type type,
            Annotation[] parameterAnnotations,
            Annotation[] methodAnnotations,
            Retrofit retrofit
    ) {
        if (!(type instanceof Class<?>)) {
            return null;
        }
        Class<?> c = (Class<?>) type;
        if (!Message.class.isAssignableFrom(c)) {
            return null;
        }
        //noinspection unchecked
        ProtoAdapter<? extends Message> adapter = ProtoAdapter.get((Class<? extends Message>) c);
        return new WireRequestBodyConverter<>(adapter);
    }
}
