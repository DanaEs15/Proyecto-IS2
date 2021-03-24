package proyectois2;

import java.sql.ResultSet;
/**
 *
 * @author xXYeaHXx
 */
public class Cliente {
    protected String Cedula;
    protected String Nombres;
    protected String Apellidos;
    protected String Direccion;
    protected String Telefono;
    AccesoBD bd;

    public Cliente() {
    }

    public Cliente(String Cedula, String Nombres, String Apellidos, String Direccion, String Telefono) {
        this.Cedula = Cedula;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }
    
    public Cliente(String Direccion) {
        this.Direccion = Direccion;
    }
    
    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getTelefono() {
        return Telefono;
    } 
    
    public String verificaCedula(String CedulaValidar) throws Exception{
        ResultSet consulta;
        String x ="no";
        String cadena = "SELECT * FROM cliente WHERE cedula ='"+CedulaValidar+"'";
        bd = new AccesoBD();
        bd.conectaBD();
        consulta = bd.consultaBD(cadena);
        while(consulta.next()){
            x = consulta.getString("cedula");
            break;
        }
        //bd.cerrarConexion();
        return x;
    }
    
    public void insertaCliente() throws Exception{
        String cadena ="INSERT INTO cliente (cedula, nombres, apellidos, direccion, telefono)"
            + " VALUES "+ "('"+getCedula()+"','"+getNombres()+"','"+getApellidos()+"','"+
            getDireccion()+"','"+getTelefono()+"')";
        bd = new AccesoBD();
        bd.conectaBD();
        bd.actualizaBD(cadena);   
        //bd.cerrarConexion();
    }
    
    public void modificaCliente(String CodigoMP)throws Exception{
        String cadena = "UPDATE cliente SET nombres = '"+getNombres()+"',"
            + "apellidos = '"+getApellidos()+"', direccion = '"+getDireccion()+"',"
            + "telefono = '"+getTelefono()+"' WHERE cedula ="+CodigoMP; 
        bd = new AccesoBD();
        bd.conectaBD();
        bd.actualizaBD(cadena); 
        //bd.cerrarConexion();
    }
    
    public int obtieneIdCliente(String _cedula) {
        int _id = 0;
        try{
        ResultSet consulta; 
        String cadena ="SELECT id_cliente FROM cliente WHERE cedula= '"+_cedula+"'";
        bd = new AccesoBD();
        bd.conectaBD();
        consulta = bd.consultaBD(cadena);
        //bd.cerrarConexion();
        while(consulta.next()){
            _id = consulta.getInt("id_cliente");
            break;
        }
        
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return _id;
    }
}