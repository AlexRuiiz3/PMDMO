package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "Productos")
public class ProductoDBO {

    @PrimaryKey(autoGenerate = true)
    private int codigo;
    @Nullable
    private String nombre;
    @Nullable
    private double precio;
    @Nullable
    private double precioKiloLitro;
    @Nullable
    private String categoria;
    @Nullable
    private String imagen;
}
