package es.iesnervion.aruiz.pruebasegundaevaluacion.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import es.iesnervion.aruiz.pruebasegundaevaluacion.R;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.UsuarioBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.viewModels.MainActivityVM;
import es.iesnervion.aruiz.pruebasegundaevaluacion.databinding.FragmentRegistroBinding;
import es.iesnervion.aruiz.pruebasegundaevaluacion.gestion.Generica;
import es.iesnervion.aruiz.pruebasegundaevaluacion.gestion.Utilidades;

public class FragmentRegistro extends Fragment implements View.OnClickListener {

    private FragmentRegistroBinding binding;
    private MainActivityVM mainActivityVM;
    private EditText editTextDNI;
    private EditText editTextNombre;
    private EditText editTextApellidos;
    private EditText editTextContrasenha;
    private EditText editTextContrasenhaConfirmacion;
    private EditText editEmail;
    private EditText editTextDireccion;
    private EditText editTextTelefono;
    private MaterialButton buttonIniciarSesion;
    private final Executor executor = Executors.newSingleThreadExecutor();

    public FragmentRegistro() {

    }

    public static FragmentRegistro newInstance() {
        FragmentRegistro fragment = new FragmentRegistro();
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
        binding = FragmentRegistroBinding.inflate(getLayoutInflater());
        mainActivityVM = new ViewModelProvider(this).get(MainActivityVM.class);

        View view = binding.getRoot();

        editTextDNI = binding.textFieldDNIRegistro.getEditText();
        editTextNombre = binding.textFieldNombreRegistro.getEditText();
        editTextApellidos = binding.textFieldApellidoRegistro.getEditText();
        editTextContrasenha = binding.textFieldContrasenhaRegistro.getEditText();
        editTextContrasenhaConfirmacion = binding.textFieldContrasenhaConfirmacionRegistro.getEditText();
        editEmail = binding.textFieldEmailRegistro.getEditText();
        editTextDireccion = binding.textFieldDireccionRegistro.getEditText();
        editTextTelefono = binding.textFieldTelefonoRegistro.getEditText();

        buttonIniciarSesion = binding.buttonRegistrarRegistro;
        buttonIniciarSesion.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        String dni = editTextDNI.getText().toString();
        String nombre = editTextNombre.getText().toString();
        String apellidos = editTextApellidos.getText().toString();
        String contrasenha = editTextContrasenha.getText().toString();
        String email = editEmail.getText().toString();
        String direccion = editTextDireccion.getText().toString();
        String telefono = editTextTelefono.getText().toString();
        if (validarDNI()) {
            if (Utilidades.validarCadena(nombre)) {
                if (apellidos.split(" ").length > 0 && Utilidades.validarCadena(apellidos.split(" ")[0])) {
                    if (validarContrasenhas()) {
                        if (validarEmail()) {
                            if (validarTelefono()) {
                                String segundoApellido = apellidos.split(" ").length > 1 ? apellidos.split(" ")[1] : "";
                                executor.execute(() -> mainActivityVM.insertarUsuario(new UsuarioBO(dni, nombre, contrasenha,
                                        direccion, apellidos.split(" ")[0], segundoApellido, email, telefono)
                                ));
                                Toast.makeText(getContext(), "Registro completado", Toast.LENGTH_SHORT).show();
                                Generica.dniUsuario = dni;
                                FragmentListaProductos fragmentListaProductos = FragmentListaProductos.newInstance();
                                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmetPrincipal, fragmentListaProductos).commit();
                            }
                        }
                    }
                } else {
                    Toast.makeText(getContext(), "El primer apellido no puede estar vacio", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(getContext(), "El nombre no puede estar vacio", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean validarDNI(){
        String dni = editTextDNI.getText().toString();
        boolean dniValido = false;
        if(Utilidades.comprarValidezDNI(dni,getContext())){ //Si el DNI es valido, se procede a comprobar si existe en la BBDD
            if(!mainActivityVM.comprobarSiExisteUsuario(dni)){//Si no existe ningun usuario con ese dni
                dniValido = true;
            }else{
                Toast.makeText(getContext(),"Ya existe un usuario con ese DNI",Toast.LENGTH_SHORT).show();
            }
        }
        return dniValido;
    }

    private boolean validarContrasenhas(){
        String contrasenha = editTextContrasenha.getText().toString();
        String confirmacionContrasenha = editTextContrasenhaConfirmacion.getText().toString();
        boolean contrasenhaValida = false;
        if(Utilidades.validarContrasenha(contrasenha,getContext())) {
            if(contrasenha.equals(confirmacionContrasenha)){
                contrasenhaValida = true;
            }else{
                Toast.makeText(getContext(),"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
            }
        }
        return contrasenhaValida;
    }

    private boolean validarEmail(){
        String email = editEmail.getText().toString();
        boolean emailValido = false;
        if(email.contains("@gmail.com") || email.contains("@gmail.es")){
            emailValido = true;
        }else{
            Toast.makeText(getContext(),"El email debe termina en @gmail.com o @gmail.es",Toast.LENGTH_SHORT).show();
        }
        return emailValido;
    }

    private boolean validarTelefono(){
        String telefono = editTextTelefono.getText().toString();
        int numeroTelefono;
        boolean telefonoValido = false;
        if(telefono.trim().equals("")){ //Esto es porque el telefono es opcional, por lo tanto si el telefono esta vacio, se considera valido
            telefonoValido = true;
        }else{
            if (telefono.length() == 9) {
                try {
                    numeroTelefono = Integer.parseInt(telefono);
                    if(numeroTelefono > 0) {
                        telefonoValido = true;
                    }else {
                        Toast.makeText(getContext(),"El telefono no puede tener valores negativos",Toast.LENGTH_SHORT).show();
                    }
                }catch(NumberFormatException e) {
                    Toast.makeText(getContext(),"El telefono debe contener solo numeros",Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(getContext(),"El telefono no tiene 9 digitos",Toast.LENGTH_SHORT).show();
            }
        }
        return telefonoValido;
    }

}