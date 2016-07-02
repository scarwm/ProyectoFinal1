
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
            System.out.println("Conexion Realizada");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
    }
    public boolean registrarUsuario(int contador, String cedula, String nombre, String apellido1, String apellido2, String correo, String telefono, String contrasena)
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
                ejecuto = cmd.execute("UPDATE usuario SET cedula='"+cedula+"',nombre='"+nombre+"',apellido1='"+apellido1+"' ,apellido2='"+apellido2+"' ,correo='"+correo+"' ,telefono='"+telefono+"' ,contrasena='"+contrasena+"' WHERE cedula='"+cedula+"'"); 
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
    

     public Boolean consultarUsuario(String contrasena, String correo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        Boolean existe=false;
        String query;

        try {
                cmd = con.createStatement();
                query = "SELECT Count(correo) as cuenta FROM usuario where correo='"+correo+"' and contrasena='"+contrasena+"'";
                //System.out.println(query);
                rs = cmd.executeQuery(query);
                
                if (rs!=null) {
                    rs.next();
                    existe = rs.getInt("cuenta") != 0;
                    //System.err.println("Existe -> "+existe);
                    return existe; 
                }
                
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
     return false;   
    }
//private String nombre, identidad, provincia, canton,correo, cuentaConAgua, cuentaConElectricidad,viasDeAcceso,
//usoDeSuelo,acueducto, pozo, necesitaEnergiaElectrica, fuenteEnergiaElectrica, talaDeArboles,
//aguasPluvialesAlcantarillado, AguasPluvialesServidumbre, movimientosDeTierraAcarreo, movimientosDeTierraMovilizacion;

     
    public boolean registrarFormularioD2(int contador, String nombre, String identidad, String provincia, String canton, 
            String correo, String cuentaConAgua, String cuentaConElectricidad, String viasDeAcceso, String usoDeSuelo, 
            String acueducto, String pozo, String necesitaEnergiaElectrica, String fuenteEnergiaElectrica, String talaDeArboles, 
            String aguasPluvialesAlcantarillado, String AguasPluvialesServidumbre, String movimientosDeTierraAcarreo, 
            String movimientosDeTierraMovilizacion )
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO d2(numeroDeFormulario,nombre,identidad,provincia,canton,correo,cuentaConAgua,cuentaConElectricidad,viasDeAcceso,usoDeSuelo,String acueducto, String pozo, String necesitaEnergiaElectrica, String fuenteEnergiaElectrica, String talaDeArboles,aguasPluvialesAlcantarillado,AguasPluvialesServidumbre,movimientosDeTierraAcarreo, \n" +
"            movimientosDeTierraMovilizacion) VALUES ("+contador+", "+nombre+",'"+identidad+"','"+provincia+"','"+canton+"','"+correo+"','"+cuentaConAgua+"','"+cuentaConElectricidad+"','"+viasDeAcceso+"','"+usoDeSuelo+"','"+acueducto+"','"+pozo+"','"
                        + "','"+necesitaEnergiaElectrica+"','"+fuenteEnergiaElectrica+"','"+talaDeArboles+"','"+aguasPluvialesAlcantarillado+"'"
                        + ",'"+AguasPluvialesServidumbre+"','"+movimientosDeTierraAcarreo+"','"+movimientosDeTierraMovilizacion+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }        
    }
    
}

