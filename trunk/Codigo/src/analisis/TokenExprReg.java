/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package analisis;

/**
 * Enumeración que representa los posibles tokens para una
 * expresión regular.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 * @see Token
 */
public enum TokenExprReg {
    /**
     * Paréntesis derecho, ")".
     */
    PAREN_DERECHO,
    
    /**
     * Paréntesis izquierdo, "(".
     */
    PAREN_IZQUIERDO,
    
    /**
     * Operador de unión, "|".
     */
    UNION,
    
    /**
     * Operador de cerradura de Kleene, "*".
     */
    CERRADURA_KLEENE,
    
    /**
     * Operador de cerradura positiva, "+".
     */
    CERRADURA_POSITIVA,
    
    /**
     * Operador de opción, "?".
     */
    OPCION,
    
    /**
     * Operador de concatenación (no tiene dibujo).
     */
    CONCATENACION,
    
    /**
     * Un símbolo del alfabeto.
     */
    ALFABETO,
    
    /**
     * Finalizador de una expresión regular (EOF).
     */
    FINAL,
    
    /**
     * Token desconocido (inválido).
     */
    DESCONOCIDO
}
