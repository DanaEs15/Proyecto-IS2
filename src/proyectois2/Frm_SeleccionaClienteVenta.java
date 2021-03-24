/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectois2;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniela Espinosa
 */
public class Frm_SeleccionaClienteVenta extends javax.swing.JFrame {
    DefaultTableModel model;
    Frm_VentaProductos1 ventaProductos1;
            
    /**
     * Creates new form Frm_SeleccionaClienteVenta
     */
    public Frm_SeleccionaClienteVenta() {
        initComponents();
        AjustarVentana();
        try {
            mostrarTabla();
        } catch (Exception ex) {
            Logger.getLogger(Frm_SeleccionaClienteVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void AjustarVentana(){
        //Centrar Ventana
        this.setLocationRelativeTo(null);  
        
        //Bloquear Tamanio
        this.setResizable(false);
    }
    
    public void Limpiar(){
        ventaProductos1.txtCedulaVenta.setText("");
        ventaProductos1.txtNombresVenta.setText("");
        ventaProductos1.txtApellidosVentas.setText("");
        ventaProductos1.txtDireccionVentas.setText("");
        ventaProductos1.txtTelefonoVentas.setText("");
    }
    
    public final void mostrarTabla() throws Exception{
    DefaultTableModel modelo = new DefaultTableModel();
        AccesoBD bd = new AccesoBD();
        ResultSet rs = bd.getTabla("SELECT cedula, nombres, apellidos, direccion, telefono FROM cliente");
        modelo.setColumnIdentifiers(new Object[]{"Cedula", "Nombres", "Apellidos", "Direccion","Telefono"});
        try{
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getString("cedula"), rs.getString("nombres"),
                rs.getString("apellidos"), rs.getString("direccion"), rs.getString("telefono")});
            }
            jtMuestraClientesVenta.setModel(modelo);
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBuscaClienteVenta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMuestraClientesVenta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selección del Cliente");

        jPanel1.setBackground(new java.awt.Color(211, 244, 255));

        txtBuscaClienteVenta.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtBuscaClienteVenta.setForeground(new java.awt.Color(204, 153, 0));
        txtBuscaClienteVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaClienteVentaKeyPressed(evt);
            }
        });

        jtMuestraClientesVenta = new javax.swing.JTable(){
            public boolean isCellEditable (int rowIndex, int colIndex){
                return false;
            }
        };
        jtMuestraClientesVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtMuestraClientesVenta.getTableHeader().setReorderingAllowed(false);
        jtMuestraClientesVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMuestraClientesVentaMouseClicked(evt);
            }
        });
        jtMuestraClientesVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtMuestraClientesVentaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtMuestraClientesVenta);

        jLabel1.setFont(new java.awt.Font("Bauhaus 93", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(231, 164, 228));
        jLabel1.setText("Buscar Cliente:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(txtBuscaClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscaClienteVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaClienteVentaKeyPressed
        // TODO add your handling code here:
        AccesoBD bd = new AccesoBD();
        String[] Titulos = {"Cédula", "Nombres", "Apellidos", "Dirección", "Teléfono"};
        String[] Registro = new String[50];

        String sql = "SELECT * FROM cliente WHERE cedula LIKE '%" + txtBuscaClienteVenta.getText()+ "%'"
        + "OR nombres LIKE '%" + txtBuscaClienteVenta.getText() + "%'"
        + "OR apellidos LIKE '%" + txtBuscaClienteVenta.getText() + "%'"
        + "OR direccion LIKE '%" + txtBuscaClienteVenta.getText() + "%'"
        + "OR telefono LIKE '%" + txtBuscaClienteVenta.getText() + "%'";

        model = new DefaultTableModel(null,Titulos);
        try {
            bd.conectaBD();
            Statement sta = bd.getConexion().createStatement();
            ResultSet rs= sta.executeQuery(sql);

            while(rs.next()){
                Registro[0] = rs.getString("cedula");
                Registro[1] = rs.getString("nombres");
                Registro[2] = rs.getString("apellidos");
                Registro[3] = rs.getString("direccion");
                Registro[4] = rs.getString("telefono");
                model.addRow(Registro);
            }
            jtMuestraClientesVenta.setModel(model);
        } catch (Exception ex) {
            //Logger.getLogger(Frm_VentaProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtBuscaClienteVentaKeyPressed

    private void jtMuestraClientesVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMuestraClientesVentaMouseClicked
        // TODO add your handling code here:
        //Limpiar();
        ventaProductos1 = new Frm_VentaProductos1();
        try{
        int col = jtMuestraClientesVenta.getSelectedRow();
        ventaProductos1.txtCedulaVenta.setText(jtMuestraClientesVenta.getModel().getValueAt(col, 0).toString());
        ventaProductos1.txtNombresVenta.setText(jtMuestraClientesVenta.getModel().getValueAt(col, 1).toString());
        ventaProductos1.txtApellidosVentas.setText(jtMuestraClientesVenta.getModel().getValueAt(col, 2).toString());
        ventaProductos1.txtDireccionVentas.setText(jtMuestraClientesVenta.getModel().getValueAt(col, 3).toString());
        ventaProductos1.txtTelefonoVentas.setText(jtMuestraClientesVenta.getModel().getValueAt(col, 4).toString());
        setVisible(false);
        ventaProductos1.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_jtMuestraClientesVentaMouseClicked

    private void jtMuestraClientesVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtMuestraClientesVentaKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jtMuestraClientesVentaKeyPressed

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
            java.util.logging.Logger.getLogger(Frm_SeleccionaClienteVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_SeleccionaClienteVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_SeleccionaClienteVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_SeleccionaClienteVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_SeleccionaClienteVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtMuestraClientesVenta;
    private javax.swing.JTextField txtBuscaClienteVenta;
    // End of variables declaration//GEN-END:variables
}