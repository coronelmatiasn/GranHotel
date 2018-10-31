/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.vista;

import AppPackage.AnimationClass;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author tinch
 */
public class Tipo_habitacion_tipo_cama_vista extends javax.swing.JFrame {

    /**
     * Creates new form Tipo_habitacion_tipo_cama_vista
     */
    public Tipo_habitacion_tipo_cama_vista() {
        initComponents();
        
        //esta sentencia lo que hace es que al largar la vista se centra en la pantalla.
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelOpcion = new javax.swing.JLabel();
        jLabelMinimizar = new javax.swing.JLabel();
        jLabelCancelar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelMenu = new javax.swing.JLabel();
        jLabelHuesped = new javax.swing.JLabel();
        jLabelHabitacion = new javax.swing.JLabel();
        jLabelReserva = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(700, 490));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelOpcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu.png"))); // NOI18N
        jLabelOpcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelOpcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelOpcionMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelOpcionMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelOpcionMouseReleased(evt);
            }
        });
        jPanel1.add(jLabelOpcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jLabelMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/minimize_1.png"))); // NOI18N
        jLabelMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinimizarMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 30, 30));

        jLabelCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png"))); // NOI18N
        jLabelCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCancelarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelCancelarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelCancelarMouseReleased(evt);
            }
        });
        jPanel1.add(jLabelCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 30, 30));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setText("Tipo Habitacion y Tipo Cama");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_ventana.png"))); // NOI18N
        jLabelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMenuMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelMenuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelMenuMouseReleased(evt);
            }
        });
        jPanel2.add(jLabelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 10, 30, 30));

        jLabelHuesped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guest_ventana.png"))); // NOI18N
        jLabelHuesped.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelHuesped.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHuespedMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelHuespedMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelHuespedMouseReleased(evt);
            }
        });
        jPanel2.add(jLabelHuesped, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 50, 30, 40));

        jLabelHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/double-king_ventana.png"))); // NOI18N
        jLabelHabitacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelHabitacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHabitacionMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelHabitacionMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelHabitacionMouseReleased(evt);
            }
        });
        jPanel2.add(jLabelHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 100, 30, 30));

        jLabelReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/online-booking_ventana.png"))); // NOI18N
        jLabelReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelReservaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelReservaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelReservaMouseReleased(evt);
            }
        });
        jPanel2.add(jLabelReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 140, 40, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 700, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizarMouseClicked
      this.setState(Habitacion_vista.ICONIFIED);
    }//GEN-LAST:event_jLabelMinimizarMouseClicked

    private void jLabelCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCancelarMousePressed
        
       jLabelCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel_in.png")));
        
        
    }//GEN-LAST:event_jLabelCancelarMousePressed

    private void jLabelCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCancelarMouseReleased
        jLabelCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png")));
    }//GEN-LAST:event_jLabelCancelarMouseReleased

    private void jLabelCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCancelarMouseClicked
       
        
        //creo un objeto Icon y le asigno la imagen del icono 
       Icon icono = new ImageIcon(getClass().getResource("/imagenes/logo_ventana.png"));
        
        int dialogoboton = JOptionPane.YES_NO_OPTION;
       int resultado = JOptionPane.showConfirmDialog(null, "Desea salir? ", "Salir",dialogoboton,JOptionPane.QUESTION_MESSAGE,icono);
       //utilizo el if para hacer una comparacion si el usuario da en si sale de la ventana y si le da no sigue trabajando 
       if (resultado==0){
           
          System.exit(0);
       }        
        
        
    }//GEN-LAST:event_jLabelCancelarMouseClicked

    private void jLabelOpcionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelOpcionMousePressed
       
        jLabelOpcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu_in.png")));
        
    }//GEN-LAST:event_jLabelOpcionMousePressed

    private void jLabelOpcionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelOpcionMouseReleased
        
       jLabelOpcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu.png"))); 
    }//GEN-LAST:event_jLabelOpcionMouseReleased

    private void jLabelOpcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelOpcionMouseClicked
      
         AnimationClass menu =new AnimationClass();
       menu.jLabelXRight(-40, 10, 10, 5, jLabelMenu);
       
       
       //mueve el icono menu a la izquierda
       AnimationClass menuu =new AnimationClass();
       menuu.jLabelXLeft(10, -40, 10, 5, jLabelMenu);
        
        //mueve el icono reserva a la izquieda
        AnimationClass reserva = new AnimationClass();
       reserva.jLabelXRight(-40, 10, 10, 5, jLabelReserva);
       
       //mueve el icono reserva a la derecha 
       AnimationClass reservaa = new AnimationClass();
       reservaa.jLabelXLeft(10, -40,10,5, jLabelReserva);
       
       //mueve el icono huesped a la derecha
       AnimationClass huesped =new AnimationClass();
       menu.jLabelXRight(-40, 10, 10, 5, jLabelHuesped);
       
       //mueve el icono huesped a la izquierda
       AnimationClass huespedd =new AnimationClass();
       menuu.jLabelXLeft(10, -40, 10, 5, jLabelHuesped);
       
       
         //mueve el icono habitacion a la izquierda
       AnimationClass habitacion =new AnimationClass();
       menu.jLabelXRight(-40, 10, 10, 5, jLabelHabitacion);
       
        
       //mueve el icono habitacion a la derecha
       AnimationClass habitacionn =new AnimationClass();
       menuu.jLabelXLeft(10, -40, 10, 5, jLabelHabitacion);
        
        
        
    }//GEN-LAST:event_jLabelOpcionMouseClicked

    private void jLabelMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuMousePressed
       
          jLabelMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_ventana_in.png")));
        
        
    }//GEN-LAST:event_jLabelMenuMousePressed

    private void jLabelMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuMouseReleased
        
        jLabelMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_ventana.png")));
        
        
    }//GEN-LAST:event_jLabelMenuMouseReleased

    private void jLabelHuespedMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHuespedMousePressed
       
         jLabelHuesped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guest_in_ventana.png")));
    }//GEN-LAST:event_jLabelHuespedMousePressed

    private void jLabelHuespedMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHuespedMouseReleased
        jLabelHuesped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guest_ventana.png")));
    }//GEN-LAST:event_jLabelHuespedMouseReleased

    private void jLabelReservaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReservaMousePressed
       jLabelReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/online-booking_ventana_in.png")));
    }//GEN-LAST:event_jLabelReservaMousePressed

    private void jLabelReservaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReservaMouseReleased
      jLabelReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/online-booking_ventana.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelReservaMouseReleased

    private void jLabelHabitacionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHabitacionMousePressed
        jLabelHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/double-king-size_in_ventana.png")));
    }//GEN-LAST:event_jLabelHabitacionMousePressed

    private void jLabelHabitacionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHabitacionMouseReleased
        jLabelHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/double-king_ventana.png")));
    }//GEN-LAST:event_jLabelHabitacionMouseReleased

    private void jLabelMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuMouseClicked
        Menu menu =new Menu();
       menu.setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabelMenuMouseClicked

    private void jLabelHuespedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHuespedMouseClicked
      
        
        Huesped_vista huesped =new Huesped_vista();
       huesped.setVisible(true);
       dispose();        
    }//GEN-LAST:event_jLabelHuespedMouseClicked

    private void jLabelHabitacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHabitacionMouseClicked
             
       
        Habitacion_vista habitacion =new Habitacion_vista();
      habitacion.setVisible(true);
       dispose(); 
    }//GEN-LAST:event_jLabelHabitacionMouseClicked

    private void jLabelReservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReservaMouseClicked
         //se crea un objeto de tio reserva vista para que luego al hacerle clik al boton cambia de pestaña   
     Reserva_vista reserva=new Reserva_vista();
     //hace visible la pestaña reserva vista
     reserva.setVisible(true);
     //cierra la ventana anterior
     dispose();
    }//GEN-LAST:event_jLabelReservaMouseClicked

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
            java.util.logging.Logger.getLogger(Tipo_habitacion_tipo_cama_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tipo_habitacion_tipo_cama_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tipo_habitacion_tipo_cama_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tipo_habitacion_tipo_cama_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tipo_habitacion_tipo_cama_vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCancelar;
    private javax.swing.JLabel jLabelHabitacion;
    private javax.swing.JLabel jLabelHuesped;
    private javax.swing.JLabel jLabelMenu;
    private javax.swing.JLabel jLabelMinimizar;
    private javax.swing.JLabel jLabelOpcion;
    private javax.swing.JLabel jLabelReserva;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
