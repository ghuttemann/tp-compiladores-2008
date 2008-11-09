/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package old;

/**
 * Implementa la transición de un autómata, representada
 * por los estados origen y destino.
 *
 * @see Estado
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class Transicion {

    /**
     * El estado origen de esta transición.
     */
    private Estado origen;
    
    /**
     * Estado destino de esta transición.
     */
    private Estado destino;
    
    /**
     * Simbolo del alfabeto para esta transición.
     */
    private String simbolo;

    /**
     * Constructor de la clase que especifíca los tres
     * atributos de la misma.
     *
     * @param origen El estado origen para esta transición.
     * @param destino El estado destino para esta transición.
     * @param simbolo El símbolo para esta transición.
     */
    public Transicion(Estado origen, Estado destino, String simbolo) {
        this.origen  = origen;
        this.destino = destino;
        this.simbolo = simbolo;
    }

    /**
     * Contructor por defecto.
     */
    public Transicion() {
        this(null, null, null);
    }

    /**
     * Obtiene el estado origen de esta transición.
     * @return El estado origen de esta transición.
     */
    public Estado getOrigen() {
        return origen;
    }

    /**
     * Setea el estado origen de esta transición.
     * @param origen El nuevo estado origen de esta transición.
     */
    public void setOrigen(Estado origen) {
        this.origen = origen;
    }

    /**
     * Obtiene el estado destino de esta transición.
     * @return El estado destino de esta transición.
     */
    public Estado getDestino() {
        return destino;
    }

    /**
     * Setea el estado destino de esta transición.
     * @param destino El nuevo estado destino de esta transición.
     */
    public void setDestino(Estado destino) {
        this.destino = destino;
    }
    
    /**
     * Obtiene el simbolo para esta transición.
     * @return El simbolo para esta transición.
     */
    public String getSimbolo() {
        return simbolo;
    }
    
    /**
     * Setea el simbolo para esta transición.
     * @param simbolo El nuevo símbolo para esta transición.
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
