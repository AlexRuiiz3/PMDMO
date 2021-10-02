/*
Crear una aplicacion en la que el usuairo escriba un texto y tenga debajo dos botones
uno para aumentar el texto(+) y otra para disminuirlo(-)

 */
package es.iesnervion.aruiz.boletin31;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Actividad5Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad5);

        Button botonAumentoTexto = findViewById(R.id.buttonAumentoTexto),
               botonDisminuir = findViewById(R.id.buttonDisminuirTexto);

        botonAumentoTexto.setOnClickListener(this);
        botonDisminuir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        EditText editTextUsuario = findViewById(R.id.editTextUsuarioAct5);
        float tamanhoTexto = editTextUsuario.getTextSize();

        if(!editTextUsuario.getText().toString().equals("")) {
            switch (v.getId()) {

                case R.id.buttonAumentoTexto:
                    if (tamanhoTexto < 100) {
                        tamanhoTexto++;
                    }
                break;

                case R.id.buttonDisminuirTexto:
                    if (tamanhoTexto > 1) {
                        tamanhoTexto--;
                    }
                break;
            }

            editTextUsuario.setTextSize(TypedValue.COMPLEX_UNIT_PX,tamanhoTexto);
        }
    }
}