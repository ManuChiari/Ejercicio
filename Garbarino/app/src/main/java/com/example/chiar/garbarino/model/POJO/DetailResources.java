package com.example.chiar.garbarino.model.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailResources {
    @SerializedName("images")
    @Expose
    private List<Detail> images;
    private String query;


    public List<Detail> getImages() {
        return images;
    }

    public String getQuery() {
        return query;
    }
}
