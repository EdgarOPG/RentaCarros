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
public class Clientes {

    Conexion cn;
    
    public Clientes() {
    cn = new Conexion();
    }
    
    public void altaClientes(String nombre, String fechaNacimiento,
                             int NoLicencia, String direccion,
                             String ciudad, String email,  
                             String telefono, String referencia)
    {
        String Query = "insert into EMPLEADOS(NOMBRE, FECHA_NACIMIENTO,"
                                            + " NUMERO_LICENCIA, DIRECCION,"
                                            + " CIUDAD, EMAIL,"
                                            + " TELEFONO, REFERENCIA)"
                                            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        ResultSet rs = null;
        try {
            PreparedStatement ps = cn.Conectar().prepareStatement(Query);
            ps.setString(1, nombre);
            ps.setString(2, fechaNacimiento);
            ps.setInt(3, NoLicencia);
            ps.setString(4, direccion);
            ps.setString(5, ciudad);
            ps.setString(6, email);
            ps.setString(7, telefono);
            ps.setString(8, referencia);
            if(ps.execute())
            {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el registro");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Datos correctamente guardados");
            }
            cn.Desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    };
}
