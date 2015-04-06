/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Romina
 */
public class proveedor implements interfazInicial{
  //variables para la coneccion
       private Statement stmt= null;
       private Connection conn = null;
       private ResultSet rs = null;
    //variables locales para la conecccion
   private int CODPROVEEDOR;
   private int codproducto; 
   private String RUCPROVEEDOR;
   private String NOMBRE;
   private String TELEFONO;
   private String DIRECCION;

    public int getCODPROVEEDOR() {
        return CODPROVEEDOR;
    }

    public void setCODPROVEEDOR(int CODPROVEEDOR) {
        this.CODPROVEEDOR = CODPROVEEDOR;
    }

    public int getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(int codproducto) {
        this.codproducto = codproducto;
    }

    public String getRUCPROVEEDOR() {
        return RUCPROVEEDOR;
    }

    public void setRUCPROVEEDOR(String RUCPROVEEDOR) {
        this.RUCPROVEEDOR = RUCPROVEEDOR;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public proveedor(int CODPROVEEDOR, int codproducto, String RUCPROVEEDOR, String NOMBRE, String TELEFONO, String DIRECCION) {
        this.CODPROVEEDOR = CODPROVEEDOR;
        this.codproducto = codproducto;
        this.RUCPROVEEDOR = RUCPROVEEDOR;
        this.NOMBRE = NOMBRE;
        this.TELEFONO = TELEFONO;
        this.DIRECCION = DIRECCION;
    }
    public proveedor(){
    this(0,0,"","","","");
    }

    @Override
    public boolean insertar() {
       conectar();
        String consultaInsertar = "insert into proveedor(CODPROVEEDOR,CODPRODUCTO,RUCPROVEEDOR,NOMBRE,TELEFONO,DIRECCION) values ("+
                this.CODPROVEEDOR+","+
                this.codproducto+",'"+
                this.RUCPROVEEDOR+"','"+
                this.NOMBRE+"','"+
                this.TELEFONO+"','"+
                this.DIRECCION+"')";
        System.out.println(consultaInsertar);
     //  JOptionPane.showMessageDialog(null,consultaInsertar );
        try{
        stmt = conn.createStatement();
        stmt.executeUpdate(consultaInsertar);
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
        String sentenciaActualizacion = "update proveedor " +
           " set CODPRODUCTO="+this.codproducto +","+
             " RUCPROVEEDOR='"+ this.RUCPROVEEDOR+"',"+
             " NOMBRE='"+ this.NOMBRE+"',"+ 
             " TELEFONO='"+ this.TELEFONO+"',"+ 
             " DIRECCION='"+this.DIRECCION +"'";      
             
            System.out.println(sentenciaActualizacion);
       try{ stmt=conn.createStatement();
       stmt.executeUpdate(sentenciaActualizacion);
       }
       catch(Exception e ){System.out.println("error en la actualizacion");}
        return true;
        
    }
    public boolean actualizarProveedor(int Codproveedor) {
        conectar();
        String sentenciaActualizacion = "update proveedor " +
           " set CODPRODUCTO="+this.codproducto +","+
             " RUCPROVEEDOR='"+ this.RUCPROVEEDOR+"',"+
             " NOMBRE='"+ this.NOMBRE+"',"+ 
             " TELEFONO='"+ this.TELEFONO+"',"+ 
             " DIRECCION='"+this.DIRECCION +"'"+
             "where CODPROVEEDOR="+Codproveedor;
             
            System.out.println(sentenciaActualizacion);
       try{ stmt=conn.createStatement();
       stmt.executeUpdate(sentenciaActualizacion);
       }
       catch(Exception e ){System.out.println("error en la actualizacion");}
        return true;
        
    }

    @Override
    public boolean eliminar() {
        conectar();
        int codigo=0;
       try { codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Codigo a eliminar"));}
        catch(Exception e){System.out.println("codigo debe ser numerico");}
       
     String sentenciaborrado = "delete from proveedor where CODPROVEEDOR= " +codigo;
        System.out.println(sentenciaborrado);
        try{
            stmt=conn.createStatement();
            stmt.executeUpdate(sentenciaborrado);
            JOptionPane.showMessageDialog(null, "PROVEEDOR ELIMINADO CORRECTAMENTE");
            
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean consultar2(int codigo) {
        conectar();
       
       String consultaBuscar="select *from PROVEEDOR where CODPROVEEDOR="+codigo;
          System.out.println(consultaBuscar);
        try {stmt = conn.createStatement();
        rs = stmt.executeQuery(consultaBuscar);
        } catch (Exception e) {System.out.println("error en la consulta: " + codigo);}
        
        try {
        if (rs.next()) {
            
            this.CODPROVEEDOR = codigo;
            RUCPROVEEDOR      = rs.getString("RUCPROVEEDOR");
            this.NOMBRE       = rs.getString("NOMBRE");
            this.TELEFONO     = rs.getString("TELEFONO");
            this.DIRECCION    = rs.getString("DIRECCION");
           
            return true;
        }
        else return false;
        }
        catch(Exception e) {return false;}
    }
    }
    

