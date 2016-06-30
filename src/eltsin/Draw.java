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
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;

/**
 *
 * @author Boris Krab
 */
public class Draw extends Canvas {
    
    private final Color [] cl =   new Color[3];
    private ArrayList<ActionObject> ListOfAO;
    private final int step;
    Draw(int step)
    {
        this.step = step;
        this.ListOfAO=new ArrayList<>();
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
        cl[0] = Color.BLACK;
        cl[1] = Color.GREEN;
        cl[2] = Color.YELLOW;
        g.setColor(cl[type]);
        g.fillRect(rcH, rcH, step, step);
//        switch (type){
//            case 0 : { g.setColor(Color.BLACK); g.fillRect(rcW, rcH,step, step); break; } // (координата Х, координата У, Ширина, Длина)
//            case 1 : { g.setColor(Color.GREEN);g.fillRect(rcW, rcH, step,step); break;}
//            case 2 : { g.setColor(Color.YELLOW);g.fillRect(rcW, rcH, step,step); break;}// (координата Х, координата У, Ширина, Длина)
//            default : break ; // не  придумал   чо сюда   написать
//            
//        }
      
    }
    public void addAO(ActionObject AS){
        ListOfAO.add(AS);
    }
    public void Redrow()
        {
            Map M=Session.getMap();
            Graphics g = getGraphics();
            
            for (int i=0;i<M.getHeight();i++)               
            {
                for (int j=0;j<M.getWidth();j++)
                {
                    drawSquare(j,i,M.getTile(j, i));
                }
            }
           Iterator<ActionObject> It = ListOfAO.iterator();
           while (It.hasNext())
           {
               ActionObject OL = It.next();
               drawSquare(OL.getposW(),OL.getposH(),(byte)2);
           }
           
        }
    
}
