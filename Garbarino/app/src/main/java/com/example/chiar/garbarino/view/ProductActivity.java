package com.example.chiar.garbarino.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;

import com.example.chiar.garbarino.R;
import com.example.chiar.garbarino.model.POJO.Product;
import com.example.chiar.garbarino.utils.ListenerProduct;

public class ProductActivity extends AppCompatActivity implements FragmentProduct.ListenerFragmentProducto, ListenerProduct {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        pegarFragment(new FragmentProduct());
    }

    private void pegarFragment (Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.entrada_fragment, R.anim.salida_fragment);
        fragmentTransaction.replace(R.id.contenedor_fragments_productos, fragment);
        fragmentTransaction.addToBackStack("product");
        fragmentTransaction.commit();

    }

    @Override
    public void informarProductoSeleccionado(Product productSeleccionado) {
        FragmentDetailProduct fragmentDetailProduct = new FragmentDetailProduct();
        Bundle bundle = new Bundle();

        bundle.putSerializable(FragmentDetailProduct.CLAVE_PRODUCTO, productSeleccionado);

        fragmentDetailProduct.setArguments(bundle);

        pegarFragment(fragmentDetailProduct);
    }

    @Override
    public void productoClick(Product product) {
        informarProductoSeleccionado(product);
    }
}
