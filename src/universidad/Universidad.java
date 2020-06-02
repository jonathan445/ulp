/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;
import java.sql.*;
/**
 *
 * @author jpere
 */
public class Universidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        final String HOST = "localhost:3306";
        final String DB = "universidad";
        final String URL = "jdbc:mariadb://" + HOST + "/" + DB;
        final String USUARIO = "root";
        final String CLAVE = "";

        try{
            Connection con = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("¡Conexión exitosa!");
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
