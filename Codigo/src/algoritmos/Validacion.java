/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package algoritmos;

import estructuras.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Esta clase implementa los algoritmos de validación
 * para AFNs y AFDs.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class Validacion {

    /**
     * Realiza la validación de una cadena de entrada contra
     * un AFD dado.
     * @param afn <code>AFN</code> contra el cual validar la
     * cadena de entrada.
     * @param entrada Cadena de entrada a validar.
     * @return Un objeto <code>ResultadoValidacion</code> con
     * los resultados de la validación.
     */
    public static ResultadoValidacion validarAFN(AFN afn, String entrada) {
        return null;
    }

    /**
     * Realiza la validación de una cadena de entrada contra
     * un AFD dado.
     * @param afd <code>AFD</code> contra el cual validar la
     * cadena de entrada.
     * @param entrada Cadena de entrada a validar.
     * @return Un objeto <code>ResultadoValidacion</code> con
     * los resultados de la validación.
     */
    public static ResultadoValidacion validarAFD(AFD afd, String entrada) {
        /* Buffer para manipular la entrada */
        Queue<String> buffer = new LinkedList<String>();
        
        /*
         * Agregamos los caracteres de la entrada en
         * forma FIFO. Cuando se consuman todos los
         * caracteres, el siguiente será null, que
         * representará al caracter EOF.
         */
        for (int i=0; i < entrada.length(); i++)
            buffer.add("" + entrada.charAt(i));
        
        /* Secuencia de estados recorridos */
        Conjunto<Estado> camino = new Conjunto<Estado>();
        
        /* Comenzamos por el estado inicial del AFD */
        Estado estadoActual = afd.getEstadoInicial();
        camino.agregar(estadoActual);
        
        /* Cada simbolo de entrada */
        String simbolo;
        
        /* Recorremos mientras hayan simbolos en la entrada */
        while ((simbolo = buffer.poll()) != null) {
            /* Nos movemos al siguiente estado */
            estadoActual = mover(estadoActual, simbolo);
            
            if (estadoActual == null) {
                /* Si no se alcanza ningún estado, terminamos */
                break;
            }
            else {
                /* Agregar el estado nuevo al camino */
                camino.agregar(estadoActual);
            }
        }
        
        /*
         * Debemos comprobar cuál fue la condición que
         * provocó la finalización del ciclo while y 
         * reaccionar de acuerdo a ello.
         */
        if (estadoActual == null) {
            /*
             * Llegamos a un estado desde el cual
             * no se pudo avanzar con el símbolo
             * actual.
             * Recuperamos todos los simbolos no
             * consumidos.
             */
            String entradaFaltante = simbolo;
            for (String s : buffer)
                entradaFaltante += s;
            
            /*
             * Retornamos el camino construidos y la
             * subcadena que faltó consumir de la
             * entrada.
             */
            return new ResultadoValidacion(afd, entrada, camino, entradaFaltante);
        }
        else {
            /* 
             * Hemos consumido toda la entrada, por lo
             * que retornamos el camino construido y
             * la cadena vacía como entrada faltante.
             */
            return new ResultadoValidacion(afd, entrada, camino, "");
        }
    }

    /**
     * Dado un Estado, recupera el Estado destino de una
     * transición por un simbolo dado.
     * @param origen El Estado origen.
     * @param simbolo Símbolo por el cual buscar una transición.
     * @return El Estado alcanzado por una transición por el 
     * simbolo dado o null en caso de no existir transición
     * para dicho simbolo.
     */
    private static Estado mover(Estado origen, String simbolo) {
        for (Transicion t : origen.getTransiciones())
            if (t.getSimbolo().equals(simbolo))
                return t.getEstado();
        
        return null;
    }
}
