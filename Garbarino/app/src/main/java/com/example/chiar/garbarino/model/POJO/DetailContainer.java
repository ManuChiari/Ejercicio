package com.example.chiar.garbarino.model.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailContainer {
    @SerializedName("resources")
    @Expose
    private DetailResources resources;
    private String query;


    public DetailResources getResources() {
        return resources;
    }

    public String getQuery() {
        return query;
    }
}
