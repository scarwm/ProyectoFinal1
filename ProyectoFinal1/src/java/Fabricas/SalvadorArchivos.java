/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas;

import Modelo.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Carolina
 */
public interface SalvadorArchivos {
    void guardarUsuario(ArrayList<Usuario> usuarios);
    ArrayList<Usuario> obtenerUsuario();
}
