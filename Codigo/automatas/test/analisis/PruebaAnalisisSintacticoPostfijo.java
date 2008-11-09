/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package analisis;

import old.AnalizadorSintacticoPostfijo;

/**
 *
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class PruebaAnalisisSintacticoPostfijo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alfabeto alfa = new Alfabeto("ab");
        String er = "(a|b)*ax";
        AnalizadorSintacticoPostfijo as = new AnalizadorSintacticoPostfijo(alfa, er);
        
        String salida;        
        try {
            salida = as.analizar();
            System.out.printf("\"%s\"", salida);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
