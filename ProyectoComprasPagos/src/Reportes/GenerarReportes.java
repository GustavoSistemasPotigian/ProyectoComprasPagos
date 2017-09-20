/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import BaseDeDatos.ConexionMySQL;
import Modelos.ConsultaPlanes;
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
    ConexionMySQL mysql= new ConexionMySQL();
            Connection cn= mysql.Conectar();
    public void reportePlanFijo(int idPlanFijo)
    {
            
        
          try {
            System.out.println("entra5");
            JasperReport reporte= (JasperReport) JRLoader.loadObject("ReportePlanFijo.jasper");
            Map parametro= new HashMap();
            parametro.put("idPlanFijo", idPlanFijo);
            System.out.println("entra6");
            
            JasperPrint j= JasperFillManager.fillReport(reporte, parametro,cn);
             System.out.println("entra7");
            JasperViewer jv= new JasperViewer(j, false);
             System.out.println("entra8");
            jv.setTitle("Reporte Importe Fijo");
             System.out.println("entra9");
            jv.setVisible(true);
           
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error al mostrar el reporte " + e);
        
        }
                
        
        
        
        
    
    }
    
    
    
    
    
    
    
}


