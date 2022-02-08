package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.CestaDBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.ProductoDBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.UsuarioDBO;

@Database(entities = {
                     CestaDBO.class,
                     ProductoDBO.class,
                     ProductosCestaDBO.class,
                     UsuarioDBO.class
        //TODO PONER LAS RELACIONES N:M
                    },
           version = 1 //Si cambia cualquier cosa de la BBDD, Hay que cambiar la version, sino falla.
)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CarroCompraDAO carroCompraDAO();//POR CADA ENTITY PONER UN DAO

    private AppDatabase APPDATABASE = null;

    public AppDatabase getInstance(Context context){
        if(APPDATABASE == null){
            synchronized (AppDatabase.class){
                APPDATABASE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"Drogueria.db").build();
            }
        }
        return APPDATABASE;
    }
}
