/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

import java.util.Vector;

/**
 * Esta clase representa un conjunto de transiciones para un estado
 * de un autómata finito.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class ConjuntoTransiciones {
    
    /**
     * Conjunto de transiciones.
     */
    private Vector<Transicion> transiciones;
    
    /**
     * Constructor de la clase.
     */
    public ConjuntoTransiciones() {
        transiciones = new Vector<Transicion>();
    }
    
    /**
     * Agrega una nueva transición al conjunto de transiciones.
     * @param transicion La transición a ser agregada.
     */
    public void agregarTransicion(Transicion transicion) {
        transiciones.add(transicion);
    }
    
    /**
     * Elimina una transición del conjunto de transiciones.
     * @param transicion La transición a ser eliminada.
     */
    public void eliminarTransicion(Transicion transicion) {
        transiciones.remove(transicion);
    }
    
    /**
     * Retorna i-esima transición del conjunto.
     * @param i La transición a retornar.
     * @return La transición buscada.
     */
    public Transicion obtenerTransicion(int i) {
        return transiciones.get(i);
    }
    
    /**
     * Retorna la cantidad de transiciones del conjunto.
     * @return Cantidad de transiciones del conjunto.
     */
    public int cantidad() {
        return transiciones.size();
    }
}
