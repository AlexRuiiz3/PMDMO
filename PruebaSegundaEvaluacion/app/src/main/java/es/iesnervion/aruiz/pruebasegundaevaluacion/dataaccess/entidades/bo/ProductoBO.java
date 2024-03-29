package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo;

import es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.dbo.ProductoDBO;

public class ProductoBO {

    private int codigo;
    private String nombre;
    private int cantidadStock;
    private double precio;
    private double precioKiloLitro;
    private String categoria;
    private int imagen;

    public ProductoBO() {

    }

    public ProductoBO(String nombre,int cantidadStock, double precio, double precioKiloLitro, String categoria, int imagen) {
        this.nombre = nombre;
        this.cantidadStock = cantidadStock;
        this.precio = precio;
        this.precioKiloLitro = precioKiloLitro;
        this.categoria = categoria;
        this.imagen = imagen;
    }



    public ProductoBO(ProductoDBO productoDBO) {
        this.codigo = productoDBO.codigo;
        this.nombre = productoDBO.nombre;
        this.cantidadStock = productoDBO.cantidadStock;
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

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
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
    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
