package com.aneesh;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CountriesResponse {
    @JsonProperty("data")
    private List<Countrypojo> data;

    public List<Countrypojo> getData() {
        return data;
    }

    public void setData(List<Countrypojo> data) {
        this.data = data;
    }
}
