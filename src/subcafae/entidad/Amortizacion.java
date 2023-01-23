
package subcafae.entidad;

import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author antho
 */
public class Amortizacion {
    //Atributos
    private Integer id;
    private String fecha;
    private Float importe;
    private Integer idSucursal;
    private Integer idPrestamo;
    //Constructor


    public Amortizacion(Integer id, String fecha, Float importe, Integer idSucursal, Integer idPrestamo) {
        this.id = id;
        this.fecha = fecha;
        this.importe = importe;
        this.idSucursal = idSucursal;
        this.idPrestamo = idPrestamo;
    }
    //Seter and Geters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Integer getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }
    //Metodos
    public static void Pagar(Connection conexion, String FechaPrestamo, String Importe, String IdSucursal, String IdPrestamo){
        //System.out.println(Fecha + Importe + IdSucursal + IdPrestamo+ "<-");
        try{
            //Permite agregar codigo sql, (inyectar codigo)
            PreparedStatement pst = conexion.prepareStatement("INSERT INTO amortizacion VALUES (?,?,?,?,?)");
            //Autoincremente
            pst.setString(1, null);
            //Detectar que prestamo pagara, (dar aviso si el prestamo ya esta pagado
            pst.setString(2, FechaPrestamo.trim());
            pst.setString(3, Importe.trim());
            pst.setString(4, IdSucursal.trim());
            pst.setString(5, IdPrestamo.trim());
            //Ejecutar codigo
            pst.executeUpdate();
            System.out.println("Pago de amortizacion exitoso");
            //Cerrar estamento
            pst.close();
        }
        catch (Exception e){
            System.out.println("No se pudo pagar");
            System.out.println(e);
        }
    }

}
