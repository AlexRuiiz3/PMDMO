package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "Usuarios")
public class UsuarioDBO {

    @PrimaryKey
    @NonNull
    public String DNI;
    @Nullable
    public String nombre;
    @Nullable
    public String contrasenha;
    @Nullable
    public String direccion;
    @Nullable
    public String primerApellido;
    @Nullable
    public String segundoApellido;
    @Nullable
    public String email;
    @Nullable
    public String telefono;

}
