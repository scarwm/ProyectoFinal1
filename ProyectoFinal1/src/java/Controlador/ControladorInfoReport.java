/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DataReport;
import Modelo.InfoReporte;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Scarlett
 */
@ManagedBean(name = "controlR")
@RequestScoped
public class ControladorInfoReport {
    
    private  List<InfoReporte> listReport=new ArrayList<InfoReporte>();
    DataReport dataReport=new DataReport();
    InfoReporte infoReportselec =new InfoReporte();
   
    public ControladorInfoReport() {
    }

    public List<InfoReporte> getListReport() {
        listReport=dataReport.listaReport();
        return listReport;
    }

    public void setListReport(List<InfoReporte> listReport) {
        this.listReport = listReport;
    }

    public InfoReporte getInfoReportselec() {
        return infoReportselec;
    }

    public void setInfoReportselec(InfoReporte infoReportselec) {
        this.infoReportselec = infoReportselec;
    }
    
    
    
}
