package es.iesnervion.aruiz.myapplicationa.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import binding
import java.util.ArrayList;

import es.iesnervion.aruiz.myapplicationa.dataaccess.entidades.bo.ProductoBO;
import es.iesnervion.aruiz.myapplicationa.dataaccess.viewmodels.CarroCompraVM;

public class CarroCompraFragment extends Fragment {

    private CarroCompraCardProductoBinding propiedadBindeo;
    private CarroCompraVM carroCompraVM = null;

    public static CarroCompraFragment newInstance() {
        CarroCompraFragment fragment = new CarroCompraFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            carroCompraVM = new ViewModelProvider(this).get(CarroCompraVM.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        propiedadBindeo = CarroCompraCardProductoBinding.inflater(inflater,container,false);
        return propiedadBindeo.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        carroCompraVM.getProductList().observe(getViewLifecycleOwner(),this::onProductOnLoaded);
    }

    private void onProductOnLoaded(ArrayList<ProductoBO> listProductos){
        propiedadBindeo.carroCompraCard
    }
}