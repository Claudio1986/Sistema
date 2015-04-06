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
import javax.swing.JOptionPane;

     
 
/**
 *
 * @author claudio
 */
public class usuario implements interfazInicial{
       private Statement stmt= null;
       private Connection conn = null;
       private ResultSet rs = null;
       
    public int id;
    private String usuario;
    //contructor por defecto
    public usuario(){
    this(0,"","","","");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public usuario(int id, String usuario, String clave, String nombre, String apellido) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    private String clave;
    private String nombre;
    private String apellido;
 
    @Override
    public boolean insertar() {
        int exito=0,contador=0;
        
      String conexion = "jdbc:odbc:venta";
        try {
     conn= DriverManager.getConnection(conexion, "root","1234");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
        String consultaInsertar = "insert into usuario(id,usuario,clave,nombre,apellido) values ("+
                this.id+",'"+
                this.usuario+"','"+
                this.clave+"','"+
                this.nombre+"','"+
                this.apellido+"')";
        
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

    @Override
    public boolean actualizar() {
         String conexion = "jdbc:odbc:venta";
        try {
     conn= DriverManager.getConnection(conexion, "root","1234");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
          
        String sentenciaActualizacion = "update USUARIO " +
             "set ID="+this.id +","+
             " NOMBRE='"+ this.nombre+"',"+
             " APELLIDO='"+this.apellido+"',"+
             " USUARIO= '"+this.usuario+"',"+
             " CLAVE='"+this.clave+"',"+
             
              
             " USUARIO='"+this.usuario +"'";      
             
            System.out.println(sentenciaActualizacion);
       try{ stmt=conn.createStatement();
       stmt.executeUpdate(sentenciaActualizacion);
       }
       catch(Exception e ){System.out.println("error en la actualizacion");}
        return true;
        
    }
 public boolean actualizarUsuario(int codigoUsuario) {
         String conexion = "jdbc:odbc:venta";
        try {
     conn= DriverManager.getConnection(conexion, "root","1234");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
          
        String sentenciaActualizacion = "update USUARIO " +
             "set ID="+this.id +","+
             " NOMBRE='"+ this.nombre+"',"+
             " APELLIDO='"+this.apellido+"',"+
             " USUARIO= '"+this.usuario+"',"+
             " CLAVE='"+this.clave+"',"+
             " USUARIO='"+this.usuario +"'"+
             " where ID="+codigoUsuario;
             
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
         String conexion = "jdbc:odbc:venta";
     try {
     conn= DriverManager.getConnection(conexion, "root","1234");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
       try {codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Codigo a eliminar"));}
        catch(Exception e){System.out.println("codigo debe ser numerico");}
       
     sentenciaborrado = "delete from usuario where id = " +codigo;
        System.out.println(sentenciaborrado);
        try{
            stmt=conn.createStatement();
            stmt.executeUpdate(sentenciaborrado);
            JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO CORRECTAMENTE");
            
        }
        catch (Exception e) {
        System.out.println("error en la eliminiacion");
                }
       
        
        return true;
    
     //   return true;
    }

    @Override
    public boolean conectar() {
      
 int exito=0; String sentenciaborrado;
         int codigo=0;
         String conexion = "jdbc:odbc:venta";
     try {
     conn= DriverManager.getConnection(conexion, "root","1234");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
       try {codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Codigo a eliminar"));}
        catch(Exception e){System.out.println("codigo debe ser numerico");}
            
            
        return true;
   }

    @Override
    public boolean consultar() {
        
    
        return true; 
    }
     

    @Override    
    public boolean consultar2(int  codigo) {
        String conexion="jdbc:odbc:venta";
             
   
    try {
     conn= DriverManager.getConnection(conexion, "root","1234");
     } catch (Exception e) {   JOptionPane.showMessageDialog(null,"no conecto");}
     
       
         String consulta = "select id,nombre,apellido,usuario,clave from usuario where id="+codigo;
          System.out.println(consulta);
        try {stmt = conn.createStatement();
        rs = stmt.executeQuery(consulta);
        } catch (Exception e) {System.out.println("error en la consulta: " + codigo);}
        try {
        if (rs.next()) {
            //comparo codigo de usuario recibido con usuario del metodo
            this.id = codigo;
            this.nombre = rs.getString("nombre");
            this.apellido= rs.getString("apellido");
            this.usuario= rs.getString("usuario");
            this.clave= rs.getString("clave");
            
            return true;
        }
        else return false;
        }
        catch(Exception e) {return false;}

    }
  
 
    } 
    
    



