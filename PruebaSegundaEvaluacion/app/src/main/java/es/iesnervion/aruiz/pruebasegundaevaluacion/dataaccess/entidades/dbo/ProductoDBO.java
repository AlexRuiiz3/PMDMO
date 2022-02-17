package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;

@Entity (tableName = "Productos")
public class ProductoDBO {

    public ProductoDBO(){

    }

    public ProductoDBO(ProductoBO productoBO){
        codigo = productoBO.getCodigo();
        nombre = productoBO.getNombre();
        precio = productoBO.getPrecio();
        precioKiloLitro = productoBO.getPrecioKiloLitro();
        categoria = productoBO.getCategoria();
        imagen = productoBO.getImagen();
    }

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
    public String imagen;
}