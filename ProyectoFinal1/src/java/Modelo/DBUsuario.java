/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Carolina
 */
public class DBUsuario {
    
    private ArrayList<Usuario> arreglo;
    
    public DBUsuario(){
        this.arreglo = new ArrayList<Usuario>();
    }
    
    public void setArregloU(ArrayList<Usuario> arreglo) {
        this.arreglo = arreglo;
    }
    public String agregarU(Usuario usuario){
        String mensaje="";
        System.out.println("entre");
        if (verificar(usuario.getCedula())){
            
            arreglo.add(usuario);
            mensaje = "Se agrego con exito";
        }else{
            mensaje = "ya existe un usuario con ese numero de cedula";
        }
        return mensaje;       
    }
    public boolean verificar(String cedula) {

        boolean dev = false;
        if (!arreglo.isEmpty()) {

            for (int i = 0; i < arreglo.size(); i++) {
                if (arreglo.get(i).getCedula().equalsIgnoreCase(cedula)) {

                    dev = true;

                    break;

                }
            }

        }
        return dev;
    }
    public Usuario buscarUsuario(String cedula) {

       Usuario dev = null;
        if (arreglo.size() != 0) {

            for (Usuario u:arreglo) {
                if (u.getCedula().equalsIgnoreCase(cedula)) {

                    dev =u;
                    break;

                }
            }

        }
            return dev;
        }
    public String eliminar(String cedula){
        Usuario u = buscarUsuario(cedula);
        
        if(u == null){
           return "No se encontró este usuario";
        }else{
            arreglo.remove(u);
        }
        return "Eliminado correctamente";
    }
    
    public void modificar(Usuario usuario){
        //private String nombre, apellido1,apellido2, cedula, correo, telefono,contraseña
        for(Usuario asuario: arreglo){
            if(asuario.getCedula().equalsIgnoreCase(usuario.getCedula())){
                asuario.setNombre(usuario.getNombre());
                asuario.setApellido1(usuario.getApellido1());
                asuario.setApellido2(usuario.getApellido2());
                asuario.setCorreo(usuario.getCorreo());
                asuario.setTelefono(usuario.getTelefono());
                asuario.setContrasena(usuario.getContrasena());
                break;
                
            }
            
        }
    }
}//FIN DE LA CLASE
