package subcafae.entidad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conexion {
    private Connection connection;
    private String url = "jdbc:mysql://localhost/ds_subcafae";
    private String user = "root";
    private String password = "";

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    //Conectarse a la vase de datos
    public void EstablecerConexion(){
        try{
            this.connection = DriverManager.getConnection(this.url,this.user,this.password);
            /*
            //Permite agregar codigo sql, (inyectar codigo)
            PreparedStatement pst = conexion.prepareStatement("INSERT INTO SUCURSAL VALUES (?,?)");
            //Autoincremente
            pst.setString(1, null);
            //Detectar que prestamo pagara, (dar aviso si el prestamo ya esta pagado
            pst.setString(2, inputImporte.getText().trim());
            //
            //pst.setString(3, inputImporte.getText().trim());
            //Conseguir fecha del sitema
            //pst.setString(4, inputFecha.getText().trim());
            //Ejecutar codigo
            pst.executeUpdate();
            System.out.println("Pago realizado");
            //Limpiar field
            //inputDocCancelacion.setText("");
            //inputDocPrestamo.setText("");
            inputImporte.setText("");
            //Mostrar confirmacion
            labelConfirmar.setText("Pago Exitoso");
            pst.close();

            */
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    //Cerar conexion
    public void CerrarConexion(){
        try{
            this.connection.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
