package com.example.chiar.garbarino.model.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Detail implements Serializable {
    @SerializedName("max_width")
    @Expose
    private Integer max_width;
    @SerializedName("url")
    @Expose
    private String url;

    public Detail(Integer max_width, String url) {
        this.max_width = max_width;
        this.url = url;

    }

    public Integer getMaxwidth() {
        return max_width;
    }

    public String getUrl() {
        return url;
    }


    @Override
    public String toString() {
        return "Detail{" +
                "max_width'" + max_width + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}