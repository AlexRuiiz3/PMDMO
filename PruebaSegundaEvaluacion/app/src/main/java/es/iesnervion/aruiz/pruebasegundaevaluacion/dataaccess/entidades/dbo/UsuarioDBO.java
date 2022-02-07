package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "Usuarios")
public class UsuarioDBO {

    @PrimaryKey
    private String DNI;
    @Nullable
    private String nombre;
    @Nullable
    private String contrasenha;
    @Nullable
    private String direccion;
    @Nullable
    private String primerApellido;
    @Nullable
    private String segundoApellido;
    @Nullable
    private String email;
    @Nullable
    private String telefono;

}
