package com.example.chiar.garbarino.model.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Review implements Serializable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("usernickname")
    @Expose
    private String usernickname;
    @SerializedName("rating")
    @Expose
    private Float rating;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("review_text")
    @Expose
    private String review_text;

    public Review(String id, String usernickname, Float rating, String title, String review_text) {
        this.id = id;
        this.usernickname = usernickname;
        this.rating = rating;
        this.title = title;
        this.review_text = review_text;

    }


    public String getId() {
        return id;
    }

    public String getUsernickname() {
        return usernickname;
    }

    public String getTitle() {
        return  title;
    }

    public String getReviewTYext() {
        return  review_text;
    }

    public Float getRating() { return rating; }


    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", usernickname='" + usernickname + '\'' +
                ", title=" + title +
                ", review_text=" + review_text +
                ", rating=" + rating +
                '}';
    }
}
