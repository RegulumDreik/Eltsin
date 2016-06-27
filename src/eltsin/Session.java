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
public class Session {
    
    private static Session _instance = null;
    private static Map map = null;
    private Session() {
        
    }
    
    public synchronized static Session getInstance() {
        if (_instance == null)
            _instance = new Session();
        return _instance;
    }
    public static void setMap(Map m){
        if (_instance == null)
            _instance = new Session();
        map=m;
    }
    public static Map getMap()
    {
        return map;
    }
    
}
