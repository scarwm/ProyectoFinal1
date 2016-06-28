/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas;

import Modelo.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.AyudanteOS;
import utilidades.Escritor;
import utilidades.Lector;

/**
 *
 * @author Carolina
 */
public class SalvadorXML implements SalvadorArchivos {

    private Escritor escritor;
    private AyudanteOS ayudaos;

    public SalvadorXML() {
        escritor = new Escritor();
        ayudaos = new AyudanteOS();
    }
    
    @Override
    public void guardarUsuario(ArrayList<Usuario> usuarios) {
             try {
            escritor.with_obj_in_file_xml(
                    ayudaos.get_config_file("usuarios.xml"),
                    usuarios);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Usuario> obtenerUsuario() {
        Lector<ArrayList<Usuario>> lector = new Lector<>();
        String filepath=null;
        try {
            filepath = ayudaos.get_config_file("usuarios.xml");
        } catch (IOException ex) {
            Logger.getLogger(SalvadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lector.read_xml(filepath);
    }
    
}
