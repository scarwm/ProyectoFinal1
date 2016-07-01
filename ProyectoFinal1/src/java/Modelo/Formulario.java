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

    private int numeroDeFormulario;
    private String nombreDeLaActividad;
    private String nombreORazonSocial;
    private String documentoDeIdentidad;
    private String direccionExacta;
    private String numTelObra;
    private String correoElectronicoObra;
    private String faxObra;
    private String codigoPostalObra;
    private String provincia;
    private String canton;
    private String distrito;
    private String nombreRL;
    private String estadoCivilRL;
    private String oficioRL;
   
    
    
    

    /**
     * Creates a new instance of Formulario
     */
    public Formulario() {
    }

    public Formulario(int numeroDeFormulario, String nombre, String nombreORazonSocial, String documentoDeIdentidad, String direccionExacta, String numTelObra, String correoElectronicoObra, String faxObra,String codigoPostalObra,String provincia,String canton, String distrito, String nombreRL,String estadoCilvilRL,String oficioRL) {
        this.numeroDeFormulario=numeroDeFormulario;
        this.nombreDeLaActividad = nombre;
        this.nombreORazonSocial = nombreORazonSocial;
        this.documentoDeIdentidad = documentoDeIdentidad;
        this.direccionExacta = direccionExacta;
        this.numTelObra = numTelObra;
        this.correoElectronicoObra = correoElectronicoObra;
        this.faxObra=faxObra;
        this.codigoPostalObra=codigoPostalObra;
        this.provincia=provincia;
        this.canton=canton;
        this.distrito=distrito;
        this.nombreRL=nombreRL;
        this.estadoCivilRL=estadoCilvilRL;
        this.oficioRL=oficioRL;
    }

    public int getNumeroDeFormulario() {
        return numeroDeFormulario;
    }

    public void setNumeroDeFormulario(int numeroDeFormulario) {
        this.numeroDeFormulario = numeroDeFormulario;
    }

    
    
    public String getNombreDeLaActividad() {
        return nombreDeLaActividad;
    }

    public void setNombreDeLaActividad(String nombreDeLaActividad) {
        this.nombreDeLaActividad = nombreDeLaActividad;
    }

    public String getNombreORazonSocial() {
        return nombreORazonSocial;
    }

    public void setNombreORazonSocial(String nombreORazonSocial) {
        this.nombreORazonSocial = nombreORazonSocial;
    }

    public String getDocumentoDeIdentidad() {
        return documentoDeIdentidad;
    }

    public void setDocumentoDeIdentidad(String documentoDeIdentidad) {
        this.documentoDeIdentidad = documentoDeIdentidad;
    }

    public String getDireccionExacta() {
        return direccionExacta;
    }

    public void setDireccionExacta(String direccionExacta) {
        this.direccionExacta = direccionExacta;
    }

    public String getNumTelObra() {
        return numTelObra;
    }

    public void setNumTelObra(String numTelObra) {
        this.numTelObra = numTelObra;
    }

    public String getCorreoElectronicoObra() {
        return correoElectronicoObra;
    }

    public void setCorreoElectronicoObra(String correoElectronico1) {
        this.correoElectronicoObra = correoElectronico1;
    }

    public String getFaxObra() {
        return faxObra;
    }

    public void setFaxObra(String faxObra) {
        this.faxObra = faxObra;
    }

    public String getCodigoPostalObra() {
        return codigoPostalObra;
    }

    public void setCodigoPostalObra(String codigoPostalObra) {
        this.codigoPostalObra = codigoPostalObra;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getNombreRL() {
        return nombreRL;
    }

    public void setNombreRL(String nombreRL) {
        this.nombreRL = nombreRL;
    }

    public String getEstadoCivilRL() {
        return estadoCivilRL;
    }

    public void setEstadoCivilRL(String estadoCivilRL) {
        this.estadoCivilRL = estadoCivilRL;
    }

    public String getOficioRL() {
        return oficioRL;
    }

    public void setOficioRL(String oficioRL) {
        this.oficioRL = oficioRL;
    }
    
    
   

}
