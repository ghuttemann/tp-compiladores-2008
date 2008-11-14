/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

import java.util.Hashtable;
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
        // TODO: Actualizar identificadores de los estados
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
        Stack<Estado> pila = new Stack<Estado>();
        
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
        /* Tablas Hash auxiliares */
        Hashtable<Estado, Conjunto<Integer>> tabla1;
        Hashtable<Conjunto<Integer>, Conjunto<Estado>> tabla2;
        
        /* Conjunto de las particiones del AFD */
        Conjunto<Conjunto<Estado>> particion = new Conjunto<Conjunto<Estado>>();
        
        /* 
         * Paso 1:
         * =======
         * Separar el AFD en dos grupos, los estados finales y
         * los estados no finales.
         */
        particion.agregar(afdMinimo.getEstadosNoFinales());
        particion.agregar(afdMinimo.getEstadosFinales());
        
        /*
         * Paso 2:
         * =======
         * Construcción de nuevas particiones
         */ 
        Conjunto<Conjunto<Estado>> nuevaParticion;
        
        while (true) {
            /* Conjunto de nuevas particiones en cada pasada */
            nuevaParticion = new Conjunto<Conjunto<Estado>>();
            
            for (Conjunto<Estado> grupo : particion) {
                /* 
                 * Los grupos unitarios son ignorados debido
                 * a que ya no pueden ser particionados.
                 */
                if (grupo.cantidad() <= 1) {
                    nuevaParticion.agregar(grupo);
                }
                else {
                    /*
                     * Paso 2.1:
                     * =========
                     * Hallamos los grupos alcanzados por
                     * cada estado del grupo actual.
                     */
                    tabla1 = new Hashtable<Estado, Conjunto<Integer>>();
                    for (Estado e : grupo)
                        tabla1.put(e, getGruposAlcanzados(e, particion));
                    
                    /*
                     * Paso 2.2:
                     * =========
                     * Calculamos las nuevas particiones
                     */
                    tabla2 = new Hashtable<Conjunto<Integer>, Conjunto<Estado>>();
                    for (Estado e : grupo) {
                        Conjunto<Integer> alcanzados = tabla1.get(e);
                        if (tabla2.containsKey(alcanzados))
                            tabla2.get(alcanzados).agregar(e);
                        else {
                            Conjunto<Estado> tmp = new Conjunto<Estado>();
                            tmp.agregar(e);
                            tabla2.put(alcanzados, tmp);
                        }
                    }
                    
                    /*
                     * Paso 2.3:
                     * =========
                     * Copiar las nuevas particiones al conjunto de
                     * nuevas particiones.
                     */
                    for (Conjunto<Estado> c : tabla2.values())
                        nuevaParticion.agregar(c);
                }
            }
            
            /* 
             * Paso 2.4:
             * =========
             * Si las particiones son iguales, significa que no
             * hubo cambios y debemos terminar. En caso contrario,
             * seguimos particionando.
             */
            if (nuevaParticion.equals(particion))
                break;
            else
                particion = nuevaParticion;
        }
        
        /* Ordenar la partición final */
        particion.ordenar();
        
        // TODO: Crear nuevo AFD
    }
    
    private static Conjunto<Integer> getGruposAlcanzados(Estado estado, Conjunto<Conjunto<Estado>> particion) {
        /* Grupos alcanzados por el estado */
        Conjunto<Integer> gruposAlcanzados = new Conjunto<Integer>();
        
        /* Obtener grupo alcanzado por cada transición */
        for (Transicion t : estado.getTransiciones()) {
            Estado destino = t.getEstado();
            
            /* Buscar grupo alcanzado */
            for (Conjunto<Estado> grupo : particion) {
                Integer idGrupo = particion.obtenerPosicion(grupo);
                if (grupo.contiene(destino) && !gruposAlcanzados.contiene(idGrupo)) {
                    gruposAlcanzados.agregar(idGrupo);
                    break;
                }
            }
        }
        
        return gruposAlcanzados;
    }
    
    private static void eliminarIdentidades(AFD afd) {
        // TODO: Implementar
    }
}
