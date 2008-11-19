/*
 * Trabajo Práctico de Compiladores 2008.
 * Analizador Léxico.
 * Archivo: VAFN.java
 * Creado el 8 de noviembre de 2008, 08:09 PM
 */
package Vista;

import analisis.Alfabeto;
import generacion.AFD;
import generacion.AFN;
import generacion.Automata;
import generacion.Conjunto;
import generacion.Estado;
import algoritmos.ResultadoValidacion;
import generacion.TablaTransicion;
import generacion.Transicion;
import algoritmos.Validacion;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.jdesktop.application.Action;

/**
 * Clase que representa la Ventana que muestra y administra los Distintos 
 * Automatas del Programa.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class VAutomatas extends javax.swing.JInternalFrame {

    /** 
     * Constructor Principal
     */
    public VAutomatas() {
        initComponents();
    }

    /** Este Metodo es el que inicializa todas los componentes a sus valores
     *  iniciales.
     *  Observación: Este metodo es modificado por el editor de formularios
     *  de Netbeans.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        CPestañas = new javax.swing.JTabbedPane();
        Pestaña1 = new javax.swing.JPanel();
        CTTransicion = new javax.swing.JScrollPane();
        TTransicion = new javax.swing.JTable();
        CVerificación = new javax.swing.JPanel();
        EVerificar = new javax.swing.JLabel();
        TextoaVerificar = new javax.swing.JTextField();
        BVerificar = new javax.swing.JToggleButton();
        EResultado = new javax.swing.JLabel();
        ScrollResultados = new javax.swing.JScrollPane();
        TextResultado = new javax.swing.JTextArea();
        Pestaña2 = new javax.swing.JScrollPane();
        Imagen = new javax.swing.JLabel();
        Pestaña3 = new javax.swing.JSplitPane();
        CTTransicion1 = new javax.swing.JScrollPane();
        TTransicion1 = new javax.swing.JTable();
        CConsola = new javax.swing.JScrollPane();
        Consola = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(Vista.AplicacionAnalizadorLexico.class).getContext().getResourceMap(VAutomatas.class);
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        CPestañas.setAutoscrolls(true);
        CPestañas.setName("CPestañas"); // NOI18N

        Pestaña1.setName("Pestaña1"); // NOI18N

        CTTransicion.setAutoscrolls(true);
        CTTransicion.setName("CTTransicion"); // NOI18N

        TTransicion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Estados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TTransicion.setMaximumSize(new java.awt.Dimension(50, 100));
        TTransicion.setMinimumSize(new java.awt.Dimension(15, 10));
        TTransicion.setName("TTransicion"); // NOI18N
        TTransicion.setPreferredSize(new java.awt.Dimension(55, 30));
        TTransicion.setRowSelectionAllowed(false);
        TTransicion.getTableHeader().setReorderingAllowed(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, CTTransicion, org.jdesktop.beansbinding.ELProperty.create("0"), TTransicion, org.jdesktop.beansbinding.BeanProperty.create("autoResizeMode"), "R");
        bindingGroup.addBinding(binding);

        CTTransicion.setViewportView(TTransicion);
        TTransicion.getColumnModel().getColumn(0).setResizable(false);
        TTransicion.getColumnModel().getColumn(0).setPreferredWidth(57);
        TTransicion.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("TTransicion.columnModel.title0")); // NOI18N

        CVerificación.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("CVerificación.border.title"), javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP)); // NOI18N
        CVerificación.setName("CVerificación"); // NOI18N

        EVerificar.setText(resourceMap.getString("EVerificar.text")); // NOI18N
        EVerificar.setName("EVerificar"); // NOI18N

        TextoaVerificar.setText(resourceMap.getString("TextoaVerificar.text")); // NOI18N
        TextoaVerificar.setName("TextoaVerificar"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(Vista.AplicacionAnalizadorLexico.class).getContext().getActionMap(VAutomatas.class, this);
        BVerificar.setAction(actionMap.get("Verificacion")); // NOI18N
        BVerificar.setText(resourceMap.getString("BVerificar.text")); // NOI18N
        BVerificar.setName("BVerificar"); // NOI18N

        EResultado.setText(resourceMap.getString("EResultado.text")); // NOI18N
        EResultado.setName("EResultado"); // NOI18N

        ScrollResultados.setName("ScrollResultados"); // NOI18N

        TextResultado.setColumns(20);
        TextResultado.setEditable(false);
        TextResultado.setFont(resourceMap.getFont("TextResultado.font")); // NOI18N
        TextResultado.setRows(5);
        TextResultado.setName("TextResultado"); // NOI18N
        ScrollResultados.setViewportView(TextResultado);

        javax.swing.GroupLayout CVerificaciónLayout = new javax.swing.GroupLayout(CVerificación);
        CVerificación.setLayout(CVerificaciónLayout);
        CVerificaciónLayout.setHorizontalGroup(
            CVerificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CVerificaciónLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CVerificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CVerificaciónLayout.createSequentialGroup()
                        .addGroup(CVerificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CVerificaciónLayout.createSequentialGroup()
                                .addComponent(EVerificar)
                                .addGap(4, 4, 4)
                                .addComponent(TextoaVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CVerificaciónLayout.createSequentialGroup()
                                .addComponent(BVerificar)
                                .addGap(47, 47, 47)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ScrollResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CVerificaciónLayout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(EResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(251, 251, 251))))
        );
        CVerificaciónLayout.setVerticalGroup(
            CVerificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CVerificaciónLayout.createSequentialGroup()
                .addComponent(EResultado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CVerificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CVerificaciónLayout.createSequentialGroup()
                        .addGroup(CVerificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextoaVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EVerificar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BVerificar))
                    .addComponent(ScrollResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout Pestaña1Layout = new javax.swing.GroupLayout(Pestaña1);
        Pestaña1.setLayout(Pestaña1Layout);
        Pestaña1Layout.setHorizontalGroup(
            Pestaña1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pestaña1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CVerificación, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(CTTransicion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
        );
        Pestaña1Layout.setVerticalGroup(
            Pestaña1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pestaña1Layout.createSequentialGroup()
                .addComponent(CTTransicion, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CVerificación, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        CPestañas.addTab(resourceMap.getString("Pestaña1.TabConstraints.tabTitle"), Pestaña1); // NOI18N

        Pestaña2.setBackground(resourceMap.getColor("Pestaña2.background")); // NOI18N
        Pestaña2.setName("Pestaña2"); // NOI18N

        Imagen.setIcon(resourceMap.getIcon("Imagen.icon")); // NOI18N
        Imagen.setText(resourceMap.getString("Imagen.text")); // NOI18N
        Imagen.setName("Imagen"); // NOI18N
        Pestaña2.setViewportView(Imagen);

        CPestañas.addTab(resourceMap.getString("Pestaña2.TabConstraints.tabTitle"), Pestaña2); // NOI18N

        Pestaña3.setDividerLocation(200);
        Pestaña3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        Pestaña3.setName("Pestaña3"); // NOI18N

        CTTransicion1.setAutoscrolls(true);
        CTTransicion1.setName("CTTransicion1"); // NOI18N

        TTransicion1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Estados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TTransicion1.setMaximumSize(new java.awt.Dimension(50, 100));
        TTransicion1.setMinimumSize(new java.awt.Dimension(15, 10));
        TTransicion1.setName("TTransicion1"); // NOI18N
        TTransicion1.setPreferredSize(new java.awt.Dimension(55, 30));
        TTransicion1.setRowSelectionAllowed(false);
        TTransicion1.getTableHeader().setReorderingAllowed(false);
        CTTransicion1.setViewportView(TTransicion1);
        TTransicion1.getColumnModel().getColumn(0).setResizable(false);
        TTransicion1.getColumnModel().getColumn(0).setPreferredWidth(57);
        TTransicion1.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("TTransicion.columnModel.title0")); // NOI18N

        Pestaña3.setLeftComponent(CTTransicion1);

        CConsola.setName("CConsola"); // NOI18N

        Consola.setColumns(20);
        Consola.setRows(5);
        Consola.setName("Consola"); // NOI18N
        CConsola.setViewportView(Consola);

        Pestaña3.setBottomComponent(CConsola);

        CPestañas.addTab(resourceMap.getString("Pestaña3.TabConstraints.tabTitle"), Pestaña3); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CPestañas, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CPestañas, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
     * Función para Completar la tabla de Transición cada vez que la ventana
     * correspondiente se Active.
     * @param evt
     */
private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

    /* Se obtiene la tabla de transición del Automata */
    TablaTransicion tabla = AF.getTablaTransicion();
    TTransicion = new JTable(tabla);

    /* Configuración Necesaria para el Contenedor de la Tabla de Transicion */
    //CTTransicion.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    //CTTransicion.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    //CTTransicion.setAutoscrolls(true);
    CTTransicion.setViewportView(TTransicion);

    /* Configuración necesario para la Tabla de Transición */
    TTransicion.setRowHeight(15);
    TTransicion.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    /* Se calcula la longitud maxima en la primera columna */
    int max = 18; // Tamaño correspondiente al header
    for (int i = 0; i < AF.cantidadEstados(); i++) {
        Object val = TTransicion.getModel().getValueAt(i, 0);
        max = max < val.toString().length() ? val.toString().length() : max;
    }

    /* Se asigna el ancho a cantidad de letras*5 (correspondientes pixeles) */
    TTransicion.getColumnModel().getColumn(0).setMaxWidth(max * 20);
    TTransicion.getColumnModel().getColumn(0).setPreferredWidth(max * 5);
    TTransicion.updateUI();

    /* Se carga tambíen para la pestaña procesos */
    TTransicion1 = new JTable(TTransicion.getModel(), TTransicion.getColumnModel());
    TTransicion1.setRowHeight(15);
    TTransicion1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    TTransicion1.getColumnModel().getColumn(0).setMaxWidth(max * 20);
    TTransicion1.getColumnModel().getColumn(0).setPreferredWidth(max * 5);
    CTTransicion1.setViewportView(TTransicion1);
    TTransicion1.updateUI();

    /* Finalmente se generan las imagenes */
    ManejarImagen();
}//GEN-LAST:event_formInternalFrameActivated


    /**
     * Función para Manejar el Boton BVerificar
     */
    @Action
    public void Verificacion() {
        String valor = TextoaVerificar.getText();
        if (valor != null && valor.length() > 0) {

            // TODO Verificar cadena con el Automata correspondiente
            ResultadoValidacion Result = null;
            if (AFN.class.isInstance(this.AF)) {
                Result = Validacion.validarAFN((AFN) this.AF, valor);
            } else if (AFD.class.isInstance(this.AF)) {
                Result = Validacion.validarAFD((AFD) this.AF, valor);
            }
            String mensaje = null;
            if (!Result.esValido()) {
                mensaje = "ERROR: La cadena ingresada no es válida. Debido a que:\n";
                String Resto = Result.getEntradaFaltante();
                if (!Resto.isEmpty()) {
                    mensaje += "- Se recorrió " + Result.getCamino() + " y no se " +
                            "puede abanzar. Falta Evaluar: " + Resto + "\n";
                } else {
                    mensaje += "- Se recorrió " + Result.getCamino() + " y se terminó" +
                            " la cadena de entrada sin llegar a un estado Final. \n";
                }
                mensaje += "---\n";
            } else {
                mensaje = "OK. La cadena es Aceptada.\n Se recorrio " +
                        Result.getCamino();
            }
            TextResultado.setText("" + mensaje);

        } else {

            String mensajeError = new String("Debe completar el Campo de Texto " +
                    "correspondiente a la Expresión a Verificar.");
            JOptionPane.showMessageDialog(this.getDesktopPane(), "Ocurrio el " +
                    "siguiente error:\n" + mensajeError);
        }
    }

    /*
     * Función para Generar y cargar la Imagen del Automata correspondiente.
     * @param evt
     */
    private void ManejarImagen(){
        
        /* Paso 1. Crear Archivo de Salida  */
        Random r = new Random();
        r.nextInt(100);
        String rand = ""+r.nextInt(100);
        String salidaDot = ubicacion.concat(proyecto).concat(rand);
        salidaDot += ".dot";
        GrafoToDot(salidaDot);

        /* Paso 2. Crear la Imagen */
        String dibujo = ubicacion.concat(proyecto).concat(rand);
        dibujo +=".png";
        
        try {
            ejecutarDotExe(exeFile, salidaDot, dibujo);
        } catch (IOException ex) {
            Logger.getLogger(VAutomatas.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Paso 3. Cargar la imagen en la Ventana */
        this.Imagen.setIcon(new ImageIcon(dibujo));
    }
    
    /**
     * Paso 1 para el Manejo de Imagenes (Crear Archivo de Salida).
     * @param salidaDot
     */
    private void GrafoToDot(String salidaDot){
        PrintWriter dotWriter = null;
        try {
            dotWriter = new PrintWriter(new File(salidaDot), new String("ISO-8859-1"));
        } catch (IOException ex) {
            Logger.getLogger(VAutomatas.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Paso 1.1. Escribir Cabecera  */
        String nombre = "\"".concat(this.getProyecto()+"\"");
        int longitud = AF.cantidadEstados();
        if (longitud > 2)
            longitud--;
        dotWriter.print("digraph " + nombre + "{\n");
        dotWriter.print("\trankdir=LR;\n");
        dotWriter.print("\tsize=\""+longitud+",5\"\n");
        dotWriter.print("\toverlap=\"scale\"\n");
        /* Paso 1.2. Escribir los Nodos Finales */
        dotWriter.print("\tnode [shape = doublecircle];");

        Conjunto<Estado> finales = AF.getEstadosFinales();
        for (Estado e : finales) {
            dotWriter.print(" \"" + e+"\"");
        }
        dotWriter.print(";\n");

        /* Paso 1.3. Escribir los Nodos no Finales */
        dotWriter.print("\tnode [shape = circle];\n");
        Conjunto<Estado> todos = AF.getEstados();
        for (Estado e : todos) {
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
     * 
     * dot.exe works by taking *.dot file and piping 
     * results into another file, for example:
     * d:\graphviz-1.12\bin\dot.exe -Tgif c:\temp\ManualDraw.dot > c:\temp\ManualDraw.gif
     * so we follow that model here and read stdout until EOF
     */
    private void ejecutarDotExe(String exeFile, String dotFileName, String outFileName) throws IOException {

        final String exeCmd = "" + exeFile + " -Tpng"+ " "+ dotFileName;

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
        
    /**
     * Sección de Variables del Programa.
     */
    private Automata AF;
    private String proyecto = " ";
    private String ubicacion = new String("C:\\tmp\\");
    private String exeFile = new String("C:\\Program Files\\Graphviz 2.21\\bin\\dot.exe");

    public String getExeFile() {
        return exeFile;
    }

    public void setExeFile(String exeFile) {
        this.exeFile = exeFile;
    }
    
    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = new String(proyecto);
        this.proyecto.replaceAll(" ", "_");
    }

    /**
     * Obtiene el autómata.
     * @return El autómata asociado.
     */
    public Automata getAF() {
        return AF;
    }

    /**
     * Asigna valor correspondiente al autómata.
     * @param AF El nuevo autómata asociado.
     */
    public void setAF(Automata AF) {
        this.AF = AF;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BVerificar;
    private javax.swing.JScrollPane CConsola;
    private javax.swing.JTabbedPane CPestañas;
    private javax.swing.JScrollPane CTTransicion;
    private javax.swing.JScrollPane CTTransicion1;
    private javax.swing.JPanel CVerificación;
    private javax.swing.JTextArea Consola;
    private javax.swing.JLabel EResultado;
    private javax.swing.JLabel EVerificar;
    private javax.swing.JLabel Imagen;
    private javax.swing.JPanel Pestaña1;
    private javax.swing.JScrollPane Pestaña2;
    private javax.swing.JSplitPane Pestaña3;
    private javax.swing.JScrollPane ScrollResultados;
    private javax.swing.JTable TTransicion;
    private javax.swing.JTable TTransicion1;
    private javax.swing.JTextArea TextResultado;
    private javax.swing.JTextField TextoaVerificar;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
