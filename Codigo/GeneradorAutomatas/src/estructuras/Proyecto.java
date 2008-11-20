/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package estructuras;

import analisis.Alfabeto;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Esta clase representa un proyecto del 
 * Generador de Autómatas. Consiste en 
 * la expresión regular y el alfabeto
 * correspondiente, a partir de los cuales
 * es posible generar todo el resto.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
@Root
public class Proyecto {
    /**
     * Alfabeto.
     */
    @Element
    private Alfabeto alfabeto;
    
    /**
     * Expresión regular.
     */
    @Element
    private String exprReg;
    
    /**
     * Constructor por defecto.
     */
    public Proyecto() {
        
    }

    /**
     * Obtiene el <code>Alfabeto</code>
     * de este <code>Proyecto</code>.
     * @return El <code>Alfabeto</code>
     * de este <code>Proyecto</code>.
     */
    public Alfabeto getAlfabeto() {
        return alfabeto;
    }

    /**
     * Establece el <code>Alfabeto</code>
     * de este <code>Proyecto</code>.
     * @param alfabeto El nuevo <code>Alfabeto</code>
     * para este <code>Proyecto</code>.
     */
    public void setAlfabeto(Alfabeto alfabeto) {
        this.alfabeto = alfabeto;
    }

    /**
     * Obtiene la Expresión Regular de
     * este <code>Proyecto</code>.
     * @return La Expresión Regular de
     * este <code>Proyecto</code>.
     */
    public String getExprReg() {
        return exprReg;
    }

    /**
     * Establece la Expresión Regular de
     * este <code>Proyecto</code>.
     * @param exprReg La nueva Expresión
     * Regular de este <code>Proyecto</code>.
     */
    public void setExprReg(String exprReg) {
        this.exprReg = exprReg;
    }
}
