/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

import analisis.Alfabeto;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        Estado estadoOrigen, estadoDestino;
        
        /* AFD resultante */
        Automata afd = new Automata(afn.getAlfabeto(), afn.getExprReg());
        
        /* Conjunto de estados finales del AFD */
        Conjunto<Conjunto<Estado>> estadosD = new Conjunto<Conjunto<Estado>>();
        
        /*
         * En esta cola se iran almacenando temporalmente los conjuntos de 
         * estados y la operación de marcarlos consistirá en quitarlos la misma
         * y guardarlos en estadosD.
         * La condición de que no haya estados marcados se dará cuando la cola
         * esté vacía.
         */
        Queue<Conjunto<Estado>> colaTemp = new LinkedList<Conjunto<Estado>>();
        
        /* Contador de estados procesados del AFD */
        int estadosProcesados = 0;
        
        /* Calculamos la Cerradura Epsilon del estado inicial */
        Conjunto<Estado> resultado = cerraduraEpsilon(afn.getEstadoInicial());
        
         /* 
          * Agregamos la Cerradura Epsilon del estado 
          * inicial del AFN a estadosD sin marcar
          */
        estadosD.agregar(resultado);
        colaTemp.add(resultado);
        
        /*
         * Iniciamos el ciclo principal del algoritmo
         */
        while (!colaTemp.isEmpty()) {
            /* Marcar T */
            Conjunto<Estado> T = colaTemp.remove();
            
            /* Agregamos el correspondiente estado al AFD */
            if (afd.cantidadEstados() < estadosD.cantidad())
                afd.agregarEstado(new Estado(afd.cantidadEstados()));
            
            /* Estado del AFD a procesar */
            estadoOrigen = afd.getEstado(estadosProcesados++);
            
            /* Buscar transiciones por cada simbolo */
            for (String simbolo : afn.getAlfabeto()) {
                /* Aplicar cerraduraEpsilon(mueve(T, simbolo)) */
                Conjunto<Estado> M = mueve(T, simbolo);
                Conjunto<Estado> U = cerraduraEpsilon(M);
                
                if (estadosD.contiene(U)) {
                    int posicion  = estadosD.obtenerPosicion(U);
                    estadoDestino = afd.getEstado(posicion);
                }
                else if (!U.estaVacio()) {
                    estadoDestino = new Estado(afd.cantidadEstados());
                    afd.agregarEstado(estadoDestino);
                    
                    /* Agregar U a estadosD (sin marcar) si no está aún */
                    estadosD.agregar(U);
                    colaTemp.add(U);
                }
                else {
                    /*
                     * Encontramos un conjunto vacío, por tanto,
                     * no debemos agregar ninguna transición y
                     * debemos saltar directamente a evaluar el
                     * siguiente simbolo del alfabeto.
                     */
                    continue;
                }
                
                // Agregamos la transición al AFD
                Transicion trans = new Transicion(estadoDestino, simbolo);
                estadoOrigen.getTransiciones().agregar(trans);
            }
        }
        
        /* Establecemos los estados finales del AFD */
        for (int i=0; i < estadosD.cantidad(); i++) {
            Estado estadoAFD = afd.getEstado(i);
            
            for (Estado e : estadosD.obtener(i)) {
                if (e.getEsFinal()) {
                    estadoAFD.setEsFinal(true);
                    break;
                }
            }
        }
        
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
     * Implementa la operación Mueve.
     * @param estados <code>Estado</code>s sobre los cuales aplicar la operación.
     * @param simbolo Símbolo que debe seguirse en las <code>Transicion</code>s.
     * @return
     */
    private static Conjunto<Estado> mueve(Conjunto<Estado> estados, String simbolo) {
        Conjunto<Estado> resultado = new Conjunto<Estado>();
        recorrido(estados, resultado, simbolo);
        return resultado;
    }
    
    /**
     * Realiza un recorrido del autómata a partir de un <code>Estado</code>
     * inicial y pasando por todas las <code>Transicion</code>s que coincidan
     * con determinado símbolo.<br>
     * Este algoritmo corresponde al una generalización del algoritmo de la
     * Figura 3.33 del libro Compiladores de Aho (2da. edicion), de manera a
     * que el mismo pueda utilizarse para las dos operaciones de Cerradura
     * Epsilon y también para la operación Mueve.
     * @param actual El <code>Estado</code> a partir del cual se realiza el recorrido.
     * @param alcanzados <code>Conjunto</code> donde se guardan los <code>Estado</code>s alcanzados.
     * @param simboloBuscado Simbolo que debe seguirse en las <code>Transicion</code>s.
     */
    private static void recorrido(Estado actual, Conjunto<Estado> alcanzados, String simboloBuscado) {
        /* Pila para almacenar los estados pendientes */
        Stack<Estado> pila = new Stack();
        
        /*
         * Cuando el símbolo buscado es igual al símbolo
         * vacío, el estado desde donde se empieza el 
         * recorrido debe incluirse entre los estados
         * alcanzados.
         */
        if (simboloBuscado.equals(Alfabeto.VACIO))
            alcanzados.agregar(actual);
        
        /* Meter el estado actual como el estado inicial */
        pila.push(actual);
        
        while (!pila.isEmpty()) {
            actual = pila.pop();
            for (Transicion t : actual.getTransiciones()) {
                Estado e = t.getEstado();
                String s = t.getSimbolo();
                
                if (s.equals(simboloBuscado) && !alcanzados.contiene(e)) {
                    alcanzados.agregar(e);
                    
                    /*
                     * Debido a que sólo cuando el símbolo buscado
                     * es igual a vacío se debe recorrer recursivamente
                     * los estados alcanzados, agregamos dichos estados
                     * a la pila solo si se da esa condición.
                     */
                    if (simboloBuscado.equals(Alfabeto.VACIO))
                        pila.push(e);
                }
            }
        }
    }
    
    /**
     * Realiza un recorrido del autómata a partir de un <code>Estado</code>
     * inicial y pasando por todas las <code>Transicion</code>s que coincidan
     * con determinado símbolo.
     * @param inicios El <code>Conjunto</code> <code>Estado</code>s a partir de los cuales
     * se realiza el recorrido.
     * @param alcanzados <code>Conjunto</code> donde se guardan los <code>Estado</code>s alcanzados.
     * @param simboloBuscado Simbolo que debe seguirse en las <code>Transicion</code>s.
     */
    private static void recorrido(Conjunto<Estado> inicios, Conjunto<Estado> alcanzados, String simboloBuscado) {
        for (Estado e : inicios)
            recorrido(e, alcanzados, simboloBuscado);
    }
}
