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
        
        AFN afn = as.analizar();
        System.out.printf("AFN:\n%s", afn);
        
        /* Tabla transicion del AFN */
        System.out.println();
        Object[][] tabla1 = afn.getTablaTransicion();
        for (int i=0; i < tabla1.length; i++) {
            for (int j=0; j < tabla1[0].length; j++)
                System.out.printf("%s\t", tabla1[i][j]);
            
            System.out.println();
        }
        
        /* AFD + estadosD */
        System.out.println();
        AFD afd = Subconjuntos.getAFD(afn);
        System.out.printf("AFD:\n%s", afd);
        System.out.printf("\nEstadosD:\n%s", afd.estadosDtoString());
        
        /* Tabla transicion del AFD */
        System.out.println();
        Object[][] tabla2 = afd.getTablaTransicion();
        for (int i=0; i < tabla2.length; i++) {
            for (int j=0; j < tabla2[0].length; j++)
                System.out.printf("%s\t", tabla2[i][j]);
            
            System.out.println();
        }
    }
}