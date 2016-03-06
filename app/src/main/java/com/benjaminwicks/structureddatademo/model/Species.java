package com.benjaminwicks.structureddatademo.model;

import com.benjaminwicks.structureddatademo.model.protobuf.google.SpeciesListOuterClass;
import com.benjaminwicks.structureddatademo.model.protobuf.wire.SpeciesList;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class Species {

    public static final String ITEM_TAG = "item";
    public static final String KINGDOM_TAG = "kingdom";
    public static final String PARENT_TAG = "parent";
    public static final String FAMILY_TAG = "family";
    public static final String IMAGE_URL_TAG = "imageURL";
    public static final String LAST_INTERPRETED_TAG = "lastInterpreted";
    public static final String ACCORDING_TO_TAG = "accordingTo";
    public static final String SPECIES_KEY_TAG = "speciesKey";
    public static final String CANONICAL_NAME_TAG = "canonicalName";
    public static final String ORDER_TAG = "order";
    public static final String PHYLUM_TAG = "phylum";
    public static final String SCIENTIFIC_NAME_TAG = "scientificName";
    public static final String SPECIES_TAG = "species";
    public static final String AUTHORSHIP_TAG = "authorship";
    public static final String GENUS_TAG = "genus";
    public static final String PARENT_KEY_TAG = "parentKey";
    public static final String CLASS_TAG = "class";
    public static final String LAST_CRAWLED_TAG = "lastCrawled";

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);

    public final String kingdom;
    public final String parent;
    public final String family;
    @SerializedName("imageURL")
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

    public static Species fromGoogleSpecies(SpeciesListOuterClass.SpeciesList.Species s) throws ParseException {
        return new Species(
                s.getKingdom(),
                s.getParent(),
                s.getFamily(),
                s.getImageURL(),
                DATE_FORMAT.parse(s.getLastInterpreted()),
                s.getAccordingTo(),
                s.getSpeciesKey(),
                s.getCanonicalName(),
                s.getTheClass(),
                s.getOrder(),
                s.getPhylum(),
                s.getScientificName(),
                s.getAuthorship(),
                s.getGenus(),
                s.getParentKey(),
                s.getSpecies(),
                DATE_FORMAT.parse(s.getLastCrawled())
        );
    }

    public SpeciesList.Species toWireSpecies() {
        return new SpeciesList.Species.Builder()
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

    public SpeciesListOuterClass.SpeciesList.Species toGoogleSpecies() {
        return SpeciesListOuterClass.SpeciesList.Species.newBuilder()
                                                        .setKingdom(kingdom)
                                                        .setParent(parent)
                                                        .setFamily(family)
                                                        .setImageURL(imageUrl)
                                                        .setLastInterpreted(DATE_FORMAT.format(lastInterpreted))
                                                        .setAccordingTo(accordingTo)
                                                        .setSpeciesKey(speciesKey)
                                                        .setCanonicalName(canonicalName)
                                                        .setTheClass(theClass)
                                                        .setOrder(order)
                                                        .setPhylum(phylum)
                                                        .setScientificName(scientificName)
                                                        .setAuthorship(authorship)
                                                        .setGenus(genus)
                                                        .setParentKey(parentKey)
                                                        .setSpecies(species)
                                                        .setLastCrawled(DATE_FORMAT.format(lastCrawled))
                                                        .build();
    }

    public static final class Builder {

        private String kingdom;
        private String parent;
        private String family;
        private String imageUrl;
        private Date lastInterpreted;
        private String accordingTo;
        private int speciesKey;
        private String canonicalName;
        private String theClass;
        private String order;
        private String phylum;
        private String scientificName;
        private String authorship;
        private String genus;
        private int parentKey;
        private String species;
        private Date lastCrawled;

        public void setKingdom(String kingdom) {
            this.kingdom = kingdom;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public void setFamily(String family) {
            this.family = family;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public void setLastInterpreted(Date lastInterpreted) {
            this.lastInterpreted = lastInterpreted;
        }

        public void setAccordingTo(String accordingTo) {
            this.accordingTo = accordingTo;
        }

        public void setSpeciesKey(int speciesKey) {
            this.speciesKey = speciesKey;
        }

        public void setCanonicalName(String canonicalName) {
            this.canonicalName = canonicalName;
        }

        public void setTheClass(String theClass) {
            this.theClass = theClass;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public void setPhylum(String phylum) {
            this.phylum = phylum;
        }

        public void setScientificName(String scientificName) {
            this.scientificName = scientificName;
        }

        public void setAuthorship(String authorship) {
            this.authorship = authorship;
        }

        public void setGenus(String genus) {
            this.genus = genus;
        }

        public void setParentKey(int parentKey) {
            this.parentKey = parentKey;
        }

        public void setSpecies(String species) {
            this.species = species;
        }

        public void setLastCrawled(Date lastCrawled) {
            this.lastCrawled = lastCrawled;
        }

        public Species build() {
            return new Species(
                    kingdom,
                    parent,
                    family,
                    imageUrl,
                    lastInterpreted,
                    accordingTo,
                    speciesKey,
                    canonicalName,
                    theClass,
                    order,
                    phylum,
                    scientificName,
                    authorship,
                    genus,
                    parentKey,
                    species,
                    lastCrawled
            );
        }
    }
}
