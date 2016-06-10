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
//nombreActivi, razon, identificacion, domicilio, otrasSenas, telefono, correo, fax, codigoPostal, correoAlternativo
//provincia,canton, distrito, repreLegal,apellidoRepre, estadoCivil, profesion, numIdentidad, telefonoRepreLegal, faxRepreLegal
//codigoPostalRepreLegal, correoRepreLegal, CIIU, IAP, consultor,correoConsultor, numSetena, numTelefono,vigencia,resolucion
        Element formPrimeraParte = new Element("FormPrimeraParte");
        Element nombreActividad = new Element("nombreActividad");
        Element razon = new Element("razon");
        Element identificacion = new Element("identificacion");
        Element domicilio = new Element("domicilio");
        Element otrasSenas = new Element("otrasSenas");
        Element telefono = new Element("telefono");
        Element correo = new Element("correo");
        Element fax = new Element("fax");
        Element codigoPostal = new Element("codigoPostal");
        Element correoAlternativo = new Element("correoAlternativo");
        Element provincia = new Element("provincia");
        Element canton = new Element("canton");
        Element distrito = new Element("distrito");
        Element repreLegal = new Element("repreLegal");
        Element apellidoRepre = new Element("apellidoRepre");
        Element estadoCivil = new Element("estadoCivil");
        Element profesion = new Element("profesion");
        Element numIdentidad = new Element("numIdentidad");
        Element telefonoRepreLegal = new Element("telefonoRepreLegal");
        Element faxRepreLegal = new Element("faxRepreLegal");
        Element codigoPostalRepreLegal = new Element("codigoPostal");
        Element correoRepreLegal = new Element("correoRepreLegal");
        Element eCIIU = new Element("ciiu");
        Element eIAP = new Element("IAP");
        Element consultor = new Element("consultor");
        Element correoConsul = new Element("correoConsul");
        Element numSetena = new Element("numSetena");
        Element numTelefono = new Element("numTelefono");
        Element vigencia = new Element("vigencia");
        Element resolucion = new Element("resolucion");
//nombreActivi, razon, identificacion, domicilio, otrasSenas, telefono, correo, fax, codigoPostal, 
//correoAlternativo,provincia,canton, distrito, repreLegal,apellidoRepre, estadoCivil, profesion, numIdentidad, 
//telefonoRepreLegal, faxRepreLegal, codigoPostalRepreLegal, correoRepreLegal, CIIU, IAP, consultor,
//correoConsultor, numSetena, numTelefono,vigencia,resolucion      
        nombreActividad.addContent(form.getNombreActivi());
        razon.addContent(form.getRazon());
        identificacion.addContent(form.getIdentificacion());
        domicilio.addContent(form.getDomicilio());
        otrasSenas.addContent(form.getOtrasSenas());
        telefono.addContent(form.getTelefono());
        correo.addContent(form.getCorreo());
        fax.addContent(form.getFax());
        codigoPostal.addContent(form.getCodigoPostal());
        correoAlternativo.addContent(form.getCorreoAlternativo());
        provincia.addContent(form.getProvincia());
        canton.addContent(form.getCanton());
        distrito.addContent(form.getDistrito());
        repreLegal.addContent(form.getRepreLegal());
        apellidoRepre.addContent(form.getApellidoRepre());
        estadoCivil.addContent(form.getEstadoCivil());
        profesion.addContent(form.getProfesion());
        numIdentidad.addContent(form.getNumIdentidad());
        telefonoRepreLegal.addContent(form.getTelefonoRepreLegal());
        faxRepreLegal.addContent(form.getFaxRepreLegal());
        codigoPostalRepreLegal.addContent(form.getCodigoPostalRepreLegal());
        correoRepreLegal.addContent(form.getCorreoRepreLegal());
        eCIIU.addContent(form.getCiiu());
        eIAP.addContent(form.getIap());
        consultor.addContent(form.getConsultor());
        correoConsul.addContent(form.getCorreoConsultor());
        numSetena.addContent(form.getNumSetena());
        numTelefono.addContent(form.getNumTelefono());
        vigencia.addContent(form.getVigencia());
        resolucion.addContent(form.getResolucion());
//nombreActivi, razon, identificacion, domicilio, otrasSenas, telefono, correo, fax, codigoPostal, 
//correoAlternativo,provincia,canton, distrito, repreLegal,apellidoRepre, estadoCivil, profesion, numIdentidad, 
//telefonoRepreLegal, faxRepreLegal, codigoPostalRepreLegal, correoRepreLegal, CIIU, IAP, consultor,
//correoConsultor, numSetena, numTelefono,vigencia,resolucion 
        formPrimeraParte.addContent(nombreActividad);
        formPrimeraParte.addContent(razon);
        formPrimeraParte.addContent(identificacion);
        formPrimeraParte.addContent(domicilio);
        formPrimeraParte.addContent(otrasSenas);
        formPrimeraParte.addContent(correo);
        formPrimeraParte.addContent(fax);
        formPrimeraParte.addContent(codigoPostal);
        formPrimeraParte.addContent(correoAlternativo);
        formPrimeraParte.addContent(provincia);
        formPrimeraParte.addContent(canton);
        formPrimeraParte.addContent(distrito);
        formPrimeraParte.addContent(repreLegal);
        formPrimeraParte.addContent(apellidoRepre);
        formPrimeraParte.addContent(estadoCivil);
        formPrimeraParte.addContent(profesion);
        formPrimeraParte.addContent(domicilio);
        formPrimeraParte.addContent(numIdentidad);
        formPrimeraParte.addContent(telefonoRepreLegal);
        formPrimeraParte.addContent(faxRepreLegal);
        formPrimeraParte.addContent(codigoPostalRepreLegal);
        formPrimeraParte.addContent(correoRepreLegal);
        formPrimeraParte.addContent(eCIIU);
        formPrimeraParte.addContent(eIAP);
        formPrimeraParte.addContent(consultor);
        formPrimeraParte.addContent(correoConsul);
        formPrimeraParte.addContent(numSetena);
        formPrimeraParte.addContent(numTelefono);
        formPrimeraParte.addContent(vigencia);
        formPrimeraParte.addContent(resolucion);
       
        raiz.addContent(formPrimeraParte);
        this.guardar();

    }

    
}// fin de la clase1
