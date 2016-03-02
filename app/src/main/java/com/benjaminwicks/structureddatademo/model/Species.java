package com.benjaminwicks.structureddatademo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class Species {

    public final String kingdom;
    public final String parent;
    public final String family;
    public final String imageUrl;
    public final String lastInterpreted;
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
    public final String lastCrawled;

    @JsonCreator Species(
            @JsonProperty("kingdom") String kingdom,
            @JsonProperty("parent") String parent,
            @JsonProperty("family") String family,
            @JsonProperty("imageURL") String imageUrl,
            @JsonProperty("lastInterpreted") String lastInterpreted,
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
            @JsonProperty("lastCrawled") String lastCrawled
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
}
