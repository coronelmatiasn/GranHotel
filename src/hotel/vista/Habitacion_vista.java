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
import hotel.modelo.Habitacion;
import hotel.modelo.HabitacionData;
import hotel.modelo.Reserva;
import hotel.modelo.TipoHabitacion;
import hotel.modelo.TipoHabitacionData;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;


public class Habitacion_vista extends javax.swing.JFrame {
private Conexion conexion;
private TipoHabitacionData tipohabitaciondata;
private HabitacionData habitaciondata;
private DefaultTableModel dataModel;
private ArrayList<Habitacion> habitaciones;
      
 
    public Habitacion_vista() {

        //esta sentencia lo que hace es que al largar la vista se centra en la pantalla.
        this.setLocationRelativeTo(null);
        
        try {
            //se crea una conexion del tipo Conexion donde se especifica la base donde se va a conectar.
            conexion = new Conexion("jdbc:mysql://localhost/hotel", "root", "");

        } catch (Exception e) {
            
           JOptionPane.showMessageDialog(null,"se produjo un error al conectar con la base de datos: " + e);
        } 
        //se crea un objeto de tipohabitacion data y se manda como parametro la conexion previamente creada.
        tipohabitaciondata = new TipoHabitacionData(conexion);
        //se crea un objeto de habitaciondata y tambien se manda como parametro la conexion previamente creada
        habitaciondata = new HabitacionData(conexion);
        habitaciones = habitaciondata.obtenerHabitaciones();
        
        initComponents();
        crearModeloDeTabla();
        setearContenidoDeTabla(this.habitaciones); 
        
        MoveMouseListener mml = new MoveMouseListener(jPanel1);
        jPanel1.addMouseListener(mml);
        jPanel1.addMouseMotionListener(mml);
    }
    
    private void crearModeloDeTabla() {
        //guarda los nombres de las columnas en un array
        String col[] = {
            "N°", 
            "Piso", 
            "Estado", 
            "Categoria", 
            "Precio", 
            "Camas"
        };

        //crea un modelo de tabla usando los nombres del array creado y 0 filas
        dataModel = new DefaultTableModel(col, 0);

        //añade el modelo a la tabla
        jTableHabitaciones.setModel(dataModel);
    }

    private void setearContenidoDeTabla(ArrayList<Habitacion> habitaciones) {
        //se elimina todo el contenido de la tabla si es que hay
        for(int i = dataModel.getRowCount(); i > 0; i--) {
            dataModel.removeRow(i - 1);
        }

        //se inserta el contenido nuevo fila por fila
        for(Habitacion h : habitaciones) {
            Object row[] = {
                h.getNHabitacion(), 
                h.getPiso(), 
                h.getEstado() ? "ocupada" : "desocupada",
                h.getTipoHabitacion().getCategoria(),
                h.getTipoHabitacion().getPrecioXNoche(),
                h.getTipoHabitacion().getTipoCama().getCategoria()
            };

            dataModel.addRow(row);
        }
    }
    
    public void filtrarHabitaciones() {
        ArrayList<Habitacion> fHabitaciones;
        String input = filterField.getText().toLowerCase();
        String estado = comboBoxEstado.getSelectedItem().toString();
        
        fHabitaciones = habitaciones;
        
        if(!estado.toLowerCase().equals("estado")) {
            if(estado.toLowerCase().equals("ocupada")) {
                fHabitaciones = (ArrayList) fHabitaciones.stream().filter(p -> p.getEstado()).collect(Collectors.toList());
            } else {
                fHabitaciones = (ArrayList) fHabitaciones.stream().filter(p -> !p.getEstado()).collect(Collectors.toList());
            }
        }

        if(!input.equals("")) {
            String rb = filterGroup.getSelection().getActionCommand().toLowerCase();
            
            switch(rb) {
                case "precio":      fHabitaciones = (ArrayList) fHabitaciones
                                        .stream()
                                        .filter(h -> Double.toString(h.getTipoHabitacion().getPrecioXNoche()).contains(input))
                                        .collect(Collectors.toList());
                                    break;
                                
                case "categoria":   fHabitaciones = (ArrayList) fHabitaciones
                                        .stream()
                                        .filter(h -> h.getTipoHabitacion().getCategoria().toLowerCase().contains(input))
                                        .collect(Collectors.toList());
                                    break;
                                    
                case "numero":      fHabitaciones = (ArrayList) fHabitaciones
                                        .stream()
                                        .filter(h -> Integer.toString(h.getNHabitacion()).contains(input))
                                        .collect(Collectors.toList());
                                    break;
                                    
                case "piso":        fHabitaciones = (ArrayList) fHabitaciones
                                        .stream()
                                        .filter(h -> Integer.toString(h.getPiso()).contains(input))
                                        .collect(Collectors.toList());
                                    break;
            }
        }
        
        setearContenidoDeTabla(fHabitaciones);
    }

    /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filterGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabelOpciones = new javax.swing.JLabel();
        jLabelMinimizar = new javax.swing.JLabel();
        jLabelCancelar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ArrayList<String> lCat = new ArrayList<>();
        lCat = tipohabitaciondata.obtenerCategorias();
        jComboBoxTipoHabitacion = new javax.swing.JComboBox(lCat.toArray());
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHabitaciones = new javax.swing.JTable();
        jLabelMenu = new javax.swing.JLabel();
        jLabelHuesped = new javax.swing.JLabel();
        jLabelReserva = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPiso = new javax.swing.JTextField();
        jTextFieldNumeroHabitacion = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnAgregarHabitacion = new javax.swing.JButton();
        filterField = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        rBPiso = new javax.swing.JRadioButton();
        rBPrecio1 = new javax.swing.JRadioButton();
        rBCategoria1 = new javax.swing.JRadioButton();
        rBNumero1 = new javax.swing.JRadioButton();
        comboBoxEstado = new javax.swing.JComboBox<>();

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
        jPanel1.add(jLabelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

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
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("HABITACIONES");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tipo De Habitacion");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        jComboBoxTipoHabitacion.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxTipoHabitacion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jComboBoxTipoHabitacion.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jComboBoxTipoHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 75, 140, -1));

        jTableHabitaciones.setBackground(new java.awt.Color(255, 255, 255));
        jTableHabitaciones.setForeground(new java.awt.Color(0, 0, 0));
        jTableHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableHabitaciones.setCellSelectionEnabled(true);
        jTableHabitaciones.setEnabled(false);
        jTableHabitaciones.setGridColor(new java.awt.Color(102, 204, 255));
        jTableHabitaciones.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableHabitaciones);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 700, 170));

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
        jPanel2.add(jLabelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 10, 40, 30));

        jLabelHuesped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guest_ventana.png"))); // NOI18N
        jLabelHuesped.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        jPanel2.add(jLabelReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 100, 40, 40));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Numero de Habitacion");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Piso");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, 20));

        jTextFieldPiso.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPiso.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextFieldPiso.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPiso.setBorder(null);
        jPanel2.add(jTextFieldPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 40, -1));

        jTextFieldNumeroHabitacion.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldNumeroHabitacion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextFieldNumeroHabitacion.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldNumeroHabitacion.setBorder(null);
        jPanel2.add(jTextFieldNumeroHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 50, -1));

        jSeparator1.setBackground(new java.awt.Color(102, 204, 255));
        jSeparator1.setForeground(new java.awt.Color(102, 204, 255));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 40, 10));

        jSeparator2.setBackground(new java.awt.Color(102, 204, 255));
        jSeparator2.setForeground(new java.awt.Color(102, 204, 255));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 50, 10));

        btnAgregarHabitacion.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarHabitacion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAgregarHabitacion.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarHabitacion.setText("AGREGAR HABITACION");
        btnAgregarHabitacion.setBorder(null);
        btnAgregarHabitacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarHabitacionActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, -1));

        filterField.setBackground(new java.awt.Color(255, 255, 255));
        filterField.setForeground(new java.awt.Color(0, 0, 0));
        filterField.setBorder(null);
        jPanel2.add(filterField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 70, -1));
        filterField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                filtrarHabitaciones();
            }
            public void removeUpdate(DocumentEvent e) {
                filtrarHabitaciones();
            }
            public void insertUpdate(DocumentEvent e) {
                filtrarHabitaciones();
            }
        });

        jSeparator3.setBackground(new java.awt.Color(102, 204, 255));
        jSeparator3.setForeground(new java.awt.Color(102, 204, 255));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 70, 10));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("FILTRAR:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        rBPiso.setBackground(new java.awt.Color(255, 255, 255));
        filterGroup.add(rBPiso);
        rBPiso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        rBPiso.setForeground(new java.awt.Color(0, 0, 0));
        rBPiso.setText("Piso");
        rBPiso.setToolTipText("");
        rBPiso.setActionCommand(rBPiso.getText());
        rBPiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBPisoActionPerformed(evt);
            }
        });
        jPanel2.add(rBPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, -1, -1));

        rBPrecio1.setBackground(new java.awt.Color(255, 255, 255));
        filterGroup.add(rBPrecio1);
        rBPrecio1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        rBPrecio1.setForeground(new java.awt.Color(0, 0, 0));
        rBPrecio1.setSelected(true);
        rBPrecio1.setText("Precio");
        rBPrecio1.setActionCommand(rBPrecio1.getText());
        rBPrecio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBPrecio1ActionPerformed(evt);
            }
        });
        jPanel2.add(rBPrecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));

        rBCategoria1.setBackground(new java.awt.Color(255, 255, 255));
        filterGroup.add(rBCategoria1);
        rBCategoria1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        rBCategoria1.setForeground(new java.awt.Color(0, 0, 0));
        rBCategoria1.setText("Categoria");
        rBCategoria1.setToolTipText("");
        rBCategoria1.setActionCommand(rBCategoria1.getText());
        rBCategoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBCategoria1ActionPerformed(evt);
            }
        });
        jPanel2.add(rBCategoria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, -1, -1));

        rBNumero1.setBackground(new java.awt.Color(255, 255, 255));
        filterGroup.add(rBNumero1);
        rBNumero1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        rBNumero1.setForeground(new java.awt.Color(0, 0, 0));
        rBNumero1.setText("Numero");
        rBNumero1.setToolTipText("");
        rBNumero1.setActionCommand(rBNumero1.getText());
        rBNumero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBNumero1ActionPerformed(evt);
            }
        });
        jPanel2.add(rBNumero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, -1, -1));

        comboBoxEstado.setBackground(new java.awt.Color(255, 255, 255));
        comboBoxEstado.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        comboBoxEstado.setForeground(new java.awt.Color(0, 0, 0));
        comboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado", "Ocupada", "Desocupada" }));
        comboBoxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEstadoActionPerformed(evt);
            }
        });
        jPanel2.add(comboBoxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 120, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 700, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelOpcionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelOpcionesMousePressed
        jLabelOpciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu_in.png")));
    }//GEN-LAST:event_jLabelOpcionesMousePressed

    private void jLabelOpcionesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelOpcionesMouseReleased
        jLabelOpciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu.png")));
    }//GEN-LAST:event_jLabelOpcionesMouseReleased
//BOTON OPCIONES.
    private void jLabelOpcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelOpcionesMouseClicked
          
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
    }//GEN-LAST:event_jLabelOpcionesMouseClicked

    private void jLabelMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuMousePressed
        jLabelMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_ventana_in.png")));
    }//GEN-LAST:event_jLabelMenuMousePressed

    private void jLabelMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuMouseReleased
        jLabelMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_ventana.png")));
    }//GEN-LAST:event_jLabelMenuMouseReleased

    private void jLabelMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuMouseClicked
        Menu menu = new Menu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabelMenuMouseClicked

    private void jLabelHuespedMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHuespedMousePressed
         jLabelHuesped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guest_in_ventana.png")));
    }//GEN-LAST:event_jLabelHuespedMousePressed

    private void jLabelHuespedMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHuespedMouseReleased
       jLabelHuesped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guest_ventana.png")));
    }//GEN-LAST:event_jLabelHuespedMouseReleased

    private void jLabelHuespedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHuespedMouseClicked
        Huesped_vista huesped = new Huesped_vista();
        huesped.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabelHuespedMouseClicked

    private void jLabelReservaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReservaMousePressed
        jLabelReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/online-booking_ventana_in.png")));
    }//GEN-LAST:event_jLabelReservaMousePressed

    private void jLabelReservaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReservaMouseReleased
        jLabelReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/online-booking_ventana.png")));
    }//GEN-LAST:event_jLabelReservaMouseReleased

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

    private void jLabelReservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReservaMouseClicked
     
     //se crea un objeto de tio reserva vista para que luego al hacerle clik al boton cambia de pestaña   
     Reserva_vista reserva=new Reserva_vista();
     //hace visible la pestaña reserva vista
     reserva.setVisible(true);
     //cierra la ventana anterior
     dispose();
     
    }//GEN-LAST:event_jLabelReservaMouseClicked

    private void btnAgregarHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarHabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarHabitacionActionPerformed

    private void comboBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEstadoActionPerformed
        filtrarHabitaciones();
    }//GEN-LAST:event_comboBoxEstadoActionPerformed

    private void rBPrecio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBPrecio1ActionPerformed
        filtrarHabitaciones();
    }//GEN-LAST:event_rBPrecio1ActionPerformed

    private void rBCategoria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBCategoria1ActionPerformed
        filtrarHabitaciones();  
    }//GEN-LAST:event_rBCategoria1ActionPerformed

    private void rBNumero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBNumero1ActionPerformed
        filtrarHabitaciones();
    }//GEN-LAST:event_rBNumero1ActionPerformed

    private void rBPisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBPisoActionPerformed
        filtrarHabitaciones();
    }//GEN-LAST:event_rBPisoActionPerformed

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
            java.util.logging.Logger.getLogger(Habitacion_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Habitacion_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Habitacion_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Habitacion_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Habitacion_vista hv = new Habitacion_vista();

                hv.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarHabitacion;
    private javax.swing.JComboBox<String> comboBoxEstado;
    private javax.swing.JTextField filterField;
    private javax.swing.ButtonGroup filterGroup;
    private javax.swing.JComboBox<String> jComboBoxTipoHabitacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCancelar;
    private javax.swing.JLabel jLabelHuesped;
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
    private javax.swing.JTable jTableHabitaciones;
    private javax.swing.JTextField jTextFieldNumeroHabitacion;
    private javax.swing.JTextField jTextFieldPiso;
    private javax.swing.JRadioButton rBCategoria1;
    private javax.swing.JRadioButton rBNumero1;
    private javax.swing.JRadioButton rBPiso;
    private javax.swing.JRadioButton rBPrecio1;
    // End of variables declaration//GEN-END:variables

  

}



