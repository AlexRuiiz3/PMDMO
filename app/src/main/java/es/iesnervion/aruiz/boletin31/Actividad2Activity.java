/*Haz una aplicacion que permita que el usuario introduzca un texto
 y que disponga de tres botones para cambiar el color del texto a azul, rojo y verde.
*/
package es.iesnervion.aruiz.boletin31;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Actividad2Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        editText = findViewById(R.id.editTextActividad2);

        Button botonAzul = findViewById(R.id.buttonAzulAct2);
        Button botonRojo = findViewById(R.id.buttonRojoAct2);
        Button botonVerde = findViewById(R.id.buttonVerdeAct2);

        botonAzul.setOnClickListener(this);
        botonRojo.setOnClickListener(this);
        botonVerde.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.buttonAzulAct2:
                editText.setTextColor(getResources().getColor(R.color.blue));
                break;

            case R.id.buttonRojoAct2:
                editText.setTextColor(getResources().getColor(R.color.red));
                break;

            case R.id.buttonVerdeAct2:
                editText.setTextColor(getResources().getColor(R.color.green));
                break;
        }
    }
}