/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Scarlett
 */
public class DataReport {
    public List<InfoReporte> listaReport(){
        List<InfoReporte> lista=new ArrayList<InfoReporte>();
        lista.add(new InfoReporte("Carolina", "123456","01/07/2016","D1","solicitud Enviada"));
        
        return lista;
    }
    
}
