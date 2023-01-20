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
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author mlocc
 */
public class FXMLDocumentAgregarController implements Initializable {

    @FXML
    private TextField inputImporte;
    @FXML
    private Label labelConfirmar;
    @FXML
    private TextField inputMeses;
    @FXML
    private TextField mostrarUsuario;
    @FXML
    private TextField mostrarPrestatario;
    @FXML
    private Button bPrestamo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Bloquear edicion de usuario y prestatario
        // TODO
    }    

    @FXML
    private void ebPagar(MouseEvent event) {
        System.out.println("Click en boton pagar");
        try{
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ds_subcafae","root","");
            //Agregar consulta de pagos, para generar nueva llave primaria
            //String pk = ;
            //Permite agregar codigo sql, (inyectar codigo)
            PreparedStatement pst = conexion.prepareStatement("INSERT INTO SUCURSAL VALUES (?,?)");
            //Autoincremente
            //pst.setString(1, inputDocCancelacion.getText().trim());
            pst.setString(1, null);
            //Detectar que prestamo pagara, (dar aviso si el prestamo ya esta pagado
            pst.setString(2, inputImporte.getText().trim());
            //
            //pst.setString(3, inputImporte.getText().trim());
            //Conseguir fecha del sitema
            //pst.setString(4, inputFecha.getText().trim());
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
    }
    
}
