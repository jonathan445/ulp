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
        MateriaData md = new MateriaData();
        CursadaData cd = new CursadaData();
        
        // Crear alumnos:
        Alumno a1 = ad.altaAlumno(new Alumno("Pepe", LocalDate.of(1995, Month.JUNE, 21), true));
        Alumno a2 = ad.altaAlumno(new Alumno("Jose", LocalDate.of(1999, Month.MAY, 15), false));
        Alumno a3 = ad.altaAlumno(new Alumno("Juan", LocalDate.of(1991, Month.OCTOBER, 3), true));
        
        // Crear materias
        Materia m1 = md.altaMateria(new Materia("Matemática"));
        Materia m2 = md.altaMateria(new Materia("Laboratorio de Programación"));
        Materia m3 = md.altaMateria(new Materia("Ingles"));
        
        // Alumnos cursan materias
        cd.altaCursada(new Cursada(a1, m1, 10));
        cd.altaCursada(new Cursada(a1, m2, 7));
        cd.altaCursada(new Cursada(a1, m3, 8));
        cd.altaCursada(new Cursada(a2, m3, 9));
        cd.altaCursada(new Cursada(a3, m1, 5));
        cd.altaCursada(new Cursada(a3, m3, 9));
        
        //1. Permitir al personal administrativo listar las materias que cursa un alumno
        System.out.println("Materias cursadas por el alumno " + a1.getNombre());
        for(Cursada c : cd.obtenerCursadasAlumno(a1.getId())){
            System.out.println(" - " + c.getMateria().getNombre() + ": " + c.getNota());
        }
        //2. Premitir al personal administrativo listar los alumnos inscriptos en una materia
        System.out.println("Alumnos que cursan la materia " + m1.getNombre());
        for (Cursada c : cd.obtenerCursadasMateria(m1.getId())){
            System.out.println(" - " + c.getAlumno().getNombre() + ": " + c.getNota());
        }
        //3. Permitir que un alumno se pueda inscribir o des-inscribir en las materias que desee
        cd.altaCursada(new Cursada(a2, m1, 10)); // Ahora Jose cursa Matemática y tiene un 10
        //4. Permitir registrar la calificación final de una materia que está cursando
        cd.actualizarCursada(a2.getId(), m1.getId(), 1); // Ahora tiene un 1 en vez de un 10
        //5. Permitir el alta, baja y modificación de los alumnos y las materias.
        // Arriba
    }
}
