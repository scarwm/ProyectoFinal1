/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Formulario;
import Modelo.FormularioXML;
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
public class ControladorFormulario {
    @ManagedProperty(value = "#{formulario}")
    
    public Formulario formulario;
    private File archivoXML;
    private FormularioXML formularioXML;

    public ControladorFormulario() throws IOException {
        archivoXML = new File("Formulario.xml");
        formularioXML = new FormularioXML(archivoXML);
        
    }
    
     public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }
    
    public String agregarFormulario(ActionEvent e) throws JDOMException, IOException {
       
        formularioXML.addForm(this.formulario);
        return "index";
        
    }
    
}
