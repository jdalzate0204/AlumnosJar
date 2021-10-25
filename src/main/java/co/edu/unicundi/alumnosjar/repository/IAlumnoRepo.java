package co.edu.unicundi.alumnosjar.repository;

import co.edu.unicundi.alumnosjar.entity.Alumno;
import javax.ejb.Local;

/**
 *
 * @author acer
 */
@Local
public interface IAlumnoRepo extends ICrud<Alumno, Integer> {

}
