/**
 * Esta clase implementa los algoritmos de validación
 * para AFNs y AFDs.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
package generacion;

/**
 * Esta clase representa los datos obtenidos
 * como resultado de un proceso de validación
 * de una cadena de entrada contra un AF.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class ResultadoValidacion {
    
    /**
     * Autómata asociado a este resultado
     * de validación.
     */
    private Automata automata;
    
    /**
     * Cadena de entrada asociada a este
     * resultado de validación.
     */
    private String entrada;
    
    /**
     * Camino producido
     */
    private Conjunto<Estado> camino;
    
    /**
     * Simbolos de entrada que no pudieron
     * ser consumidos.
     */
    private String entradaFaltante;
    
    /**
     * Construye el resultado de una validación de
     * una cadena de entrada contra un <code>Automata</code>.
     * @param automata 
     * @param entrada 
     * @param camino El camino resultante de la validación.
     * @param entradaFaltante Simbolos de entrada que no pudieron ser consumidos.
     */
    public ResultadoValidacion(Automata automata, String entrada, 
        Conjunto<Estado> camino, String entradaFaltante) {
        
        this.automata = automata;
        this.entrada = entrada;
        this.camino = camino;
        this.entradaFaltante = (entradaFaltante == null) ? "" : entradaFaltante;
    }

    /**
     * Obtiene el <code>Automata</code> asociado
     * a este resultado de validación.
     * @return El <code>Automata</code> asociado
     * a este resultado de validación.
     */
    public Automata getAutomata() {
        return automata;
    }

    /**
     * Obtiene la cadena de entrada asociada
     * a este resultado de validación.
     * @return La cadena de entrada asociada
     * a este resultado de validación.
     */
    public String getEntrada() {
        return entrada;
    }

    /**
     * El camino de <code>Estado</code>s que
     * resulta de validar la cadena de entrada.
     * @return Un <code>Conjunto</code> de <code>Estado</code>s
     * alcanzados durante la validación.
     */
    public Conjunto<Estado> getCamino() {
        return camino;
    }

    /**
     * Obtiene los simbolos de entrada que no
     * pudieron ser consumidos.
     * @return Un <code>String</code> que contiene
     * los símbolos de entrada que no pudieron ser
     * consumidos, o la cadena vacía si todos los
     * símbolos fueron consumidos.
     */
    public String getEntradaFaltante() {
        return entradaFaltante;
    }
    
    /**
     * Determina si el resultado de la validación
     * es válido o no. Es decir, si la cadena de
     * entrada es aceptada o no por el <code>Automata</code>.
     * @return <code>true</code> si la cadena de entrada
     * es aceptada por el <code>Automata</code>, <code>false</code>
     * en caso contrario.
     */
    public boolean esValido() {
        if (!entradaFaltante.equals(""))
            return false;
        
        if (camino.obtenerUltimo().getEsFinal())
            return true;
        else
            return false;
    }
}
