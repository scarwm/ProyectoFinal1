/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author Carolina
 */
@ManagedBean
@ApplicationScoped
public class Formulario {
    private String nombre;
    /**
     * Creates a new instance of Formulario
     */
    public Formulario() {
    }

    public Formulario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 
}
