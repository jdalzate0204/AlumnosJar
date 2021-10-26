package co.edu.unicundi.alumnosjar.repository;

import co.edu.unicundi.alumnosjar.entity.Alumno;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author acer
 */

public interface IAlumnoRepo extends ICrud<Alumno, Integer> {
    public Alumno ListAlumno(String cedula);
}
