package com.example.chiar.garbarino.model.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReviewContainer {
    @SerializedName("items")
    @Expose
    private List<ReviewBucket> items;

    private String query;


    public List<ReviewBucket> getItems() {
        return items;
    }

    public String getQuery() {
        return query;
    }
}
