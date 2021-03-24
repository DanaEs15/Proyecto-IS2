package proyectois2;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author xXYeaHXx
 */
public class AccesoBD {
    
    //Atributos
    private Connection conexion = null;

    //Metodos Set y Get
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Connection getConexion() {
        return conexion;
    }
    
    //Constructor
    public AccesoBD() {
        
    }
    
    //Funcion para conectar a la base de datos
    public void conectaBD() throws Exception{
        try {
            if(conexion == null){
            Driver driver = (Driver)
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            DriverManager.registerDriver(driver);
            
            String cadena = "jdbc:mysql://localhost/facturacion";
            conexion = DriverManager.getConnection(cadena,"root","");
            }
            //JOptionPane.showMessageDialog(null, "Conexión exitosa...", "",
                //JOptionPane.INFORMATION_MESSAGE);
        }
        catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión con la base "
                + "de datos\n"+e.toString() + "...", "", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null,"Finalizando Servidor...", "", 
                JOptionPane.INFORMATION_MESSAGE);
        }       
    }
    
    //Funcion para consultar datos en la base de datos
    public ResultSet consultaBD(String sql){
        ResultSet cursor = null;
        try{
            Statement atm = conexion.createStatement();
            cursor = atm.executeQuery(sql);
        //    JOptionPane.showMessageDialog(null, "La consulta se realizo con éxito...",
        //        "",JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException e){
        //    JOptionPane.showMessageDialog(null,"Error en la consulta\n"
        //    +e.toString()+"...","",JOptionPane.ERROR_MESSAGE);
        }           
        return cursor;
    }
    
    //Funcion para actualizar datos en la base datos
    public void actualizaBD(String sql){
        try{
            Statement sta=conexion.createStatement();
            sta.executeUpdate(sql);
            //OptionPane.showMessageDialog(null, "La inforacion ha sido actulizada "
            //    + "con éxito...", "", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException e){
            //JOptionPane.showMessageDialog(null, "Error al actualizar la "
            //    + "informacion\n"+e.toString()+"...", "", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Funcion para cerrar la conexion con la base de datos
    public void cerrarConexion() throws SQLException{
        //conexion.close();
    }
    
    //Funcion para obtener una tabla completa de la base de datos
    public ResultSet getTabla(String Cosulta) throws Exception{
        conectaBD();
        Statement stm;
        ResultSet cursor = null;
        try{
            stm = conexion.createStatement();
            cursor = stm.executeQuery(Cosulta);
        }
        catch (SQLException e){
        //    JOptionPane.showMessageDialog(null, "Error en la consulta..."+e.toString()
        //        ,"",JOptionPane.ERROR_MESSAGE);
        }           
        return cursor;       
    }
    
}