package sql;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Clase que crea las conexiones a utilizar en la base de datos y los demas
 * metodos del sistema.
 *
 * @author Daniela Santillanes Castro
 * @since 06/05/2015
 * @version 1.0
 */
public class Conexion {

    public String db = ""; //Nombre base de datos a usar
    public String url = "jdbc:mysql://localhost/" + db;
    public String user = "root";
    public String pass = ""; //Contraseña para conexion

    /**
     * Método para realizar la conexión a la base de datos.
     * @return link.
     */
    public Connection Conectar() {

        Connection link = null;

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return link;
    }

}
