/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eltsin;

import eltsin.AO.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;

/**
 *
 * @author Boris Krab
 */
public class Draw extends Canvas {
    
    private final Color [] cl = {Color.BLACK,Color.GREEN,Color.YELLOW};
    private ArrayList<ActionObject> ListOfAO;
    private final int step;
    Draw(int step)
    {
        this.step = step;
        this.ListOfAO=new ArrayList<>();
        this.addKeyListener(new KeyAdapter() {
     
            @Override
            public void keyPressed(KeyEvent e) {
                Session.setKey(e.getKeyCode());
                }
                 
        });
    }
    
    @Override
    public void paint(Graphics g){
        Redrow();
//        repaint();
      
    }
   
    
    public void drawSquare(int posW,int posH, byte type){
        
        Graphics g = getGraphics();
        int rcW=posW*step;
        int rcH=posH*step;
        g.setColor(cl[type]);
        g.fillRect(rcW, rcH, step, step);
      
    }

    public void Redrow()
        {
            Map M=Session.getMap().clone();
            Graphics g = getGraphics();
            Iterator<ActionObject> It = Session.ListOfAO.iterator();
           while (It.hasNext())
           {
               ActionObject OL = It.next();
               M.setTile(OL.getposW(), OL.getposH(), (byte)2);
           }
            for (int i=0;i<M.getHeight();i++)               
            {
                for (int j=0;j<M.getWidth();j++)
                {
                    drawSquare(j,i,M.getTile(j, i));
                }
            }
           
        }
    
}
