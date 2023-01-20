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
        this.DNI = DNI;
        this.Password = password;
    }

    //
    public void setIdPrestatario(String idPrestatario) {
        this.IdPrestatario = idPrestatario;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public void setEstadoCivil(String estadoCivil) {
        EstadoCivil = estadoCivil;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString(){
        return IdPrestatario + " - " + Nombres + " - " + Sexo +" - " + EstadoCivil + " - " + DNI ;
    }

    // -- Metodos

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
                        resultado.getString("DNI")));
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
