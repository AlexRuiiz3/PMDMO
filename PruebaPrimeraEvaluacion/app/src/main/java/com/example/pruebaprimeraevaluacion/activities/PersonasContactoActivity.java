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

        //Se obtienen las personas que vienen de otra actividad
        ArrayList<Persona> listaPersonas = (ArrayList<Persona>) getIntent().getSerializableExtra("ListPersonasContacto");

        Spinner spinnerPersonas = findViewById(R.id.spinnerPersonasContacto);

        SpinnerAdapter adapter = new SpinnerAdapter(listaPersonas);
        spinnerPersonas.setAdapter(adapter);
        spinnerPersonas.setOnItemSelectedListener(this);
    }

    /*
     * Cabecera:  public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
     * Comentario: Este metodo se encarga de realizar una tarea cuando un elemento es seleccionado.
     *             En este caso al seleccionar un elemento de un spinner se modificara el texto de un
     *             texView con los datos de un objeto de tipo Persona.
     * Entradas: AdapterView<?> adapterView, View view, int position, long l
     * Salidas: Ninguna
     * Precondiciones: Ninguna
     * Postcondicones: Se modificara el texto de varios texView con los valores de algunos atributos de
     *                 un objeto Persona seleccionado.
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Persona persona = (Persona) adapterView.getAdapter().getItem(position);

        textViewTelefono.setText(persona.getTelefono());
        textViewCargo.setText(persona.getCargo());
        textViewEmail.setText(persona.getEmail());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    //Adapter del spinner
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
    //ViewHolder usado en el spinner
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