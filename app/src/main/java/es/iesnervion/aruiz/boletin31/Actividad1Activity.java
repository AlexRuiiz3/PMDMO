package es.iesnervion.aruiz.boletin31;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Actividad1Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText1;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        editText1 = findViewById(R.id.editTextNumeroSumar1);
        editText2 = findViewById(R.id.editTextNumeroSumar2);

        Button botonSumar = findViewById(R.id.buttonSumarActividad1);

        botonSumar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String textoEditText1 = editText1.getText().toString();
        String textoEditText2 = editText2.getText().toString();
        String resultado = "Sin resultados";

        TextView textResultado = findViewById(R.id.textResultado);

        if (!textoEditText1.equals("") && !textoEditText2.equals("")) {
            resultado = String.valueOf(Integer.parseInt(textoEditText1) + Integer.parseInt(textoEditText2));
        }

        textResultado.setText(getString(R.string.Resultado)+resultado);

    }
}