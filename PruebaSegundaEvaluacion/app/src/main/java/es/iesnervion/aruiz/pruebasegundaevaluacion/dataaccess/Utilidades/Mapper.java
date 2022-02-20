package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.Utilidades;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.ProductoBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo.UsuarioBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.ProductoDBO;
import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.UsuarioDBO;

public class Mapper { //Clase que se usa para poder pasar de las clases DBO A BO y viceversa

    public static ProductoDBO productoBOaDBO(ProductoBO productoBO){
        ProductoDBO productoDBO = new ProductoDBO();
        productoDBO.codigo = productoBO.getCodigo();
        productoDBO.nombre = productoBO.getNombre();
        productoDBO.precio = productoBO.getPrecio();
        productoDBO.precioKiloLitro = productoBO.getPrecioKiloLitro();
        productoDBO.categoria = productoBO.getCategoria();
        productoDBO.imagen = productoBO.getImagen();
        return productoDBO;
    }

    public static UsuarioDBO usuarioBOaDBO(UsuarioBO usuarioBO){
        UsuarioDBO usuarioDBO = new UsuarioDBO();
        usuarioDBO.DNI = usuarioBO.getDNI();
        usuarioDBO.nombre = usuarioBO.getNombre();
        usuarioDBO.contrasenha = usuarioBO.getContrasenha();
        usuarioDBO.primerApellido = usuarioBO.getPrimerApellido();
        usuarioDBO.segundoApellido = usuarioBO.getSegundoApellido();
        usuarioDBO.email = usuarioBO.getEmail();
        usuarioDBO.direccion = usuarioBO.getDireccion();
        usuarioDBO.telefono = usuarioBO.getTelefono();
        return usuarioDBO;
    }
}
