/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import static javax.swing.DropMode.INSERT;
import static org.omg.CORBA.AnySeqHelper.insert;
 
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author kevin bermudez
 */
@ManagedBean
public class FileUploadView {
    
    private UploadedFile file;
    Connection con = null;
 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
 
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Completo", event.getFile().getFileName() + " se han cargado lo(s) archivo(s).");
        FacesContext.getCurrentInstance().addMessage(null, message);
        setFile(event.getFile());
        realizarConexion();
        registrarArchivo(getFile());
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
    
    /**
     *
     * @param archivo
     * @return
     */
    public boolean registrarArchivo(UploadedFile archivo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute(insert into archivos("(SELECT* FROM archivos(BULK N"+archivo+",SINGLE_BLOB)as Pdf)");
                
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
