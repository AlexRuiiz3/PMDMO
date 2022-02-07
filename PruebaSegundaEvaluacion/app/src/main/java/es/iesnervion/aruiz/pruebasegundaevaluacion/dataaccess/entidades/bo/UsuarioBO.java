package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo;

public class UsuarioBO {

    private String DNI;
    private String nombre;
    private String contrasenha;
    private String direccion;
    private String primerApellido;
    private String segundoApellido;
    private String email;
    private String telefono;

    public UsuarioBO(String DNI, String nombre, String contrasenha, String direccion, String primerApellido, String segundoApellido, String email, String telefono) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.contrasenha = contrasenha;
        this.direccion = direccion;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.email = email;
        this.telefono = telefono;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
