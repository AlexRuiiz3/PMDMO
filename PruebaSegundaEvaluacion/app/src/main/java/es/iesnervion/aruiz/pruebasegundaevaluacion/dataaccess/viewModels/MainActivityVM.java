package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.viewModels;

import androidx.lifecycle.ViewModel;

import java.util.List;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.repositorio.RepositorioProducto;

public class MainActivityVM extends ViewModel {

    private RepositorioProducto producto;

    public static int insertarProductos(List<ProductoBO> productos){
        return RepositorioProducto.insertarProductos(productos);
    }

}
