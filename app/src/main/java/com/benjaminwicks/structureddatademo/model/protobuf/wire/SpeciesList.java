// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: SpeciesList.proto at 7:1
package com.benjaminwicks.structureddatademo.model.protobuf.wire;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

import java.io.IOException;
import java.util.List;

import okio.ByteString;

public final class SpeciesList extends Message<SpeciesList, SpeciesList.Builder> {
  public static final ProtoAdapter<SpeciesList> ADAPTER = new ProtoAdapter_SpeciesList();

  private static final long serialVersionUID = 0L;

  @WireField(
      tag = 1,
      adapter = "com.benjaminwicks.structureddatademo.model.protobuf.wire.SpeciesList$Species#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<Species> speciesList;

  public SpeciesList(List<Species> speciesList) {
    this(speciesList, ByteString.EMPTY);
  }

  public SpeciesList(List<Species> speciesList, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.speciesList = Internal.immutableCopyOf("speciesList", speciesList);
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.speciesList = Internal.copyOf("speciesList", speciesList);
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof SpeciesList)) return false;
    SpeciesList o = (SpeciesList) other;
    return Internal.equals(unknownFields(), o.unknownFields())
        && Internal.equals(speciesList, o.speciesList);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (speciesList != null ? speciesList.hashCode() : 1);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (speciesList != null) builder.append(", speciesList=").append(speciesList);
    return builder.replace(0, 2, "SpeciesList{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<SpeciesList, Builder> {
    public List<Species> speciesList;

    public Builder() {
      speciesList = Internal.newMutableList();
    }

    public Builder speciesList(List<Species> speciesList) {
      Internal.checkElementsNotNull(speciesList);
      this.speciesList = speciesList;
      return this;
    }

    @Override
    public SpeciesList build() {
      return new SpeciesList(speciesList, buildUnknownFields());
    }
  }

  public static final class Species extends Message<Species, Species.Builder> {
    public static final ProtoAdapter<Species> ADAPTER = new ProtoAdapter_Species();

    private static final long serialVersionUID = 0L;

    public static final String DEFAULT_KINGDOM = "";

    public static final String DEFAULT_PARENT = "";

    public static final String DEFAULT_FAMILY = "";

    public static final String DEFAULT_IMAGEURL = "";

    public static final String DEFAULT_LASTINTERPRETED = "";

    public static final String DEFAULT_ACCORDINGTO = "";

    public static final Integer DEFAULT_SPECIESKEY = 0;

    public static final String DEFAULT_CANONICALNAME = "";

    public static final String DEFAULT_THECLASS = "";

    public static final String DEFAULT_ORDER = "";

    public static final String DEFAULT_PHYLUM = "";

    public static final String DEFAULT_SCIENTIFICNAME = "";

    public static final String DEFAULT_AUTHORSHIP = "";

    public static final String DEFAULT_GENUS = "";

    public static final Integer DEFAULT_PARENTKEY = 0;

    public static final String DEFAULT_SPECIES = "";

    public static final String DEFAULT_LASTCRAWLED = "";

    @WireField(
        tag = 1,
        adapter = "com.squareup.wire.ProtoAdapter#STRING"
    )
    public final String kingdom;

    @WireField(
        tag = 2,
        adapter = "com.squareup.wire.ProtoAdapter#STRING"
    )
    public final String parent;

    @WireField(
        tag = 3,
        adapter = "com.squareup.wire.ProtoAdapter#STRING"
    )
    public final String family;

    @WireField(
        tag = 4,
        adapter = "com.squareup.wire.ProtoAdapter#STRING"
    )
    public final String imageURL;

    @WireField(
        tag = 5,
        adapter = "com.squareup.wire.ProtoAdapter#STRING"
    )
    public final String lastInterpreted;

    @WireField(
        tag = 6,
        adapter = "com.squareup.wire.ProtoAdapter#STRING"
    )
    public final String accordingTo;

    @WireField(
        tag = 7,
        adapter = "com.squareup.wire.ProtoAdapter#INT32"
    )
    public final Integer speciesKey;

    @WireField(
        tag = 8,
        adapter = "com.squareup.wire.ProtoAdapter#STRING"
    )
    public final String canonicalName;

    @WireField(
        tag = 9,
        adapter = "com.squareup.wire.ProtoAdapter#STRING"
    )
    public final String theClass;

    @WireField(
        tag = 10,
        adapter = "com.squareup.wire.ProtoAdapter#STRING"
    )
    public final String order;

    @WireField(
        tag = 11,
        adapter = "com.squareup.wire.ProtoAdapter#STRING"
    )
    public final String phylum;

    @WireField(
        tag = 12,
        adapter = "com.squareup.wire.ProtoAdapter#STRING"
    )
    public final String scientificName;

    @WireField(
        tag = 13,
        adapter = "com.squareup.wire.ProtoAdapter#STRING"
    )
    public final String authorship;

    @WireField(
        tag = 14,
        adapter = "com.squareup.wire.ProtoAdapter#STRING"
    )
    public final String genus;

    @WireField(
        tag = 15,
        adapter = "com.squareup.wire.ProtoAdapter#INT32"
    )
    public final Integer parentKey;

    @WireField(
        tag = 16,
        adapter = "com.squareup.wire.ProtoAdapter#STRING"
    )
    public final String species;

    @WireField(
        tag = 17,
        adapter = "com.squareup.wire.ProtoAdapter#STRING"
    )
    public final String lastCrawled;

    public Species(String kingdom, String parent, String family, String imageURL, String lastInterpreted, String accordingTo, Integer speciesKey, String canonicalName, String theClass, String order, String phylum, String scientificName, String authorship, String genus, Integer parentKey, String species, String lastCrawled) {
      this(kingdom, parent, family, imageURL, lastInterpreted, accordingTo, speciesKey, canonicalName, theClass, order, phylum, scientificName, authorship, genus, parentKey, species, lastCrawled, ByteString.EMPTY);
    }

    public Species(String kingdom, String parent, String family, String imageURL, String lastInterpreted, String accordingTo, Integer speciesKey, String canonicalName, String theClass, String order, String phylum, String scientificName, String authorship, String genus, Integer parentKey, String species, String lastCrawled, ByteString unknownFields) {
      super(ADAPTER, unknownFields);
      this.kingdom = kingdom;
      this.parent = parent;
      this.family = family;
      this.imageURL = imageURL;
      this.lastInterpreted = lastInterpreted;
      this.accordingTo = accordingTo;
      this.speciesKey = speciesKey;
      this.canonicalName = canonicalName;
      this.theClass = theClass;
      this.order = order;
      this.phylum = phylum;
      this.scientificName = scientificName;
      this.authorship = authorship;
      this.genus = genus;
      this.parentKey = parentKey;
      this.species = species;
      this.lastCrawled = lastCrawled;
    }

    @Override
    public Builder newBuilder() {
      Builder builder = new Builder();
      builder.kingdom = kingdom;
      builder.parent = parent;
      builder.family = family;
      builder.imageURL = imageURL;
      builder.lastInterpreted = lastInterpreted;
      builder.accordingTo = accordingTo;
      builder.speciesKey = speciesKey;
      builder.canonicalName = canonicalName;
      builder.theClass = theClass;
      builder.order = order;
      builder.phylum = phylum;
      builder.scientificName = scientificName;
      builder.authorship = authorship;
      builder.genus = genus;
      builder.parentKey = parentKey;
      builder.species = species;
      builder.lastCrawled = lastCrawled;
      builder.addUnknownFields(unknownFields());
      return builder;
    }

    @Override
    public boolean equals(Object other) {
      if (other == this) return true;
      if (!(other instanceof Species)) return false;
      Species o = (Species) other;
      return Internal.equals(unknownFields(), o.unknownFields())
          && Internal.equals(kingdom, o.kingdom)
          && Internal.equals(parent, o.parent)
          && Internal.equals(family, o.family)
          && Internal.equals(imageURL, o.imageURL)
          && Internal.equals(lastInterpreted, o.lastInterpreted)
          && Internal.equals(accordingTo, o.accordingTo)
          && Internal.equals(speciesKey, o.speciesKey)
          && Internal.equals(canonicalName, o.canonicalName)
          && Internal.equals(theClass, o.theClass)
          && Internal.equals(order, o.order)
          && Internal.equals(phylum, o.phylum)
          && Internal.equals(scientificName, o.scientificName)
          && Internal.equals(authorship, o.authorship)
          && Internal.equals(genus, o.genus)
          && Internal.equals(parentKey, o.parentKey)
          && Internal.equals(species, o.species)
          && Internal.equals(lastCrawled, o.lastCrawled);
    }

    @Override
    public int hashCode() {
      int result = super.hashCode;
      if (result == 0) {
        result = unknownFields().hashCode();
        result = result * 37 + (kingdom != null ? kingdom.hashCode() : 0);
        result = result * 37 + (parent != null ? parent.hashCode() : 0);
        result = result * 37 + (family != null ? family.hashCode() : 0);
        result = result * 37 + (imageURL != null ? imageURL.hashCode() : 0);
        result = result * 37 + (lastInterpreted != null ? lastInterpreted.hashCode() : 0);
        result = result * 37 + (accordingTo != null ? accordingTo.hashCode() : 0);
        result = result * 37 + (speciesKey != null ? speciesKey.hashCode() : 0);
        result = result * 37 + (canonicalName != null ? canonicalName.hashCode() : 0);
        result = result * 37 + (theClass != null ? theClass.hashCode() : 0);
        result = result * 37 + (order != null ? order.hashCode() : 0);
        result = result * 37 + (phylum != null ? phylum.hashCode() : 0);
        result = result * 37 + (scientificName != null ? scientificName.hashCode() : 0);
        result = result * 37 + (authorship != null ? authorship.hashCode() : 0);
        result = result * 37 + (genus != null ? genus.hashCode() : 0);
        result = result * 37 + (parentKey != null ? parentKey.hashCode() : 0);
        result = result * 37 + (species != null ? species.hashCode() : 0);
        result = result * 37 + (lastCrawled != null ? lastCrawled.hashCode() : 0);
        super.hashCode = result;
      }
      return result;
    }

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
      if (kingdom != null) builder.append(", kingdom=").append(kingdom);
      if (parent != null) builder.append(", parent=").append(parent);
      if (family != null) builder.append(", family=").append(family);
      if (imageURL != null) builder.append(", imageURL=").append(imageURL);
      if (lastInterpreted != null) builder.append(", lastInterpreted=").append(lastInterpreted);
      if (accordingTo != null) builder.append(", accordingTo=").append(accordingTo);
      if (speciesKey != null) builder.append(", speciesKey=").append(speciesKey);
      if (canonicalName != null) builder.append(", canonicalName=").append(canonicalName);
      if (theClass != null) builder.append(", theClass=").append(theClass);
      if (order != null) builder.append(", order=").append(order);
      if (phylum != null) builder.append(", phylum=").append(phylum);
      if (scientificName != null) builder.append(", scientificName=").append(scientificName);
      if (authorship != null) builder.append(", authorship=").append(authorship);
      if (genus != null) builder.append(", genus=").append(genus);
      if (parentKey != null) builder.append(", parentKey=").append(parentKey);
      if (species != null) builder.append(", species=").append(species);
      if (lastCrawled != null) builder.append(", lastCrawled=").append(lastCrawled);
      return builder.replace(0, 2, "Species{").append('}').toString();
    }

    public static final class Builder extends Message.Builder<Species, Builder> {
      public String kingdom;

      public String parent;

      public String family;

      public String imageURL;

      public String lastInterpreted;

      public String accordingTo;

      public Integer speciesKey;

      public String canonicalName;

      public String theClass;

      public String order;

      public String phylum;

      public String scientificName;

      public String authorship;

      public String genus;

      public Integer parentKey;

      public String species;

      public String lastCrawled;

      public Builder() {
      }

      public Builder kingdom(String kingdom) {
        this.kingdom = kingdom;
        return this;
      }

      public Builder parent(String parent) {
        this.parent = parent;
        return this;
      }

      public Builder family(String family) {
        this.family = family;
        return this;
      }

      public Builder imageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
      }

      public Builder lastInterpreted(String lastInterpreted) {
        this.lastInterpreted = lastInterpreted;
        return this;
      }

      public Builder accordingTo(String accordingTo) {
        this.accordingTo = accordingTo;
        return this;
      }

      public Builder speciesKey(Integer speciesKey) {
        this.speciesKey = speciesKey;
        return this;
      }

      public Builder canonicalName(String canonicalName) {
        this.canonicalName = canonicalName;
        return this;
      }

      public Builder theClass(String theClass) {
        this.theClass = theClass;
        return this;
      }

      public Builder order(String order) {
        this.order = order;
        return this;
      }

      public Builder phylum(String phylum) {
        this.phylum = phylum;
        return this;
      }

      public Builder scientificName(String scientificName) {
        this.scientificName = scientificName;
        return this;
      }

      public Builder authorship(String authorship) {
        this.authorship = authorship;
        return this;
      }

      public Builder genus(String genus) {
        this.genus = genus;
        return this;
      }

      public Builder parentKey(Integer parentKey) {
        this.parentKey = parentKey;
        return this;
      }

      public Builder species(String species) {
        this.species = species;
        return this;
      }

      public Builder lastCrawled(String lastCrawled) {
        this.lastCrawled = lastCrawled;
        return this;
      }

      @Override
      public Species build() {
        return new Species(kingdom, parent, family, imageURL, lastInterpreted, accordingTo, speciesKey, canonicalName, theClass, order, phylum, scientificName, authorship, genus, parentKey, species, lastCrawled, buildUnknownFields());
      }
    }

    private static final class ProtoAdapter_Species extends ProtoAdapter<Species> {
      ProtoAdapter_Species() {
        super(FieldEncoding.LENGTH_DELIMITED, Species.class);
      }

      @Override
      public int encodedSize(Species value) {
        return (value.kingdom != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value.kingdom) : 0)
            + (value.parent != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, value.parent) : 0)
            + (value.family != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, value.family) : 0)
            + (value.imageURL != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, value.imageURL) : 0)
            + (value.lastInterpreted != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, value.lastInterpreted) : 0)
            + (value.accordingTo != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, value.accordingTo) : 0)
            + (value.speciesKey != null ? ProtoAdapter.INT32.encodedSizeWithTag(7, value.speciesKey) : 0)
            + (value.canonicalName != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, value.canonicalName) : 0)
            + (value.theClass != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, value.theClass) : 0)
            + (value.order != null ? ProtoAdapter.STRING.encodedSizeWithTag(10, value.order) : 0)
            + (value.phylum != null ? ProtoAdapter.STRING.encodedSizeWithTag(11, value.phylum) : 0)
            + (value.scientificName != null ? ProtoAdapter.STRING.encodedSizeWithTag(12, value.scientificName) : 0)
            + (value.authorship != null ? ProtoAdapter.STRING.encodedSizeWithTag(13, value.authorship) : 0)
            + (value.genus != null ? ProtoAdapter.STRING.encodedSizeWithTag(14, value.genus) : 0)
            + (value.parentKey != null ? ProtoAdapter.INT32.encodedSizeWithTag(15, value.parentKey) : 0)
            + (value.species != null ? ProtoAdapter.STRING.encodedSizeWithTag(16, value.species) : 0)
            + (value.lastCrawled != null ? ProtoAdapter.STRING.encodedSizeWithTag(17, value.lastCrawled) : 0)
            + value.unknownFields().size();
      }

      @Override
      public void encode(ProtoWriter writer, Species value) throws IOException {
        if (value.kingdom != null) ProtoAdapter.STRING.encodeWithTag(writer, 1, value.kingdom);
        if (value.parent != null) ProtoAdapter.STRING.encodeWithTag(writer, 2, value.parent);
        if (value.family != null) ProtoAdapter.STRING.encodeWithTag(writer, 3, value.family);
        if (value.imageURL != null) ProtoAdapter.STRING.encodeWithTag(writer, 4, value.imageURL);
        if (value.lastInterpreted != null) ProtoAdapter.STRING.encodeWithTag(writer, 5, value.lastInterpreted);
        if (value.accordingTo != null) ProtoAdapter.STRING.encodeWithTag(writer, 6, value.accordingTo);
        if (value.speciesKey != null) ProtoAdapter.INT32.encodeWithTag(writer, 7, value.speciesKey);
        if (value.canonicalName != null) ProtoAdapter.STRING.encodeWithTag(writer, 8, value.canonicalName);
        if (value.theClass != null) ProtoAdapter.STRING.encodeWithTag(writer, 9, value.theClass);
        if (value.order != null) ProtoAdapter.STRING.encodeWithTag(writer, 10, value.order);
        if (value.phylum != null) ProtoAdapter.STRING.encodeWithTag(writer, 11, value.phylum);
        if (value.scientificName != null) ProtoAdapter.STRING.encodeWithTag(writer, 12, value.scientificName);
        if (value.authorship != null) ProtoAdapter.STRING.encodeWithTag(writer, 13, value.authorship);
        if (value.genus != null) ProtoAdapter.STRING.encodeWithTag(writer, 14, value.genus);
        if (value.parentKey != null) ProtoAdapter.INT32.encodeWithTag(writer, 15, value.parentKey);
        if (value.species != null) ProtoAdapter.STRING.encodeWithTag(writer, 16, value.species);
        if (value.lastCrawled != null) ProtoAdapter.STRING.encodeWithTag(writer, 17, value.lastCrawled);
        writer.writeBytes(value.unknownFields());
      }

      @Override
      public Species decode(ProtoReader reader) throws IOException {
        Builder builder = new Builder();
        long token = reader.beginMessage();
        for (int tag; (tag = reader.nextTag()) != -1;) {
          switch (tag) {
            case 1: builder.kingdom(ProtoAdapter.STRING.decode(reader)); break;
            case 2: builder.parent(ProtoAdapter.STRING.decode(reader)); break;
            case 3: builder.family(ProtoAdapter.STRING.decode(reader)); break;
            case 4: builder.imageURL(ProtoAdapter.STRING.decode(reader)); break;
            case 5: builder.lastInterpreted(ProtoAdapter.STRING.decode(reader)); break;
            case 6: builder.accordingTo(ProtoAdapter.STRING.decode(reader)); break;
            case 7: builder.speciesKey(ProtoAdapter.INT32.decode(reader)); break;
            case 8: builder.canonicalName(ProtoAdapter.STRING.decode(reader)); break;
            case 9: builder.theClass(ProtoAdapter.STRING.decode(reader)); break;
            case 10: builder.order(ProtoAdapter.STRING.decode(reader)); break;
            case 11: builder.phylum(ProtoAdapter.STRING.decode(reader)); break;
            case 12: builder.scientificName(ProtoAdapter.STRING.decode(reader)); break;
            case 13: builder.authorship(ProtoAdapter.STRING.decode(reader)); break;
            case 14: builder.genus(ProtoAdapter.STRING.decode(reader)); break;
            case 15: builder.parentKey(ProtoAdapter.INT32.decode(reader)); break;
            case 16: builder.species(ProtoAdapter.STRING.decode(reader)); break;
            case 17: builder.lastCrawled(ProtoAdapter.STRING.decode(reader)); break;
            default: {
              FieldEncoding fieldEncoding = reader.peekFieldEncoding();
              Object value = fieldEncoding.rawProtoAdapter().decode(reader);
              builder.addUnknownField(tag, fieldEncoding, value);
            }
          }
        }
        reader.endMessage(token);
        return builder.build();
      }

      @Override
      public Species redact(Species value) {
        Builder builder = value.newBuilder();
        builder.clearUnknownFields();
        return builder.build();
      }
    }
  }

  private static final class ProtoAdapter_SpeciesList extends ProtoAdapter<SpeciesList> {
    ProtoAdapter_SpeciesList() {
      super(FieldEncoding.LENGTH_DELIMITED, SpeciesList.class);
    }

    @Override
    public int encodedSize(SpeciesList value) {
      return Species.ADAPTER.asRepeated().encodedSizeWithTag(1, value.speciesList)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, SpeciesList value) throws IOException {
      if (value.speciesList != null) Species.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.speciesList);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public SpeciesList decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.speciesList.add(Species.ADAPTER.decode(reader)); break;
          default: {
            FieldEncoding fieldEncoding = reader.peekFieldEncoding();
            Object value = fieldEncoding.rawProtoAdapter().decode(reader);
            builder.addUnknownField(tag, fieldEncoding, value);
          }
        }
      }
      reader.endMessage(token);
      return builder.build();
    }

    @Override
    public SpeciesList redact(SpeciesList value) {
      Builder builder = value.newBuilder();
      Internal.redactElements(builder.speciesList, Species.ADAPTER);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
