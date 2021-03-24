
package proyectois2;

import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Daniela Espinosa
 */
public class Frm_RegistraCliente extends javax.swing.JFrame {

    /**
     * Creates new form Frm_RegistraCliente
     */
    public Frm_RegistraCliente() {
        initComponents();
        AjustarVentana();
    }
    
    public void Limpiar(){
        txtClienteCedula.setText("");
        txtClienteNombres.setText("");
        txtClienteApellidos.setText("");
        txtClienteDireccion.setText("");
        txtClienteTelefono.setText("");
    }

    private void AjustarVentana(){
        //Centrar Ventana
        this.setLocationRelativeTo(null);  
        
        //Bloquear Tamanio
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpRegistrarCliente = new javax.swing.JPanel();
        txtClienteTelefono = new javax.swing.JTextField();
        txtClienteNombres = new javax.swing.JTextField();
        lblClienteNombres = new javax.swing.JLabel();
        lblClienteCedula = new javax.swing.JLabel();
        txtClienteCedula = new javax.swing.JTextField();
        lblClienteDireccion = new javax.swing.JLabel();
        txtClienteDireccion = new javax.swing.JTextField();
        lblClienteTelefono = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bntIngresoClienteGuardar = new javax.swing.JButton();
        bntIngresoClienteCancelar = new javax.swing.JButton();
        txtClienteApellidos = new javax.swing.JTextField();
        lblClienteApellidos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Cliente");

        jpRegistrarCliente.setBackground(new java.awt.Color(255, 241, 207));
        jpRegistrarCliente.setForeground(new java.awt.Color(240, 240, 240));

        txtClienteTelefono.setPreferredSize(new java.awt.Dimension(6, 25));
        txtClienteTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClienteTelefonoKeyTyped(evt);
            }
        });

        txtClienteNombres.setPreferredSize(new java.awt.Dimension(6, 25));

        lblClienteNombres.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        lblClienteNombres.setForeground(new java.awt.Color(38, 63, 68));
        lblClienteNombres.setText("Nombres:");
        lblClienteNombres.setMaximumSize(new java.awt.Dimension(95, 45));
        lblClienteNombres.setMinimumSize(new java.awt.Dimension(95, 45));
        lblClienteNombres.setPreferredSize(new java.awt.Dimension(95, 45));

        lblClienteCedula.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        lblClienteCedula.setForeground(new java.awt.Color(38, 63, 68));
        lblClienteCedula.setText("Cédula:");
        lblClienteCedula.setMaximumSize(new java.awt.Dimension(95, 45));
        lblClienteCedula.setMinimumSize(new java.awt.Dimension(95, 45));
        lblClienteCedula.setPreferredSize(new java.awt.Dimension(95, 45));

        txtClienteCedula.setPreferredSize(new java.awt.Dimension(6, 25));
        txtClienteCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClienteCedulaKeyTyped(evt);
            }
        });

        lblClienteDireccion.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        lblClienteDireccion.setForeground(new java.awt.Color(38, 63, 68));
        lblClienteDireccion.setText("Dirección:");
        lblClienteDireccion.setMaximumSize(new java.awt.Dimension(95, 45));
        lblClienteDireccion.setMinimumSize(new java.awt.Dimension(95, 45));
        lblClienteDireccion.setPreferredSize(new java.awt.Dimension(95, 45));

        txtClienteDireccion.setPreferredSize(new java.awt.Dimension(6, 25));

        lblClienteTelefono.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        lblClienteTelefono.setForeground(new java.awt.Color(38, 63, 68));
        lblClienteTelefono.setText("Teléfono:");
        lblClienteTelefono.setMaximumSize(new java.awt.Dimension(95, 45));
        lblClienteTelefono.setMinimumSize(new java.awt.Dimension(95, 45));
        lblClienteTelefono.setPreferredSize(new java.awt.Dimension(95, 45));

        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(38, 63, 68));
        jLabel1.setText("Registrar Cliente");

        bntIngresoClienteGuardar.setBackground(new java.awt.Color(255, 211, 105));
        bntIngresoClienteGuardar.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        bntIngresoClienteGuardar.setForeground(new java.awt.Color(1, 86, 104));
        bntIngresoClienteGuardar.setText("Guardar");
        bntIngresoClienteGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntIngresoClienteGuardarActionPerformed(evt);
            }
        });

        bntIngresoClienteCancelar.setBackground(new java.awt.Color(255, 211, 105));
        bntIngresoClienteCancelar.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        bntIngresoClienteCancelar.setForeground(new java.awt.Color(1, 86, 104));
        bntIngresoClienteCancelar.setText("Cancelar");
        bntIngresoClienteCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntIngresoClienteCancelarActionPerformed(evt);
            }
        });

        txtClienteApellidos.setPreferredSize(new java.awt.Dimension(6, 25));
        txtClienteApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteApellidosActionPerformed(evt);
            }
        });

        lblClienteApellidos.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        lblClienteApellidos.setForeground(new java.awt.Color(38, 63, 68));
        lblClienteApellidos.setText("Apellidos:");
        lblClienteApellidos.setMaximumSize(new java.awt.Dimension(95, 45));
        lblClienteApellidos.setMinimumSize(new java.awt.Dimension(95, 45));
        lblClienteApellidos.setPreferredSize(new java.awt.Dimension(95, 45));

        javax.swing.GroupLayout jpRegistrarClienteLayout = new javax.swing.GroupLayout(jpRegistrarCliente);
        jpRegistrarCliente.setLayout(jpRegistrarClienteLayout);
        jpRegistrarClienteLayout.setHorizontalGroup(
            jpRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistrarClienteLayout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(bntIngresoClienteGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntIngresoClienteCancelar)
                .addGap(117, 117, 117))
            .addGroup(jpRegistrarClienteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpRegistrarClienteLayout.createSequentialGroup()
                        .addComponent(lblClienteCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(txtClienteCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpRegistrarClienteLayout.createSequentialGroup()
                        .addGroup(jpRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblClienteNombres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblClienteApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblClienteDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                .addComponent(lblClienteTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(42, 42, 42)
                        .addGroup(jpRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClienteTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClienteDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClienteApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClienteNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRegistrarClienteLayout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(100, 100, 100))
        );
        jpRegistrarClienteLayout.setVerticalGroup(
            jpRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistrarClienteLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(jpRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtClienteCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClienteCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jpRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClienteNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClienteNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jpRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClienteApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClienteApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jpRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblClienteDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(jpRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblClienteTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(jpRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntIngresoClienteGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntIngresoClienteCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpRegistrarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClienteCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteCedulaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if((c<'0' || c>'9') && (c != KeyEvent.VK_BACK_SPACE)){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo se aceptan números enteros"
                + " positvos...!!!", "", JOptionPane.WARNING_MESSAGE);
        }
        if(txtClienteCedula.getText().length()==10){
            evt.consume();
            JOptionPane.showMessageDialog(null, "La CÉDULA solo debe "
                + "tener máximo 10 dígitos!!!", "", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtClienteCedulaKeyTyped

    private void txtClienteTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteTelefonoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if((c<'0' || c>'9') && (c != KeyEvent.VK_BACK_SPACE)){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo se aceptan números enteros"
                + " positvos...!!!", "", JOptionPane.WARNING_MESSAGE);
        }
        if(txtClienteTelefono.getText().length()==10){
            evt.consume();
            JOptionPane.showMessageDialog(null, "El TELÉFONO solo debe "
                + "tener máximo 10 dígitos!!!", "", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtClienteTelefonoKeyTyped

    private void bntIngresoClienteGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntIngresoClienteGuardarActionPerformed
        Cliente c = new Cliente();
        boolean pass = false, pass2 = false, pass3 = false, pass4 = false, pass5 = false;

        //Validaciones del campo de texto Cédula
        do{
            if(txtClienteCedula.getText().equals("")){
                JOptionPane.showMessageDialog(null,"El campo CÉDULA no debe estar vacío...!!!",
                    "", JOptionPane.WARNING_MESSAGE);
                txtClienteCedula.requestFocus();
                return;
            }
            else if(txtClienteCedula.getText().length()<10){
                JOptionPane.showMessageDialog(null,"El campo CÉDULA debe tener 10 dígitos...!!!",
                    "", JOptionPane.WARNING_MESSAGE);
                txtClienteCedula.requestFocus();
                return;
            }
            else{
                try {
                    if(c.verificaCedula(txtClienteCedula.getText()).equals(txtClienteCedula.getText())){
                        JOptionPane.showMessageDialog(null, "LA CÉDULA ingresada ya se encuentra "
                            + "en la base de datos...", "", JOptionPane.INFORMATION_MESSAGE);
                        txtClienteCedula.setText("");
                        txtClienteCedula.requestFocus();
                        return;
                    }
                    else{
                        pass = true;
                    }
                } catch (Exception ex) {

                }
            }
        }while(!pass);

        //Validaciones del campo de texto Nombres
        do{
            if(txtClienteNombres.getText().equals("")){
                JOptionPane.showMessageDialog(null,"El campo NOMBRES no debe estar vacío...!!!",
                    "",JOptionPane.WARNING_MESSAGE);
                txtClienteNombres.requestFocus();
                return;
            }
            else{
                pass2 = true;
            }
        }while(!pass2);

        //Validaciones del campo de texto Apellidos
        do{
            if(txtClienteApellidos.getText().equals("")){
                JOptionPane.showMessageDialog(null,"El campo APELLIDOS no debe estar vacío...!!!",
                    "",JOptionPane.WARNING_MESSAGE);
                txtClienteApellidos.requestFocus();
                return;
            }
            else{
                pass3 = true;
            }
        }while(!pass3);

        //Validaciones del campo de texto Dirección
        do{
            if(txtClienteDireccion.getText().equals("")){
                JOptionPane.showMessageDialog(null,"El campo DIRECCIÓN no debe estar vacío...!!!",
                    "",JOptionPane.WARNING_MESSAGE);
                txtClienteDireccion.requestFocus();
                return;
            }            
            else{
                pass4 = true;
            }
        }while(!pass4);
        
        //Validaciones del campo de texto Teléfono
        do{
            if(txtClienteTelefono.getText().equals("")){
                JOptionPane.showMessageDialog(null,"El campo TELÉFONO no debe estar vacío...!!!",
                    "",JOptionPane.WARNING_MESSAGE);
                txtClienteTelefono.requestFocus();
                return;
            }
            else if(txtClienteTelefono.getText().length()<9){
                JOptionPane.showMessageDialog(null,"EL TELÉFONO debe tener al menos 9 dígitos...!!!"
                    ,"",JOptionPane.WARNING_MESSAGE);
                txtClienteTelefono.setText("");
                txtClienteTelefono.requestFocus();
                return;
            }
            else{
                pass5 = true;
            }
        }while(!pass5);

        c = new Cliente(txtClienteCedula.getText(), txtClienteNombres.getText(),
            txtClienteApellidos.getText(), txtClienteDireccion.getText(),
            txtClienteTelefono.getText());
        try {
            c.insertaCliente();
        } catch (Exception ex) {

        }
        Limpiar();
        JOptionPane.showMessageDialog(null, "CLIENTE ingresado a la base de datos con éxito!!!"
            , "", JOptionPane.INFORMATION_MESSAGE);
        setVisible(false);
    }//GEN-LAST:event_bntIngresoClienteGuardarActionPerformed

    private void bntIngresoClienteCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntIngresoClienteCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_bntIngresoClienteCancelarActionPerformed

    private void txtClienteApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteApellidosActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_RegistraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_RegistraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_RegistraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_RegistraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_RegistraCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntIngresoClienteCancelar;
    private javax.swing.JButton bntIngresoClienteGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jpRegistrarCliente;
    private javax.swing.JLabel lblClienteApellidos;
    private javax.swing.JLabel lblClienteCedula;
    private javax.swing.JLabel lblClienteDireccion;
    private javax.swing.JLabel lblClienteNombres;
    private javax.swing.JLabel lblClienteTelefono;
    private javax.swing.JTextField txtClienteApellidos;
    private javax.swing.JTextField txtClienteCedula;
    private javax.swing.JTextField txtClienteDireccion;
    private javax.swing.JTextField txtClienteNombres;
    private javax.swing.JTextField txtClienteTelefono;
    // End of variables declaration//GEN-END:variables
}