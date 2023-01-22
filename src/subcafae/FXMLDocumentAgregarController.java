package subcafae;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import subcafae.entidad.Conexion;
import subcafae.entidad.Prestamista;
import subcafae.entidad.Prestamo;

import static subcafae.FXMLLoginController.prestatario;
import static subcafae.entidad.Prestamista.ObtenerPrestamista;

/**
 * FXML Controller class
 *
 * @author mlocc
 */
public class FXMLDocumentAgregarController implements Initializable {

    @FXML
    private TextField inputImporte;
    @FXML
    private Label labelConfirmar;
    @FXML
    private TextField inputMeses;
    @FXML
    private TextField mostrarUsuario;
    @FXML
    private TextField mostrarPrestatario;
    @FXML
    private Button bPrestamo;
    // Instanciar la conexion
    private Conexion conexion;

    Prestamista prestamista;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Esta en Agregar = Obtener prestamo");
        //Mostrar datos de usuario
        mostrarUsuario.setText(prestatario.getNombres());
        //Generar un prestamista aleatorio
        conexion = new Conexion();
        conexion.EstablecerConexion();
        prestamista = Prestamista.ObtenerPrestamista(conexion.getConnection());
        mostrarPrestatario.setText(prestamista.getNombres());
        System.out.println(prestamista);
        System.out.println("Agregar termino de cargar");

    }
    //    //                      23567522
    @FXML
    private void ebObtenerPrestamo(MouseEvent event) {
        //Obtener prestamo
        System.out.println("Click en boton obtener prestamo");
        //Prestamo.GenerarPrestamo(conexion.getConexion());



    }

}
