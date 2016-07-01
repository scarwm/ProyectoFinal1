/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Scarlett
 */
public class InfoReporte {
    
    private String nombre;
    private String cedula;
    private String fecha;
    private String tipoDeFor;
    private String estadoDeLaSolicitud;
    
    
    public InfoReporte() {
    }

    public InfoReporte(String nombre, String cedula, String fecha, String tipoDeFor, String estadoDeLaSolicitud) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.fecha = fecha;
        this.tipoDeFor = tipoDeFor;
        this.estadoDeLaSolicitud = estadoDeLaSolicitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstadoDeLaSolicitud() {
        return estadoDeLaSolicitud;
    }

    public void setEstadoDeLaSolicitud(String estadoDeLaSolicitud) {
        this.estadoDeLaSolicitud = estadoDeLaSolicitud;
    }

    
     
    
    public String getTipoDeFor() {
        return tipoDeFor;
    }

    public void setTipoDeFor(String tipoDeFor) {
        this.tipoDeFor = tipoDeFor;
    }

    
}