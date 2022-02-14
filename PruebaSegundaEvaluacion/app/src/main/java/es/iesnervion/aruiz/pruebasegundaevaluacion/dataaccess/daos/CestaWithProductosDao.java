package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.ListenableFuture;

@Dao
public interface CestaWithProductosDao {

    @Insert
    ListenableFuture<Integer> insertarProductosEnCesta(int codigoCesta, int codigoProducto);

    @Query("DELETE FROM CestaProductos WHERE codigoCesta = (SELECT codigo FROM Cesta WHERE DNIUsuario = :dni)")
    ListenableFuture<Integer> eliminarProductosCestaUsuario(String dni);

    @Query("DELETE FROM CestaProductos WHERE codigoCesta = (SELECT codigo FROM Cesta WHERE DNIUsuario = :dni) AND codigoProducto = :codigoProducto")
    ListenableFuture<Integer> eliminarProductoCestaUsuario(String dni, int codigoProducto);
}
