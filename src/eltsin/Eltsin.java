/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eltsin;

/**
 *
 * @author Dmitriy Kapustinskiy
 */
public class Eltsin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Draw d  = new Draw(800,640,16);
        d.CreateWindow();
        d.Redrow();
    }
    
}
