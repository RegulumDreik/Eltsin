/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eltsin;
import eltsin.AO.*;
/**
 *
 * @author Dmitriy Kapustinskiy
 */
public class Eltsin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Window W = new Window();
        W.createFrame();
        Draw d=new Draw(16);
        W.add(d);
        Map M= new Map(50,40);
        M.GenerateMapCell();
        Session.setMap(M);
        Player PL=new Player(25,26);
        d.addAO(PL);
        int c =1;
        while (true)
        {
            if (c==1)
            {
                c++;
                M.addTile(25,25);
            }
            else
            {
                c--;
                M.delTile(25, 25);
            }
            PL.update();
            d.Redrow();
        }
    }
    
}
