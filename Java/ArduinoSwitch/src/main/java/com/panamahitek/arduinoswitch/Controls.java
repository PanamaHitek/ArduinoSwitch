package com.panamahitek.arduinoswitch;

import java.awt.Color;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 *
 * @author Antony García González, del Equipo Creativo de Panama Hitek
 * Visita http://panamahitek.com
 */
public class Controls {

    public void enableButton(JButton boton) {
        boton.setEnabled(true);
        boton.setBackground(new Color(255, 204, 51));

    }

    public void disableButton(JButton boton) {
        boton.setEnabled(false);
        boton.setBackground(new Color(204, 204, 204));
    }

    public void disableConnectionPanel(JButton boton, JComboBox combo) {
        combo.setEnabled(false);
        boton.setEnabled(false);
    }

    public void enableConnectionPanel(JButton boton, JComboBox combo) {
        combo.setEnabled(true);
        boton.setEnabled(true);
    }
    
    public void goToURL(String URL){
           if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                try {
                    java.net.URI uri = new java.net.URI(URL);
                    desktop.browse(uri);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(Acerca.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Acerca.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
