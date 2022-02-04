package es.iesnervion.aruiz.myapplicationa.dataaccess.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import es.iesnervion.aruiz.myapplicationa.dataaccess.CarroCompraDAO;
import es.iesnervion.aruiz.myapplicationa.dataaccess.entidades.dbo.ProductoDBO;

@Database(entities = ProductoDBO.class, version = 1)
public abstract class AppDatabase extends RoomDatabase { //Es la BBDD

    public abstract CarroCompraDAO carroCompraDAO(); //Para que luego en el VM Se pueda comunicar con la BBDD

    private AppDatabase APPDATABASE = null;

    public AppDatabase getInstance(Context context){
        if(APPDATABASE == null){//Si no hay instancia de la BBDD(No esta creada la BBDD), Se procede a crearla
            synchronized (AppDatabase.class){//Bloquea termporalmente la aplicacion hasta que se obtenga de la BBDD
                AppDatabase instance = Room.databaseBuilder
                        (context.getApplicationContext(),
                                AppDatabase.class,
                                "CarroCompra.db"//"CarroCompra.db es el nombre de la BBDD"
                        ).build();
                APPDATABASE = instance;
            }
        }
        return APPDATABASE;
    }
}
