/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package analisis;

/**
 *
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class AnalizadorSintactico {
    
    /**
     * 
     */
    private AnalizadorLexico lexer;
    
    /**
     * 
     */
    private StringBuffer salida;
    
    /**
     * 
     * @param alfabeto
     * @param exprReg
     */
    public AnalizadorSintactico(Alfabeto alfabeto, String exprReg) {
        lexer  = new AnalizadorLexico(alfabeto, exprReg);
        salida = new StringBuffer();
    }
    
    /**
     * 
     * @return
     */
    public String analizar() {
        
        return salida.toString();
    }
    
    
}
