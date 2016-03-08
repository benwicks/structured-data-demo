# structured-data-demo
An Android application that demonstrates decoding/encoding data with XML, JSON, and protocol buffers.

# Download the sample Android app .apk
- Go [here](https://play.google.com/store/apps/details?id=com.benjaminwicks.structureddatademo) to download the demo app

# Presentation references
- Did you know that, [according to Google](https://developers.google.com/protocol-buffers/docs/overview#whynotxml), you can decrease the amount of data you send by 3-10x and increase parsing speeds by 20-100x, simply by changing the data format your app uses to transfer data?

# How-to generate protobuf model from .proto message
## Using Square's Wire library
- Checkout this source and open in as a new project in Android Studio
- Go to [the wire project on github](https://github.com/square/wire) and look at its README
- Download [the latest wire-compiler from maven.org](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.squareup.wire%22%20AND%20a%3A%22wire-compiler%22)
- Open a shell prompt and change to the structured-data-demo directory
- Run `java -jar ~/Downloads/wire-compiler-2.1.1-jar-with-dependencies.jar --proto_path=app/src/main/proto/benjaminwicks/structureddatademo/model/protobuf/wire/ --java_out=app/out_wire SpeciesList.proto` to generate a Java class from the .proto file (Resulting class was 623 lines)
- Copy the generated Java class from the out_wire directory to the matching directory within the project's java directory

## Using Google's protoc tool
- Download the latest source from [Google's download page](https://developers.google.com/protocol-buffers/docs/downloads)
- Unzip and look at the README. Follow the steps to install protoc
- Run `protoc --java_out=app/out_google -I=app/src/main/proto app/src/main/proto/benjaminwicks/structureddatademo/model/protobuf/google/SpeciesList.proto` to generate a Java class from the .proto file (Resulting class was 3581 lines)
- Or, follow [Google's Protobuf guidelines for Android](http://developer.android.com/training/articles/memory.html#NanoProto) and use the protoc gradle plugin to generate a "Nano" Java class (Resulting class was 442 lines)
- Copy the generated Java class from the out_google directory to the matching directory within the project's java directory
