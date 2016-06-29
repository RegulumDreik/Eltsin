/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eltsin.AO;
import eltsin.Session;
/**
 *
 * @author Boris Krab
 */
public class ActionObject {
    
    protected int posH; 
    protected int posW;
    protected Session Game;
    ActionObject()
    {
        Game=Session.getInstance();
    }
    public int getposH(){
        return this.posW;
    }
    
    public int getposW(){
        return this.posH;
    }
    void setposH(int IN){
        posH=IN;
    }
    void setposW(int IN){
        posW=IN;
    }


}
