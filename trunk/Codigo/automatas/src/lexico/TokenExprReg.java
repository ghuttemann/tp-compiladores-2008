/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 */
package lexico;

/**
 * Enumeración que representa los posibles tokens para una
 * expresión regular.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 * @see Token
 */
public enum TokenExprReg {
    // Paréntesis derecho (grupo)
    PAREN_DER,
    
    // Paréntesis izquierdo (grupo)
    PAREN_IZQ,
    
    // Operador de unión, "|"
    UNION,
    
    // Operador de cerradura de Kleene, "*"
    CERO_MAS,
    
    // Operador de cerradura positiva, "+"
    UNO_MAS,
    
    // Operador de opción, "?"
    CERO_UNO,
    
    // Operador de concatenación (no tiene dibujo)
    CONCAT,
    
    // Un símbolo del alfabeto
    SIM_LEN,
    
    // Finalizador de una expresión regular
    FINAL,
    
    // Token inválido
    DESCONOCIDO
}
