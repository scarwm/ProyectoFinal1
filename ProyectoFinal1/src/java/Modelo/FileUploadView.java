/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author kevin bermudez
 */
@ManagedBean
public class FileUploadView {
    
    private UploadedFile file;
 
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
    }
}
