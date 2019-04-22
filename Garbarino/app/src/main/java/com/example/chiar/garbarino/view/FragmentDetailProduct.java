package com.example.chiar.garbarino.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.chiar.garbarino.R;
import com.example.chiar.garbarino.controller.ProductController;
import com.example.chiar.garbarino.model.POJO.Detail;
import com.example.chiar.garbarino.model.POJO.DetailContainer;
import com.example.chiar.garbarino.model.POJO.Product;
import com.example.chiar.garbarino.model.POJO.ProductContainer;
import com.example.chiar.garbarino.model.POJO.Review;
import com.example.chiar.garbarino.model.POJO.ReviewContainer;
import com.example.chiar.garbarino.utils.ListenerProduct;
import com.example.chiar.garbarino.utils.ResultListener;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetailProduct extends Fragment {

    public static final String CLAVE_PRODUCTO = "producto";
    private ImageView imageViewProducto;
    private TextView textViewNombre;
    private TextView textViewPrecio;
    private TextView textViewPrecioLista;
    private TextView textViewDescuento;
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private ListenerProduct listenerProducto;
    private LinearLayout lstrevies;
    private LinearLayout lstimages;
    private ProductController controller;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_product,container,false);

        imageViewProducto = view.findViewById(R.id.detalle_producto_imagen);
        textViewNombre = view.findViewById(R.id.detalle_producto_nombre);
        textViewPrecio = view.findViewById(R.id.detalle_producto_precio);
        textViewPrecioLista = view.findViewById(R.id.detalle_producto_precio_lista);
        textViewPrecioLista.setPaintFlags(textViewPrecioLista.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        textViewDescuento = view.findViewById(R.id.detalle_producto_descuento);
        recyclerView = view.findViewById(R.id.recyclerProductos);
        lstrevies = view.findViewById(R.id.lstrevies);
        lstimages = view.findViewById(R.id.lstimagenes);


        Product product =  (Product) this.getArguments().getSerializable(FragmentDetailProduct.CLAVE_PRODUCTO);

        //Puede ue necesitemos volver al listado si hay que filtrar el producto
        if (product.getPrice() == null || product.getDescription() == null) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.popBackStack("proiducto",0);
        }

        Glide.with(this.getActivity()).load("http:" + product.getImage_url()).into(imageViewProducto);
        textViewNombre.setText(product.getDescription());
        textViewPrecio.setText("" + product.getPrice());
        textViewPrecioLista.setText("" + product.getList_price());

        // Si no nos viene el descuento hacemos modificaciones
        if (view.findViewById(R.id.celda_producto_descuento) != null) {
            if (product.getDiscount() == 0 || product.getDiscount() == null) {
                textViewPrecioLista.setVisibility(View.GONE);
                textViewDescuento.setVisibility(View.GONE);
            }
            textViewDescuento.setText("" + product.getDiscount());
        }


        loadImages(this.getActivity(), product.getId());
        loadReview(this.getActivity(), product.getId());

        return view;
    }

    public void loadReview(Activity a, String id) {
        controller = new ProductController();
        final Activity ctx = a;
        controller.searchReviews(id , new ResultListener<ReviewContainer>() {
            @Override
            public void finish(ReviewContainer result) {
                Log.v("hola","hola");
                List<Review> lstRevies = result.getItems().get(0).getReviews();
                int cont = 0;
                Log.e("elementos","" + lstRevies.size());
                while (cont < 3 && cont <lstRevies.size()) {
                    LinearLayout ll = new LinearLayout(ctx);
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    lp.gravity = Gravity.CENTER_HORIZONTAL;

                    ll.setOrientation(LinearLayout.VERTICAL);
                    ll.setLayoutParams(lp);
                    LinearLayout ll2 = new LinearLayout(ctx);
                    ll2.setOrientation(LinearLayout.VERTICAL);
                    ll2.setLayoutParams(lp);
                    TextView titulo = new TextView(ctx);
                    titulo.setLayoutParams(lp);
                    titulo.setText(lstRevies.get(cont).getTitle() + "(" + lstRevies.get(cont).getUsernickname()+ ")");
                    TextView review = new TextView(ctx);
                    review.setLayoutParams(lp);
                    review.setText(lstRevies.get(cont).getReviewTYext());
                    ll2.addView(titulo);
                    ll2.addView(review);
                    LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    RatingBar rb = new RatingBar(ctx);
                    rb.setLayoutParams(lp2);
                    rb.setNumStars(5);
                    rb.setStepSize(0.1f);
                    rb.setIsIndicator(true);
                    rb.setRating(lstRevies.get(cont).getRating());
                    ll2.addView(rb);
                    ll.addView(ll2);
                    lstrevies.addView(ll);
                    cont++;
                }
            }
        });
    }

    public void loadImages(Activity a, String id) {
        controller = new ProductController();
        final Activity ctx = a;
        controller.searchDetalle(id , new ResultListener<DetailContainer>() {
            @Override
            public void finish(DetailContainer result) {
                List<Detail> lstImages = result.getResources().getImages();
                int cont = 0;
                for (Detail detail : lstImages) {
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                    lp.gravity = Gravity.CENTER_HORIZONTAL;

                    ImageView iv = new ImageView(ctx);
                    iv.setLayoutParams(lp);
                    iv.setAdjustViewBounds(true);
                    Glide.with(ctx).load("http:" + detail.getUrl()).into(iv);
                    lstimages.addView(iv);
                    cont++;
                }
            }
        });
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listenerProducto = (ListenerProduct) context;
    }
}
