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
    
    private String nombreActivi, razon, identificacion, domicilio, otrasSenas, telefono, correo, fax, codigoPostal, 
 correoAlternativo,provincia,canton, distrito, repreLegal,apellidoRepre, estadoCivil, profesion, numIdentidad, 
 telefonoRepreLegal, faxRepreLegal, codigoPostalRepreLegal, correoRepreLegal, ciiu, iap, consultor,
 correoConsultor, numSetena, numTelefono,vigencia,resolucion;    
    
    public Formulario() {
    
    }   

    public Formulario(String nombreActivi, String razon, String identificacion, String domicilio, String otrasSenas, String telefono, String correo, String fax, String codigoPostal, String correoAlternativo, String provincia, String canton, String distrito, String repreLegal, String apellidoRepre, String estadoCivil, String profesion, String numIdentidad, String telefonoRepreLegal, String faxRepreLegal, String codigoPostalRepreLegal, String correoRepreLegal, String ciiu, String iap, String consultor, String correoConsultor, String numSetena, String numTelefono, String vigencia, String resolucion) {
        this.nombreActivi = nombreActivi;
        this.razon = razon;
        this.identificacion = identificacion;
        this.domicilio = domicilio;
        this.otrasSenas = otrasSenas;
        this.telefono = telefono;
        this.correo = correo;
        this.fax = fax;
        this.codigoPostal = codigoPostal;
        this.correoAlternativo = correoAlternativo;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.repreLegal = repreLegal;
        this.apellidoRepre = apellidoRepre;
        this.estadoCivil = estadoCivil;
        this.profesion = profesion;
        this.numIdentidad = numIdentidad;
        this.telefonoRepreLegal = telefonoRepreLegal;
        this.faxRepreLegal = faxRepreLegal;
        this.codigoPostalRepreLegal = codigoPostalRepreLegal;
        this.correoRepreLegal = correoRepreLegal;
        this.ciiu = ciiu;
        this.iap = iap;
        this.consultor = consultor;
        this.correoConsultor = correoConsultor;
        this.numSetena = numSetena;
        this.numTelefono = numTelefono;
        this.vigencia = vigencia;
        this.resolucion = resolucion;
    }

    public String getNombreActivi() {
        return nombreActivi;
    }

    public void setNombreActivi(String nombreActivi) {
        this.nombreActivi = nombreActivi;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getOtrasSenas() {
        return otrasSenas;
    }

    public void setOtrasSenas(String otrasSenas) {
        this.otrasSenas = otrasSenas;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCorreoAlternativo() {
        return correoAlternativo;
    }

    public void setCorreoAlternativo(String correoAlternativo) {
        this.correoAlternativo = correoAlternativo;
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

    public String getRepreLegal() {
        return repreLegal;
    }

    public void setRepreLegal(String repreLegal) {
        this.repreLegal = repreLegal;
    }

    public String getApellidoRepre() {
        return apellidoRepre;
    }

    public void setApellidoRepre(String apellidoRepre) {
        this.apellidoRepre = apellidoRepre;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getNumIdentidad() {
        return numIdentidad;
    }

    public void setNumIdentidad(String numIdentidad) {
        this.numIdentidad = numIdentidad;
    }

    public String getTelefonoRepreLegal() {
        return telefonoRepreLegal;
    }

    public void setTelefonoRepreLegal(String telefonoRepreLegal) {
        this.telefonoRepreLegal = telefonoRepreLegal;
    }

    public String getFaxRepreLegal() {
        return faxRepreLegal;
    }

    public void setFaxRepreLegal(String faxRepreLegal) {
        this.faxRepreLegal = faxRepreLegal;
    }

    public String getCodigoPostalRepreLegal() {
        return codigoPostalRepreLegal;
    }

    public void setCodigoPostalRepreLegal(String codigoPostalRepreLegal) {
        this.codigoPostalRepreLegal = codigoPostalRepreLegal;
    }

    public String getCorreoRepreLegal() {
        return correoRepreLegal;
    }

    public void setCorreoRepreLegal(String correoRepreLegal) {
        this.correoRepreLegal = correoRepreLegal;
    }

    public String getCiiu() {
        return ciiu;
    }

    public void setCiiu(String ciiu) {
        this.ciiu = ciiu;
    }

    public String getIap() {
        return iap;
    }

    public void setIap(String iap) {
        this.iap = iap;
    }

    public String getConsultor() {
        return consultor;
    }

    public void setConsultor(String consultor) {
        this.consultor = consultor;
    }

    public String getCorreoConsultor() {
        return correoConsultor;
    }

    public void setCorreoConsultor(String correoConsultor) {
        this.correoConsultor = correoConsultor;
    }

    public String getNumSetena() {
        return numSetena;
    }

    public void setNumSetena(String numSetena) {
        this.numSetena = numSetena;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }
    
    
    
}



