/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package subcafae;

import java.net.URL;
import java.sql.Connection;
import java.util.Date;
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
import subcafae.entidad.*;

import static javafx.collections.FXCollections.reverse;
import static subcafae.FXMLLoginController.prestatario;

/**
 * FXML Controller class
 *
 * @author antho
 */
public class FXMLDocumentAmortizarController implements Initializable {

    @FXML
    private TextField inputImporte;
    @FXML
    private ComboBox<Sucursal> bcbxSucursal;
    @FXML
    private ComboBox<Prestamo> bcbxPrestamo;
    @FXML
    private Button bPagar;
    // Instanciar la conexion
    private Conexion conexion;
    //Coleccion para el combo box
    private ObservableList<Sucursal> listaSucursal;
    private ObservableList<Prestamo> listaPrestamo;
    @FXML
    private Label banderaPago;
    @FXML
    private Label mostrarFecha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Iniciar la conexion
        conexion = new Conexion();
        conexion.EstablecerConexion();
        //Llenar el arreglo
        listaSucursal = FXCollections.observableArrayList();
        listaPrestamo = FXCollections.observableArrayList();
        // Defrente la clase xq ya tiene static
        Sucursal.LlenarInformacion(conexion.getConnection(), listaSucursal);
        Prestamo.ObtenerPrestamos( conexion.getConnection(), listaPrestamo, prestatario.getIdPrestatario());
        //Asignar la lista
        bcbxSucursal.setItems(listaSucursal);
        bcbxPrestamo.setItems(listaPrestamo);
        //Bloquear letras en input
        inputImporte.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("\\d*")) return;
            inputImporte.setText(newValue.replaceAll("\\D", ""));
        });
        //Mostrar fecha del sistema
        Date date = new Date();
        long timeInMilliSeconds = date.getTime();
        java.sql.Date fechaHoy = new java.sql.Date(timeInMilliSeconds);
        mostrarFecha.setText(fechaHoy.toString());
        //Cerrar la conexion
        //conexion.CerrarConexion();
    }

    @FXML
    private void ebPagar(MouseEvent event) {
        // CORREGIR (Si ya se pago por completo o si el pago exede el monto)

        //Verificar campos llenados correctamente
        if(inputImporte.getText().isEmpty() ||  bcbxPrestamo.getValue().getIdPrestamo().isEmpty() || bcbxSucursal.getValue().getIdSucursal().isEmpty()) {
            System.out.println("Datos incompletos");
        }
        else{
            Amortizacion.Pagar(conexion.getConnection(),
                                mostrarFecha.getText(),
                                inputImporte.getText(),
                                bcbxSucursal.getValue().getIdSucursal(),
                                bcbxPrestamo.getValue().getIdPrestamo());
            banderaPago.setText("! PAGO EXITOSO !");
        }
        //Borrar banderas
        inputImporte.setText("");
        bcbxSucursal.setValue(null);
        bcbxPrestamo.setValue(null);
    }
    
}
