package es.iesnervion.aruiz.pruebasegundaevaluacion.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;

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
        boolean elementoDeseadoClicado = false;
        if(item.getItemId() == R.id.menuBuscadorProductosFiltrarCategorias){
            item.getSubMenu().add("Categoria 1");
            elementoDeseadoClicado = true;
        }
        return elementoDeseadoClicado;
    }
}