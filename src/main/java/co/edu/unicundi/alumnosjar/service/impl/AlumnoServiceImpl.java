package co.edu.unicundi.alumnosjar.service.impl;

import co.edu.unicundi.alumnosjar.repository.IAlumnoRepo;
import co.edu.unicundi.alumnosjar.service.IAlumnoService;
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
}
