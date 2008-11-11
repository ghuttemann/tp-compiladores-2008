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
    public static AFD getAFDminimo(AFD afd) {
        AFD afdMinimo = new AFD(afd.getAlfabeto(), afd.getExprReg());
        
        /* 
         * Copiamos el AFD a minimizar y realizamos
         * la minimización sobre el nuevo AFD.
         */
        Automata.copiarEstados(afd, afdMinimo, 0);
        
        /* Además, debemos copiar los estados finales */
        for (int i=0; i < afd.cantidadEstados(); i++) {
            Estado tmp = afd.getEstado(i);
            afdMinimo.getEstado(i).setEsFinal(tmp.getEsFinal());
        }
        
        /* Eliminamos los estados inalcanzables */
        eliminarInalcanzables(afdMinimo);
        
        /* TODO: Proceso de minimización */
        
        /* Eliminamos estados identidad */
        eliminarIdentidades(afdMinimo);
        
        return afdMinimo;
    }
    
    private static void eliminarInalcanzables(AFD afd) {
        
    }
    
    private static void eliminarIdentidades(AFD afd) {
        
    }
}
