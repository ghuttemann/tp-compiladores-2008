/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

import estructuras.TablaTransicion;
import estructuras.AFD;
import estructuras.AFN;
import algoritmos.Subconjuntos;
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
        String er = "(a|b)*abb";
        AnalizadorSintactico as = new AnalizadorSintactico(alfa, er);
        
        AFN afn = as.analizar();
        System.out.printf("AFN:\n%s", afn);
        
        /* Cabecera de la Tabla transicion del AFN */
        System.out.println();
        TablaTransicion tabla1 = afn.getTablaTransicion();
        
        for (int i=0; i < tabla1.getColumnCount(); i++)
            System.out.printf("%s\t", tabla1.getColumnName(i));
        
        /* Datos de la Tabla transicion del AFN */
        System.out.println();
        for (int i=0; i < tabla1.getRowCount(); i++) {
            for (int j=0; j < tabla1.getColumnCount(); j++)
                System.out.printf("%s\t", tabla1.getValueAt(i, j));
            
            System.out.println();
        }
        
        /* AFD + estadosD */
        System.out.println();
        AFD afd = Subconjuntos.getAFD(afn);
        System.out.printf("AFD:\n%s", afd);
        System.out.printf("\nEstadosD:\n%s", afd.estadosDtoString());
        
        /* Tabla transicion del AFD */
        System.out.println();
        TablaTransicion tabla2 = afd.getTablaTransicion();
        
        for (int i=0; i < tabla2.getColumnCount(); i++)
            System.out.printf("%s\t\t", tabla2.getColumnName(i));
        
        System.out.println();
        for (int i=0; i < tabla2.getRowCount(); i++) {
            for (int j=0; j < tabla2.getColumnCount(); j++)
                System.out.printf("%s\t\t", tabla2.getValueAt(i, j));
            
            System.out.println();
        }
        
        System.out.printf("\nConjuntos estados producidos:\n%s", Subconjuntos.getLog());
    }
}