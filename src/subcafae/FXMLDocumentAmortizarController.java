/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package subcafae;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ComboBox<String> bcbxSucursal;
    @FXML
    private ComboBox<?> bcbxPrestamo;
    @FXML
    private Label labelConfirmar;
    @FXML
    private Button bPagar;
    //Coleccion para el combo box
    private ObservableList<String> listaSucursal;
    private ObservableList<String> listaPrestamo;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listaSucursal = FXCollections.observableArrayList("üno","caramelo", "hermano?","caramelo", "hermano?","caramelo", "hermano?");
        bcbxSucursal.setItems(listaSucursal);
    }    

    @FXML
    private void ebPagar(MouseEvent event) {
    }
    
}
