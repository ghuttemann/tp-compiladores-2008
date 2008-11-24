/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package Vista;

import analisis.Alfabeto;
import estructuras.Automata;
import estructuras.Configuracion;
import estructuras.Conjunto;
import estructuras.Estado;
import estructuras.Transicion;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * Clase que representa la Ventana donde se cargar los datos del Analizador
 * y permite seleccionar las funcionalidades disponibles (AFN, AFD, Simulación).
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class Pintor {

    /* Automata a dibujar */
    private Automata AF;
    
    /* Nombre del proyecto para guardar las imagenes */
    private String proyecto;
    
    /* 
     * Configuración generales de parametros de ejecucion de dot y repositorio
     * de imagenes generadas
     */
    private Configuracion config;

    /**
     * Constructor Principal
     * @param AF
     * @param proyecto
     * @param config
     */
    public Pintor(Automata AF, String proyecto, Configuracion config) {
        this.AF = AF;
        this.proyecto = proyecto;
        this.config = config;
    }
    
    /*
     * Función para Generar y cargar la Imagen del Automata correspondiente.
     * @param e Estado que se debe pintar de rojo.
     */
    public ImageIcon ManejarImagen(Estado e) {
        
        /* Paso 1. Crear Archivo de Salida  */
        String marca = "" + System.currentTimeMillis();
        String salidaDot = config.getTempPath() + File.separator + proyecto.replace(" ", "");
        salidaDot +=  "-" + marca;
        salidaDot += ".dot";
        
        GrafoToDot(salidaDot, e);

        /* Paso 2. Crear la Imagen */        
        String dibujo = config.getTempPath() + File.separator + proyecto.replace(" ", "");
        dibujo += "-" + marca;
        dibujo += ".png";
        
        try {
            String exeFile = config.getGraphvizPath() + File.separator + "dot";
            ejecutarDotExe(exeFile, salidaDot, dibujo);
        } catch (IOException ex) {
            Logger.getLogger(VAutomatas.class.getName()).log(Level.SEVERE, null, ex); // TODO: Mostrar error
        }

        /* Paso 3. Cargar la imagen en la Ventana */
        return new ImageIcon(dibujo);
    }
    
    /**
     * Paso 1 para el Manejo de Imagenes (Crear Archivo de Salida).
     * @param salidaDot
     */
    private void GrafoToDot(String salidaDot, Estado actual){
        PrintWriter dotWriter = null;
        try {
            dotWriter = new PrintWriter(new File(salidaDot), new String("ISO-8859-1"));
        } catch (IOException ex) {
            Logger.getLogger(VAutomatas.class.getName()).log(Level.SEVERE, null, ex); // TODO: Mostrar error
        }
        
        /* Paso 1.1. Escribir Cabecera  */
        String nombre = "\"".concat(this.proyecto+"\"");
        int longitud = AF.cantidadEstados();
        if (longitud < 5)
            longitud = 5;
        
        dotWriter.print("digraph " + nombre + "{\n");
        dotWriter.print("\trankdir=LR;\n");
        dotWriter.print("\tsize=\""+longitud+",5\"\n");
        dotWriter.print("\toverlap=\"scale\";\n");

        String linea;
        for (Estado e : AF.getEstados()) {
            if (e.getEsFinal())
                linea = "\"" + e + "\"" + "[shape=doublecircle";
            else
                linea = "\"" + e + "\"" + "[shape=circle";
            
            if (e.equals(actual))
                linea += ", style=filled, fillcolor=red, color=red];\n";
            else
                linea += "];\n";
                
            dotWriter.print(linea);
        }
        
        /* Agregamos las transiciones */
        for (Estado e : AF.getEstados()) {
            String origen = e.toString();
            Conjunto<Transicion> transiciones = e.getTransiciones();
            for (Transicion t : transiciones) {
                String etiqueta = t.getSimbolo();
                
                if (etiqueta.equals(Alfabeto.VACIO))
                    etiqueta = "".concat("&epsilon;");
                
                dotWriter.print("\t\"" + origen + "\" -> \"" + t.getEstado() + "\" [ label = \"" +
                        etiqueta + "\" ];\n");
            }
        }
        dotWriter.println("}");
        dotWriter.close();        
    }

    /*
     * Paso 2 para el Manejo de Imagenes (Crear Imagen).
     */
    private void ejecutarDotExe(String exeFile, String dotFileName, String outFileName) throws IOException {

        final String exeCmd = exeFile + " -Tpng " + dotFileName;

        Process p = Runtime.getRuntime().exec(exeCmd);

        PrintStream ps = new PrintStream(outFileName);
        InputStream is = p.getInputStream();				
	byte[] buf = new byte[32 * 1024];
        int len;
        while (true) {
            len = is.read(buf);
            if (len <= 0){
                break;
            }
            ps.write(buf, 0, len);
        }        
        is.close();
        ps.close();
        p.destroy();
    }

}
