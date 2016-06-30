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
        Session.addAO(PL);
        Seeker SK= new Seeker (2,2);
        Session.addAO(SK);
        while (true)
        {
            SK.update();
            PL.update();
            d.Redrow();
        }
    }
    
}
