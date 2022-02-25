package es.iesnervion.aruiz.pruebasegundaevaluacion.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import es.iesnervion.aruiz.pruebasegundaevaluacion.R;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.viewModels.MainActivityVM;
import es.iesnervion.aruiz.pruebasegundaevaluacion.databinding.FragmentCestaCompraBinding;
import es.iesnervion.aruiz.pruebasegundaevaluacion.gestion.Generica;

public class FragmentCestaCompra extends Fragment implements View.OnClickListener {

    private FragmentCestaCompraBinding binding;
    private RecyclerView recyclerView;
    private MainActivityVM mainActivityVM;
    private Executor executor;
    private List<ProductoBO> listadoProductos;

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
        mainActivityVM = new ViewModelProvider(requireActivity()).get(MainActivityVM.class);

        mainActivityVM.getListadoProductosCestaUsuario().observe(getViewLifecycleOwner(),this::observerListadoProductosCesta);
        mainActivityVM.cargarProductosCestaNoEnviadaUsuario(Generica.dniUsuario);

        executor = Executors.newSingleThreadExecutor();

        recyclerView = binding.recyclerViewProductosCesta;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.materialButtonAceptarCesta.setOnClickListener(this);
        return view;
    }
    private void observerListadoProductosCesta(List<ProductoBO> productosCestaUsuario) {
        listadoProductos = productosCestaUsuario;
        recyclerView.setAdapter(new AdapterRecyclerViewListProducts(productosCestaUsuario));
        calcularPrecioTotalProductos(productosCestaUsuario);
    }

    private void calcularPrecioTotalProductos(List<ProductoBO> productosCestaUsuario){
        DecimalFormat df = new DecimalFormat("####0.00"); //Para poder redondear un decimal
        double total = 0;
        for(ProductoBO producto: productosCestaUsuario){
            total += producto.getPrecio();
        }
        binding.textViewPrecioTotalCesta.setText("Total:"+df.format(total)+"€");
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.materialButtonAceptarCesta){//TODO PONER QUE MANDE UN CORREO
            if (listadoProductos.size() == 0){
                Toast.makeText(getContext(),"No se puede aceptar, no hay productos añadidos",Toast.LENGTH_SHORT).show();
            }else{
                executor.execute(() -> {
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{ mainActivityVM.obtenerEmailUsuario(Generica.dniUsuario)});
                    email.putExtra(Intent.EXTRA_SUBJECT, "Compra Supermercado");
                    email.putExtra(Intent.EXTRA_TEXT, "La cesta estara preparada en dos horas. Importe: "+binding.textViewPrecioTotalCesta.getText());
                    email.setType("message/rfc822");
                    startActivity(Intent.createChooser(email, "Choose an Email client :"));
                    mainActivityVM.actualizarEstadoCesta(Generica.dniUsuario,1);
                    mainActivityVM.cargarProductosCestaNoEnviadaUsuario(Generica.dniUsuario);
                });
            }
        }
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


        class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
            private TextView textViewNombre;
            private TextView textViewPrecio;
            private ImageView imageViewImagenProducto;
            private ProductoBO producto;

            public ViewHolder(View view) {
                super(view);
                textViewNombre = view.findViewById(R.id.textViewNombreProducto);
                textViewPrecio = view.findViewById(R.id.textViewPrecioProducto);
                imageViewImagenProducto = view.findViewById(R.id.imageViewProducto);
                view.setOnClickListener(this);
            }

            public void asignarDatos(ProductoBO producto){
                textViewNombre.setText(producto.getNombre());
                textViewPrecio.setText(producto.getPrecio()+"€");
                imageViewImagenProducto.setImageResource(producto.getImagen());
                this.producto = producto;
            }

            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getContext(), v);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.menu_producto_cesta, popup.getMenu());
                popup.setOnMenuItemClickListener(this);
                popup.show();
            }

            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.opcionMenuEliminarProductoCesta){
                    executor.execute(() -> {
                        mainActivityVM.eliminarProductoCesta(Generica.dniUsuario,producto.getCodigo());
                        mainActivityVM.cargarProductosCestaNoEnviadaUsuario(Generica.dniUsuario);//Se llama para que se actualice la lista del recyclerview y se calcule de nuevo el precio Total
                    });

                }
                return true;
            }
        }
    }
}