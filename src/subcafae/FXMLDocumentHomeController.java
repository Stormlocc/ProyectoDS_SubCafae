/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import javafx.scene.control.Label;
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
public class FXMLDocumentHomeController implements Initializable {

    @FXML
    private BorderPane borderPanel;
    @FXML
    private Pane headerHome;
    @FXML
    private VBox leftHome;
    @FXML
    private Pane mainHome;
    @FXML
    private ImageView bConfiguracion;
    @FXML
    private ImageView bOpciones;
    @FXML
    private ImageView bHome;
    @FXML
    private ImageView bHistorial;
    @FXML
    private ImageView bReporte;
    @FXML
    private Label tituloHome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   


    @FXML
    private void ebHistorial(MouseEvent event) {
    }
    

    @FXML
    private void ebReporte(MouseEvent event) {

    }

    @FXML
    private void ebHome(MouseEvent event) {

    }
    
}
