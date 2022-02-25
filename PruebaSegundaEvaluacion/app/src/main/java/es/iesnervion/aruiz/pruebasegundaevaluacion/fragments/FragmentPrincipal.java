package es.iesnervion.aruiz.pruebasegundaevaluacion.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import es.iesnervion.aruiz.pruebasegundaevaluacion.R;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.viewModels.MainActivityVM;
import es.iesnervion.aruiz.pruebasegundaevaluacion.databinding.FragmentPrincipalBinding;
import es.iesnervion.aruiz.pruebasegundaevaluacion.gestion.Generica;
import es.iesnervion.aruiz.pruebasegundaevaluacion.gestion.Utilidades;

public class FragmentPrincipal extends Fragment implements View.OnClickListener {

    private FragmentPrincipalBinding binding;
    private EditText editTextDNI;
    private EditText editTextContrasenha;
    private MaterialTextView textRegistrarse;
    private MaterialButton buttonIniciarSesion;

    private MainActivityVM mainActivityVM;

    public FragmentPrincipal() {
        // Required empty public constructor
    }

    public static FragmentPrincipal newInstance() {
        FragmentPrincipal fragment = new FragmentPrincipal();
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
        binding = FragmentPrincipalBinding.inflate(getLayoutInflater());
        mainActivityVM = new ViewModelProvider(requireActivity()).get(MainActivityVM.class);

        View view = binding.getRoot();

        editTextDNI = binding.textFieldDNIInicioSesion.getEditText();
        editTextContrasenha = binding.textFieldContrasenhaInicioSesion.getEditText();

        buttonIniciarSesion = binding.buttonIniciarSesion;
        buttonIniciarSesion.setOnClickListener(this);

        textRegistrarse = binding.textViewRegistrarse;
        textRegistrarse.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.buttonIniciarSesion:
            String DNI = editTextDNI.getText().toString();
            String contrasenha = editTextContrasenha.getText().toString();

            if(Utilidades.comprarValidezDNI(DNI,getContext())){ //Si el DNI es valido
                if(Utilidades.validarContrasenha(contrasenha,getContext())){
                    if(mainActivityVM.comprobarSiExisteUsuario(DNI,contrasenha)){
                        Toast.makeText(getContext(),"Acceso concedido",Toast.LENGTH_SHORT).show();
                        Generica.dniUsuario = DNI;
                        FragmentListaProductos fragmentListaProductos = FragmentListaProductos.newInstance();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmetPrincipal,fragmentListaProductos).addToBackStack(null).commit();
                    }else{
                        Toast.makeText(getContext(),"No existe ningun usuario con ese DNI y contraseña",Toast.LENGTH_SHORT).show();
                    }
                }
            }
            break;

            case R.id.textViewRegistrarse:
                FragmentRegistro fragmentRegistro = FragmentRegistro.newInstance();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmetPrincipal,fragmentRegistro).addToBackStack(null).commit();
            break;
        }
    }
}