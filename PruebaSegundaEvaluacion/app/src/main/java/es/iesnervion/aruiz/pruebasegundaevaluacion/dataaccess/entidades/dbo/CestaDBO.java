package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity (tableName = "Cesta", primaryKeys = {"codigo","DNI"}/*,
         foreignKeys = @ForeignKey(entity = UsuarioDBO.class,
                                   parentColumns = "DNI",
                                   childColumns = "DNIUsuario"
                                  )*/
         )

public class CestaDBO {

    @PrimaryKey(autoGenerate = true)
    private int codigo;
    @Nullable
    private boolean estado;
    @Nullable
    private String DNIUsuario;
}
