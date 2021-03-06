/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author claudio
 */
public class frmTablaEjemplo extends javax.swing.JFrame {
  private Connection con = null;
  private ResultSet rs = null;
  private Statement stmt= null;
  private ResultSetMetaData  rsm = null;
    /**
     * Creates new form frmTablaEjemplo
     */
    public frmTablaEjemplo() {
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
        jt1 = new javax.swing.JTable();
        btnLlenar = new javax.swing.JButton();
        btnNombres = new javax.swing.JButton();
        btnPornombre = new javax.swing.JButton();
        txtBuscar = new javax.swing.JButton();
        txtBucar = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        btnPrint = new javax.swing.JButton();
        btnPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Agency FB", 1, 10)); // NOI18N

        jt1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jt1);

        btnLlenar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLlenar.setText("DESPLEGAR TODOS ");
        btnLlenar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLlenarMouseClicked(evt);
            }
        });
        btnLlenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLlenarActionPerformed(evt);
            }
        });

        btnNombres.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNombres.setText("DESPLEGAR POR ID");
        btnNombres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNombresMouseClicked(evt);
            }
        });

        btnPornombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPornombre.setText("DESPLEGAR POR NOMBRE");
        btnPornombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPornombreMouseClicked(evt);
            }
        });
        btnPornombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPornombreActionPerformed(evt);
            }
        });

        txtBuscar.setText("BUSCAR");
        txtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarMouseClicked(evt);
            }
        });
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnPrint.setText("imprimir");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnPdf.setText("PDF");
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnPrint)
                .addGap(157, 157, 157))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnLlenar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNombres, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPornombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotal)
                            .addComponent(txtBucar, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                        .addGap(48, 48, 48)
                        .addComponent(txtBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPdf)))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnLlenar)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNombres)
                    .addComponent(txtBuscar)
                    .addComponent(txtBucar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnPornombre)
                .addGap(15, 15, 15)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnPrint)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnPdf)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLlenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLlenarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLlenarActionPerformed

    private void btnLlenarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLlenarMouseClicked
        // TODO add your handling code here:
        try{
DefaultTableModel modelo = new DefaultTableModel();
//this.jt1.setModel(vista);
this.jt1.setModel(modelo);


String conexion = "jdbc:odbc:venta";
        try {
     con= DriverManager.getConnection(conexion, "root","1234");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
      String consulta = "select ID,NOMBRE,APELLIDO,USUARIO from usuario order by id";
  System.out.println(consulta);
    try{stmt=con.createStatement();
    rs=stmt.executeQuery(consulta);
    }catch (Exception e){System.out.println ("error en la consulta");}
    ResultSetMetaData rsm = rs.getMetaData();
    int cantidadColumnas = rsm.getColumnCount();
    for(int i =1;i<=cantidadColumnas;i++)
    { modelo.addColumn(rsm.getColumnLabel(i));
     String descripcion = (String) jt1.getValueAt(i, 0);
    //JOptionPane.showMessageDialog(this,RescatoValor );
    System.out.println(descripcion);
    }
    
    while(rs.next()){
    Object[] fila = new Object[cantidadColumnas];
    for(int i = 0;i<cantidadColumnas;i++){
    fila[i]=rs.getObject(i+1);
    }
    modelo.addRow(fila);
    }
 rs.close();
}catch (Exception ex){ex.printStackTrace();}
    }//GEN-LAST:event_btnLlenarMouseClicked

    private void btnNombresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNombresMouseClicked
        // TODO add your handling code here
        int codigo=0;
          try { codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Codigo a consultar"));}
        catch(Exception e){System.out.println("codigo debe ser numerico");}
        
   
          try{
DefaultTableModel modelo = new DefaultTableModel();
//this.jt1.setModel(vista);
this.jt1.setModel(modelo);


String conexion = "jdbc:odbc:venta";
        try {
     con= DriverManager.getConnection(conexion, "root","1234");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
      
         
  // String consulta = "select id,nombre,apellido,usuario,A,PRECIOUNITARIO,CANTIDAD from AUTOMOVIL ORDER BY MARCA";
     String consulta = "select ID,NOMBRE,APELLIDO,USUARIO from usuario  where id="+codigo;
  System.out.println(consulta);
    try{stmt=con.createStatement();
    rs=stmt.executeQuery(consulta);
    }catch (Exception e){System.out.println ("error en la consulta");}
    ResultSetMetaData rsm = rs.getMetaData();
    int cantidadColumnas = rsm.getColumnCount();
    for(int i =1;i<=cantidadColumnas;i++)
    { modelo.addColumn(rsm.getColumnLabel(i));}
    while(rs.next()){
    Object[] fila = new Object[cantidadColumnas];
    for(int i = 0;i<cantidadColumnas;i++){
    fila[i]=rs.getObject(i+1);
    
    }
    modelo.addRow(fila);
    }
 rs.close();
}catch (Exception ex){ex.printStackTrace();}
 



    }//GEN-LAST:event_btnNombresMouseClicked
public void mostrartable(String nombre){
 try{
DefaultTableModel modelo = new DefaultTableModel();
//this.jt1.setModel(vista);
this.jt1.setModel(modelo);


String conexion = "jdbc:odbc:venta";
        try {
     con= DriverManager.getConnection(conexion, "root","1234");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
       List tb = new ArrayList();
        List nom = new ArrayList();  
  // String consulta = "select id,nombre,apellido,usuario,A,PRECIOUNITARIO,CANTIDAD from AUTOMOVIL ORDER BY MARCA";
     String consulta = "select ID,NOMBRE,APELLIDO,USUARIO from usuario where nombre='"+nombre+"'";
                                                                   //              ='"+nombre+"'"
  //                   "SELECT id_t FROM empleados WHERE nombre = '"+nombre+"'";
    System.out.println(consulta);
    try{stmt=con.createStatement();
    rs=stmt.executeQuery(consulta);
    }catch (Exception e){System.out.println ("error en la consulta");}
    ResultSetMetaData rsm = rs.getMetaData();
    int cantidadColumnas = rsm.getColumnCount();
    for(int i =1;i<=cantidadColumnas;i++)
    { modelo.addColumn(rsm.getColumnLabel(i));}
    while(rs.next()){
    Object[] fila = new Object[cantidadColumnas];
    for(int i = 0;i<cantidadColumnas;i++){
    fila[i]=rs.getObject(i+1);
    tb.add(jt1);
     
    }
    modelo.addRow(fila);
    }
    System.out.println(jt1);
    
 rs.close();
}catch (Exception ex){ex.printStackTrace();}
 

}
 
    private void btnPornombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPornombreMouseClicked
   /*     // TODO add your handling code here:
        // TODO add your handling code here
        String nombre=null;
          nombre = (JOptionPane.showInputDialog("Ingrese nombre a consultar"));
       
        
   
          try{
DefaultTableModel modelo = new DefaultTableModel();
//this.jt1.setModel(vista);
this.jt1.setModel(modelo);


String conexion = "jdbc:odbc:venta";
        try {
     con= DriverManager.getConnection(conexion, "root","1234");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
      
         
  // String consulta = "select id,nombre,apellido,usuario,A,PRECIOUNITARIO,CANTIDAD from AUTOMOVIL ORDER BY MARCA";
     String consulta = "select ID,NOMBRE,APELLIDO,USUARIO from usuario where nombre='"+nombre+"'";
  //                   "SELECT id_t FROM empleados WHERE nombre = '"+nombre+"'";
    System.out.println(consulta);
    try{stmt=con.createStatement();
    rs=stmt.executeQuery(consulta);
    }catch (Exception e){System.out.println ("error en la consulta");}
    ResultSetMetaData rsm = rs.getMetaData();
    int cantidadColumnas = rsm.getColumnCount();
    for(int i =1;i<=cantidadColumnas;i++)
    { modelo.addColumn(rsm.getColumnLabel(i));}
    while(rs.next()){
    Object[] fila = new Object[cantidadColumnas];
    for(int i = 0;i<cantidadColumnas;i++){
    fila[i]=rs.getObject(i+1);
    
    }
    modelo.addRow(fila);
    }
 rs.close();
}catch (Exception ex){ex.printStackTrace();}*/
 


    }//GEN-LAST:event_btnPornombreMouseClicked

    private void txtBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMouseClicked
 
      
    }//GEN-LAST:event_txtBuscarMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnPornombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPornombreActionPerformed
        // TODO add your handling code here:
        
            String nombre=JOptionPane.showInputDialog("Ingrese nombre");
         mostrartable(nombre);
         
       
    }//GEN-LAST:event_btnPornombreActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
      try {
          jt1.print(JTable.PrintMode.NORMAL);
      } catch (PrinterException ex) {
          Logger.getLogger(frmTablaEjemplo.class.getName()).log(Level.SEVERE, null, ex);
      }
       
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
     
    }//GEN-LAST:event_btnPdfActionPerformed

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
            java.util.logging.Logger.getLogger(frmTablaEjemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTablaEjemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTablaEjemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTablaEjemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTablaEjemplo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLlenar;
    private javax.swing.JButton btnNombres;
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton btnPornombre;
    private javax.swing.JButton btnPrint;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt1;
    private javax.swing.JTextField txtBucar;
    private javax.swing.JButton txtBuscar;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
