/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package analisis;

/**
 * Clase que implementa un analizador sintáctico predictivo
 * para una expresión regular, realizando una traducción de 
 * la misma a su versión postfija.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class AnalizadorSintacticoPostfijo {
    
    /**
     * El analizador léxico para este analizador
     * sintáctico. Se hará uso del mismo para 
     * obtener tokens.
     */
    private AnalizadorLexico analizadorLexico;
    
    /**
     * Buffer en el que se va escribiendo la salida
     * de la traducción.
     */
    private StringBuffer salida;
    
    /**
     * Variable para el token actual.
     */
    private Token preanalisis;
    
    /**
     * Contador de tokens recibidos. Útil para
     * indicar dónde ocurren los errores.
     */
    private int contadorTokens;
    
    /**
     * Constructor de la clase.
     * @param alfabeto El alfabeto sobre el cual está definido <code>exprReg</code>.
     * @param exprReg La expresión regular a evaluar.
     */
    public AnalizadorSintacticoPostfijo(Alfabeto alfabeto, String exprReg) {
        analizadorLexico = new AnalizadorLexico(alfabeto, exprReg);
        salida = new StringBuffer();
        contadorTokens = 0;
    }

    /**
     * Inicia el análisis sintáctico (traducción).
     * @return Una cadena que representa la versión postfija de la 
     * expresión regular de entrada.
     * @throws java.lang.Exception En caso de encontrar algún error
     * de sintáxis en la expresión regular de entrada.
     */
    public String analizar() throws Exception {
        preanalisis = obtenerToken();
        
        if (preanalisis.getIdentificador() == TokenExprReg.FINAL)
            error("Expresión regular vacía");
        
        ExprReg();
        
        if (preanalisis.getIdentificador() != TokenExprReg.FINAL)
            error("Carácter inválido");
        
        return salida.toString();
    }
    
    /**
     * Método que procesa las uniones de la expresión regular.
     * @throws java.lang.Exception Propaga la excepción de Concat() y R1().
     */
    private void ExprReg() throws Exception {
        Concat();
        R1();
    }
    
    /**
     * Método que procesa las uniones en forma de lista.
     * @throws java.lang.Exception Propaga la excepción de Concat().
     */
    private void R1() throws Exception {
        while (true) {
            if (preanalisis.getIdentificador() == TokenExprReg.UNION) {
                match(preanalisis);
                Concat();
                escribir(new Token(TokenExprReg.UNION));
            }
            else {
                // Derivar en vacío
                return;
            }
        }
    }

    /**
     * Método que procesa una concatenación en la expresión regular.
     * @throws java.lang.Exception Propaga la excepción de Grupo() y R2().
     */
    private void Concat() throws Exception {
        Grupo();
        R2();
    }
    
    /**
     * Método que procesa una concatenación en forma de lista.
     * @throws java.lang.Exception Propaga la excepción de Grupo().
     */
    private void R2() throws Exception {
        while (true) {
            switch (preanalisis.getIdentificador()) {
                case PAREN_IZQUIERDO:
                case ALFABETO:
                    Grupo();
                    escribir(new Token(TokenExprReg.CONCATENACION));
                    break;
                default:
                    // Derivar en vacío
                    return;
            }
        }
    }
    
    /**
     * Se elimina a R3 trasladando el vacío a Oper. De esta manera,
     * Oper deriva en vacío en caso de no existir un operador.
     * @throws java.lang.Exception Propaga las excepciones de Elem() y Oper().
     */
    private void Grupo() throws Exception {
        Elem();
        R3();
    }
    
    /**
     * 
     * @throws java.lang.Exception
     */
    private void R3() throws Exception {
        switch (preanalisis.getIdentificador()) {
            case CERRADURA_KLEENE:
            case CERRADURA_POSITIVA:
            case OPCION:
                Oper();
                break;
            default:
                // Derivar en vacío
                return;
        }
    }
  
    /**
     * Método que procesa un elemento unitario en la expresión
     * regular. Se intenta hacer match con el paréntesis de
     * apertura o con algún símbolo del alfabeto. En caso 
     * contrario, se produce un error.
     * @throws java.lang.Exception En caso de que no se encuentre un símbolo
     * del alfabeto ni un paréntesis de apertura (inicio de una nueva expresión
     * regular).
     */
    private void Elem() throws Exception {
        switch (preanalisis.getIdentificador()) {
            case PAREN_IZQUIERDO:
                match(new Token(TokenExprReg.PAREN_IZQUIERDO));
                ExprReg();
                match(new Token(TokenExprReg.PAREN_DERECHO));
                break;
            case ALFABETO:
                SimLen();
                break;
            default:
                error("Se espera paréntesis de apertura o símbolo de alfabeto. " +
                    "Se encontró \"" + preanalisis.getValor() + "\"");
        }
    }
    
    /**
     * Método que procesa un operador en la expresión regular.
     * @throws java.lang.Exception Propaga la excepción de match().
     */
    private void Oper() throws Exception {
        escribir(preanalisis);
        match(preanalisis);
    }
    
    /**
     * Método que procesa un símbolo del alfabeto en la expresión regular.
     * @throws java.lang.Exception Si el caracter actual no es un símbolo del alfabeto.
     */
    private void SimLen() throws Exception {
        if (analizadorLexico.getAlfabeto().contiene(preanalisis.getValor())) {
            escribir(preanalisis);
            match(preanalisis);
        }
        else {
            error("El símbolo \"" + preanalisis.getValor() + 
                "\" no pertenece al alfabeto definido.");
        }
    }

    /**
     * 
     * @param entrada
     * @throws java.lang.Exception
     */
    private void match(Token entrada) throws Exception {
        if (preanalisis.equals(entrada))
            preanalisis = obtenerToken();
        else if (entrada.getIdentificador() == TokenExprReg.PAREN_DERECHO)
            error("Falta paréntesis de cierre");
        else
            error("Carácter inválido");
    }
    
    /**
     * Método que escribe la cadena de salida de la traducción.
     * @param entrada Token a escribir.
     */
    private void escribir(Token entrada) {
        salida.append(entrada.getValor());
    }
    
    private void error(String mensaje) throws Exception {
        String mensajeCompleto = "";
        
        mensajeCompleto += "Error de sintáxis\n";
        mensajeCompleto += "Carácter: " + preanalisis.getValor() + "\n";
        mensajeCompleto += "Posición: " + contadorTokens + "\n";
        mensajeCompleto += "Mensaje : " + mensaje;
        
        throw new Exception(mensajeCompleto);
    }
    
    private Token obtenerToken() {
        ++contadorTokens;
        return analizadorLexico.sgteToken();
    }
}
