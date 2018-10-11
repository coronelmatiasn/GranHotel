
package hotel.modelo;

import hotel.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TipoHabitacionData {
    private Connection connection = null;

    public TipoHabitacionData(Conexion conexion) {
        connection = conexion.getConexion();
    }
    
    public void guardarTipoHabitacion (TipoHabitacion tipoHabitacion) {
        try {
            String sql = "INSERT INTO tipoHabitacion (id, categoria, cantidadMaxPersonas, precioXNoche, tipoDeCama) VALUES ( ? , ? , ? , ? , ? );";
            
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt (1, tipoHabitacion.getId());
            statement.setString (2, tipoHabitacion.getCategoria());
            statement.setInt (3, tipoHabitacion.getCantidadMaxPersonas());
            statement.setDouble (4, tipoHabitacion.getPrecioXNoche());
            statement.setTipoDeCama (5, tipoHabitacion.getTipoCama());
            
            statement.executeUpdate();
            statement.close();
            
        }  catch (SQLException ex) {
            System.out.println("Error al insertar un tipo de habitacion: " + ex.getMessage());
        }
    }
    
public List <TipoHabitacion> obtenerTipoHabitacion(){
       ArrayList <TipoHabitacion> tipoHabitaciones = new ArrayList<>();

        try {
            int idTipoDeCama;
            String sql = "SELECT * FROM tipoHabitacion;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            TipoHabitacion tipoHabitacion;
            while(resultSet.next()){
                tipoHabitacion = new TipoHabitacion();
                tipoHabitacion.setId (resultSet.getInt("id"));
                tipoHabitacion.setCategoria(resultSet.getString("categoria"));
                tipoHabitacion.setCantidadMaxPersonas (resultSet.getInt("canttidadMaxPersonas"));
                tipoHabitacion.setPrecioXNoche (resultSet.getDouble("precioXNoche"));
                
                
                
                tipoHabitacion.setTipoCama (resultSet.getTipoDeCama ("tipoCama"));

                tipoHabitaciones.add(tipoHabitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista tipoHabitaciones: " + ex.getMessage());
        }
         
        return tipoHabitaciones;
    }
}

