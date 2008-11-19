/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package estructuras;

/**
 * Clase que representa la abstracción para un Autómata Finito
 * Determinístico con estados mínimos (AFDMin), en cuanto a 
 * cantidad de estados se refiere.<br><br>
 * Un AFDMin es generado a partir de un AFD a través del algoritmo 
 * de Minimización de Estados.<br><br>
 * Antes del dicho algoritmo, deben eliminarse los estados inalcanzables 
 * realizando un recorrido DFS o BFS a partir del estado inicial 
 * del AFD. Luego de dicho algoritmo deben eliminarse aquellos estados 
 * identidades que no sean estados finales.<br><br>
 * El AFDMin contiene tres instancias de AFD que representan a los
 * AFDs tras cada uno de estos algoritmos.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class AFDMin {
    /**
     * AFD original.
     */
    private AFD afdOriginal;
    
    /**
     * AFD resultante luego de aplicar la
     * eliminación de estados inalcanzables.
     */
    private AFD afdPostInalcanzables;
    
    /**
     * AFD resultante luego de aplicar el
     * algoritmo de minimización.
     */
    private AFD afdPostMinimizacion;
    
    /**
     * AFD resultante luego de aplicar la
     * eliminación de estados identidades
     * no finales.
     */
    private AFD afdPostIdentidades;
    
    /**
     * Construye un <code>AFDMin</code>.
     * @param afdOriginal El <code>AFD</code> a partir del cual fue construido este <code>AFDMin</code>.
     * @param afdPostInalcanzables El <code>AFD</code> resultante de la eliminación de estados inalcanzables.
     * @param afdPostMinimizacion El <code>AFD</code> resultante del proceso de minimización.
     * @param afdPostIdentidades El <code>AFD</code> resultante de la eliminación de estados identidades.
     */
    public AFDMin(AFD afdOriginal, AFD afdPostInalcanzables, AFD afdPostMinimizacion, AFD afdPostIdentidades) {
        this.afdOriginal          = afdOriginal;
        this.afdPostInalcanzables = afdPostInalcanzables;
        this.afdPostMinimizacion  = afdPostMinimizacion;
        this.afdPostIdentidades   = afdPostIdentidades;
    }
    
    /**
     * Obtiene el <code>AFD</code> a partir del cual fue construido este <code>AFDMin</code>.
     * @return El <code>AFD</code> a partir del cual fue construido este <code>AFDMin</code>.
     */
    public AFD getAfdOriginal() {
        return afdOriginal;
    }

    /**
     * Obtiene el <code>AFD</code> resultante de la eliminación de estados inalcanzables.
     * @return El <code>AFD</code> resultante de la eliminación de estados inalcanzables.
     */
    public AFD getAfdPostInalcanzables() {
        return afdPostInalcanzables;
    }

    /**
     * Obtiene el <code>AFD</code> resultante del proceso de minimización.
     * @return El <code>AFD</code> resultante del proceso de minimización.
     */
    public AFD getAfdPostMinimizacion() {
        return afdPostMinimizacion;
    }

    /**
     * Obtiene el <code>AFD</code> resultante de la eliminación de estados identidades.
     * @return El <code>AFD</code> resultante de la eliminación de estados identidades.
     */
    public AFD getAfdPostIdentidades() {
        return afdPostIdentidades;
    }
    
    /**
     * Verifica si la eliminación de estados inalcanzables produjo algún
     * cambio sobre el <code>AFD</code> original.
     * @return <code>true</code> si la eliminación de estados inalcanzables
     * produjo algún cambio sobre el <code>AFD</code> original, <code>false</code>
     * en caso contrario.
     */
    public boolean inalcanzablesEliminados() {
        if (afdOriginal.toString().equals(afdPostInalcanzables.toString()))
            return false;
        else
            return true;
    }
    
    /**
     * Verifica si la eliminación de estados identidades produjo algún
     * cambio sobre el <code>AFD</code> resultante de la minimización.
     * @return <code>true</code> si la eliminación de estados identidades
     * produjo algún cambio sobre el <code>AFD</code> resultante de la 
     * minimización, <code>false</code> en caso contrario.
     */
    public boolean identidadesEliminados() {
        if (afdPostMinimizacion.toString().equals(afdPostIdentidades.toString()))
            return false;
        else
            return true;
    }
}
