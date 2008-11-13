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
     * Obtiene un <code>AFD</code> mínimo a partir de un 
     * <code>AFD</code> determinado.
     * @param afd El <code>AFD</code> a minimizar.
     * @return Un <code>AFD</code> equivalente a <code>afd</code> 
     * pero con la menor cantidad de estados posibles.
     */
    public static AFD getAFDminimo(AFD afd) {
        /* AFD Mínimo */
        AFD afdMinimo = new AFD(afd.getAlfabeto(), afd.getExprReg());
        
        /* 
         * Copiamos el AFD a minimizar y realizamos
         * la minimización sobre el nuevo AFD. Además,
         * debemos copiar los estados finales.
         */
        Automata.copiarEstados(afd, afdMinimo, 0);
        for (int i=0; i < afd.cantidadEstados(); i++) {
            Estado tmp = afd.getEstado(i);
            afdMinimo.getEstado(i).setEsFinal(tmp.getEsFinal());
        }
        
        /* Eliminamos los estados inalcanzables */
        eliminarInalcanzables(afdMinimo);
        
        /* Proceso de minimización */
        minimizar(afdMinimo);
        
        /* Eliminamos estados identidad */
        eliminarIdentidades(afdMinimo);
        
        return afdMinimo;
    }
    
    /**
     * Elimina los estados inalcanzables de un AFD.
     * @param afd El AFD sobre el cual se eliminan estados inalcanzables.
     */
    private static void eliminarInalcanzables(AFD afd) {
        /* Conjunto de estados alcanzados desde el estado inicial */
        Conjunto<Estado> alcanzados = recuperarAlcanzados(afd);
        
        /* Eliminamos los estados no alcanzados */
        afd.getEstados().retener(alcanzados);
        
        /* Actualizamos los identificadores de los estados */
        // TODO
    }
    
    /**
     * A partir del estado inicial de un AFD recupera los
     * estados alcanzados, realizando un recorrido DFS
     * no recursivo (utiliza una pila).
     * @param afd El AFD cuyos estados alcanzados deben ser
     * recuperados.
     * @return El conjunto de estados recuperados.
     */
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
    
    private static void minimizar(AFD afdMinimo) {
        /* Conjunto de las particiones del AFD */
        Conjunto<Conjunto<Estado>> particion = new Conjunto<Conjunto<Estado>>();
        
        /* 
         * Paso 1:
         * =======
         * Separar el AFD en dos grupos, los estados finales y
         * los estados no finales.
         */
        particion.agregar(afdMinimo.getEstadosFinales());
        particion.agregar(afdMinimo.getEstadosNoFinales());
        
        /*
         * Paso 2:
         * =======
         * Construcción de nuevas particiones
         */
        Conjunto<Conjunto<Estado>> nuevaParticion = new Conjunto<Conjunto<Estado>>();
        
        do {
            for (Conjunto<Estado> grupo : particion) {
                /* 
                 * Los grupos unitarios son ignorados debido
                 * a que ya no pueden ser particionados.
                 */
                if (grupo.cantidad() > 1) {
                    // TODO
                }
            }
        } while (!nuevaParticion.estaVacio());
    }
    
    private static void eliminarIdentidades(AFD afd) {
        // TODO
    }
}
