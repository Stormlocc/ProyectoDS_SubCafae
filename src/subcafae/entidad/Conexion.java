package subcafae.entidad;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/ds_subcafae";
    private String user = "root";
    private String password = "";

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        System.out.println("Si no conecta es xq la clase tiene final en las variables, osea ya no sepued instanciar");
        this.connection = connection;
    }

    //Conectarse a la vase de datos
    public void EstablecerConexion(){
        try{
            // Load the Connector/J driver
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Establish connection to MySQL
            this.connection = DriverManager.getConnection(this.url,this.user,this.password);
            System.out.println("Conectado exitosamente");
        }
        catch(Exception e){
            System.out.println("Error de conexion");
            System.out.println(e);
        }
    }
    //Cerar conexion
    public void CerrarConexion(){
        try{
            this.connection.close();
            System.out.println("Desconectado");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
