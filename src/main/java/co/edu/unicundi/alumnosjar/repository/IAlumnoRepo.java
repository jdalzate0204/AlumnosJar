package co.edu.unicundi.alumnosjar.repository;

import co.edu.unicundi.alumnosjar.entity.Alumno;

/**
 *
 * @author acer
 */

public interface IAlumnoRepo extends ICrud<Alumno, Integer> {
      public void eliminarNativo(Integer id);
      public int validarExistencia(Integer id);
}
