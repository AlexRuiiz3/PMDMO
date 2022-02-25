package es.iesnervion.aruiz.pruebasegundaevaluacion.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import es.iesnervion.aruiz.pruebasegundaevaluacion.R;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.viewModels.MainActivityVM;
import es.iesnervion.aruiz.pruebasegundaevaluacion.databinding.FragmentDetallesProductoBinding;
import es.iesnervion.aruiz.pruebasegundaevaluacion.gestion.Generica;

public class FragmentDetallesProducto extends Fragment implements View.OnClickListener {

    private FragmentDetallesProductoBinding binding;
    private MainActivityVM mainActivityVM;
    private int codigoProducto;

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

        binding.buttonIrAlaCesta.setOnClickListener(this);
        binding.buttonAAdirCestaDetalles.setOnClickListener(this);
        return view;
    }

    private void productoChanged(ProductoBO productoBO) {
        codigoProducto = productoBO.getCodigo();
        binding.imageViewProductoFragDetalles.setImageResource(productoBO.getImagen());
        binding.textViewNombreProductoFragDetalles.setText(productoBO.getNombre());
        binding.textViewCantidadProductoFragDetalles.setText(String.valueOf(productoBO.getCantidadStock()));
        binding.textViewPrecioProductoFragDetalles.setText(String.valueOf(productoBO.getPrecioKiloLitro()));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.buttonIrAlaCesta:
                FragmentCestaCompra fragmentCestaCompra = FragmentCestaCompra.newInstance();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmetPrincipal,fragmentCestaCompra).addToBackStack(null).commit();

                break;

            case R.id.buttonAñadirCestaDetalles:
                Executor executor = Executors.newSingleThreadExecutor();
                executor.execute(() ->  {
                    Looper.prepare();//Para poder mostrar los Toast ya que se hace desde un hilo secundario
                    if(mainActivityVM.insertarProductoEnCesta(Generica.dniUsuario,codigoProducto)){
                        Toast.makeText(getContext(),"El producto fue añadido",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getContext(),"Producto ya añadido",Toast.LENGTH_SHORT).show();
                    }
                });
            break;
        }
    }
}