package es.iesnervion.aruiz.pruebasegundaevaluacion.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
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

import java.util.ArrayList;
import java.util.List;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.ProductoDBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.R;

public class FragmentListaProductos extends Fragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private List<ProductoDBO> listadoProductos;
    private RecyclerView recyclerView;

    public FragmentListaProductos() {
        // Required empty public constructor
    }
    public static FragmentListaProductos newInstance(String param1, String param2) {
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
        View view = inflater.inflate(R.layout.fragment_lista_productos, container, false);

        ImageButton botonDesplegable = view.findViewById(R.id.imageButtonDesplegable);
        botonDesplegable.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.imageButtonDesplegable){
            PopupMenu popup = new PopupMenu(getContext(), v);
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.menu_buscador_productos, popup.getMenu());
            popup.setOnMenuItemClickListener(this);
            popup.show();
        }
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        List<ProductoDBO> productos = null;
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
                productos = new ArrayList<>();
            break;

            case R.id.submenuOrdenarItemPrecio:
                //TODO Ordenar lista por precio
                productos = new ArrayList<>();
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

    public class AdapterRecyclerViewListProducts extends RecyclerView.Adapter<AdapterRecyclerViewListProducts.ViewHolder> {
        private List<ProductoDBO> listaProductos;

        public AdapterRecyclerViewListProducts(List<ProductoDBO> listaProductos){
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

            public void asignarDatos(ProductoDBO producto){
                textViewNombre.setText(producto.getNombre());
                textViewPrecio.setText(String.valueOf(producto.getPrecio()));
                imageViewImagenProducto.setImageResource(Integer.parseInt("R.drawable."+producto.getImagen()));
            }
        }
    }
}