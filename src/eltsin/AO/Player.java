/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eltsin.AO;

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
}
