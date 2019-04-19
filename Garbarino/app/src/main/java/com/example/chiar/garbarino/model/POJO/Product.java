package com.example.chiar.garbarino.model.POJO;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    private String id;
    private String description;
    private String price;
    private String list_price;
    private Integer discount;
    private String image_url;
    private List<Product> data;

    public Product(String id, String description, String price, String list_price, Integer discount, String image_url, List<Product> data) {
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

    public String getPrice() {
        return price;
    }

    public String getList_price() {
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
