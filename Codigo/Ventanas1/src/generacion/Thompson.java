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
        Estado fin = new Estado(1, true);
        
        /* Transición entre los estados inicial y final */
        Transicion tran = new Transicion(fin, simbolo);
        ini.getTransiciones().agregar(tran);
        
        /* Agregamos los estados al AFN */
        afn.agregarEstado(ini);
        afn.agregarEstado(fin);
        
        return afn;
    }
    
    /**
     * Aplica la cerradura de Kleene (*) a un AFN dado.
     * @param afn El AFN sobre el cual aplicar la cerradura de Kleene.
     * @return El AFN resultante de aplicar cerradura de Kleene a <code>afn</code>.
     */
    public static AFN cerraduraKleene(AFN afn) {
        AFN afn_salida = new AFN();
                
        /* Agregamos el estado inicial */
        Estado nuevoInicio = new Estado(afn_salida.cantidadEstados());
        afn_salida.agregarEstado(nuevoInicio);
        
        /* 
         * Agregamos los demás estados, el incremento es igual
         * a la cantidad de estado en el AFN destino.
         */
        Automata.copiarEstados(afn, afn_salida, afn_salida.cantidadEstados());
        
        /* Agregamos el estado final */
        Estado nuevoFin = new Estado(afn_salida.cantidadEstados(), true);
        afn_salida.agregarEstado(nuevoFin);
        
        /* Agregamos transiciones adicionales desde el nuevo estado inicial */
        nuevoInicio.getTransiciones().agregar(new Transicion(afn_salida.getEstado(1), Alfabeto.VACIO));
        nuevoInicio.getTransiciones().agregar(new Transicion(nuevoFin, Alfabeto.VACIO));
        
        /* Estado anterior al final */
        Estado antesDeFinal = afn_salida.getEstado(afn_salida.cantidadEstados() - 2);
        
        /* Agregamos transiciones adicionales desde el anterior estado final */
        antesDeFinal.getTransiciones().agregar(new Transicion(afn_salida.getEstado(1), Alfabeto.VACIO));
        antesDeFinal.getTransiciones().agregar(new Transicion(nuevoFin, Alfabeto.VACIO));
        
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
    
    /**
     * Aplica el operador de unión a dos AFNs dados.
     * @param afn1 El primer operando de la unión.
     * @param afn2 El segundo operando de la unión.
     * @return El AFN resultante de la unión de 
     * <code>afn1</code> y <code>afn2</code>.
     */
    public static AFN union(AFN afn1, AFN afn2) {
        Transicion trans;
        AFN afn = new AFN();
        
        /* Agregamos el estado inicial */
        Estado nuevoInicio = new Estado(afn.cantidadEstados());
        afn.agregarEstado(nuevoInicio);
        
        /* 
         * Agregamos los estados de afn1, el incremento es igual
         * a la cantidad de estado en el AFN destino.
         */
        Automata.copiarEstados(afn1, afn, afn.cantidadEstados());
        
        /* 
         * Agregamos los estados de afn2, el incremento es igual
         * a la cantidad de estado en el AFN destino.
         */
        Automata.copiarEstados(afn2, afn, afn.cantidadEstados());
        
        /* Agregamos el estado final */
        Estado nuevoFin = new Estado(afn.cantidadEstados(), true);
        afn.agregarEstado(nuevoFin);
        
        /* 
         * Creamos transición vacía desde estado inicial 
         * de afn hasta estado inicial de afn1 (ahora en afn).
         */
        trans = new Transicion();
        trans.setEstado(afn.getEstado(1));
        trans.setSimbolo(Alfabeto.VACIO);
        nuevoInicio.getTransiciones().agregar(trans);
        
        /* 
         * Creamos transición vacía desde estado inicial 
         * de afn hasta estado inicial de afn2 (ahora en afn).
         */
        trans = new Transicion();
        trans.setEstado(afn.getEstado(afn1.cantidadEstados() + 1));
        trans.setSimbolo(Alfabeto.VACIO);
        nuevoInicio.getTransiciones().agregar(trans);
        
        /*
         * Creamos transición vacía desde el estado final
         * de afn1 (ahora en afn) hasta el estado final de afn.
         */
        trans = new Transicion();
        trans.setEstado(afn.getEstado(afn.cantidadEstados() - 1));
        trans.setSimbolo(Alfabeto.VACIO);
        afn.getEstado(afn1.cantidadEstados()).getTransiciones().agregar(trans);
        
        /*
         * Creamos transición vacía desde el estado final
         * de afn2 (ahora en afn) hasta el estado final de afn.
         */
        trans = new Transicion();
        trans.setEstado(afn.getEstado(afn.cantidadEstados() - 1));
        trans.setSimbolo(Alfabeto.VACIO);
        afn.getEstado(afn.cantidadEstados() - 2).getTransiciones().agregar(trans);
        
        return afn;
    }
    
    /**
     * Aplica el operador de concatenación a dos AFNs dados.
     * @param afn1 El primer operando de la concatenación.
     * @param afn2 El segundo operando de la concatenación.
     * @return El AFN resultante de la concatenación de 
     * <code>afn1</code> y <code>afn2</code>.
     */
    public static AFN concatenacion(AFN afn1, AFN afn2) {
        AFN afn = new AFN();
        
        /* 
         * Agregamos los estados de afn1, el incremento es igual
         * a la cantidad de estado en el AFN destino, que en este
         * caso es igual a cero.
         */
        Automata.copiarEstados(afn1, afn, afn.cantidadEstados());
        
        /* Último estado actual del autómata que estamos generando */
        Estado ultimoActual = afn.getEstado(afn.cantidadEstados() - 1);
        
        /* 
         * Agregamos los estados de afn2, excepto el primero.
         * En este caso, el incremento es igual al máximo 
         * identificador de estados en el AFN destino y no a
         * la cantidad de estados ya que aquí se omite un estado.
         */
        Automata.copiarEstados(afn2, afn, afn.cantidadEstados() - 1, 1);
        
        /* Estado inicial de afn2 */
        Estado inicioAfn2 = afn2.getEstadoInicial();
        
        /*
         * Agregamos las transiciones del estado inicial de afn2
         * (ahora en afn) al estado final de afn1 (ahora en afn).
         */
        Automata.copiarTransiciones(afn, inicioAfn2.getTransiciones(), 
                            ultimoActual, ultimoActual.getIdentificador());
        
        /* Establecer estado final */
        afn.getEstado(afn.cantidadEstados() - 1).setEsFinal(true);
        
        return afn;
    }
}
