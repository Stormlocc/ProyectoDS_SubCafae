/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package subcafae;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author mlocc
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private Pane IniciarSesion;
    @FXML
    private TextField inputDNI;
    @FXML
    private PasswordField inputPassword;
    @FXML
    private Button bIniciarSesion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ebIniciarSesion(ActionEvent event) throws IOException {
        System.out.println("Ingreso a Home");
        //Funcion para cargar el FXMLLayout.fxml
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("FXMLLayout.fxml"));
        
        
        //Una solucion podria ser cerrar la pestaña e iniciar el FXMLLayout.fxml
        
        
    }
    
}
