package gui;

/**
 * Clase principal, se utiliza como lanzador para el programa principal
 * incializar aqui los componentes del programa
 *
 * @author Adrian Flores Pizarro
 */
public class Launcher {

    public static void main(String[] args) {
        Login frmLogin = new Login();
        frmLogin.setLocationRelativeTo(frmLogin);
        frmLogin.setVisible(true);

    }

}
