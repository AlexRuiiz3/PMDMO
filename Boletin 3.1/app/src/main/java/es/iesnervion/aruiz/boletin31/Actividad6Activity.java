/*
   Crear un aplicacion que tenga una imagen que al ser puldada cambie por otra.
 */
package es.iesnervion.aruiz.boletin31;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Actividad6Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton cambiarImagenButton;
    private boolean activado = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad6);

        cambiarImagenButton = findViewById(R.id.imageButtonCambiarImagenAct6);

        cambiarImagenButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(!activado){
            cambiarImagenButton.setImageResource(R.drawable.sonidoon);
            activado = true;
        }else{
            cambiarImagenButton.setImageResource(R.drawable.sonidooff);
            activado = false;
        }

    }
}