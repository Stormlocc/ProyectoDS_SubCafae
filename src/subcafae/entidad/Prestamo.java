package subcafae.entidad;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
    

    // Metodos
    public static void GenerarPrestamo(Connection conexion, String FechaPrestamo,String Importe,String Meses,String IdPrestatario,String IdPrestamista) {
        try{
            //Permite agregar codigo sql, (inyectar codigo)
            PreparedStatement pst = conexion.prepareStatement("INSERT INTO prestamo VALUES (?,?,?,?,?,?)");
            //Autoincremente
            pst.setString(1, null);
            //Detectar que prestamo pagara, (dar aviso si el prestamo ya esta pagado
            pst.setString(2, FechaPrestamo.trim());
            //
            pst.setString(3, Importe.trim());
            //Conseguir fecha del sitema
            pst.setString(4, Meses.trim());
            pst.setString(5, IdPrestatario.trim());
            pst.setString(6, IdPrestamista.trim());
            //Ejecutar codigo
            pst.executeUpdate();
            System.out.println("Pago realizado");
            //Limpiar field
            //inputDocCancelacion.setText("");
            //inputDocPrestamo.setText("");
            //inputImporte.setText("");
            //Mostrar confirmacion
            //labelConfirmar.setText("Pago Exitoso");
            pst.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
