/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author claudio
 */
public class detalleVenta extends venta{
    
    private Connection conn = null;
    private ResultSet rs = null;
    private Statement stmt= null;
    
    private int idventa;
    private int ventaid;

    public int getVentaid() {
        return ventaid;
    }

    public void setVentaid(int ventaid) {
        this.ventaid = ventaid;
    }

    public detalleVenta(int ventaid) {
        this.ventaid = ventaid;
    }
    private Date FECHADETALLe;
    private int Cantidad;
    private int precioD;

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public Date getFECHADETALLe() {
        return FECHADETALLe;
    }

    public void setFECHADETALLe(Date FECHADETALLe) {
        this.FECHADETALLe = FECHADETALLe;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getPrecioD() {
        return precioD;
    }

    public void setPrecio(int precioD) {
        this.precioD = precioD;
    }
 public boolean conectarse() {
         String conexion = "jdbc:odbc:venta";
        try {
     conn= DriverManager.getConnection(conexion, "root","1234");
     System.out.println("CONECTADO EXITOSAMENTE");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
        
        return true;
        
        
    }
    public detalleVenta(int idventa,int idCliente, Date FECHADETALLe, int Cantidad, int precioD, int idVenta, String fechaVenta, String Vendedor, int Total, String medioDePago) {
        super(idVenta,idCliente, fechaVenta, Vendedor, Total, medioDePago);
        this.idventa = idventa;
        this.FECHADETALLe = FECHADETALLe;
        this.Cantidad = Cantidad;
        this.precioD = precioD;
    }

    public detalleVenta(int idventa, Date FECHADETALLe, int Cantidad, int precio) {
        this.idventa = idventa;
        this.FECHADETALLe = FECHADETALLe;
        this.Cantidad = Cantidad;
        this.precioD = precioD;
    }
    public detalleVenta(){
        this(0,new Date(),0,0);
 }
    
    public boolean insertar() {
       int exito=0,contador=0;
       
  Date fecha1 = new Date ();
  
  System.out.println(fecha1);
 
      conectarse();
      String fecha;
  Date fecha3 = new Date ();
  fecha = fecha3.toLocaleString();
        String consultaInsertar = "insert into detalleventa(ventaid,FECHADETALLe,Cantidad,precio) values ("+
                this.ventaid+",'"+
                fecha+"',"+
                this.Cantidad+","+
                this.precioD+")";
            
               
        
        System.out.println(consultaInsertar);
     //  JOptionPane.showMessageDialog(null,consultaInsertar );
        try{
        stmt = conn.createStatement();
        exito = stmt.executeUpdate(consultaInsertar);
       // JOptionPane.showMessageDialog(null,"INSERTADO CORRECTAMENTE");
           }
         catch (Exception e ){
         System.out.println("error en la insercion"+ e.getMessage());
          }    
        return true;
        
    }
    
}
