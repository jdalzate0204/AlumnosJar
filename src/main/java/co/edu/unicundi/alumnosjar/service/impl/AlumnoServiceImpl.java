package co.edu.unicundi.alumnosjar.service.impl;

import co.edu.unicundi.alumnosjar.entity.Alumno;
import co.edu.unicundi.alumnosjar.repository.IAlumnoRepo;
import co.edu.unicundi.alumnosjar.service.IAlumnoService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author acer
 */
@Stateless
public class AlumnoServiceImpl implements IAlumnoService{

    @EJB
    public IAlumnoRepo repo;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
