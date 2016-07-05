/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import static javax.swing.DropMode.INSERT;
import org.apache.commons.codec.binary.Base64;
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

    private UploadedFile getFile() {
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

    public void realizarConexion() {
       
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/proyectofinal";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexion exitosa");
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
    public boolean registrarArchivo(UploadedFile archivo) {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        
        
        
        try {
            cmd = con.createStatement();
            
            String data=encodeFileToBase64Binary(archivo);
            
           // System.out.println("\n \n \n el archivo es: \n"+data+"\n \n ");
           
            PreparedStatement stment= con.prepareStatement("Insert into archivos value(?)");
            stment.setString(1, data);
            stment.execute();

           
           
           
            
            //ejecuto = cmd.execute("INSERT INTO archivos(longdata) values(" +data+ ");");
            
            System.out.println("Guardado con exito");
            return true;
            // rs.close();
        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    }

    private String encodeFileToBase64Binary(UploadedFile archivo) throws IOException {

        //File file =  (File) getFile(); //new File(fileName);
        
        byte[] bytes = loadFile(archivo);
        byte[] encoded = Base64.encodeBase64(bytes);
        String encodedString = new String(encoded);
        
       // System.out.println("El archivo codificado es: "+encodedString);
        
        return encodedString;
    }
    
    private byte[] loadFile(UploadedFile file) throws IOException {
        InputStream is = file.getInputstream(); // new FileInputStream(file);

        //long length = file.length();
        long length= file.getSize();
        
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        byte[] bytes = new byte[(int) length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + file.getFileName());
        }
        is.close();
        return bytes;
    }

}
