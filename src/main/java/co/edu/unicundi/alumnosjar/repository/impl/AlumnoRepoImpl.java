package co.edu.unicundi.alumnosjar.repository.impl;

import co.edu.unicundi.alumnosjar.entity.Alumno;
import co.edu.unicundi.alumnosjar.repository.IAlumnoRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

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
       this.em.remove(obj);
    }    

   /* @Override
    public void eliminarNativo(Integer id) {
        Query eliminar = em.createNamedQuery("Alumno.EliminarNativo");
        eliminar.setParameter(1, id);
        eliminar.executeUpdate();
    }*/
    @Override
    public void eliminarNativo(Integer id) {
        
        this.em.createNamedQuery("Alumno.EliminarID").setParameter(1, id).executeUpdate();
       
    }

    @Override
    public int validarExistencia(Integer id) {
        Query query = em.createNamedQuery("Alumno.ContarId").setParameter(1, id);
        Number validador = (Number) query.getSingleResult();
        int respuesta = validador.intValue();
        return respuesta;
    }
}
