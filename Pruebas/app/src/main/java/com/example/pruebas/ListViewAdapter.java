package com.example.pruebas;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class ListViewAdapter<T> extends ArrayAdapter<T> {

    private ArrayList<T> nombreImagenes;

    public ListViewAdapter(Context context, int resource, int textViewResourceId, ArrayList<T> objects) {
        super(context, resource, textViewResourceId, objects);
        this.nombreImagenes = objects;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){

        View viewRow = super.getView(position,view,parent); //El getview de arrayadapter es el que pone el texto, las imagenes no las puede getionar por eso se hace a mano

        ImageView imagen = viewRow.findViewById(R.id.imageView);
        Persona persona = (Persona) nombreImagenes.get(position);

        if (android.R.drawable.btn_star_big_on == persona.getCodigoImagen()) {
            imagen.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (android.R.drawable.arrow_up_float == persona.getCodigoImagen()) {
            imagen.setImageResource(android.R.drawable.arrow_up_float);
        } else if (android.R.drawable.ic_delete == persona.getCodigoImagen()) {
            imagen.setImageResource(android.R.drawable.ic_delete);
        } else {
            imagen.setImageResource(android.R.drawable.ic_menu_gallery);
        }
        return viewRow;
    }
}
