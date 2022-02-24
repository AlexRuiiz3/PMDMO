package es.iesnervion.aruiz.pruebasegundaevaluacion.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.viewModels.MainActivityVM;
import es.iesnervion.aruiz.pruebasegundaevaluacion.databinding.FragmentDetallesProductoBinding;

public class FragmentDetallesProducto extends Fragment {

    private FragmentDetallesProductoBinding binding;
    private MainActivityVM mainActivityVM;

    public FragmentDetallesProducto() {
        // Required empty public constructor
    }

    public static FragmentDetallesProducto newInstance() {
        FragmentDetallesProducto fragment = new FragmentDetallesProducto();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetallesProductoBinding.inflate(getLayoutInflater());
        View view  = binding.getRoot();
        mainActivityVM = new ViewModelProvider(requireActivity()).get(MainActivityVM.class);
        mainActivityVM.getProductoSeleccionado().observe(getViewLifecycleOwner(),this::productoChanged);
        return view;
    }

    private void productoChanged(ProductoBO productoBO) {
        binding.imageViewProductoFragDetalles.setImageResource(productoBO.getImagen());
        binding.textViewNombreProductoFragDetalles.setText(productoBO.getNombre());
        binding.textViewCantidadProductoFragDetalles.setText(String.valueOf(productoBO.getCantidadStock()));
        binding.textViewPrecioProductoFragDetalles.setText(String.valueOf(productoBO.getPrecioKiloLitro()));
    }
}