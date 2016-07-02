/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Carolina
 */
public class FormularioD2 {
    
private String nombre, identidad, provincia, canton,correo, cuentaConAgua, cuentaConElectricidad,viasDeAcceso,
usoDeSuelo,acueducto, pozo, necesitaEnergiaElectrica, fuenteEnergiaElectrica, talaDeArboles,
aguasPluvialesAlcantarillado, AguasPluvialesServidumbre, movimientosDeTierraAcarreo, movimientosDeTierraMovilizacion;

private int numeroDeFormulario;

    public FormularioD2() {
    }

    public FormularioD2(String nombre, String identidad, String provincia, String canton, String correo, String cuentaConAgua, String cuentaConElectricidad, String viasDeAcceso, String usoDeSuelo, String acueducto, String pozo, String necesitaEnergiaElectrica, String fuenteEnergiaElectrica, String talaDeArboles, String aguasPluvialesAlcantarillado, String AguasPluvialesServidumbre, String movimientosDeTierraAcarreo, String movimientosDeTierraMovilizacion) {
        this.numeroDeFormulario=2;
        this.nombre = nombre;
        this.identidad = identidad;
        this.provincia = provincia;
        this.canton = canton;
        this.correo = correo;
        this.cuentaConAgua = cuentaConAgua;
        this.cuentaConElectricidad = cuentaConElectricidad;
        this.viasDeAcceso = viasDeAcceso;
        this.usoDeSuelo = usoDeSuelo;
        this.acueducto = acueducto;
        this.pozo = pozo;
        this.necesitaEnergiaElectrica = necesitaEnergiaElectrica;
        this.fuenteEnergiaElectrica = fuenteEnergiaElectrica;
        this.talaDeArboles = talaDeArboles;
        this.aguasPluvialesAlcantarillado = aguasPluvialesAlcantarillado;
        this.AguasPluvialesServidumbre = AguasPluvialesServidumbre;
        this.movimientosDeTierraAcarreo = movimientosDeTierraAcarreo;
        this.movimientosDeTierraMovilizacion = movimientosDeTierraMovilizacion;
    }

    public int getNumeroDeFormulario() {
        return numeroDeFormulario;
    }

    public void setNumeroDeFormulario(int numeroDeFormulario) {
        this.numeroDeFormulario = numeroDeFormulario;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
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

    public String getCuentaConAgua() {
        return cuentaConAgua;
    }

    public void setCuentaConAgua(String cuentaConAgua) {
        this.cuentaConAgua = cuentaConAgua;
    }

    public String getCuentaConElectricidad() {
        return cuentaConElectricidad;
    }

    public void setCuentaConElectricidad(String cuentaConElectricidad) {
        this.cuentaConElectricidad = cuentaConElectricidad;
    }

    public String getViasDeAcceso() {
        return viasDeAcceso;
    }

    public void setViasDeAcceso(String viasDeAcceso) {
        this.viasDeAcceso = viasDeAcceso;
    }

    public String getUsoDeSuelo() {
        return usoDeSuelo;
    }

    public void setUsoDeSuelo(String usoDeSuelo) {
        this.usoDeSuelo = usoDeSuelo;
    }

    public String getAcueducto() {
        return acueducto;
    }

    public void setAcueducto(String acueducto) {
        this.acueducto = acueducto;
    }

    public String getPozo() {
        return pozo;
    }

    public void setPozo(String pozo) {
        this.pozo = pozo;
    }

    public String getNecesitaEnergiaElectrica() {
        return necesitaEnergiaElectrica;
    }

    public void setNecesitaEnergiaElectrica(String necesitaEnergiaElectrica) {
        this.necesitaEnergiaElectrica = necesitaEnergiaElectrica;
    }

    public String getFuenteEnergiaElectrica() {
        return fuenteEnergiaElectrica;
    }

    public void setFuenteEnergiaElectrica(String fuenteEnergiaElectrica) {
        this.fuenteEnergiaElectrica = fuenteEnergiaElectrica;
    }

    public String getTalaDeArboles() {
        return talaDeArboles;
    }

    public void setTalaDeArboles(String talaDeArboles) {
        this.talaDeArboles = talaDeArboles;
    }

    public String getAguasPluvialesAlcantarillado() {
        return aguasPluvialesAlcantarillado;
    }

    public void setAguasPluvialesAlcantarillado(String aguasPluvialesAlcantarillado) {
        this.aguasPluvialesAlcantarillado = aguasPluvialesAlcantarillado;
    }

    public String getAguasPluvialesServidumbre() {
        return AguasPluvialesServidumbre;
    }

    public void setAguasPluvialesServidumbre(String AguasPluvialesServidumbre) {
        this.AguasPluvialesServidumbre = AguasPluvialesServidumbre;
    }

    public String getMovimientosDeTierraAcarreo() {
        return movimientosDeTierraAcarreo;
    }

    public void setMovimientosDeTierraAcarreo(String movimientosDeTierraAcarreo) {
        this.movimientosDeTierraAcarreo = movimientosDeTierraAcarreo;
    }

    public String getMovimientosDeTierraMovilizacion() {
        return movimientosDeTierraMovilizacion;
    }

    public void setMovimientosDeTierraMovilizacion(String movimientosDeTierraMovilizacion) {
        this.movimientosDeTierraMovilizacion = movimientosDeTierraMovilizacion;
    }

    

}//fin de la clase
