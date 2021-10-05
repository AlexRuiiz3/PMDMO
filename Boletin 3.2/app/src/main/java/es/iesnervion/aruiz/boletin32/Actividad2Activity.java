package es.iesnervion.aruiz.boletin32;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Actividad2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        RadioButton radioButtonSuma = findViewById(R.id.radioButtonSumar),
                    radioButtonRestar = findViewById(R.id.radioButtonRestar),
                    radioButtonMultiplicar = findViewById(R.id.radioButtonMultiplicar),
                    radioButtonDividir = findViewById(R.id.radioButtonDividir);


        radioButtonSuma.setOnClickListener(this);
        radioButtonRestar.setOnClickListener(this);
        radioButtonMultiplicar.setOnClickListener(this);
        radioButtonDividir.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText editTextPrimerNumero = findViewById(R.id.editTextPrimerNumero),
                 editTextSegundoNumero = findViewById(R.id.editTextSegundoNumero);

        TextView textResultado = findViewById(R.id.textViewResultado);

        int primerNumero = 0,segundoNumero = 0,resultado = 0;

        if(!editTextPrimerNumero.getText().toString().equals("") &&
                !editTextSegundoNumero.getText().toString().equals("")
        ) {
            primerNumero = Integer.parseInt(editTextPrimerNumero.getText().toString());
            segundoNumero = Integer.parseInt(editTextSegundoNumero.getText().toString());

            switch (view.getId()) {

                case R.id.radioButtonSumar:
                    resultado = primerNumero + segundoNumero;
                break;

                case R.id.radioButtonRestar:
                    resultado = primerNumero - segundoNumero;
                break;

                case R.id.radioButtonMultiplicar:
                    resultado = primerNumero * segundoNumero;
                break;

                case R.id.radioButtonDividir:
                    if(segundoNumero != 0){
                        resultado = primerNumero / segundoNumero;
                    }
                break;

            }
        }

        textResultado.setText(String.valueOf(resultado));
    }

}