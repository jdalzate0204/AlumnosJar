package co.edu.unicundi.alumnosjar.service.impl;

import co.edu.unicundi.alumnosjar.entity.Alumno;
import co.edu.unicundi.alumnosjar.repository.IAlumnoRepo;
import co.edu.unicundi.alumnosjar.service.IAlumnoService;
import java.util.*;
import javax.ejb.*;
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

    List<Alumno> list;
    Alumno alumno;
    HashMap<String, String> errores = new HashMap();
    
    @Override
    public void guardar(Alumno obj) throws CloneNotSupportedException {
      
        list = repo.listarTodos();
        alumno = null;
        
        for (ConstraintViolation error: obj.validar())
            errores.put(error.getPropertyPath().toString(), error.getMessage());

        if (errores.size() > 0)
            throw new IllegalArgumentException(errores.toString());
        else {
            for (Alumno a: list){
                if(obj.getCedula().equals(a.getCedula()))
                    alumno = a;
            }
            
            if (alumno != null)
                throw new CloneNotSupportedException("La cedula ingresada ya esta registrada con otro usuario");
            else 
                this.repo.guardar(obj);
        }  
    }

    @Override
    public List<Alumno> listar() {
        return repo.listarTodos();
    }

    @Override
    public Alumno listarPorId(Integer id) {
        alumno = repo.listarPorId(id);
        if (alumno != null)
            return alumno;
        else
            throw new NotFoundException("Alumno no encontrado");
    }

    @Override
    public void editar(Alumno obj) throws CloneNotSupportedException {
        list = repo.listarTodos();
        alumno = null;

        for (ConstraintViolation error: obj.validar())
            errores.put(error.getPropertyPath().toString(), error.getMessage());

        if (errores.size() > 0)
            throw new IllegalArgumentException(errores.toString());
        else {
            for (Alumno a: list){
                if(obj.getCedula().equals(a.getCedula()))
                    alumno = a;
            }
            
            if ((alumno == null) || ((alumno.getId() == obj.getId()) && (alumno.getCedula().equals(obj.getCedula()))))
                this.repo.editar(obj);
            else
                throw new CloneNotSupportedException("La cedula ingresada ya esta registrada con otro usuario");
            }
    }

    @Override
    public void eliminar(Integer id) {
        Alumno alumno=this.listarPorId(id);
        this.repo.eliminar(alumno);
    }

    @Override
    public void eliminarNativo(Integer id) {
        int respuesta=this.repo.validarExistencia(id);
        System.out.println(respuesta);
        if(respuesta==1){
           this.repo.eliminarNativo(id);  
        }else
            throw new NotFoundException("Alumno no encontrado");
       
    }
} 