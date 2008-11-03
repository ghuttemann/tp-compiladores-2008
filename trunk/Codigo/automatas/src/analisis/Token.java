/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package analisis;

/**
 * Clase que representa un token de una expresión regular. El token
 * tiene dos atributos: identificador y valor.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 * @see TokenExprReg
 */
public class Token {
    
    /**
     * Identificador del token.
     */
    private TokenExprReg ident;
    
    /**
     * Valor del token.
     */
    private String valor;
    
    /**
     * Constructor por defecto.
     * @param token El tipo de token que deseamos crear.
     * @throws Exception En caso de que <code>token</code> sea un tipo inválido.
     */
    public Token(TokenExprReg token) throws Exception {
        if (token == TokenExprReg.CERRADURA_KLEENE) {
            ident = TokenExprReg.CERRADURA_KLEENE;
            valor = "*";
        }
        else if (token == TokenExprReg.OPCION) {
            ident = TokenExprReg.OPCION;
            valor = "?";
        }
        else if (token == TokenExprReg.CERRADURA_POSITIVA) {
            ident = TokenExprReg.CERRADURA_POSITIVA;
            valor = "+";
        }
        else if (token == TokenExprReg.CONCATENACION) {
            ident = TokenExprReg.CONCATENACION;
            valor = "#";
        }
        else if (token == TokenExprReg.UNION) {
            ident = TokenExprReg.UNION;
            valor = "|";
        }
        else if (token == TokenExprReg.PAREN_DERECHO) {
            ident = TokenExprReg.PAREN_DERECHO;
            valor = ")";
        }
        else if (token == TokenExprReg.PAREN_IZQUIERDO) {
            ident = TokenExprReg.PAREN_IZQUIERDO;
            valor = "(";
        }
        else if (token == TokenExprReg.FINAL) {
            ident = TokenExprReg.FINAL;
            valor = "";
        }
        else {
            throw new Exception("Token inválido");
        }
    }
    
    /**
     * Constructor para simbolos del alfabeto y para símbolos desconocidos.
     * @param token El tipo de token que deseamos crear.
     * @param simbolo Símbolo del alfabeto o desconocido para el token.
     * @throws Exception En caso de que <code>token</code> sea un tipo inválido.
     */
    public Token(TokenExprReg token, String simbolo) throws Exception {
        if (token == TokenExprReg.ALFABETO) {
            ident = TokenExprReg.ALFABETO;
            valor = simbolo;
        }
        else if (token == TokenExprReg.DESCONOCIDO) {
            ident = TokenExprReg.DESCONOCIDO;
            valor = simbolo;
        }
        else {
            throw new Exception("Token inválido");
        }
    }
    
    /**
     * Devuelve el atributo <i>identificador</i> del token.
     * @return Identificador del token.
     */
    public TokenExprReg getIdentificador() {
        return ident;
    }
    
    /**
     * Devuelve el atributo <i>valor</i> del token.
     * @return
     */
    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Token other = (Token) obj;
        if (this.ident != other.ident) {
            return false;
        }
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.ident != null ? this.ident.hashCode() : 0);
        hash = 59 * hash + (this.valor != null ? this.valor.hashCode() : 0);
        return hash;
    }
}
