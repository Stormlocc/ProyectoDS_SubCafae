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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import subcafae.entidad.Conexion;
import subcafae.entidad.Prestatario;
import subcafae.entidad.Sucursal;

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
    private ObservableList<Prestatario> listaPrestatario;
    private Conexion conexion;

    static Prestatario prestatario;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("Estas en Login");
    }

    @FXML
    private void ebIniciarSesion(ActionEvent event) throws IOException {
        System.out.println("Click en boton iniciar sesion");
        //Generar conexion
        conexion = new Conexion();
        conexion.EstablecerConexion();
        // Instanciar lista
        listaPrestatario = FXCollections.observableArrayList();
        // Obtener usuario  //Verifica  que dni y pass existan sino en dicho modulo mostrara error
        Prestatario.IniciarSesion(conexion.getConnection(), listaPrestatario, inputDNI.getText(), inputPassword.getText());
        //                      23567522
        // Comprueba la exitencia de usuario
        if (!listaPrestatario.isEmpty()) {
            // Imprimir el usuario
            System.out.println(listaPrestatario.get(0));
            // Generar instancia public del usuario
            prestatario = listaPrestatario.get(0);
            // Cambiar de ventana
            CargarPagina("vista/FXMLDocumentLayout");
        } else {
            inputDNI.setText("");
            inputPassword.setText("");
        }
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