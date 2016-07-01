/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
public class FormularioXML {
    private Element raiz;
    private Document documento;
    private String ruta;

    public FormularioXML(File archivoXML) throws IOException {
        this.ruta = archivoXML.getAbsolutePath();
        if (archivoXML.exists()) {
            abrirArchivo();
        } else {
            crearArchivo();
        }
    }
    
    public void crearArchivo() {
        raiz = new Element("formularios");
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

    public void addForm(Formulario form) throws IOException {
        // nombre, apellidos,correo, telefono,contraseña;
        Element formulario = new Element("formulario");
        Attribute numeroDeFormulario = new Attribute("numeroDeFormulario",String.valueOf(form.getNumeroDeFormulario()));
        Element nombreDeLaActividad = new Element("nombreDeLaActividad");
        Element nombreORazonsocial =new Element("nombreORazonsocial");
        Element documentoDeIdentidad =new Element("documentoDeIdentidad");
        Element direccionExacta =new Element("direccionExacta");
        Element numTelObra =new Element("numTelObra");
        Element correoElectronicoObra =new Element("correoElectronicoObra");
        Element faxObra =new Element("faxObra");
        Element codigoPostalObra =new Element("codigoPostalObra");
        Element provincia=new Element("provincia");
        Element canton=new Element("canton");
        Element distrito=new Element("distrito");
        Element nombreRL=new Element("nombreRL");
        Element estadoCivilRL=new Element("estadoCivilRL");
        Element oficioRL=new Element("oficioRL");


        
        nombreDeLaActividad.addContent(form.getNombreDeLaActividad());
        nombreORazonsocial.addContent(form.getNombreORazonSocial());
        documentoDeIdentidad.addContent(form.getDocumentoDeIdentidad());
        direccionExacta.addContent(form.getDireccionExacta());
        numTelObra.addContent(form.getNumTelObra());
        correoElectronicoObra.addContent(form.getCorreoElectronicoObra());
        faxObra.addContent(form.getFaxObra());
        codigoPostalObra.addContent(form.getCodigoPostalObra());
        provincia.addContent(form.getProvincia());
        canton.addContent(form.getCanton());
        distrito.addContent(form.getDistrito());
        nombreRL.addContent(form.getNombreRL());
        estadoCivilRL.addContent(form.getEstadoCivilRL());
        oficioRL.addContent(form.getOficioRL());
        
        formulario.setAttribute(numeroDeFormulario);
        formulario.addContent(nombreDeLaActividad);
        formulario.addContent(nombreORazonsocial);
        formulario.addContent(documentoDeIdentidad);
        formulario.addContent(direccionExacta);
        formulario.addContent(numTelObra);
        formulario.addContent(correoElectronicoObra);
        formulario.addContent(faxObra);
        formulario.addContent(codigoPostalObra);
        formulario.addContent(provincia);
        formulario.addContent(canton);
        formulario.addContent(distrito);
        formulario.addContent(nombreRL);
        formulario.addContent(estadoCivilRL);
        formulario.addContent(oficioRL);
        
        raiz.addContent(formulario);
        this.guardar();
    }

    
}// fin de la clase1
