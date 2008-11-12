/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

import java.util.Stack;

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
        /* Conjunto de estados alcanzados desde el estado inicial */
        Conjunto<Estado> alcanzados = recuperarAlcanzados(afd);
        
        /* Eliminamos los estados no alcanzados */
        afd.getEstados().retener(alcanzados);
        
        /* Actualizamos los identificadores de los estados */
        // TODO
    }
    
    private static Conjunto<Estado> recuperarAlcanzados(AFD afd) {
        /* Estado inicial del recorrido */
        Estado actual = afd.getEstadoInicial();
        
        /* Conjunto de estados alcanzados */
        Conjunto<Estado> alcanzados = new Conjunto<Estado>();
        
        /* Agregamos el estad actual */
        alcanzados.agregar(actual);
        
        /* Pila para almacenar los estados pendientes */
        Stack<Estado> pila = new Stack();
        
        /* Meter el estado actual como el estado inicial */
        pila.push(actual);
        
        while (!pila.isEmpty()) {
            actual = pila.pop();
            
            for (Transicion t : actual.getTransiciones()) {
                Estado e = t.getEstado();
                
                if (!alcanzados.contiene(e)) {
                    alcanzados.agregar(e);
                    pila.push(e);
                }
            }
        }
        
        return alcanzados;
    }
    
    private static void eliminarIdentidades(AFD afd) {
        
    }
}
