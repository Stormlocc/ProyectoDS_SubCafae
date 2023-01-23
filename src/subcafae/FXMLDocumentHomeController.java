/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package subcafae;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


import static subcafae.FXMLLoginController.prestatario;

/**
 * FXML Controller class
 *
 * @author mlocc
 */
public class FXMLDocumentHomeController implements Initializable {

    @FXML
    private Label mostrarNombre;
    @FXML
    private Label mostrarApellido;
    @FXML
    private Label mostrarDNI;
    @FXML
    private Label mostrarSexo;
    @FXML
    private Label mostrarEstadoCivil;

    /**
     * Initializes the controller class.
     */
    //    //                      23567522
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Estas en Home");
        // TODO
        // Cargar datos necesario en modo public
        String[] nombres = prestatario.getNombres().split(" ");
        if(nombres.length == 4)
            mostrarNombre.setText(nombres[2]+" "+nombres[3]);
        else
            mostrarNombre.setText(nombres[2]);
        mostrarApellido.setText(nombres[0]+" "+nombres[1]);
        mostrarDNI.setText(prestatario.getDNI());
        mostrarSexo.setText(prestatario.getSexo());
        mostrarEstadoCivil.setText(prestatario.getEstadoCivil());
    }
}
