package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Coneccion {
    public Connection conexion;
    public Coneccion() throws ClassNotFoundException, SQLException{
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mariadb://localhost3306/proyecto?user=root?password=misael96");
            java.sql.Statement s= conexion.createStatement();
            
        } catch (ClassNotFoundException | SQLException e) {
        }
    }
}
