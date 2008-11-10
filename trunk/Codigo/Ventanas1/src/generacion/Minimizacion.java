/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

/**
 * Esta clase implementa el algoritmo de minimización de 
 * estados de un AFD.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class Minimizacion {

    /**
     * 
     * @param afd
     * @return
     */
    public AFD getAFDminimo(AFD afd) {
        AFD afdMinimo = new AFD(afd.getAlfabeto(), afd.getExprReg());
        
        /* 
         * Copiamos el AFD a minimizar y realizamos
         * la minimización sobre el nuevo AFD.
         */
        Automata.copiarEstados(afd, afdMinimo, 0);
        
        
        
        return afdMinimo;
    }
}
