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
public class PruebaAnalisisSintactico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alfabeto alfa = new Alfabeto("ab");
        String er = "(a|b)*ax";
        AnalizadorSintactico as = new AnalizadorSintactico(alfa, er);
        
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
