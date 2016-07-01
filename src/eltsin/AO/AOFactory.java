/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eltsin.AO;

import eltsin.Session;
import java.util.Random;

/**
 *
 * @author Dmitriy Kapustinskiy
 */
public class AOFactory {
    public static Player getplayer(){
        Random rnd = new Random();
        int i,j;
        while (Session.getMap().getTile(i=rnd.nextInt(Session.getMap().getHeight()), j=rnd.nextInt(Session.getMap().getWidth()))==1){}
        return new Player(i,j);
    }
    public static Seeker getSeeker(){
        Random rnd = new Random();
        int i,j;
        while (Session.getMap().getTile(i=rnd.nextInt(Session.getMap().getHeight()), j=rnd.nextInt(Session.getMap().getWidth()))==1){}
        return new Seeker(i,j);
    }
    public static Papers getPapers(){
        Random rnd = new Random();
        int i,j;
        while (Session.getMap().getTile(i=rnd.nextInt(Session.getMap().getHeight()), j=rnd.nextInt(Session.getMap().getWidth()))==1){}
        return new Papers(i,j);
    }
}