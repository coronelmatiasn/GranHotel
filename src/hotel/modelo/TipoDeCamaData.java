/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.modelo;

import hotel.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fati
 */
public class TipoDeCamaData {
    private Connection connection = null;

    public TipoDeCamaData(Conexion conexion) {
        connection = conexion.getConexion();
    }
    
    public void guardarTipoDeCama (TipoDeCama tipoDeCama) {
        try {
            String sql = "INSERT INTO `Tipo de Cama` (id_tipo_cama, categoria_cama) VALUES ( ? , ? );";
            
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt (1, tipoDeCama.getId());
            statement.setString (2, tipoDeCama.getCategoria());
            
            statement.executeUpdate();
            statement.close();
            
        }  catch (SQLException ex) {
            System.out.println("Error al insertar un tipo de cama: " + ex.getMessage());
        }
    }
    
public List <TipoDeCama> obtenerTipoDeCama(){
       ArrayList <TipoDeCama> tiposDeCama = new ArrayList<>();
            

        try {
            String sql = "SELECT * FROM `Tipo de Cama`;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            TipoDeCama tipoDeCama;
            while(resultSet.next()){
                tipoDeCama = new TipoDeCama();
                tipoDeCama.setId(resultSet.getInt("id_tipo_cama"));
                tipoDeCama.setCategoria(resultSet.getString("categoria"));

                tiposDeCama.add(tipoDeCama);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista de tipos de cama: " + ex.getMessage());
        }
         
        return tiposDeCama;
    }
}
