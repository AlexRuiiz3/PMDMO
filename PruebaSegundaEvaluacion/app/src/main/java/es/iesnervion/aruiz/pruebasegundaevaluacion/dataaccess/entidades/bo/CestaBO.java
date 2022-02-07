package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo;

public class CestaBO {

    private int codigo;
    private boolean estado;
    private String DNIUsuario;

    public CestaBO(int codigo, boolean estado, String DNIUsuario) {
        this.codigo = codigo;
        this.estado = estado;
        this.DNIUsuario = DNIUsuario;
    }

    public int getCodigo() {
        return codigo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDNIUsuario() {
        return DNIUsuario;
    }
}
