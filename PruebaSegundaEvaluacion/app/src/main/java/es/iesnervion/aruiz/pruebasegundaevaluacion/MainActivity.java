package es.iesnervion.aruiz.pruebasegundaevaluacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
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
        mainActivityVM.getListadoProductos().observe(this,this::observerListadoProductos);
        mainActivityVM.cargarProductos();
    }

    private void observerListadoProductos(List<ProductoBO> productos) {
        if(productos == null || productos.size() == 0) { //Si no hay productos en la BBDD
            ArrayList<ProductoBO> listaProductos = new ArrayList<>();
            listaProductos.add(new ProductoBO("Heineken pack 12 botellas",23,7.33,2.44,"Bebidas",R.drawable.producto_heineken));
            listaProductos.add(new ProductoBO("Pizza 4 quesos 390g",12,2.25,2.25,"Precocinados",R.drawable.producto_pizza_4_quesos));
            listaProductos.add(new ProductoBO("Palomitas",3,2.64,6.77,"Aperitivos",R.drawable.producto_palomitas));
            listaProductos.add(new ProductoBO("Leche semidesnatada 1.5L",66,1.35,0.90,"Lácteos",R.drawable.producto_leche_semidesnatada));
            listaProductos.add(new ProductoBO("Botella de agua 1.5L",111,0.37,0.25,"Bebidas",R.drawable.producto_botella_de_agua));
            listaProductos.add(new ProductoBO("Yogurt natural Danone",454,1.19,2.48,"Yogures",R.drawable.producto_yogurt_danone));
            listaProductos.add(new ProductoBO("Manzanas",56,0.99,1.69,"Frutas",R.drawable.producto_manzanas));
            listaProductos.add(new ProductoBO("Plátanos de Canarias",2,3.09,3.09,"Frutas",R.drawable.producto_platano));
            listaProductos.add(new ProductoBO("Aceite de oliva virgen extra 1L",87,4.15,4.15,"Alimentacion",R.drawable.producto_aceite_virgen_extra));
            listaProductos.add(new ProductoBO("Ron barcelo",45,14.35,20.43,"Bebidas",R.drawable.producto_ron_barcelo));
            listaProductos.add(new ProductoBO("Cacahuetes con miel",88,0.99,7.92,"Aperitivos",R.drawable.producto_cacahute_con_miel));
            listaProductos.add(new ProductoBO("Caldo de pollo 1L",43,0.72,0.72,"Conservas",R.drawable.producto_caldo_pollo));
            listaProductos.add(new ProductoBO("Tulipán 450g",7,1.95,4.33,"Lácteos",R.drawable.producto_tulipan));
            listaProductos.add(new ProductoBO("Cereales rellenos de leche",3,2.19,4.38,"Desayunos",R.drawable.producto_cereales_rellenos_de_leche));
            listaProductos.add(new ProductoBO("Ambientador automático",54,2.05,8.20,"Ambientadores",R.drawable.producto_ambientador));
            listaProductos.add(new ProductoBO("Tomate frito pack 3 brick",25,0.86,0.74,"Alimentacion",R.drawable.producto_tomate_frito));
            listaProductos.add(new ProductoBO("Mahou pack 12 latas",12,8.16,2.06,"Bebidas",R.drawable.producto_mahou));
            listaProductos.add(new ProductoBO("Cacaolat 1L",52,1.91,1.91,"Lácteos",R.drawable.producto_cacaolat));
            listaProductos.add(new ProductoBO("Frutos secos",9,2.79,5.58,"Aperitivos",R.drawable.producto_frutos_secos));
            listaProductos.add(new ProductoBO("Pasta de dientes Colgate",34,3.09,20.6,"Higiene",R.drawable.producto_pasta_dientes));
            listaProductos.add(new ProductoBO("Natillas Danone Vainilla",23,2.09,4.35,"Yogures",R.drawable.producto_natillas_vainilla));
            listaProductos.add(new ProductoBO("Macarrones 1kg",24,1.12,1.12,"Alimentacion",R.drawable.producto_macarrones));
            listaProductos.add(new ProductoBO("Huevos L 12ud",55,1.65,1.65,"Huevos",R.drawable.producto_huevos));
            listaProductos.add(new ProductoBO("Nuggets 350g",32,4.15,11.86,"Precocinados",R.drawable.producto_nuggets));
            listaProductos.add(new ProductoBO("Chocolate relleno oreo Milka",89,2.63,2.63,"Aperitivos",R.drawable.producto_chocolate_milka));
            executor.execute(() -> mainActivityVM.insertarProductos(listaProductos));
        }
    }
}