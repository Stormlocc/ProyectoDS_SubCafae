/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package subcafae;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class FXMLDocumentHistorialController implements Initializable {

    @FXML
    private ImageView ebHome;
    @FXML
    private ImageView ebHome1;
    @FXML
    private BorderPane borderPanel;
    @FXML
    private Pane headerHome;
    @FXML
    private VBox leftHome;
    @FXML
    private Pane mainHome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void initialize(MouseEvent event) {
    }

    @FXML
    private void ebHistorial(MouseEvent event) {
        System.out.println("Moviendo a pestaña historial");
    }

    @FXML
    private void ebReporte(MouseEvent event) {
        System.out.println("Moviendo a pestaña reporte");
    }
    
    
}
