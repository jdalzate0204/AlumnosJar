package co.edu.unicundi.alumnosjar.service.impl;

import co.edu.unicundi.alumnosjar.entity.Alumno;
import co.edu.unicundi.alumnosjar.repository.IAlumnoRepo;
import co.edu.unicundi.alumnosjar.service.IAlumnoService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author acer
 */
@Stateless
public class AlumnoServiceImpl implements IAlumnoService{

    @EJB
<<<<<<< HEAD
    private IAlumnoRepo repo;
=======
    public IAlumnoRepo repo;
>>>>>>> 7f51d3d2667a67d776c001f3c505e80c6920fb92

    @Override
    public void guardar(Alumno obj) {
       this.repo.guardar(obj);
    }

    @Override
    public List<Alumno> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alumno listarPorId(Integer id) {
        Alumno alumno = repo.listarPorId(id);
        if (alumno != null)
            return alumno;
        else
            throw new NotFoundException("Alumno no encontrado");
    }

    @Override
    public void editar(Alumno obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
