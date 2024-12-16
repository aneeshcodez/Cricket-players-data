package com.aneesh.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CountriesResponse {
    @JsonProperty("data")
    private List<CountryDto> data;

    public List<CountryDto> getData() {
        return data;
    }

    public void setData(List<CountryDto> data) {
        this.data = data;
    }
}
