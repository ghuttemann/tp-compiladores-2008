/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lexico;

import java.util.Arrays;
import java.util.Vector;

/**
 * Clase que representa el alfabeto sobre el cual se construye
 * una expresión regular.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class Alfabeto {
    
    /**
     * Conjunto de símbolos del alfabeto.
     */
    private Vector<String> simbolos;
    
    /**
     * Contructor de la clase.
     * @param caracteres Cadena de caracteres con los símbolos del alfabeto.
     */
    public Alfabeto(String caracteres) {      
        String[] arregloTemp = new String[caracteres.length()];
        for (int i=0; i < caracteres.length(); i++)
            arregloTemp[i] = "" + caracteres.charAt(i);
        
        Arrays.sort(arregloTemp);
        
        simbolos = new Vector<String>(arregloTemp.length);
        for (int i=0; i < arregloTemp.length; i++) {
            String temp = arregloTemp[i];
            if (!simbolos.contains(temp))
                simbolos.add(temp);
        }   
    }
    
    /**
     * Retorna el tamaño de este alfabeto, es decir
     * la cantidad de símbolos que contiene.
     * @return Cantidad de símbolos del alfabeto.
     */
    public int getTamaño() {
        return simbolos.size();
    }
    
    /**
     * Retorna un determinado símbolo del alfabeto.
     * @param pos Posición del símbolo dentro del alfabeto.
     * @return El símbolo del alfabeto ubicado en la posición <code>pos</code>.
     */
    public String getSimbolo(int pos) {
        return simbolos.get(pos);
    }
    
    /**
     * Método que permite conocer si un caracter dado pertenece
     * a este alfabeto.
     * @param caracter El caracter que se quiere saber si pertenece al alfabeto.
     * @return <code>true</code> si el caracter pertenece al alfabeto, <code>false</code> en caso contrario.
     */
    public boolean contiene(String caracter) {
        return simbolos.contains(caracter);
    }
    
    @Override
    public String toString() {
        String salida = "{";
        
        for (int i=0; i < this.getTamaño(); i++) {
            salida += simbolos.get(i);
            
            if (i < this.getTamaño()-1)
                salida += ", ";
        }
        
        return salida;
    }
}
