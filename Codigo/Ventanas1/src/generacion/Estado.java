/*
 * Trabajo Práctico de Compiladores 2008.
 * 10mo Semestre Ingeniería Infomática.
 * Facultad Politécnica - UNA.
 */
package generacion;

/**
 * Esta clase representa un estado para un Autómata Finito.
 * @author Germán Hüttemann
 * @author Marcelo Rodas
 */
public class Estado implements Comparable<Estado> {

    /**
     * Identificador de este Estado.
     */
    private int identificador;
    
    /**
     * Variable que indica si el Estado es final.
     */
    private boolean esFinal;
    
    /**
     * Etiqueta de este estado.
     */
    private String etiqueta;
    
    /**
     * Conjunto de transiciones del Estado.
     */
    private Conjunto<Transicion> transiciones;
    
    /**
     * Indica si este Estado ya fue visitado
     * durante algún recorrido realizado sobre
     * el Automata que contiene a este Estado.
     */
    private boolean visitado;
    
    /**
     * Crea un <code>Estado</code> no final con un identificador determinado.
     * @param identificador El identificador del nuevo estado.
     * @throws Exception Si <code>identificador</code> es negativo.
     */
    public Estado(int identificador) throws Exception {
        this(identificador, false);
    }
    
    /**
     * Crea un <code>Estado</code> con un identificador determinado, 
     * que será final o no de acuerdo al valor de <code>esFinal</code>.
     * @param identificador El identificador para este <code>Estado</code>.
     * @param esFinal Determina si el <code>Estado</code> es final o no.
     * @throws Exception Si <code>identificador</code> es negativo.
     */
    public Estado(int identificador, boolean esFinal) throws Exception {
        setIdentificador(identificador);
        setEsFinal(esFinal);
        setEtiqueta(String.valueOf(identificador));
        transiciones = new Conjunto<Transicion>();
    }
    
    /**
     * Establece un nuevo identificador para este <code>Estado</code>.
     * @param identificador El nuevo identificador para este <code>Estado</code>.
     * @throws Exception Si <code>identificador</code> es negativo.
     */
    public void setIdentificador(int identificador) throws Exception {
        if (identificador < 0)
            throw new Exception("El identificador de un Estado no puede ser negativo.");
        
        this.identificador = identificador;
    }
    
    /**
     * Obtiene el identificador para este <code>Estado</code>.
     * @return El identificador del <code>Estado</code>.
     */
    public int getIdentificador() {
        return identificador;
    }
    
    /**
     * Obtiene la etiqueta de este <code>Estado</code>.
     * @return Un objeto <code>String</code> representando
     * la etiqueta de este <code>Estado</code>.
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Establece una nueva etiqueta para este <code>Estado</code>.
     * @param etiqueta La nueva etiqueta para este <code>Estado</code>.
     */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    /**
     * Obtiene el estado de aceptación del <code>Estado</code>.
     * @return <code>true</code> si el <code>Estado</code> es final, 
     * <code>false</code> en caso contrario.
     */
    public boolean getEsFinal() {
        return esFinal;
    }

    /**
     * Establece un nuevo estado de aceptación para este <code>Estado</code>.
     * @param esFinal El nuevo estado de aceptación para este <code>Estado</code>.
     * Si el valor <code>true</code> el <code>Estado</code> se convertirá en
     * final, si es <code>false</code> el <code>Estado</code> se convertirá
     * en no final.
     */
    public void setEsFinal(boolean esFinal) {
        this.esFinal = esFinal;
    }
    
    /**
     * Obtiene el estado de inicio del <code>Estado</code>.
     * @return <code>true</code> si el <code>Estado</code> es inicial, 
     * <code>false</code> en caso contrario.
     */
    public boolean getEsInicial() {
        return identificador == 0;
    }
    
    /**
     * Obtiene el conjunto de transiciones de este <code>Estado</code>.
     * @return El conjunto de transiciones del <code>Estado</code>.
     */
    public Conjunto<Transicion> getTransiciones() {
        return transiciones;
    }
    
    /**
     * Obtiene es estado de visitado de este <code>Estado</code>.
     * @return <code>true</code> si este <code>Estado</code> ya 
     * ha sido visitado, <code>false</code> en caso contrario.
     */
    public boolean getVisitado() {
        return visitado;
    }
    
    /**
     * Establece el nuevo estado de visitado de este <code>Estado</code>.
     * @param visitado Nuevo estado de visitado de este <code>Estado</code>.
     */
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
    
    /**
     * Verifica si el <code>Estado</code> es un estado identidad.
     * @return <code>true</code> si este <code>Estado</code> es un 
     * estado identidad, <code>false</code> en caso contrario.
     */
    public boolean getEsIdentidad() {
        for (Transicion trans : getTransiciones())
            if (!this.equals(trans.getEstado()))
                return false;
        
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        
        if (getClass() != obj.getClass())
            return false;
        
        final Estado other = (Estado) obj;
        if (this.identificador == other.identificador)
            return true;
        
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.identificador;
        return hash;
    }

    public int compareTo(Estado obj) {
        return this.identificador - obj.identificador;
    }
    
    @Override
    public String toString() {
        String valor;
        
        if (getEtiqueta().equals(""))
            valor = String.valueOf(identificador);
        else
            valor = getEtiqueta();
        
        if (getEsInicial())
            valor += "i";
        
        if (getEsFinal())
            valor += "f";
                
        return valor;
    }
}
