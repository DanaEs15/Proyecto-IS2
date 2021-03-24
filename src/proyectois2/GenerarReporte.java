/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectois2;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Daniela Espinosa
 */
public class GenerarReporte {
    AccesoBD bd;
    public void GenerarFactura(int id) {
        try {
        bd = new AccesoBD();
        bd.conectaBD();
        JasperReport factura =(JasperReport) JRLoader.loadObject("FacturaIm.jasper");    
        Map parametro = new HashMap();
        parametro.put("Factura", id );
        JasperPrint j= JasperFillManager.fillReport(factura, parametro , bd.getConexion());
        JasperViewer jv = new JasperViewer(j,false);
        jv.setTitle("Factura");
        jv.setVisible(true);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}
