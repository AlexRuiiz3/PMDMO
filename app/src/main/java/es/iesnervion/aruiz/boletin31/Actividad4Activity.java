/*
Crea una galeria de imagenes basicas. Que muestre dos botones
"Siguiente" y "Anterior", que al ser pulsados muestren la imagen siguiente o la anterior
 */
package es.iesnervion.aruiz.boletin31;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class Actividad4Activity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Integer> idImagenes = new ArrayList<>(3);
    private int posicionImagenActual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad4);
        idImagenes.add(R.drawable.imagen1);
        idImagenes.add(R.drawable.imagen2);
        idImagenes.add(R.drawable.imagen3);

        Button volverAtras = findViewById(R.id.buttonPasarImagenIzq),
               pasarFoto = findViewById(R.id.buttonPasarImagenDere);

        volverAtras.setOnClickListener(this);
        pasarFoto.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        ImageView imagen = findViewById(R.id.imageViewAct4);
        switch(v.getId()){

            case R.id.buttonPasarImagenIzq:
                posicionImagenActual--;
                if(posicionImagenActual < 0){
                    posicionImagenActual = idImagenes.size()-1;
                }
            break;

            case R.id.buttonPasarImagenDere:
                posicionImagenActual++;
                if(posicionImagenActual > idImagenes.size()-1){
                    posicionImagenActual = 0;
                }
            break;
        }
        imagen.setImageResource(idImagenes.get(posicionImagenActual));
    }
}