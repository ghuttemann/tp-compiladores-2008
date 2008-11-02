/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

/**
 * Esta clase representa un estado para un Autómata Finito.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class Estado implements Comparable<Estado> {

    /**
     * Identificador de este Estado.
     */
    private int ident;
    
    /**
     * Conjunto de transiciones del estado.
     */
    private ConjuntoTransiciones transiciones;
    
    /**
     * Constructor por defecto. Construye un Estado sin identificador.
     */
    public Estado() {
        setIdentificador(-1);
    }
    
    /**
     * Construye un Estado con un identificador determinado.
     * @param id El identificador de este Estado.
     */
    public Estado(int id) {
        setIdentificador(id);
    }
    
    /**
     * Establece un nuevo identificador para este Estado.
     * @param id El nuevo identificador para este Estado.
     */
    public void setIdentificador(int id) {
        ident = id;
    }
    
    /**
     * Obtiene el identificador para este Estado.
     * @return El identificador del Estado.
     */
    public int getIdentificador() {
        return ident;
    }
    
    /**
     * Obtiene el conjunto de transiciones de este estado.
     * @return El conjunto de transiciones del estado.
     */
    public ConjuntoTransiciones getTransiciones() {
        return transiciones;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Estado other = (Estado) obj;
        if (this.ident != other.ident) {
            return false;
        }
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.ident;
        return hash;
    }

    public int compareTo(Estado obj) {
        return this.ident - obj.ident;
    }
}
