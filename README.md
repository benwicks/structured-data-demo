# structured-data-demo
An Android application that demonstrates decoding/encoding data with XML, JSON, and protocol buffers.

# Download the sample Android app .apk
- Go [here](https://play.google.com/store/apps/details?id=com.benjaminwicks.structureddatademo) to download the demo app

# How-to generate protobuf model from .proto message
## Using Square's Wire library
- Checkout this source and open in as a new project in Android Studio
- Go to [the wire project on github](https://github.com/square/wire) and look at its README
- Download [the latest wire-compiler from maven.org](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.squareup.wire%22%20AND%20a%3A%22wire-compiler%22)
- Open a shell prompt and change to the structured-data-demo directory
- Run `java -jar ~/Downloads/wire-compiler-2.1.1-jar-with-dependencies.jar --proto_path=app/src/main/proto/benjaminwicks/structureddatademo/model/protobuf/wire/ --java_out=app/out_wire SpeciesList.proto` to generate a Java class from the .proto file
- Copy the generated Java class from the out_wire directory to the matching directory within the project's java directory

## Using Google's protoc tool
- Download the latest source from [Google's download page](https://developers.google.com/protocol-buffers/docs/downloads)
- Unzip and look at the README. Follow the steps to install protoc
- Run `protoc --java_out=app/out_google -I=app/src/main/proto app/src/main/proto/benjaminwicks/structureddatademo/model/protobuf/google/SpeciesList.proto` to generate a Java class from the .proto file
- Copy the generated Java class from the out_google directory to the matching directory within the project's java directory
