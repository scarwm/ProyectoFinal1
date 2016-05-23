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
import java.util.Date;
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
public class UsuarioXML {
    
    private Element raiz;
    private Document documento;
    private String ruta;

    public UsuarioXML(File archivoXML) throws IOException {
        this.ruta = archivoXML.getAbsolutePath();
        if (archivoXML.exists()) {
            abrirArchivo();
        } else {
            crearArchivo();
        }
    }
    
    public void crearArchivo() {
        raiz = new Element("usuarios");
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

    public void addUser(Usuario user) throws IOException {
        // nombre, apellidos,correo, telefono,contraseña;
        Element usuario = new Element("usuario");
        Element nombre = new Element("nombre");
        Element apellido = new Element("apellido");
        Attribute cedula = new Attribute("cedula", user.getCedula());
        Element correo = new Element("correo");
        Element telefono = new Element("telefono"); 
        Element contrasena = new Element("contrasena");

        nombre.addContent(user.getNombre());
        apellido.addContent(user.getApellidos());
        correo.addContent(user.getCorreo());
        telefono.addContent(user.getTelefono());        
        contrasena.addContent(user.getContraseña());

        usuario.setAttribute(cedula);
        usuario.addContent(nombre);
        usuario.addContent(apellido);
        usuario.addContent(correo);
        usuario.addContent(telefono);
        usuario.addContent(contrasena);

        raiz.addContent(usuario);
        this.guardar();
    }

    public Usuario verificarUsuario(String contrasena, String correo) {
        List<Element> listaUsuarios = (List<Element>) raiz.getChildren();
        for (Element usuario : listaUsuarios) {
            if (usuario.getChildText("contrasena").equals(contrasena) && usuario.getChildText("correo").equals(correo)) {
                return new Usuario(
                        usuario.getChildText("nombre"),
                        usuario.getChildText("apellido"),
                        usuario.getAttributeValue("cedula"),
                        usuario.getChildText("correo"),
                        usuario.getChildText("telefono"),
                        usuario.getChildText("contrasena"));
            }
        }
        return null;
    }

    public Object verificarUsuarioXCedula(String cedula, int index) {
        List<Element> listaUsuarios = (List<Element>) raiz.getChildren();
        for (Element usuario : listaUsuarios) {
            if (usuario.getAttributeValue("cedula").equals(cedula)) {
                if (index == 1) {
                    return new Usuario(
                         usuario.getChildText("nombre"),
                        usuario.getChildText("apellido"),
                        usuario.getAttributeValue("cedula"),
                        usuario.getChildText("correo"),
                        usuario.getChildText("telefono"),
                        usuario.getChildText("contrasena"));
                } else {
                    return usuario;
                }
            }
        }
        return null;
    }

    public ArrayList<Usuario> getUsuario() throws ParseException {

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        Usuario usuario;
        List<Element> listaE = (List<Element>) raiz.getChildren();

        for (Element listaE1 : listaE) {
            usuario = new Usuario();
            usuario.setNombre(listaE1.getChildText("nombre"));
            usuario.setApellidos(listaE1.getChildText("apellido"));
            usuario.setCedula(listaE1.getAttributeValue("cedula"));
            usuario.setCorreo(listaE1.getChildText("correo"));
            usuario.setTelefono(listaE1.getChildText("telefono"));
            listaUsuarios.add(usuario);
        }
        return listaUsuarios;
    }

    public void modificarUsuario(Usuario user) {
        Element usuarioEncontrado = (Element) this.verificarUsuarioXCedula(user.getCedula(), 0);
        usuarioEncontrado.getChild("nombre").setText(user.getNombre());
        usuarioEncontrado.getChild("apellido").setText(user.getApellidos());
        usuarioEncontrado.getChild("correo").setText(user.getCorreo());
        usuarioEncontrado.getChild("telefono").setText(user.getTelefono());
        usuarioEncontrado.getChild("contrasena").setText(user.getContraseña());
        guardar();
    }
}
