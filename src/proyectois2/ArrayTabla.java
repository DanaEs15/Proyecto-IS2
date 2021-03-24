/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectois2;

import java.sql.ResultSet;

/**
 *
 * @author Daniela Espinosa
 */
public class ArrayTabla {
    private int nfactura;
    private int codigo;
    private int cantidad;
    private double pvp;
    AccesoBD bd;

    public ArrayTabla() {
    }

    public ArrayTabla(int nfactura, int codigo, int cantidad, double pvp) {
        this.nfactura = nfactura;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.pvp = pvp;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setNfactura(int nfactura) {
        this.nfactura = nfactura;
    }

    public int getNfactura() {
        return nfactura;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    public double getPvp() {
        return pvp;
    }
        
    public int idFactura(){
        int _idFactura = 0;
        try{
        ResultSet consulta;     
        String cadena = "SELECT num_factura FROM factura ORDER BY num_factura DESC LIMIT 1;";
        bd = new AccesoBD();
        bd.conectaBD();
        consulta = bd.consultaBD(cadena);
        while(consulta.next()){
            _idFactura = consulta.getInt("num_factura");
            break;
        }
        //bd.cerrarConexion();
            return _idFactura;
        }catch( Exception e){}
        return _idFactura;
    }
    
    public int idArticulo(int _codigoa) {
        int _idArticulo = 0;
        try{
        ResultSet consulta;     
        String cadena = "SELECT id_articulo FROM articulo WHERE codigo = "+_codigoa;
        bd = new AccesoBD();
        bd.conectaBD();
        consulta = bd.consultaBD(cadena);
        while(consulta.next()){
            _idArticulo = consulta.getInt("id_articulo");
            break;
        }
        //bd.cerrarConexion();
            return _idArticulo;
        }catch( Exception e){}
        return _idArticulo;
    }
    
}
