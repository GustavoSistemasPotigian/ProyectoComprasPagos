/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import BaseDeDatos.ConexionMySQL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author gustavo
 */
public class GenerarReportes {
    
    public void reportePlanFijo(String valor)
    {
        try {
            
            JasperReport reporte= (JasperReport) JRLoader.loadObject("ReportePlanFijo.jasper");
            Map parametro= new HashMap();
            parametro.put("valor", valor);
            ConexionMySQL mysql= new ConexionMySQL();
            Connection cn= mysql.Conectar();
            
            JasperPrint j= JasperFillManager.fillReport(reporte, parametro,cn);
            JasperViewer jv= new JasperViewer(j, false);
            jv.setTitle("Reporte Importe Fijo");
            jv.setVisible(true);
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error al mostrar el reporte " + e);
        
        }
                
        
        
        
        
    
    }
    
    
    
    
    
    
    
}


