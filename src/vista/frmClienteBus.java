/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.producto;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author claudio
 */
public class frmClienteBus extends javax.swing.JFrame {
private Connection con = null;
  private ResultSet rs = null;
  private Statement stmt= null;
  private ResultSetMetaData  rsm = null;
  producto P= new producto();
    /**
    /**
     * Creates new form frmClienteBus
     */
    public frmClienteBus() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnTodos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnBusPorRut = new javax.swing.JButton();
        btnMarca = new javax.swing.JButton();
        btnBusquedaProv = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modelo/atras3.png"))); // NOI18N
        jButton4.setText("Volver");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modelo/impresora32.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTodos.setText("TODOS");
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setText("Ingrese parametros de Busqueda");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.red);
        jLabel3.setText("BUSQUEDA DE CLIENTE");

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        btnBusPorRut.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBusPorRut.setText("RUT");
        btnBusPorRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusPorRutActionPerformed(evt);
            }
        });

        btnMarca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMarca.setText("LIMPIAR");
        btnMarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMarcaMouseClicked(evt);
            }
        });
        btnMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcaActionPerformed(evt);
            }
        });

        btnBusquedaProv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBusquedaProv.setText("COD-CLIENTE");
        btnBusquedaProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaProvActionPerformed(evt);
            }
        });

        jt1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jt1.setForeground(java.awt.Color.blue);
        jt1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jt1);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modelo/cliente96.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(80, 80, 80)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBusquedaProv, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBusPorRut, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBusquedaProv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusPorRut, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        framePrincipal formInicial = new framePrincipal();
        formInicial.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            jt1.print(JTable.PrintMode.NORMAL);
        } catch (PrinterException ex) {
            Logger.getLogger(frmTablaEjemplo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        try{
DefaultTableModel modelo = new DefaultTableModel();
//this.jt1.setModel(vista);
this.jt1.setModel(modelo);


String conexion = "jdbc:odbc:venta";
        try {
     con= DriverManager.getConnection(conexion, "root","1234");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
      
         
  // String consulta = "select id,nombre,apellido,usuario,A,PRECIOUNITARIO,CANTIDAD from AUTOMOVIL ORDER BY MARCA";
 String consulta = "select CODCLIENTE as CODIGO,CLAVE,DIRECCION,DNI as RUT from Cliente order by CODCLIENTE ";
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
 

    }//GEN-LAST:event_btnTodosActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnBusPorRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusPorRutActionPerformed
        // TODO add your handling code here:
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            //this.jt1.setModel(vista);
            this.jt1.setModel(modelo);

            String conexion = "jdbc:odbc:venta";
            try {
                con= DriverManager.getConnection(conexion, "root","1234");
            } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}

            String cod=this.txtCodigo.getText();
            // String consulta = "select id,nombre,apellido,usuario,A,PRECIOUNITARIO,CANTIDAD from AUTOMOVIL ORDER BY MARCA";
            String consulta = "select CODCLIENTE as CODIGO,CLAVE,DIRECCION,DNI as RUT from Cliente where DNI='"+cod+"'";
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

        }catch (Exception ex){ex.printStackTrace();}
        this.txtCodigo.setText("");

    }//GEN-LAST:event_btnBusPorRutActionPerformed

    private void btnMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcaActionPerformed
        this.txtCodigo.setText("");
        
        }
        public void mostrartable(String nombre){
            try{
                DefaultTableModel modelo = new DefaultTableModel();
                //this.jt1.setModel(vista);
                this.jt1.setModel(modelo);

                P.conectar();
                List tb = new ArrayList();
                List nom = new ArrayList();
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
                        tb.add(jt1);

                    }
                    modelo.addRow(fila);
                }
                System.out.println(jt1);

                rs.close();
            }catch (Exception ex){ex.printStackTrace();}
    }//GEN-LAST:event_btnMarcaActionPerformed

    private void btnBusquedaProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaProvActionPerformed
   try{
            DefaultTableModel modelo = new DefaultTableModel();
            //this.jt1.setModel(vista);
            this.jt1.setModel(modelo);

            P.conectar();
            
            if(this.txtCodigo.getText().equals("")){
                JOptionPane.showMessageDialog(this, "INGRESE CODIGO A CONSULTAR");
            }
            else{
               
                 try{   
                int  cod =Integer.parseInt(this.txtCodigo.getText());
                 
                 
               
                
                String consulta = "select CODCLIENTE as CODIGO,CLAVE,DIRECCION,DNI as RUT from Cliente where CODCLIENTE="+cod;
              
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

                
}catch(Exception e){
                 JOptionPane.showMessageDialog(this,"SE ESPERO DATO ENTERO O NUMERICO");
                         }
            }
        }catch (Exception ex){ex.printStackTrace();}
        this.txtCodigo.setText("");
    }//GEN-LAST:event_btnBusquedaProvActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.txtCodigo.requestFocusInWindow();
    }//GEN-LAST:event_formWindowOpened

    private void btnMarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMarcaMouseClicked
        // TODO add your handling code here:
        this.txtCodigo.setText("");
        DefaultTableModel modelo = (DefaultTableModel) jt1.getModel();
        modelo.setRowCount(0);
        jt1.updateUI();
    }//GEN-LAST:event_btnMarcaMouseClicked

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
            java.util.logging.Logger.getLogger(frmClienteBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClienteBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClienteBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClienteBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmClienteBus().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusPorRut;
    private javax.swing.JButton btnBusquedaProv;
    private javax.swing.JButton btnMarca;
    private javax.swing.JButton btnTodos;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt1;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}