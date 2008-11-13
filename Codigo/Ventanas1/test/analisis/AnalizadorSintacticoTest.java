/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package analisis;

import generacion.AFN;
import org.junit.Test;

/**
 * Clase de prueba para la clase <code>AnalizadorSintactico</code>
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class AnalizadorSintacticoTest {

    /**
     * Test of analizar method, of class AnalizadorSintactico.
     * @throws Exception 
     */
    @Test
    public void testAnalizar() throws Exception {
        Alfabeto alfa = new Alfabeto("ab");
        String er = "(a|b)a*";
        AnalizadorSintactico as = new AnalizadorSintactico(alfa, er);
        
        AFN salida = as.analizar();
        System.out.printf("AFN:\n%s", salida);
        
        /* Tabla transicion del AFN */
        System.out.println();
        Object[][] tabla = salida.getTablaTransicion();
        for (int i=0; i < tabla.length; i++) {
            for (int j=0; j < tabla[0].length; j++)
                System.out.printf("%s\t", tabla[i][j]);
            
            System.out.println();
        }
    }
}
