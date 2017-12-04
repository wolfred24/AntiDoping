
package Vista;

import Modelo.DBHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Donantes extends javax.swing.JFrame {

    
    ResultSet rs;
    DBHandler dbh = new DBHandler(Main.dbUser,Main.dbPassword);
    FTabla tabla;
    
    public Donantes() {
        initComponents();
        cbEmpresasPopulate();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public Donantes(FTabla tabla) {
        initComponents();
        cbEmpresasPopulate();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.tabla = tabla;
        System.out.println("========================");
    }
public void cbEmpresasPopulate(){
     //insertInto insert =new insertInto();
     try {
            rs = dbh.getValues("select * from empresas");
            int i = 0;
            
            while(rs.next()){
                cbCompany.insertItemAt(rs.getString("NameEmpresa"), i++);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Donantes.class.getName()).log(Level.SEVERE, null, ex);
        }
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rbMale = new javax.swing.JRadioButton();
        rbFemale = new javax.swing.JRadioButton();
        cbCompany = new javax.swing.JComboBox<>();
        tfName = new javax.swing.JTextField();
        tfLastName = new javax.swing.JTextField();
        tfLicencia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        bAccept = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Agregar donante");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellidos:");

        jLabel4.setText("Licensia:");

        jLabel5.setText("Fecha de nacimiento:");

        jLabel6.setText("Genero:");

        buttonGroup1.add(rbMale);
        rbMale.setText("Masculino");

        buttonGroup1.add(rbFemale);
        rbFemale.setText("Femenino");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbMale)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbFemale)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbMale)
                    .addComponent(rbFemale))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCompanyActionPerformed(evt);
            }
        });

        tfLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLastNameActionPerformed(evt);
            }
        });

        jLabel7.setText("Empresa en la que trabaja:");

        bAccept.setText("Aceptar");
        bAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAcceptActionPerformed(evt);
            }
        });

        bCancel.setText("Canselar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 376, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                        .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfLicencia, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfName)
                                    .addComponent(tfLastName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                .addComponent(cbCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel5)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLastNameActionPerformed

    private void bAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAcceptActionPerformed
  
//        DBHandler insert =new insertInto();
        String name;
        String fecha;
        int genero;
        String empresa;
        
        
        name= tfName.getText()+" "+tfLastName.getText();
        String licen = tfLicencia.getText();
        if (tfName.getText().equals("")||tfLicencia.getText().equals("")||tfLastName.getText().equals("")/*||jDateChooser1.get.equals("")*/){
            JOptionPane.showMessageDialog(null,"porfavor llene todos los campos");
        }else{
            
             String dia =Integer.toString(jDateChooser1.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes =Integer.toString(jDateChooser1.getCalendar().get(Calendar.MONTH)+1);
        String año =Integer.toString(jDateChooser1.getCalendar().get(Calendar.YEAR));
        fecha = año+"-"+mes+"-"+dia;
        
        if(rbFemale.isSelected()||rbMale.isSelected()){
           
        if(rbFemale.isSelected()){
            genero=0;
        }else{
            genero=1;
        } 
        
         empresa =""+cbCompany.getSelectedItem().toString();
          dbh.insertDonante(name,licen,fecha,genero,empresa);
          tabla.updateTable();
          
        }else{
            JOptionPane.showMessageDialog(null,"por favor seleccione un tipo de sexo");
        }
        }
       
        
        
         //System.out.println("---"+insert.empresa+" "+cEmpresa.getSelectedItem());
       
      
        
    }//GEN-LAST:event_bAcceptActionPerformed

    private void cbCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCompanyActionPerformed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCompanyActionPerformed

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
            java.util.logging.Logger.getLogger(Donantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Donantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Donantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Donantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Donantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAccept;
    private javax.swing.JButton bCancel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbCompany;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JTextField tfLastName;
    private javax.swing.JTextField tfLicencia;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
