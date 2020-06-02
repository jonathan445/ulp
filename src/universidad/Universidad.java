package universidad;
import java.time.LocalDate;
import java.time.Month;
import universidad.data.*;
import universidad.entidades.*;

public class Universidad {
    public static void main(String[] args) {
        final String HOST = "localhost:3306";
        final String DB = "universidad";
        final String URL = "jdbc:mariadb://" + HOST + "/" + DB;
        final String USUARIO = "root";
        final String CLAVE = "";
        
        Conexion con = new Conexion(URL, USUARIO, CLAVE);
        
        AlumnoData ad = new AlumnoData();
        // Agregar alumnos
        ad.altaAlumno(new Alumno("True", LocalDate.of(2000, Month.MAY, 15), true));
        ad.altaAlumno(new Alumno("False", LocalDate.of(2000, Month.MAY, 15), false));
        // Listar todos los alumnos
        for(Alumno al : ad.obtenerAlumnos()){
            System.out.println("ID" + al.getId());
        }
        // Eliminar alumno
        ad.bajaAlumno(24);
    }
}
