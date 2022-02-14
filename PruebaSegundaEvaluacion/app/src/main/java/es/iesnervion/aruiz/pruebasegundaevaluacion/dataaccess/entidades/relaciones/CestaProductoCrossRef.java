package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.relaciones;

import androidx.room.Entity;

@Entity(tableName = "CestaProductos",primaryKeys = {"codigoCesta","codigoProducto"})
public class CestaProductoCrossRef {
    public int codigoCesta;
    public int codigoProducto;
}
