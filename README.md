# structured-data-demo
An Android application that demonstrates decoding/encoding data with XML, JSON, and protocol buffers.

I gave [a talk](https://docs.google.com/presentation/d/11c32YxERf5Dw4co_ViD1KQ3Ezyjt9Kr3UMKLRhZycX8/edit?usp=sharing) at the Omaha Google Developers' Group on "Decoding/Encoding Structured Data with Android"

# Download the sample Android app .apk
- Go [here](https://play.google.com/store/apps/details?id=com.benjaminwicks.structureddatademo) to download the demo app

# Presentation references
- [All about Protocol Buffers](https://developers.google.com/protocol-buffers/docs/overview)
- Did you know that, [according to Google](https://developers.google.com/protocol-buffers/docs/overview#whynotxml), you can decrease the amount of data you send by 3-10x and increase parsing speeds by 20-100x, simply by changing the data format your app uses to transfer data?
- ["Extending a Protocol Buffer"](https://developers.google.com/protocol-buffers/docs/cpptutorial#extending-a-protocol-buffer)
- [proto2 Language Guide](https://developers.google.com/protocol-buffers/docs/proto)
- [Encoding implementation details](https://developers.google.com/protocol-buffers/docs/encoding#structure)
- [Android's XML recommendation](http://developer.android.com/training/basics/network-ops/xml.html)
- [Square's Wire blog post](https://corner.squareup.com/2013/08/introducing-wire.html)

# For further reference
- [FlatBuffers](https://code.facebook.com/posts/872547912839369/improving-facebook-s-performance-on-android-with-flatbuffers/), another format [developed by Google](https://google.github.io/flatbuffers/) similar to protobufs that is intended for game development
- [Performance Patterns video](https://www.youtube.com/watch?v=IwxIIUypnTE) about protocol buffers on Android

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
  - See the output [here](https://github.com/benwicks/structured-data-demo/blob/f3ba90727562194e3f364e876568b4c55ef132a1/app/out_google/com/benjaminwicks/structureddatademo/model/protobuf/google/SpeciesListOuterClass.java)
- Or, follow [Google's Protobuf guidelines for Android](http://developer.android.com/training/articles/memory.html#NanoProto) and use the protoc gradle plugin to generate a "Nano" Java class (Resulting class was 442 lines)
  - See the output [here](https://github.com/benwicks/structured-data-demo/blob/master/app/src/main/java/com/benjaminwicks/structureddatademo/model/protobuf/google/nano/OuterGoogleSpeciesList.java)
- Copy the generated Java class from the out_google directory to the matching directory within the project's java directory
