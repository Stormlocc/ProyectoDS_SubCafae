package subcafae.entidad;

import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Sucursal {
    private Integer idSucursal;
    private String nombre;
    public Sucursal(Integer idSucursal, String nombre){
        this.idSucursal = idSucursal;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString(){

        return  this.nombre;
    }
    
    public static void LlenarInformacion(Connection conexion, ObservableList<Sucursal> listaSucursal){
        // completar combo box en sucursal
        try{
            //Consultar a la BD
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM Sucursal");
            while (resultado.next()){
                listaSucursal.add(new Sucursal(resultado.getInt("IdSucursal"),resultado.getString("Nombre")));
            }
        }
        catch (Exception e){
            System.out.println("No se encontro sucursales");
            System.out.println(e);
        }

        
        
    }
    
}
