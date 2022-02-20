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

    public MutableLiveData<String> getDniUsuario() {
        return dniUsuario;
    }

    public void insertarUsuario(UsuarioBO usuarioBO){
        RepositorioUsuario.insertarUsuario(usuarioBO);
    }

    public void insertarProductos(List<ProductoBO> productos){
        RepositorioProducto.insertarProductos(productos);
    }

    public List<ProductoBO> obtenerProductos(){
        return RepositorioProducto.obtenerProductos();
    }

    public boolean comprobarSiExisteUsuario(String DNI, String contrasenha){
         return RepositorioUsuario.comprobarSiExisteDNIUsuario(DNI, contrasenha);
    }

    public boolean comprobarSiExisteUsuario(String DNI){
        return RepositorioUsuario.comprobarSiExisteDNIUsuario(DNI);
    }
}
