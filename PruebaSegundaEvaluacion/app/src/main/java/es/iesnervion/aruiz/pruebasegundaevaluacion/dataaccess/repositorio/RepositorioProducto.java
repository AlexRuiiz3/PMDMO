package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.repositorio;

import java.util.ArrayList;
import java.util.List;

import es.iesnervion.aruiz.pruebasegundaevaluacion.gestion.Generica;
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

    public static List<ProductoBO> obtenerProductos(){
        List<ProductoDBO> productosDBO = productoDao.obtenerProductos().blockingFirst();
        ArrayList<ProductoBO> productosBO = new ArrayList<>();
        if(productosDBO != null){
            for (ProductoDBO productoDBO: productosDBO) {
                productosBO.add(new ProductoBO(productoDBO));
            }
        }
        return productosBO;
    }

    public static ProductoBO obtenerProducto(ProductoBO productoBO){
        List<ProductoDBO> productosDBO = productoDao.obtenerProducto(productoBO.getCodigo(),productoBO.getNombre()).blockingFirst();
        ArrayList<ProductoBO> productosBO = new ArrayList<>();
        ProductoBO productoSolicitado = new ProductoBO();
        if(productosDBO != null && productosDBO.size() > 0){
            for (ProductoDBO productoDBO: productosDBO) {
                productosBO.add(new ProductoBO(productoDBO));
            }
            productoSolicitado = productosBO.get(0);
        }
        return productoSolicitado;
    }

    public static List<ProductoBO> obtenerProductosDeCategoria(String nombreCategoria){
        List<ProductoDBO> productosDBO = productoDao.obtenerProductosDeCategoria(nombreCategoria).blockingFirst();
        ArrayList<ProductoBO> productosBO = new ArrayList<>();
        if(productosDBO != null){
            for (ProductoDBO productoDBO: productosDBO) {
                productosBO.add(new ProductoBO(productoDBO));
            }
        }
        return productosBO;
    }

    public static List<String> obtenerCategorias(){
        List<String> nombresCategorias = productoDao.obtenerNombreCategorias().blockingFirst();
        return nombresCategorias;
    }
}
