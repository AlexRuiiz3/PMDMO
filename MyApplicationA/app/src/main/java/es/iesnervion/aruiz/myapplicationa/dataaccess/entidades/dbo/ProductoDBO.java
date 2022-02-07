package es.iesnervion.aruiz.myapplicationa.dataaccess.entidades.dbo;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Producto")
public class ProductoDBO {//CLASE QUE SE COMNUICA CON LA BDD

    @PrimaryKey(autoGenerate = true)
    private int id;
    @Nullable
    private double precio;
    @Nullable
    private String foto;
    @Nullable
    private String name;
}
