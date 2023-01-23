package subcafae.entidad;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Prestamista {
    private Integer IdPrestamista;
    private String Nombres;
    private String Email;


    public Prestamista(Integer idPrestamista, String nombres, String email) {
        IdPrestamista = idPrestamista;
        Nombres = nombres;
        Email = email;
    }

    public Integer getIdPrestamista() {
        return IdPrestamista;
    }

    public String getNombres() {
        return Nombres;
    }


    public String toString(){
        return IdPrestamista + " " +Nombres + " " +Email;
    }

    //Obtener prestamista
    public static Prestamista ObtenerPrestamista(Connection conexion ){
        try{
            ObservableList<Prestamista> listaPrestamista = FXCollections.observableArrayList();
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM prestamista");
            //Conseguir todos los prestamistas

            while (resultado.next()) {
                listaPrestamista.add(new Prestamista(resultado.getInt("IdPrestamista"),
                                                    resultado.getString("Nombres"),
                                                    resultado.getString("Email"))
                );
            }
            /**/
            //Prestamista aleatorio
            int numero = (int) (Math.random() * listaPrestamista.size());
            return listaPrestamista.get(numero);
        }
        catch (Exception e){
            System.out.println("No se genero un prestamista");
            System.out.println(e);
        }    //    //                      23567522
        return  null;
    }
}
