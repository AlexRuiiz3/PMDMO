package es.iesnervion.practicafragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.iesnervion.practicafragments.databinding.FragmentListBinding;
import es.iesnervion.practicafragments.placeholder.PlaceholderContent;

/**
 * A fragment representing a list of Items.
 */
public class FragmentList extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_PARAM1 = "contactos";
    // TODO: Customize parameters
    private List<Contacto> contactos;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FragmentList() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static FragmentList newInstance(ArrayList<Contacto> contactos) {
        FragmentList fragment = new FragmentList();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, contactos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            contactos = (ArrayList<Contacto>)getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView listaContactos = view.findViewById(R.id.RecyclerViewContactos);
        listaContactos.setAdapter(new ListFragmentAdapter(crearListaConactos()));
        return view;
    }

    //ADAPTER
    public static class ListFragmentAdapter extends RecyclerView.Adapter<ListFragmentAdapter.ViewHolder> {

        private final List<Contacto> contactos;

        public ListFragmentAdapter(List<Contacto> contactos) {
            this.contactos = contactos;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacto_recyclerview,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
        holder.asignarDatos(contactos.get(position));
        }

        @Override
        public int getItemCount() {
            return contactos.size();
        }

        //VIEW HOLDER
        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView textViewNombreContacto;
            public TextView textViewTelefonoContacto;

            public ViewHolder(View view) {
                super(view);
                textViewNombreContacto = view.findViewById(R.id.textViewNombreContacto);
                textViewTelefonoContacto = view.findViewById(R.id.textViewTelefonoContacto);
            }

            public void asignarDatos(Contacto contacto){
                textViewNombreContacto.setText(contacto.getNombre());
                textViewTelefonoContacto.setText(contacto.getTelefono());
            }
        }
    }

    private List<Contacto> crearListaConactos(){
        List<Contacto> contactos = new ArrayList<>();
            contactos.add(new Contacto("Contacto 1","apellidos 1","111111111","C/Calle 1"));
            contactos.add(new Contacto("Contacto 2","apellidos 2","222222222","C/Calle 2"));
            contactos.add(new Contacto("Contacto 3","apellidos 3","333333333","C/Calle 3"));
            contactos.add(new Contacto("Contacto 4","apellidos 4","444444444","C/Calle 4"));
            contactos.add(new Contacto("Contacto 5","apellidos 5","555555555","C/Calle 5"));
            contactos.add(new Contacto("Contacto 6","apellidos 6","666666666","C/Calle 6"));
            contactos.add(new Contacto("Contacto 7","apellidos 7","777777777","C/Calle 7"));
            contactos.add(new Contacto("Contacto 8","apellidos 8","888888888","C/Calle 8"));
        return contactos;
    }
}