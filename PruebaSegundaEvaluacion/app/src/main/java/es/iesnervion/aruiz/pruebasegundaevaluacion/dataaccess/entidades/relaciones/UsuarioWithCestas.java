package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.relaciones;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.CestaDBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.UsuarioDBO;

public class UsuarioWithCestas {
    @Embedded public UsuarioDBO usuario;
    @Relation(
            parentColumn = "DNI",
            entityColumn = "DNIUsuario"
    )
    public List<CestaDBO> cestas;
}
