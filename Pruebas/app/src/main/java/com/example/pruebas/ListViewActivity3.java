package com.example.pruebas;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
//Clase con vista personalizada
public class ListViewActivity3 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private TextView texto;
    private ListView listaElementos;
    private ArrayList<Persona> valores = new ArrayList<Persona>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        texto = findViewById(R.id.textView);
        listaElementos = findViewById(R.id.listViewElementos);

        valores.add(new Persona("Persona1",android.R.drawable.btn_star_big_on));
        valores.add(new Persona("Persona2",android.R.drawable.arrow_up_float));
        valores.add(new Persona("Persona3",0));
        valores.add(new Persona("Persona4",android.R.drawable.arrow_up_float));
        valores.add(new Persona("Persona3",0));
        valores.add(new Persona("Persona6",0));
        valores.add(new Persona("Persona1",android.R.drawable.arrow_up_float));
        valores.add(new Persona("Persona8",0));
        valores.add(new Persona("Persona9",0));
        valores.add(new Persona("Persona2",0));
        valores.add(new Persona("Persona3",android.R.drawable.ic_delete));
        valores.add(new Persona("Persona12",0));
        valores.add(new Persona("Persona13",android.R.drawable.ic_delete));
        valores.add(new Persona("Persona14",0));

        listaElementos.setAdapter(new ListViewAdapter(this,R.layout.viewpersonalizada,R.id.textViewPersonalizada,valores));
        listaElementos.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        texto.setText(valores.get(position).toString());
    }
}