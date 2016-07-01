/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eltsin;
import eltsin.AO.ActionObject;
import eltsin.AO.Player;
import java.util.ArrayList;
/**
 *
 * @author Dmitriy Kapustinskiy
 */
public class Session {
    
    private static Session _instance = null;
    private static Map map = null;
    private static int key = -1;
    private static Player curPL = null;
    public static ArrayList<ActionObject> ListOfAO = null;
    private static int listik=0;
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
        if (ListOfAO == null) 
            ListOfAO= new ArrayList<>();
        Session.ListOfAO.add(AS);
    }
    public static void setPL(Player m){
        if (_instance == null)
            _instance = new Session();
        curPL=m;
    }
    public static Player getPL(){
        return curPL;
    }
    public static void clear(){
        if (_instance == null)
            _instance = new Session();
    map = null;
    key = -1;
    curPL = null;
    ListOfAO = null;
    listik=0;
    }
    public static void addListik()
    {
        listik++;
    }
    public static int getListik()
    {
        if (_instance == null)
            _instance = new Session();
        return listik;
    }
}
