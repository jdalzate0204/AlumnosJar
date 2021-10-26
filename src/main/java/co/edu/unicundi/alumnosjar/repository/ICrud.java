package co.edu.unicundi.alumnosjar.repository;

import java.util.List;

/**
 *
 * @author acer
 */
public interface ICrud<T, V> {
    //Metodos genericos
    public void guardar(T obj);
    public List<T> listarTodos();
    public T listarPorId(V id);
    public void editar(T obj);
    public void eliminar(T obj);
   
}
