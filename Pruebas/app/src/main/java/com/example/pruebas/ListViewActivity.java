package com.example.pruebas;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
//Clase list con adapter arrayAdapter
public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private TextView texto;
    private ListView listaElementos;
    private ArrayList<String> valores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        texto = findViewById(R.id.textView);
        listaElementos = findViewById(R.id.listViewElementos);

        valores.add("Ordenador");
        valores.add("Ordenador2");
        valores.add("Ordenador3");
        valores.add("Ordenador4");
        valores.add("Ordenador5");
        valores.add("Ordenador6");
        valores.add("Ordenador7");
        valores.add("Ordenador8");
        valores.add("Ordenador9");
        valores.add("Ordenador10");
        valores.add("Ordenador11");

        listaElementos.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,valores));
        listaElementos.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        texto.setText(valores.get(position));
    }
}