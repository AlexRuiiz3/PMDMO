package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.ListenableFuture;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.UsuarioBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.UsuarioDBO;

@Dao
public interface UsuarioDao {

    @Insert
    ListenableFuture<Integer> insertUsuario(UsuarioBO usuarioNuevo);//Devuelve el numero de filas afectadas

    @Query("SELECT * FROM USUARIOS WHERE DNI= :dni AND contrasenha =:contrasenha")
    ListenableFuture<UsuarioBO> obtenerUsuario(String dni, String contrasenha);
}
