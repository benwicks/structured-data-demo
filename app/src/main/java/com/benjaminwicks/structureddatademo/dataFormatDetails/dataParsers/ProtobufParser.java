package com.benjaminwicks.structureddatademo.dataFormatDetails.dataParsers;

import com.benjaminwicks.structureddatademo.model.Species;
import com.benjaminwicks.structureddatademo.model.protobuf.google.OuterGoogleSpeciesList;
import com.benjaminwicks.structureddatademo.model.protobuf.google.OuterGoogleSpeciesList.SpeciesList;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public final class ProtobufParser implements DataParser {

    private int byteArraySize;

    @Override public byte[] encode(List<Species> speciesList) throws IOException {
        OuterGoogleSpeciesList.SpeciesList.Species[] googleSpeciesList =
                new OuterGoogleSpeciesList.SpeciesList.Species[speciesList.size()];
        for (int i = 0, max = speciesList.size(); i < max; i++) {
            Species s = speciesList.get(i);
            googleSpeciesList[i] = s.toGoogleSpecies();
        }
        OuterGoogleSpeciesList.SpeciesList result = new OuterGoogleSpeciesList.SpeciesList();
        result.speciesList = googleSpeciesList;
        byte[] flatArray = new byte[byteArraySize];
        result.writeTo(CodedOutputByteBufferNano.newInstance(flatArray));
        return flatArray;
    }

    @Override public List<Species> decode(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            byte[] b = new byte[4096];
            int n;
            while ((n = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, n);
            }
            byte[] buf = outputStream.toByteArray();
            byteArraySize = buf.length;
            CodedInputByteBufferNano input = CodedInputByteBufferNano.newInstance(buf);
            OuterGoogleSpeciesList.SpeciesList.Species[] googleSpeciesList = SpeciesList.parseFrom(input).speciesList;
            List<Species> speciesList = new ArrayList<>(googleSpeciesList.length);
            for (OuterGoogleSpeciesList.SpeciesList.Species s : googleSpeciesList) {
                speciesList.add(Species.fromGoogleSpecies(s));
            }
            return speciesList;
        } catch (ParseException e) {
            throw new Error("Invalid date format", e);
        } finally {
            outputStream.close();
        }
    }
}
