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
 * de una cadena de entrada contra un <code>Automata</code>.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public abstract class ResultadoValidacion {
    
    /**
     * Autómata asociado a este resultado
     * de validación.
     */
    protected Automata automata;
    
    /**
     * Cadena de entrada asociada a este
     * resultado de validación.
     */
    protected String entrada;
    
    /**
     * Simbolos de entrada que no pudieron
     * ser consumidos.
     */
    protected String entradaFaltante;

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
     * El camino de <code>Estado</code>s o <code>Conjunto</code> 
     * de <code>Estado</code>s que resulta de validar la cadena 
     * de entrada.
     * @return Un <code>Conjunto</code> de <code>Estado</code>s
     * o de <code>Conjunto</code> de <code>Estado</code>s 
     * alcanzados durante la validación.
     */
    public abstract Conjunto getCamino();

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
    public abstract boolean esValido();
}
