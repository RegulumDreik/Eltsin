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
        return layer1[posW][posH];
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
}
