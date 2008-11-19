/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package analisis;

import estructuras.AFN;
import estructuras.Log;
import algoritmos.Thompson;

/**
 * Clase que implementa un analizador sintáctico predictivo
 * para una expresión regular, realizando una traducción de 
 * la misma a su correspondiente AFN.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class AnalizadorSintactico {
    
    /**
     * Log del análisis sintáctico.
     */
    private Log log;
    
    /**
     * El analizador léxico para este analizador
     * sintáctico. Se hará uso del mismo para 
     * obtener tokens.
     */
    private AnalizadorLexico analizadorLexico;
    
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
    public AnalizadorSintactico(Alfabeto alfabeto, String exprReg) {
        analizadorLexico = new AnalizadorLexico(alfabeto, exprReg);
        contadorTokens = 0;
        log = new Log();
    }

    /**
     * Inicia el análisis sintáctico (traducción).
     * @return Un AFN que representa a la expresión regular de entrada.
     * @throws java.lang.Exception En caso de encontrar algún error
     * de sintáxis en la expresión regular de entrada.
     */
    public AFN analizar() throws Exception {
        preanalisis = obtenerToken();
        
        if (preanalisis.getIdentificador() == TokenExprReg.FINAL)
            error("Expresión regular vacía");
        
        // Logging
        log.vaciar();
        log.agregar("Derivaciones realizadas por el parser".toUpperCase()).nuevaLinea();
        log.agregar("-------------------------------------").nuevaLinea().nuevaLinea();
        
        AFN afn = ExprReg();
        afn.setAlfabeto(analizadorLexico.getAlfabeto());
        afn.setExprReg(analizadorLexico.getExpresionRegular());
        
        if (preanalisis.getIdentificador() != TokenExprReg.FINAL)
            error("Carácter de finalización inválido");
        
        return afn;
    }
    
    /**
     * Método que procesa las uniones de la expresión regular.
     * @throws java.lang.Exception Propaga la excepción de Concat() y R1().
     */
    private AFN ExprReg() throws Exception {
        log.agregar("ExprReg -> Concat R1").nuevaLinea();
        
        AFN afn1 = Concat();
        AFN afn2 = R1();
        
        if (afn2 == null)
            return afn1;
        else
            return Thompson.union(afn1, afn2);
    }
    
    /**
     * Método que procesa las uniones en forma de lista.
     * @throws java.lang.Exception Propaga la excepción de ExprReg().
     */
    private AFN R1() throws Exception {
        if (preanalisis.getIdentificador() == TokenExprReg.UNION) {
            match(preanalisis);
            /*
             * Como el lado derecho de la producción 
             * 'R1 -> "|" Concat R1' es igual al de 
             * 'ExpReg -> Concat R1', en terminos de
             * ejecución de métodos, hacemos una llamada
             * al método ExpReg().
             */
            log.agregar("R1 -> \"|\" Concat R1").nuevaLinea();
            AFN afn1 = Concat();
            AFN afn2 = R1();

            if (afn2 == null)
                return afn1;
            else
                return Thompson.union(afn1, afn2);
        }
        else {
            // Derivar en vacío
            log.agregar("R1 -> " + Alfabeto.VACIO).nuevaLinea();
            return null;
        }
    }

    /**
     * Método que procesa una concatenación en la expresión regular.
     * @throws java.lang.Exception Propaga la excepción de Grupo() y R2().
     */
    private AFN Concat() throws Exception {
        log.agregar("Concat -> Grupo R2").nuevaLinea();
        
        AFN afn1 = Grupo();
        AFN afn2 = R2();
        
        if (afn2 == null)
            return afn1;
        else
            return Thompson.concatenacion(afn1, afn2);
    }
    
    /**
     * Método que procesa una concatenación en forma de lista.
     * @throws java.lang.Exception Propaga la excepción de Concat().
     */
    private AFN R2() throws Exception {
        switch (preanalisis.getIdentificador()) {
            case PAREN_IZQUIERDO:
            case ALFABETO:
                /*
                 * Como el lado derecho de la producción 
                 * 'R2 -> Grupo R2' es igual al de 
                 * 'Concat -> Grupo R2' hacemos una llamada
                 * al método Concat().
                 */
                log.agregar("R2 -> Grupo R2").nuevaLinea();
                AFN afn1 = Grupo();
                AFN afn2 = R2();

                if (afn2 == null)
                    return afn1;
                else
                    return Thompson.concatenacion(afn1, afn2);
            default:
                // Derivar en vacío
                log.agregar("R2 -> " + Alfabeto.VACIO).nuevaLinea();
                return null;
        }
    }
    
    /**
     * Método que procesa un elemento unitario, posiblemente aplicando un
     * operador unario.
     * @throws java.lang.Exception Propaga las excepciones de Elem() y Oper().
     */
    private AFN Grupo() throws Exception {
        log.agregar("Grupo -> Elem Oper").nuevaLinea();
        
        AFN afn = Elem();
        TokenExprReg operador = Oper();
        
        switch (operador) {
            case CERRADURA_KLEENE:
                return Thompson.cerraduraKleene(afn);
            case CERRADURA_POSITIVA:
                return Thompson.cerraduraPositiva(afn);
            case OPCION:
                return Thompson.opcion(afn);
            default:
                return afn;
        }
    }
    
    /**
     * Método que procesa un operador en la expresión regular.
     * @throws java.lang.Exception Propaga la excepción de match().
     */
    private TokenExprReg Oper() throws Exception {
        TokenExprReg operador;
        
        switch (preanalisis.getIdentificador()) {
            case CERRADURA_KLEENE:
            case CERRADURA_POSITIVA:
            case OPCION:
                operador = preanalisis.getIdentificador();
                
                log.agregar("Oper -> " + preanalisis.getValor()).nuevaLinea();
                match(preanalisis);
                break;
            default:
                // Derivar en vacío
                log.agregar("Oper -> " + Alfabeto.VACIO).nuevaLinea();
                operador = TokenExprReg.DESCONOCIDO;
        }
        
        return operador;
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
    private AFN Elem() throws Exception {
        AFN afn = null;
        
        switch (preanalisis.getIdentificador()) {
            case PAREN_IZQUIERDO:
                log.agregar("Elem -> \"(\" ExprReg \")\"").nuevaLinea();
                
                match(new Token(TokenExprReg.PAREN_IZQUIERDO));
                afn = ExprReg();
                match(new Token(TokenExprReg.PAREN_DERECHO));
                break;
            case ALFABETO:
                log.agregar("Elem -> SimLen").nuevaLinea();
                
                afn = SimLen();
                break;
            default:
                error("Se espera paréntesis de apertura o símbolo de alfabeto. " +
                    "Se encontró \"" + preanalisis.getValor() + "\"");
        }
        
        return afn;
    }
    
    /**
     * Método que procesa un símbolo del alfabeto en la expresión regular.
     * @throws java.lang.Exception Si el caracter actual no es un símbolo del alfabeto.
     */
    private AFN SimLen() throws Exception {
        String simbolo = preanalisis.getValor();
        
        if (!analizadorLexico.getAlfabeto().contiene(simbolo)) {
            error("El símbolo \"" + simbolo + 
                "\" no pertenece al alfabeto definido.");
        }
        
        log.agregar("SimElem -> " + simbolo).nuevaLinea();
        
        AFN afn = Thompson.basico(simbolo);
        match(preanalisis);
        return afn;
    }

    /**
     * Método que se encarga de corroborar que la
     * entrada es la correcta para consumir el siguiente
     * token.
     * @param entrada Token esperado, debe ser igual al token actual.
     * @throws java.lang.Exception En caso de que el token actual no
     * sea igual al esperado.
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
     * Método que se encarga de lanzar excepciones
     * para los distintos casos de error posibles.
     * @param mensaje El mensaje de error.
     * @throws java.lang.Exception Siempre se lanza una excepción,
     * producto del error ocurrido.
     */
    private void error(String mensaje) throws Exception {
        String mensajeCompleto = "";
        
        mensajeCompleto += "Error de sintáxis\n";
        mensajeCompleto += "Carácter: " + preanalisis.getValor() + "\n";
        mensajeCompleto += "Posición: " + contadorTokens + "\n";
        mensajeCompleto += "Mensaje : " + mensaje;
        
        throw new Exception(mensajeCompleto);
    }
    
    /**
     * Método que obtiene el siguiente token y registra
     * la cantidad de tokens leídos.
     * @return El siguiente token del Analizador Léxico.
     * @throws java.lang.Exception
     */
    private Token obtenerToken() throws Exception {
        ++contadorTokens;
        return analizadorLexico.sgteToken();
    }
    
    /**
     * Obtiene el <code>Log</code> de esta clase.
     * @return El <code>Log</code> correspondiente
     * al proceso de análisis sintáctico.
     */
    public Log getLog() {
        return log;
    }
}
