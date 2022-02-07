package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity (tableName = "ProductosCesta", primaryKeys = {"codigoProducto","codigoCesta"},
         foreignKeys = {
                        @ForeignKey(entity = CestaDBO.class,
                                    parentColumns = "codigo",
                                    childColumns = "codigoCesta"
                                    ),
                         @ForeignKey(entity = ProductoDBO.class,
                                     parentColumns = "codigo",
                                     childColumns = "codigoProducto"
                         )
         }
)
public class ProductosCestaDBO {
    private int codigoProducto;
    private int codigoCesta;
}
