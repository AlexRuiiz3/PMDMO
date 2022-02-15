package es.iesnervion.aruiz.pruebasegundaevaluacion.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import org.w3c.dom.Text;

import es.iesnervion.aruiz.pruebasegundaevaluacion.R;
import es.iesnervion.aruiz.pruebasegundaevaluacion.databinding.FragmentPrincipalBinding;

public class FragmentPrincipal extends Fragment implements View.OnClickListener {

    private FragmentPrincipalBinding binding;
    private EditText editTextViewDNI;
    private EditText editTextPassword;
    private MaterialTextView textRegistrarse;
    private MaterialButton buttonInisiarSesion;

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
        View view = binding.getRoot();

        editTextViewDNI = binding.textFieldDNIInicioSesion.getEditText();
        editTextPassword= binding.textFieldPasswordInicioSesion.getEditText();

        buttonInisiarSesion = binding.buttonIniciarSesion;
        buttonInisiarSesion.setOnClickListener(this);

        textRegistrarse = binding.textViewRegistrarse;
        textRegistrarse.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.buttonIniciarSesion:
            if(comprarValidezDNI()){ //Si el DNI es valido
                if(!editTextPassword.getText().toString().trim().equals("") && editTextPassword.getText().toString().length() >= 8){
                    if(true){//TODO Comprobar en la base de datos
                        Toast.makeText(getContext(),"Acceso concedido",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getContext(),"No existe ningun usuario con ese DNI y contraseña",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getContext(),"La contraseña no puede estar vacio, ademas debe tener 8 digitos minimo",Toast.LENGTH_SHORT).show();
                }
            }
            break;

            case R.id.textViewRegistrarse:
                FragmentRegistro fragmentRegistro = FragmentRegistro.newInstance();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmetPrincipal,fragmentRegistro).addToBackStack(null).commit();
            break;
        }
    }

    private boolean comprarValidezDNI(){
        char [] letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        String DNI = editTextViewDNI.getText().toString();
        int numeroDNI = 0;
        boolean valido = false;

        if(!DNI.trim().equals("")){// Si el DNI no esta vacio
            if(DNI.length() == 9) {
                try {
                    numeroDNI = Integer.parseInt(DNI.substring(0,8));
                    if(DNI.charAt(8) == letras[numeroDNI % 23]) {
                        valido = true;
                    }else {
                        Toast.makeText(getContext(),"Letra del DNI no valida",Toast.LENGTH_SHORT).show();
                    }
                }catch(NumberFormatException e) {
                    Toast.makeText(getContext(),"Numeros del DNI no valido",Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(getContext(),"Longitud DNI no valida(Debe ser de 9)",Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getContext(),"DNI no puede estar vacio",Toast.LENGTH_SHORT).show();
        }
        return valido;
    }
}