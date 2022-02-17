package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.UsuarioBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.UsuarioDBO;

@Dao
public interface UsuarioDao {

    @Insert
    void insertUsuario(UsuarioDBO usuarioNuevo);//Devuelve el numero de filas afectadas

    @Query("SELECT * FROM USUARIOS WHERE DNI= :dni AND contrasenha =:contrasenha")
    LiveData<List<UsuarioBO>> obtenerUsuario(String dni, String contrasenha);
}
