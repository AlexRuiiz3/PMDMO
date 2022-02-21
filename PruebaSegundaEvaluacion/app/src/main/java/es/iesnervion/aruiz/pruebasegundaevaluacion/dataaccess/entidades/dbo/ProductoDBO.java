package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;

@Entity (tableName = "Productos")
public class ProductoDBO {

    @PrimaryKey(autoGenerate = true)
    public int codigo;
    @Nullable
    public String nombre;
    @Nullable
    public double precio;
    @Nullable
    public double precioKiloLitro;
    @Nullable
    public String categoria;
    @Nullable
    public int imagen;
}
