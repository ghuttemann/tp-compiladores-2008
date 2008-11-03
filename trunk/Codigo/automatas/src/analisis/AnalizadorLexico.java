/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package analisis;

import java.util.Hashtable;

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
     * Tabla de símbolos válidos esperados por el analizador léxico.
     */
    private Hashtable<String, TokenExprReg> tablaSimbolos;
    
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
       crearTablaSimbolos();
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

            // Omitimos cualquier tipo de espacio en blanco
            if (lexema.matches("\\s"))
                return sgteToken();
            
            TokenExprReg tipoToken = tablaSimbolos.get(lexema);
            
            if (tipoToken == null)
                return new Token(TokenExprReg.DESCONOCIDO, lexema);
            else if (tipoToken == TokenExprReg.ALFABETO)
                return new Token(TokenExprReg.ALFABETO, lexema);
            else
                return new Token(tipoToken);
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
    
    private void crearTablaSimbolos() {
        tablaSimbolos = new Hashtable<String, TokenExprReg>();

        tablaSimbolos.put("*", TokenExprReg.CERRADURA_KLEENE);
        tablaSimbolos.put("+", TokenExprReg.CERRADURA_POSITIVA);
        tablaSimbolos.put("?", TokenExprReg.OPCION);
        tablaSimbolos.put("|", TokenExprReg.UNION);
        tablaSimbolos.put("(", TokenExprReg.PAREN_IZQUIERDO);
        tablaSimbolos.put(")", TokenExprReg.PAREN_DERECHO);
        tablaSimbolos.put("", TokenExprReg.FINAL);

        for (int i=0; i < alfabeto.getTamaño(); i++) {
            String simbolo = alfabeto.getSimbolo(i);
            tablaSimbolos.put(simbolo, TokenExprReg.ALFABETO);
        }
    }
}
