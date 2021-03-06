/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectois2;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author PJ_Yeah
 */
public class Frm_ActualizaDatosFabricante extends javax.swing.JFrame {

    /** Creates new form Frm_ActualizaDatosFabricante */
    public Frm_ActualizaDatosFabricante() {
        initComponents();
        AjustarVentana();
        Limpiar();
        RecuperaDatos();
    }
    
    private void AjustarVentana(){
        //Centrar Ventana
        this.setLocationRelativeTo(null);  
        
        //Bloquear Tamanio
        this.setResizable(false);
    }
    
    private void Limpiar(){
        txtIModificaFabricante.setText("");
    }
    
    private void RecuperaDatos(){
        try{
            AccesoBD bd = new AccesoBD();
            bd.conectaBD();
            String sql = "SELECT nombre_fabricante FROM fabricante "
                + "WHERE id_fabricante = '" + ProyectoIS2._Fab + "'"; 
            Statement sta = bd.getConexion().createStatement();
            ResultSet rs= sta.executeQuery(sql);

            while(rs.next()){
                txtIModificaFabricante.setText(rs.getString("nombre_fabricante"));
            }
                
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString(), "", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpActualizaDatosFabricante = new javax.swing.JPanel();
        lblFabricante = new javax.swing.JLabel();
        bntIngresoProductosGuardar = new javax.swing.JButton();
        bntIngresoProductosCancelar = new javax.swing.JButton();
        lblModificaFabricante = new javax.swing.JLabel();
        txtIModificaFabricante = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizaci??n Fabricante");

        jpActualizaDatosFabricante.setBackground(new java.awt.Color(242, 230, 53));

        lblFabricante.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        lblFabricante.setForeground(new java.awt.Color(110, 13, 37));
        lblFabricante.setText("Fabricante:");
        lblFabricante.setPreferredSize(new java.awt.Dimension(95, 45));

        bntIngresoProductosGuardar.setBackground(new java.awt.Color(241, 235, 228));
        bntIngresoProductosGuardar.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        bntIngresoProductosGuardar.setForeground(new java.awt.Color(167, 152, 139));
        bntIngresoProductosGuardar.setText("Guardar");
        bntIngresoProductosGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntIngresoProductosGuardarActionPerformed(evt);
            }
        });

        bntIngresoProductosCancelar.setBackground(new java.awt.Color(241, 235, 228));
        bntIngresoProductosCancelar.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        bntIngresoProductosCancelar.setForeground(new java.awt.Color(167, 152, 139));
        bntIngresoProductosCancelar.setText("Cancelar");
        bntIngresoProductosCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntIngresoProductosCancelarActionPerformed(evt);
            }
        });

        lblModificaFabricante.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 36)); // NOI18N
        lblModificaFabricante.setForeground(new java.awt.Color(110, 13, 37));
        lblModificaFabricante.setText("Modifica Fabricante");

        txtIModificaFabricante.setPreferredSize(new java.awt.Dimension(95, 45));

        javax.swing.GroupLayout jpActualizaDatosFabricanteLayout = new javax.swing.GroupLayout(jpActualizaDatosFabricante);
        jpActualizaDatosFabricante.setLayout(jpActualizaDatosFabricanteLayout);
        jpActualizaDatosFabricanteLayout.setHorizontalGroup(
            jpActualizaDatosFabricanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpActualizaDatosFabricanteLayout.createSequentialGroup()
                .addGroup(jpActualizaDatosFabricanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpActualizaDatosFabricanteLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpActualizaDatosFabricanteLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(bntIngresoProductosGuardar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpActualizaDatosFabricanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpActualizaDatosFabricanteLayout.createSequentialGroup()
                        .addComponent(bntIngresoProductosCancelar)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpActualizaDatosFabricanteLayout.createSequentialGroup()
                        .addComponent(txtIModificaFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpActualizaDatosFabricanteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblModificaFabricante)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpActualizaDatosFabricanteLayout.setVerticalGroup(
            jpActualizaDatosFabricanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpActualizaDatosFabricanteLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblModificaFabricante)
                .addGap(45, 45, 45)
                .addGroup(jpActualizaDatosFabricanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIModificaFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jpActualizaDatosFabricanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntIngresoProductosGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntIngresoProductosCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpActualizaDatosFabricante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpActualizaDatosFabricante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntIngresoProductosGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntIngresoProductosGuardarActionPerformed
        Fabricante f;
        String _fabricante = ProyectoIS2._Fab; 
        boolean pass = false;

        //Validaciones del campo de texto Fabricante
        do{
            if(txtIModificaFabricante.getText().equals("")){
                JOptionPane.showMessageDialog(null,"El campo FABRICANTE no debe estar vac??o...!!!",
                    "",JOptionPane.WARNING_MESSAGE);
                txtIModificaFabricante.requestFocus();
                return;
            }
            else{
                pass = true;
            }
        }while(!pass);

        f = new Fabricante(txtIModificaFabricante.getText());

        try {
            f.modificaFabricante(_fabricante);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        Limpiar();
        JOptionPane.showMessageDialog(null, "Datos de FABRICANTE modificados con ??xito!!!"
            , "", JOptionPane.INFORMATION_MESSAGE);
        setVisible(false);
    }//GEN-LAST:event_bntIngresoProductosGuardarActionPerformed

    private void bntIngresoProductosCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntIngresoProductosCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_bntIngresoProductosCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_ActualizaDatosFabricante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_ActualizaDatosFabricante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_ActualizaDatosFabricante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_ActualizaDatosFabricante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_ActualizaDatosFabricante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntIngresoProductosCancelar;
    private javax.swing.JButton bntIngresoProductosGuardar;
    private javax.swing.JPanel jpActualizaDatosFabricante;
    private javax.swing.JLabel lblFabricante;
    private javax.swing.JLabel lblModificaFabricante;
    private javax.swing.JTextField txtIModificaFabricante;
    // End of variables declaration//GEN-END:variables

}
