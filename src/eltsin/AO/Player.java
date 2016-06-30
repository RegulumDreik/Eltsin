/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eltsin.AO;
import eltsin.Session;
import eltsin.AO.ActionObject;

/**
 *
 * @author Boris Krab
 */
public class Player  extends ActionObject{
    long start;
    public boolean death;
    public Player(int x, int y)
    {
        super.posH=x;
        super.posW=y;
        start=System.currentTimeMillis();
        death=false;
    }
    public void update(){
        long end=System.currentTimeMillis();
        if (end-start>150&&!death)
        {
        switch(Session.getKey()){
            case 37:{
                if (Session.getMap().getTile(super.posH-1, posW)==0) 
                {
                    posH--;
                    Session.setKey(-1);
                }
                break;
            }
            case 38:{
                if (Session.getMap().getTile(super.posH, super.posW-1)==0) 
                {
                    posW--;
                    Session.setKey(-1);
                }
                break;
            }
            case 39:{
                if (Session.getMap().getTile(super.posH+1, super.posW)==0) 
                {
                    posH++;
                    Session.setKey(-1);
                }
                break;
            }
            case 40:{
                if (Session.getMap().getTile(super.posH, super.posW+1)==0) 
                {
                    posW++;
                    Session.setKey(-1);
                }
                break;
            }
            default: break;
        }
        start=System.currentTimeMillis();
        }        
    }
    public void  die()
    {
        death=true;
    }
}
