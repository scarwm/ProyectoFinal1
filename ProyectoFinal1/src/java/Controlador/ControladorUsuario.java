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
       
        conexionBD.registrarUsuario(usuario.getCedula(), usuario.getNombre(), usuario.getApellido1(), usuario.getApellido2(), usuario.getCorreo(), usuario.getTelefono(), usuario.getContrasena());
        usuarioXML.addUser(this.usuario);
        System.out.println("hoal");
        return "index";
    }

    public String login(String contraseña, String correo) throws JDOMException, IOException {
        if (!"".equals(contraseña) && !"".equals(correo)) {
            if(conexionBD.consultarUsuario(contraseña, correo)==true){
                if(correo.equals("admin@Setena.com") && conexionBD.consultarUsuario(contraseña, correo)==true){
                    return "superAdmin";
                }


            }
             else
                return "ingresarAhora";
        }
        return "formulariosPrincipal";
    }

    public void modificarUsuario(String cedula, String nombre, String apellido1, String apellido2, String correo, String telefono, String contrasena){
        conexionBD.modificarUsuario(cedula, nombre, apellido1, apellido2, correo, telefono, contrasena);
    }

    public Usuario getInfoUsuario() {
        this.usuario = usuarioXML.verificarUsuario(usuario.getContrasena(), usuario.getCorreo());
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
