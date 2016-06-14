/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioXML;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
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

public class ControladorUsuario {
    @ManagedProperty(value = "#{usuario}")
    
    public Usuario usuario;
    private File archivoXML;
    private UsuarioXML usuarioXML;
    private ConexionBD conexionBD;
            
    public ControladorUsuario() throws IOException {
        
        archivoXML = new File("Usuario.xml");
        usuarioXML = new UsuarioXML(archivoXML);
        conexionBD= new ConexionBD();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String agregarUsuario(ActionEvent e) throws JDOMException, IOException {
       
        conexionBD.registrarUsuario(usuario.getCedula(), usuario.getNombre(), usuario.getApellido1(), usuario.getApellido2(), usuario.getCorreo(), usuario.getTelefono(), usuario.getContraseña());
        usuarioXML.addUser(this.usuario);
        return "index";
    }

    public String login(String contraseña, String correo) throws JDOMException, IOException {
        System.out.println("entro por aca");
        if (!"".equals(contraseña) && !"".equals(correo) && usuarioXML.verificarUsuario(contraseña, correo) != null) {
            if (contraseña.equals(usuarioXML.verificarUsuario(contraseña, correo).getContraseña()) && correo.equals(usuarioXML.verificarUsuario(contraseña, correo).getCorreo())) {
                System.out.println("entra");
                return "formulariosPrincipal";
            }
        } 
        return "index";
    }

    public Usuario getInfoUsuario() {
        this.usuario = usuarioXML.verificarUsuario(usuario.getContraseña(), usuario.getCorreo());
        return usuario;
    }

    public void modificarUsuario() {
        usuarioXML.modificarUsuario(this.usuario);
    }

    public ArrayList<Usuario> getListaUser() throws ParseException, JDOMException, IOException {
        ArrayList<Usuario> listaUser = usuarioXML.getUsuario();
        return listaUser;
    }
    
}
