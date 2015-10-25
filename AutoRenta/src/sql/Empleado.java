package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Empleado {

    /**
     * Metodo para agregar empleados a la base de datos.
     * @param usuario
     * @param contra
     * @param nombre
     * @param fechaNacimiento
     * @param direccion
     * @param email
     * @param telefono
     * @param telefonoCasa
     * @return 
     */
    public static boolean addEmpleados(String usuario, String contra, String nombre,
            String fechaNacimiento, String direccion, String email, String telefono, String telefonoCasa) {

        sql.Conexion mysql = new sql.Conexion();
        Connection link = mysql.Conectar();
        String Query = "insert into EMPLEADOS(USUARIO, CONTRASENIA,"
                        + " NOMBRE, FECHA_NACIMIENTO,"
                        + " DIRECCION, EMAIL,"
                        + " TELEFONO, TELEFONO_CASA)"
                        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            PreparedStatement stat = link.prepareStatement(Query);

            stat.setString(1, usuario);
            stat.setString(2, contra);
            stat.setString(3, nombre);
            stat.setString(4, fechaNacimiento);
            stat.setString(5, direccion);
            stat.setString(6, email);
            stat.setString(7, telefono);
            stat.setString(8, telefonoCasa);
            stat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    /**
     * Metodo para obtener usuario y contraseña del empleado para inicio de sesion
     * @param usuario
     * @param contra
     * @return 
     */
    public static boolean ingresarUsuario(String usuario,String contra){
        sql.Conexion mysql = new sql.Conexion();
        Connection link = mysql.Conectar();
        String Query = "select * from EMPLEADOS where USUARIO like ? and CONTRASENIA = ?";
        ResultSet rs = null;

        try {
             PreparedStatement stat = link.prepareStatement(Query);

            stat.setString(1, usuario);
            stat.setString(2, contra);
            
            stat.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    /**
     * Metodo para obtener el nombre de los empleados de la base de datos
     * @return true si el query se ejecuto correctamente
     */
    public static ResultSet getEmpleados(){
        sql.Conexion mysql = new sql.Conexion();
        Connection link = mysql.Conectar();
        ResultSet val = null;
        String Query = "SELECT NOMBRE FROM EMPLEADOS";

        try {
            PreparedStatement stat = link.prepareStatement(Query);
            val = stat.executeQuery();

            return val;

        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            return val;
        }
    }
    
    /**
     * Metodo para borrar empleados de la base de datos mediante su nombre
     * @param nombre que es el nombre del empleados
     * @return true si el query se ejecuto correctamente
     */
    public static boolean borrarEmpleado(String nombre){
        sql.Conexion mysql = new sql.Conexion();
        Connection link = mysql.Conectar();
        String Query;

        Query = "DELETE FROM EMPLEADOS WHERE NOMBRE = ?";
        try {
            PreparedStatement stat = link.prepareStatement(Query);

            stat.setString(1, nombre);

            stat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean validarContrasenia(String contra1, String contra2) {
        if (contra2.equals(contra1)) {
            if (contra1.length() <= 15 && contra1.length() >= 5) {
                System.out.println("Contraseña de longitud correcta");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "La contraseña debe tener una longitud de entre 5 y 15 caracteres.");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            return false;
        }
    }
}
