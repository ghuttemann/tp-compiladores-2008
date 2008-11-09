/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

import analisis.Alfabeto;

/**
 * Clase que representa la abstracción para un Autómata Finito,
 * sea Determinístico (AFD) o No determinístico (AFN).<br><br>
 * Inicialmente, un AFN es contruído a partir de una expresión
 * regular a través de las construcciones de Thompson.<br><br>
 * Un AFD es generado a partir de un AFN a través del algoritmo
 * de Subconjuntos.<br><br>
 * Adicionalmente, un AFD puede ser reducido (en cuanto a
 * cantidad de estados se refiere) a través del algoritmo
 * de Minimización de Estados.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class Automata {
    
    /**
     * Conjunto de estados del autómata.
     */
    private Conjunto<Estado> estados;
    
    /**
     * Expresión regular para este autómata.
     */
    private String exprReg;
    
    /**
     * Alfabeto para este autómata.
     */
    private Alfabeto alfabeto;
    
    /**
     * Constructor por defecto.
     */
    public Automata() {
       this(null, "");
    }
    
    /**
     * Construye un <code>Automata</code> con un determinado <code>Alfabeto</code>
     * y una determinada expresión regular.
     * @param alfabeto El <code>Alfabeto</code> de este <code>Automata</code>.
     * @param exprReg La expresión regular para este <code>Automata</code>.
     */
    public Automata(Alfabeto alfabeto, String exprReg) {
        estados = new Conjunto<Estado>();
        setAlfabeto(alfabeto);
        setExprReg(exprReg);
    }
    
    /**
     * Obtiene el <code>Alfabeto</code> de este <code>Automata</code>.
     * @return El <code>Alfabeto</code> de este <code>Automata</code>.
     */
    public Alfabeto getAlfabeto() {
        return alfabeto;
    }

    /**
     * Establece el <code>Alfabeto</code> de este <code>Automata</code>.
     * @param alfabeto El nuevo <code>Alfabeto</code> para este <code>Automata</code>.
     */
    public void setAlfabeto(Alfabeto alfabeto) {
        this.alfabeto = alfabeto;
    }

    /**
     * Obtiene la expresión regular para este <code>Automata</code>.
     * @return La expresión regular para este <code>Automata</code>.
     */
    public String getExprReg() {
        return exprReg;
    }

    /**
     * Establece la expresión regular para este <code>Automata</code>.
     * @param exprReg La nueva expresión regular para este <code>Automata</code>.
     */
    public void setExprReg(String exprReg) {
        this.exprReg = exprReg;
    }
    
    /**
     * Obtiene el <code>Estado</code> inicial del <code>Automata</code>.
     * @return El <code>Estado</code> inicial del <code>Automata</code>.
     */
    public Estado getEstadoInicial() {
        return estados.obtenerPrimero();
    }
    
    /**
     * Obtiene los <code>Estado</code>s finales del <code>Automata</code>.
     * @return El conjunto de <code>Estado</code>s finales del <code>Automata</code>.
     */
    public Conjunto<Estado> getEstadosFinales() {
        Conjunto<Estado> finales = new Conjunto<Estado>();
        
        for (Estado tmp : estados)
            if (tmp.getEsFinal())
                finales.agregar(tmp);
        
        return finales;
    }
    
    /**
     * Agrega un <code>Estado</code> al <code>Automata</code>.
     * @param estado Nuevo <code>Estado</code> para el <code>Automata</code>.
     */
    public void agregarEstado(Estado estado) {
        estados.agregar(estado);
    }
    
    /**
     * Recupera un determinado <code>Estado</code> del <code>Automata</code>.
     * @param pos El identificador del <code>Estado</code> a recuperar.
     * @return El <code>Estado</code> recuperado.
     */
    public Estado getEstado(int pos) {
        return estados.obtener(pos);
    }
    
    /**
     * Recupera el conjunto de <code>Estado</code>s del <code>Automata</code>.
     * @return El conjunto de <code>Estado</code>s el <code>Automata</code>.
     */
    public Conjunto<Estado> getEstados() {
        return estados;
    }
    
    /**
     * Recupera la cantidad de estados del <code>Automata</code>.
     * @return Cantidad de estados del <code>Automata</code>.
     */
    public int cantidadEstados() {
        return estados.cantidad();
    }
    
    /**
     * Establece a <code>false</code> el estado de visitado de todos los 
     * <code>Estado</code>s de este <code>Automata</code>. Útil para
     * iniciar un recorrido nuevo sobre los <code>Estado</code>s de este
     * <code>Automata</code>.
     */
    public void iniciarRecorrido() {
        for (Estado tmp : estados)
            tmp.setVisitado(false);
    }
    
    @Override
    public String toString() {
        String afnStr = "";
        
        for (Estado tmp : getEstados()) {
            afnStr += tmp.toString();
            
            for (Transicion trans : tmp.getTransiciones())
                afnStr += " --> " + trans.getEstado() + "(" + trans.getSimbolo() + ")";
            
            afnStr += "\n";
        }
        
        return afnStr;
    }
}
