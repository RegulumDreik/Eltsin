/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eltsin;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author Boris Krab
 */
public class Window  extends JFrame{
    private final int width = 800;
    private final int height = 661;
    private final int step = 16;

    public void createFrame(){
       
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(width,height));
        this.addKeyListener(new KeyAdapter() {
     
            @Override
            public void keyPressed(KeyEvent e) {
                Session.setKey(e.getKeyCode());
            }
        });
    }
    public void setCanvas(Draw in)
    {
        this.add(in);
    }

}
