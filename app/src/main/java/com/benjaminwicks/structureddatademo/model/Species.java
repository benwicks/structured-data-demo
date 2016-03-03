package com.benjaminwicks.structureddatademo.model;

import com.benjaminwicks.structureddatademo.model.protobuf.wire.SpeciesList;
import com.benjaminwicks.structureddatademo.model.protobuf.wire.SpeciesList.Species.Builder;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class Species {

    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);

    public final String kingdom;
    public final String parent;
    public final String family;
    public final String imageUrl;
    public final Date lastInterpreted;
    public final String accordingTo;
    public final int speciesKey;
    public final String canonicalName;
    public final String theClass;
    public final String order;
    public final String phylum;
    public final String scientificName;
    public final String authorship;
    public final String genus;
    public final int parentKey;
    public final String species;
    public final Date lastCrawled;

    @JsonCreator Species(
            @JsonProperty("kingdom") String kingdom,
            @JsonProperty("parent") String parent,
            @JsonProperty("family") String family,
            @JsonProperty("imageURL") String imageUrl,
            @JsonProperty("lastInterpreted") Date lastInterpreted,
            @JsonProperty("accordingTo") String accordingTo,
            @JsonProperty("speciesKey") int speciesKey,
            @JsonProperty("canonicalName") String canonicalName,
            @JsonProperty("class") String theClass,
            @JsonProperty("order") String order,
            @JsonProperty("phylum") String phylum,
            @JsonProperty("scientificName") String scientificName,
            @JsonProperty("authorship") String authorship,
            @JsonProperty("genus") String genus,
            @JsonProperty("parentKey") int parentKey,
            @JsonProperty("species") String species,
            @JsonProperty("lastCrawled") Date lastCrawled
    ) {
        this.kingdom = kingdom;
        this.parent = parent;
        this.family = family;
        this.imageUrl = imageUrl;
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

    public static Species fromWireSpecies(SpeciesList.Species s) throws ParseException {
        return new Species(
                s.kingdom,
                s.parent,
                s.family,
                s.imageURL,
                DATE_FORMAT.parse(s.lastInterpreted),
                s.accordingTo,
                s.speciesKey,
                s.canonicalName,
                s.theClass,
                s.order,
                s.phylum,
                s.scientificName,
                s.authorship,
                s.genus,
                s.parentKey,
                s.species,
                DATE_FORMAT.parse(s.lastCrawled)
        );
    }

    public SpeciesList.Species toWireSpecies() {
        return new Builder()
                .kingdom(kingdom)
                .parent(parent)
                .family(family)
                .imageURL(imageUrl)
                .lastInterpreted(DATE_FORMAT.format(lastInterpreted))
                .accordingTo(accordingTo)
                .speciesKey(speciesKey)
                .canonicalName(canonicalName)
                .theClass(theClass)
                .order(order)
                .phylum(phylum)
                .scientificName(scientificName)
                .authorship(authorship)
                .genus(genus)
                .parentKey(parentKey)
                .species(species)
                .lastCrawled(DATE_FORMAT.format(lastCrawled))
                .build();
    }
}
