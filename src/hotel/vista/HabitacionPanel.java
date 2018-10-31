package hotel.vista;

import hotel.modelo.Habitacion;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class HabitacionPanel extends javax.swing.JPanel {
    private ArrayList<Habitacion> habitaciones;
    private double precioXNoche;
    private int nroHab;
    private boolean botonOk;

    public HabitacionPanel(ArrayList<Habitacion> habitaciones) {
        //crea un nuevo JPanel habitacionPanel
        /*
        llama a los metodos InitComponents(que inicializa las variables que contienen a los componentes de la ventana)
        y al metodo crearTabla(define el contenido de la tabla).
        */
        
        this.habitaciones = habitaciones;
        initComponents();
        crearTabla();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        confirmar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(300, 220));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        table.setBackground(new java.awt.Color(255, 255, 255));
        table.setForeground(new java.awt.Color(0, 0, 0));
        table.setMinimumSize(new java.awt.Dimension(300, 200));
        table.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tableComponentAdded(evt);
            }
        });
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
        confirmar.setEnabled(false);
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });

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

    //este metodo es llamado cuando se hace click en alguna fila de la tabla
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        //contiene el indice de la fila seleccionada
        int row = table.getSelectedRow();
        //contiene la cantidad de columnas de la tabla
        int columns = table.getColumnCount();
        
        String columnName;
        
        /*
        El siguiente loop recorre todas las columnas de la fila seleccionada
        y selecciona las que tengan como titulo "nro"(que contiene el numero de habitacion)
        o "precio por noche"(que contiene el precio por noche de cada habitacion) y almacena
        sus valores en las variables nroHab y precioXNoche, respectivamente.
        */
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
        
        //El boton confirmar solo es clickeable si hay alguna fila seleccionada.
        confirmar.setEnabled(true);
    }//GEN-LAST:event_tableMouseClicked
    
    //Metodo llamado cuando se hace click sobre el boton confirmar
    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        //variable que guarda la ventana que contiene a este JPanel.
        Window win = SwingUtilities.getWindowAncestor(this);
        //el la variable botonOk indica a otra ventana que se ha elegido una fila.
        botonOk = true; 
        
        //cierra la ventana.
        if (win != null) {
           win.dispose();
        }
    }//GEN-LAST:event_confirmarActionPerformed

    private void tableComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tableComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tableComponentAdded

    //este metodo desactiva el boton confirmar si no hay una fila seleccionada.
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        for(int i = 0; i < table.getRowCount(); i++) {
            if(table.isRowSelected(i)) {
                return;
            }
        }
        
        confirmar.setEnabled(false);
    }//GEN-LAST:event_formMouseClicked

    public int getNroHab() {
        return nroHab;
    }
    
    public double getPrecioXNoche() {
        return precioXNoche;
    }
    
    public void setBotonOk(boolean botonOk) {
        this.botonOk = botonOk;
    }
    
    public boolean getBotonOk() {
        return botonOk;
    }
    
    //metodo que carga los datos en la tabla.
    private void crearTabla() {
        //se guardan los nombres de las columnas en un array.
        String[] col = {"nro", "piso", "precio por noche", "camas"};

        //se crea un TableModel(modelo de tabla) con las columnas definidas en el array anterior y con 0 filas
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        //se crea una fila por cada elemento del arraylist habitaciones
        for(Habitacion h : habitaciones) {
            //en cada iteracion se almacenan los datos de cada fila en un array
            Object[] row = {
                h.getNHabitacion(),
                h.getPiso(),
                h.getTipoHabitacion().getPrecioXNoche(),
                h.getTipoHabitacion().getTipoCama().getCategoria()
            };

            //y se pasa el array al table model, agregando una fila
            tableModel.addRow(row);
        }
        
        //se setea el table model con sus columnas definidas y sus filas en la tabla
        table.setModel(tableModel);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
