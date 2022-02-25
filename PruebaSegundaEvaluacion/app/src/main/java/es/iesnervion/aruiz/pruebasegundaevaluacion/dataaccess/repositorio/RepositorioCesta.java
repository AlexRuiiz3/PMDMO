package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.repositorio;

import java.util.List;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.CestaBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.CestaDBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.room.BaseDatosDrogueria;
import es.iesnervion.aruiz.pruebasegundaevaluacion.gestion.Generica;

public class RepositorioCesta {

    private static BaseDatosDrogueria database = BaseDatosDrogueria.getInstance(Generica.contextoAplicacion);

    public static void insertarCesta(String dniUsuario){
        CestaDBO cestaDBO = new CestaDBO();
        cestaDBO.DNIUsuario = dniUsuario;
        database.cestaDao().crearCestaUsuario(cestaDBO);
    }

    public static void actualizarEstadoCesta(String dniUsuario, int estado){
        database.cestaDao().actualizarEstadoCesta(dniUsuario,estado);
    }

    public static int obtenerCodigoCestaNoEnviadaUsuario(String dniUsuario){
        int codigoCesta = 0;
        if(database.cestaDao().obtenerCestaUsuarioNoEnviada(dniUsuario).blockingFirst() != null && database.cestaDao().obtenerCestaUsuarioNoEnviada(dniUsuario).blockingFirst().size() > 0) {
            codigoCesta = database.cestaDao().obtenerCestaUsuarioNoEnviada(dniUsuario).blockingFirst().get(0).codigo;
        }
        return codigoCesta;
    }
}
