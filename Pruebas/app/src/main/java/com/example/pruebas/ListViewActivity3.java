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
    private ArrayList<String> valores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        texto = findViewById(R.id.textView);
        listaElementos = findViewById(R.id.listViewElementos);

        valores.add("Estrella");
        valores.add("Ordenador2");
        valores.add("Ordenador3");
        valores.add("Delete");
        valores.add("Ordenador5");
        valores.add("Flecha");
        valores.add("Ordenador7");
        valores.add("Ordenador8");
        valores.add("Ordenador9");
        valores.add("Ordenador10");
        valores.add("Ordenador11");
        valores.add("Estrella");
        valores.add("Ordenador2");
        valores.add("Ordenador3");
        valores.add("Delete");
        valores.add("Ordenador5");
        valores.add("Flecha");
        valores.add("Ordenador7");

        listaElementos.setAdapter(new ListViewAdapter(this,R.layout.viewpersonalizada,R.id.textViewPersonalizada,valores));
        listaElementos.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        texto.setText(valores.get(position));
    }
}