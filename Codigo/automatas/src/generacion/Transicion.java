/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

/**
 * Implementa la transición de un autómata, representada
 * por el símbolo y el estado destino. El estado inicial
 * está dado por el estado en el que está contenida esta
 * transición.
 *
 * @see Estado
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class Transicion {
    
    /**
     * <code>Estado</code> destino de esta <code>Transicion</code>.
     */
    private Estado estado;
    
    /**
     * Simbolo del alfabeto para esta <code>Transicion</code>.
     */
    private String simbolo;

    /**
     * Construye una <code>Transicion</code> especificando los dos
     * atributos de la misma.
     *
     * @param estado El <code>Estado</code> destino para esta <code>Transicion</code>.
     * @param simbolo El símbolo para esta <code>Transicion</code>.
     */
    public Transicion(Estado estado, String simbolo) {
        this.estado  = estado;
        this.simbolo = simbolo;
    }

    /**
     * Contruye una <code>Transicion</code> sin <code>Estado</code>
     * ni simbolo.
     */
    public Transicion() {
        this(null, null);
    }

    /**
     * Obtiene el <code>Estado</code> destino de esta <code>Transicion</code>.
     * @return El <code>Estado</code> destino de esta <code>Transicion</code>.
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Establece el <code>Estado</code> destino de esta <code>Transicion</code>.
     * @param estado El nuevo <code>Estado</code> destino de esta <code>Transicion</code>.
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    /**
     * Obtiene el simbolo para esta <code>Transicion</code>.
     * @return El simbolo para esta <code>Transicion</code>.
     */
    public String getSimbolo() {
        return simbolo;
    }
    
    /**
     * Establece el simbolo para esta <code>Transicion</code>.
     * @param simbolo El nuevo símbolo para esta <code>Transicion</code>.
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
