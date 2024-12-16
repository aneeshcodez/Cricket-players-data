package com.aneesh;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class PlayersResponse {
    @JsonProperty("data")
    private List<PlayerDto> data;

    public List<PlayerDto> getData() {
        return data;
    }

    public void setData(List<PlayerDto> data) {
        this.data = data;
    }
}
