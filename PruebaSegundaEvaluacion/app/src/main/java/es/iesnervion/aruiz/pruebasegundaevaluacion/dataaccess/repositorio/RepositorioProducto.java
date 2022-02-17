package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import es.iesnervion.aruiz.pruebasegundaevaluacion.Generica;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.Utilidades.Mapper;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.daos.ProductoDao;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.ProductoDBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.room.BaseDatosDrogueria;

public class RepositorioProducto {

    private static BaseDatosDrogueria database = BaseDatosDrogueria.getInstance(Generica.contextoAplicacion);
    private static ProductoDao productoDao = database.productoDao();//PARA LAS QUERY

    public static void insertarProductos(List<ProductoBO> productos){
        ArrayList<ProductoDBO> productosDBO = new ArrayList<>();
        for (ProductoBO productoBO: productos) {
            productosDBO.add(Mapper.productoBOaDBO(productoBO));
        }
        database.productoDao().insertarProductos(productosDBO);
    }
}
