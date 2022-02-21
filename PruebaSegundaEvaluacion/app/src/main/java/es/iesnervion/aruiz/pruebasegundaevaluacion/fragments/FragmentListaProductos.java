package es.iesnervion.aruiz.pruebasegundaevaluacion.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.R;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.viewModels.MainActivityVM;
import es.iesnervion.aruiz.pruebasegundaevaluacion.databinding.FragmentListaProductosBinding;

public class FragmentListaProductos extends Fragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private FragmentListaProductosBinding binding;
    private List<ProductoBO> listadoProductos;
    private RecyclerView recyclerView;
    private MainActivityVM mainActivityVM;
    private ImageButton botonFiltar;
    private ImageButton botonCestaCompra;

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
        mainActivityVM = new ViewModelProvider(this).get(MainActivityVM.class);
        View view = binding.getRoot();

        botonFiltar = binding.imageButtonFlitrar;
        botonFiltar.setOnClickListener(this);

        botonCestaCompra = binding.imageButtonCestaCompra;
        botonCestaCompra.setOnClickListener(this);

        listadoProductos = mainActivityVM.obtenerProductos();
        recyclerView = binding.recyclerViewProductos;

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3)); //Para especificar que el contenido del recylcerView se vea en 3 columnas
        recyclerView.setAdapter(new AdapterRecyclerViewListProducts(listadoProductos));
        return view;
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
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        List<ProductoBO> productos = null;
        switch (item.getItemId()){
            case R.id.menuBuscadorProductosFiltrarCategorias:
                //TODO obtener cuantas categorias hay en la BBDD y mostrar su nombre
                SubMenu submenu = item.getSubMenu();
                submenu.add("Volver a la original");
                for (int i = 1; i <= 20; i++){
                    submenu.add("Categoria "+i);
                }
            break;

            case R.id.submenuOrdenarItemNombre:
                //TODO Ordenar lista por nombre
                Toast.makeText(getContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                //productos = new ArrayList<>();
            break;

            case R.id.submenuOrdenarItemPrecio:
                //TODO Ordenar lista por precio
                Toast.makeText(getContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                //productos = new ArrayList<>();
            break;

            default: //Sera cuando se haga click en una categoria
                if(item.getTitle() == "Volver a la original"){
                    //TODO obtener la lista completa, original
                }else{
                    //TODO obtener productos de la categoria clicada
                }
            break;
        }
        if(productos != null){
            recyclerView.setAdapter(new AdapterRecyclerViewListProducts(productos)); //Aqui se actualiza el recyclerView con la nueva lista filtrada
        }
        return true;
    }

    //Poner que cuando le de para atras pregunte si quiere salir.



    public class AdapterRecyclerViewListProducts extends RecyclerView.Adapter<AdapterRecyclerViewListProducts.ViewHolder> {
        private List<ProductoBO> listaProductos;

        public AdapterRecyclerViewListProducts(List<ProductoBO> listaProductos){
            this.listaProductos = listaProductos;
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

        class ViewHolder extends RecyclerView.ViewHolder{
            private TextView textViewNombre;
            private TextView textViewPrecio;
            private ImageView imageViewImagenProducto;

            public ViewHolder(View itemView) {
                super(itemView);
                textViewNombre = itemView.findViewById(R.id.textViewNombreProducto);
                textViewPrecio = itemView.findViewById(R.id.textViewPrecioProducto);
                imageViewImagenProducto = itemView.findViewById(R.id.imageViewProducto);
            }

            public void asignarDatos(ProductoBO producto){
                textViewNombre.setText(producto.getNombre());
                textViewPrecio.setText(producto.getPrecio()+"€");
                imageViewImagenProducto.setImageResource(producto.getImagen());
            }
        }
    }
}