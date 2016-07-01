/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eltsin.AO;

import eltsin.Session;

/**
 *
 * @author Dmitriy Kapustinskiy
 */
public class Papers extends ActionObject {
    Papers(int x, int y)
    {
        super.posH=x;
        super.posW=y;
        super.color=4;        
    }
    @Override
    public void update(){
        if ((Session.getPL().posH==posH)&(Session.getPL().posW==posW)&super.color!=0)
        {
            Session.addListik();
            super.color=0;
        }
    }
}
