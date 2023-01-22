package subcafae.entidad;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Prestamista {
    private Integer IdPrestamista;
    private String Nombres;
    private String Email;


    //static List<Prestamista> listaPrestamista = new ArrayList<>();

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

    public String getEmail() {
        return Email;
    }


    public String toString(){
        return IdPrestamista + " " +Nombres + " " +Email;
    }

    //Obtener prestamista
    public static Prestamista ObtenerPrestamista(Connection conexion ){
        try{
            ObservableList<Prestamista> listaPrestamista = FXCollections.observableArrayList();;
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
            System.out.println("Aleatorio " +  numero);
            System.out.println(listaPrestamista.get(numero));
            return listaPrestamista.get(numero);
        }
        catch (Exception e){
            System.out.println("No se genero un prestamista");
            System.out.println(e);
        }    //    //                      23567522
        return  null;
    }
}
