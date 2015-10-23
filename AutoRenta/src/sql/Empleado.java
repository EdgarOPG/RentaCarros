
package sql;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Empleado {

    Conexion cn;
    public Empleado() {
    cn = new Conexion();    
    }
    
        //Variables Query
    /*
    String Nombre;
    Date FechaNacimieto;
    String Direccion;
    String Email;
    String Telefono;
    String TelefonoCasa;
    */

    public Conexion getCn() {
        return cn;
    }

    public void setCn(Conexion cn) {
        this.cn = cn;
    }
    
    public void altaEmpleados(String usuario, String contra ,
                              String nombre, String fechaNacimiento,
                              String direccion, String email, 
                              String telefono, String telefonoCasa)
    {        
        /*
        Nombre = nombre;
        FechaNacimieto = fechaNacimiento;
        Direccion = direccion;
        Email = email;
        Telefono = telefono;
        TelefonoCasa = telefonoCasa;
        */
        
        String Query = "insert into EMPLEADOS(USUARIO, CONTRASENIA, NOMBRE, "
                     + "FECHA_NACIMIENTO, DIRECCION, EMAIL, TELEFONO, TELEFONO_CASA) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
            rs = ps.executeQuery();
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null, "Datos correctamente guardados");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el registro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
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