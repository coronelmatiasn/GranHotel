/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.vista;

import hotel.modelo.Habitacion;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fati
 */
public class HabitacionPanel extends javax.swing.JPanel {
    ArrayList<Habitacion> habitaciones;
    double precioXNoche;
    int nroHab;
    /**
     * Creates new form HabitacionPanel
     */
    public HabitacionPanel(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        String[] col = {"nro", "piso", "precio por noche", "camas"};

        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        table = new javax.swing.JTable();
        confirmar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(300, 220));

        table.setBackground(new java.awt.Color(255, 255, 255));
        table.setForeground(new java.awt.Color(0, 0, 0));
        table.setModel(tableModel);
        table.setMinimumSize(new java.awt.Dimension(300, 200));
        for(Habitacion h : habitaciones) {
            Object[] row = {
                h.getNHabitacion(),
                h.getPiso(),
                h.getTipoHabitacion().getPrecioXNoche(),
                h.getTipoHabitacion().getTipoCama().getCategoria()
            };

            tableModel.addRow(row);
        }
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        confirmar.setBackground(new java.awt.Color(255, 255, 255));
        confirmar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        confirmar.setForeground(new java.awt.Color(0, 0, 0));
        confirmar.setText("CONFIRMAR");
        confirmar.setAlignmentX(0.5F);
        confirmar.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(confirmar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(confirmar)
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int row = table.getSelectedRow();
        int columns = table.getColumnCount();
        String columnName;
        
        for(int i = 0; i < columns; i++) {
            columnName = table.getColumnName(i);
            switch(columnName) {
                case "nro":
                    nroHab = (int) table.getValueAt(row, i);
                    break;
                case "precio por noche": 
                    precioXNoche = (double) table.getValueAt(row, i);
                    break;
            }      
        }

        System.out.println(nroHab);
        System.out.println(precioXNoche);
    }//GEN-LAST:event_tableMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
