/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author eopg9
 */
public class Vehiculos {
    Conexion cn;
    public Vehiculos() {
    cn = new Conexion();
    }
    
    public void AltaVehiculos(String marca, int modelo,
                              String color, String transmision, 
                              Float precio, Float tanque,
                              int inventario)
    {
    String Query = "insert into VEHICULO(MARCA, MODELO,"
                                        + " COLOR, TRANSMISION,"
                                        + " PRECIO_RENTA, TANQUE,"
                                        + " INVENTARIO)"
                                        + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        ResultSet rs = null;
        try {
            PreparedStatement ps = cn.Conectar().prepareStatement(Query);
            ps.setString(1, marca);
            ps.setInt(2, modelo);
            ps.setString(3, color);
            ps.setString(4, transmision);
            ps.setFloat(5, precio);
            ps.setFloat(6, tanque);
            ps.setInt(7, inventario);
            if(ps.execute())
            {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el registro");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Datos correctamente guardados");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
}
