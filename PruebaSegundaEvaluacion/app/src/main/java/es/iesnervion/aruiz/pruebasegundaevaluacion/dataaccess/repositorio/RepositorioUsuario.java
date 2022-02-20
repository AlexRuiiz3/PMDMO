package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.repositorio;

import java.util.List;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.Utilidades.Mapper;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.UsuarioBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.gestion.Generica;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.daos.UsuarioDao;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.UsuarioDBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.room.BaseDatosDrogueria;
import io.reactivex.Flowable;
import io.reactivex.Single;

public class RepositorioUsuario {

    private static BaseDatosDrogueria database = BaseDatosDrogueria.getInstance(Generica.contextoAplicacion);
    private static UsuarioDao usuarioDao = database.usuarioDao();//PARA LAS QUERY

    public static void insertarUsuario(UsuarioBO usuario){
        database.usuarioDao().insertUsuario(Mapper.usuarioBOaDBO(usuario));
    }

    public static boolean comprobarSiExisteDNIUsuario(String DNI, String contrasenha){
        UsuarioDBO usuarioDBO = usuarioDao.obtenerUsuarioPorDNIyContrasenha(DNI, contrasenha).blockingFirst();
        return usuarioDBO != null;
    }

    public static boolean comprobarSiExisteDNIUsuario(String DNI){
        return usuarioDao.obtenerUsuarioPorDNI(DNI).blockingFirst().size() > 0;
    }
}
