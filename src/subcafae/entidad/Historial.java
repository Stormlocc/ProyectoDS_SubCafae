package subcafae.entidad;

import javafx.collections.ObservableList;
import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Historial {
    private String idPrestamo;
    private String fecha;
    private String sucural;
    private Float monto;
    private Float saldo;

    public Historial( String fecha, String sucural, Float monto, Float saldo) {
        this.fecha = fecha;
        this.sucural = sucural;
        this.monto = monto;
        this.saldo = saldo;
    }

    public String getFecha() {
        return fecha;
    }



    public String getSucural() {
        return sucural;
    }



    public Float getMonto() {
        return monto;
    }



    public Float getSaldo() {
        return saldo;
    }


    
   
    public static void GenerarHistorial(Connection conexion, ObservableList<Historial> listaHistorial, Prestatario usuario){
        System.out.println("Generando historial");
        try{
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT a.IdPrestamo,a.FechaAmortizacion,s.Nombre,a.Importe,b.Importe \"Total\"" +
                    "FROM (amortizacion a INNER JOIN prestamo  b ON a.IdPrestamo = b.IdPrestamo) INNER JOIN sucursal s on a.IdSucursal = s.IdSucursal\n" +
                    "WHERE b.IdPrestatario =" + usuario.getIdPrestatario());
            while (resultado.next()){
                listaHistorial.add(new Historial(
                                resultado.getString("IdPrestamo") + " " + resultado.getString("FechaAmortizacion"),
                                                resultado.getString("Nombre"),
                                                resultado.getFloat("Importe"),
                                                resultado.getFloat("Total"))
                                    );
            }
        }
        catch (Exception e){
            System.out.println("No se genero el historial");
            System.out.println(e);
        }
    }



}
