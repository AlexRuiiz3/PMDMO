package com.example.pruebaprimeraevaluacion.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pruebaprimeraevaluacion.R;
import com.example.pruebaprimeraevaluacion.clasesBasicas.Persona;

import java.util.ArrayList;

public class PersonasContactoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerPersonas;
    private TextView textViewTelefono;
    private TextView textViewCargo;
    private TextView textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas_contacto);

        textViewTelefono = findViewById(R.id.textViewTelefonoPersona);
        textViewCargo = findViewById(R.id.textViewCargoPersona);
        textViewEmail = findViewById(R.id.textViewEmailPersona);

        ArrayList<Persona> listaPersonas = (ArrayList<Persona>) getIntent().getSerializableExtra("ListPersonasContacto");

        spinnerPersonas = findViewById(R.id.spinnerPersonasContacto);

        SpinnerAdapter adapter = new SpinnerAdapter(listaPersonas);
        spinnerPersonas.setAdapter(adapter);
        spinnerPersonas.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        if(adapterView != null) {
            Persona persona = (Persona) adapterView.getAdapter().getItem(position);

            textViewTelefono.setText(persona.getTelefono());
            textViewCargo.setText(persona.getCargo());
            textViewEmail.setText(persona.getEmail());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    class SpinnerAdapter extends BaseAdapter{

        private ArrayList<Persona> listaPersonas;

        public SpinnerAdapter(ArrayList<Persona> listaPersonas){
            this.listaPersonas = listaPersonas;
        }
        @Override
        public int getCount() {
            return listaPersonas.size();
        }

        @Override
        public Object getItem(int position) {
            return listaPersonas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view,  ViewGroup viewGroup) {
            View viewRow = view;
            TextView textViewNombre;
            TextView textViewApellidos;
            Persona persona = (Persona) getItem(position);
            ViewHolder holder;

            if(viewRow == null){
                viewRow = getLayoutInflater().inflate(R.layout.persona_contacto,viewGroup,false);
                textViewNombre = viewRow.findViewById(R.id.textViewNombrePersona);
                textViewApellidos = viewRow.findViewById(R.id.textViewApellidosPersona);
                holder = new ViewHolder(textViewNombre,textViewApellidos);
                viewRow.setTag(holder);
            }else{
                holder = (ViewHolder) viewRow.getTag();
            }
            holder.getTextViewNombre().setText(persona.getNombre());
            holder.getTextViewApellidos().setText(persona.getApellidos());
            return viewRow;
        }
    }

    class ViewHolder{
        private TextView textViewNombre;
        private TextView textViewApellidos;

        public ViewHolder(TextView textViewNombre, TextView textViewApellidos) {
            this.textViewNombre = textViewNombre;
            this.textViewApellidos = textViewApellidos;
        }
        public TextView getTextViewNombre() {
            return textViewNombre;
        }

        public TextView getTextViewApellidos() {
            return textViewApellidos;
        }

    }
}