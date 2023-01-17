
package subcafae.entidad;

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

}
