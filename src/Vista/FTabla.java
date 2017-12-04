/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.DBHandler;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author fred_
 */
public class FTabla extends javax.swing.JFrame {
    
    DefaultTableModel dtm = new DefaultTableModel();
    ResultSet rs;
    DBHandler dbh = new DBHandler(Main.dbUser,Main.dbPassword);
    String[] columnNames;

    /**
     * Creates new form fTabla
     */
    public FTabla() {
        initComponents();
        prepararTabla();
        rs = dbh.getValues("Select * FROM "+Main.actualTable);
        lWindowName.setText(Main.actualTable);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        updateTable(rs);
        cbOrderBy.setModel(new javax.swing.DefaultComboBoxModel<>(dbh.getColumnNames(Main.actualTable)));
        cbSearchBy.setModel(new javax.swing.DefaultComboBoxModel<>(dbh.getColumnNames(Main.actualTable)));
        //cbOrderBy.insertItemAt("", 0);
        //prepararComboBoxes();
        ColumnsAutoSizer.sizeColumnsToFit(tabla);
        if(tabla.getColumnCount()*90 > tabla.getWidth()){
            this.setSize(tabla.getColumnCount()*90, this.getHeight());
        }
        if(Main.privilege == 0 ){
            bDelete.setEnabled(false);
            bAgregar.setEnabled(false);
            tabla.setEnabled(false);
            System.out.println(Main.privilege);
            System.out.println("++++++++++++++");
        }
        setLocation(430, 1);
    }
    
    void prepararTabla() {
        columnNames =dbh.getColumnNames(Main.actualTable);
        String titulos[] = columnNames;
        dtm = new DefaultTableModel(null, titulos);
        tabla.setModel(dtm);
        addListener(tabla);
    }
    
    
    
    void updateTable(ResultSet rs) {
        int nColumns = dbh.getColumnNames(Main.actualTable).length;
        String[] valores = new String[nColumns];
        //int contador = 0;
        //ArrayList valores = new ArrayList();
        dtm = (DefaultTableModel) tabla.getModel();
        dtm.setRowCount(0);
        try {
            while (rs.next()) {
                for(int x = 1; x <= nColumns; x++){
                    valores[x-1] = rs.getString(x);
                }
                //valores.add(rs.getString(contador));
                
                dtm.addRow(valores);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FTabla.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void updateTable() {
        rs = dbh.getValues("SELECT * FROM "+Main.actualTable);
        int nColumns = dbh.getColumnNames(Main.actualTable).length;
        String[] valores = new String[nColumns];
        //int contador = 0;
        //ArrayList valores = new ArrayList();
        dtm = (DefaultTableModel) tabla.getModel();
        dtm.setRowCount(0);
        try {
            while (rs.next()) {
                for(int x = 1; x <= nColumns; x++){
                    valores[x-1] = rs.getString(x);
                }
                //valores.add(rs.getString(contador));
                
                dtm.addRow(valores);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FTabla.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void addListener(JTable tabla) {
        tabla.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent evento) {
                cellModified(evento);
            }
        });
    }
    
    public void cellModified(TableModelEvent evento) {
        if (evento.getType() == TableModelEvent.UPDATE) {
            TableModel modelo = ((TableModel) (evento.getSource()));
            int fila = evento.getFirstRow();
            int columna = evento.getColumn();
            String valor =  modelo.getValueAt(fila, columna).toString();
            String id = modelo.getValueAt(fila, 0).toString();
            System.out.println("Fila: "+fila+" Columna: "+columna+" valor: "+valor+" ID: "+id);
            boolean status;

            status = dbh.update("UPDATE " + Main.actualTable + " SET " + columnNames[columna]
                    + "='"+valor+"' WHERE "+columnNames[0]+"="+id);
            if(status == true){
                rs = dbh.getValues("Select * FROM "+Main.actualTable);
                updateTable(rs);
            }
        }
    }
    
//    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
//           Component component = super.prepareRenderer(renderer, row, column);
//           int rendererWidth = component.getPreferredSize().width;
//           TableColumn tableColumn = table.getColumnModel().getColumn(column);
//           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
//           return component;
//        }
//    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollpane = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        bAgregar = new javax.swing.JButton();
        cbOrderBy = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbSearchBy = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lWindowName = new javax.swing.JLabel();
        cbOrderTipe = new javax.swing.JComboBox<>();
        bDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        scrollpane.setViewportView(tabla);

        bAgregar.setText("Agregar");
        bAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarActionPerformed(evt);
            }
        });

        jLabel1.setText("Ordenar Por:");

        jLabel2.setText("Buscar");

        jLabel3.setText("Buscar por:");

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lWindowName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lWindowName.setText("Titulo");

        cbOrderTipe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ASC", "DESC" }));

        bDelete.setText("Eliminar");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollpane)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lWindowName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bDelete)
                        .addGap(18, 18, 18)
                        .addComponent(bAgregar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbOrderBy, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbOrderTipe, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addComponent(jLabel2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAgregar)
                    .addComponent(lWindowName)
                    .addComponent(bDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbOrderBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(cbOrderTipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String query = "SELECT * FROM "+Main.actualTable;
        String orderBy = cbOrderBy.getSelectedItem().toString();
        String sorted = cbOrderTipe.getSelectedItem().toString();
        String searchBy = cbSearchBy.getSelectedItem().toString();
        String searchTerm = tfSearch.getText();
        System.out.println("Search: "+searchBy+" "+searchTerm);
        if(tfSearch.getText().isEmpty()){
            query = query;
        }else{
            query = query+" WHERE "+searchBy+" LIKE '%"+searchTerm+"%'";
        }
        query = query+" ORDER BY "+orderBy+" "+sorted;
        rs = dbh.getValues(query);
        updateTable(rs);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        // TODO add your handling code here:
        int column = tabla.getSelectedColumn();
        int row = tabla.getSelectedRow();
        String value = tabla.getValueAt(row, 0).toString();
        String columnName = columnNames[0];
        System.out.println("DELETE COLUMNAME: "+columnName+" VALUE: "+value);
        dbh.deleteRow(Main.actualTable, columnName, value);
        updateTable();
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarActionPerformed
        // TODO add your handling code here:
        if(Main.actualTable == "Donantes"){
            new Donantes(this).setVisible(true);
        }
        
        if(Main.actualTable == "Medicos"){
            new Medicos(this).setVisible(true);
        }
        
        if(Main.actualTable == "Drogas"){
            new FDrogas(this).setVisible(true);
        }
        if(Main.actualTable == "Empresas"){
            new FEmpresa(this).setVisible(true);
        }
    }//GEN-LAST:event_bAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(FTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FTabla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAgregar;
    private javax.swing.JButton bDelete;
    private javax.swing.JComboBox<String> cbOrderBy;
    private javax.swing.JComboBox<String> cbOrderTipe;
    private javax.swing.JComboBox<String> cbSearchBy;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lWindowName;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
