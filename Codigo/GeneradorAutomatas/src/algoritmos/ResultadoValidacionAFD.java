/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package algoritmos;

import estructuras.*;

/**
 * Esta clase representa los datos obtenidos
 * como resultado de un proceso de validación
 * de una cadena de entrada contra un <code>AFD</code>.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class ResultadoValidacionAFD extends ResultadoValidacion {
    
    /**
     * Camino producido
     */
    private Conjunto<Par<Estado, String>> camino;
    
    /**
     * Construye el resultado de una validación de
     * una cadena de entrada contra un <code>Automata</code>.
     * @param automata El <code>AFD</code> relacionado a la validación.
     * @param entrada La cadena de entrada relacionada a la validación.
     * @param camino El camino resultante de la validación.
     * @param entradaFaltante Simbolos de entrada que no pudieron ser consumidos.
     */
    public ResultadoValidacionAFD(AFD automata, String entrada, 
        Conjunto<Par<Estado, String>> camino, String entradaFaltante) {
        
        this.automata = automata;
        this.entrada = entrada;
        this.camino = camino;
        this.entradaFaltante = (entradaFaltante == null) ? "" : entradaFaltante;
    }
    
    /**
     * El camino de <code>Estado</code>s que
     * resulta de validar la cadena de entrada.
     * @return Un <code>Conjunto</code> de <code>Estado</code>s
     * alcanzados durante la validación.
     */
    public Conjunto<Par<Estado, String>> getCamino() {
        return camino;
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
        
        if (camino.obtenerUltimo().getPrimero().getEsFinal())
            return true;
        else
            return false;
    }
}
