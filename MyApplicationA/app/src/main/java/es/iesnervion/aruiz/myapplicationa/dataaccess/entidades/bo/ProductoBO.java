package es.iesnervion.aruiz.myapplicationa.dataaccess.entidades.bo;

public class ProductoBO { //OBJETOS QUE USAREMOS EN NUESTRA APLICACION, INTERMEDIARIO ENTRE LA API Y LA BBDD
    //BO Objetos que vienen de fuera API, BBDD, Objetos que no son de nuestra aplicacion

    private int id;
    private String nombre;
    private String foto;
    private double precio;

    public ProductoBO(int id, String nombre, String foto, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
