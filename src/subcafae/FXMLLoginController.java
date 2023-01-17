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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author mlocc
 */
public class FXMLLoginController implements Initializable {
    @FXML
    private BorderPane panelLogin;
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
        System.out.println("Login cargado");
    }

    @FXML
    private void ebIniciarSesion(ActionEvent event) throws IOException {
        System.out.println("Ingreso a Home");
        //Guardar todos los datos, y verificar si existe el usuario
        CargarPagina("vista/FXMLDocumentLayout");

    }

    private void CargarPagina(String p) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(p + ".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //panelLogin.getUserData();
        panelLogin.setLeft(null);
        panelLogin.setRight(null);
        panelLogin.setCenter(root);
    }
}