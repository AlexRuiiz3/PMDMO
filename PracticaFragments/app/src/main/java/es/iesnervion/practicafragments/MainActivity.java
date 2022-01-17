package es.iesnervion.practicafragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Contacto> listaContactos = crearListaConactos();

        FragmentList fragmentList = FragmentList.newInstance(listaContactos);
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentList,fragmentList).commit();

        FragmentContacto fragmentContacto = FragmentContacto.newInstance(listaContactos.get(0));
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentList,fragmentContacto).commit();
    }

    private ArrayList<Contacto> crearListaConactos(){
        ArrayList<Contacto> contactos = new ArrayList<>();
        contactos.add(new Contacto("Contacto 1","apellidos 1","111111111","C/Calle 1"));
        contactos.add(new Contacto("Contacto 2","apellidos 2","222222222","C/Calle 2"));
        contactos.add(new Contacto("Contacto 3","apellidos 3","333333333","C/Calle 3"));
        contactos.add(new Contacto("Contacto 4","apellidos 4","444444444","C/Calle 4"));
        contactos.add(new Contacto("Contacto 5","apellidos 5","555555555","C/Calle 5"));
        contactos.add(new Contacto("Contacto 6","apellidos 6","666666666","C/Calle 6"));
        contactos.add(new Contacto("Contacto 7","apellidos 7","777777777","C/Calle 7"));
        contactos.add(new Contacto("Contacto 8","apellidos 8","888888888","C/Calle 8"));
        return contactos;
    }
}