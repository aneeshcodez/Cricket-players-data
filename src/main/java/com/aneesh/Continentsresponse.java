package com.aneesh;



import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Continentsresponse {
    @JsonProperty("data")
    private List<Continentpojo> continents;

    public List<Continentpojo> getContinents() {
        return continents;
    }

    public void setContinents(List<Continentpojo> continents) {
        this.continents = continents;
    }
}
