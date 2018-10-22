
package hotel.modelo;

import hotel.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class TipoHabitacionData {
    private Connection connection = null;
    private Conexion conexion;

    public TipoHabitacionData(Conexion conexion) {
        this.conexion=conexion;
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
            statement.setInt(5, tipoHabitacion.getTipoCama().getId_tipo_cama());
            
            statement.executeUpdate();
            statement.close();
            
        }  catch (SQLException ex) {
            System.out.println("Error al insertar un tipo de habitacion: " + ex.getMessage());
        }
    }          
 
    public ArrayList <TipoHabitacion> obtenerTipoHabitacion(){
        ArrayList <TipoHabitacion> tipoHabitaciones = new ArrayList<>();     

        try {
            String sql = "SELECT * FROM tipo_de_habitacion;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            TipoHabitacion tipoHabitacion;
            while(resultSet.next()){
                tipoHabitacion = new TipoHabitacion();
                tipoHabitacion.setId(resultSet.getInt("id_tipo_habitacion"));
                tipoHabitacion.setCategoria(resultSet.getString("categoria_habitacion"));
                tipoHabitacion.setCantidadMaxPersonas (resultSet.getInt("cantidad_maxima_personas"));
                tipoHabitacion.setPrecioXNoche (resultSet.getDouble("precio_por_noche"));
                TipoDeCama tc=buscarTipoCama(resultSet.getInt("id_tipo_cama"));
                tipoHabitaciones.add(tipoHabitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista tipoHabitaciones: " + ex.getMessage());
        }
         
        return tipoHabitaciones;
    }

public void cargarComboxConTipoHabitacion(JComboBox comboxTipo){
    
    String sql= "SELECT * FROM tipo_de_habitacion;";
    
    try {
     
       PreparedStatement statement = connection.prepareStatement(sql);
       ResultSet resultSet = statement.executeQuery();
       
       
       while(resultSet.next()){
           
            comboxTipo.addItem(resultSet.getString("categoria_habitacion"));
            
       }
       statement.close();
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
        
    }
       
        }


public  TipoHabitacion buscartipohabitacion(int id){
    TipoHabitacion tipohabitacion=null;
    try {
            
            String sql = "SELECT * FROM tipo_de_habitacion WHERE id_tipo_habitacion =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                 tipohabitacion = new TipoHabitacion();
               tipohabitacion.setId(resultSet.getInt("id_tipo_habitacion"));
               tipohabitacion.setCategoria(resultSet.getString("categoria_habitacion"));
              tipohabitacion.setCantidadMaxPersonas(resultSet.getInt("cantidad_maxima_personas"));
               tipohabitacion.setPrecioXNoche(resultSet.getDouble("precio_por_noche"));
              TipoDeCama c = buscarTipoCama(resultSet.getInt("id_tipo_cama"));
              tipohabitacion.setTipoCama(c);
                
            }      
            statement.close();
            
            
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
        
        return  tipohabitacion;
    }

 public TipoDeCama buscarTipoCama(int id){
    
       TipoDeCamaData tc= new TipoDeCamaData(conexion);
        
        return tc.buscarTipoCama(id);
        
    }
}

