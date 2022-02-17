package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.repositorio.RepositorioProducto;

public class MainActivityVM extends ViewModel {

    public MutableLiveData<Integer> insertarProductos(List<ProductoBO> productos){
        RepositorioProducto.insertarProductos(productos);
        MutableLiveData<Integer> a = new MutableLiveData<>();
        a.postValue(0);
        return a;
    }
}
