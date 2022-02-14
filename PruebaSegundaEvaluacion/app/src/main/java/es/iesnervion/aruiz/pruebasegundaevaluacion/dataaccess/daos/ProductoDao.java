package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.ProductoDBO;
import io.reactivex.Completable;
import io.reactivex.Flowable;

@Dao
public interface ProductoDao {

    @Insert
    ListenableFuture<Integer> insertarProductos(List<ProductoDBO> productos);

    @Query("SELECT * FROM Productos")
    ListenableFuture<List<ProductoDBO>> obtenerProductos();

    @Query("SELECT * FROM Productos WHERE codigo = :codigoProducto")
    ListenableFuture<ProductoDBO> obtenerProducto(int codigoProducto);

    @Query("SELECT P.* FROM Productos AS P " +
            "INNER JOIN CestaProductos AS CP ON P.codigo = CP.codigoProducto " +
            "INNER JOIN Cesta AS C ON CP.codigoCesta = C.codigo " +
            "WHERE C.DNIUsuario = :dni")
    LiveData<List<ProductoDBO>> obtenerProductosCestaUsuario(String dni);
}
