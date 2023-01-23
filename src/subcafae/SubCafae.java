package subcafae;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author mlocc
 */
public class SubCafae extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("vista/FXMLLogin.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
            Logout(stage);
        });

    }

    public void Logout(Stage stage){
        //Crear aletar
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cerrar sesion de reportes SubCafae");
        alert.setHeaderText("Seguro desea salir del programa?");
        alert.setContentText("Estas apunto de salir.");

        if(alert.showAndWait().get() == ButtonType.OK){
            //Scena actual en la que estamos
            System.out.println("salio del programa");
            stage.close();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
