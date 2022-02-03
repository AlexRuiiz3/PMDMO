package es.iesnervion.aruiz.pruebasegundaevaluacion.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.Menu;
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

import es.iesnervion.aruiz.pruebasegundaevaluacion.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentListaProductos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentListaProductos extends Fragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentListaProductos() {
        // Required empty public constructor
    }
    public static FragmentListaProductos newInstance(String param1, String param2) {
        FragmentListaProductos fragment = new FragmentListaProductos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
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

        switch (item.getItemId()){
            case R.id.menuBuscadorProductosFiltrarCategorias:
                //TODO obtener cuantas categorias hay en la BBDD y mostrar su nombre
                SubMenu submenu = item.getSubMenu();
                for (int i = 1; i <= 20; i++){
                    submenu.add("Categoria "+i);
                }
            break;

            case R.id.submenOrdenarItemNombre:
                //TODO Ordenar lista por nombre
            break;

            case R.id.submenOrdenarItemPrecio:
                //TODO Ordenar lista por precio
            break;

            default: //Sera cuando se haga click en una categoria
                Toast.makeText(getContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
            break;
        }
        return true;
    }

    class AdapterRecyclerViewListProducts extends RecyclerView.Adapter {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        class ViewHolder extends RecyclerView.ViewHolder{

            private TextView textViewPrecio;
            private TextView textViewNombre;
            private ImageView imageViewImagenProducto;

            public ViewHolder(View itemView) {
                super(itemView);
                textViewPrecio = itemView.findViewById(R.id.textViewPrecioProducto);
                textViewNombre = itemView.findViewById(R.id.textViewNombreProducto);
                imageViewImagenProducto = itemView.findViewById(R.id.imageViewProducto);
            }

            public asignarDatos(Producto producto){

            }
        }
    }
}