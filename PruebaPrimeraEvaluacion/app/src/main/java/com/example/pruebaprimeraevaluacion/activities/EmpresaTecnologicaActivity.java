package com.example.pruebaprimeraevaluacion.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pruebaprimeraevaluacion.R;
import com.example.pruebaprimeraevaluacion.ViewModels.EmpresaTecnologicaActivityVM;
import com.example.pruebaprimeraevaluacion.clasesBasicas.EmpresaTecnologica;

public class EmpresaTecnologicaActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageViewLogo;
    private TextView textViewNombre;
    private EditText editTextViewTelefono;
    private TextView textViewWeb;
    private TextView textViewLocalizacion;
    private TextView textViewEmail;
    private EditText editTextViewDireccion;
    private ImageButton buttonGuardarCambios;
    private Button buttonPersonasContacto;
    private EmpresaTecnologicaActivityVM viewModelEmpresaTecnologica;
    private TextView textViewResultadosGuardados;
    private TextView textViewResultadosDireccion;
    private TextView textViewResultadosTelefono;

    private EmpresaTecnologica empresaTecnologica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_tecnologica);

        imageViewLogo = findViewById(R.id.imageLogoActivityEmpresaTecnologica);
        textViewNombre = findViewById(R.id.textNombreActivityEmpresaTecnologica);
        editTextViewTelefono = findViewById(R.id.editTextTelefonoActivityEmpresaTecnologica);

        //TextView Resultados
        textViewResultadosGuardados = findViewById(R.id.textViewResultadosGuardados);
        textViewResultadosDireccion = findViewById(R.id.textViewResultadoDireccion);
        textViewResultadosTelefono = findViewById(R.id.textViewResultadoTelefono);

        //Web
        textViewWeb = findViewById(R.id.textWebActivityEmpresaTecnologica);
        textViewWeb.setOnClickListener(this);

        //Localizacion
        textViewLocalizacion = findViewById(R.id.textLocalizacionActivityEmpresaTecnologica);
        textViewLocalizacion.setOnClickListener(this);

        //Email
        textViewEmail = findViewById(R.id.textViewEmailActivityEmpresaTecnologica);
        textViewEmail.setOnClickListener(this);

        //Direccion
        editTextViewDireccion = findViewById(R.id.editTextViewDireccionActivityEmpresaTecnologica);

        //Botones
        buttonPersonasContacto = findViewById(R.id.buttonPersonasContactoActivityEmpresaTecnologica);
        buttonPersonasContacto.setOnClickListener(this);
        buttonGuardarCambios = findViewById(R.id.buttonGuardarCambios);
        buttonGuardarCambios.setOnClickListener(this);

        //Inicializacion contenido componentes
        empresaTecnologica = (EmpresaTecnologica) getIntent().getSerializableExtra("EmpresaTecnologica");
        imageViewLogo.setImageResource(empresaTecnologica.getLogo());
        textViewNombre.setText(empresaTecnologica.getNombre());
        editTextViewTelefono.setText(empresaTecnologica.getTelefono());
        textViewWeb.setText(empresaTecnologica.getWeb());
        textViewLocalizacion.setText(empresaTecnologica.getLocalizacion());
        textViewEmail.setText(empresaTecnologica.getEmail());
        editTextViewDireccion.setText(empresaTecnologica.getDireccion());

        //ViewModel
        viewModelEmpresaTecnologica = new ViewModelProvider(this).get(EmpresaTecnologicaActivityVM.class);
        viewModelEmpresaTecnologica.getEmpresa().observe(this,this::onTextChanged);
    }

    private void onTextChanged(EmpresaTecnologica empresa) {
        editTextViewDireccion.setText(empresa.getDireccion());
        editTextViewTelefono.setText(empresa.getTelefono());
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){

            case R.id.buttonPersonasContactoActivityEmpresaTecnologica:
                if(empresaTecnologica.getPersonasContacto().size() > 0) {//Si la empresa tiene personas de contacto
                    intent = new Intent(this, PersonasContactoActivity.class);
                    intent.putExtra("ListPersonasContacto", empresaTecnologica.getPersonasContacto());
                }
                break;

            case R.id.textWebActivityEmpresaTecnologica:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(textViewWeb.getText().toString()));
                break;

            case R.id.textLocalizacionActivityEmpresaTecnologica:
                String[] partesLocalizacion = textViewLocalizacion.getText().toString().split(",");
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+partesLocalizacion[0]+","+partesLocalizacion[1]+"(Label)"));
                intent.setPackage("com.google.android.apps.maps");
                break;

            case R.id.textViewEmailActivityEmpresaTecnologica:
                Intent intentEmail = new Intent(Intent.ACTION_SEND);
                intentEmail.putExtra(Intent.EXTRA_EMAIL,textViewEmail.getText().toString());
                intentEmail.setType("message/rfc822");

                startActivity(Intent.createChooser(intentEmail,"Envia un mensaje"));
                break;

            case R.id.buttonGuardarCambios:
                empresaTecnologica.setDireccion(editTextViewDireccion.getText().toString());
                empresaTecnologica.setTelefono(editTextViewTelefono.getText().toString());
                viewModelEmpresaTecnologica.getEmpresa().postValue(empresaTecnologica);
                //Resultados
                textViewResultadosGuardados.setText(R.string.resultados_guardados);
                textViewResultadosDireccion.setText(R.string.direccion+" " +editTextViewDireccion.getText().toString());
                textViewResultadosTelefono.setText(R.string.telefono+" " +editTextViewTelefono.getText().toString());

                break;
        }
        if(intent != null){
            startActivity(intent);
        }
    }
}