/*
 * Nombre: Persona
 *
 * Comentario: Esta clase representa una persona. Este caso hace referencia ha persona de una empresa
 *
 * Atributos:
 *              - Basicos:
 *                          -Nombre: Cadena, Consultable, Modificable
 *                          -Apellidos: Cadena, Consultable, Modificable
 *                          -Telefono: Cadena, Consultable, Modificable
 *                          -Cargo: Cadena, Consultable, Modificable
 *                          -Email: Cadena, Consultable, Modificable
 *              - Derivados: Ninguno
 *              - Compartidos: Ninguno
 *
 * Metodos fundamentales(Propiedades):
 *              -Nombre
 *                      -public String getNombre()
 *                      -public void setNombre(String nombre)
 *              -Apellidos
 *                      -public String getApellidos()
 *                      -public void setApellidos(String apellidos)
 *
 *             -Telefono
 *                      -public String getTelefono()
 *                      -public void setTelefono(String telefono)
 *
 *             -Cargo
 *                      -public String getCargo()
 *                      -public void setCargo(String cargo)
 *
 *             -Email
 *                      -public String getEmail()
 *                      -public void setEmail(String email)
 *
 * Metodos añadidos: Ninguno
 *
 * Metodos hereados: Ninguno
 *
 */

package com.example.pruebaprimeraevaluacion.clasesBasicas;

import java.io.Serializable;

public class Persona implements Serializable {

    //Atributos
    private String nombre;
    private String apellidos;
    private String telefono;
    private String cargo;
    private String email;

    //Constructor sin parametros
    public Persona() {
        nombre = "";
        apellidos = "";
        telefono = "";
        cargo = "";
        email = "";
    }

    //Constructor con parametros
    public Persona(String nombre, String apellidos, String telefono, String cargo, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.cargo = cargo;
        this.email = email;
    }

    //Metodos Fundamentales(Propiedades)
    //Nombre
    public String getNombre() {

        return nombre;
    }
    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    //Apellidos
    public String getApellidos() {

        return apellidos;
    }
    public void setApellidos(String apellidos) {

        this.apellidos = apellidos;
    }

    //Telefono
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {

        this.telefono = telefono;
    }

    //Cargo
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    //Email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
