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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import subcafae.entidad.Conexion;
import subcafae.entidad.Prestatario;

import static subcafae.FXMLLoginController.prestatario;
/**
 * FXML Controller class
 *
 * @author antho
 */
public class FXMLDocumentCambiarPasswordController implements Initializable {

    @FXML
    private TextField inputPassword;
    @FXML
    private TextField inputNewPassword;
    @FXML
    private Button bCambiarPassword;
    // Instanciar la conexion
    private Conexion conexion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ebCambiarPassword(MouseEvent event) {
        if(inputPassword.getText().isEmpty() || inputNewPassword.getText().isEmpty()){
            System.out.println("Datos incompletos para cambiar el password");
        }
        else{
            conexion = new Conexion();
            conexion.EstablecerConexion();
            Prestatario.CambiarPassword(conexion.getConnection(),prestatario ,inputPassword.getText(),inputNewPassword.getText());
        }
        //borrar los cambos
        inputPassword.setText("");
        inputNewPassword.setText("");
    }
    
}
