package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.ProductoDBO;

public class ProductoBO {

    private int codigo;
    private String nombre;
    private double precio;
    private double precioKiloLitro;
    private String categoria;
    private String imagen;

    public ProductoBO(String nombre, double precio, double precioKiloLitro, String categoria, String imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.precioKiloLitro = precioKiloLitro;
        this.categoria = categoria;
        this.imagen = imagen;
    }

    public ProductoBO(ProductoDBO productoDBO) {
        this.codigo = productoDBO.codigo;
        this.nombre = productoDBO.nombre;
        this.precio = productoDBO.precio;
        this.precioKiloLitro = productoDBO.precioKiloLitro;
        this.categoria = productoDBO.categoria;
        this.imagen = productoDBO.imagen;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecioKiloLitro() {
        return precioKiloLitro;
    }

    public void setPrecioKiloLitro(double precioKiloLitro) {
        this.precioKiloLitro = precioKiloLitro;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
