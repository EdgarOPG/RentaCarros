/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Dani
 */
public class BuscarVehiculo extends javax.swing.JFrame {
    
    int count = 0;
    static int IdVehiculo;
    
    /**
     * Creates new form BuscarVehiculo
     */
    public BuscarVehiculo() {
        initComponents();
        listInfo("");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        txtBuscar.requestFocus();
        this.setLocationRelativeTo(null);
        this.setTitle("Buscar Vehiculo");
    }
    
    /**
     * Metodo para enlistar los vehiculos, faltan las busquedas sql
     */
    private void listInfo(String x) {
        int y;
        DefaultTableModel modelo1 = (DefaultTableModel) jTable1.getModel();
        for (y = jTable1.getRowCount() - 1; y >= 0; y--) 
        {
            modelo1.removeRow(y);
        }
        ResultSet data = sql.Vehiculos.buscarVehiculo(x);
        try {
            while (data.next()) {
                int codigo = data.getInt("ID_VEHICULO");
                String marca = data.getString("MARCA");
                String modelo = data.getString("MODELO");
                String color = data.getString("COLOR");
                String transmision = data.getString("TRANSMISION");
                float precio = data.getFloat("PRECIO_RENTA");
                float tanque = data.getFloat("TANQUE");
                modelo1.addRow(new Object[]{codigo, marca, modelo, color, transmision, tanque, precio});
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
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

        Nombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Nombre.setText("Marca del Vehiculo:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Marca", "Modelo", "Color", "Transmision", "Tanque", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(txtBuscar))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Nombre))
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        count++;
        //Evalua si el renglon de la tabla es clickeado dos veces.
        if (count == 2) {
            pasarDatos();
            count = 0;
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
       
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String texto = txtBuscar.getText();
        listInfo(texto);
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
      
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             pasarDatos();
         }
    }//GEN-LAST:event_jTable1KeyPressed

    public void pasarDatos(){
        int row = jTable1.getSelectedRow();
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            //Toma el valor del String en la posicion 1 del renglon, es decir el nombre y obtiene el Id 
            //con el metodo obtenerCodigo que esta en la clase Inicio.
            int id = (int) modelo.getValueAt(row, 0);
            String marca = (String) modelo.getValueAt(row, 1);
            String modelo1 = (String) modelo.getValueAt(row, 2);
            String color = (String) modelo.getValueAt(row, 3);
            float precio = (Float) modelo.getValueAt(row, 6);
//            System.out.println(modelo.getValueAt(row, 1));
            String codigo = sql.Vehiculos.codigo(marca, modelo1, color, precio);
            Inicio.obtenerCodigo(codigo);
            setIdVehiculo(id);
            JOptionPane.showMessageDialog(this, "Vehiculo seleccionado exitosamente.");
            this.dispose();
    }
    
    public static void setIdVehiculo(int id) {
        IdVehiculo = id;
    }
    
    public static int getIdVehiculo() {
        return IdVehiculo;
    }
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
            java.util.logging.Logger.getLogger(BuscarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarVehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton jButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
