/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eltsin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author Boris Krab
 */
public class DrawObject extends JFrame {
    private final int width  = 640;
    private final int height = 800;
    private final int step = 16;
    
    public void Window(){
        
        this.setSize(new Dimension(width, height));
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setFocusable(true);
        
    }
    
    @Override
    public void paint(Graphics g){
       drawSquare(); 
    }
    
    
    public void drawSquare(){
        
        Graphics g = getGraphics();
        super.paint(g);
        int obj= 0; // эта  хуита , которую   мы будем передовать из мэпа, что бы решать каким цветом красить квадратик
        
        switch (obj){
            case 0 : { g.setColor(Color.BLACK); g.fillRect(200, 200, step, step); } // (координата Х, координата У, Ширина, Длина)
            case 1 : { g.setColor(Color.WHITE);g.fillRect(200, 200, step, step); } // (координата Х, координата У, Ширина, Длина)
            default : break ; // не  придумал   чо сюда   написать
        }
    }
    
}
