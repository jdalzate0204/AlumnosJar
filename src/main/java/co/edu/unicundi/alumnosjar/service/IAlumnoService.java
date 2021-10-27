package co.edu.unicundi.alumnosjar.service;
import org.codehaus.jettison.json.JSONException;
import co.edu.unicundi.alumnosjar.entity.Alumno;
import java.util.List;
import javax.ejb.Local;
import javax.json.JsonException;


/**
 *
 * @author acer
 */
@Local
public interface IAlumnoService  {
    public void guardar(Alumno obj) throws CloneNotSupportedException;
    public List<Alumno> listar();
    public Alumno listarPorId(Integer id);
    public void editar(Alumno obj) throws CloneNotSupportedException;
    public void eliminar(Integer id);
    public void eliminarNativo(Integer id);
}
