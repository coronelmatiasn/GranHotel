package hotel.vista;

import hotel.Conexion;
import hotel.modelo.HabitacionData;
import hotel.modelo.Reserva;
import hotel.modelo.ReservaData;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class BuscarReservaPanel extends javax.swing.JPanel {
    private Reserva reserva;
    private ArrayList<Reserva> lReservas;
    private Conexion conexion;
    private DefaultTableModel dataModel;

    public BuscarReservaPanel() {
        conexion = new Conexion("jdbc:mysql://localhost/hotel", "root", "");
        //inicializa las variables que contienen a los componentes del formulario
        initComponents();
        crearModeloDeTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoBusqueda = new javax.swing.JTextField();
        botonBusqueda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        botonTerminarReserva = new javax.swing.JButton();

        botonBusqueda.setText("Buscar");
        botonBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBusquedaActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table);

        botonTerminarReserva.setText("TERMINAR RESERVA");
        botonTerminarReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonTerminarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTerminarReservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonBusqueda))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(botonTerminarReserva)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBusqueda))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonTerminarReserva)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBusquedaActionPerformed
        buscarReservas();
        setearContenidoDeTabla();
    }//GEN-LAST:event_botonBusquedaActionPerformed

    private void buscarReservas() {
        String huesped;
        ReservaData rd = new ReservaData(conexion);
        huesped = campoBusqueda.getText();
        
        try {
            //si el campo de busqueda tiene un numero la busqueda se hace por dni
            int dni = Integer.parseInt(huesped);
            lReservas = rd.buscarReservasPorHuesped(dni);
        } catch(NumberFormatException e) {
            //si es un string la busqueda se hace por nombre
            lReservas = rd.buscarReservasPorHuesped(huesped);
        }     
    }
    
    private void botonTerminarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTerminarReservaActionPerformed
        ReservaData rd = new ReservaData(conexion);
        HabitacionData hd = new HabitacionData(conexion);
        //se obtiene la cantidad de columnas
        int columns = table.getColumnCount();
        //se obtiene la fila seleccionada
        int row = table.getSelectedRow();
        
        String columnName;   
        int nReserva = -1;
        int nHabitacion = -1;
        
        /*
        Por cada iteracion del siguiente loop se recorre cada columna y se revisa
        si el nombre de la columna es "N°" o "Habitacion", en el primer caso se guarda
        su contenido en la variable en nReserva(numero de reserva) y en el segundo caso
        en la variable nHabitacion(numero de habitacion).
        */
        for(int i = 0; i < columns; i++) {
            columnName = table.getColumnName(i);
            
            if(columnName.equals("N°")) {
                nReserva = (int) table.getValueAt(row, i);
            }
            
            if(columnName.equals("Habitacion")) {
                nHabitacion = (int) table.getValueAt(row, i);
            }
        }
        
        //se finaliza la reserva y el estado de la habitacion pasa a ser desocupado
        if(nReserva != -1) {
            rd.finalizarReserva(nReserva);
            hd.setEstadoHabitacion(nHabitacion, false);
        }
        
        //redibuja las filas de la tabla actualizando el contenido
        buscarReservas();
        setearContenidoDeTabla();
    }//GEN-LAST:event_botonTerminarReservaActionPerformed
            
    private void crearModeloDeTabla() {
        //guarda los nombres de las columnas en un array
        String col[] = {
            "N°", 
            "Habitacion", 
            "DNI", 
            "Huesped", 
            "Fecha Entrada", 
            "Fecha Salida", 
            "Cantidad De Personas", 
            "Importe",
            "Estado"
        };
        
        //crea un modelo de tabla usando los nombres del array creado y 0 filas
        dataModel = new DefaultTableModel(col, 0);
        
        //añade el modelo a la tabla
        table.setModel(dataModel);
    }
    
    private void setearContenidoDeTabla() {
        //se elimina todo el contenido de la tabla si es que hay
        for(int i = dataModel.getRowCount(); i > 0; i--) {
            dataModel.removeRow(i - 1);
        }
        
        //se inserta el contenido nuevo fila por fila
        for(Reserva r : lReservas) {
            Object row[] = {
                r.getNroReserva(), 
                r.getHabitacion().getNHabitacion(), 
                r.getHuesped().getDni(),
                r.getHuesped().getNombre(),
                r.getFechaEntrada().toString(),
                r.getFechaSalida().toString(),
                r.getCantidadDePersonas(),
                r.getImporteTotal(),
                r.getEstado() ? "activa" : "inactiva"
            };
            
            dataModel.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBusqueda;
    private javax.swing.JButton botonTerminarReserva;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
