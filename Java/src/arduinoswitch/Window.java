package arduinoswitch;

import Arduino.Arduino;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Antony García Gonzáles, from Panama Hitek Creative Team
 * 
 * Este ejemplo le da dfuncionalidad a un sencillo ejemplo para encender o apagar un LED
 * conectado a Arduino al presionar uno de los dos botones de la interfaz gráfica.
 */

public class Window extends javax.swing.JFrame {
//Se instancia la Librería Arduino

    Arduino Arduino = new Arduino();

    public Window() {
        initComponents();
//Se inicia la conexión con Arduino para transmisión de datos
        try {
            Arduino.ArduinoTX("COM10", 2000, 9600);

        } catch (Exception ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonEncender = new javax.swing.JButton();
        jButtonApagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jButtonEncender.setBackground(new java.awt.Color(255, 204, 51));
        jButtonEncender.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButtonEncender.setForeground(new java.awt.Color(255, 102, 0));
        jButtonEncender.setText("Encender");
        jButtonEncender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncenderActionPerformed(evt);
            }
        });

        jButtonApagar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonApagar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButtonApagar.setForeground(new java.awt.Color(255, 102, 0));
        jButtonApagar.setText("Apagar");
        jButtonApagar.setEnabled(false);
        jButtonApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonEncender, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonApagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButtonEncender)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonApagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEncenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncenderActionPerformed

        //Se modifica la interface gráfica del botón precionado
        jButtonEncender.setEnabled(false);
        jButtonApagar.setEnabled(true);
        Color c;
        c = new Color(255, 204, 51);
        jButtonApagar.setBackground(c);
        c = new Color(204, 204, 204);
        jButtonEncender.setBackground(c);

        //Se envían un -1- para encender el LED
        try {
            Arduino.SendData("1");
        } catch (Exception ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonEncenderActionPerformed

    private void jButtonApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarActionPerformed

        //Se modifica la interface gráfica del botón precionado
        jButtonEncender.setEnabled(true);
        jButtonApagar.setEnabled(false);
        Color c;
        c = new Color(255, 204, 51);
        jButtonEncender.setBackground(c);
        c = new Color(204, 204, 204);
        jButtonApagar.setBackground(c);

        //Se envía un -0- para apagar el LED
        try {
            Arduino.SendData("0");
        } catch (Exception ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonApagarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApagar;
    private javax.swing.JButton jButtonEncender;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
