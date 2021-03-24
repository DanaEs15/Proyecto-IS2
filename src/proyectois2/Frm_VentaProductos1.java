
package proyectois2;

import java.awt.HeadlessException;
import java.sql.*;
import java.text.*;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniela Espinosa
 */
public class Frm_VentaProductos1 extends javax.swing.JFrame {
    Frm_SeleccionaClienteVenta seleccionaClienteVenta;
    DefaultTableModel model;
    DefaultTableModel model2;
    AccesoBD bd = new AccesoBD();
    private String po;
    private double acu = 0.0;

    /**
     * Creates new form Frm_VentaProductos
     */
    public Frm_VentaProductos1()  {
        initComponents();
        AjustarVentana();
        bloquearTxts();
        try{
            ActualizarTabla();
            //LlenarTabla();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
    
    private void AjustarVentana(){
        //Centrar Ventana
        this.setLocationRelativeTo(null);  
        
        //Bloquear Tamanio
        this.setResizable(false);
    }
    
    private void bloquearTxts(){
        txtCedulaVenta.setEnabled(false);
        txtNombresVenta.setEnabled(false);
        txtApellidosVentas.setEnabled(false);
        txtDireccionVentas.setEnabled(false);
        txtTelefonoVentas.setEnabled(false);
        txtFacturaSubtotal.setEnabled(false);
        txtFacturaIVA.setEnabled(false);
        txtFacturaTotalaPagar.setEnabled(false);
    }
    
    private void LlenarTabla() throws Exception{
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat form = new DecimalFormat("#.##", simbolos);
        Articulo a = new Articulo();
        int i=0;  String cd = po, x, p;
                
        String matriz2[][];
        matriz2 = new String[ProyectoIS2.ListaVenta.size()][5];
        for (Map.Entry duo: ProyectoIS2.ListaVenta.entrySet()) {
            x = duo.getKey().toString();
            matriz2[i][0] = duo.getKey().toString();            
            matriz2[i][1] = duo.getValue().toString();
            matriz2[i][2] = a.obtenerDescripcion(x);
            matriz2[i][3] = String.valueOf(form.format(a.obtenerPrecio(x)));
            matriz2[i][4] = String.valueOf(form.format(Integer.parseInt(duo.getValue().toString())* a.obtenerPrecio(x)));
            acu+=Double.parseDouble(matriz2[i][4]);
            i++;
        }
              
        jtProductosAgregadosVentas.setModel(new javax.swing.table.DefaultTableModel(
            matriz2,
            new String [] {
                "Código", "Cantidad", "Descripción", "Valor Unitario", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
    }
    
    private void ActualizarTabla() throws Exception{
    DefaultTableModel modelo = new DefaultTableModel();
        AccesoBD bd = new AccesoBD();
        ResultSet rs = bd.getTabla("SELECT codigo, stock, descripcion, precio FROM articulo");
        modelo.setColumnIdentifiers(new Object[]{"Código", "Descripción", "Precio"});
        try{
            while(rs.next()){
                if(rs.getInt("stock")>0){
                modelo.addRow(new Object[]{rs.getString("codigo"),
                rs.getString("descripcion"), rs.getDouble("precio")});}
            }
            jtMuestraProductoVenta.setModel(modelo);
        }
        catch(SQLException e){
            System.out.println(e.toString());
        }
    }

    public void restaVendido(){
        Articulo a = new Articulo();
        String codi ; int restar, actual;
        for (int i = 0; i < jtProductosAgregadosVentas.getRowCount(); i++) {
            try{
                codi = (String) jtProductosAgregadosVentas.getValueAt(i,0);
                System.out.println(codi);
                actual = a.obtenerStock(codi);
                restar = Integer.parseInt((String) jtProductosAgregadosVentas.getValueAt(i,1));
                System.out.println(restar);
                a.restaStock(codi, (actual - restar));
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
	}
    }
    
    private void llenaTabla2 () {
        ArrayTabla at = new ArrayTabla();
        
        try{
            
            bd.conectaBD();
            
            for (int i = 0; i < jtProductosAgregadosVentas.getRowCount(); i++) {
                PreparedStatement pst = bd.getConexion().prepareStatement(""
                    + "INSERT INTO factura_has_articulo (factura_num_articulo, articulo_id_articulo, "
                    + "cantidad, PVP) VALUES (?,?,?,?)");
                pst.setInt(1, (at.idFactura()));
                //System.out.println("Mira "+(at.idFactura()+1));
                pst.setInt(2, (at.idArticulo(Integer.parseInt(jtProductosAgregadosVentas.getValueAt(i, 0).toString()))));
                //System.out.println("Mira 2: " + (at.idArticulo(Integer.parseInt(jtProductosAgregadosVentas.getValueAt(i, 0).toString()))));
                pst.setInt(3, Integer.parseInt((jtProductosAgregadosVentas.getValueAt(i, 1)).toString()));
                //System.out.println("Mira 3: "+Integer.parseInt((jtProductosAgregadosVentas.getValueAt(i, 1)).toString()));
                pst.setDouble(4, (Double.parseDouble(jtProductosAgregadosVentas.getValueAt(i, 3).toString())
                    + (Double.parseDouble(jtProductosAgregadosVentas.getValueAt(i, 3).toString()))*0.12));
                //System.out.println("xd:"+Double.parseDouble(jtProductosAgregadosVentas.getValueAt(i, 3).toString())*0.12);
                //System.out.println("Mira 4: "+ (Double.parseDouble(jtProductosAgregadosVentas.getValueAt(i, 3).toString())
                //    +(Double.parseDouble(jtProductosAgregadosVentas.getValueAt(i, 3).toString()))*0.12));
                pst.executeUpdate();
            }
        }
        catch(Exception e) {JOptionPane.showMessageDialog(null, e.toString());}
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jpVentas = new javax.swing.JPanel();
        lblTituloVentas = new javax.swing.JLabel();
        lblCedulaVentas = new javax.swing.JLabel();
        lblNombresVentas = new javax.swing.JLabel();
        lblApellidosVentas = new javax.swing.JLabel();
        lblDireccionVentas = new javax.swing.JLabel();
        lblTelefonoVentas = new javax.swing.JLabel();
        txtNombresVenta = new javax.swing.JTextField();
        txtCedulaVenta = new javax.swing.JTextField();
        txtDireccionVentas = new javax.swing.JTextField();
        txtTelefonoVentas = new javax.swing.JTextField();
        txtApellidosVentas = new javax.swing.JTextField();
        btnSeleccionCliente = new javax.swing.JButton();
        btnVentaProductosAgregar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtMuestraProductoVenta = new javax.swing.JTable();
        txtBuscaProductosVenta = new javax.swing.JTextField();
        lblFacturaTotal = new javax.swing.JLabel();
        txtFacturaSubtotal = new javax.swing.JTextField();
        txtFacturaTotalaPagar = new javax.swing.JTextField();
        txtFacturaIVA = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductosAgregadosVentas = new javax.swing.JTable();
        btnOK = new javax.swing.JButton();
        lblFacturaSubtotal = new javax.swing.JLabel();
        lblFacturaIVA = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Facturación");
        setSize(new java.awt.Dimension(0, 45));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setAutoscrolls(true);
        jScrollPane3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jpVentas.setBackground(new java.awt.Color(211, 244, 255));
        jpVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloVentas.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 24)); // NOI18N
        lblTituloVentas.setForeground(new java.awt.Color(231, 164, 228));
        lblTituloVentas.setText("Ventas ");
        jpVentas.add(lblTituloVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        lblCedulaVentas.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        lblCedulaVentas.setForeground(new java.awt.Color(231, 164, 228));
        lblCedulaVentas.setText("Cédula:");
        lblCedulaVentas.setPreferredSize(new java.awt.Dimension(64, 25));
        jpVentas.add(lblCedulaVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, 86, -1));

        lblNombresVentas.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        lblNombresVentas.setForeground(new java.awt.Color(231, 164, 228));
        lblNombresVentas.setText("Nombres:");
        lblNombresVentas.setPreferredSize(new java.awt.Dimension(80, 25));
        jpVentas.add(lblNombresVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 121, 110, -1));

        lblApellidosVentas.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        lblApellidosVentas.setForeground(new java.awt.Color(231, 164, 228));
        lblApellidosVentas.setText("Apellidos:");
        lblApellidosVentas.setPreferredSize(new java.awt.Dimension(81, 25));
        jpVentas.add(lblApellidosVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 169, 120, -1));

        lblDireccionVentas.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        lblDireccionVentas.setForeground(new java.awt.Color(231, 164, 228));
        lblDireccionVentas.setText("Dirección:");
        lblDireccionVentas.setPreferredSize(new java.awt.Dimension(86, 25));
        jpVentas.add(lblDireccionVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 217, 120, -1));

        lblTelefonoVentas.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        lblTelefonoVentas.setForeground(new java.awt.Color(231, 164, 228));
        lblTelefonoVentas.setText("Teléfono:");
        lblTelefonoVentas.setPreferredSize(new java.awt.Dimension(81, 25));
        jpVentas.add(lblTelefonoVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 264, 120, -1));

        txtNombresVenta.setPreferredSize(new java.awt.Dimension(6, 25));
        jpVentas.add(txtNombresVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 124, 210, -1));

        txtCedulaVenta.setPreferredSize(new java.awt.Dimension(6, 25));
        jpVentas.add(txtCedulaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 76, 130, -1));

        txtDireccionVentas.setPreferredSize(new java.awt.Dimension(6, 25));
        jpVentas.add(txtDireccionVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 220, 210, -1));

        txtTelefonoVentas.setPreferredSize(new java.awt.Dimension(6, 25));
        jpVentas.add(txtTelefonoVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 267, 130, -1));

        txtApellidosVentas.setPreferredSize(new java.awt.Dimension(6, 25));
        jpVentas.add(txtApellidosVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 172, 210, -1));

        btnSeleccionCliente.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnSeleccionCliente.setText("Seleccionar Cliente");
        btnSeleccionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionClienteActionPerformed(evt);
            }
        });
        jpVentas.add(btnSeleccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 71, -1, -1));

        btnVentaProductosAgregar1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnVentaProductosAgregar1.setText("Agregar a la factura");
        btnVentaProductosAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaProductosAgregar1ActionPerformed(evt);
            }
        });
        jpVentas.add(btnVentaProductosAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 300, -1, -1));

        jtMuestraProductoVenta = new javax.swing.JTable(){
            public boolean isCellEditable (int rowIndex, int colIndex){
                return false;
            }
        };
        jtMuestraProductoVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtMuestraProductoVenta.getTableHeader().setReorderingAllowed(false);
        jtMuestraProductoVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMuestraProductoVentaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtMuestraProductoVenta);

        jpVentas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 298, -1, 113));

        txtBuscaProductosVenta.setPreferredSize(new java.awt.Dimension(6, 25));
        txtBuscaProductosVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaProductosVentaActionPerformed(evt);
            }
        });
        txtBuscaProductosVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaProductosVentaKeyPressed(evt);
            }
        });
        jpVentas.add(txtBuscaProductosVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 340, 92, -1));

        lblFacturaTotal.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 18)); // NOI18N
        lblFacturaTotal.setForeground(new java.awt.Color(231, 164, 228));
        lblFacturaTotal.setText("Total a Pagar:");
        jpVentas.add(lblFacturaTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 640, -1, 25));

        txtFacturaSubtotal.setPreferredSize(new java.awt.Dimension(6, 25));
        jpVentas.add(txtFacturaSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 550, 104, -1));

        txtFacturaTotalaPagar.setPreferredSize(new java.awt.Dimension(6, 25));
        jpVentas.add(txtFacturaTotalaPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 640, 104, -1));

        txtFacturaIVA.setPreferredSize(new java.awt.Dimension(6, 25));
        jpVentas.add(txtFacturaIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 590, 104, -1));

        jtProductosAgregadosVentas = new javax.swing.JTable(){
            public boolean isCellEditable (int rowIndex, int colIndex){
                return false;
            }
        };
        jtProductosAgregadosVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cantidad", "Descripcion", "Valor Unitario", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProductosAgregadosVentas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtProductosAgregadosVentas);

        jpVentas.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 429, 553, 100));

        btnOK.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnOK.setText("Pagar");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        jpVentas.add(btnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 670, -1, -1));

        lblFacturaSubtotal.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 18)); // NOI18N
        lblFacturaSubtotal.setForeground(new java.awt.Color(231, 164, 228));
        lblFacturaSubtotal.setText("Subtotal:");
        jpVentas.add(lblFacturaSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, -1, -1));

        lblFacturaIVA.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 18)); // NOI18N
        lblFacturaIVA.setForeground(new java.awt.Color(231, 164, 228));
        lblFacturaIVA.setText("IVA:");
        jpVentas.add(lblFacturaIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 590, -1, -1));

        jScrollPane3.setViewportView(jpVentas);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionClienteActionPerformed
        // TODO add your handling code here:
        char x ='x'; boolean pass = false;
        try{
        if(txtCedulaVenta.getText().equals("")){
            setVisible(false);
            seleccionaClienteVenta = new  Frm_SeleccionaClienteVenta();
            seleccionaClienteVenta.setVisible(true);
        }
        else{
            do{
                x = JOptionPane.showInputDialog("Ya ha escogido un cliente, si decide"
                    + " escoger otro se borraran los productos agregados para la venta...!!!\n"
                    + "Escriba 1 si desea continuar o cualquier otro caracter para cancelar ").charAt(0);
                if(x == '1'){
                    ProyectoIS2.ListaVenta.clear();
                    pass = true;
                    setVisible(false);
                    seleccionaClienteVenta = new  Frm_SeleccionaClienteVenta();
                    seleccionaClienteVenta.setVisible(true);
                }
                else{
                    return;
                }
            }while(!pass);   
        }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        
    }//GEN-LAST:event_btnSeleccionClienteActionPerformed

    private void txtBuscaProductosVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaProductosVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaProductosVentaActionPerformed

    private void txtBuscaProductosVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaProductosVentaKeyPressed
        // TODO add your handling code here:
        AccesoBD bd = new AccesoBD();
        String[] Titulos = {"Codigo", "Descripcion", "Precio"};
        String[] Registro = new String[50];
        
        String sql = "SELECT * FROM articulo WHERE codigo LIKE '%" + txtBuscaProductosVenta.getText()+ "%'"
            //+ "OR cantidad LIKE '%" + txtBuscaProductosVenta.getText() + "%'"
            + "OR descripcion LIKE '%" + txtBuscaProductosVenta.getText() + "%'"
            + "OR precio LIKE '%" + txtBuscaProductosVenta.getText() + "%'";
        
        model = new DefaultTableModel(null,Titulos);
        try {
            bd.conectaBD();
            Statement sta = bd.getConexion().createStatement();
            ResultSet rs= sta.executeQuery(sql);
            
            while(rs.next()){
                if(rs.getInt("stock") == 0){
                    
                }
                else{
                Registro[0] = rs.getString("codigo");
                //Registro[1] = rs.getString("cantidad");
                Registro[1] = rs.getString("descripcion");
                Registro[2] = rs.getString("precio");
                model.addRow(Registro);
                }
            }
            jtMuestraProductoVenta.setModel(model);
        } catch (Exception ex) {
            //Logger.getLogger(Frm_VentaProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtBuscaProductosVentaKeyPressed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
        if(txtCedulaVenta.getText().equals("")){
            JOptionPane.showMessageDialog(null, "No ha escogido a ningun cliente!!!",
                "", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(txtFacturaTotalaPagar.getText().equals("")){
            JOptionPane.showMessageDialog(null, "No hay ningun producto agregado!!!",
                "", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat form = new DecimalFormat("#.##", simbolos);
        boolean pass = false;
        double pagoc, cambio, total;
        total = Double.parseDouble(txtFacturaTotalaPagar.getText());
        do{
            try{
                do{
                pagoc = Double.parseDouble(JOptionPane.showInputDialog(null,
                    "Valor a total pagar: "+total+"\nIngrese el pago del cliente: ","",JOptionPane.INFORMATION_MESSAGE));
                if(pagoc>=total){
                    cambio = pagoc - total;
                    JOptionPane.showMessageDialog(null, "Su cambio: "+form.format(cambio));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Debe pagar completo");
                }
                }while(pagoc<total);
                pass = true;
            }catch(Exception e){
                pass = false;
            }
        }while(!pass);
        
        restaVendido();
        
        JOptionPane.showMessageDialog(null, "Gracias por su compra!!!");
        setVisible(false);
        try {
            ActualizarTabla();
        } catch (Exception ex) {
            
        }
        Factura f = new Factura();
        try {
             f = new Factura(f.obtieneIdCliente(txtCedulaVenta.getText()),Double.parseDouble(txtFacturaSubtotal.getText()),
                Double.parseDouble(txtFacturaIVA.getText()), txtDireccionVentas.getText());
            f.insertaFactura();
            llenaTabla2();
        ProyectoIS2.ListaVenta.clear();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnVentaProductosAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaProductosAgregar1ActionPerformed
        
        Articulo a = new Articulo();
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat form = new DecimalFormat("#.##", simbolos);
        boolean pass = false, pass2 = false, pass3 = false;   String codigoIn;
        int unidadesFactura=0, unidades;
        double total;
        pass = false;
        
        if(txtCedulaVenta.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Primero debe escoger un cliente...!!!", 
                "", JOptionPane.WARNING_MESSAGE );
            txtBuscaProductosVenta.setText("");
            btnSeleccionCliente.requestFocus();
            return;          
        }
          
    do{
        if(txtBuscaProductosVenta.getText().equals("")){
            JOptionPane.showMessageDialog(null,"El campo CÓDIGO esta vacío...!!!",
                "", JOptionPane.WARNING_MESSAGE);
            txtBuscaProductosVenta.requestFocus();
            return;
        }
        else{
            try {
                if(!a.verificaCodigo(txtBuscaProductosVenta.getText())){
                    JOptionPane.showMessageDialog(null, "El CÓDIGO ingresado no existe, "
                        + "ingrese o escoja uno valido...", "", JOptionPane.INFORMATION_MESSAGE);
                        txtBuscaProductosVenta.setText("");
                        txtBuscaProductosVenta.requestFocus();
                        return;
                } 
                else{
                    pass3 = true; 
                    pass = true;
                }            
            } catch (HeadlessException ex) {
                System.out.println(ex.toString());
            }
        }
    }while(!pass3);
        
        codigoIn = txtBuscaProductosVenta.getText();     
                
        //Proceso en caso de que encuentre el producto
        if(pass){           
            if(ProyectoIS2.ListaVenta.containsKey(codigoIn)) {
                unidadesFactura = ProyectoIS2.ListaVenta.get(codigoIn);
            } 
            else{
                unidadesFactura = 0;
            }
        do{
            
            try{
            unidades = Integer.parseInt(JOptionPane.showInputDialog("Unidades"
            + " Disponibles :"+(a.obtenerStock(codigoIn)-unidadesFactura)+"\nUnidades "
            + "en factura provisional : "+unidadesFactura+"\nUnidades que desea"
            + " agregar: "));
            if(unidades <= 0){
                JOptionPane.showMessageDialog(null, "La cantidad a escoger debe ser minimo 1","",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            }catch(Exception e ){
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad valida...!!!","",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
                try {
                    if((a.obtenerStock(codigoIn)- unidadesFactura) < unidades){
                        
                        JOptionPane.showMessageDialog(null, "No hay suficiente stock. "
                                + "Puede añadir a la venta un máximo de " + (a.obtenerStock(codigoIn)
                                    - unidadesFactura) + " unidades de ese producto.");
                        
                    }
                    
                    else if (ProyectoIS2.ListaVenta.containsKey(codigoIn)) {
                        
                        ProyectoIS2.ListaVenta.put(codigoIn, (ProyectoIS2.ListaVenta.get(codigoIn) + unidades));
                        po = codigoIn;
                        pass2 = true;
                        
                    }
                    
                    else {
                        
                        ProyectoIS2.ListaVenta.put(codigoIn, unidades);
                        po = codigoIn;
                        pass2 = true;
                    }   
                }catch (Exception ex) {
                    Logger.getLogger(Frm_VentaProductos1.class.getName()).log(Level.SEVERE, null, ex);
                }
        }while(!pass2);
        
        try {
            LlenarTabla();
        } catch (Exception ex){
            
        }
        txtFacturaSubtotal.setText(form.format(acu));
        txtFacturaIVA.setText(form.format(acu*0.12));
        total = Double.parseDouble(txtFacturaSubtotal.getText()) + Double.parseDouble(txtFacturaIVA.getText());
        txtFacturaTotalaPagar.setText(form.format(total));              
        }  
        
    }//GEN-LAST:event_btnVentaProductosAgregar1ActionPerformed

    private void jtMuestraProductoVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMuestraProductoVentaMouseClicked
        // TODO add your handling code here:
        int col = jtMuestraProductoVenta.getSelectedRow();
        
        txtBuscaProductosVenta.setText(jtMuestraProductoVenta.getModel().
                getValueAt(col, 0).toString());
    }//GEN-LAST:event_jtMuestraProductoVentaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_VentaProductos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_VentaProductos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_VentaProductos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_VentaProductos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_VentaProductos1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnSeleccionCliente;
    private javax.swing.JButton btnVentaProductosAgregar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpVentas;
    private javax.swing.JTable jtMuestraProductoVenta;
    private javax.swing.JTable jtProductosAgregadosVentas;
    private javax.swing.JLabel lblApellidosVentas;
    private javax.swing.JLabel lblCedulaVentas;
    private javax.swing.JLabel lblDireccionVentas;
    private javax.swing.JLabel lblFacturaIVA;
    private javax.swing.JLabel lblFacturaSubtotal;
    private javax.swing.JLabel lblFacturaTotal;
    private javax.swing.JLabel lblNombresVentas;
    private javax.swing.JLabel lblTelefonoVentas;
    private javax.swing.JLabel lblTituloVentas;
    public javax.swing.JTextField txtApellidosVentas;
    private javax.swing.JTextField txtBuscaProductosVenta;
    public javax.swing.JTextField txtCedulaVenta;
    public javax.swing.JTextField txtDireccionVentas;
    private javax.swing.JTextField txtFacturaIVA;
    private javax.swing.JTextField txtFacturaSubtotal;
    private javax.swing.JTextField txtFacturaTotalaPagar;
    public javax.swing.JTextField txtNombresVenta;
    public javax.swing.JTextField txtTelefonoVentas;
    // End of variables declaration//GEN-END:variables
}
