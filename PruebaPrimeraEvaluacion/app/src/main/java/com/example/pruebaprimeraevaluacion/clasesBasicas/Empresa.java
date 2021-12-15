/*
 * Nombre: Empresa
 *
 * Comentario: Esta clase representa una empresa
 *
 * Atributos:
 *              - Basicos:
 *                          -Logo: int, Consultable, Modificable
 *                          -Nombre: Cadena, Consultable, Modificable
 *              - Derivados: Ninguno
 *              - Compartidos: Ninguno
 *
 * Metodos fundamentales(Propiedades):
 *              -Logo
 *                      -public int getLogo()
 *                      -public void setLogo(int logo)
 *              -Nombre
 *                      -public String getNombre()
 *                      -public void setNombre(String nombre)
 *
 * Metodos añadidos: Ninguno
 *
 * Metodos hereados: Ninguno
 *
 */
package com.example.pruebaprimeraevaluacion.clasesBasicas;

import java.io.Serializable;

public class Empresa implements Serializable {

    //Atributos
    private int logo;
    private String nombre;

    //Constructor sin parametros
    public Empresa() {
        logo = 0;
        nombre = "";
    }

    //Constructor con parametros
    public Empresa(int logo, String nombre) {
        this.logo = logo;
        this.nombre = nombre;
    }

    //Metodos fundamentales(Propiedades)
    //Logo
    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    //Nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
