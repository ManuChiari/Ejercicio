package com.example.chiar.garbarino.model.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("list_price")
    @Expose
    private Integer list_price;
    @SerializedName("discount")
    @Expose
    private Integer discount;
    @SerializedName("image_url")
    @Expose
    private String image_url;
    @SerializedName("data")
    @Expose
    private List<Product> data;

    public Product(String id, String description, Integer price, Integer list_price, Integer discount, String image_url, List<Product> data) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.list_price = list_price;
        this.discount = discount;
        this.image_url = image_url;
        this.data = data;
    }

    public List<Product> getData() {
        return data;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getList_price() {
        return list_price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public String getImage_url() {
        return image_url;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", list_price=" + list_price +
                ", discount=" + discount +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}

