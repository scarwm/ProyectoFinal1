/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;


import Modelo.Usuario;
import org.w3c.dom.Element;

/**
 *
 * @author Carolina
 */
public class UsuarioBuilder implements InterfazBuilder {
//private String nombre, apellido1,apellido2, cedula, correo, telefono,contrasena;
    @Override
    public Usuario construteEstuduante(Object obj) {
        Element eElement = (Element) obj;
        Usuario usuario = new Usuario(
                eElement.getElementsByTagName("nombre").item(0).getTextContent(),
                eElement.getElementsByTagName("apellido1").item(0).getTextContent(),
                eElement.getElementsByTagName("apellido2").item(0).getTextContent(),
                eElement.getElementsByTagName("cedula").item(0).getTextContent(),
                eElement.getElementsByTagName("correo").item(0).getTextContent(),
                eElement.getElementsByTagName("telefono").item(0).getTextContent(),
                eElement.getElementsByTagName("contrasena").item(0).getTextContent()
        );//aqui se cierra el constructor
        return usuario;
    }
    
}
