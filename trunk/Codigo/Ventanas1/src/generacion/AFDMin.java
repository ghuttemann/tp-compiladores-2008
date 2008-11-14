/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

import analisis.Alfabeto;

/**
 * Clase que representa la abstracción para un Autómata Finito
 * Determinístico con estados mínimos (AFDMin), en cuanto a 
 * cantidad de estados se refiere.<br><br>
 * Un AFDMin es generado a partir de un AFD a través del algoritmo 
 * de Minimización de Estados. Antes del dicho algoritmo, deben 
 * eliminarse los estados inalcanzables realizando un recorrido 
 * DFS o BFS a partir del estado inicial del AFD. Luego de dicho
 * algoritmo deben eliminarse aquellos estados identidades que
 * no sean estados finales.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class AFDMin extends Automata {
    
    /**
     * AFD resultante luego de aplicar la
     * eliminación de estados inalcanzables.
     */
    private AFD afdPostEstadosInalcanzables;
    
    /**
     * AFD resultante luego de aplicar el
     * algoritmo de minimización.
     */
    private AFD afdPostMinimizacion;
    
    /**
     * Constructor por defecto.
     */
    public AFDMin() {
       this(null, "");
    }
    
    /**
     * Construye un <code>AFDMin</code> con un determinado <code>Alfabeto</code>
     * y una determinada expresión regular.
     * @param alfabeto El <code>Alfabeto</code> de este <code>AFDMin</code>.
     * @param exprReg La expresión regular para este <code>AFDMin</code>.
     */
    public AFDMin(Alfabeto alfabeto, String exprReg) {
        super(alfabeto, exprReg);
    }
    
    /**
     * Retorna la tabla de transición de estados.
     * @return La tabla de transición de estados.
     */
    public TablaTransicion getTablaTransicion() {
        int cantFil = getEstados().cantidad();
        int cantCol = getAlfabeto().getTamaño() + 1;
        
        return cargarTablaTransiciones(cantFil, cantCol, 0);
    }
}
