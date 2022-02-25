package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.repositorio;

import java.util.List;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.relaciones.CestaProductoCrossRef;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.room.BaseDatosDrogueria;
import es.iesnervion.aruiz.pruebasegundaevaluacion.gestion.Generica;

public class RepositorioCestaWithProductos {

    private static BaseDatosDrogueria database = BaseDatosDrogueria.getInstance(Generica.contextoAplicacion);


    public static boolean insertarProductoEnCesta(String dniUsuario, int codigoProducto){
        boolean insertado = false;
        boolean productoYaInsertado = false;
        List<ProductoBO> productosUsuario = RepositorioProducto.obtenerProductosCestaUsuario(dniUsuario);

        for(int i = 0; i < productosUsuario.size() && !productoYaInsertado; i++){
            if(productosUsuario.get(i).getCodigo() == codigoProducto){
                productoYaInsertado = true;
            }
        }

        if(!productoYaInsertado){ //Si el producto no se ha insertado
            int codigoCesta = RepositorioCesta.obtenerCodigoCestaNoEnviadaUsuario(dniUsuario);
            if(codigoCesta == 0){//Significa que no hay ninguna cesta con estado sin enviar
                RepositorioCesta.insertarCesta(dniUsuario); //Se crea una nueva cesta para que se añadan los nuevos productos.
                codigoCesta = RepositorioCesta.obtenerCodigoCestaNoEnviadaUsuario(dniUsuario);
            }
            CestaProductoCrossRef cestaProductoCrossRef = new CestaProductoCrossRef();
            cestaProductoCrossRef.codigoCesta = codigoCesta;
            cestaProductoCrossRef.codigoProducto = codigoProducto;
            database.cestaWithProductosDao().insertarProductoEnCesta(cestaProductoCrossRef);
            insertado = true;
        }
    return insertado;
    }

    public static void eliminarProductoEnCesta(String dniUsuario, int codigoProducto){
        int codigoCesta = RepositorioCesta.obtenerCodigoCestaNoEnviadaUsuario(dniUsuario);
        CestaProductoCrossRef cestaProductoCrossRef = new CestaProductoCrossRef();
        cestaProductoCrossRef.codigoCesta = codigoCesta;
        cestaProductoCrossRef.codigoProducto = codigoProducto;
        database.cestaWithProductosDao().eliminarProductoEnCesta(cestaProductoCrossRef);
    }
}
