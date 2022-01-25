package es.iesnervion.aruiz.PracticaFragmentConVM;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragmentContacto extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "contacto";

    // TODO: Rename and change types of parameters
    private View vista;
    private MainActivityVM mainActivityVM;

    public FragmentContacto() {
        // Required empty public constructor
    }

    /*
    public static FragmentContacto newInstance() {
        FragmentContacto fragment = new FragmentContacto();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* if (getArguments() != null) {

        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_contacto, container, false);
        return vista;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainActivityVM = new ViewModelProvider(getActivity()).get(MainActivityVM.class);
        mainActivityVM.getContactoSeleccionado().observe(getViewLifecycleOwner(), this::onContactoChange);
    }

    private void onContactoChange(Contacto contacto) {
        ((TextView)vista.findViewById(R.id.textViewNombreContactoFragment)).setText(contacto.getNombre());
        ((TextView)vista.findViewById(R.id.textViewApellidosContactoFragment)).setText(contacto.getApellidos());
        ((TextView)vista.findViewById(R.id.textViewTelefonoContactoFragment)).setText(contacto.getTelefono());
        ((TextView)vista.findViewById(R.id.textViewDireccionContactoFragment)).setText(contacto.getDireccion());
    }
}