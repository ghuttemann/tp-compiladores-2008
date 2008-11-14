/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

import analisis.Alfabeto;

/**
 * Clase que representa la abstracción para un Autómata Finito,
 * No determinístico (AFN). Un AFN es contruído a partir de una 
 * expresión regular a través de las construcciones de Thompson.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class AFN extends Automata {
        
    /**
     * Constructor por defecto.
     */
    public AFN() {
       super();
    }
    
    /**
     * Construye un <code>AFN</code> con un determinado <code>Alfabeto</code>
     * y una determinada expresión regular.
     * @param alfabeto El <code>Alfabeto</code> de este <code>AFN</code>.
     * @param exprReg La expresión regular para este <code>AFN</code>.
     */
    public AFN(Alfabeto alfabeto, String exprReg) {
        super(alfabeto, exprReg);
    }
    
    /**
     * Retorna la tabla de transición de estados.
     * @return La tabla de transición de estados.
     */
    public TablaTransicion getTablaTransicion() {
        int cantFil = getEstados().cantidad();
        int cantCol = getAlfabeto().getTamaño() + 2;
        
        return cargarTablaTransiciones(cantFil, cantCol, 0);
    }
}
