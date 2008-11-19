/*
 * Ventanas1App.java
 */

package Vista;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class AplicacionAnalizadorLexico extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new VentanaRaiz(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of Ventanas1App
     */
    public static AplicacionAnalizadorLexico getApplication() {
        return Application.getInstance(AplicacionAnalizadorLexico.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(AplicacionAnalizadorLexico.class, args);
    }
}
