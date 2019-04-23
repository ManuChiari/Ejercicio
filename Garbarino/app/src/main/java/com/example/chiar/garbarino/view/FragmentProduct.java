package com.example.chiar.garbarino.view;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.example.chiar.garbarino.R;
import com.example.chiar.garbarino.controller.ProductController;
import com.example.chiar.garbarino.model.POJO.Product;
import com.example.chiar.garbarino.model.POJO.ProductContainer;
import com.example.chiar.garbarino.model.POJO.ReviewContainer;
import com.example.chiar.garbarino.utils.ResultListener;


public class FragmentProduct extends Fragment implements ProductAdapter.ListenerAdapterProductos {

    private ListenerFragmentProducto listenerFragmentProducto;
    private ProductAdapter productAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        RecyclerView recyclerViewProductos = view.findViewById(R.id.recyclerProductos);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerViewProductos.setLayoutManager(gridLayoutManager);
        productAdapter = new ProductAdapter(this);
        recyclerViewProductos.setAdapter(productAdapter);
        loadProduct();


        return view;
    }

    public void loadProduct(){

        ProductController productController = new ProductController();
        productController.searchProducto(new ResultListener<ProductContainer>() {
            @Override
            public void finish(ProductContainer result) {
                productAdapter.setProducts(result.getProducts());
            }
        });
    }

//    public void loadRaiting(String id, Activity a){
////        ProductController productController = new ProductController();
////        final Activity ctx = a;
////        productController.searchReviews(id, new ResultListener<ReviewContainer>() {
////            @Override
////            public void finish(ReviewContainer result) {
////                RatingBar ratingBar = new RatingBar(ctx);
////
////            }
////        });
////    }


    @Override
    public void productoSeleccionado(Product productSeleccionado) {
        listenerFragmentProducto.informarProductoSeleccionado(productSeleccionado);
    }

    public interface ListenerFragmentProducto {
        public void informarProductoSeleccionado(Product productSeleccionado);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listenerFragmentProducto = (ListenerFragmentProducto)context;
    }
}
