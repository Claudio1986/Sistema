/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author claudio
 */
public class conoceTeclas extends JFrame implements KeyListener{
    JLabel jl1= new JLabel("");
    JLabel jl2= new JLabel("");
    JLabel jl3= new JLabel("");
    
    
    public conoceTeclas(){
     add(jl1);
     add(jl2);
     add(jl3);
    addKeyListener(this);
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
       
    }

   @Override
    public void keyPressed(KeyEvent ke) {
      System.out.println("El caracter pulsado"+ke.getKeyChar() +"tecla especial"+ ke.getKeyLocation()+"codigo Pulsado"+ke.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
}
