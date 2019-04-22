package com.example.chiar.garbarino.model.DAO;

import com.example.chiar.garbarino.model.POJO.DetailContainer;
import com.example.chiar.garbarino.model.POJO.Product;
import com.example.chiar.garbarino.model.POJO.ProductContainer;
import com.example.chiar.garbarino.model.POJO.ReviewContainer;
import com.example.chiar.garbarino.utils.GarbarinoHelper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductService {
    @GET(GarbarinoHelper.PRODUCTO)
    public Call<ProductContainer> searchProduct();

    @GET (GarbarinoHelper.PRODUCTO_ID)
    public Call<DetailContainer> searchDetail(@Path("id") String id);

    @GET (GarbarinoHelper.PRODUCTO_ID_REVIEWS)
    public Call<ReviewContainer> searchReviews(@Path("id") String id);
}
