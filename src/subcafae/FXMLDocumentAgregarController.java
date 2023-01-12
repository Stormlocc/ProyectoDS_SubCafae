/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package subcafae;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author mlocc
 */
public class FXMLDocumentAgregarController implements Initializable {

    @FXML
    private ComboBox<?> inputDocPrestamo;
    @FXML
    private TextField inputImporte;
    @FXML
    private Button bPagar;
    @FXML
    private Label labelConfirmar;
    @FXML
    private ComboBox<?> inputSucursal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ebPagar(MouseEvent event) {
        System.out.println("Click en boton pagar");
        /*
        try{
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SubCafae","root","");
            //Agregar consulta de pagos, para generar nueva llave primaria
            //String pk = ;
            //Permite agregar codigo sql, (inyectar codigo)
            PreparedStatement pst = conexion.prepareStatement("INSERT INTO AMORTIZACION VALUES (?,?,?,?)");
            //Autoincremente
            pst.setString(1, inputDocCancelacion.getText().trim());
            //Detectar que prestamo pagara, (dar aviso si el prestamo ya esta pagado
            pst.setString(2, inputDocPrestamo.getText().trim());
            //
            pst.setString(3, inputImporte.getText().trim());
            //Conseguir fecha del sitema
            pst.setString(4, inputFecha.getText().trim());
            //Ejecutar codigo
            pst.executeUpdate();
            System.out.println("Pago realizado");
            //Limpiar field
            //inputDocCancelacion.setText("");
            //inputDocPrestamo.setText("");
            inputImporte.setText("");
            //Mostrar confirmacion
            labelConfirmar.setText("Pago Exitoso");
            pst.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        */
    }
    
}
