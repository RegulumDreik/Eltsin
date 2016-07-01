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

/**
 *
 * @author Boris Krab
 */
public class Draw extends Canvas {
    
    private final Color [] cl = {Color.BLACK,Color.GREEN,Color.YELLOW,Color.RED};
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
        if (type==4)
        {
            rcW=rcW+step/3;
            rcH=rcH+step/3;
            g.setColor(Color.WHITE);
            g.fillRect(rcW, rcH, step/3, step/3);
            g.setColor(Color.BLACK);
            rcH-=step/3;
            rcW-=step/3;
            g.fillRect(rcW, rcH, step, step/3);
            rcH+=2*step/3;
            g.fillRect(rcW, rcH, step, step/3+1);
            rcH-=step/3;
            g.fillRect(rcW, rcH, step/3, step/3);
            rcW+=2*step/3;
            g.fillRect(rcW, rcH, step/3+1, step);
        }
        else{
        g.setColor(cl[type]);
        g.fillRect(rcW, rcH, step, step);
        }
    }

    public void Redrow()
        {
            Map M=Session.getMap().clone();
            Graphics g = getGraphics();
            Iterator<ActionObject> It = Session.ListOfAO.iterator();
           while (It.hasNext())
           {
               ActionObject OL = It.next();
               M.setTile(OL.getposW(), OL.getposH(), OL.color);
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
