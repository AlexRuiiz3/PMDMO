package es.iesnervion.aruiz.pruebasegundaevaluacion;

import static io.reactivex.internal.schedulers.SchedulerPoolFactory.start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.AsyncTask;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.viewModels.MainActivityVM;

public class MainActivity extends AppCompatActivity {

    private MainActivityVM mainActivityVM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Generica.contextoAplicacion = this;

        mainActivityVM = new ViewModelProvider(this).get(MainActivityVM.class);
        this.deleteDatabase("Drogueria.db");
        fetchData();
    }
//Para poder ejecutar operaciones en segundo plano
    private final Executor executor = Executors.newSingleThreadExecutor();
    public void fetchData(){
        ArrayList<ProductoBO> listaProductos = new ArrayList<>();
        listaProductos.add(new ProductoBO(001,"Producto",10,1,"Categoria","Imagen"));

        executor.execute(() -> mainActivityVM.insertarProductos(listaProductos));
    }
}