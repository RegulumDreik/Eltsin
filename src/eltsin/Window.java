/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eltsin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Boris Krab
 */
public class Window  extends JFrame{
    private final int width = 816;
    private final int height = 679;
    private final int step = 16;

    public void createFrame(){
       
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(width,height));
        this.add(new Draw(step));
            
    }

}
