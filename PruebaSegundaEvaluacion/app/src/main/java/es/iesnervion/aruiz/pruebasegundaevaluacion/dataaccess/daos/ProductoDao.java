package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.daos;

import androidx.room.Dao;
import androidx.room.Query;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.ProductoDBO;
import io.reactivex.Flowable;

@Dao
public interface ProductoDao {

    @Query("SELECT * FROM Productos")
    Flowable<ProductoDBO> getProductos();

    @Query("SELECT * FROM CestaProductoCrossRef WHERE codigoProducto = :idCesta")
    Flowable<ProductoDBO> getProductosDeCesta(int idCesta);
}
