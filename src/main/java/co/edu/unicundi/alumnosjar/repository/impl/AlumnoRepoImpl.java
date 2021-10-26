package co.edu.unicundi.alumnosjar.repository.impl;

import co.edu.unicundi.alumnosjar.entity.Alumno;
import co.edu.unicundi.alumnosjar.repository.IAlumnoRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author acer
 */
@Stateless
public class AlumnoRepoImpl implements IAlumnoRepo{
    
    @PersistenceContext(unitName = "conexionAlumnos")
    private EntityManager em;

    @Override
    public void guardar(Alumno obj) {
       this.em.persist(obj);
    }

    @Override
    public List<Alumno> listarTodos() {
        TypedQuery<Alumno> query = em.createNamedQuery("Alumno.ListarTodos", Alumno.class);
        return query.getResultList(); 
    } 

    @Override
    public Alumno listarPorId(Integer id) {
        Alumno alumno = em.find(Alumno.class, id);
        return alumno;
    }

    @Override
    public void editar(Alumno obj) {
        this.em.merge(obj);
    }

    @Override
    public void eliminar(Alumno obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alumno ListAlumno(String cedula) {
        Alumno alumno = em.find(Alumno.class,cedula );
        return alumno;
    }
    
 
    
}
