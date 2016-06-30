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
public class Map {
    private byte[][] layer1;
    private int width;
    private int height;
    Map(int width, int height){
        layer1=new byte[width][height];
        this.width=width;
        this.height=height;
        for (int i=0;i<width;i++)
        {
            for (int j=0;j<height;j++)
            {
                if ((((i == 0) || (j == 0)) || (i == width-1))||(j==height-1))
                {
                    layer1[i][j]=1;
                }
                else
                {
                    layer1[i][j]=0;
                }
            }
        }
    }
    public int getWidth()
    {
        return this.width;
    }
    public int getHeight()
    {
        return this.height;
    }
    public byte getTile(int posW,int posH)
    {
        if (posW<width&posW>0&posH<height&posH>0)
        return layer1[posW][posH];
        else return 1;
    }
    public void GenerateMapCell()
    {
        layer1=CellMazeGen.initialiseMap(layer1);
        for (int i=0;i<8;i++)
            layer1=CellMazeGen.doSimulationStep(layer1);
        layer1=CellMazeGen.finalstep(layer1);
    }
    public void addTile(int X,int Y)
    {
        layer1[X][Y]=1;
    }
    public void delTile(int X,int Y)
    {
        layer1[X][Y]=0;
    }
    public ArrayList<int[]> pathFinder(int startX, int startY, int finishX, int finishY)
    {   
        /*byte[][] seekMas=new byte[width][height];
        for (int i=0;i<width;i++)
        {
            for (int k=0;k<height;k++)
            {
                seekMas[i][k]=layer1[i][k];
            }
        }*/
        VolnAlg seek = new VolnAlg(layer1);
        VolnAlg.Point[] retPoint = seek.find(new VolnAlg.Point(startX,startY), new VolnAlg.Point(finishX,finishY));
        ArrayList<int[]> retInt = new ArrayList<>();
        if (retPoint==null) return null;
        for (VolnAlg.Point retPoint1 : retPoint) {
            int[] tp= new int[2];
            tp[0] = retPoint1.getX();
            tp[1] = retPoint1.getY();
            retInt.add(tp);
        }
        return retInt;
    }
    @Override
    public Map clone()
            {
                Map rt=new Map(width,height);
                for (int i=0;i<width;i++)
                {
                    for (int j=0;j<height;j++)
                    {
                        rt.layer1[i][j]=this.layer1[i][j];
                    }
                }
                return rt;
            }
    void setTile (int x,int y, byte T)
    {
        if (x<width&x>0&y<height&y>0)
        layer1[x][y]=T;
    }
}
