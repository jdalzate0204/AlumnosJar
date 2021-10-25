package co.edu.unicundi.alumnosjar.repository.impl;

import co.edu.unicundi.alumnosjar.entity.Alumno;
import co.edu.unicundi.alumnosjar.repository.IAlumnoRepo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author acer
 */
public class AlumnoRepoImpl implements IAlumnoRepo{
    
    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager em;

    @Override
    public void guardar(Alumno obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alumno listarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Alumno obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Alumno obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
