package universidad.data;

import java.sql.*;
import java.util.ArrayList;
import universidad.Conexion;
import universidad.entidades.Materia;

public class MateriaData {
    public Materia altaMateria(Materia materia){
        try {
            String sql = "INSERT INTO materia (nombre) VALUES ('" + materia.getNombre() + "');";
            Statement s = Conexion.get().createStatement();
            s.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = s.getGeneratedKeys();
            
            if (rs.first())
                materia.setId(rs.getInt(1));
            s.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return materia;
    }
    
    public ArrayList<Materia> obtenerMaterias(){
        ArrayList<Materia> resultados = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM materia";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()){
                resultados.add(new Materia(rs.getInt("ID"), rs.getString("NOMBRE")));
            }
            s.close();
        } catch (SQLException e){
            System.out.println("Error:" + e.getMessage());
        }
        
        return resultados;
    }
    
    public Materia obtenerMateria(int id){
        Materia materia = null;
        try {
            String sql = "SELECT * FROM materia WHERE id = " + id + ";";

            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()){
                materia = new Materia(rs.getInt("ID"), rs.getString("NOMBRE"));
            }      
            s.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return materia;
    }
    
    public void bajaMateria(int id){
        try {
            String sql = "DELETE FROM materia WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            s.executeQuery(sql);
            
            s.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public void actualizarMateria(int id, Materia materia){
        try {
            String sql = "UPDATE materia SET nombre = " + materia.getNombre() + " WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            s.execute(sql);
            
            s.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
    

