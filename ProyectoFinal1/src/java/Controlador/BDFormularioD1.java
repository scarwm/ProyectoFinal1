/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Scarlett
 */
public class BDFormularioD1 {

    Connection con = null;

    public BDFormularioD1() {
        realizarConexion();
    }

    public void realizarConexion() {
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/proyectofinal";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión Realizada");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean registrarFormulario(int numeroDeFormulario, String nombreDeLaActividad, String nombreORazonSocial, String documentoDeIdentidad, String direccionExacta, String numTelObra, String correoElectronicoObra, String faxObra, String codigoPostalObra, String provincia, String canton, String distrito, String nombreRL, String estadoCivilRL, String oficioRL) {
        System.out.println("Registrar formulario");

        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
            cmd = con.createStatement();
            ejecuto = cmd.execute("INSERT INTO formulariod1(numeroDeFormulario,nombreDeLaActividad,nombreORazonSocial,documentoDeIdentidad,direccionExacta,numTelObra,correoElectronicoObra,faxObra,codigoPostalObra,provincia,canton,distrito,nombreRL,estadoCivilRL,oficioRL) VALUES ("+ numeroDeFormulario+",'"+nombreDeLaActividad+"','"+nombreORazonSocial+"','"+documentoDeIdentidad+"','"+direccionExacta+"','"+numTelObra+"','"+correoElectronicoObra+"','"+faxObra+"','"+codigoPostalObra+"','"+provincia+"','"+canton+"','"+distrito+"','"+nombreRL+"','"+estadoCivilRL+"','"+oficioRL+"')");
            System.out.println("Insert into");

            return true;
            // rs.close();
        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    }

}
