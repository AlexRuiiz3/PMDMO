package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;


import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.relaciones.CestaProductoCrossRef;

@Dao
public interface CestaWithProductosDao {

    @Insert
    void insertarProductoEnCesta(CestaProductoCrossRef cestaProductoCrossRef);
    @Delete
    void eliminarProductoEnCesta(CestaProductoCrossRef cestaProductoCrossRef);
}
