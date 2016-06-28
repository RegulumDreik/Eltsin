/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eltsin;
import java.util.Random;
/**
 *
 * @author Dmitriy Kapustinskiy
 */
public class CellMazeGen {
   private static final float chanceToStartAlive = 0.4f;
   private static final int deathLimit=6;
   private static final int birthLimit=2;
public static byte[][] initialiseMap(byte[][] map){
    Random R=new Random();
    for(int x=0; x<map.length; x++){
        for(int y=0; y<map[x].length; y++){
            if(R.nextFloat() < chanceToStartAlive){
                map[x][y] = 1;
            }
        }
    }
    return map;
}
private static int countAliveNeighbours(byte[][] map, int x, int y){
    int count = 0;
    for(int i=-1; i<2; i++){
        for(int j=-1; j<2; j++){
            int neighbour_x = x+i;
            int neighbour_y = y+j;
            //If we're looking at the middle point
            if(i == 0 && j == 0){
                //Do nothing, we don't want to add ourselves in!
            }
            //In case the index we're looking at it off the edge of the map
            else if(neighbour_x < 0 || neighbour_y < 0 || neighbour_x >= map.length || neighbour_y >= map[0].length){
                count = count + 1;
            }
            //Otherwise, a normal check of the neighbour
            else if(map[neighbour_x][neighbour_y]==1){
                count = count + 1;
            }
        }
    }
    return count;
}
public static byte[][] doSimulationStep(byte[][] oldMap){
    byte[][] newMap = new byte[oldMap.length][oldMap[0].length];
    //Loop over each row and column of the map
    for(int x=0; x<oldMap.length; x++){
        for(int y=0; y<oldMap[0].length; y++){
            int nbs = countAliveNeighbours(oldMap, x, y);
            //The new value is based on our simulation rules
            //First, if a cell is alive but has too few neighbours, kill it.
            if(oldMap[x][y]==1){
                if(nbs < deathLimit){
                    newMap[x][y] = 0;
                }
                else{
                    newMap[x][y] = 1;
                }
            } //Otherwise, if the cell is dead now, check if it has the right number of neighbours to be 'born'
            else{
                if(nbs > birthLimit){
                    newMap[x][y] = 1;
                }
                else{
                    newMap[x][y] = 0;
                }
            }
        }
    }
    return newMap;
}
public static byte [][] finalstep(byte [][] oldMap)
{
    byte[][] newMap = new byte[oldMap.length][oldMap[0].length];
    
    for(int x=0; x<oldMap.length; x++){
        for(int y=0; y<oldMap[0].length; y++){
            if(oldMap[x][y]==1&(x>0&x<oldMap.length-1)&(y>0&y<oldMap[0].length-1)){
                if((oldMap[x-1][y-1]==1&oldMap[x-1][y]==0&oldMap[x-1][y+1]==1)|(oldMap[x+1][y-1]==1&oldMap[x+1][y]==0&oldMap[x+1][y+1]==1)|(oldMap[x-1][y+1]==1&oldMap[x][y+1]==0&oldMap[x+1][y+1]==1)|(oldMap[x-1][y-1]==1&oldMap[x][y-1]==0&oldMap[x+1][y-1]==1)){
                    newMap[x][y] = 0;
                }
                else
                {
                    newMap[x][y] = 1;
                }
            }
            else
            {
                newMap[x][y]=oldMap[x][y];
            }
        }
    }
    return newMap;
}
}
