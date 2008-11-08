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
     * Identificador del Estado destino de esta <code>Transicion</code>.
     */
    private Integer identificadorEstado;
    
    /**
     * Simbolo del alfabeto para esta <code>Transicion</code>.
     */
    private String simbolo;

    /**
     * Construye una <code>Transicion</code> especificando los dos
     * atributos de la misma.
     *
     * @param identificadorEstado El identificador del <code>Estado</code> 
     * destino para esta <code>Transicion</code>.
     * @param simbolo El símbolo para esta <code>Transicion</code>.
     */
    public Transicion(Integer identificadorEstado, String simbolo) {
        this.identificadorEstado = identificadorEstado;
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
     * Obtiene el identificador del <code>Estado</code> destino de esta <code>Transicion</code>.
     * @return El identificador del <code>Estado</code> destino de esta <code>Transicion</code>.
     */
    public Integer getIdentificadorEstado() {
        return identificadorEstado;
    }

    /**
     * Establece el <code>Estado</code> destino de esta <code>Transicion</code>.
     * @param identificadorEstado El nuevo <code>Estado</code> destino de esta <code>Transicion</code>.
     */
    public void setIdentificadorEstado(Integer identificadorEstado) {
        this.identificadorEstado = identificadorEstado;
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
