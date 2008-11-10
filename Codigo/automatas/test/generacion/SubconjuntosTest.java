/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

import analisis.Alfabeto;
import analisis.AnalizadorSintactico;
import org.junit.Test;

/**
 * Clase de prueba para la clase <code>Subconjuntos</code>
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class SubconjuntosTest {
    
    /**
     * Test of getAFD method, of class Subconjuntos.
     * @throws Exception 
     */
    @Test
    public void testGetAFD() throws Exception {
        Alfabeto alfa = new Alfabeto("ab");
        String er = "a*b?(ab|ba)b?a*";
        AnalizadorSintactico as = new AnalizadorSintactico(alfa, er);
        
        Automata afn = as.analizar();
        System.out.printf("%s", afn);
        
        System.out.println();
        
        Automata afd = Subconjuntos.getAFD(afn);
        System.out.printf("%s", afd);
    }
}