/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Carolina
 */
public class FormularioD2XML {
    
    private Element raiz;
    private Document documento;
    private String ruta;

    public FormularioD2XML(File archivoXML) throws IOException {
        this.ruta = archivoXML.getAbsolutePath();
        if (archivoXML.exists()) {
            abrirArchivo();
        } else {
            crearArchivo();
        }
    }
    
    public void crearArchivo() {
        raiz = new Element("formulariosD2");
        documento = new Document(raiz);
        guardar();
    }

    public void guardar() {
        XMLOutputter xMLOutputter = new XMLOutputter();
        try {
            xMLOutputter.output(documento, new PrintWriter(ruta));
        } catch (IOException ex) {
            Logger.getLogger(UsuarioXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void abrirArchivo() throws IOException {
        try {
            SAXBuilder sAXBuilder = new SAXBuilder();
            sAXBuilder.setIgnoringElementContentWhitespace(true);
            documento = sAXBuilder.build(ruta);
            raiz = documento.getRootElement();
        } catch (JDOMException ex) {
            System.out.println("error");
        }
    }

    public void addUser(FormularioD2 formularioD2) throws IOException {
        // nombre, identidad, provincia, canton,correo, cuentaConAgua, cuentaConElectricidad,viasDeAcceso,
        //usoDeSuelo,acueducto, pozo, necesitaEnergiaElectrica, fuenteEnergiaElectrica, talaDeArboles,
        //aguasPluvialesAlcantarillado, AguasPluvialesServidumbre, movimientosDeTierraAcarreo, 
        //movimientosDeTierraMovilizacion;

        Element d2 = new Element("formularioD2");
        Element nombre = new Element("nombre");
        Attribute identidad = new Attribute("identidad", formularioD2.getIdentidad());
        Element provincia = new Element("provincia");
        Element canton = new Element("canton");
        Element correo = new Element("correo");
        Element cuentaConAgua = new Element("cuentaConAgua"); 
        Element cuentaConElectricidad = new Element("cuentaConElectricidad");
        Element viasDeAcceso = new Element("viasDeAcceso");
        Element usoDeSuelo = new Element("usoDeSuelo");
        Element acueducto = new Element("acueducto");
        Element pozo = new Element("pozo"); 
        Element necesitaEnergiaElectrica= new Element("necesitaEnergiaElectrica");
        Element fuenteDeEnergiaElectrica = new Element("fuenteDeEnergiaElectrica"); 
        Element talaDeArboles = new Element("talaDeArboles");
        Element aguasPluvialesAlcantarillado = new Element("aguasPluvialesAlcantarillado");
        Element AguasPluvialesServidumbre = new Element("AguasPluvialesServidumbre");
        Element movimientosDeTierraAcarreo = new Element("movimientosDeTierraAcarreo");
        Element movimientosDeTierraMovilizacion = new Element("movimientosDeTierraMovilizacion"); 

        nombre.addContent(formularioD2.getNombre());
        provincia.addContent(formularioD2.getProvincia());
        canton.addContent(formularioD2.getCanton());
        correo.addContent(formularioD2.getCorreo());
        cuentaConAgua.addContent(formularioD2.getCuentaConAgua());        
        cuentaConElectricidad.addContent(formularioD2.getCuentaConElectricidad());
        viasDeAcceso.addContent(formularioD2.getViasDeAcceso());
        usoDeSuelo.addContent(formularioD2.getUsoDeSuelo());
        acueducto.addContent(formularioD2.getAcueducto());
        pozo.addContent(formularioD2.getPozo());
        necesitaEnergiaElectrica.addContent(formularioD2.getNecesitaEnergiaElectrica());        
        fuenteDeEnergiaElectrica.addContent(formularioD2.getFuenteEnergiaElectrica());
        talaDeArboles.addContent(formularioD2.getTalaDeArboles());
        aguasPluvialesAlcantarillado.addContent(formularioD2.getAguasPluvialesAlcantarillado());
        AguasPluvialesServidumbre.addContent(formularioD2.getAguasPluvialesServidumbre());
        movimientosDeTierraAcarreo.addContent(formularioD2.getMovimientosDeTierraAcarreo());
        movimientosDeTierraMovilizacion.addContent(formularioD2.getMovimientosDeTierraMovilizacion());   
        
        d2.setAttribute(identidad);
        d2.addContent(nombre);
        d2.addContent(provincia);
        d2.addContent(canton);
        d2.addContent(correo);
        d2.addContent(cuentaConAgua);
        d2.addContent(cuentaConElectricidad);
        d2.addContent(viasDeAcceso);
        d2.addContent(usoDeSuelo);
        d2.addContent(acueducto);
        d2.addContent(pozo);
        d2.addContent(necesitaEnergiaElectrica);
        d2.addContent(fuenteDeEnergiaElectrica);
        d2.addContent(talaDeArboles);
        d2.addContent(aguasPluvialesAlcantarillado);
        d2.addContent(AguasPluvialesServidumbre);
        d2.addContent(movimientosDeTierraAcarreo);
        d2.addContent(movimientosDeTierraMovilizacion);

        raiz.addContent(d2);
        this.guardar();
    }

}
