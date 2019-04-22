package com.example.chiar.garbarino.view;


import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.chiar.garbarino.R;
import com.example.chiar.garbarino.model.POJO.Product;
import com.example.chiar.garbarino.utils.ListenerProduct;


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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_product,container,false);

        imageViewProducto = view.findViewById(R.id.detalle_producto_imagen);
        textViewNombre = view.findViewById(R.id.detalle_producto_nombre);
        textViewPrecio = view.findViewById(R.id.detalle_producto_precio);
        textViewPrecioLista = view.findViewById(R.id.detalle_producto_precio_lista);
        textViewDescuento = view.findViewById(R.id.detalle_producto_descuento);
        recyclerView = view.findViewById(R.id.recyclerProductos);

        Product product =  (Product) this.getArguments().getSerializable(FragmentDetailProduct.CLAVE_PRODUCTO);

        Glide.with(this.getActivity()).load("http:" + product.getImage_url()).into(imageViewProducto);
        textViewNombre.setText(product.getDescription());
        textViewPrecio.setText("" + product.getPrice());
        textViewPrecioLista.setText("" + product.getList_price());
        textViewPrecioLista.setPaintFlags(textViewPrecioLista.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        if (view.findViewById(R.id.celda_producto_descuento) != null)
            textViewDescuento.setText("" + product.getDiscount());



        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listenerProducto = (ListenerProduct) context;
    }
}
