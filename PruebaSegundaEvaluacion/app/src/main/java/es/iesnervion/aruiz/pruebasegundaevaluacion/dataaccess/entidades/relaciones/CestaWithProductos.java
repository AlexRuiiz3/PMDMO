package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.relaciones;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.CestaDBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.ProductoDBO;

public class CestaWithProductos {
    @Embedded public CestaDBO cesta;
    @Relation(
            parentColumn = "codigo",
            entityColumn = "codigo",
            associateBy = @Junction(ProductoDBO.class)
    )
    public List<ProductoDBO> productos;
}
