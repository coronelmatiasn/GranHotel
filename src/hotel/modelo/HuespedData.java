
package hotel.modelo;

import hotel.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class HuespedData {
    private Connection connection = null;

    public HuespedData(Conexion conexion) {
        connection = conexion.getConexion();
    }
    
    public void guardarHuesped (Huesped huesped) {
        try {
            String sql = "INSERT INTO huesped (dni, nombre, domicilio, celular, correo) VALUES ( ? , ? , ? , ? , ? );";
            
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt (1, huesped.getDni());
            statement.setString (2, huesped.getNombre());
            statement.setString (3, huesped.getDomicilio());
            statement.setString (4, huesped.getCelular());
            statement.setString (5, huesped.getCorreo());
            
            statement.executeUpdate();
            statement.close();
            
        }  catch (SQLException ex) {
            System.out.println("Error al insertar un huesped: " + ex.getMessage());
        }
    }
       
            

    
public List <Huesped> obtenerHuesped(){
       ArrayList <Huesped> huespedes = new ArrayList<>();
            

        try {
            String sql = "SELECT * FROM huesped;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Huesped huesped;
            while(resultSet.next()){
                huesped = new Huesped();
                huesped.setDni(resultSet.getInt("dni"));
                huesped.setNombre(resultSet.getString("nombre"));
                huesped.setDomicilio(resultSet.getString("domicilio"));
                huesped.setCelular(resultSet.getString("celular"));
                huesped.setCorreo(resultSet.getString("correo"));

                huespedes.add(huesped);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista de huesped: " + ex.getMessage());
        }
         
        return huespedes;
    }
}
