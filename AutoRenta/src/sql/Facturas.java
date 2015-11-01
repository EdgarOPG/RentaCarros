
package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Facturas {
    
    /**
     * Metodo para agregar Rentas a la base de datos.
     * @param usuario
     * @param contra
     * @param nombre
     * @param rol
     * @param fechaNacimiento
     * @param direccion
     * @param email
     * @param telefono
     * @param telefonoCasa
     * @return 
     */
    
    public static void RegistrarRenta(int idEmpleado, int idCliente, int idVehiculo,
                                      String fechaRenta, String fechaEntrega){
        sql.Conexion mysql = new sql.Conexion();
        Connection link = mysql.Conectar();
        String Query = "insert into FACTURAS(ID_EMPLEADO, ID_CLIENTE, ID_VEHICULO,"
                        + " FECHA, FECHA_ENTREGA) "
                        + " VALUES(?, 1, 1, ?, ?)";
        try {

            PreparedStatement stat = link.prepareStatement(Query);

            stat.setInt(1, idEmpleado);
//            stat.setInt(2, idCliente);
//            stat.setInt(3, idVehiculo);
            stat.setString(2, fechaRenta);
            stat.setString(3, fechaEntrega);
            stat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
