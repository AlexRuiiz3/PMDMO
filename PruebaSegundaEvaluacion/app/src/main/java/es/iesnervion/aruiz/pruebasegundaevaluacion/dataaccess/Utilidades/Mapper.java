package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.Utilidades;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.ProductoDBO;

public class Mapper { //Clase que se usa para poder pasar de las clases DBO A BO u viceversa

    public static ProductoDBO productoBOaDBO(ProductoBO productoBO){
        return new ProductoDBO(productoBO);
    }
}
