package es.iesnervion.practicafragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentContacto#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentContacto extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "contacto";

    // TODO: Rename and change types of parameters
    private Contacto contacto;

    public FragmentContacto() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param contacto Parameter 1
     * @return A new instance of fragment framentContacto.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentContacto newInstance(Contacto contacto) {
        FragmentContacto fragment = new FragmentContacto();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1,contacto);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            contacto = (Contacto) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    public void actualizar(Bundle a){
        contacto = (Contacto) a.getSerializable("ContactoSeleccionado");
        View view = getView();
        TextView textViewNombre = view.findViewById(R.id.textViewNombreContactoFragment);
        textViewNombre.setText(getString(R.string.nombre)+" "+contacto.getNombre());

        TextView textViewApellidos = view.findViewById(R.id.textViewApellidosContactoFragment);
        textViewApellidos.setText(getString(R.string.apellidos)+" "+contacto.getApellidos());

        TextView textViewTelefono = view.findViewById(R.id.textViewTelefonoContactoFragment);
        textViewTelefono.setText(getString(R.string.telefono)+" "+contacto.getTelefono());

        TextView textViewDireccion = view.findViewById(R.id.textViewDireccionContactoFragment);
        textViewDireccion.setText(getString(R.string.direccion)+" "+contacto.getDireccion());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacto, container, false);

        TextView textViewNombre = view.findViewById(R.id.textViewNombreContactoFragment);
        textViewNombre.setText(getString(R.string.nombre)+" "+contacto.getNombre());

        TextView textViewApellidos = view.findViewById(R.id.textViewApellidosContactoFragment);
        textViewApellidos.setText(getString(R.string.apellidos)+" "+contacto.getApellidos());

        TextView textViewTelefono = view.findViewById(R.id.textViewTelefonoContactoFragment);
        textViewTelefono.setText(getString(R.string.telefono)+" "+contacto.getTelefono());

        TextView textViewDireccion = view.findViewById(R.id.textViewDireccionContactoFragment);
        textViewDireccion.setText(getString(R.string.direccion)+" "+contacto.getDireccion());

        return view;
    }
}