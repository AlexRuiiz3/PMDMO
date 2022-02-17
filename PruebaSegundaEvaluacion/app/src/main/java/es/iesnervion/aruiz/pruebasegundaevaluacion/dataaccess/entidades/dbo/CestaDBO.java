package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity (tableName = "Cesta"/*, primaryKeys = {"codigo","DNIUsuario"},
         foreignKeys = @ForeignKey(entity = UsuarioDBO.class,
                                   parentColumns = "DNI",
                                   childColumns = "DNIUsuario"
                                  )*/
         )

public class CestaDBO {

    @PrimaryKey(autoGenerate = true)
    public int codigo;
    @Nullable
    @ColumnInfo(defaultValue = "false")
    public boolean estado;

    @Nullable
    @NonNull//Obligaba a ponerlo
    public String DNIUsuario;
}
