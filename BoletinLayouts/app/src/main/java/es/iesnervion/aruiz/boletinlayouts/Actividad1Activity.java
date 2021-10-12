package es.iesnervion.aruiz.boletinlayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Actividad1Activity extends AppCompatActivity implements View.OnClickListener {

    private String valorPrimero = "";
    private String valorSegundo = "";
    private String resultado;
    private char operacion = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1_2);

        Button button1 = findViewById(R.id.buttonNumero1),
               button2 = findViewById(R.id.buttonNumero2),
               button3 = findViewById(R.id.buttonNumero3),
               button4 = findViewById(R.id.buttonNumero4),
               button5 = findViewById(R.id.buttonNumero5),
               button6 = findViewById(R.id.buttonNumero6),
               button7 = findViewById(R.id.buttonNumero7),
               button8 = findViewById(R.id.buttonNumero8),
               button9 = findViewById(R.id.buttonNumero9),
               button0 = findViewById(R.id.buttonNumero0),
               buttonSumar = findViewById(R.id.buttonSumar),
               buttonRestar = findViewById(R.id.buttonRestar),
               buttonDividir = findViewById(R.id.buttonDividir),
               buttonMultiplicar = findViewById(R.id.buttonMultiplicar),
               buttonIgual = findViewById(R.id.buttonIgual),
               buttonBorrarTodo = findViewById(R.id.buttonCE);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonSumar.setOnClickListener(this);
        buttonRestar.setOnClickListener(this);
        buttonDividir.setOnClickListener(this);
        buttonMultiplicar.setOnClickListener(this);
        buttonIgual.setOnClickListener(this);
        buttonBorrarTodo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String numero = "";
        TextView textViewResultado = findViewById(R.id.textViewResultado);;

        switch(view.getId()) {
            case R.id.buttonNumero1:
                numero = "1";
                break;

            case R.id.buttonNumero2:
                numero = "2";
                break;

            case R.id.buttonNumero3:
                numero = "3";
                break;
            case R.id.buttonNumero4:
                numero = "4";
                break;
            case R.id.buttonNumero5:
                numero = "5";
                break;

            case R.id.buttonNumero6:
                numero = "6";
                break;

            case R.id.buttonNumero7:
                numero = "7";
                break;

            case R.id.buttonNumero8:
                numero = "8";
                break;

            case R.id.buttonNumero9:
                numero = "9";
                break;

            case R.id.buttonNumero0:
                numero = "0";
                break;

            case R.id.buttonSumar:
                if (!valorPrimero.equals("")) {
                    operacion = '+';
                }
                break;

            case R.id.buttonRestar:
                if (!valorPrimero.equals("")) {
                    operacion = '-';
                }
                break;

            case R.id.buttonDividir:
                if (!valorPrimero.equals("")) {
                    operacion = '/';
                }
                break;

            case R.id.buttonMultiplicar:
                if (!valorPrimero.equals("")) {
                    operacion = '*';
                }
                break;

            case R.id.buttonIgual:
                if (!valorSegundo.equals("")){
                    switch (operacion) {
                        case '+':
                            resultado = String.valueOf(Integer.parseInt(valorPrimero) + Integer.parseInt(valorSegundo));
                            break;

                        case '-':
                            resultado = String.valueOf(Integer.parseInt(valorPrimero) - Integer.parseInt(valorSegundo));
                            break;

                        case '/':
                            if (Integer.parseInt(valorSegundo) != 0) {
                                resultado = String.valueOf(Integer.parseInt(valorPrimero) / Integer.parseInt(valorSegundo));
                            } else {
                                resultado = "No se puede dividir por cero";
                            }

                            break;

                        case '*':
                            resultado = String.valueOf(Integer.parseInt(valorPrimero) * Integer.parseInt(valorSegundo));
                            break;
                    }
                    valorPrimero = resultado;
                    valorSegundo = "";
                    operacion = ' ';
                }

                textViewResultado.setText(resultado);
            break;

            case R.id.buttonCE:
                valorPrimero = "";
                valorSegundo = "";
                operacion = ' ';
                break;
        }

        if (operacion == ' '){
            valorPrimero += numero;
            textViewResultado.setText(valorPrimero+" "+operacion);
        }else{
            valorSegundo += numero;
            textViewResultado.setText(valorPrimero+" "+operacion+" "+valorSegundo);
        }

    }
}