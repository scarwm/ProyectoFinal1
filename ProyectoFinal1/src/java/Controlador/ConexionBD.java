package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConexionBD {
    
    Connection con = null;
    public ConexionBD()
    {
        realizarConexion();
        
    }
    public void realizarConexion()
    {
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
    public boolean registrarUsuario(String cedula, String nombre, String apellido1, String apellido2, String correo, String telefono, String contrasena)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO usuario(cedula,nombre,apellido1,apellido2,correo,telefono,contrasena) VALUES ("+cedula+",'"+nombre+"','"+apellido1+"','"+apellido2+"','"+correo+"','"+telefono+"','"+contrasena+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }        
    }
    
    public boolean modificarUsuario(String cedula, String nombre, String apellido1, String apellido2, String correo, String telefono, String contrasena)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `usuario` SET cedula='"+cedula+"',nombre='"+nombre+"',apellido1='"+apellido1+"' ,apellido2='"+apellido2+"' ,correo='"+correo+"' ,telefono='"+telefono+"' ,contrasena='"+contrasena+"' WHERE cedula='"+cedula+"'"); 
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }     
    }
    
    public boolean eliminarUsuario(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM `usuario` WHERE cedula='"+cedula+"'"); 
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }     
    }
    
    public Boolean consultarUsuario(String correo, String contrasena)
    {
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM usuario where correo='"+correo+"' and contrasena='"+contrasena+"'");
                
                if (rs!=null) 
                {
                    return true; 
                }
                
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
     return false;   
    }
    
}
