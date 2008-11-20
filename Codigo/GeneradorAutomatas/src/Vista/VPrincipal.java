/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package Vista;

import analisis.Alfabeto;
import analisis.AnalizadorSintactico;
import estructuras.AFD;
import estructuras.AFDMin;
import estructuras.AFN;
import algoritmos.Minimizacion;
import algoritmos.Subconjuntos;
import estructuras.Configuracion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;

/**
 * Clase que representa la Ventana donde se cargar los datos del Analizador
 * y permite seleccionar las funcionalidades disponibles (AFN, AFD, Simulación).
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class VPrincipal extends javax.swing.JInternalFrame {

    /** 
     * Constructor Principal
     * @param config La configuración de directorios.
     */
    public VPrincipal(Configuracion config) {
        this.config = config;
        initComponents();
    }

    /** 
     * Este Metodo es el que inicializa todas los componentes a sus valores
     * iniciales.
     * Observación: Este metodo es modificado por el editor de formularios
     * de Netbeans.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Principal = new javax.swing.JPanel();
        Datos = new javax.swing.JPanel();
        Clases = new javax.swing.JComboBox();
        TAlfabeto = new javax.swing.JLabel();
        FPersonalizado = new javax.swing.JTextField();
        TPersonalizado = new javax.swing.JLabel();
        Procesar = new javax.swing.JButton();
        TERegular = new javax.swing.JLabel();
        FERegular = new javax.swing.JTextField();
        Procesos = new javax.swing.JPanel();
        BAFN = new javax.swing.JButton();
        BAFD = new javax.swing.JButton();
        BAFDmin = new javax.swing.JButton();
        BSimulacion = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(Vista.AplicacionAnalizadorLexico.class).getContext().getResourceMap(VPrincipal.class);
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N
        setNextFocusableComponent(Clases);

        Principal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        Principal.setName("Principal"); // NOI18N

        Datos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Requeridos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 12))); // NOI18N
        Datos.setFont(resourceMap.getFont("Datos.font")); // NOI18N
        Datos.setName("Datos"); // NOI18N

        Clases.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Personalizado", "[A-Z]", "[a-z]", "[0-9]" }));
        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(Vista.AplicacionAnalizadorLexico.class).getContext().getActionMap(VPrincipal.class, this);
        Clases.setAction(actionMap.get("ManejarClases")); // NOI18N
        Clases.setKeySelectionManager(null);
        Clases.setName("Clases"); // NOI18N
        Clases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClasesActionPerformed(evt);
            }
        });

        TAlfabeto.setBackground(resourceMap.getColor("TAlfabeto.background")); // NOI18N
        TAlfabeto.setFont(resourceMap.getFont("TAlfabeto.font")); // NOI18N
        TAlfabeto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TAlfabeto.setText(resourceMap.getString("TAlfabeto.text")); // NOI18N
        TAlfabeto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TAlfabeto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TAlfabeto.setInheritsPopupMenu(false);
        TAlfabeto.setName("TAlfabeto"); // NOI18N

        FPersonalizado.setMaximumSize(new java.awt.Dimension(5, 1));
        FPersonalizado.setMinimumSize(new java.awt.Dimension(2, 20));
        FPersonalizado.setName("FPersonalizado"); // NOI18N
        FPersonalizado.setSelectionEnd(10);

        TPersonalizado.setFont(resourceMap.getFont("TPersonalizado.font")); // NOI18N
        TPersonalizado.setText(resourceMap.getString("TPersonalizado.text")); // NOI18N
        TPersonalizado.setName("TPersonalizado"); // NOI18N

        Procesar.setAction(actionMap.get("procesarEntrada")); // NOI18N
        Procesar.setName("Procesar"); // NOI18N

        TERegular.setFont(resourceMap.getFont("TERegular.font")); // NOI18N
        TERegular.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TERegular.setText(resourceMap.getString("TERegular.text")); // NOI18N
        TERegular.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TERegular.setName("TERegular"); // NOI18N

        FERegular.setName("FERegular"); // NOI18N

        javax.swing.GroupLayout DatosLayout = new javax.swing.GroupLayout(Datos);
        Datos.setLayout(DatosLayout);
        DatosLayout.setHorizontalGroup(
            DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatosLayout.createSequentialGroup()
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DatosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Clases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(TPersonalizado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FPersonalizado, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DatosLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(FERegular, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DatosLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(Procesar)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addComponent(TAlfabeto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
            .addComponent(TERegular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );
        DatosLayout.setVerticalGroup(
            DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatosLayout.createSequentialGroup()
                .addComponent(TAlfabeto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Clases, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TPersonalizado)
                    .addComponent(FPersonalizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TERegular, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FERegular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Procesar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Procesos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Procesos del Análisis Léxico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 12))); // NOI18N
        Procesos.setName("Procesos"); // NOI18N

        BAFN.setAction(actionMap.get("procesarAFN")); // NOI18N
        BAFN.setEnabled(false);
        BAFN.setName("BAFN"); // NOI18N

        BAFD.setAction(actionMap.get("procesarAFD")); // NOI18N
        BAFD.setFont(resourceMap.getFont("BAFD.font")); // NOI18N
        BAFD.setText(resourceMap.getString("BAFD.text")); // NOI18N
        BAFD.setEnabled(false);
        BAFD.setName("BAFD"); // NOI18N

        BAFDmin.setAction(actionMap.get("procesarAFDmin")); // NOI18N
        BAFDmin.setText(resourceMap.getString("BAFDmin.text")); // NOI18N
        BAFDmin.setEnabled(false);
        BAFDmin.setName("BAFDmin"); // NOI18N

        BSimulacion.setAction(actionMap.get("procesarSimulacion")); // NOI18N
        BSimulacion.setEnabled(false);
        BSimulacion.setName("BSimulacion"); // NOI18N

        javax.swing.GroupLayout ProcesosLayout = new javax.swing.GroupLayout(Procesos);
        Procesos.setLayout(ProcesosLayout);
        ProcesosLayout.setHorizontalGroup(
            ProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProcesosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BAFN, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BAFD, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BAFDmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BSimulacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProcesosLayout.setVerticalGroup(
            ProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProcesosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BAFDmin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BAFD, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BAFN, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PrincipalLayout = new javax.swing.GroupLayout(Principal);
        Principal.setLayout(PrincipalLayout);
        PrincipalLayout.setHorizontalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(Procesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PrincipalLayout.setVerticalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Procesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
     * Metodo para la selección de Alfabetos Predefinidos
     */
private void ClasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClasesActionPerformed

    int index = this.Clases.getSelectedIndex();
    if (index == 1) {
        this.FPersonalizado.setText("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        this.FPersonalizado.setEnabled(false);
    } else if (index == 2) {
        this.FPersonalizado.setText("abcdefghijklmnopqrstuvwxyz");
        this.FPersonalizado.setEnabled(false);
    } else if (index == 3) {
        this.FPersonalizado.setText("0123456789");
        this.FPersonalizado.setEnabled(false);
    } else { //Personalizado
        this.FPersonalizado.setEnabled(true);
    }
}//GEN-LAST:event_ClasesActionPerformed

    /**
      * Función para realizar el control de la Entrada y ejecutar los algoritmos
      * del Analizador Léxico.
      * También deberá habilitar los Botones para mostrar los procesos.
      */
    @Action
    public void procesarEntrada() {

        // Controlar que se tenga completo los datos.
        boolean error = false;
        if (this.FERegular.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this.getDesktopPane(), "La Expresión Regular debe ser completada.");
            error = true;
        }
        if (this.FPersonalizado.isEnabled()) {
            
            if (this.FPersonalizado.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this.getDesktopPane(), "Se debe seleccionar un Alfabeto.");
                error = true;

            } else if (this.FPersonalizado.getText().length() > 26) {
                JOptionPane.showMessageDialog(this.getDesktopPane(), "El Alfabeto solo puede tener 26 caracteres.");
                error = true;
                
            } else if (!this.FPersonalizado.getText().matches("[a-zA-Z0-9]+")) {
                JOptionPane.showMessageDialog(this.getDesktopPane(), "El Alfabeto solo puede contener [a-z], [A-Z] ó [0-9].");
                error = true;                
            }
        }

        if (!error) {
            // Se Inicializa el Analizador Sintactico.
            String Abc = this.FPersonalizado.getText();
            String ERegular = this.FERegular.getText();
            
            Alfabeto abecedario = new Alfabeto(Abc);
            AnalizadorSintactico ASintactico = new AnalizadorSintactico(abecedario, ERegular);
            try {
                // Se procesa el AFN.
                miAFN = ASintactico.analizar();
                miAFN.setLogProceso(ASintactico.getLog().toString());
                
            } catch (Exception ex) {
                Logger.getLogger(VPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                String mensajeError = ex.getMessage();                
                JOptionPane.showMessageDialog(this.getDesktopPane(), "Ocurrio el siguiente error:\n"+mensajeError);
                error = true;
            }
            // Si hay error terminar
            if (error){
                return;
            } else {
                miAFD = Subconjuntos.getAFD(miAFN);
                miAFD.setLogProceso(Subconjuntos.getLog().toString());
                
                miAFDmin = Minimizacion.getAFDminimo(miAFD);
                miAFDmin.getAfdPostIdentidades().setLogProceso(Minimizacion.getLog().toString());
            }
            
            // Habilitamos los Botones para mostrar los Procesos.
            this.BAFN.setEnabled(true);
            this.BAFD.setEnabled(true);
            this.BAFDmin.setEnabled(true);
            this.BSimulacion.setEnabled(true);
        }
    }

    /**
     * Función para procesar el AFN y mostrar la Ventana con sus Datos
     * correspondientes.
     */
    @Action
    public void procesarAFN() {
        VAutomatas VAFN = new VAutomatas(config);
        VAFN.setAF(miAFN);
        String titulo = new String("AFN para Proyecto: \"".concat(this.getTitle().concat("\"")));
        VAFN.setTitle(titulo);
        VAFN.setProyecto(this.getTitle());
        
        this.getDesktopPane().add(VAFN, javax.swing.JLayeredPane.DEFAULT_LAYER);
        this.getDesktopPane().moveToFront(VAFN);
        this.transferFocus();
        VAFN.setVisible(true);
    }

    /**
     * Función para procesar el AFD y mostrar la Ventana con sus Datos
     * correspondientes.
     */
    @Action
    public void procesarAFD() {
        VAutomatas VAFD = new VAutomatas(config);
        VAFD.setAF(miAFD);
        String titulo = new String("AFD para Proyecto: \"".concat(this.getTitle().concat("\"")));
        VAFD.setTitle(titulo);
        VAFD.setProyecto(this.getTitle());
        
        this.getDesktopPane().add(VAFD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        this.getDesktopPane().moveToFront(VAFD);
        VAFD.setVisible(true);
    }

    /**
     * Función para procesar el AFD Mínimo y mostrar la Ventana con sus Datos
     * correspondientes.
     */
    @Action
    public void procesarAFDmin() {
        VAutomatas VAFDmin = new VAutomatas(config);
        VAFDmin.setAF(miAFDmin.getAfdPostMinimizacion());
        String titulo = new String("AFD Mínimo para Proyecto: \"".concat(this.getTitle().concat("\"")));
        VAFDmin.setTitle(titulo);
        VAFDmin.setProyecto(this.getTitle());
        
        this.getDesktopPane().add(VAFDmin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        this.getDesktopPane().moveToFront(VAFDmin);
        VAFDmin.setVisible(true);
    }
    
    /**
     * Función para procesar el AFD Mínimo y Generar la Simulación de su
     * representación Gráfica, con expresiones regulares ingresadas.
     */
    @Action
    public void procesarSimulacion() {
        VSimulador VAFDmin = new VSimulador();
        String titulo = new String("AFD Mínimo Simulado para Proyecto: \"".concat(this.getTitle().concat("\"")));
        VAFDmin.setTitle(titulo);
        
        this.getDesktopPane().add(VAFDmin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        this.getDesktopPane().moveToFront(VAFDmin);
        VAFDmin.setVisible(true);

    }
    
    
    /*
     * Sección de Variables del Programa.
     */
    private AFN miAFN;
    private AFD miAFD;
    private AFDMin miAFDmin;
    private Configuracion config;

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAFD;
    private javax.swing.JButton BAFDmin;
    private javax.swing.JButton BAFN;
    private javax.swing.JButton BSimulacion;
    private javax.swing.JComboBox Clases;
    private javax.swing.JPanel Datos;
    private javax.swing.JTextField FERegular;
    private javax.swing.JTextField FPersonalizado;
    private javax.swing.JPanel Principal;
    private javax.swing.JButton Procesar;
    private javax.swing.JPanel Procesos;
    private javax.swing.JLabel TAlfabeto;
    private javax.swing.JLabel TERegular;
    private javax.swing.JLabel TPersonalizado;
    // End of variables declaration//GEN-END:variables
}
