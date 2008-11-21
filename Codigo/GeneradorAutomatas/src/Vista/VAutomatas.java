/*
 * Trabajo Práctico de Compiladores 2008.
 * Analizador Léxico.
 * Archivo: VAFN.java
 * Creado el 8 de noviembre de 2008, 08:09 PM
 */
package Vista;

import estructuras.AFD;
import estructuras.AFN;
import estructuras.Automata;
import algoritmos.ResultadoValidacion;
import estructuras.TablaTransicion;
import algoritmos.Validacion;
import estructuras.Configuracion;
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
     * @param config La configuración de directorios.
     */
    public VAutomatas(Configuracion config) {
        this.config = config;
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

        CPestanhas = new javax.swing.JTabbedPane();
        Pestanha1 = new javax.swing.JPanel();
        CTTransicion = new javax.swing.JScrollPane();
        TTransicion = new javax.swing.JTable();
        CVerificación = new javax.swing.JPanel();
        EVerificar = new javax.swing.JLabel();
        TextoaVerificar = new javax.swing.JTextField();
        BVerificar = new javax.swing.JToggleButton();
        EResultado = new javax.swing.JLabel();
        ScrollResultados = new javax.swing.JScrollPane();
        TextResultado = new javax.swing.JTextArea();
        BLimpiarValidacion = new javax.swing.JButton();
        Pestanha3 = new javax.swing.JSplitPane();
        CTTransicion1 = new javax.swing.JScrollPane();
        TTransicion1 = new javax.swing.JTable();
        CConsola = new javax.swing.JScrollPane();
        Consola = new javax.swing.JTextArea();
        Pestanha2 = new javax.swing.JScrollPane();
        Imagen = new javax.swing.JLabel();

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

        CPestanhas.setAutoscrolls(true);
        CPestanhas.setName("CPestanhas"); // NOI18N

        Pestanha1.setName("Pestanha1"); // NOI18N

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
        TextoaVerificar.setNextFocusableComponent(BVerificar);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(Vista.AplicacionAnalizadorLexico.class).getContext().getActionMap(VAutomatas.class, this);
        BVerificar.setAction(actionMap.get("Validacion")); // NOI18N
        BVerificar.setText(resourceMap.getString("BVerificar.text")); // NOI18N
        BVerificar.setName("BVerificar"); // NOI18N

        EResultado.setText(resourceMap.getString("EResultado.text")); // NOI18N
        EResultado.setName("EResultado"); // NOI18N

        ScrollResultados.setName("ScrollResultados"); // NOI18N

        TextResultado.setColumns(20);
        TextResultado.setEditable(false);
        TextResultado.setFont(resourceMap.getFont("TextResultado.font")); // NOI18N
        TextResultado.setLineWrap(true);
        TextResultado.setRows(5);
        TextResultado.setName("TextResultado"); // NOI18N
        ScrollResultados.setViewportView(TextResultado);

        BLimpiarValidacion.setAction(actionMap.get("LimpiarResultadoValidacion")); // NOI18N
        BLimpiarValidacion.setName("BLimpiarVerificacion"); // NOI18N

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
                                .addGroup(CVerificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BLimpiarValidacion, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                                    .addComponent(BVerificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(47, 47, 47)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ScrollResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
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
                        .addComponent(BVerificar)
                        .addGap(18, 18, 18)
                        .addComponent(BLimpiarValidacion))
                    .addComponent(ScrollResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout Pestanha1Layout = new javax.swing.GroupLayout(Pestanha1);
        Pestanha1.setLayout(Pestanha1Layout);
        Pestanha1Layout.setHorizontalGroup(
            Pestanha1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pestanha1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CVerificación, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(CTTransicion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
        );
        Pestanha1Layout.setVerticalGroup(
            Pestanha1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pestanha1Layout.createSequentialGroup()
                .addComponent(CTTransicion, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CVerificación, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        CVerificación.getAccessibleContext().setAccessibleName(resourceMap.getString("CVerificación.AccessibleContext.accessibleName")); // NOI18N

        CPestanhas.addTab(resourceMap.getString("Pestanha1.TabConstraints.tabTitle"), Pestanha1); // NOI18N

        Pestanha3.setDividerLocation(200);
        Pestanha3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        Pestanha3.setName("Pestanha3"); // NOI18N

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

        Pestanha3.setLeftComponent(CTTransicion1);

        CConsola.setName("CConsola"); // NOI18N

        Consola.setColumns(20);
        Consola.setEditable(false);
        Consola.setRows(5);
        Consola.setName("Consola"); // NOI18N
        CConsola.setViewportView(Consola);

        Pestanha3.setBottomComponent(CConsola);

        CPestanhas.addTab(resourceMap.getString("Pestanha3.TabConstraints.tabTitle"), Pestanha3); // NOI18N

        Pestanha2.setBackground(resourceMap.getColor("Pestanha2.background")); // NOI18N
        Pestanha2.setName("Pestanha2"); // NOI18N

        Imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Imagen.setIcon(resourceMap.getIcon("Imagen.icon")); // NOI18N
        Imagen.setText(resourceMap.getString("Imagen.text")); // NOI18N
        Imagen.setName("Imagen"); // NOI18N
        Pestanha2.setViewportView(Imagen);

        CPestanhas.addTab(resourceMap.getString("Pestanha2.TabConstraints.tabTitle"), Pestanha2); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CPestanhas, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CPestanhas, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
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

    /* Se carga la tabla tambíen para la pestaña procesos */
    TTransicion1 = new JTable(TTransicion.getModel(), TTransicion.getColumnModel());
    TTransicion1.setRowHeight(15);
    TTransicion1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    TTransicion1.getColumnModel().getColumn(0).setMaxWidth(max * 20);
    TTransicion1.getColumnModel().getColumn(0).setPreferredWidth(max * 5);
    CTTransicion1.setViewportView(TTransicion1);
    TTransicion1.updateUI();

    /* Finalmente se generan las imagenes */
    Pintor brocha = new Pintor(AF, proyecto, config);
    this.Imagen.setIcon(brocha.ManejarImagen(null));
    
    /* Se carga el proceso realizado por el Automata */
    Consola.setText(this.AF.getLogProceso());
}//GEN-LAST:event_formInternalFrameActivated


    /**
     * Función para Manejar el Boton BVerificar
     */
    @Action
    public void Validacion() {
        String valor = TextoaVerificar.getText();
        if (valor == null)
            valor = "";

        // Verificar cadena con el Automata correspondiente
        ResultadoValidacion Result = null;
        if (AFN.class.isInstance(this.AF)) {
            Result = Validacion.validarAFN((AFN) this.AF, valor);
        } else if (AFD.class.isInstance(this.AF)) {
            Result = Validacion.validarAFD((AFD) this.AF, valor);
        }
        String mensaje = null;
        if (!Result.esValido()) {
            mensaje = "ERROR: La cadena ingresada NO ES ACEPTADA.\n\n";
            String Resto = Result.getEntradaFaltante();
            if (!Resto.isEmpty()) {
                mensaje += "Se recorrió " + Result.getCamino() + " y no se " +
                        "pudo avanzar más. FALTÓ CONSUMIR: \"" + Resto + "\".";
            } else {
                mensaje += "Se recorrió " + Result.getCamino() + " y se consumió" +
                        " la cadena de entrada sin llegar a un ESTADO FINAL. \n";
            }
        } else {
            mensaje = "OK. La cadena es ACEPTADA.\nSe recorrio " + Result.getCamino();
        }
        TextResultado.setText("" + mensaje);
    }
        
    /**
     * Sección de Variables del Programa.
     */
    private Automata AF;
    private String proyecto;
    
    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = new String(proyecto);
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

    @Action
    public void LimpiarResultadoValidacion() {
        TextResultado.setText("");
    }
    
    /**
     * Variables adicionales
     */
    private Configuracion config;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BLimpiarValidacion;
    private javax.swing.JToggleButton BVerificar;
    private javax.swing.JScrollPane CConsola;
    private javax.swing.JTabbedPane CPestanhas;
    private javax.swing.JScrollPane CTTransicion;
    private javax.swing.JScrollPane CTTransicion1;
    private javax.swing.JPanel CVerificación;
    private javax.swing.JTextArea Consola;
    private javax.swing.JLabel EResultado;
    private javax.swing.JLabel EVerificar;
    private javax.swing.JLabel Imagen;
    private javax.swing.JPanel Pestanha1;
    private javax.swing.JScrollPane Pestanha2;
    private javax.swing.JSplitPane Pestanha3;
    private javax.swing.JScrollPane ScrollResultados;
    private javax.swing.JTable TTransicion;
    private javax.swing.JTable TTransicion1;
    private javax.swing.JTextArea TextResultado;
    private javax.swing.JTextField TextoaVerificar;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
