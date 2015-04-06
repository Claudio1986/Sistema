/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author claudio
 */
public class categoria implements interfazInicial{
      //variables de la coneccion
    private Connection conn = null;
    private Statement stmt = null;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public categoria(int idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }
    private int idCategoria;
    private String nombre;

    @Override
    public boolean insertar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean conectar() {
         {
       //cargar el jdbc
        boolean exito=true;
        //Class.forName("com.mysql.jdbc.Driver"); 
        try {Class.forName("com.mysql.jdbc.Driver");}
        catch (Exception e){
         System.out.println("error con el driver jdbc-odbc");
         exito = false;
        }
        //Prepara la conexion
        try{conn= DriverManager.getConnection("jdbc:odbc:bdventa","root","1234");}
        catch (Exception e) {
            System.out.println("error al abrir conexion"+e.getMessage());
            exito = false;
        }
        
        return exito;
        }
    }

    @Override
    public boolean consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean consultar2(int  codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
