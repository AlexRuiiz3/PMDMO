package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.ProductoDBO;
import io.reactivex.Flowable;

@Dao
public interface ProductoDao {

    @Insert
    void insertarProductos(List<ProductoDBO> productos);

    @Query("SELECT * FROM Productos")
    Flowable<List<ProductoDBO>> obtenerProductos();

    @Query("SELECT DISTINCT categoria FROM Productos")
    Flowable<List<String>> obtenerNombreCategorias();

    @Query("SELECT * FROM Productos WHERE categoria = :nombreCategoria")
    Flowable<List<ProductoDBO>> obtenerProductosDeCategoria(String nombreCategoria);

    @Query("SELECT * FROM Productos  WHERE codigo = :codigoProducto AND nombre = :nombreProducto ")
    Flowable<List<ProductoDBO>>obtenerProducto(int codigoProducto,String nombreProducto);

    @Query("SELECT P.* FROM Productos AS P " +
            "INNER JOIN CestaProductos AS CP ON P.codigo = CP.codigoProducto " +
            "INNER JOIN Cesta AS C ON CP.codigoCesta = C.codigo " +
            "WHERE C.DNIUsuario = :dni")
    LiveData<List<ProductoBO>> obtenerProductosCestaUsuario(String dni);
}
