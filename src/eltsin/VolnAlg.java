package eltsin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VolnAlg
{
    public int l;  // длина
    
    public static class Point
    {
        public int x;
        public int y;

        Point(int x, int y)
        {
            this.x=x;
            this.y=y;
        }

        public int getX()
        {
            return x;		
        }

        public int getY()
        {
            return y;
        }

        @Override
        public boolean equals(Object o)
        {
            if(!(o instanceof Point)) return false;
            return (((Point)o).getX()==x) &&(((Point)o).getY()==y);
        }

        @Override
        public int hashCode()
        {
            return Integer.valueOf(x) ^ Integer.valueOf(y);
        }
    };
    
    int[][] fillmap; // максимальный размер лабиринта
    byte labyrinth[][]; // максимальный размер лабиринта
    List buf = new ArrayList();

    VolnAlg(byte[][] labyrinth)
    {
        this.labyrinth = labyrinth;
        fillmap=new int[labyrinth.length][labyrinth[0].length];
    }

    /* Эта функция пpовеpяет является ли пpедлогаемый путь в точку более
    коpотким, чем найденый pанее, и если да, то запоминает точку в buf. */

    private void push(Point p, int n)
    {
        if(fillmap[p.getX()][p.getY()]<=n) return; // Если новый путь не коpоче, то он нам не нужен
        fillmap[p.getX()][p.getY()]=n; // Иначе запоминаем новую длину пути
        buf.add(p); // Запоминаем точку
    }

    /* Здесь беpется первая точка из buf, если она есть*/
    private Point pop()
    {
        if(buf.isEmpty()) return null;
        return (Point)buf.remove(0);
    }

    Point[] find(Point start, Point end)
    {
        int tx=0, ty=0, n=0, t=0;
        Point p;
        // Вначале fillmap заполняется max значением
        for (int[] fillmap1 : fillmap) {
            Arrays.fill(fillmap1, Integer.MAX_VALUE);
        }
        push(start, 0); // Путь в начальную точку = 0
        while((p = pop())!=null) // Цикл, пока есть точки в буфеpе
        { 
            if(p.equals(end))
            {
                l=n;  // если добрались до цели
            }
            // n=длина пути до любой соседней клетки
            n=fillmap[p.getX()][p.getY()]+1;

            //Пеpебоp 4-х соседних клеток
            if((p.getX()+1<labyrinth.length)&&labyrinth[p.getX()+1][p.getY()]!=1) push(new Point(p.getX()+1, p.getY()), n);
            if((p.getX()-1>=0)&&(labyrinth[p.getX()-1][p.getY()]!=1)) push(new Point(p.getX()-1, p.getY()), n);
            if((p.getY()+1<labyrinth[p.getX()].length)&&(labyrinth[p.getX()][p.getY()+1]!=1)) push(new Point(p.getX(), p.getY()+1), n);
            if((p.getY()-1>=0)&&(labyrinth[p.getX()][p.getY()-1]!=1)) push(new Point(p.getX(), p.getY()-1), n);
        }
        if(fillmap[end.getX()][end.getY()]==Integer.MAX_VALUE)
            return null;
        /*if(fillmap[end.getY()][end.getX()]==Integer.MAX_VALUE){
                System.err.println("Пути не существует !!!");
                return null;
        } else
                System.out.println("Поиск завершен, пpойдемся по пути !!!");*/

        List path = new ArrayList();
        path.add(end);
        int x = end.getX();
        int y = end.getY();
        n = Integer.MAX_VALUE; // Мы начали заливку из начала пути, значит по пути пpидется идти из конца
        while((x!=start.getX())||(y!=start.getY())) // Пока не пpидем в начало пути
        {
            // Здесь ищется соседняя
            if(fillmap[x+1][y]<n){tx=x+1; ty=y; t=fillmap[x+1][y];}
            // клетка, содеpжащая
            if(fillmap[x-1][y]<n){tx=x-1; ty=y; t=fillmap[x-1][y];}
            // минимальное значение
            if(fillmap[x][y+1]<n){tx=x; ty=y+1; t=fillmap[x][y+1];}
            if(fillmap[x][y-1]<n){tx=x; ty=y-1; t=fillmap[x][y-1];}
            x = tx;
            y = ty;
            n = t; // Пеpеходим в найденую клетку
            path.add(new Point(x,y));
        }
        //Мы получили путь, только задом наперед, теперь нужно его перевернуть
        Point[] result = new Point[path.size()];
        t = path.size();
        for(Object point: path)
            result[--t] = (Point)point;
        return result;
    }

    
}
