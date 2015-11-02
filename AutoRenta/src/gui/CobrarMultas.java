package gui;

import static gui.DevolucionVehiculo.jTable1;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tux
 */
public class CobrarMultas extends javax.swing.JFrame {

    float total = DevolucionVehiculo.MultaTotal;
    boolean ready = false;
    static double Cobro;
    static double Dias;

    /**
     * Creates new form cobrar
     */
    public CobrarMultas() {
        initComponents();
        val.efectivo(pagar_entregado);
        cobrar_total.setText(Format.Mxn(total));
        pagar_entregado.setText(String.valueOf(total));
        cmdCobrar.setEnabled(true);
        pagar_entregado.requestFocus();
        pagar_entregado.selectAll();
        ready = true;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    public void cambio() {
        Double entregado = 0.00;
        Double cambio = 0.00;
        if (!(pagar_entregado.getText().equals(""))) {
            entregado = Double.parseDouble(pagar_entregado.getText());
            if (entregado >= total) {
                cambio = entregado - total;
                pago_cambio.setText(Format.Mxn(cambio));
                cmdCobrar.setEnabled(true);
            } else {
                pago_cambio.setText(Format.Mxn(0));
                cmdCobrar.setEnabled(false);
            }
        } else {
            pago_cambio.setText(Format.Mxn(0));
            cmdCobrar.setEnabled(false);
        }
    }

    public static void setCobro(double totalCobrar) {
        Cobro = totalCobrar;
    }

    public static double getCobro() {
        return Cobro;
    }


    public void cobrar() {
        java.util.Date ahora = new java.util.Date();
        String Regreso = Fechas.sumarFechasDias(ahora, Inicio.getDiasRenta());
        int x;
        int tipoPago = 1;
        double entregado = Double.parseDouble(pagar_entregado.getText());
        DefaultTableModel venta = (DefaultTableModel) Inicio.frm_renta.getModel();
        DefaultTableModel venta1 = (DefaultTableModel) DevolucionVehiculo.jTable1.getModel();
        int row = jTable1.getSelectedRow();
        int id = (Integer) venta1.getValueAt(row, 0);
       if (sql.Vehiculos.devolverVehiculo(id)) {
                    JOptionPane.showMessageDialog(this, "Vehiculo Devuelto.");
                    DevolucionVehiculo.listInfo("");
                    DevolucionVehiculo.txtBuscar.setText(null);
                    DevolucionVehiculo.txtBuscar.requestFocus();
                    DevolucionVehiculo.count = 0;
                } else {
                    JOptionPane.showMessageDialog(this, "Error al devolver vehiculo.");
                }
            this.dispose();
        }


    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cobrar_total = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pagar_entregado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pago_cambio = new javax.swing.JLabel();
        cmdCobrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setText("Total a pagar");

        cobrar_total.setText("$ 0.00");

        jLabel3.setText("Entregado");

        pagar_entregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagar_entregadoActionPerformed(evt);
            }
        });
        pagar_entregado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pagar_entregadoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pagar_entregadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pagar_entregadoKeyTyped(evt);
            }
        });

        jLabel4.setText("Su cambio");

        pago_cambio.setText("$ 0.00");

        cmdCobrar.setText("Cobrar");
        cmdCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCobrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cobrar_total)
                            .addComponent(pago_cambio)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdCobrar)
                            .addComponent(pagar_entregado, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cobrar_total))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pagar_entregado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pago_cambio)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(cmdCobrar)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void cmdCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCobrarActionPerformed
        cobrar();
        this.dispose();
    }//GEN-LAST:event_cmdCobrarActionPerformed

    private void pagar_entregadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pagar_entregadoKeyTyped
        //        cambio();
    }//GEN-LAST:event_pagar_entregadoKeyTyped

    private void pagar_entregadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pagar_entregadoKeyReleased
        cambio();
    }//GEN-LAST:event_pagar_entregadoKeyReleased

    private void pagar_entregadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pagar_entregadoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cobrar();
            this.dispose();
        }
    }//GEN-LAST:event_pagar_entregadoKeyPressed

    private void pagar_entregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagar_entregadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagar_entregadoActionPerformed

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
            java.util.logging.Logger.getLogger(CobrarMultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CobrarMultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CobrarMultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CobrarMultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new CobrarMultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdCobrar;
    private javax.swing.JLabel cobrar_total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField pagar_entregado;
    private javax.swing.JLabel pago_cambio;
    // End of variables declaration//GEN-END:variables
}
