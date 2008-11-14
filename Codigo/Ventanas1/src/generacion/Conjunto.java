/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

import java.util.Arrays;
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
public class Conjunto<T extends Comparable<T>> 
    implements Iterable<T>, Comparable<Conjunto<T>> {
    
    /**
     * Conjunto de elementos.
     */
    private Vector<T> elementos;
    
    /**
     * Indica si el conjunto está ordenado.
     */
    private boolean estaOrdenado;
    
    /**
     * Constructor de la clase.
     */
    public Conjunto() {
        elementos = new Vector<T>();
        
        /*
         * Inicialmente, el conjunto
         * está ordenado.
         */
        estaOrdenado = true;
    }
    
    /**
     * Agrega un nuevo elemento al conjunto.
     * @param elemento El nuevo elemento a agregar.
     */
    public void agregar(T elemento) {
        /*
         * Si el conjunto está ordenado y elemento a 
         * agregar es mayor que el último, entonces
         * se pierde el orden.
         */
        if (!estaVacio() && obtenerUltimo().compareTo(elemento) > 0)
            estaOrdenado = false;
        
        elementos.add(elemento);
    }
    
    /**
     * Elimina un elemento del conjunto.
     * @param elemento El elemento a ser eliminado.
     */
    public void eliminar(T elemento) {
        boolean eliminado = elementos.remove(elemento);
        
        /*
         * Si se ha eliminado un elemento, podría
         * quedar en orden. Por ejemplo en [1, 3, 2],
         * al eliminar el 3, queda ordenado [1, 2].
         */
        if (eliminado && !getEstaOrdenado())
            estaOrdenado = verificarOrden();
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
     * Retorna la posición de la primera ocurrencia
     * de un elemento en este <code>Conjunto</code>.
     * @param elemento El elemento a buscar.
     * @return La posición de la primera ocurrencia
     * de un elemento en este <code>Conjunto</code>,
     * o -1 si el elemento no está contenido.
     */
    public int obtenerPosicion(T elemento) {
        return elementos.indexOf(elemento);
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
     * Determina si este <code>Conjunto</code> está vacío
     * @return <code>true</code> si este <code>Conjunto</code>
     * está vacío, <code>false</code> en caso contrario.
     */
    public boolean estaVacio() {
        return cantidad() == 0;
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
    
    /**
     * Comprueba si un elemento está contenido en este <code>Conjunto</code>.
     * @param elemento Objeto a buscar en el <code>Conjunto</code>.
     * @return <code>true</code> si <code>elemento</code> está en el 
     * <code>Conjunto</code>, <code>false</code> en caso contrario.
     */
    public boolean contiene(T elemento) {
        return elementos.contains(elemento);
    }
    
    /**
     * Retiene en este <code>Conjunto</code> solo aquellos elementos
     * que estén contenidos en un subconjunto dado.
     * @param subconjunto <code>Conjunto</code> de elementos que deben
     * ser retenidos en este <code>Conjunto</code> (los demás serán
     * eliminados).
     * @return <code>true</code> si este <code>Conjunto</code> ha
     * cambiado como consecuencia de esta llamada, <code>false</code>
     * en caso contrario.
     */
    public boolean retener(Conjunto<T> subconjunto) {
        return elementos.retainAll(subconjunto.elementos);
    }
    
    /**
     * Ordena los elementos del conjunto.
     */
    public void ordenar() {
        Object[] arregloTemp = elementos.toArray();
        Arrays.sort(arregloTemp);
        
        elementos.clear();
        for (Object e : arregloTemp)
            elementos.add((T) e);
    }
    
    /**
     * Verifica si el conjunto está ordenado o no.
     * @return <code>true</code> si el conjunto está 
     * ordenado, <code>false</code> en caso contrario.
     */
    public boolean getEstaOrdenado() {
        return estaOrdenado;
    }
    
    /**
     * Verifica si el conjunto está ordenado, realizando
     * una comparación entre pares de elementos.
     * @return <code>true</code> si el conjunto está 
     * ordenado, <code>false</code> en caso contrario.
     */
    private boolean verificarOrden() {
        if (estaVacio())
            return true;
        
        T actual = obtenerPrimero();
        
        for (int i=1; i < cantidad(); i++) {
            T sgte = obtener(i);
            
            if (actual.compareTo(sgte) > 0)
                return false;
            
            actual = sgte;
        }
        
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        
        if (getClass() != obj.getClass())
            return false;
        
        final Conjunto<T> other = (Conjunto<T>) obj;
        return this.elementos.equals(other.elementos);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.elementos != null ? this.elementos.hashCode() : 0);
        return hash;
    }
    
    @Override
    public String toString() {
        return elementos.toString();
    }

    public int compareTo(Conjunto<T> obj) {
        if (!getEstaOrdenado())
            ordenar();
        
        if (!obj.getEstaOrdenado())
            obj.ordenar();
        
        for (int i=0; /* sin condición */; i++) {
            /* Si ambos Conjuntos tienen más elementos */
            if (cantidad() > i && obj.cantidad() > i) {
                T a = obtener(i);
                T b = obj.obtener(i);
                int cmp = a.compareTo(b);
                
                /* Si hay diferencias, basta para comparar */
                if (cmp != 0)
                    return cmp;
            }
            else if (cantidad() > i) /* Si este Conjunto tiene más elementos, será el mayor */
                return 1;
            else if (obj.cantidad() > i) /* Si este Conjunto tiene menos elementos, será el menor */
                return -1;
            else /* Si ninguno tiene más elementos, son iguales */
                return 0;
        }
    }
}
