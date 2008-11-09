/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

import analisis.Alfabeto;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Esta clase implementa los algoritmos para realizar
 * la conversión de un AFN a un AFD.
 * @see Automata
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class Subconjuntos {

    /**
     * 
     * @param afn
     * @return
     */
    public static Automata getAFD(Automata afn) {
        /*
         * TransD
         */
        Hashtable<Conjunto<Estado>, Hashtable<String, Conjunto<Estado>>> transD =
                    new Hashtable<Conjunto<Estado>, Hashtable<String, Conjunto<Estado>>>();
        
        /*
         * Conjunto de estados finales del AFD.
         */
        Conjunto<Conjunto<Estado>> estadosD = new Conjunto<Conjunto<Estado>>();
        
        /*
         * En esta cola se iran almacenando temporalmente los conjuntos de 
         * estados y la operación de marcarlos consistirá en quitarlos la misma
         * y guardarlos en estadosD.
         * La condición de que no haya estados marcados se dará cuando la cola
         * esté vacía.
         */
        Queue<Conjunto<Estado>> colaTemp = new LinkedList<Conjunto<Estado>>();
        
        /*
         * Debemos agregar la Cerradura Epsilon del estado inicial
         * del AFN a colaTmp.
         */
        afn.iniciarRecorrido();
        Conjunto<Estado> resultado = cerraduraEpsilon(afn.getEstadoInicial());
        colaTemp.add(resultado);
        
        /*
         * Iniciamos el ciclo principal del algoritmo
         */
        while (!colaTemp.isEmpty()) {
            // Marcar T
            Conjunto<Estado> T = colaTemp.remove();
            estadosD.agregar(T);
            
            for (String simbolo : afn.getAlfabeto()) {
                // Aplicar cerraduraEpsilon(mueve(T, simbolo))
                afn.iniciarRecorrido();
                Conjunto<Estado> M = mover(T, simbolo);
                afn.iniciarRecorrido();
                Conjunto<Estado> U = cerraduraEpsilon(M);
                
                // Agregar U a estadosD si no está y sin marcar
                if (!estadosD.contiene(U))
                    colaTemp.add(U);
                
                // Agregar a transD
                if (transD.containsKey(T))
                    transD.get(T).put(simbolo, U);
                else {
                    Hashtable<String, Conjunto<Estado>> hash = new Hashtable<String, Conjunto<Estado>>();
                    hash.put(simbolo, U);
                    transD.put(T, hash);
                }
            }
        }
        
        Automata afd = new Automata(afn.getAlfabeto(), afn.getExprReg());
        
        //TODO: construir el nuevo AFD.
        
        return afd;
    }
    
    /**
     * Implementa la operación Cerradura Epsilon sobre un <code>Estado</code>.
     * @param estado <code>Estado</code> sobre el cual aplicar la operación.
     * @return El <code>Conjunto</code> de estados alcanzados.
     */
    private static Conjunto<Estado> cerraduraEpsilon(Estado estado) {
        Conjunto<Estado> resultado = new Conjunto<Estado>();
        recorrido(estado, resultado, Alfabeto.VACIO);
        return resultado;
    }
    
    /**
     * Implementa la operación Cerradura Epsilon sobre un <code>Conjunto</code>
     * de <code>Estado</code>s.
     * @param estados <code>Conjunto</code> de <code>Estado</code>s sobre el 
     * cual aplicar operación.
     * @return El <code>Conjunto</code> de estados alcanzados.
     */
    private static Conjunto<Estado> cerraduraEpsilon(Conjunto<Estado> estados) {
        Conjunto<Estado> resultado = new Conjunto<Estado>();
        recorrido(estados, resultado, Alfabeto.VACIO);
        return resultado;
    }
    
    /**
     * Implementa la operación Mover.
     * @param estados <code>Estado</code>s sobre los cuales aplicar la operación.
     * @param simbolo Símbolo que debe seguirse en las <code>Transicion</code>s.
     * @return
     */
    private static Conjunto<Estado> mover(Conjunto<Estado> estados, String simbolo) {
        Conjunto<Estado> resultado = new Conjunto<Estado>();
        recorrido(estados, resultado, simbolo);
        return resultado;
    }
    
    /**
     * Realiza un recorrido del autómata a partir de un <code>Estado</code>
     * inicial y pasando por todas las <code>Transicion</code>s que coincidan
     * con determinado símbolo.
     * @param actual El <code>Estado</code> a partir del cual se realiza el recorrido.
     * @param alcanzados <code>Conjunto</code> donde se guardan los <code>Estado</code>s alcanzados.
     * @param simbolo Simbolo que debe seguirse en las <code>Transicion</code>s.
     */
    private static void recorrido(Estado actual, Conjunto<Estado> alcanzados, String simbolo) {
        /* 
         * El estado actual es agregado al conjunto
         * de alcanzados y luego se recorren sus
         * transiciones.
         */
        alcanzados.agregar(actual);
        
        /* Marcamos el estado actual como visitado */
        actual.setVisitado(true);
        
        /*
         * Debemos comenzar a recorrer las transiciones
         * a través del símbolo indicado como parámetro,
         * a partir del estado inicial y seguir, recursivamente,
         * con los estados alcanzados.
         */
        for (Transicion tmp : actual.getTransiciones())
            if (tmp.getSimbolo().equals(simbolo) && !tmp.getEstado().getVisitado())
                recorrido(tmp.getEstado(), alcanzados, simbolo);
    }
    
    /**
     * Realiza un recorrido del autómata a partir de un <code>Estado</code>
     * inicial y pasando por todas las <code>Transicion</code>s que coincidan
     * con determinado símbolo.
     * @param inicios El <code>Conjunto</code> <code>Estado</code>s a partir de los cuales
     * se realiza el recorrido.
     * @param alcanzados <code>Conjunto</code> donde se guardan los <code>Estado</code>s alcanzados.
     * @param simbolo Simbolo que debe seguirse en las <code>Transicion</code>s.
     */
    private static void recorrido(Conjunto<Estado> inicios, Conjunto<Estado> alcanzados, String simbolo) {
        for (Estado tmp : inicios)
            recorrido(tmp, alcanzados, simbolo);
    }
}
