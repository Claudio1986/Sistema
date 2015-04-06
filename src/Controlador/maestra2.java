/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author claudio
 */
public interface maestra2 {
    public boolean insertar();
    public boolean actualizar();
    public boolean eliminar();
    public boolean conectar();
    public boolean consultar(int codigoConsulta);
    public boolean consultar2(String codigo,String contraseña);
}
