package es.iesnervion.aruiz.boletinlayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

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


        listaElementos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,valores));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    texto.setText(valores.get(position));

    }
}