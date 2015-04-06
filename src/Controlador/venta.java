/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author claudio
 */
public class venta implements interfazInicial{
    private int idVenta;
    private int idCliente;
    public  String fechaVenta;
    private String Vendedor;
    
       private Statement stmt= null;
       private Connection conn = null;
       private ResultSet rs = null;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getVendedor() {
        return Vendedor;
    }

    public void setVendedor(String Vendedor) {
        this.Vendedor = Vendedor;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
    }
    private int Total;
    private String medioDePago;

    public venta(int idVenta,int idCliente, String fechaVenta, String Vendedor, int Total, String medioDePago) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.Vendedor = Vendedor;
        this.Total = Total;
        this.medioDePago = medioDePago;
    }
    public venta(){
        this(0,0,"","",0,"");
    }

    @Override
    public boolean insertar() {
        /*        Dateti fecha;
        Date fecha1 = new Date ();
        fecha = fecha1.toLocaleString();*/
        Date fecha = new Date();
        //JOptionPane.showMessageDialog(null, rs);
        
  conectar();
  
         String consultaInsertar = "insert into venta(idVenta,idCliente,fechaVenta,vendedor,total,medioDePago)"
               
                 + "values ("+
                    this.idVenta+","+
                    this.idCliente+",'"+
                    this.fechaVenta+"','"+ 
                    this.Vendedor+"',"+
                    this.Total+",'"+
                    this.medioDePago+"')";
       //JOptionPane.showMessageDialog(null,consultaInsertar);
        try{
        stmt = conn.createStatement();
         stmt.executeUpdate(consultaInsertar);
       
           }
         catch (Exception e ){
         System.out.println("error en la insercion Fallo"+ e.getMessage());
          }    
        return true;
    }

    @Override
    public boolean actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    @Override
    public boolean eliminar() {
        return true;
    }
    public boolean eliminaProductoVentaActual(String codigo,int subtotal){
    conectar();
    int resta=0;
    String obtieneValores="select precioventa from producto where serieproducto="+codigo;
    try {stmt = conn.createStatement();
        rs = stmt.executeQuery(obtieneValores);
        } catch (Exception e) {System.out.println("error en la consulta: " + codigo);}
        try {if (rs.next()) {
            // if(thi)
            int precio = rs.getInt("precioventa");
            resta=subtotal-precio;
            System.out.println(resta);
            
            
            
            rs.close();
            stmt.close();
           return true;}
      
      
    return true;
    }catch(Exception e){System.out.println("error en Eliminacion de items");}return false;
}
    

    @Override
    public boolean conectar() {
         String conexion = "jdbc:odbc:venta";
        try {
     conn= DriverManager.getConnection(conexion, "root","1234");
     System.out.println("CONECTADO EXITOSAMENTE");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
        
        return true;
        
        
    }

    @Override
    public boolean consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean consultar2(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
