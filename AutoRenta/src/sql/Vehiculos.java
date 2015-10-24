/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.Connection;
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

    /**
     * Metodo para agregar vehiculos a la base de datos
     *
     * @param marca
     * @param modelo
     * @param color
     * @param transmision
     * @param precio
     * @param tanque
     * @param inventario
     * @return
     */
    public static boolean addVehiculos(String marca, String modelo, String color,
            String transmision, float precio, float tanque, int inventario) {
        sql.Conexion mysql = new sql.Conexion();
        Connection link = mysql.Conectar();
        String Query = "insert into VEHICULO(MARCA, MODELO,"
                + " COLOR, TRANSMISION,"
                + " PRECIO_RENTA, TANQUE,"
                + " INVENTARIO)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stat = link.prepareStatement(Query);

            stat.setString(1, marca);
            stat.setString(2, modelo);
            stat.setString(3, color);
            stat.setString(4, transmision);
            stat.setFloat(5, precio);
            stat.setFloat(6, tanque);
            stat.setInt(7, inventario);
            stat.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Vehiculos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Metodo para obtener todos los datos del vehiculo de la base de datos
     *
     * @return
     */
    public static ResultSet getVehiculos() {
        ResultSet val = null;
        sql.Conexion mysql = new sql.Conexion();
        Connection link = mysql.Conectar();
        String Query;

        Query = "SELECT * FROM VEHICULOS";

        try {
            PreparedStatement stat = link.prepareStatement(Query);

            val = stat.executeQuery();

            return val;

        } catch (SQLException ex) {
            Logger.getLogger(Vehiculos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * Metodo para modificar todos los campos del vehiculo de la base de datos
     * @param marca
     * @param modelo
     * @param color
     * @param transmision
     * @param precio
     * @param tanque
     * @param inventario
     * @param codVehiculo
     * @param año
     * @return 
     */
    public static boolean modificarVehiculos(String marca, String modelo, String color,
            String transmision, Float precio, Float tanque, int inventario, int codVehiculo, int año) {
    sql.Conexion mysql = new sql.Conexion();
        Connection link = mysql.Conectar();
        String Query;

        Query = "UPDATE VEHICULOS SET  MARCA=?, MODELO=?, COLOR=?, TRANSMISION=?, "
                + "PRECIO=?,AÑO=?, TANQUE=?, INVENTARION=? WHERE ID_VEHICULO=?";
        try {
            PreparedStatement stat = link.prepareStatement(Query);

            stat.setString(1, marca);
            stat.setString(2, modelo);
            stat.setString(3, color);
            stat.setString(4, transmision);
            stat.setDouble(5, precio);
            stat.setInt(6, año);
            stat.setFloat(7, tanque);
            stat.setInt(8, inventario);
            stat.setInt(8, codVehiculo);
            stat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Vehiculos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    /**
     * Metodo para borrar un vehiculo de la base de datos mediante su id.
     * @param idVehiculo
     * @return 
     */
    public static boolean borrarVehiculo(int idVehiculo){
        sql.Conexion mysql = new sql.Conexion();
        Connection link = mysql.Conectar();
        String Query;

        Query = "DELETE FROM VEHICULOS WHERE ID_VEHICULO= ?";
        try {
            PreparedStatement stat = link.prepareStatement(Query);

            stat.setInt(1, idVehiculo);

            stat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
