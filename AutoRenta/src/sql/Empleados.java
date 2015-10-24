
package sql;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Empleados {

    Conexion cn;
    public Empleados() {
    cn = new Conexion();    
    }
    
    public boolean Ingresar(String usuario,String contra){
        
        String Query = "select * from EMPLEADOS where USUARIO like ? and CONTRASENIA = ?";
        ResultSet rs = null;

        try {
            PreparedStatement ps = cn.Conectar().prepareStatement(Query);
            ps.setString(1, usuario);
            ps.setString(2, contra);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
            else
            {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }


    public void altaEmpleados(String usuario, String contra ,
                              String nombre, String fechaNacimiento,
                              String direccion, String email, 
                              String telefono, String telefonoCasa)
    {
        String Query = "insert into EMPLEADOS(USUARIO, CONTRASENIA,"
                                            + " NOMBRE, FECHA_NACIMIENTO,"
                                            + " DIRECCION, EMAIL,"
                                            + " TELEFONO, TELEFONO_CASA)"
                                            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        ResultSet rs = null;
        try {
            PreparedStatement ps = cn.Conectar().prepareStatement(Query);
            ps.setString(1, usuario);
            ps.setString(2, contra);
            ps.setString(3, nombre);
            ps.setString(4, fechaNacimiento);
            ps.setString(5, direccion);
            ps.setString(6, email);
            ps.setString(7, telefono);
            ps.setString(8, telefonoCasa);
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

    public boolean validarContrasenia(String contra1,String contra2){
        if(contra2.equals(contra1))
        {
            if(contra1.length() <= 15 && contra1.length() >= 5)
            {
                System.out.println("Contraseña de longitud correcta");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null,"La contraseña debe tener una longitud de entre 5 y 15 caracteres.");
                return false;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden");
            return false;
        }
    }
}
