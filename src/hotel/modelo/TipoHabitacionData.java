
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
            String sql = "INSERT INTO tipoHabitacion (categoria_habitacion, cantidad_maxima_personas, precio_por_noche, id_tipo_cama) VALUES ( ? , ? , ? , ? );";
            
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString (1, tipoHabitacion.getCategoria());
            statement.setInt (2, tipoHabitacion.getCantidadMaxPersonas());
            statement.setDouble (3, tipoHabitacion.getPrecioXNoche());
            statement.setInt(4, tipoHabitacion.getTipoCama().getId_tipo_cama());
            
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    tipoHabitacion.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            
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
                tipoHabitacion.setCantidadMaxPersonas(resultSet.getInt("cantidad_maxima_personas"));
                tipoHabitacion.setPrecioXNoche(resultSet.getDouble("precio_por_noche"));
                TipoDeCama tc = buscarTipoCama(resultSet.getInt("id_tipo_cama"));
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


    public TipoHabitacion buscartipohabitacion(int id){
        TipoHabitacion tipohabitacion = null;

        try {  
            String sql = "SELECT * FROM tipo_de_habitacion WHERE id_tipo_habitacion = ?;";

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
    
    public ArrayList<TipoHabitacion> buscartipohabitacion(String categoria, int cantPersonas){
        TipoHabitacion tipoHabitacion = null;
        ArrayList<TipoHabitacion> tiposHabitacion = new ArrayList<>();

        try {  
            String sql = "SELECT * FROM tipo_de_habitacion " + 
                         "WHERE categoria_habitacion = ? " +
                         "AND cantidad_maxima_personas >= ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, categoria);
            statement.setInt(2, cantPersonas);


            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                tipoHabitacion = new TipoHabitacion();
                tipoHabitacion.setId(resultSet.getInt("id_tipo_habitacion"));
                tipoHabitacion.setCategoria(resultSet.getString("categoria_habitacion"));
                tipoHabitacion.setCantidadMaxPersonas(resultSet.getInt("cantidad_maxima_personas"));
                tipoHabitacion.setPrecioXNoche(resultSet.getDouble("precio_por_noche"));
                TipoDeCama c = buscarTipoCama(resultSet.getInt("id_tipo_cama"));
                tipoHabitacion.setTipoCama(c);
                
                tiposHabitacion.add(tipoHabitacion);
            }      

            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }

        return  tiposHabitacion;
    }
    
    public ArrayList<String> obtenerCategorias() {
        ArrayList<String> categorias = new ArrayList<>();     

        try {
            String sql = "SELECT DISTINCT categoria FROM tipo_de_habitacion;";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                categorias.add(resultSet.getString("categoria"));
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista tipoHabitaciones: " + ex.getMessage());
        }
         
        return categorias;
    }

    public TipoDeCama buscarTipoCama(int id){
        TipoDeCamaData tc= new TipoDeCamaData(conexion);
        
        return tc.buscarTipoCama(id);    
    }
}

