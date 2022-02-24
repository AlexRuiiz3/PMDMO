package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.repositorio;


import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.Utilidades.Mapper;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.UsuarioBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.gestion.Generica;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.daos.UsuarioDao;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.room.BaseDatosDrogueria;

public class RepositorioUsuario {

    private static BaseDatosDrogueria database = BaseDatosDrogueria.getInstance(Generica.contextoAplicacion);
    private static UsuarioDao usuarioDao = database.usuarioDao();//PARA LAS QUERY

    public static void insertarUsuario(UsuarioBO usuario){
        database.usuarioDao().insertUsuario(Mapper.usuarioBOaDBO(usuario));
    }

    public static boolean comprobarSiExisteDNIUsuario(String DNI, String contrasenha){
        return usuarioDao.obtenerUsuarioPorDNIyContrasenha(DNI, contrasenha).blockingFirst().size() > 0;
    }

    public static boolean comprobarSiExisteDNIUsuario(String DNI){
        return usuarioDao.obtenerUsuarioPorDNI(DNI).blockingFirst().size() > 0;
    }
}
