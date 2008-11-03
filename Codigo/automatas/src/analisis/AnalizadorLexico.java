/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package analisis;

/**
 * Esta clase implementa el analizador léxico y el método para
 * que el Analizador Sintáctico pueda consumir tokens.<br><br>
 * Es importante mencionar que los lexemas de la entrada siempre
 * estarán formados por un solo caracter, por lo que no se 
 * requiere utilizar autómatas finitos para construirlos.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class AnalizadorLexico {
    
    /**
     * Conjunto de símbolos que pueden ser utilizados para
     * escribir la entrada (<code>exprReg</code>) para el
     * Analizador Léxico.
     */
    private Alfabeto alfabeto;
    
    /**
     * La cadena de entrada sobre el cual debe trabajar el
     * Analizador Léxico. La misma consiste en una expresión
     * regular definida sobre el alfabeto con los siguientes 
     * símbolos <code>|, *, +, ?, (, )</code>, más todos los 
     * símbolos de <code>alfabeto</code>.
     */
    private String exprReg;
    
    /**
     * Variable utilizada como buffer de entrada. Inicialmente,
     * consiste en la expresión regular de entrada.
     */
    private StringBuffer buffer;
    
    /**
     * Constructor de la clase.
     * @param alfabeto El alfabeto de simbolos posibles sobre 
     * la cual se puede definir una expresión regular.
     * @param exprReg La expresión regular (entrada) sobre la que se trabaja.
     */
    public AnalizadorLexico(Alfabeto alfabeto, String exprReg) {
       this.alfabeto = alfabeto;
       this.exprReg  = exprReg;
       this.buffer   = new StringBuffer(exprReg);
    }
    
    /**
     * Este método se encarga de consumir caracteres del buffer
     * de entrada, convertirlos a tokens y retornarlos al Analizador
     * Sintáctico.
     * @return El siguiente token recuperado de la entrada.
     */
    public Token sgteToken() {
        try {
            String lexema = sgteLexema();

            if (lexema.matches("\\s"))
                // Omitimos cualquier tipo de espacio en blanco
                return sgteToken();
            else if (lexema.equals("*"))
                return new Token(TokenExprReg.CERRADURA_KLEENE);
            else if (lexema.equals("+"))
                return new Token(TokenExprReg.CERRADURA_POSITIVA);
            else if (lexema.equals("?"))
                return new Token(TokenExprReg.OPCION);
            else if (lexema.equals("|"))
                return new Token(TokenExprReg.UNION);
            else if (lexema.equals("("))
                return new Token(TokenExprReg.PAREN_IZQUIERDO);
            else if (lexema.equals(")"))
                return new Token(TokenExprReg.PAREN_DERECHO);
            else if (lexema.equals(""))
                return new Token(TokenExprReg.FINAL);
            else if (alfabeto.contiene(lexema))
                return new Token(TokenExprReg.ALFABETO, lexema);
            else
                return new Token(TokenExprReg.DESCONOCIDO, lexema);
        } 
        catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    /**
     * 
     * @return
     */
    public Alfabeto getAlfabeto() {
        return alfabeto;
    }
    
    /**
     * 
     * @return
     */
    public String getExpresionRegular() {
        return exprReg;
    }
    
    /**
     * Este método consume cada uno de los caracteres del buffer 
     * de entrada, hasta agotarlos. En dicho momento, retorna la 
     * cadena vacía, que representará al token FINAL.
     * @return Siguiente caracter en el buffer de entrada.
     */
    private String sgteLexema() {
        String salida = "";
        
        if (buffer.length() > 0) {
            salida += buffer.charAt(0);
            buffer.deleteCharAt(0);
        }
        
        return salida;
    }
}
