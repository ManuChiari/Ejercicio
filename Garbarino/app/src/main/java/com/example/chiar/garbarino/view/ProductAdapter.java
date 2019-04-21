package com.example.chiar.garbarino.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.chiar.garbarino.R;
import com.example.chiar.garbarino.model.POJO.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolderProducto> {

    private List<Product> products = new ArrayList<>();
    private ListenerAdapterProductos listenerAdapterProductos;


    public ProductAdapter(ListenerAdapterProductos listenerAdapterProductos) {
        this.listenerAdapterProductos = listenerAdapterProductos;

    }



    @NonNull
    @Override
    public ViewHolderProducto onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.celda_producto, viewGroup, false);

        ViewHolderProducto viewHolderProducto = new ViewHolderProducto(view);

        return viewHolderProducto;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProducto viewHolderProducto, int i) {

        Product product = products.get(i);
        viewHolderProducto.bindProducto(product);
    }


    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolderProducto extends RecyclerView.ViewHolder {
        private TextView textViewNombreProducto;
        private ImageView imageViewProducto;
        private TextView textViewPrecio;
        private TextView textViewPrecioLista;
        private TextView textViewDescuento;

        public ViewHolderProducto( View itemView) {
            super(itemView);
            textViewNombreProducto = itemView.findViewById(R.id.celda_producto_description);
            imageViewProducto = itemView.findViewById(R.id.celda_producto_imagen);
            textViewPrecio = itemView.findViewById(R.id.celda_prudcto_precio);
            textViewPrecioLista = itemView.findViewById(R.id.celda_producto_precio_lista);
            textViewDescuento = itemView.findViewById(R.id.celda_producto_descuento);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Product productSeleccionado = products.get(getAdapterPosition());
                    listenerAdapterProductos.productoSeleccionado(productSeleccionado);
                }
            });
        }

        public void bindProducto(Product product) {
            textViewNombreProducto.setText(product.getDescription());
            Glide.with(itemView).load("http:" + product.getImage_url()).into(imageViewProducto);
            textViewPrecio.setText("$ " + product.getPrice().toString());
            textViewPrecioLista.setText("$ " + product.getList_price().toString());
            textViewDescuento.setText(product.getDiscount().toString() + "%");
        }
    }

    public void setProducts (List<Product> products){
        this.products = products;
        notifyDataSetChanged();
    }


    public interface ListenerAdapterProductos{
        public void productoSeleccionado (Product productSeleccionado);
    }
}
