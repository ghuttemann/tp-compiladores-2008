/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

import analisis.Alfabeto;
import analisis.AnalizadorSintactico;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de prueba para la clase <code>Minimizacion</code>.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class MinimizacionTest {

    /**
     * Test of getAFDminimo method, of class Minimizacion.
     * @throws Exception 
     */
    @Test
    public void testGetAFDminimo() throws Exception {
        Alfabeto alfa = new Alfabeto("ab");
        String er = "(a|b)*abb";
        AnalizadorSintactico as = new AnalizadorSintactico(alfa, er);
        
        AFN afn = as.analizar();
        AFD afd = Subconjuntos.getAFD(afn);
        AFD afdMin = Minimizacion.getAFDminimo(afd);
        
        System.out.printf("AFD 1:\n%s", afd.toString());
        System.out.println();
        System.out.printf("AFD 2:\n%s", afdMin.toString());
        
        if (!afd.toString().equals(afdMin.toString()))
            fail("Los AFDs no coinciden...");
    }
}