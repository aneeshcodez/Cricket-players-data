package com.aneesh.dtos;



import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Continentsresponse {
    @JsonProperty("data")
    private List<ContinentDto> continents;

    public List<ContinentDto> getContinents() {
        return continents;
    }

    public void setContinents(List<ContinentDto> continents) {
        this.continents = continents;
    }
}
