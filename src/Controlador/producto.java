/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.frmProducto;

/**
 *
 * @author claudio
 */
public class producto implements interfazInicial{
       private Statement stmt= null;
       private Connection conn = null;
       private ResultSet rs = null;
       private String total;
       public int resultado=0;
       public int stockPublico=1;
       public String codigo2=null;
      
     
      

    public int getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(int codproducto) {
        this.codproducto = codproducto;
    }

    public String getSerieProducto() {
        return serieProducto;
    }

    public void setSerieProducto(String serieProducto) {
        this.serieProducto = serieProducto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getStockActual() {
        return StockActual;
    }

    public void setStockActual(int StockActual) {
        this.StockActual = StockActual;
    }

    public int getPreciocosto() {
        return preciocosto;
    }

    public void setPreciocosto(int preciocosto) {
        this.preciocosto = preciocosto;
    }

    public int getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(int precioventa) {
        this.precioventa = precioventa;
    }

    public String getFechaactualizacion() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(ahora);
    }

    public void setFechaactualizacion(String fechaactualizacion) {
        this.fechaactualizacion = fechaactualizacion;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public producto(int codproducto, String serieProducto, String marca, String tipo, int StockActual, int preciocosto, int precioventa, String fechaactualizacion, int idProveedor) {
        this.codproducto = codproducto;
        this.serieProducto = serieProducto;
        this.marca = marca;
        this.tipo = tipo;
        this.StockActual = StockActual;
        this.preciocosto = preciocosto;
        this.precioventa = precioventa;
        this.fechaactualizacion = fechaactualizacion;
        this.idProveedor = idProveedor;
    }
    private int codproducto;
    private String serieProducto;
    private String marca;
    private String tipo;
    private int StockActual;
    private int preciocosto;
    private int precioventa;
    private String fechaactualizacion;
    private int idProveedor;

    @Override
    public boolean insertar() {
       int exito=0,contador=0;
        
      String conexion = "jdbc:odbc:venta";
        try {
     conn= DriverManager.getConnection(conexion, "root","1234");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
     
         String consultaInsertar = "insert into producto(codproducto,serieProducto,marca,tipo,"
                 + "StockActual,preciocosto,precioventa,fechaactualizacion,idProveedor) "
                 + "values ("+
                    this.codproducto+",'"+
                    this.serieProducto+"','"+
                    this.marca+"','"+
                    this.tipo+"',"+
                    this.StockActual+","+
                    this.preciocosto+","+
                    this.precioventa+",'"+
                    this.fechaactualizacion+"',"+
                    this.idProveedor+")";
         
       System.out.println(consultaInsertar);
     
        try{
        stmt = conn.createStatement();
        exito = stmt.executeUpdate(consultaInsertar);
        JOptionPane.showMessageDialog(null,"INSERTADO CORRECTAMENTE");
           }
         catch (Exception e ){
         System.out.println("error en la insercion"+ e.getMessage());
          }    
        return true;
    }

    @Override
    public boolean actualizar() {
    conectar(); 
    String sentenciaActualizacion = "update Producto " +
             "set CODPRODUCTO="+this.codproducto+","+
             "SERIEPRODUCTO='"+ this.serieProducto+"',"+
             " MARCA='"+ this.marca+"',"+ 
             " TIPO='"+ this.tipo+"',"+ 
             " STOCKACTUAL="+ this.StockActual+","+ 
             " PRECIOCOSTO="+ this.preciocosto+","+
             " PRECIOVENTA="+ this.precioventa+","+
             "  FECHAACTUALIZACION='"+ this.fechaactualizacion+"',"+
             " IDPROVEEDOR="+ this.idProveedor+"";
   
             System.out.println(sentenciaActualizacion);
       try{ stmt=conn.createStatement();
       stmt.executeUpdate(sentenciaActualizacion);
       }
       catch(Exception e ){System.out.println("error en la actualizacion");}
        return true;
        
    
      
       
        
    }
    public boolean actualizarProducto(int codProducto) {
   String conexion = "jdbc:odbc:venta";
        try {
     conn= DriverManager.getConnection(conexion, "root","1234");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
        
    String sentenciaActualizacion = "update Producto " +
            "set CODPRODUCTO="+this.codproducto+","+
             "SERIEPRODUCTO='"+ this.serieProducto+"',"+
             " MARCA='"+ this.marca+"',"+ 
             " TIPO='"+ this.tipo+"',"+ 
             " STOCKACTUAL="+ this.StockActual+","+ 
             " PRECIOCOSTO="+ this.preciocosto+","+
             " PRECIOVENTA="+ this.precioventa+","+
             " FECHAACTUALIZACION='"+ this.fechaactualizacion+"',"+
             " IDPROVEEDOR="+ this.idProveedor+""+
            " where CODPRODUCTO="+codProducto;
   // JOptionPane.showMessageDialog(null,codProducto );
   
             System.out.println(sentenciaActualizacion);
       try{ stmt=conn.createStatement();
       stmt.executeUpdate(sentenciaActualizacion);
       }
       catch(Exception e ){System.out.println("error en la actualizacion");}
        return true;
        
    
      
       
        
    }
    
   
    @Override
    public boolean eliminar() {
         int exito=0; String sentenciaborrado;
         int codigo=0;
     /*    String conexion = "jdbc:odbc:venta";
     try {
     conn= DriverManager.getConnection(conexion, "root","1234");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}*/
         conectar();
       try {codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Codigo a eliminar"));}
        catch(Exception e){System.out.println("codigo debe ser numerico");}
       
     sentenciaborrado = "delete from PRODUCTO where CODPRODUCTO = " +codigo;
        System.out.println(sentenciaborrado);
        try{
            stmt=conn.createStatement();
            stmt.executeUpdate(sentenciaborrado);
            JOptionPane.showMessageDialog(null, "PRODUCTO ELIMINADO CORRECTAMENTE");
            
        }
        catch (Exception e) {
        System.out.println("error en la eliminiacion");
                }
       
        
        return true;
    
    
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
       
        return true; 
    }
    public boolean validarProducto(String codigoValidacion) throws SQLException{
         int exito=0,contador=0;
       
      String conexion = "jdbc:odbc:venta";
        try {
     conn= DriverManager.getConnection(conexion, "root","1234");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
       // String consultaInsertar = "insert into usuario(id,usuario,clave,nombre,apellido) values ('"+
         String consultaValidar = "select serieProducto from producto";
                
                   
         
       System.out.println(consultaValidar);
       JOptionPane.showMessageDialog(null,consultaValidar );
        try{
        stmt = conn.createStatement();
        exito = stmt.executeUpdate(consultaValidar);
        JOptionPane.showMessageDialog(null,"VALIDADO");
           }
         catch (Exception e ){
         System.out.println("error en la consulta"+ e.getMessage());
         }
 while(rs.next()){
       
     if(codigoValidacion.equals(rs.getString("serieProducto")))
       {
       System.out.println("existe");
       }
       else{
       System.out.println("no existe");
       }
        
        
              }
        
        return true;
    }

    @Override
    public boolean consultar2(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   public boolean Buscar(String codigoBarra) {
           String conexion="jdbc:odbc:venta";
   try { conn= DriverManager.getConnection(conexion, "root","1234");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
       //conectar();
      String consulta = "select codproducto,serieProducto,marca,tipo,StockActual,"
                 + "preciocosto,precioventa,fechaactualizacion,idProveedor "
                 + "from producto where serieproducto="+codigoBarra;
                                       // nombre='"+nombre+"'";
         // System.out.println(consulta);
        try {stmt = conn.createStatement();
        rs = stmt.executeQuery(consulta);
        } catch (Exception e) {System.out.println("error en la consulta: " + codigoBarra);}
        try {if (rs.next()) {
           // if(thi)
            this.codproducto         =  rs.getInt("codproducto");
            this.serieProducto       =  codigoBarra;
            this.marca               =  rs.getString("marca");
            this.tipo                =  rs.getString("tipo");
            this.StockActual         =  rs.getInt("StockActual");
            this.preciocosto         =  rs.getInt("preciocosto");
            this.precioventa         =  rs.getInt("precioventa");
            this.fechaactualizacion  =  rs.getString("fechaactualizacion");
            this.idProveedor=rs.getInt("idProveedor");
          //  rs.close();
           // stmt.close();
           return true;}
        else return false;}
        catch(Exception e) {return false;}
   }
   //CONTRUCTOR POR DEFECTO
 public producto(){
 this(0,"","","",0,0,0,"",0);
 }

    public boolean consultarStock(String codigo) throws SQLException {
        
         /*String conexion="jdbc:odbc:venta";
   try { conn= DriverManager.getConnection(conexion, "root","1234");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}*/
       conectar();
        int valor=0;
       String consultaValor="select count(*)as Total from producto where serieProducto='"+codigo+"'";
     
      // String consultaValor="select count(*)as Total from producto";
    //   System.out.println(consultaValor);
        try {stmt = conn.createStatement();
        rs = stmt.executeQuery(consultaValor);
        } catch (Exception e) {System.out.println("error en la consulta: " + codigo);}
        
        while (rs.next()) {
            resultado = Integer.parseInt(rs.getString("total"));
            System.out.println(resultado);
            
           
        }
        return true;}

    public boolean sumar(String codigoBarra,int cantidad) throws SQLException{
        conectar();
        int valor=0;
       String consultaValor="select sum(precioventa)as Total from producto where serieProducto='"+codigoBarra+"'";
     
      // String consultaValor="select count(*)as Total from producto";
    //   System.out.println(consultaValor);
        try {stmt = conn.createStatement();
        rs = stmt.executeQuery(consultaValor);
        } catch (Exception e) {System.out.println("error en la consulta: " + codigoBarra);}
        int TotalProducto=0;
        int Total=0;
        while (rs.next()) {
            
           TotalProducto= rs.getInt("Total");
           System.out.println(TotalProducto);
           Total=cantidad*TotalProducto;
           System.out.println(TotalProducto);
            
           
        }
        return true;
   
    }
    
    }
