/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eltsin;
import eltsin.AO.*;
import java.util.Iterator;
import javax.swing.JOptionPane;
/**
 *
 * @author Dmitriy Kapustinskiy
 */
public class Eltsin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numoflist=4;
        Window W = new Window();
        W.createFrame();
        Draw d=new Draw(16);
        W.add(d);
        initaliase(4,numoflist);
        while (numoflist<11)
        {
            Iterator<ActionObject> It = Session.ListOfAO.iterator();
           while (It.hasNext())
           {
               ActionObject OL = It.next();
               OL.update();
           }
            d.Redrow();
            if (Session.getPL().death){
                int select = JOptionPane.showConfirmDialog(null, "You Lose", "Try again?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (select == JOptionPane.YES_OPTION){
                    Session.clear();
                    initaliase(4,numoflist);
                }
                else{
                    System.exit(0);
                }
            }
            if (Session.getListik()==numoflist){
                int select = JOptionPane.showConfirmDialog(null, "You Win", "Try next?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (select == JOptionPane.YES_OPTION){
                    Session.clear();
                    numoflist++;
                    initaliase(4,numoflist);
                }
                else{
                    System.exit(0);
                }
            }
        }
    }
    private static void initaliase(int colEnemy, int colList)
    {
        Session.setMap(new Map(50,40));
        Session.getMap().GenerateMapCell();
        Session.setPL(AOFactory.getplayer());
        Session.addAO(Session.getPL());
        for (int i=0;i<colEnemy;i++)
        {
            Session.addAO(AOFactory.getSeeker());
        }
        for (int i=0;i<colList;i++)
        {
            Session.addAO(AOFactory.getPapers());
        }
    }
}
