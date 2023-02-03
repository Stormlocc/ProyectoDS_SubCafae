package subcafae;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SubScene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import subcafae.entidad.Conexion;
import subcafae.entidad.Historial;
import subcafae.entidad.Prestamo;

import static subcafae.FXMLLoginController.prestatario;

/**
 * FXML Controller class
 *
 * @author mlocc
 */
public class FXMLDocumentReporteController implements Initializable {

    @FXML
    private AnchorPane anchorPanel;
    @FXML
    private LineChart<?, ?> lnchart;
    @FXML
    private Label pagoMensual;
    @FXML
    private Label saldo;
    @FXML
    private ProgressBar bProgreso;

    private ObservableList<Historial> listaTablaHistorial;
    private ObservableList<Prestamo> listaPrestamo;
    @FXML
    private Label mesesRestantes;
    @FXML
    private Label portentaje;
    private Conexion conexion;

    private Float totalPagado = 0.0F ;
    private Float totalPrestamo = 0.0F ;
    private int mesesPagados = 0;
    private int mesesTotal = 0;
    /**
     * Initializes the controller class.
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conexion = new Conexion();
        conexion.EstablecerConexion();
        LlenarLineChart();
        LLenarProgressBar();
        conexion.CerrarConexion();
    }
    private void LLenarProgressBar() {
        listaPrestamo = FXCollections.observableArrayList();
        Prestamo.ObtenerPrestamos( conexion.getConnection(), listaPrestamo, prestatario.getIdPrestatario());
        //Total de prestamo
        for (int i = 0; i < listaPrestamo.size(); i++) {
            totalPrestamo += listaPrestamo.get(i).getImporte();
            mesesTotal += listaPrestamo.get(i).getMeses();
            mesesPagados += 1;
        }
        String pag= String.valueOf(Math.round((totalPrestamo- totalPagado) / (mesesTotal-mesesPagados)) /1.0)  ;
        pagoMensual.setText("S/. "+pag);
        String mes= String.valueOf(mesesTotal-mesesPagados);
        mesesRestantes.setText(mes);
        saldo.setText("S/. "+String.valueOf(Math.round(totalPrestamo- totalPagado)/1.0));
        bProgreso.setProgress(totalPagado/totalPrestamo);
        portentaje.setText(totalPagado/totalPrestamo*100 + " %");
    }
    public void  LlenarLineChart(){
        listaTablaHistorial = FXCollections.observableArrayList();
        //Buscar historial
        Historial.GenerarHistorial(conexion.getConnection(), listaTablaHistorial, prestatario);
        XYChart.Series serie = new XYChart.Series();
        //Llenar Line Chart
        for (int i = 0; i < listaTablaHistorial.size(); i++) {
            totalPagado = totalPagado+ listaTablaHistorial.get(i).getMonto();
            serie.getData().add(new  XYChart.Data(Integer.toString(i+1),listaTablaHistorial.get(i).getMonto()));
        }
        //Agregar puntos a tabla
        lnchart.getData().add(serie);

    }

}
//22322556

