package subcafae;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import subcafae.entidad.Conexion;
import subcafae.entidad.Prestamo;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Esta en Agregar = Obtener prestamo");
        //Bloquear edicion de usuario y prestatario
        // TODO
    }

    @FXML
    private void ebObtenerPrestamo(MouseEvent event) {
        System.out.println("Click en boton obtener prestamo");
        Prestamo.GenerarPrestamo(conexion.getConexion());
    }

}
