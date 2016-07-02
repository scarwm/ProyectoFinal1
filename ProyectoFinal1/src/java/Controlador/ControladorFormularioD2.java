/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.FormularioD2;
import Modelo.FormularioD2XML;
import java.io.File;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import org.jdom2.JDOMException;

/**
 *
 * @author Carolina
 */
@ManagedBean
@RequestScoped

public class ControladorFormularioD2 {
    @ManagedProperty(value = "#{formulario}")
    public FormularioD2 formulario;
    private File archivoXML;
    private FormularioD2XML formularioD2XML;
    private ConexionBD conexionBD;
   
    public ControladorFormularioD2() throws IOException {
        archivoXML = new File("FormularioD2.xml");
        formularioD2XML = new FormularioD2XML(archivoXML);
        conexionBD= new ConexionBD();

        
    }
    
    public FormularioD2 getFormulario() {
        return formulario;
    }

    public void setFormulario(FormularioD2 formularioD2) {
        this.formulario = formularioD2;
    }
    //private String nombre, identidad, provincia, canton,correo, cuentaConAgua, cuentaConElectricidad,viasDeAcceso,
//usoDeSuelo,acueducto, pozo, necesitaEnergiaElectrica, fuenteEnergiaElectrica, talaDeArboles,
//aguasPluvialesAlcantarillado, AguasPluvialesServidumbre, movimientosDeTierraAcarreo, movimientosDeTierraMovilizacion;

    
    public String agregarUsuario(ActionEvent e) throws JDOMException, IOException {
        conexionBD.registrarFormularioD2(formulario.getNumeroDeFormulario() ,formulario.getNombre(), formulario.getIdentidad(), formulario.getProvincia(), 
                formulario.getCanton(), formulario.getCorreo(), formulario.getCuentaConAgua(), formulario.getCuentaConElectricidad(),
                 formulario.getViasDeAcceso(), formulario.getUsoDeSuelo(), formulario.getAcueducto(), formulario.getPozo(), formulario.getNecesitaEnergiaElectrica(),
                 formulario.getFuenteEnergiaElectrica(), formulario.getTalaDeArboles(), formulario.getAguasPluvialesAlcantarillado(),
                 formulario.getAguasPluvialesServidumbre(), formulario.getMovimientosDeTierraAcarreo(), formulario.getMovimientosDeTierraMovilizacion());
        formularioD2XML.addUser(this.formulario);
        return "index";
    }
    
}
