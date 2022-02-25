package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.CestaDBO;
import io.reactivex.Flowable;


@Dao
public interface CestaDao {

    @Insert
    void crearCestaUsuario(CestaDBO cestaDBO);

    @Query("SELECT * FROM Cesta WHERE DNIUsuario = :dni AND estado = 0")
    Flowable<List<CestaDBO>> obtenerCestaUsuarioNoEnviada(String dni);

    @Query("UPDATE Cesta SET estado = :estado WHERE DNIUsuario = :dniUsuario AND estado = 0")
    void actualizarEstadoCesta(String dniUsuario,int estado);
}
