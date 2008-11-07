/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

import java.util.Iterator;
import java.util.Vector;

/**
 * Esta clase representa un conjunto genérico. La misma es utilizada
 * para los conjuntos de estados y transiciones, correspondientes a
 * un autómata finito y a un determinado estado destino de los estados
 * de éste.
 * @param <T> El tipo de dato almacenado en esta conjunto.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class Conjunto<T> implements Iterable<T> {
    
    /**
     * Conjunto de elementos.
     */
    private Vector<T> elementos;
    
    /**
     * Constructor de la clase.
     */
    public Conjunto() {
        elementos = new Vector<T>();
    }
    
    /**
     * Agrega un nuevo elemento al conjunto.
     * @param elemento El nuevo elemento a agregar.
     */
    public void agregar(T elemento) {
        elementos.add(elemento);
    }
    
    /**
     * Elimina un elemento del conjunto.
     * @param elemento El elemento a ser eliminado.
     */
    public void eliminar(T elemento) {
        elementos.remove(elemento);
    }
    
    /**
     * Retorna el i-ésimo elemento del conjunto.
     * @param i Posición del elemento a retornar.
     * @return El elemento buscado.
     */
    public T obtener(int i) {
        return elementos.get(i);
    }
    
    /**
     * Retorna el primer elemento del conjunto.
     * @return El primer elemento del conjunto.
     */
    public T obtenerPrimero() {
        return elementos.firstElement();
    }
    
    /**
     * Retorna el último elemento del conjunto.
     * @return El último elemento del conjunto.
     */
    public T obtenerUltimo() {
        return elementos.lastElement();
    }    
    /**
     * Retorna la cantidad de transiciones del conjunto.
     * @return Cantidad de transiciones del conjunto.
     */
    public int cantidad() {
        return elementos.size();
    }

    /**
     * Retorna un iterador sobre los elementos del conjunto.
     * Es útil para realizar recorridos sobre los elementos
     * que están contenidos en el conjunto, tales como estados
     * o transiciones.
     * @return Un objeto <code>Iterator<code> con los 
     * elementos de este conjunto.
     */
    public Iterator<T> iterator() {
        return elementos.iterator();
    }
}
