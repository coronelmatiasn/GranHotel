
package hotel.modelo;

import hotel.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TipoDeCamaData {
    private Connection connection = null;

    public TipoDeCamaData(Conexion conexion) {
        connection = conexion.getConexion();
    }
    
    public void guardarTipoDeCama (TipoDeCama tipoDeCama) {
        try {
            String sql = "INSERT INTO tipoDeCama (id_tipo_cama, categoria) VALUES ( ? , ?);";
            
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt (1, tipoDeCama.getId_tipo_cama());
            statement.setString (2, tipoDeCama.getCategoria());
          
            statement.executeUpdate();
            statement.close();
            
        }  catch (SQLException ex) {
            System.out.println("Error al insertar una cama: " + ex.getMessage());
        }
    }
       
            

    
public List <TipoDeCama> obtenerTipoDeCama(){
       ArrayList <TipoDeCama> tiposDeCamas = new ArrayList<>();
            

        try {
            String sql = "SELECT * FROM tipoDeCama;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            TipoDeCama tipodecama;
            while(resultSet.next()){
                tipodecama = new TipoDeCama();
                tipodecama.setId_tipo_cama(resultSet.getInt("id"));
               tipodecama.setCategoria(resultSet.getString("categoria"));
            

                tiposDeCamas.add(tipodecama);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista de camas: " + ex.getMessage());
        }
         
        return tiposDeCamas;
    }
}
   
