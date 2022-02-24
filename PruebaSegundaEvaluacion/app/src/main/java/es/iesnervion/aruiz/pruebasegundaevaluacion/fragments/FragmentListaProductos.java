package es.iesnervion.aruiz.pruebasegundaevaluacion.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.R;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.viewModels.MainActivityVM;
import es.iesnervion.aruiz.pruebasegundaevaluacion.databinding.FragmentListaProductosBinding;

public class FragmentListaProductos extends Fragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener, SearchView.OnQueryTextListener {

    private FragmentListaProductosBinding binding;
    private RecyclerView recyclerView;
    private SearchView searchView;
    private ImageButton botonFiltar;
    private ImageButton botonCestaCompra;

    private AdapterRecyclerViewListProducts adapterRecyclerView;
    private MainActivityVM mainActivityVM;
    private List<String> listadoNombreCategorias;
    private List<ProductoBO> listadoProductos;

    public FragmentListaProductos() {
        // Required empty public constructor
    }
    public static FragmentListaProductos newInstance() {
        FragmentListaProductos fragment = new FragmentListaProductos();
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
        binding = FragmentListaProductosBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        botonFiltar = binding.imageButtonFlitrar;
        botonFiltar.setOnClickListener(this);

        botonCestaCompra = binding.imageButtonCestaCompra;
        botonCestaCompra.setOnClickListener(this);

        searchView = binding.searchViewListadoProductos;
        searchView.setOnQueryTextListener(this);

        //Datos necesarios de VM
        mainActivityVM = new ViewModelProvider(requireActivity()).get(MainActivityVM.class);
        mainActivityVM.getListadoProductos().observe(getViewLifecycleOwner(),this::observerListadoProductos);
        mainActivityVM.getListadoNombreCategorias().observe(getViewLifecycleOwner(),this::observerListadoNombreCategorias);
        mainActivityVM.cargarNombreCategorias();

        recyclerView = binding.recyclerViewProductos;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3)); //Para especificar que el contenido del recylcerView se vea en 3 columnas

        /* Esto es necesario para poder volver del fragment de listado de productos a el fragment de inicio de sesion.
        *  Lo que se hace en entrar dentro del evento que esta asociado al boton del movil del ir para atras.
        *  Es necesario hacerlo de esta manera debido a:
        *  Tenemos 3 fragments I(Inicio sesion), R(Registro) y L(Listado de productos)
        *  Entonces de I se pasa a R, y en la pila se guarda el fragment I
        *  Ahora de R se pasa a L pero, no se guarda R en la pila ya que no tiene sentido que cuando se este en el fragment L, se vuelva a el fragment de registro
        *  El problema esta en como esta hecha la pila de fragment por dentro porque,
        *  I -> R(Guardar I) -> L
        *
        *  Si estando ahora en L se quiere volver atras, internamente como esta hecho lo que se hara es
        *  remove de R y pone el I. Eso no es correcto porque se estarian superponiendo los fragments ahora se veria el fragment L que ya estaba mas el I
        *
        */
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                mostrarAlertVolverAtras();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);
        return view;
    }

    private void observerListadoNombreCategorias(List<String> nombresCategorias) {
        listadoNombreCategorias = nombresCategorias;
    }

    private void observerListadoProductos(List<ProductoBO> productosBO) {
        listadoProductos = productosBO;
        adapterRecyclerView = new AdapterRecyclerViewListProducts(productosBO);
        recyclerView.setAdapter(adapterRecyclerView);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.imageButtonFlitrar:
                PopupMenu popup = new PopupMenu(getContext(), v);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.menu_buscador_productos, popup.getMenu());
                popup.setOnMenuItemClickListener(this);
                popup.show();
                break;

            case R.id.imageButtonCestaCompra:
                Toast.makeText(getContext(),"Ir a cesta de compra",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //Metodo para cuando se pulse una opcion del menu flotante
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        List<ProductoBO> productos = null;
        switch (item.getItemId()){
            case R.id.menuBuscadorProductosFiltrarCategorias:
                SubMenu submenu = item.getSubMenu(); //Se crea un subMenu
                for (int i = 0; i < listadoNombreCategorias.size(); i++){
                    submenu.add(listadoNombreCategorias.get(i));
                }
            break;

            case R.id.submenuOrdenarItemNombre:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) { //Para un problema con la version de la API
                    listadoProductos.sort(Comparator.comparing(ProductoBO::getNombre));
                    adapterRecyclerView = new AdapterRecyclerViewListProducts(listadoProductos);
                    recyclerView.setAdapter(adapterRecyclerView);
                }
            break;

            case R.id.submenuOrdenarItemPrecio:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) { //Para un problema con la version de la API
                    listadoProductos.sort(Comparator.comparing(ProductoBO::getPrecio));
                    adapterRecyclerView = new AdapterRecyclerViewListProducts(listadoProductos);
                    recyclerView.setAdapter(adapterRecyclerView);
                }
            break;

            case R.id.menuBuscadorProductosVolverListaOriginal:
                mainActivityVM.cargarProductos();
            break;

            default: //Sera cuando se haga click en una categoria
                if(!item.getTitle().equals("Ordenar Por")){
                    mainActivityVM.cargarProductosDeCategoria((String) item.getTitle());
                }
            break;
        }
        return true;
    }

    private void mostrarAlertVolverAtras(){

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Volver atras");
        builder.setMessage("¿Quiere volver a inicio de sesión?");

        builder.setPositiveButton("Si", (dialog, which) -> {
            getActivity().getSupportFragmentManager().popBackStack();//Limpia todos los fragmentos que haya en la pila.
            FragmentPrincipal fragmentPrincipal = FragmentPrincipal.newInstance(); //Se añade el fragment principal
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmetPrincipal,fragmentPrincipal).commit();
        });

        builder.setNegativeButton("No", (dialog, which) -> {
        });
        builder.create().show(); //Se crea y se muestra
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapterRecyclerView.filtrarProductos(newText);
        return false;
    }

    public class AdapterRecyclerViewListProducts extends RecyclerView.Adapter<AdapterRecyclerViewListProducts.ViewHolder> {
        private List<ProductoBO> listaProductos;
        private List<ProductoBO> listaProductosAux;

        public AdapterRecyclerViewListProducts(List<ProductoBO> listaProductos){
            this.listaProductos = new ArrayList<>(listaProductos);
            listaProductosAux = new ArrayList<>(listaProductos);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.producto_recylerview,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.asignarDatos(listaProductos.get(position));
        }

        @Override
        public int getItemCount() {
            return listaProductos.size();
        }

        public void filtrarProductos(String texto) {
            if(texto.length() == 0){
                listaProductos = new ArrayList<>(listaProductosAux);//listaProductosAux tiene todos los productos
            }else{
                listaProductos.clear();
                for(ProductoBO producto : listaProductosAux){
                    if(producto.getNombre().toLowerCase().contains(((CharSequence) texto).toString().toLowerCase())
                            || String.valueOf(producto.getPrecio()).contains(((CharSequence) texto).toString().toLowerCase())){
                        listaProductos.add(producto);
                    }
                }
            }
            recyclerView.setAdapter(new AdapterRecyclerViewListProducts(listaProductos));
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
                inflater.inflate(R.menu.menu_opciones_producto, popup.getMenu());
                popup.setOnMenuItemClickListener(this);
                popup.show();
            }

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.opcionMenuAnhadirProductoCesta:

                    break;

                    case R.id.opcionMenuVerDetalles:
                        mainActivityVM.getProductoSeleccionado().postValue(producto);
                        FragmentDetallesProducto fragmentDetallesProducto = FragmentDetallesProducto.newInstance();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmetPrincipal,fragmentDetallesProducto).addToBackStack(null).commit();
                    break;
                }
                return true;
            }
        }
    }
}