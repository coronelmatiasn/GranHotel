
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
            statement.setInt (1, habitacion.getnHabitacion());
            statement.setInt (2, habitacion.getPiso());
            statement.setBoolean (3, habitacion.getEstado());
            statement.setObject(4, habitacion.getTipoHabitacion());
            
            
            statement.executeUpdate();
            statement.close();
            
        }  catch (SQLException ex) {
            System.out.println("Error al insertar habitacion: " + ex.getMessage());
        }
    }
       
            

    
public List <Habitacion> obtenerHabitacion(){
       ArrayList <Habitacion> habitaciones = new ArrayList<>();
            

        try {
            String sql = "SELECT * FROM habitacion;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Habitacion habitacion;
            while(resultSet.next()){
                habitacion = new Habitacion();
                habitacion.setnHabitacion (resultSet.getInt ("nHabitacion"));
                habitacion.setPiso (resultSet.getInt ("piso"));
                habitacion.setEstado (resultSet.getBoolean ("estado"));
                habitacion.setTipoHabitacion ((TipoHabitacion) resultSet.getObject("tipoHabitacion"));
                

                habitaciones.add(habitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista de habitaciones: " + ex.getMessage());
        }
         
        return habitaciones;
    }
}
