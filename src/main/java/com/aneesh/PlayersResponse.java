package com.aneesh;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class PlayersResponse {
    @JsonProperty("data")
    private List<Playerpojo> data;

    public List<Playerpojo> getData() {
        return data;
    }

    public void setData(List<Playerpojo> data) {
        this.data = data;
    }
}
