package subcafae;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author mlocc
 */
public class FXMLDocumentLayoutController implements Initializable {

    @FXML
    private BorderPane borderPanel;
    @FXML
    private Pane headerHome;
    @FXML
    private ImageView bConfiguracion;
    @FXML
    private ImageView bOpciones;
    @FXML
    private VBox leftHome;
    @FXML
    private ImageView bHome;
    @FXML
    private ImageView bHistorial;
    @FXML
    private ImageView bReporte;
    @FXML
    private Pane mainHome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CargarPagina("vista/FXMLDocumentHome");
        // Tambien cargar datos necesario en modo public
    }    
    
    @FXML
    private void ebHome(MouseEvent event) {
        CargarPagina("vista/FXMLDocumentHome");
    }

    @FXML
    private void ebHistorial(MouseEvent event) {
        CargarPagina("vista/FXMLDocumentHistorial");
    }

    @FXML
    private void ebReporte(MouseEvent event) {
        CargarPagina("vista/FXMLDocumentReporte");
    }
    
    @FXML
    private void ebOpciones(MouseEvent event) {
        CargarPagina("vista/FXMLDocumentAgregar");
    }
    
    /*Modulo para cargar paginas*/
    private void CargarPagina(String p){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(p+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        borderPanel.setCenter(root);
    }
    
}
