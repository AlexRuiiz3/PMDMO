package com.example.pruebaprimeraevaluacion.clasesBasicas;

public class EmpresaNoTecnologica extends Empresa{

    private String actividad;
    private String cnae;

    public EmpresaNoTecnologica(int logo, String nombre, String actividad, String cnae) {
        super(logo, nombre);
        this.actividad = actividad;
        this.cnae = cnae;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getCnae() {
        return cnae;
    }

    public void setCnae(String cnae) {
        this.cnae = cnae;
    }

    @Override
    public String toString() {
        return getNombre()+" "+ actividad+" "+cnae;
    }
}
