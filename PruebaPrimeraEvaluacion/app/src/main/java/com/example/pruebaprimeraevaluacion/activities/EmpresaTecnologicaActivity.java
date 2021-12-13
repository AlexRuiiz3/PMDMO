package com.example.pruebaprimeraevaluacion.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pruebaprimeraevaluacion.R;
import com.example.pruebaprimeraevaluacion.ViewModels.EmpresaTecnologicaActivityVM;
import com.example.pruebaprimeraevaluacion.clasesBasicas.EmpresaTecnologica;

public class EmpresaTecnologicaActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageViewLogo;
    private TextView textViewNombre;
    private TextView textViewTelefono;
    private TextView textViewWeb;
    private TextView textViewLocalizacion;
    private TextView textViewEmail;
    private TextView textViewDireccion;
    private Button buttonGuardarCambios;
    private Button buttonPersonasContacto;

    private EmpresaTecnologica empresaTecnologica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_tecnologica);

        imageViewLogo = findViewById(R.id.imageLogoActivityEmpresaTecnologica);
        textViewNombre = findViewById(R.id.textNombreActivityEmpresaTecnologica);
        textViewTelefono = findViewById(R.id.textTelefonoActivityEmpresaTecnologica);

        textViewWeb = findViewById(R.id.textWebActivityEmpresaTecnologica);
        textViewWeb.setOnClickListener(this);

        textViewLocalizacion = findViewById(R.id.textLocalizacionActivityEmpresaTecnologica);
        textViewLocalizacion.setOnClickListener(this);

        textViewEmail = findViewById(R.id.textViewEmailActivityEmpresaTecnologica);
        textViewEmail.setOnClickListener(this);

        textViewDireccion = findViewById(R.id.textViewDireccionActivityEmpresaTecnologica);

        buttonPersonasContacto = findViewById(R.id.buttonPersonasContactoActivityEmpresaTecnologica);
        buttonPersonasContacto.setOnClickListener(this);
        buttonGuardarCambios = findViewById(R.id.buttonGuardarCambios);
        buttonGuardarCambios.setOnClickListener(this);

        empresaTecnologica = (EmpresaTecnologica) getIntent().getSerializableExtra("EmpresaTecnologica");
        imageViewLogo.setImageResource(empresaTecnologica.getLogo());
        textViewNombre.setText(empresaTecnologica.getNombre());
        textViewTelefono.setText(empresaTecnologica.getTelefono());
        textViewWeb.setText(empresaTecnologica.getWeb());
        textViewLocalizacion.setText(empresaTecnologica.getLocalizacion());
        textViewEmail.setText(empresaTecnologica.getEmail());
        textViewDireccion.setText(empresaTecnologica.getDireccion());

        //EmpresaTecnologicaActivityVM viewModelEmpresaTecnologica = new ViewModelProvider(this).get(EmpresaTecnologicaActivityVM.class);
        //viewModelEmpresaTecnologica.getNombre().observe(this,this::onTextChanged);
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
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("google.streetview:cbll="+textViewLocalizacion.getText().toString()));
                intent.setPackage("com.google.android.apps.maps");
                break;

            case R.id.textViewEmailActivityEmpresaTecnologica:
                Intent intentEmail = new Intent(Intent.ACTION_SENDTO);
                intentEmail.putExtra(Intent.EXTRA_EMAIL,textViewEmail.getText().toString());
                intentEmail.setType("message/rfc822");

                startActivity(Intent.createChooser(intentEmail,"Envia un mensaje"));
                break;

            case R.id.buttonGuardarCambios:

                break;
        }
        if(intent != null){
            startActivity(intent);
        }
    }
}