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
        Element nombre = new Element("nombre");

        nombre.addContent(form.getNombre());
        formulario.addContent(nombre);

        raiz.addContent(formulario);
        this.guardar();
    }

    
}// fin de la clase1
