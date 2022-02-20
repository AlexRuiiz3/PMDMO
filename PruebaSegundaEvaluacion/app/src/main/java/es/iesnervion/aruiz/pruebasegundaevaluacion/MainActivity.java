package es.iesnervion.aruiz.pruebasegundaevaluacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.viewModels.MainActivityVM;
import es.iesnervion.aruiz.pruebasegundaevaluacion.gestion.Generica;

public class MainActivity extends AppCompatActivity {
    //Para poder ejecutar operaciones en segundo plano
    private final Executor executor = Executors.newSingleThreadExecutor();
    private MainActivityVM mainActivityVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Generica.contextoAplicacion = this;

        mainActivityVM = new ViewModelProvider(this).get(MainActivityVM.class);
        //this.deleteDatabase("Drogueria.db");
        //insertarProductosBBDD();
    }

    private void insertarProductosBBDD(){
        List<ProductoBO> productos = mainActivityVM.obtenerProductos();
        if(productos == null || productos.size() == 0){ //Si no hay productos en la BBDD
            ArrayList<ProductoBO> listaProductos = new ArrayList<>();
            listaProductos.add(new ProductoBO("Heineken pack 12 botellas",7.33,2.44,"Bebidas","Imagen"));
            listaProductos.add(new ProductoBO("Botella de agua 1.5L",0.37,0.25,"Bebidas","Imagen"));
            listaProductos.add(new ProductoBO("Manzanas",0.99,1.69,"Frutas","Imagen"));
            listaProductos.add(new ProductoBO("Platanos de Canarias",3.09,3.09,"Frutas","Imagen"));
            listaProductos.add(new ProductoBO("Ron barcelo",14.30,20.43,"Bebidas","Imagen"));
            listaProductos.add(new ProductoBO("Cacahuetes con miel",0.99,7.92,"Aperitivos","Imagen"));
            listaProductos.add(new ProductoBO("Cereales rellenos de leche",2.19,4.38,"Desayunos","Imagen"));
            listaProductos.add(new ProductoBO("Ambientador Automatico",2.05,8.20,"Ambientadores","Ambientadores"));
            listaProductos.add(new ProductoBO("Palomitas",1.55,5.17,"Aperitivos","Imagen"));
            listaProductos.add(new ProductoBO("Mahou pack 12 latas",8.16,2.06,"Bebidas","Imagen"));
            listaProductos.add(new ProductoBO("Frutos secos",2.79,5.58,"Aperitivos","Imagen"));
            executor.execute(() -> mainActivityVM.insertarProductos(listaProductos));
        }
    }
}