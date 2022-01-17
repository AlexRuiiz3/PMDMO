package es.iesnervion.aruiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements BotonesFragment.InteracionFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BotonesFragment botonesFragment = new BotonesFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentActivityMain, botonesFragment)
                .addToBackStack(null)
                .commit();

    }
    @Override
    public void interacionFragment(View view) {
            String mensaje = "Soy del boton 1";

        if(view != null && view.getId() == R.id.buttonSegundoMensaje){
            mensaje = "Soy el boton 2";
        }

        MensajeFragment mensajeFragment = MensajeFragment.newInstance(mensaje);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentActivityMain, mensajeFragment)
                .addToBackStack(null).commit();
    }
}