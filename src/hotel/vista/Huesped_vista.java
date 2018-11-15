/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.vista;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import AppPackage.AnimationClass;
import hotel.Conexion;
import hotel.modelo.Huesped;
import hotel.modelo.HuespedData;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang3.text.WordUtils;
public class Huesped_vista extends javax.swing.JFrame {

private HuespedData huespeddata;
private Conexion conexion;
private DefaultTableModel dataModel;
private  ArrayList <Huesped> listahuesped;

    public Huesped_vista() {
        initComponents();
        this.setLocationRelativeTo(null);
        conexion = new Conexion("jdbc:mysql://localhost/hotel", "root", "");
        huespeddata = new HuespedData(conexion);
        listahuesped = (ArrayList)huespeddata.obtenerHuesped();
        
        crearModeloDeTabla();
        setearContenidoDeTabla(listahuesped);

        MoveMouseListener mml = new MoveMouseListener(jPanel1);
        jPanel1.addMouseListener(mml);
        jPanel1.addMouseMotionListener(mml);
    }
    
    private void crearModeloDeTabla() {
        //guarda los nombres de las columnas en un array
        String col[] = {
            "DNI", 
            "Nombre", 
            "Domicilio", 
            "Celular", 
            "Correo"
        };

        //crea un modelo de tabla usando los nombres del array creado y 0 filas
        //sobreescribe el metodo isCellEditable para que retorne false en todas las celdas y no se puedan editar
        dataModel = new DefaultTableModel(col, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        //añade el modelo a la tabla
        tabla.setModel(dataModel);
    }

    private void setearContenidoDeTabla(ArrayList<Huesped> huespedes) {
        //se elimina todo el contenido de la tabla si es que hay
        for(int i = dataModel.getRowCount(); i > 0; i--) {
            dataModel.removeRow(i - 1);
        }

        //se inserta el contenido nuevo fila por fila
        for(Huesped h : listahuesped) {
            Object row[] = {
                h.getDni(), 
                h.getNombre(), 
                h.getDomicilio(),
                h.getCelular(),
                h.getCorreo()
            };

            dataModel.addRow(row);
        }
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
        jLabelOpciones = new javax.swing.JLabel();
        jLabelMinimizar = new javax.swing.JLabel();
        jLabelCancelar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        campoDNI = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelMenu = new javax.swing.JLabel();
        jLabelHabitacion = new javax.swing.JLabel();
        jLabelReserva = new javax.swing.JLabel();
        campoNombreYApellido = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        campoDomicilio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        campoCelular = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        campoCorreo = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        validacionCampoDNI = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelOpciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu.png"))); // NOI18N
        jLabelOpciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelOpciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelOpcionesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelOpcionesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelOpcionesMouseReleased(evt);
            }
        });
        jPanel1.add(jLabelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jLabelMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/minimize_1.png"))); // NOI18N
        jLabelMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinimizarMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 30, 30));

        jLabelCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png"))); // NOI18N
        jLabelCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        jPanel1.add(jLabelCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 30, 30));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setText("HUESPED");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("DNI");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 40, -1));

        campoDNI.setBackground(new java.awt.Color(255, 255, 255));
        campoDNI.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        campoDNI.setForeground(new java.awt.Color(0, 0, 0));
        campoDNI.setBorder(null);
        campoDNI.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoDNIFocusLost(evt);
            }
        });
        campoDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDNIActionPerformed(evt);
            }
        });
        jPanel2.add(campoDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 150, -1));

        tabla.setBackground(new java.awt.Color(255, 255, 255));
        tabla.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tabla.setForeground(new java.awt.Color(0, 0, 0));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.setGridColor(new java.awt.Color(51, 153, 255));
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 700, 130));

        jSeparator1.setBackground(new java.awt.Color(102, 204, 255));
        jSeparator1.setForeground(new java.awt.Color(102, 204, 255));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 150, 10));

        jLabelMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_ventana.png"))); // NOI18N
        jLabelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        jPanel2.add(jLabelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 10, -1, 30));

        jLabelHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/double-king_ventana.png"))); // NOI18N
        jLabelHabitacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        jPanel2.add(jLabelHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 60, 40, 30));

        jLabelReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/online-booking_ventana.png"))); // NOI18N
        jLabelReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        jPanel2.add(jLabelReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 100, -1, 40));

        campoNombreYApellido.setBackground(new java.awt.Color(255, 255, 255));
        campoNombreYApellido.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        campoNombreYApellido.setForeground(new java.awt.Color(0, 0, 0));
        campoNombreYApellido.setBorder(null);
        campoNombreYApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreYApellidoActionPerformed(evt);
            }
        });
        jPanel2.add(campoNombreYApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 220, -1));

        jSeparator2.setBackground(new java.awt.Color(102, 204, 255));
        jSeparator2.setForeground(new java.awt.Color(102, 204, 255));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 220, 10));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nombre y Apellido");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 130, -1));

        campoDomicilio.setBackground(new java.awt.Color(255, 255, 255));
        campoDomicilio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        campoDomicilio.setForeground(new java.awt.Color(0, 0, 0));
        campoDomicilio.setBorder(null);
        campoDomicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDomicilioActionPerformed(evt);
            }
        });
        jPanel2.add(campoDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 290, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Domicilio");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 70, -1));

        jSeparator3.setBackground(new java.awt.Color(102, 204, 255));
        jSeparator3.setForeground(new java.awt.Color(102, 204, 255));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 290, 10));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Celular");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 50, -1));

        campoCelular.setBackground(new java.awt.Color(255, 255, 255));
        campoCelular.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        campoCelular.setForeground(new java.awt.Color(0, 0, 0));
        campoCelular.setBorder(null);
        campoCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCelularActionPerformed(evt);
            }
        });
        jPanel2.add(campoCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 290, -1));

        jSeparator4.setBackground(new java.awt.Color(102, 204, 255));
        jSeparator4.setForeground(new java.awt.Color(102, 204, 255));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 290, 10));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Correo");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 50, -1));

        campoCorreo.setBackground(new java.awt.Color(255, 255, 255));
        campoCorreo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        campoCorreo.setForeground(new java.awt.Color(0, 0, 0));
        campoCorreo.setBorder(null);
        campoCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCorreoActionPerformed(evt);
            }
        });
        jPanel2.add(campoCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 290, -1));

        jSeparator5.setBackground(new java.awt.Color(102, 204, 255));
        jSeparator5.setForeground(new java.awt.Color(102, 204, 255));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 290, 10));

        btnModificar.setBackground(new java.awt.Color(255, 255, 255));
        btnModificar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setText("MODIFICAR");
        btnModificar.setBorder(null);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, -1, -1));

        validacionCampoDNI.setBackground(new java.awt.Color(255, 255, 255));
        validacionCampoDNI.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        validacionCampoDNI.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(validacionCampoDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 190, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 700, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDNIActionPerformed

    private void jLabelOpcionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelOpcionesMousePressed
        jLabelOpciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu_in.png")));
    }//GEN-LAST:event_jLabelOpcionesMousePressed

    private void jLabelOpcionesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelOpcionesMouseReleased
         jLabelOpciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu.png")));
    }//GEN-LAST:event_jLabelOpcionesMouseReleased

    private void jLabelOpcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelOpcionesMouseClicked
      
        
       AnimationClass menu =new AnimationClass();
       menu.jLabelXRight(-40, 10, 10, 5, jLabelMenu);
       
       
       //mueve el icono menu a la izquierda
       AnimationClass menuu =new AnimationClass();
       menuu.jLabelXLeft(10, -40, 10, 5, jLabelMenu);
        
       //mueve el icono habitacion a la izquierda
       AnimationClass habitacion =new AnimationClass();
       menu.jLabelXRight(-40, 10, 10, 5, jLabelHabitacion);
       
        
       //mueve el icono habitacion a la derecha
       AnimationClass habitacionn =new AnimationClass();
       menuu.jLabelXLeft(10, -40, 10, 5, jLabelHabitacion);

       
        //mueve el icono reserva a la izquieda
        AnimationClass reservaaa = new AnimationClass();
        reservaaa.jLabelXRight(-40, 10, 10, 5, jLabelReserva);
       
       //mueve el icono reserva a la derecha 
       AnimationClass reservaa = new AnimationClass();
        reservaa.jLabelXLeft(10, -40,10,5, jLabelReserva);
    }//GEN-LAST:event_jLabelOpcionesMouseClicked

    private void jLabelMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuMousePressed
         jLabelMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_ventana_in.png")));
    }//GEN-LAST:event_jLabelMenuMousePressed

    private void jLabelMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuMouseReleased
        jLabelMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_ventana.png")));
    }//GEN-LAST:event_jLabelMenuMouseReleased

    private void jLabelMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuMouseClicked
       Menu menu =new Menu();
       menu.setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabelMenuMouseClicked

    private void jLabelHabitacionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHabitacionMousePressed
      jLabelHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/double-king-size_in_ventana.png")));
    }//GEN-LAST:event_jLabelHabitacionMousePressed

    private void jLabelHabitacionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHabitacionMouseReleased
        jLabelHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/double-king_ventana.png")));
    }//GEN-LAST:event_jLabelHabitacionMouseReleased

    private void jLabelReservaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReservaMousePressed
       jLabelReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/online-booking_ventana_in.png")));
    }//GEN-LAST:event_jLabelReservaMousePressed

    private void jLabelReservaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReservaMouseReleased
        jLabelReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/online-booking_ventana.png")));
    }//GEN-LAST:event_jLabelReservaMouseReleased

    private void jLabelMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizarMouseClicked
        this.setState(Huesped_vista.ICONIFIED);
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

    private void jLabelHabitacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHabitacionMouseClicked
          
        Habitacion_vista habitacion =new Habitacion_vista();
      habitacion.setVisible(true);
       dispose(); 
    }//GEN-LAST:event_jLabelHabitacionMouseClicked

    private void jLabelReservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReservaMouseClicked
     Reserva_vista reserva=new Reserva_vista();
     reserva.setVisible(true);
     dispose();
    }//GEN-LAST:event_jLabelReservaMouseClicked

    private void campoNombreYApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreYApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreYApellidoActionPerformed

    private void campoDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDomicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDomicilioActionPerformed

    private void campoCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCelularActionPerformed

    private void campoCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCorreoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int dni;
        String nombre, direccion, celular, correo;
        
        try {
            dni = Integer.parseInt(campoDNI.getText());
            
            validacionCampoDNI.setText("");
        } catch(NumberFormatException e) {
            validacionCampoDNI.setText("Inserte un numero de DNI válido"); 
            
            return;
        }
        
        nombre = campoNombreYApellido.getText();
        direccion = campoDomicilio.getText();
        celular = campoCelular.getText();
        correo = campoCorreo.getText();
        
        Huesped h = new Huesped(dni, nombre, direccion, celular, correo);
        
        huespeddata.actualizarHuesped(h);
            
        listahuesped = (ArrayList)huespeddata.obtenerHuesped();
        setearContenidoDeTabla(listahuesped);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int dni;
        
        try {
            dni = Integer.parseInt(campoDNI.getText());
            
            validacionCampoDNI.setText("");
        } catch(NumberFormatException e) {
            validacionCampoDNI.setText("Inserte un numero de DNI válido"); 
            
            return;
        }
        
        huespeddata.borrarHuesped(dni);
        
        listahuesped = (ArrayList)huespeddata.obtenerHuesped();
        setearContenidoDeTabla(listahuesped);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMousePressed
        int dni;
        String nombre, celular, domicilio, correo;
        if(tabla.getSelectedRow() != -1) {
            int row = tabla.getSelectedRow();
        
            dni = (int) tabla.getValueAt(row, 0);
            nombre = (String) tabla.getValueAt(row, 1);
            domicilio = (String) tabla.getValueAt(row, 2);
            celular = (String) tabla.getValueAt(row, 3);
            correo = (String) tabla.getValueAt(row, 4);
            
            campoDNI.setText(Integer.toString(dni));
            campoNombreYApellido.setText(nombre);
            campoDomicilio.setText(domicilio);
            campoCelular.setText(celular);
            campoCorreo.setText(correo);    
            
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
        } else {
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }
    }//GEN-LAST:event_tablaMousePressed

    private void campoDNIFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDNIFocusLost
        int dni;
        
        //si el campo de dni contiene algun texto, el bloque de codigo dentro del if se ejecuta
        if(!campoDNI.getText().equals("")){
            //validacion del campo de dni
            try {
                dni = Integer.parseInt(campoDNI.getText());
            } catch(NumberFormatException e) {
                return;
            }
            
            
            //si el huesped existe se rellenan los campos relacionados a datos del huesped automaticamente
            if(huespeddata.existeHuesped(dni)) {
                Huesped huesped = huespeddata.buscarHuesped(dni);
                
                campoNombreYApellido.setText(huesped.getNombre());
                campoCelular.setText(huesped.getCelular());
                campoCorreo.setText(huesped.getCorreo());
                campoDomicilio.setText(huesped.getDomicilio());
                
                btnModificar.setEnabled(true);
                btnEliminar.setEnabled(true);
            } else {
                btnModificar.setEnabled(false);
                btnEliminar.setEnabled(false);
            }
        }
    }//GEN-LAST:event_campoDNIFocusLost

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
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Huesped_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Huesped_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Huesped_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Huesped_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Huesped_vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JTextField campoCelular;
    private javax.swing.JTextField campoCorreo;
    private javax.swing.JTextField campoDNI;
    private javax.swing.JTextField campoDomicilio;
    private javax.swing.JTextField campoNombreYApellido;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCancelar;
    private javax.swing.JLabel jLabelHabitacion;
    private javax.swing.JLabel jLabelMenu;
    private javax.swing.JLabel jLabelMinimizar;
    private javax.swing.JLabel jLabelOpciones;
    private javax.swing.JLabel jLabelReserva;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel validacionCampoDNI;
    // End of variables declaration//GEN-END:variables
}
