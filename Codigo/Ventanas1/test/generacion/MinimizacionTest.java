/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generacion;

import analisis.Alfabeto;
import analisis.AnalizadorSintactico;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ghuttemann
 */
public class MinimizacionTest {

    /**
     * Test of getAFDminimo method, of class Minimizacion.
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