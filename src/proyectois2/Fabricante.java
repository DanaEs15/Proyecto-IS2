/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectois2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Daniela Espinosa
 */
public class Fabricante {
    private String Nombre;
    AccesoBD bd;

    public Fabricante() {
    }

    public Fabricante(String Nombre) {
        this.Nombre = Nombre;
    }
    

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    //Método para inserta fabricantes dentro de la base de datos
    public void insertaFabricante() throws Exception{
        String cadena ="INSERT INTO fabricante (nombre_fabricante)"
            + " VALUES "+ "('"+getNombre()+"')";
        bd = new AccesoBD();
        bd.conectaBD();
        bd.actualizaBD(cadena);   
        //bd.cerrarConexion();
    }    
    
    public void modificaFabricante(String CodigoMF)throws Exception{
        int _codigo;
        _codigo = Integer.parseInt(CodigoMF);
        String cadena = "UPDATE fabricante SET nombre_fabricante = '"+getNombre()
            + "' WHERE id_fabricante ="+_codigo; 
        bd = new AccesoBD();
        bd.conectaBD();
        bd.actualizaBD(cadena); 
        bd.cerrarConexion();
    } 
    
    public boolean verificaCodigo(String codigo) {
        int _codigo;
        _codigo = Integer.parseInt(codigo);
        ResultSet rs;
        try{
            bd = new AccesoBD();
            bd.conectaBD();
            PreparedStatement ps = bd.getConexion().prepareStatement
        ("SELECT 1 FROM fabricante WHERE id_fabricante =?");
            ps.setInt(1, _codigo);
            rs = ps.executeQuery();
            return rs.next();            
            //bd.cerrarConexion();           
        }catch(Exception e){
            
        }
        return false;      
    }
}
