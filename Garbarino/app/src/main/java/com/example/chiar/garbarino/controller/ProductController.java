package com.example.chiar.garbarino.controller;

import com.example.chiar.garbarino.model.DAO.ProductDAO;
import com.example.chiar.garbarino.model.POJO.Product;
import com.example.chiar.garbarino.model.POJO.ProductContainer;
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

    public void searchDetalle (String id, final ResultListener<Product> listenerView){
        ProductDAO productDAO = new ProductDAO();
        productDAO.searchDetail(id, new ResultListener<Product>() {
            @Override
            public void finish(Product result) {
                listenerView.finish(result);
            }
        });
    }

    public void searchReviews (String id, final ResultListener<Product> listenerView){
        ProductDAO productDAO = new ProductDAO();
        productDAO.searchReviews(id, new ResultListener<Product>() {
            @Override
            public void finish(Product result) {
                listenerView.finish(result);
            }
        });
    }
}
