/*
 * Trabajo Práctico de Compiladores 2008.
 * Analizador Léxico.
 * Archivo: VAFN.java
 * Creado el 8 de noviembre de 2008, 08:09 PM
 */

package Vista;

import generacion.Automata;
import generacion.TablaTransicion;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * Ventana que muestra y administra los Distintos Automatas del Programa.
 * @author  mrodas
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
        TextaVerificar = new javax.swing.JTextField();
        BVerificar = new javax.swing.JToggleButton();
        EResultado = new javax.swing.JLabel();
        ScrollResultados = new javax.swing.JScrollPane();
        TextResultado = new javax.swing.JTextArea();
        Pestaña2 = new javax.swing.JScrollPane();

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

        CTTransicion.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        CTTransicion.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
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

        TextaVerificar.setText(resourceMap.getString("TextaVerificar.text")); // NOI18N
        TextaVerificar.setName("TextaVerificar"); // NOI18N

        BVerificar.setText(resourceMap.getString("BVerificar.text")); // NOI18N
        BVerificar.setName("BVerificar"); // NOI18N
        BVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BVerificarActionPerformed(evt);
            }
        });

        EResultado.setText(resourceMap.getString("EResultado.text")); // NOI18N
        EResultado.setName("EResultado"); // NOI18N

        ScrollResultados.setName("ScrollResultados"); // NOI18N

        TextResultado.setColumns(20);
        TextResultado.setRows(5);
        TextResultado.setName("TextResultado"); // NOI18N
        ScrollResultados.setViewportView(TextResultado);

        javax.swing.GroupLayout CVerificaciónLayout = new javax.swing.GroupLayout(CVerificación);
        CVerificación.setLayout(CVerificaciónLayout);
        CVerificaciónLayout.setHorizontalGroup(
            CVerificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CVerificaciónLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CVerificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EVerificar)
                    .addComponent(EResultado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CVerificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CVerificaciónLayout.createSequentialGroup()
                        .addComponent(TextaVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(BVerificar)
                        .addContainerGap(221, Short.MAX_VALUE))
                    .addComponent(ScrollResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)))
        );
        CVerificaciónLayout.setVerticalGroup(
            CVerificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CVerificaciónLayout.createSequentialGroup()
                .addGroup(CVerificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EVerificar)
                    .addComponent(TextaVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BVerificar))
                .addGroup(CVerificaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CVerificaciónLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(ScrollResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                    .addGroup(CVerificaciónLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(EResultado)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout Pestaña1Layout = new javax.swing.GroupLayout(Pestaña1);
        Pestaña1.setLayout(Pestaña1Layout);
        Pestaña1Layout.setHorizontalGroup(
            Pestaña1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pestaña1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pestaña1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pestaña1Layout.createSequentialGroup()
                        .addComponent(CVerificación, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(CTTransicion, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)))
        );
        Pestaña1Layout.setVerticalGroup(
            Pestaña1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pestaña1Layout.createSequentialGroup()
                .addComponent(CTTransicion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CVerificación, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CPestañas.addTab(resourceMap.getString("Pestaña1.TabConstraints.tabTitle"), Pestaña1); // NOI18N

        Pestaña2.setName("Pestaña2"); // NOI18N
        CPestañas.addTab(resourceMap.getString("Pestaña2.TabConstraints.tabTitle"), Pestaña2); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CPestañas, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CPestañas, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addGap(23, 23, 23))
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
    CTTransicion.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    CTTransicion.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    CTTransicion.setAutoscrolls(true);
    CTTransicion.setViewportView(TTransicion);
    
    /* Configuración necesario para la Tabla de Transición */
    TTransicion.setRowHeight(15);
    TTransicion.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    
    /* Se calcula la longitud maxima en la primera columna */
    int max =18; // Tamaño correspondiente al header
    for (int i=0; i <AF.cantidadEstados();i++) {
        Object val = TTransicion.getModel().getValueAt(i, 0);
        max = max<val.toString().length()? val.toString().length(): max;
    }   
    
    /* Se asigna el ancho a cantidad de letras*5 (correspondientes pixeles) */
    TTransicion.getColumnModel().getColumn(0).setMaxWidth(max*20);
    TTransicion.getColumnModel().getColumn(0).setPreferredWidth(max*5);
    TTransicion.updateUI();
}//GEN-LAST:event_formInternalFrameActivated

private void BVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVerificarActionPerformed
    String valor = TextaVerificar.getText();
    if ( valor != null && valor.length() > 0 ) {
        // TODO Verificar cadena con el Automata correspondiente
        
        /* Paso 1. Verificar Abecedario */
        
        /* Paso 2. Generar el Recorrido del valor en el AF */
        
        /* Paso 2.1. Calcular y escribir en el Area de Texto Resultado */
        
        /* Paso 2.2. Si hubo error mostrar el error*/
        
    } else {
        String mensajeError = new String ("Debe completar el Campo de Texto " +
                "correspondiente a la Expresión a Verificar.");
        JOptionPane.showMessageDialog(this.getDesktopPane(), "Ocurrio el siguiente error:\n"+mensajeError);
    }    
}//GEN-LAST:event_BVerificarActionPerformed


    /**
     * Sección de Variables del Programa.
     */
    private Automata AF;

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
    private javax.swing.JTabbedPane CPestañas;
    private javax.swing.JScrollPane CTTransicion;
    private javax.swing.JPanel CVerificación;
    private javax.swing.JLabel EResultado;
    private javax.swing.JLabel EVerificar;
    private javax.swing.JPanel Pestaña1;
    private javax.swing.JScrollPane Pestaña2;
    private javax.swing.JScrollPane ScrollResultados;
    private javax.swing.JTable TTransicion;
    private javax.swing.JTextArea TextResultado;
    private javax.swing.JTextField TextaVerificar;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
