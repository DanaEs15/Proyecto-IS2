package proyectois2;

import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Daniela Espinosa
 */
public class Frm_RegistraProducto extends javax.swing.JFrame {

    /**
     * Creates new form Frm_RegistraProducto
     */
    Frm_MuestraFabricante muestraFabricante;
    
    public Frm_RegistraProducto() {
        initComponents();
        AjustarVentana();
        txtIngresoFabricanteProducto.setEnabled(false);
        LlenarCbm();
    }
    
    private void AjustarVentana(){
        //Centrar Ventana
        this.setLocationRelativeTo(null);  
        
        //Bloquear Tamanio
        this.setResizable(false);
    }
    
    public void Limpiar(){
        txtIngresoCodigoProducto.setText("");
        txtIngresoStockProducto.setText("");
        txtIngresoFabricanteProducto.setText("");
        txtIngresoNombreProducto.setText("");
        txtIngresoPrecioProducto.setText("");              
    }
    
    private void LlenarCbm(){
        Articulo ar = new Articulo();
        try {
            ar.Llena_Combo(jComboBox1);
        } catch (Exception ex) {
            
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

        jpRegistraProducto = new javax.swing.JPanel();
        lblIngresoCodigoProducto = new javax.swing.JLabel();
        lblIngresoNombreProducto = new javax.swing.JLabel();
        lblIngresoPrecioProducto = new javax.swing.JLabel();
        lblIngresoFabricanteProducto = new javax.swing.JLabel();
        txtIngresoCodigoProducto = new javax.swing.JTextField();
        txtIngresoNombreProducto = new javax.swing.JTextField();
        txtIngresoPrecioProducto = new javax.swing.JTextField();
        txtIngresoStockProducto = new javax.swing.JTextField();
        bntIngresoProductosGuardar = new javax.swing.JButton();
        bntIngresoProductosCancelar = new javax.swing.JButton();
        lblRegistrarProductos = new javax.swing.JLabel();
        lblIngresoStockProducto1 = new javax.swing.JLabel();
        txtIngresoFabricanteProducto = new javax.swing.JTextField();
        btnElijeFrabricante = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Producto");

        jpRegistraProducto.setBackground(new java.awt.Color(255, 102, 102));

        lblIngresoCodigoProducto.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        lblIngresoCodigoProducto.setForeground(new java.awt.Color(102, 0, 102));
        lblIngresoCodigoProducto.setText("Código:");
        lblIngresoCodigoProducto.setPreferredSize(new java.awt.Dimension(95, 45));

        lblIngresoNombreProducto.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        lblIngresoNombreProducto.setForeground(new java.awt.Color(102, 0, 102));
        lblIngresoNombreProducto.setText("Descripcion:");
        lblIngresoNombreProducto.setPreferredSize(new java.awt.Dimension(95, 45));

        lblIngresoPrecioProducto.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        lblIngresoPrecioProducto.setForeground(new java.awt.Color(102, 0, 102));
        lblIngresoPrecioProducto.setText("Precio:");
        lblIngresoPrecioProducto.setPreferredSize(new java.awt.Dimension(95, 45));

        lblIngresoFabricanteProducto.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        lblIngresoFabricanteProducto.setForeground(new java.awt.Color(102, 0, 102));
        lblIngresoFabricanteProducto.setText("Fabricante:");
        lblIngresoFabricanteProducto.setPreferredSize(new java.awt.Dimension(95, 45));

        txtIngresoCodigoProducto.setPreferredSize(new java.awt.Dimension(95, 45));
        txtIngresoCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIngresoCodigoProductoKeyTyped(evt);
            }
        });

        txtIngresoNombreProducto.setPreferredSize(new java.awt.Dimension(95, 45));

        txtIngresoPrecioProducto.setPreferredSize(new java.awt.Dimension(95, 45));
        txtIngresoPrecioProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIngresoPrecioProductoKeyTyped(evt);
            }
        });

        txtIngresoStockProducto.setPreferredSize(new java.awt.Dimension(95, 45));
        txtIngresoStockProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIngresoStockProductoKeyTyped(evt);
            }
        });

        bntIngresoProductosGuardar.setBackground(new java.awt.Color(251, 227, 185));
        bntIngresoProductosGuardar.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        bntIngresoProductosGuardar.setText("Guardar");
        bntIngresoProductosGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntIngresoProductosGuardarActionPerformed(evt);
            }
        });

        bntIngresoProductosCancelar.setBackground(new java.awt.Color(251, 227, 185));
        bntIngresoProductosCancelar.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        bntIngresoProductosCancelar.setText("Cancelar");
        bntIngresoProductosCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntIngresoProductosCancelarActionPerformed(evt);
            }
        });

        lblRegistrarProductos.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 36)); // NOI18N
        lblRegistrarProductos.setForeground(new java.awt.Color(102, 0, 102));
        lblRegistrarProductos.setText("Registrar Productos");

        lblIngresoStockProducto1.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        lblIngresoStockProducto1.setForeground(new java.awt.Color(102, 0, 102));
        lblIngresoStockProducto1.setText("Stock:");
        lblIngresoStockProducto1.setPreferredSize(new java.awt.Dimension(95, 45));

        txtIngresoFabricanteProducto.setPreferredSize(new java.awt.Dimension(95, 45));

        btnElijeFrabricante.setText("...");
        btnElijeFrabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElijeFrabricanteActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jpRegistraProductoLayout = new javax.swing.GroupLayout(jpRegistraProducto);
        jpRegistraProducto.setLayout(jpRegistraProductoLayout);
        jpRegistraProductoLayout.setHorizontalGroup(
            jpRegistraProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRegistraProductoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRegistrarProductos)
                .addGap(92, 92, 92))
            .addGroup(jpRegistraProductoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jpRegistraProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpRegistraProductoLayout.createSequentialGroup()
                        .addComponent(lblIngresoFabricanteProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIngresoFabricanteProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpRegistraProductoLayout.createSequentialGroup()
                        .addComponent(lblIngresoNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIngresoNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpRegistraProductoLayout.createSequentialGroup()
                        .addComponent(lblIngresoPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIngresoPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpRegistraProductoLayout.createSequentialGroup()
                        .addComponent(lblIngresoStockProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIngresoStockProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpRegistraProductoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblIngresoCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(231, 231, 231)
                        .addComponent(txtIngresoCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnElijeFrabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jpRegistraProductoLayout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(bntIngresoProductosGuardar)
                .addGap(120, 120, 120)
                .addComponent(bntIngresoProductosCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpRegistraProductoLayout.setVerticalGroup(
            jpRegistraProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistraProductoLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblRegistrarProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jpRegistraProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIngresoCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIngresoCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jpRegistraProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIngresoStockProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIngresoStockProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jpRegistraProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIngresoFabricanteProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIngresoFabricanteProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElijeFrabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jpRegistraProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIngresoNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIngresoNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jpRegistraProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIngresoPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIngresoPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jpRegistraProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntIngresoProductosGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntIngresoProductosCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpRegistraProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpRegistraProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntIngresoProductosCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntIngresoProductosCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_bntIngresoProductosCancelarActionPerformed

    private void bntIngresoProductosGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntIngresoProductosGuardarActionPerformed
        Articulo a = new Articulo();
        boolean pass = false, pass2 = false, pass3 = false, pass4 = false, pass5 = false;

        //Validaciones del campo de texto Código
        do{
            if(txtIngresoCodigoProducto.getText().equals("")){
                JOptionPane.showMessageDialog(null,"El campo CÓDIGO no debe estar vacío...!!!",
                    "", JOptionPane.WARNING_MESSAGE);
                txtIngresoCodigoProducto.requestFocus();
                return;
            }
            else{
                try {
                    if(a.verificaCodigo(txtIngresoCodigoProducto.getText())){
                        JOptionPane.showMessageDialog(null, "El CÓDIGO ingresado ya se encuentra en uso..."
                            , "", JOptionPane.INFORMATION_MESSAGE);
                        txtIngresoCodigoProducto.setText("");
                        txtIngresoCodigoProducto.requestFocus();
                        return;
                    }
                    else{
                        pass = true;
                    }
                } catch (Exception ex) {

                }
            }
        }while(!pass);

        //Validaciones del campo de texto Cantidad
        do{
            if(txtIngresoStockProducto.getText().equals("")){
                JOptionPane.showMessageDialog(null,"El campo CANTIDAD no debe estar vacío...!!!",
                    "",JOptionPane.WARNING_MESSAGE);
                txtIngresoStockProducto.requestFocus();
                return;
            }
            else if(Integer.parseInt(txtIngresoStockProducto.getText())<=0){
                JOptionPane.showMessageDialog(null,"La CANTIDAD no puede ser 0...!!!"
                    ,"",JOptionPane.WARNING_MESSAGE);
                txtIngresoStockProducto.setText("");
                txtIngresoStockProducto.requestFocus();
                return;
            }
            else{
                pass2 = true;
            }
        }while(!pass2);

        //Validaciones del campo de texto Descripción
        do{
            if(txtIngresoNombreProducto.getText().equals("")){
                JOptionPane.showMessageDialog(null,"El campo DESCRIPCIÓN no debe estar vacío...!!!",
                    "",JOptionPane.WARNING_MESSAGE);
                txtIngresoNombreProducto.requestFocus();
                return;
            }
            else{
                pass3 = true;
            }
        }while(!pass3);
        
        //Validaciones del campo de texto Descripción
        do{
            if(txtIngresoFabricanteProducto.getText().equals("")){
                JOptionPane.showMessageDialog(null,"El campo FABRICANTE no debe estar vacío...!!!",
                    "",JOptionPane.WARNING_MESSAGE);
                return;
            }
            else{
                pass4 = true;
            }
        }while(!pass4);

        //Validaciones del campo de texto Precio
        do{
            if(txtIngresoPrecioProducto.getText().equals("")){
                JOptionPane.showMessageDialog(null,"El campo PRECIO no debe estar vacío...!!!",
                    "",JOptionPane.WARNING_MESSAGE);
                txtIngresoPrecioProducto.requestFocus();
                return;
            }
            else if(Double.parseDouble(txtIngresoPrecioProducto.getText())<=0){
                JOptionPane.showMessageDialog(null,"El PRECIO no puede ser 0...!!!"
                    ,"",JOptionPane.WARNING_MESSAGE);
                txtIngresoPrecioProducto.setText("");
                txtIngresoPrecioProducto.requestFocus();
                return;
            }
            else{
                pass5 = true;
            }
        }while(!pass5);

        
        a = new Articulo(txtIngresoCodigoProducto.getText(),Integer.parseInt
            (txtIngresoStockProducto.getText()),Integer.parseInt(txtIngresoFabricanteProducto.getText()),
                txtIngresoNombreProducto.getText(),Double.parseDouble(txtIngresoPrecioProducto.getText()));

        try {
            a.insertaProducto();
        } catch (Exception ex) {
            ex.toString();
        }

        Limpiar();
        JOptionPane.showMessageDialog(null, "PRODUCTO agregado al inventario con éxito!!!"
            , "", JOptionPane.INFORMATION_MESSAGE);
        setVisible(false);
    }//GEN-LAST:event_bntIngresoProductosGuardarActionPerformed

    private void txtIngresoStockProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIngresoStockProductoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if((c<'0' || c>'9') && (c != KeyEvent.VK_BACK_SPACE)){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo se aceptan números enteros..."
                + " positvos!!!","",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtIngresoStockProductoKeyTyped

    private void txtIngresoPrecioProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIngresoPrecioProductoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if((c<'0' || c>'9') && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'||
            txtIngresoPrecioProducto.getText().contains("."))){
        evt.consume();
        JOptionPane.showMessageDialog(null, "Solo se aceptan números enteros "
            + "positivos y un punto decimal !!!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtIngresoPrecioProductoKeyTyped

    private void txtIngresoCodigoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIngresoCodigoProductoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if((c<'0' || c>'9') && (c != KeyEvent.VK_BACK_SPACE)){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo se aceptan números enteros"
                + " positvos...!!!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }

        if(txtIngresoCodigoProducto.getText().length()==8){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo se aceptan códigos de "
                + "máximo 8 dígitos!!!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtIngresoCodigoProductoKeyTyped

    private void btnElijeFrabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElijeFrabricanteActionPerformed
        // TODO add your handling code here: 
        Articulo av = new Articulo();
        try {
            String categoria1 = (String) jComboBox1.getSelectedItem();
            txtIngresoFabricanteProducto.setText(av.obtenerIdFabricante(categoria1));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
    }//GEN-LAST:event_btnElijeFrabricanteActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_RegistraProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_RegistraProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_RegistraProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_RegistraProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_RegistraProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntIngresoProductosCancelar;
    private javax.swing.JButton bntIngresoProductosGuardar;
    private javax.swing.JButton btnElijeFrabricante;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jpRegistraProducto;
    private javax.swing.JLabel lblIngresoCodigoProducto;
    private javax.swing.JLabel lblIngresoFabricanteProducto;
    private javax.swing.JLabel lblIngresoNombreProducto;
    private javax.swing.JLabel lblIngresoPrecioProducto;
    private javax.swing.JLabel lblIngresoStockProducto1;
    private javax.swing.JLabel lblRegistrarProductos;
    private javax.swing.JTextField txtIngresoCodigoProducto;
    private javax.swing.JTextField txtIngresoFabricanteProducto;
    private javax.swing.JTextField txtIngresoNombreProducto;
    private javax.swing.JTextField txtIngresoPrecioProducto;
    private javax.swing.JTextField txtIngresoStockProducto;
    // End of variables declaration//GEN-END:variables
}