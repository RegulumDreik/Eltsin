/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eltsin;
import eltsin.AO.ActionObject;
import java.util.ArrayList;
/**
 *
 * @author Dmitriy Kapustinskiy
 */
public class Session {
    
    private static Session _instance = null;
    private static Map map = null;
    private static int key = -1;
    public static ArrayList<ActionObject> ListOfAO = null;
    private Session() {
        ListOfAO= new ArrayList<>();
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
    public static void setKey(int in){
        if (_instance == null)
            _instance = new Session();
        key=in;
    }
    public static int getKey()
    {
        return key;
    }
    public static void addAO(ActionObject AS){
        if (_instance == null)
            _instance = new Session();
        Session.ListOfAO.add(AS);
    }
}
