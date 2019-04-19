package com.example.chiar.garbarino.model.DAO;

import com.example.chiar.garbarino.model.POJO.Product;
import com.example.chiar.garbarino.model.POJO.ProductContainer;
import com.example.chiar.garbarino.utils.GarbarinoHelper;
import com.example.chiar.garbarino.utils.ResultListener;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDAO extends MyRetrofit{
    public ProductService service;
    public ProductDAO() {
        super(GarbarinoHelper.URL_BASE);
        service = retrofit.create(ProductService.class);
    }

    public void searchProduct( final ResultListener<ProductContainer> listener){
        Call<ProductContainer> call = service.searchProduct();
        call.enqueue(new Callback<ProductContainer>() {
            @Override
            public void onResponse(Call<ProductContainer> call, Response<ProductContainer> response) {
                listener.finish(response.body());
            }

            @Override
            public void onFailure(Call<ProductContainer> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    public void searchDetail(String id, final ResultListener<Product> listenerController){
        Call<Product> call = service.searchDetail(id);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                listenerController.finish(response.body());
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });
    }

    public void searchReviews (String id, final ResultListener<Product> listenerController ) {
        Call<Product> call = service.searchReviews(id);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                listenerController.finish(response.body());
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });
    }

}
