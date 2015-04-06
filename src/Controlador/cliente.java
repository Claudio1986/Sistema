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
public class cliente implements interfazInicial{
       private Statement stmt= null;
       private Connection conn = null;
       private ResultSet rs = null;
       
       private int codcliente;

    public int getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(int codcliente) {
        this.codcliente = codcliente;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    //contructor por defecto
 public cliente(){
     this(0,"","","");
 }
    public cliente(int codcliente, String clave, String direccion, String dni) {
        this.codcliente = codcliente;
        this.clave = clave;
        this.direccion = direccion;
        this.dni = dni;
    }
       private String clave;
       private String direccion;
       private String dni;

    @Override
    public boolean insertar() {
       int exito=0,contador=0;
        
      conectar();
        String consultaInsertar = "insert into Cliente(CodCliente,clave,direccion,dni) values ("+
                this.codcliente+",'"+
                this.clave+"','"+
                this.direccion+"','"+
                this.dni+"')";
               
        
        System.out.println(consultaInsertar);
     //  JOptionPane.showMessageDialog(null,consultaInsertar );
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
    public boolean actualizarCliente(int codigo) {
        String conexion = "jdbc:odbc:venta";
        try {
     conn= DriverManager.getConnection(conexion, "root","1234");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
        String sentenciaActualizacion = "update CLIENTE"+
            " Set CLAVE='"+this.clave +"',"+
             "DIRECCION='"+ this.direccion +"',"+       
             "DNI='"+this.dni +"'"+    
             "where CODCLIENTE="+codigo;
       // JOptionPane.showMessageDialog(null, codigo);
            System.out.println(sentenciaActualizacion);
       try{ stmt=conn.createStatement();
       stmt.executeUpdate(sentenciaActualizacion);
       }
       catch(Exception e ){System.out.println("error en la actualizacion");}
        return true;
    }


    @Override
    public boolean actualizar() {
        conectar();
        String sentenciaActualizacion = "update CLIENTE " +
             "set CODCLIENTE="+this.codcliente +","+
             " CLAVE='"+this.clave +"',"+
             "DIRECCION='"+ this.direccion +"',"+       
             "DNI='"+this.dni +"'";
            // "where serieproducto = '"+ this.txtRecibe.getText()+"'";     
             
            System.out.println(sentenciaActualizacion);
       try{ stmt=conn.createStatement();
       stmt.executeUpdate(sentenciaActualizacion);
       }
       catch(Exception e ){System.out.println("error en la actualizacion");}
        return true;
    }

    @Override
    public boolean eliminar() {
        int codigo = 0;
        conectar();
        try {codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Codigo a eliminar"));}
        catch(Exception e){System.out.println("codigo debe ser numerico");}
       
   String  sentenciaborrado = "delete from cliente where CODCLIENTE = " +codigo;
        System.out.println(sentenciaborrado);
        try{
            stmt=conn.createStatement();
            stmt.executeUpdate(sentenciaborrado);
            JOptionPane.showMessageDialog(null, "CLIENTE ELIMINADO CORRECTAMENTE");
            
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
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
           return true;
    }

    @Override
    public boolean consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean consultar2(int codigo) {
       String conexion = "jdbc:odbc:venta";
        try {
     conn= DriverManager.getConnection(conexion, "root","1234");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
     
       
       String consultaBuscar="select *from cliente where CodCliente="+codigo;
          System.out.println(consultaBuscar);
        try {stmt = conn.createStatement();
        rs = stmt.executeQuery(consultaBuscar);
        } catch (Exception e) {System.out.println("error en la consulta: " + codigo);}
        try {
        if (rs.next()) {
            //comparo codigo de usuario recibido con usuario del metodo
            this.codcliente = codigo;
            this.clave = rs.getString("clave");
            this.direccion= rs.getString("direccion");
            this.dni= rs.getString("dni");
           
            
            return true;
        }
        else return false;
        }
        catch(Exception e) {return false;}
    }
    
}
