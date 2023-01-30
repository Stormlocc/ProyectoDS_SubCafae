package subcafae;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import subcafae.entidad.*;

import static subcafae.FXMLLoginController.prestatario;


/**
 * FXML Controller class
 *
 * @author mlocc
 */
public class FXMLDocumentHistorialController implements Initializable {

    @FXML
    private TableView<Historial> tbvHistorial;
    @FXML
    private TableColumn<Historial, String> columSucursal;
    @FXML
    private TableColumn<Historial, Float> columMonto;
    @FXML
    private TableColumn<Historial, Float> columSaldo;
    @FXML
    private TableColumn<Historial, String> columFecha;
    
    //Colecciones
    private ObservableList<Historial> listaTablaHistorial;
    private Conexion conexion;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //tbvHistorial.setSelectionModel(null);
        // TODO
        conexion = new Conexion();
        conexion.EstablecerConexion();
        //
        // Generar la tabla de historial
        listaTablaHistorial = FXCollections.observableArrayList();
        Historial.GenerarHistorial(conexion.getConnection(), listaTablaHistorial, prestatario);
        // Enlazar tableview con la coleccion
        tbvHistorial.setItems(listaTablaHistorial);
        // Setera columnas
        columFecha.setCellValueFactory(new PropertyValueFactory<Historial,String>("fecha"));
        columSucursal.setCellValueFactory(new PropertyValueFactory<Historial,String>("sucural"));
        columMonto.setCellValueFactory(new PropertyValueFactory<Historial,Float>("monto"));
        //Calcular el saldo, sino cmaibar nombre a la columna
        columSaldo.setCellValueFactory(new PropertyValueFactory<Historial,Float>("saldo"));
    }    

//76894310
    private void ebHistorial(MouseEvent event) {
        System.out.println("Moviendo a pestaña historial");
    }

    private void ebReporte(MouseEvent event) {
        System.out.println("Moviendo a pestaña reporte");
    }
    
    
}
