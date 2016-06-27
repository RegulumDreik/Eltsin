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
public class Draw extends JFrame {
    private int width;
    private int height;
    private int step;
    Draw(int width, int height, int step)
    {
        this.width=width;
        this.height=height;
        this.step=step;
    }
    public void CreateWindow(){
        
        this.setSize(new Dimension(width, height));
        this.setVisible(true);
        this.setResizable(false);
      
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setFocusable(true);
        
    }
   
    @Override
    public void paint(Graphics g){
        Redrow();
    }
   
    
    public void drawSquare(int posW,int posH, byte type){
        
        Graphics g = getGraphics();
        int rcW=posW*step;
        int rcH=posH*step;
        
        switch (type){
            case 0 : { g.setColor(Color.BLACK); g.fillRect(rcW, rcH, step, step); break; } // (координата Х, координата У, Ширина, Длина)
            case 1 : { g.setColor(Color.GREEN);g.fillRect(rcW, rcH, step, step); break;} // (координата Х, координата У, Ширина, Длина)
            default : break ; // не  придумал   чо сюда   написать
            
        }
      
    }

    public void Redrow()
        {
            Map M=new Map(50,40);
            Graphics g = getGraphics();
            
            for (int i=0;i<M.getHeight();i++)
            {
                for (int j=0;j<M.getWidth();j++)
                {
                    drawSquare(j,i,M.getTile(j, i));
                }
            }
           
        }
    
}
