/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Date;

/**
 *
 * @author claudio
 */
public class pedido {
    private int numero;

    public pedido(int numero, Date fecha) {
        this.numero = numero;
        this.fecha = fecha;
    }
    public pedido(){
    this(0,new Date());
    
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    private Date fecha;
    
    
}
