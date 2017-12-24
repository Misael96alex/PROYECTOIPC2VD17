
package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Usuario {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        
        (new Usuario()).agregarUsuario("tony12", "Antonio", "Ajuchan", "20/03/1994", "123");
        
    }
    public boolean agregarUsuario (String nickname, String nombre, String apellido, String fechaNacimiento, String pasword) throws ClassNotFoundException, SQLException{
        Connection dbConnection = null;
        PreparedStatement statement = null;
        try {
            
            String insert = "INSERT INTO USUARIO (nickname, nombre, apellido, fechaNacimiento, pasword)"
                    + "Values (?,?,?,?,?) ";
            Coneccion d = new Coneccion();
            dbConnection = d.conexion;
            
            statement = dbConnection.prepareStatement(insert);
            statement.setString(1, nickname);
            statement.setString(2, nombre);
            statement.setString(3, apellido);
            statement.setString(4, fechaNacimiento);
            statement.setString(5, pasword);
            
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            Coneccion d = new Coneccion();
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    
}
