package com.example.chiar.garbarino.controller;

import com.example.chiar.garbarino.model.DAO.ProductDAO;
import com.example.chiar.garbarino.model.POJO.DetailContainer;
import com.example.chiar.garbarino.model.POJO.Product;
import com.example.chiar.garbarino.model.POJO.ProductContainer;
import com.example.chiar.garbarino.model.POJO.ReviewContainer;
import com.example.chiar.garbarino.utils.ResultListener;

public class ProductController {

    public void searchProducto (final ResultListener<ProductContainer> listenerView){
        ProductDAO productDAO = new ProductDAO();
        productDAO.searchProduct(new ResultListener<ProductContainer>() {
            @Override
            public void finish(ProductContainer result) {
                listenerView.finish(result);
            }
        });
    }

    public void searchDetalle (String id, final ResultListener<DetailContainer> listenerView){
        ProductDAO productDAO = new ProductDAO();
        productDAO.searchDetail(id, new ResultListener<DetailContainer>() {
            @Override
            public void finish(DetailContainer result) {
                listenerView.finish(result);
            }
        });
    }

    public void searchReviews (String id, final ResultListener<ReviewContainer> listenerView){
        ProductDAO productDAO = new ProductDAO();
        productDAO.searchReviews(id, new ResultListener<ReviewContainer>() {
            @Override
            public void finish(ReviewContainer result) {
                listenerView.finish(result);
            }
        });
    }
}
