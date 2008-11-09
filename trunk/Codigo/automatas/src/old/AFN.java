/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package old;

import generacion.*;
import analisis.Alfabeto;

/**
 * Esta clase representa un Autómata Finito No-determinístico, el cual
 * es construído a partir de una expresión regular, a través del algoritmo
 * de Thompson.<br><br>
 * Por definición, un AFN puede tener más de un estado final. Sin embargo,
 * los AFNs construídos con el algoritmo de Thompson siempre tienen un solo
 * estado final.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class AFN {

    /**
     * Conjunto de estados del AFN.
     */
    private Conjunto<Estado> estados;
    
    /**
     * Estado inicial del AFN.
     */
    private Estado inicio;
    
    /**
     * Estado final del AFN.
     */
    private Estado fin;
    
    /**
     * Expresión regular para este AFN.
     */
    private String exprReg;
    
    /**
     * Alfabeto para este AFN.
     */
    private Alfabeto alfabeto;
    
    /**
     * Constructor por defecto.
     */
    public AFN() {
        this(null, "");
    }
    
    public AFN(Alfabeto alfabeto, String exprReg) {
        estados = new Conjunto<Estado>();
        setAlfabeto(alfabeto);
        setExprReg(exprReg);
    }

    /**
     * Obtiene el estado inicial del AFN.
     * @return El estado inicial del AFN.
     */
    public Estado getEstadoInicial() {
        return inicio;
    }

    /**
     * Setea el estado inicial del AFN.
     * @param inicio El nuevo estado inicial del AFN.
     */
    public void setEstadoInicial(Estado inicio) {
        this.inicio = inicio;
    }
    
    /**
     * Obtiene el estado final del AFN.
     * @return El estado final del AFN.
     */
    public Estado getEstadoFinal() {
        return fin;
    }
    
    /**
     * Setea el estado final del AFN.
     * @param fin El estado final del AFN.
     */
    public void setEstadoFinal(Estado fin) {
        this.fin = fin;
    }

    /**
     * Obtiene el alfabeto de este AFN.
     * @return El alfabeto de este AFN.
     */
    public Alfabeto getAlfabeto() {
        return alfabeto;
    }

    /**
     * Setea el alfabeto de este AFN.
     * @param alfabeto El nuevo alfabeto para este AFN.
     */
    public void setAlfabeto(Alfabeto alfabeto) {
        this.alfabeto = alfabeto;
    }

    /**
     * Obtiene la expresión regular para este AFN.
     * @return La expresión regular para este AFN.
     */
    public String getExprReg() {
        return exprReg;
    }

    /**
     * Setea la expresión regular para este AFN.
     * @param exprReg La nueva expresión regular para este AFN.
     */
    public void setExprReg(String exprReg) {
        this.exprReg = exprReg;
    }
    
    /**
     * Agrega un estado al AFN.
     * @param estado Nuevo estado para el AFN.
     */
    public void agregarEstado(Estado estado) {
        estados.agregar(estado);
    }
    
    public Conjunto<Estado> getEstados() {
        return estados;
    }
    
    @Override
    public String toString() {
        String afnStr = "";
        
        for (Estado tmp : getEstados()) {
            afnStr += tmp.toString();
            
            for (Transicion trans : tmp.getTransiciones())
                afnStr += " --> " + trans.getDestino() + "(" + trans.getSimbolo() + ")";
            
            afnStr += "\n";
        }
        
        return afnStr;
    }   
}
