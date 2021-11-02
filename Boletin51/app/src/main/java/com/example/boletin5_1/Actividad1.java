package com.example.boletin5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Actividad1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private TextView textViewSeleccionSpinner;
    private ArrayList<Equipo> equipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        textViewSeleccionSpinner = findViewById(R.id.textViewSeleccionSpinner);

        equipos = new ArrayList<>();
        equipos.add(new Equipo("Sevilla",R.drawable.sevilla));
        equipos.add(new Equipo("Beti",R.drawable.betis));
        equipos.add(new Equipo("VARcelonar",R.drawable.barcelona));
        equipos.add(new Equipo("Rayo",R.drawable.rayo));
        equipos.add(new Equipo("Cadiz",R.drawable.cadiz));
        equipos.add(new Equipo("Celta",R.drawable.celta));
        equipos.add(new Equipo("Sevilla",R.drawable.sevilla));
        equipos.add(new Equipo("Beti",R.drawable.betis));
        equipos.add(new Equipo("VARcelonar",R.drawable.barcelona));
        equipos.add(new Equipo("Rayo",R.drawable.rayo));
        equipos.add(new Equipo("Cadiz",R.drawable.cadiz));
        equipos.add(new Equipo("Celta",R.drawable.celta));

        spinner = findViewById(R.id.spinnerAct1);
        SpinnerAdapter adapter = new SpinnerAdapter(this,R.layout.view_equipo,equipos);
        spinner.setOnItemSelectedListener(this);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        textViewSeleccionSpinner.setText(equipos.get(position).getNombre());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    //Adapter del Spinner
    class SpinnerAdapter<T> extends BaseAdapter {

        private Context context;
        private int resource;
        private ArrayList<T> listaObjetos;

        public SpinnerAdapter(Context context, int resource,ArrayList<T> listaObjetos) {
            this.context = context;
            this.resource = resource;
            this.listaObjetos = listaObjetos;
        }

        @Override
        public int getCount() {
            return listaObjetos.size();
        }

        @Override
        public Object getItem(int position) {
            return listaObjetos.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        //Este metodo es para cambiar la forma en la que se ven las view cuando despliegas la lista
        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            View viewRow = convertView;
            ViewHolder holder;
            TextView textViewEquipo;
            ImageView imageViewEquipo;
            Equipo equipo = (Equipo)(listaObjetos.get(position));

            if(viewRow == null) {
                LayoutInflater inflater = getLayoutInflater();
                viewRow = inflater.inflate(R.layout.view_imagen_equipo, parent, false);

                textViewEquipo = viewRow.findViewById(R.id.viewImagenEquipoEquipo);
                imageViewEquipo = viewRow.findViewById(R.id.viewImagenEquipoImagen);

                holder = new ViewHolder(textViewEquipo, imageViewEquipo);
                viewRow.setTag(holder);

                holder.getTextViewEquipo().setText(equipo.getNombre());
                holder.getImageEquipo().setImageResource(equipo.getImagen());
            }
            return viewRow;
        }

        @Override
        public View getView(int position,View convertView,ViewGroup parent) {
            View viewRow;
            ViewHolder holder;
            TextView textViewEquipo;
            ImageView imageViewEquipo;
            Equipo equipo = (Equipo)(listaObjetos.get(position));

            LayoutInflater inflater = getLayoutInflater();
            viewRow = inflater.inflate(R.layout.view_equipo,parent,false);

            textViewEquipo = viewRow.findViewById(R.id.textViewEquipo);
            imageViewEquipo = viewRow.findViewById(R.id.imageEquipo);

            holder = new ViewHolder(textViewEquipo,imageViewEquipo);
            viewRow.setTag(holder);

            holder.getTextViewEquipo().setText(equipo.getNombre());
            holder.getImageEquipo().setImageResource(equipo.getImagen());

            return viewRow;
        }
    }

    class ViewHolder{
        private TextView textViewEquipo;
        private ImageView imageEquipo;

        public ViewHolder(TextView textViewEquipo, ImageView imageEquipo){
            this.textViewEquipo = textViewEquipo;
            this.imageEquipo=  imageEquipo;
        }

        public TextView getTextViewEquipo() {
            return textViewEquipo;
        }
        public ImageView getImageEquipo() {
            return imageEquipo;
        }
    }
}