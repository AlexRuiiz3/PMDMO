package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.repositorio;

import java.util.List;
import java.util.concurrent.ExecutionException;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.daos.ProductoDao;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.room.BaseDatosDrogueria;

public class RepositorioProducto {

    private static BaseDatosDrogueria database = BaseDatosDrogueria.getInstance(null); //pasar contexto, guardarlo ebn una calse aux
    private static ProductoDao productoDao;

    public static int insertarProductos(List<ProductoBO> productos){
        int filasInsertadas = 0;
        try {
            filasInsertadas = database.productoDao().insertarProductos(productos).get();
        } catch (ExecutionException | InterruptedException e) {
            //e.printStackTrace();
        }

        return filasInsertadas;
    }
}
