package es.iesnervion.aruiz.boletin31;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import es.iesnervion.aruiz.boletin31.databinding.ActivityActividad2Binding;

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

    @SuppressLint("ResourceAsColor")
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