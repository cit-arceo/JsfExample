package idao;

import java.util.List;

/**
 *
 * @author citlalli
 */
public interface Idao <T,V> {
    public boolean insertar(T t);
    public boolean eliminar(V v);
    public boolean actualizar(T t, V v);
    
    public T mostrar(V v);
    public List<T> mostrarTodo();
}
