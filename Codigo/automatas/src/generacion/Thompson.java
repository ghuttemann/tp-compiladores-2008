/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

import analisis.Alfabeto;

/**
 * Esta clase implementa los algoritmos de Thompson para cada
 * uno de los operadores de una expresión regular.<br><br>
 * Cabe destacar que las operaciones implementadas en esta
 * clase tiene de efectos secundarios (side-effects) sobre 
 * los AFN recibidos como argumentos ya que en ciertos casos
 * estos resultan alterados. Sin embargo, a efectos prácticos
 * esto no es un problema, ya que en la traducción de una 
 * expresión regular a AFN siempre será significativo solo el
 * último AFN construído.<br><br>
 * La solución que podría aplicarse para corregir este efecto
 * es implementar una función de copia para los AFN.
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
        
        /* Estados inicial y final */
        Estado ini = new Estado(0);
        Estado fin = new Estado(1);
        
        /* Transición entre los estados inicial y final */
        Transicion tran = new Transicion(ini, fin, simbolo);
        ini.getTransiciones().agregar(tran);
        
        /* Agregamos los estados al AFN */
        afn.agregarEstado(ini);
        afn.agregarEstado(fin);
        
        /* Seteamos los estados inicial y final */
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
        int contadorEstados = 0;
                
        /* Agregamos el estado inicial */
        Estado nuevoInicio = new Estado(contadorEstados++);
        afn_salida.agregarEstado(nuevoInicio);
        afn_salida.setEstadoInicial(nuevoInicio);
        
        /* Agregamos los demás estados */
        for (Estado tmp : afn.getEstados()) {
            tmp.setIdentificador(contadorEstados++);
            afn_salida.agregarEstado(tmp);
        }
        
        /* Agregamos el estado final */
        Estado nuevoFin = new Estado(contadorEstados);
        afn_salida.agregarEstado(nuevoFin);
        afn_salida.setEstadoFinal(nuevoFin);
        
        /* Estados inicial y final anteriores */
        Estado anteriorInicio = afn.getEstadoInicial();
        Estado anteriorFin    = afn.getEstadoFinal();
        
        /* Agregamos transiciones adicionales desde el nuevo estado inicial */
        nuevoInicio.getTransiciones().agregar(new Transicion(nuevoInicio, anteriorInicio, Alfabeto.VACIO));
        nuevoInicio.getTransiciones().agregar(new Transicion(nuevoInicio, nuevoFin, Alfabeto.VACIO));
        
        /* Agregamos transiciones adicionales desde el anterior estado final */
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
        int contadorEstados = afn1.getEstadoFinal().getIdentificador() + 1;
        
        /* Agregar los estados de afn1 */
        for (Estado tmp : afn1.getEstados())
            afn_salida.agregarEstado(tmp);
        
        /* 
         * Agregar los estados de afn2, excepto el primero. Debemos 
         * incrementar los identificadores de dichos estados.
         */
        for (int i=1; i < afn2.getEstados().cantidad(); i++) {
            Estado tmp = afn2.getEstados().obtener(i);
            tmp.setIdentificador(contadorEstados++);
            afn_salida.agregarEstado(tmp);
        }
        
        /*
         * Agregamos las transiciones del estado inicial de afn2
         * al estado final de afn1.
         */
        for (Transicion trans : afn2.getEstadoInicial().getTransiciones()) {
            Transicion nuevaTrans = new Transicion();
            
            nuevaTrans.setOrigen(afn1.getEstadoFinal());
            nuevaTrans.setDestino(trans.getDestino());
            nuevaTrans.setSimbolo(trans.getSimbolo());
            
            afn1.getEstadoFinal().getTransiciones().agregar(nuevaTrans);
        }
        
        // Setear nuevos estados inicial y final.
        afn_salida.setEstadoInicial(afn1.getEstadoInicial());
        afn_salida.setEstadoFinal(afn2.getEstadoFinal());
        
        return afn_salida;
    }
}
