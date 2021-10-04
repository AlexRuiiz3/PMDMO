/*Diseña una aplicacion que permita que el usuario introduzca un texto y ademas
 disponga de dos botones: "Alinear izquierda" y "Alinear derecha", que alineen el
 texto a la izquierda y a la derecha respectivamente.
*/

package es.iesnervion.aruiz.boletin31;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Actividad3Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3);

        Button botonTextIzq = findViewById(R.id.buttonTextAlingLeft),
               botonTextDer = findViewById(R.id.buttonTextAlingRight);

        botonTextIzq.setOnClickListener(this);
        botonTextDer.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        EditText editText = findViewById(R.id.editTextAlign);

        switch (view.getId()){
            case R.id.buttonTextAlingLeft:
                editText.setGravity(Gravity.START);
            break;

            case R.id.buttonTextAlingRight:
                editText.setGravity(Gravity.END);
            break;
        }


    }
}