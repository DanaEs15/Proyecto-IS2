package proyectois2;
/**
 *
 * @author Daniela Espinosa
 */
public class Factura extends Cliente{
    private int IdCliente;
    private double SubTotal;
    private double IVA;

    public Factura() {
    }

    public Factura(int IdCliente, double SubTotal, double IVA) {
        this.IdCliente = IdCliente;
        this.SubTotal = SubTotal;
        this.IVA = IVA;
    }    

    public Factura(int IdCliente, double SubTotal, double IVA, String Direccion) {
        super(Direccion);
        this.IdCliente = IdCliente;
        this.SubTotal = SubTotal;
        this.IVA = IVA;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public double getIVA() {
        return IVA;
    }

    public void insertaFactura() throws Exception{
        System.out.println(obtieneIdCliente(getCedula()));
        String cadena ="INSERT INTO factura "
            + "(cliente_id_cliente, fecha_factura, direccion, subtotal, iva)"
            + " VALUES ('"+getIdCliente()+"', CURDATE(),'"+getDireccion()+"',"
            + "'"+getSubTotal()+"','"+getIVA()+"')";
        bd = new AccesoBD();
        bd.conectaBD();
        bd.actualizaBD(cadena);   
        bd.cerrarConexion();
    }

    @Override
    public int obtieneIdCliente(String _cedula) {
        return super.obtieneIdCliente(_cedula); //To change body of generated methods, choose Tools | Templates.
    }
}
