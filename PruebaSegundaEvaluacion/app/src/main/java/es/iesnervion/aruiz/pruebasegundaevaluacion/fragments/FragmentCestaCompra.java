package es.iesnervion.aruiz.pruebasegundaevaluacion.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.iesnervion.aruiz.pruebasegundaevaluacion.R;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.databinding.FragmentCestaCompraBinding;

public class FragmentCestaCompra extends Fragment {

    private FragmentCestaCompraBinding binding;
    private RecyclerView recyclerView;

    public FragmentCestaCompra() {
        // Required empty public constructor
    }

    public static FragmentCestaCompra newInstance() {
        FragmentCestaCompra fragment = new FragmentCestaCompra();
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
        binding = FragmentCestaCompraBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        recyclerView = binding.recyclerViewProductosCesta;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setAdapter(new AdapterRecyclerViewListProducts(null));

        return view;
    }

    public class AdapterRecyclerViewListProducts extends RecyclerView.Adapter<FragmentCestaCompra.AdapterRecyclerViewListProducts.ViewHolder> {
        private List<ProductoBO> listaProductos;

        public AdapterRecyclerViewListProducts(List<ProductoBO> listaProductos){
            this.listaProductos = new ArrayList<>(listaProductos);
        }

        @Override
        public FragmentCestaCompra.AdapterRecyclerViewListProducts.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.producto_recylerview,parent,false);
            return new FragmentCestaCompra.AdapterRecyclerViewListProducts.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(FragmentCestaCompra.AdapterRecyclerViewListProducts.ViewHolder holder, int position) {
            holder.asignarDatos(listaProductos.get(position));
        }

        @Override
        public int getItemCount() {
            return listaProductos.size();
        }


        class ViewHolder extends RecyclerView.ViewHolder {
            private TextView textViewNombre;
            private TextView textViewPrecio;
            private ImageView imageViewImagenProducto;

            public ViewHolder(View view) {
                super(view);
                textViewNombre = view.findViewById(R.id.textViewNombreProducto);
                textViewPrecio = view.findViewById(R.id.textViewPrecioProducto);
                imageViewImagenProducto = view.findViewById(R.id.imageViewProducto);
            }

            public void asignarDatos(ProductoBO producto){
                textViewNombre.setText(producto.getNombre());
                textViewPrecio.setText(producto.getPrecio()+"€");
                imageViewImagenProducto.setImageResource(producto.getImagen());
            }
        }
    }
}