/*
 * Nombre: EmpresaTecnologica
 *
 * Comentario: Esta clase representa a una empresa que no es tecnologica y que al hereda de la clase Empresa
 *             tendra todas las caracteristidas de dicha clase.
 *
 * Atributos:
 *              - Basicos:
 *                          -Actividad: Cadena, Consultable, Modificable
 *                          -Cnae: Cadena, Consultable, Modificable
 *              - Derivados: Ninguno
 *              - Compartidos: Ninguno
 *
 * Metodos fundamentales(Propiedades):
 *              -Actividad
 *                      -public String getActividad()
 *                      -public void setActividad(String actividad)
 *              -Cnae
 *                      -public String getCnae()
 *                      -public void setCnae(String cnae)
 *
 * Metodos añadidos: Ninguno
 *
 * Metodos hereados: Ninguno
 *
 */
package com.example.pruebaprimeraevaluacion.clasesBasicas;

public class EmpresaNoTecnologica extends Empresa{

    //Atributos
    private String actividad;
    private String cnae;

    //Constructor sin parametros
    public EmpresaNoTecnologica() {
        super();
        this.actividad = "";
        this.cnae = "";
    }

    //Constructor con parametros
    public EmpresaNoTecnologica(int logo, String nombre, String actividad, String cnae) {
        super(logo, nombre);
        this.actividad = actividad;
        this.cnae = cnae;
    }

    //Metodos fundamentales(Propiedades)
    //Actividad
    public String getActividad() {
        return actividad;
    }
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    //Cnae
    public String getCnae() {
        return cnae;
    }
    public void setCnae(String cnae) {
        this.cnae = cnae;
    }
}
