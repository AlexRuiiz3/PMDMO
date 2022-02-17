package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.daos.CestaDao;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.daos.ProductoDao;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.daos.UsuarioDao;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.CestaDBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.ProductoDBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.UsuarioDBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.relaciones.CestaProductoCrossRef;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.relaciones.CestaWithProductos;

@Database(entities = {
                     CestaDBO.class,
                     ProductoDBO.class,
                     UsuarioDBO.class,
                     CestaProductoCrossRef.class
                    },
           version = 10 //Si cambia cualquier cosa de la BBDD, Hay que cambiar la version, sino falla.
)
public abstract class BaseDatosDrogueria extends RoomDatabase {

    public abstract CestaDao cestaDao();
    public abstract UsuarioDao usuarioDao();
    public abstract ProductoDao productoDao();

    private static BaseDatosDrogueria APPDATABASE = null;

    public static BaseDatosDrogueria getInstance(Context context){
        if(APPDATABASE == null){
            synchronized (BaseDatosDrogueria.class){
                APPDATABASE = Room.databaseBuilder(context.getApplicationContext(), BaseDatosDrogueria.class,"Drogueria.db").build();
            }
        }
        return APPDATABASE;
    }
}
