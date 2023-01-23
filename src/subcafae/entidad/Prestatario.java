package subcafae.entidad;

import javafx.collections.ObservableList;

import java.sql.*;


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
            ResultSet resultado = sentencia.executeQuery("SELECT* FROM prestatario WHERE DNI='"+dni+"' AND PASSWORD = '"+pass+"';");
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
    public static void CambiarPassword(Connection conexion, Prestatario user, String inputPassword, String newPassword){
        System.out.println(user);   //  45731551
        try{
            if(user.getPassword().equals(inputPassword)){
                System.out.println("Contrase;as coinciden");
                //Inyectar codigo
                PreparedStatement pst = conexion.prepareStatement("UPDATE prestatario SET prestatario.password = ? WHERE DNI = ? AND IdPrestatario = ?");
                pst.setString(1, newPassword);
                pst.setString(2, user.getDNI());
                pst.setString(3, user.getIdPrestatario());
                pst.executeUpdate();
                pst.close();
                System.out.println("Cambio de contraseña exitoso");
            }
            else{
                System.out.println("Contrasenas NO NO coinciden");
            }
        }
        catch (Exception e){
            System.out.println("Datos incorrectos para cambiar contraseña");
            System.out.println(e);
            System.out.println();
        }

    }
}
