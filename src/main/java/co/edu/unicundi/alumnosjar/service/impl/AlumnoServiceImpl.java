package co.edu.unicundi.alumnosjar.service.impl;

import co.edu.unicundi.alumnosjar.entity.Alumno;
import co.edu.unicundi.alumnosjar.repository.IAlumnoRepo;
import co.edu.unicundi.alumnosjar.service.IAlumnoService;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolation;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author acer
 */
@Stateless
public class AlumnoServiceImpl implements IAlumnoService{

    @EJB
    private IAlumnoRepo repo;

    @Override
    public void guardar(Alumno obj) throws CloneNotSupportedException {
   
      try{
         HashMap<String, String> errores = new HashMap();

         for (ConstraintViolation error: obj.validar())
             errores.put(error.getPropertyPath().toString(), error.getMessage());

         if (errores.size() > 0)
             throw new IllegalArgumentException(errores.toString());
         else{
                 Alumno alumno=repo.ListAlumno(obj.getCedula());
          
                if(obj.getCedula().equals(alumno.getCedula())){
                       this.repo.guardar(obj);
                }else
                   throw new CloneNotSupportedException("Cedula ya registrada"); 
         } 
       } catch (CloneNotSupportedException e) {
                throw e;
            } catch (IllegalArgumentException e) {
                throw e;
       }
    }

    @Override
    public List<Alumno> listar() {
       return repo.listarTodos();
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
