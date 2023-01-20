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
import javafx.scene.control.ChoiceBox;
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
public class FXMLDocumentLayoutController implements Initializable {

    @FXML
    private BorderPane borderPanel;
    @FXML
    private Pane headerHome;
    @FXML
    private ImageView bConfiguracion;
    @FXML
    private ImageView bOpciones;
    @FXML
    private VBox leftHome;
    @FXML
    private ImageView bHome;
    @FXML
    private ImageView bHistorial;
    @FXML
    private ImageView bReporte;
    @FXML
    private Pane mainHome;
    @FXML
    private ChoiceBox<String> chbOpciones;

    private String[] opciones = {"Obtener prestamo","Agregar pago","Cambiar contraseña","Salir"};
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Estas en Layout");
        // TODO
        CargarPagina("vista/FXMLDocumentHome");
        // Cargar el boton de opciones
        chbOpciones.getItems().addAll(opciones);
        chbOpciones.setOnAction(this::echbOpciones);
    }

    private void echbOpciones(ActionEvent actionEvent) {
        //Choise box para mostrar opciones como: salir, agregar pago, prestamo,
        String inputOpcion = chbOpciones.getValue();
        System.out.println(inputOpcion);
        if (inputOpcion=="Obtener prestamo" ){
            System.out.println("Ingreso a obtener prestamo");
            CargarPagina("vista/FXMLDocumentAgregar");
            System.out.println("Ingreso a obtener prestamo");
        }
        if(inputOpcion.equals(opciones[1]) ){
            System.out.println("Ingreso a Agregar pagoo");
            CargarPagina("vista/FXMLDocumentAmortizar");

        }
        if(inputOpcion.equals(opciones[2])){
            System.out.println("Cambiar contraseña");
            CargarPagina("vista/FXMLDocumentCambiarPassword");
        }
        if(inputOpcion.equals(opciones[3])){
            System.out.println("salio del programa");
        }
    }

    @FXML
    private void ebHome(MouseEvent event) {
        CargarPagina("vista/FXMLDocumentHome");
    }

    @FXML
    private void ebHistorial(MouseEvent event) {
        CargarPagina("vista/FXMLDocumentHistorial");
    }

    @FXML
    private void ebReporte(MouseEvent event) {
        CargarPagina("vista/FXMLDocumentReporte");
    }

    
    /*Modulo para cargar paginas*/
    private void CargarPagina(String p){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(p+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        borderPanel.setCenter(root);
    }
    
}
