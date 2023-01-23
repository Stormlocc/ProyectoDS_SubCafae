package subcafae;

import java.net.URL;
import java.sql.Connection;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import subcafae.entidad.Conexion;
import subcafae.entidad.Prestamista;
import subcafae.entidad.Prestamo;

import static subcafae.FXMLLoginController.prestatario;
import static subcafae.entidad.Prestamista.ObtenerPrestamista;

/**
 * FXML Controller class
 *
 * @author mlocc
 */
public class FXMLDocumentAgregarController implements Initializable {

    @FXML
    private TextField inputImporte;
    @FXML
    private TextField inputMeses;
    @FXML
    private TextField mostrarUsuario;
    @FXML
    private TextField mostrarPrestatario;
    @FXML
    private Button bPrestamo;
    @FXML
    private Label banderaPrestamo;
    // Instanciar la conexion
    private Conexion conexion;


    Prestamista prestamista;
    @FXML
    private Label mostrarFecha;
    //java.sql.Date fechaHoy;        enviar direcmatenete en el foramto fecha
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Esta en Agregar = Obtener prestamo");
        //Ingresar solo numeros

        inputImporte.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("\\d*")) return;
            inputImporte.setText(newValue.replaceAll("\\D", ""));
        });

        inputMeses.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("\\d*")) return;
            inputMeses.setText(newValue.replaceAll("\\D", ""));
        });

        //
        //Mostrar datos de usuario
        mostrarUsuario.setText(prestatario.getNombres());
        //Generar un prestamista aleatorio
        conexion = new Conexion();
        conexion.EstablecerConexion();
        prestamista = Prestamista.ObtenerPrestamista(conexion.getConnection());
        mostrarPrestatario.setText(prestamista.getNombres());
        //Mostrar fecha del sistema
        Date date = new Date();
        long timeInMilliSeconds = date.getTime();
        java.sql.Date fechaHoy = new java.sql.Date(timeInMilliSeconds);
        mostrarFecha.setText(fechaHoy.toString());
    }
    //    //                      23567522
    @FXML
    private void ebObtenerPrestamo(MouseEvent event) {
        //Verificar campos llenados correctamente
        if(inputImporte.getText().isEmpty() && inputMeses.getText().isEmpty()){
            System.out.println("Datos incompletos");
        }
        else{
            //Obtener prestamo
            System.out.println("Click en boton obtener prestamo");
            Integer IdPrestamo = null;
            String FechaPrestamo = mostrarFecha.getText();
            String Importe = inputImporte.getText();
            String Meses = inputMeses.getText();
            String IdPrestatario = prestatario.getIdPrestatario();
            String IdPrestamista = String.valueOf(prestamista.getIdPrestamista());
            //System.out.println(IdPrestamo+FechaPrestamo+ Importe+ Meses+ IdPrestatario+""+IdPrestamista);
            Prestamo.GenerarPrestamo(conexion.getConnection(),FechaPrestamo,Importe,Meses,IdPrestatario,IdPrestamista);
            //Mostrar bandera de prestamos
            banderaPrestamo.setText("! Prestamo Exitoso !!");
        }
        //Limpiar pantalla
        inputImporte.setText("");
        inputMeses.setText("");
    }
}
