package es.iesnervion.aruiz.PracticaFragmentConVM;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class FragmentList extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_PARAM1 = "contactos";
    // TODO: Customize parameters
    private List<Contacto> contactos;
    public MainActivityVM mainActivityVM;

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
/*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }*/

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
        listaContactos.setLayoutManager(new LinearLayoutManager(getContext()));
        listaContactos.setAdapter(new ListFragmentAdapter(contactos));

        mainActivityVM = new ViewModelProvider(getActivity()).get(MainActivityVM.class);
        return view;
    }

    //ADAPTER
    public class ListFragmentAdapter extends RecyclerView.Adapter<ListFragmentAdapter.ViewHolder>  {

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
        public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
            public TextView textViewNombreContacto;
            public TextView textViewTelefonoContacto;
            public Contacto contacto;

            public ViewHolder(View view) {
                super(view);
                textViewNombreContacto = view.findViewById(R.id.textViewNombreContacto);
                textViewTelefonoContacto = view.findViewById(R.id.textViewTelefonoContacto);
                view.setOnClickListener(this);
            }

            public void asignarDatos(Contacto contacto){
                textViewNombreContacto.setText(contacto.getNombre());
                textViewTelefonoContacto.setText(contacto.getTelefono());
                this.contacto = contacto;
            }

            @Override
            public void onClick(View v) {
                mainActivityVM.getContactoSeleccionado().postValue(contacto);
            }
        }
    }
}