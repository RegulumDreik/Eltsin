/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eltsin.AO;

import eltsin.Session;
import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author Boris Krab
 */
public class Seeker extends ActionObject {
    long start;
    ArrayList<int[]> path;
    int PosPLX, PosPLY;
    int step;
    public Seeker(int x, int y)
    {
        super.posH=x;
        super.posW=y;
        start=System.currentTimeMillis();
        PosPLY=-1;
        PosPLX=-1;
        step=4;
    }
     public void update(){
        long end=System.currentTimeMillis();
        for (int i=0;i<Session.ListOfAO.size();i++)
                if (Session.ListOfAO.get(i).getClass()==Player.class)
                {
                    PosPLX=Session.ListOfAO.get(i).posH;
                    PosPLY=Session.ListOfAO.get(i).posW;
                }
        if (step>=4)
        {
            path=Session.getMap().pathFinder(posH, posW, PosPLX, PosPLY);
            step=0;
        }
        
            if (end-start>220&path!=null)
            {
                int[] in =path.get(0);
                posH=in[0];
                posW=in[1];
                path.remove(0);
                step++;
                start=System.currentTimeMillis();
            }
        
    }
}
