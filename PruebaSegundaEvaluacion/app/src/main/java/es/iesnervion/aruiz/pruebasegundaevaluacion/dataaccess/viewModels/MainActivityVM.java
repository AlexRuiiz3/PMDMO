package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.UsuarioBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.repositorio.RepositorioProducto;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.repositorio.RepositorioUsuario;

public class MainActivityVM extends ViewModel {

    private MutableLiveData<String> dniUsuario;

    private MutableLiveData<List<ProductoBO>> listadoProductos;
    private MutableLiveData<List<String>> listadoNombreCategorias;

    public MutableLiveData<String> getDniUsuario() {
        if(dniUsuario == null){
            dniUsuario = new MutableLiveData<>();
        }
        return dniUsuario;
    }

    public MutableLiveData<List<ProductoBO>> getListadoProductos(){
        if(listadoProductos == null){
            listadoProductos = new MutableLiveData<>();
        }
        return listadoProductos;
    }

    public MutableLiveData<List<String>> getListadoNombreCategorias(){
        if(listadoNombreCategorias == null){
            listadoNombreCategorias = new MutableLiveData<>();
        }
        return listadoNombreCategorias;
    }

    //INSERTS
    public void insertarUsuario(UsuarioBO usuarioBO){
        RepositorioUsuario.insertarUsuario(usuarioBO);
    }

    public void insertarProductos(List<ProductoBO> productos){
        RepositorioProducto.insertarProductos(productos);
    }

    //SELECTS
    public void cargarProductos(){
        listadoProductos.postValue(RepositorioProducto.obtenerProductos());
    }
    public void cargarProductosDeCategoria(String nombreCategoria){
        listadoProductos.postValue(RepositorioProducto.obtenerProductosDeCategoria(nombreCategoria));
    }

    public void cargarNombreCategorias(){
        listadoNombreCategorias.postValue(RepositorioProducto.obtenerCategorias());
    }

    public boolean comprobarSiExisteUsuario(String DNI, String contrasenha){
         return RepositorioUsuario.comprobarSiExisteDNIUsuario(DNI, contrasenha);
    }

    public boolean comprobarSiExisteUsuario(String DNI){
        return RepositorioUsuario.comprobarSiExisteDNIUsuario(DNI);
    }
}
