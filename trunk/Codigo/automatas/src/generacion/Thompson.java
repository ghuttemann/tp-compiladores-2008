/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

import analisis.Alfabeto;

/**
 * Esta clase implementa los algoritmos de Thompson para cada
 * uno de los operadores de una expresión regular.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class Thompson {

    /**
     * Construye un AFN a partir de un símbolo, que puede ser
     * un símbolo del alfabeto o el símbolo vacío.
     * @param simbolo El símbolo a partir del cual construir el AFN.
     * @return El AFN para <code>simbolo</code>.
     */
    public static AFN basico(String simbolo) {
        AFN afn = new AFN();
        
        // Estados inicial y final
        Estado ini = new Estado(0);
        Estado fin = new Estado(1);
        
        // Transición entre los estados inicial y final
        Transicion tran = new Transicion(ini, fin, simbolo);
        ini.getTransiciones().agregar(tran);
        
        // Agregamos los estados al AFN
        afn.agregarEstado(ini);
        afn.agregarEstado(fin);
        
        // Seteamos los estados inicial y final
        afn.setEstadoInicial(ini);
        afn.setEstadoFinal(fin);
        
        return afn;
    }
    
    /**
     * Aplica la cerradura de Kleene (*) a un AFN dado.
     * @param afn El AFN sobre el cual aplicar la cerradura de Kleene.
     * @return El AFN resultante de aplicar cerradura de Kleene a <code>afn</code>.
     */
    public static AFN cerraduraKleene(AFN afn) {
        AFN afn_salida = new AFN();
                
        // Agregamos el estado inicial
        Estado nuevoInicio = new Estado(0);
        afn_salida.agregarEstado(nuevoInicio);
        afn_salida.setEstadoInicial(nuevoInicio);
        
        // Agregamos los demás estados
        for (int i=0; i < afn.getEstados().cantidad(); i++) {
            Estado tmp = afn.getEstados().obtener(i);
            tmp.setIdentificador(i + 1);
            afn_salida.agregarEstado(tmp);
        }
        
        // Agregamos el estado final
        Estado nuevoFin = new Estado(afn.getEstados().cantidad() + 1);
        afn_salida.agregarEstado(nuevoFin);
        afn_salida.setEstadoFinal(nuevoFin);
        
        // Estados inicial y final anteriores
        Estado anteriorInicio = afn.getEstadoInicial();
        Estado anteriorFin    = afn.getEstadoFinal();
        
        // Agregamos transiciones adicionales desde el nuevo estado inicial
        nuevoInicio.getTransiciones().agregar(new Transicion(nuevoInicio, anteriorInicio, Alfabeto.VACIO));
        nuevoInicio.getTransiciones().agregar(new Transicion(nuevoInicio, nuevoFin, Alfabeto.VACIO));
        
        // Agregamos transiciones adicionales desde el anterior estado final
        anteriorFin.getTransiciones().agregar(new Transicion(anteriorFin, anteriorInicio, Alfabeto.VACIO));
        anteriorFin.getTransiciones().agregar(new Transicion(anteriorFin, nuevoFin, Alfabeto.VACIO));
        
        return afn_salida;
    }
    
    /**
     * Aplica la cerradura positiva (+) a un AFN dado.
     * @param afn El AFN sobre el cual aplicar la cerradura positiva.
     * @return El AFN resultante de aplicar cerradura positiva a <code>afn</code>.
     */
    public static AFN cerraduraPositiva(AFN afn) {
        return concatenacion(afn, cerraduraKleene(afn));
    }
    
    /**
     * Aplica el operador de opción (?) a un AFN dado.
     * @param afn El AFN sobre el cual aplicar el operador de opción.
     * @return El AFN resultante de aplicar el operador de opción a <code>afn</code>.
     */
    public static AFN opcion(AFN afn) {
        return union(afn, basico(Alfabeto.VACIO));
    }
    
    public static AFN union(AFN afn1, AFN afn2) {
        return null;
    }
    
    public static AFN concatenacion(AFN afn1, AFN afn2) {
        AFN afn_salida = new AFN();
        
        // Agregar los estados de afn1.
        for (int i=0; i < afn1.getEstados().cantidad(); i++) {
            Estado tmp = afn1.getEstados().obtener(i);
            afn_salida.agregarEstado(tmp);
        }
        
        // Setear estados inicial y final.
        afn_salida.setEstadoInicial(afn1.getEstadoInicial());
        afn_salida.setEstadoFinal(afn1.getEstadoFinal());       
        
        return afn_salida;
    }
}
