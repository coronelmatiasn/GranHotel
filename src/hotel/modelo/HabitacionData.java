
package hotel.modelo;

import hotel.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class HabitacionData {
    private Connection connection = null;

    public HabitacionData(Conexion conexion) {
        connection = conexion.getConexion();
    }
    
    public void guardarHabitacion (Habitacion habitacion) {
        try {
            String sql = "INSERT INTO habitacion (nHabitacion, piso, estado, tipoHabitacion) VALUES ( ? , ? , ? , ? );";
            
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt (1, habitacion.getNHabitacion());
            statement.setInt (2, habitacion.getPiso());
            statement.setBoolean (3, habitacion.getEstado());
            statement.setInt (4, habitacion.getTipoHabitacion().getId());
            
            
            statement.executeUpdate();
            statement.close();
            
        }  catch (SQLException ex) {
            System.out.println("Error al insertar habitacion: " + ex.getMessage());
        }
    }
       
            

    
public List <Habitacion> obtenerHabitacion(){
       ArrayList <Habitacion> habitaciones = new ArrayList<>();
            

        try {
            String sql = "SELECT h.nro_habitacion, h.piso, h.estado, h.id_tipo_habitacion, t.categoria_habitacion, " +
                         "t.cantidad_maxima_personas, t.precio_por_noche, t.id_tipo_cama, c.categoria_cama " +
                         "FROM `habitacion` h, `tipo_de_habitacion` t, tipo_de_cama c " + 
                         "WHERE h.id_tipo_habitacion = t.id_tipo_habitacion AND t.id_tipo_cama = c.id_tipo_cama;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Habitacion habitacion;
            TipoHabitacion tipoHabitacion;
            TipoDeCama tipoDeCama;
            while(resultSet.next()){
                habitacion = new Habitacion();
                tipoHabitacion = new TipoHabitacion();
                tipoDeCama = new TipoDeCama();
                
                tipoDeCama.setId(resultSet.getInt("id_tipo_cama"));
                tipoDeCama.setCategoria(resultSet.getString("categoria_cama"));
                
                tipoHabitacion.setId(resultSet.getInt("id_tipo_habitacion"));
                tipoHabitacion.setCategoria(resultSet.getString("categoria_habitacion"));
                tipoHabitacion.setCantidadMaxPersonas(resultSet.getInt("cantidad_maxima_personas"));
                tipoHabitacion.setPrecioXNoche(resultSet.getDouble("precio_por_noche"));
                
                habitacion.setNHabitacion (resultSet.getInt ("nro_habitacion"));
                habitacion.setPiso (resultSet.getInt ("piso"));
                habitacion.setEstado (resultSet.getBoolean ("estado"));
 
                tipoHabitacion.setTipoCama(tipoDeCama);
                habitacion.setTipoHabitacion (tipoHabitacion);
                

                habitaciones.add(habitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista de habitaciones: " + ex.getMessage());
        }
         
        return habitaciones;
    }
}
