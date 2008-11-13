/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

import javax.swing.table.AbstractTableModel;

/**
 * Esta clase representa la tabla de transición
 * de estados de un Autómata, para ser mostrada
 * en un JTable.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class TablaTransicion extends AbstractTableModel {
    
    /**
     * Valores de la tabla de transiciones
     */
    private Object[][] valores;
    
    /**
     * Cabecera de la tabla de transiciones
     */
    private String[] cabecera;
    
    /**
     * 
     * @param cantFil
     * @param cantCol
     */
    public TablaTransicion(int cantFil, int cantCol) {
        valores  = new Object[cantFil][cantCol + 1];
        cabecera = new String[cantCol + 1];
    }

    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
