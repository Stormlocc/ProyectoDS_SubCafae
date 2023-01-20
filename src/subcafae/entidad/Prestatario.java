package subcafae.entidad;

import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prestatario {
    private String IdPrestatario;
    private String Nombres;
    private String Sexo;
    private String EstadoCivil;
    private String DNI;
    private String Password;

    public Prestatario(String idPrestatario, String nombres, String sexo, String estadoCivil, String dni, String password) {
        this.IdPrestatario = idPrestatario;
        this.Nombres = nombres;
        this.Sexo = sexo;
        this.EstadoCivil = estadoCivil;
        this.DNI = dni;
        this.Password = password;
    }

    //


    public String getIdPrestatario() {
        return this.IdPrestatario;
    }

    public String getNombres() {
        return this.Nombres;
    }

    public String getSexo() {
        return this.Sexo;
    }

    public String getEstadoCivil() {
        return this.EstadoCivil;
    }

    public String getDNI() {
        return this.DNI;
    }

    public String getPassword() {
        return Password;
    }

    @Override
    public String toString(){
        return this.IdPrestatario + " - " + this.Nombres + " - " + this.Sexo +" - " + this.EstadoCivil + " - " + this.DNI ;
    }

    // -- Metodos
    //                      23567522
    public static void IniciarSesion(Connection conexion, ObservableList<Prestatario> prestatario, String dni, String pass){
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT* FROM prestatario WHERE DNI="+dni+" AND PASSWORD ="+pass);
            while (resultado.next()){

                prestatario.add(new Prestatario(resultado.getString("IdPrestatario"),
                        resultado.getString("Nombres"),
                        resultado.getString("Sexo"),
                        resultado.getString("EstadoCivil"),
                        resultado.getString("DNI"),
                        resultado.getString("Password")));
            }
        }
        catch (SQLException e) {
            System.out.println("Datos incorrectos de usuario al iniciar sesion");
            System.out.println(e);
            System.out.println();
        }
        //

    }
}
