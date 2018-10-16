
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
            statement.setInt (5, tipoHabitacion.getTipoCama().getId());
            
            statement.executeUpdate();
            statement.close();
            
        }  catch (SQLException ex) {
            System.out.println("Error al insertar un tipo de habitacion: " + ex.getMessage());
        }
    }
    
public List <TipoHabitacion> obtenerTipoHabitacion(){
       ArrayList <TipoHabitacion> tipoHabitaciones = new ArrayList<>();

        try {
            String sql = "SELECT h.id_tipo_habitacion, h.categoria_habitacion, h.cantidad_maxima_personas, h.precio_por_noche, h.id_tipo_cama, c.categoria_cama " +
                         "FROM `tipo de habitacion` h LEFT JOIN `tipo de cama` c ON h.id_tipo_cama = c.id_tipo_cama;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            TipoHabitacion tipoHabitacion;
            TipoDeCama tipoDeCama;
            while(resultSet.next()){
                tipoHabitacion = new TipoHabitacion();
                tipoDeCama = new TipoDeCama();
                
                tipoDeCama.setId(resultSet.getInt("id_tipo_cama"));
                tipoDeCama.setCategoria(resultSet.getString("categoria_cama"));
                        
                tipoHabitacion.setId(resultSet.getInt("id_tipo_habitacion"));
                tipoHabitacion.setCategoria(resultSet.getString("categoria_habitacion"));
                tipoHabitacion.setCantidadMaxPersonas (resultSet.getInt("cantidad_maxima_personas"));
                tipoHabitacion.setPrecioXNoche(resultSet.getDouble("precio_por_noche"));
                tipoHabitacion.setTipoCama(tipoDeCama);
                tipoHabitaciones.add(tipoHabitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista tipoHabitaciones: " + ex.getMessage());
        }
         
        return tipoHabitaciones;
    }
}

