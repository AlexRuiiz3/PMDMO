package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.daos;

import androidx.room.Dao;
import androidx.room.Insert;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.CestaDBO;


@Dao
public interface CestaDao {

    @Insert
    void crearCestaUsuario(CestaDBO cestaDBO);

}
