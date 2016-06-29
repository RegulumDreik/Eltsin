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
    public Player(int x, int y)
    {
        super.posH=x;
        super.posW=y;
    }
    public void update(){
        switch(Session.getKey()){
            case 37:{
                
                break;
            }case 38:{
                
                break;
            }
            case 39:{
                
                break;
            }
            case 40:{
                
                break;
            }
            default: break;
        }        
    }
}
