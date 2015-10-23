
package sql;

import java.sql.Date;


public class Empleado {

    Conexion cn;
    public Empleado() {
    cn = new Conexion();    
    }
    
        //Variables Query
    String Nombre;
    Date FechaNacimieto;
    String Direccion;
    String Email;
    String Telefono;
    String TelefonoCasa;

    public Conexion getCn() {
        return cn;
    }

    public void setCn(Conexion cn) {
        this.cn = cn;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Date getFechaNacimieto() {
        return FechaNacimieto;
    }

    public void setFechaNacimieto(Date FechaNacimieto) {
        this.FechaNacimieto = FechaNacimieto;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getTelefonoCasa() {
        return TelefonoCasa;
    }

    public void setTelefonoCasa(String TelefonoCasa) {
        this.TelefonoCasa = TelefonoCasa;
    }
    
    
    public void altaEmpleados(String nombre, Date fechaNacimiento,
                              String direccion, String email, 
                              String telefono, String telefonoCasa)
    {
        cn.Conectar();
        
        Nombre = nombre;
        FechaNacimieto = fechaNacimiento;
        Direccion = direccion;
        Email = email;
        Telefono = telefono;
        TelefonoCasa = telefonoCasa;
        
        
    };
    
}
