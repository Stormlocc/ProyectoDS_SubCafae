package subcafae.entidad;

import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author antho
 */
public class Prestamo {

    private String IdPrestamo;
    private String FechaPrestamo;
    private Integer Importe;
    private Integer Meses;
    private String IdPrestatario;
    private String IdPrestamista;


    public Prestamo(String idPrestamo, String fechaPrestamo, Integer importe, Integer meses, String idPrestatario, String idPrestamista) {
        IdPrestamo = idPrestamo;
        FechaPrestamo = fechaPrestamo;
        Importe = importe;
        Meses = meses;
        IdPrestatario = idPrestatario;
        IdPrestamista = idPrestamista;
    }

    public String getIdPrestamo() {
        return IdPrestamo;
    }

    public Integer getImporte() {
        return Importe;
    }

    public Integer getMeses() {
        return Meses;
    }

    @Override
    public String toString(){

        return  "Codigo: " + IdPrestamo + " \t    Fecha: "+ FechaPrestamo;
    }

    // Metodos
    public static void GenerarPrestamo(Connection conexion, String FechaPrestamo,String Importe,String Meses,String IdPrestatario,String IdPrestamista) {
        try{
            //Permite agregar codigo sql, (inyectar codigo)
            PreparedStatement pst = conexion.prepareStatement("INSERT INTO prestamo VALUES (?,?,?,?,?,?)");
            //Autoincremente
            pst.setString(1, null);
            //Detectar que prestamo pagara, (dar aviso si el prestamo ya esta pagado
            pst.setString(2, FechaPrestamo.trim());
            pst.setString(3, Importe.trim());
            pst.setString(4, Meses.trim());
            pst.setString(5, IdPrestatario.trim());
            pst.setString(6, IdPrestamista.trim());
            //Ejecutar codigo
            pst.executeUpdate();
            System.out.println("Prestamo exitoso");
            //Cerrar estamento
            pst.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void ObtenerPrestamos(Connection conexion, ObservableList<Prestamo> listaPrestamo, String IdPrestatario){
        //Recolectar los prestamos
        try{
            //Consultar a la BD
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM prestamo WHERE IdPrestatario = " + IdPrestatario);
            while (resultado.next()){
                listaPrestamo.add(new Prestamo(resultado.getString("IdPrestamo"),
                                                resultado.getString("FechaPrestamo"),
                                                resultado.getInt("Importe"),
                                                resultado.getInt("Meses"),
                                                resultado.getString("IdPrestatario"),
                                                resultado.getString("IdPrestamista")
                                                )
                );
            }
        }
        catch (Exception e){
            System.out.println("No se encontro prestamos");
            System.out.println(e);
        }

    }

}
