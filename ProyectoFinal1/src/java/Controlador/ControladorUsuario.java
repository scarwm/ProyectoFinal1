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
import utilidades.Escritor;


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
    private Escritor escritor;
    String ruta;
            
    public ControladorUsuario() throws IOException {
        //this.ruta = "C:\Users\Carolina\Documents\NetBeansProjects";
        
        archivoXML = new File("Usuario.xml");
        usuarioXML = new UsuarioXML(archivoXML);
        conexionBD= new ConexionBD();
        escritor = new Escritor();
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
       // escritor.with_obj_in_file_xml(ruta,this.usuario);
        System.out.println("hoal");
        return "index";
    }
         

    public String login(String contrasena, String correo) throws JDOMException, IOException {
        if (!"".equals(contrasena) && !"".equals(correo)) {
            if(conexionBD.consultarUsuario(contrasena, correo)==true){
                if(correo.equals("admin@Setena.com") && conexionBD.consultarUsuario(contrasena, correo)==true){
                    return "superAdmin";
                }
            }
             else
                return "ingresarAhora";
        }
        return "formulariosPrincipal";
    }

    public void modificarUsuario(ActionEvent e){
        conexionBD.modificarUsuario(usuario.getCedula(), usuario.getNombre(), usuario.getApellido1(), usuario.getApellido2(), usuario.getCorreo(), usuario.getTelefono(), usuario.getContrasena());
        usuarioXML.modificarUsuario(this.usuario);
    }

    public Usuario getInfoUsuario() {
        this.usuario = usuarioXML.verificarUsuario(usuario.getContrasena(), usuario.getCorreo());
        return usuario;
    }

    public ArrayList<Usuario> getListaUser() throws ParseException, JDOMException, IOException {
        ArrayList<Usuario> listaUser = usuarioXML.getUsuario();
        return listaUser;
    }
    
}
