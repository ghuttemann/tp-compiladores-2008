/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package estructuras;

import java.util.Vector;

/**
 *
 * @author Germán Hütteman
 * @author Marcelo Rodas
 */
public class Log {

    /**
     * Lista de cadenas que se van
     * agregando al Log.
     */
    private Vector<String> cadenas;
    
    /**
     * Construye un nuevo <code>Log</code> que
     * no contiene ningún texto.
     */
    public Log() {
        cadenas = new Vector<String>();
    }
    
    /**
     * Agrega una línea al <code>Log</code>.
     * @param linea La línea agregada al <code>Log</code>.
     * @return this (para encadenamiento de métodos).
     */
    public Log agregar(String linea) {
        cadenas.add(linea);
        return this;
    }
    
    /**
     * Agrega un caracter de fin de línea al <code>Log</code>.
     * @return this (para encadenamiento de métodos).
     */
    public Log nuevaLinea() {
        cadenas.add("\n");
        return this;
    }
    
    /**
     * Vacia las cadenas de este <code>Log</code>.
     * @return this (para encadenamiento de métodos).
     */
    public Log vaciar() {
        cadenas.clear();
        return this;
    }
    
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        for (String s : cadenas)
            str.append(s);
        
        return str.toString();
    }
}
