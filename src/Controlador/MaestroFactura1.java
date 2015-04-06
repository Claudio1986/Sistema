/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author claudio
 */
public class MaestroFactura1 {
     private String nombreCliente;
    private String apellidoCliente;
    private String direccionCliente;
    private String ordenCompra;
    private String rut;
    private String numeroGuia;
    private String condicionPago;
    private String fechaEmision;
    private String fechaVencimiento;

    public MaestroFactura1() {
       this("","","","","","","","","");
       
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(String ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public String getRut() {
        return rut;
    }

    public void setRuc(String rut) {
        this.rut = rut;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public String getCondicionPago() {
        return condicionPago;
    }

    public void setCondicionPago(String condicionPago) {
        this.condicionPago = condicionPago;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public MaestroFactura1(String nombreCliente, String apellidoCliente, String direccionCliente, String ordenCompra, String ruc, String numeroGuia, String condicionPago, String fechaEmision, String fechaVencimiento) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.direccionCliente = direccionCliente;
        this.ordenCompra = ordenCompra;
        this.rut = rut;
        this.numeroGuia = numeroGuia;
        this.condicionPago = condicionPago;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
    }
    
}
