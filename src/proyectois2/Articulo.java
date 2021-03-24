package proyectois2;

import java.sql.*;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author Daniela Espinosa
 */
public class Articulo {
    
    private String Codigo;
    private int Cantidad;
    private int Fabricante;
    private String Descripcion;
    private double Precio;
    AccesoBD bd;

    public Articulo() {
    }

    public Articulo(String Codigo, int Cantidad, int Fabricante, String Descripcion, double Precio) {
        this.Codigo = Codigo;
        this.Cantidad = Cantidad;
        this.Fabricante = Fabricante;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setFabricante(int Fabricante) {
        this.Fabricante = Fabricante;
    }

    public int getFabricante() {
        return Fabricante;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public double getPrecio() {
        return Precio;
    }
    
    //Función para saber si un código ya se encuentra en uso dentro de la base de datos
    public boolean verificaCodigo(String codigo) {
        ResultSet rs;
        try{
            bd = new AccesoBD();
            bd.conectaBD();
            PreparedStatement ps = bd.getConexion().prepareStatement("SELECT 1 FROM articulo WHERE codigo =?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            return rs.next();            
            //bd.cerrarConexion();           
        }catch(Exception e){
            
        }
        return false;      
    }
    
    //Método para inserta productos dentro de la base de datos
    public void insertaProducto() throws Exception{
        String cadena ="INSERT INTO articulo (codigo, fabricante_id_fabricante, stock, descripcion, precio)"
            + " VALUES "+ "('"+getCodigo()+"','"+getFabricante()+"','"+getCantidad()+"','"+getDescripcion()+"','"+
            getPrecio()+"')";
        bd = new AccesoBD();
        bd.conectaBD();
        bd.actualizaBD(cadena);   
        bd.cerrarConexion();
    }
    
    //Método para obtner la cantidad de un producto pasándole como parámetro el código del mismo
    public int obtenerStock(String CodigoO) {
        try{
        ResultSet consulta;     int stockActual = 0;
        String cadena = "SELECT * FROM articulo WHERE codigo = "+CodigoO;
        bd = new AccesoBD();
        bd.conectaBD();
        consulta = bd.consultaBD(cadena);
        while(consulta.next()){
            stockActual = consulta.getInt("stock");
            break;
        }
        //bd.cerrarConexion();
        return stockActual;
        }catch( Exception e){
            
        }
        return 0;
    }
    
    public String obtenerDescripcion(String CodigoO) throws Exception{
        ResultSet consulta;     String _descripcion = "";
        String cadena = "SELECT * FROM articulo WHERE codigo = "+CodigoO;
        bd = new AccesoBD();
        bd.conectaBD();
        consulta = bd.consultaBD(cadena);
        while(consulta.next()){
            _descripcion = consulta.getString("descripcion");
            break;
        }
        
        return _descripcion;
        //bd.cerrarConexion();
    }
    
    public double obtenerPrecio(String CodigoO) throws Exception{
        ResultSet consulta;     double precio = 0.0;
        String cadena = "SELECT * FROM articulo WHERE codigo = "+CodigoO;
        bd = new AccesoBD();
        bd.conectaBD();
        consulta = bd.consultaBD(cadena);
        while(consulta.next()){
            precio = consulta.getDouble("precio");
            break;
        }
        //bd.cerrarConexion();
        return precio;
    }
    
    //Metodo para eliminar un producto del inventario
    public void eliminar(String CodigoE) throws Exception{
        String cadena ="DELETE FROM articulo WHERE codigo ="+ CodigoE;
        bd = new AccesoBD();
        bd.conectaBD();
        bd.actualizaBD(cadena);
        bd.cerrarConexion();
    }
    
    //Método para modificar el stock de un producto pasándole como parámetro el código del mismo
    public void modificaStock(String CodigoM) throws Exception{
        String cadena = "UPDATE articulo SET stock = '"+getCantidad()+"' WHERE codigo ="+CodigoM;
        bd = new AccesoBD();
        bd.conectaBD();
        bd.actualizaBD(cadena); 
        bd.cerrarConexion();
    }
    
    public void restaStock(String codR, int canti) throws Exception{
        String cadena = "UPDATE articulo SET stock = '"+canti+"' WHERE codigo ="+codR;
        bd = new AccesoBD();
        bd.conectaBD();
        bd.actualizaBD(cadena); 
        bd.cerrarConexion();
    }
    
    public void modificaProducto(String CodigoMP)throws Exception{
        String cadena = "UPDATE articulo SET stock = '"+getCantidad()+"',"
            + "descripcion = '"+getDescripcion()+"', precio = '"+getPrecio()+"'"
            + "WHERE codigo ="+CodigoMP; 
        bd = new AccesoBD();
        bd.conectaBD();
        bd.actualizaBD(cadena); 
        bd.cerrarConexion();
    }  
    
    public ResultSet consultaTotal() throws Exception{
        ResultSet consulta;
        String cadena = "SELECT * FROM fabricante";
        bd = new AccesoBD();
        bd.conectaBD();
        consulta = bd.consultaBD(cadena);
        //bd.cerrarConexion();
        return consulta;
    }
    
    public void Llena_Combo(javax.swing.JComboBox cmb) throws Exception{
        try{
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            cmb.setModel(modeloCombo);
            ResultSet re;
            re = consultaTotal();
            modeloCombo.addElement("Nombre Fabricante");            
            while(re.next()){
                modeloCombo.addElement(re.getString("nombre_fabricante"));
            }            
        }
        catch(Exception e){
            System.out.println("Error al cargar el combo"+e.toString());
        }
    }
    
    public String obtenerIdFabricante(String _nombreFabricante) throws Exception{
        ResultSet consulta; String _codigof = "0";
        String cadena = "SELECT * FROM fabricante WHERE nombre_fabricante = '"+_nombreFabricante+"'";
        bd = new AccesoBD();
        bd.conectaBD();
        consulta = bd.consultaBD(cadena);
        //bd.cerrarConexion();
        while(consulta.next()){
            _codigof = String.valueOf(consulta.getInt("id_fabricante"));
            break;
        }
        return _codigof;
    }
}