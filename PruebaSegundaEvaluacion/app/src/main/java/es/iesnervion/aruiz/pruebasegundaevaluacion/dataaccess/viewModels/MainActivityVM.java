package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.UsuarioBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.repositorio.RepositorioCesta;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.repositorio.RepositorioCestaWithProductos;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.repositorio.RepositorioProducto;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.repositorio.RepositorioUsuario;

public class MainActivityVM extends ViewModel {

    private MutableLiveData<List<ProductoBO>> listadoProductos;
    private MutableLiveData<List<ProductoBO>> listadoProductosCestaUsuario;
    private MutableLiveData<List<String>> listadoNombreCategorias;
    private MutableLiveData<ProductoBO> productoSeleccionado;
    private MutableLiveData<Integer> numeroProductosCesta;

    public MutableLiveData<ProductoBO> getProductoSeleccionado() {
        if(productoSeleccionado == null){
            productoSeleccionado = new MutableLiveData<>();
        }
        return productoSeleccionado;
    }

    public MutableLiveData<List<ProductoBO>> getListadoProductos(){
        if(listadoProductos == null){
            listadoProductos = new MutableLiveData<>();
        }
        return listadoProductos;
    }

    public MutableLiveData<List<ProductoBO>> getListadoProductosCestaUsuario(){
        if(listadoProductosCestaUsuario == null){
            listadoProductosCestaUsuario = new MutableLiveData<>();
        }
        return listadoProductosCestaUsuario;
    }

    public MutableLiveData<List<String>> getListadoNombreCategorias(){
        if(listadoNombreCategorias == null){
            listadoNombreCategorias = new MutableLiveData<>();
        }
        return listadoNombreCategorias;
    }

    public MutableLiveData<Integer> getNumeroProductosCesta() {
        if(numeroProductosCesta == null){
            numeroProductosCesta = new MutableLiveData<>();
        }
        return numeroProductosCesta;
    }
    //INSERTS
    public void insertarUsuario(UsuarioBO usuarioBO){
        RepositorioUsuario.insertarUsuario(usuarioBO);
    }

    public void insertarProductos(List<ProductoBO> productos){
        RepositorioProducto.insertarProductos(productos);
    }
    public void crearCestaUsuario(String dni){
        RepositorioCesta.insertarCesta(dni);
    }

    public boolean insertarProductoEnCesta(String dniUsuario, int codigoProducto){
        return RepositorioCestaWithProductos.insertarProductoEnCesta(dniUsuario,codigoProducto);
    }

    //SELECTS
    public void cargarProductos(){
        listadoProductos.postValue(RepositorioProducto.obtenerProductos());
    }
    public void cargarProductosCestaNoEnviadaUsuario(String dniUsuario){
        listadoProductosCestaUsuario.postValue(RepositorioProducto.obtenerProductosCestaUsuario(dniUsuario));
    }
    public void cargarProductosDeCategoria(String nombreCategoria){
        listadoProductos.postValue(RepositorioProducto.obtenerProductosDeCategoria(nombreCategoria));
    }
    public int obtenerNumeroProductosCesta(String dniUsuario){
        return RepositorioProducto.obtenerProductosCestaUsuario(dniUsuario).size();
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
    public String obtenerEmailUsuario(String dniUsuario){
        return RepositorioUsuario.obtenerEmailUsuairo(dniUsuario);
    }
    public ProductoBO obtenerProducto(ProductoBO productoBO){
        return RepositorioProducto.obtenerProducto(productoBO);
    }
    //Update
    public void actualizarEstadoCesta(String dniUsuario,int estado){
        RepositorioCesta.actualizarEstadoCesta(dniUsuario,estado);
    }
    //Delete
    public void eliminarProductoCesta(String dniUsuario,int codigoProducto){
        RepositorioCestaWithProductos.eliminarProductoEnCesta(dniUsuario, codigoProducto);
    }
}
