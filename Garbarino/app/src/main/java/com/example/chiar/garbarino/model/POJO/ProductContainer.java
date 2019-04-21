package com.example.chiar.garbarino.model.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductContainer {
    @SerializedName("items")
    @Expose
    private List<Product> products;
    private String query;


    public List<Product> getProducts() {
        return products;
    }

    public String getQuery() {
        return query;
    }
}
