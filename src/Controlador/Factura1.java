/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.List;

/**
 *
 * @author claudio
 */
public class Factura1 {
     
    private MaestroFactura1 maestro;
    private List<producto1> productos;

    public List<producto1> getProductos() {
        return productos;
    }

    public void setProductos(List<producto1> productos) {
        this.productos = productos;
    }

    public MaestroFactura1 getMaestro() {
        return maestro;
    }

    public void setMaestro(MaestroFactura1 maestro) {
        this.maestro = maestro;
    }
}

    
    

