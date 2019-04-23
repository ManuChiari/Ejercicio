package com.example.chiar.garbarino.model.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReviewBucket {
    @SerializedName("reviews")
    @Expose
    private List<Review> reviews;
    @SerializedName("average_overal_rating")
    @Expose
    private String average_overal_rating;
    private String query;


    public List<Review> getReviews() {
        return reviews;
    }

    public String getQuery() {
        return query;
    }

    public String getAverage_overal_rating() {
        return average_overal_rating;
    }
}
