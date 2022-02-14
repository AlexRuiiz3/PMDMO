package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductosCestaBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.ProductoDBO;


@Dao
public interface CestaDao {

    @Insert
    ListenableFuture<Integer> crearCestaUsuario(String dni);

}
