package es.iesnervion.practicafragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
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
    private ItemSelectRecyclerView interfaceItemSelect;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FragmentList() {
    }

    // TODO: Customize parameter initialization

    public static FragmentList newInstance(ArrayList<Contacto> contactos) {
        FragmentList fragment = new FragmentList();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, contactos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        interfaceItemSelect = (ItemSelectRecyclerView)context;
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
       // listaContactos.setOnClickListener(this);

        listaContactos.setLayoutManager(new LinearLayoutManager(getContext()));
        listaContactos.setAdapter(new ListFragmentAdapter(contactos,this));
        return view;
    }

    //ADAPTER
    public static class ListFragmentAdapter extends RecyclerView.Adapter<ListFragmentAdapter.ViewHolder> {

        private final List<Contacto> contactos;
        private FragmentList fragmentList;

        public ListFragmentAdapter(List<Contacto> contactos,FragmentList fragmentList) {
            this.contactos = contactos;
            this.fragmentList = fragmentList;
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
    public interface ItemSelectRecyclerView{
        void onItemSelect(Contacto contactoSeleccionado);
    }
}