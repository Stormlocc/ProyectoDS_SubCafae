/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package subcafae;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author antho
 */
public class FXMLDocumentAmortizarController implements Initializable {

    @FXML
    private TextField inputImporte;
    @FXML
    private Text inputMeses;
    @FXML
    private ComboBox<?> bcbxSucursal;
    @FXML
    private ComboBox<?> bcbxPrestamo;
    @FXML
    private Label labelConfirmar;
    @FXML
    private Button bPagar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ebPagar(MouseEvent event) {
    }
    
}
