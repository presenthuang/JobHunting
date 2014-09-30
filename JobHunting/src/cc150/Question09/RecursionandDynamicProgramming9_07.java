package cc150.Question09;

import java.util.LinkedList;

public class RecursionandDynamicProgramming9_07 {
	enum Color{
		Black, White, Red, Yellow, Green
	}
	
	boolean paintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor){
		if(x < 0 || y < 0 || x >= screen[0].length || y > screen.length){
			return false;
		}
		
		if(screen[y][x] == ocolor){
			screen[y][x] = ncolor;
			paintFill(screen, x - 1, y, ocolor, ncolor);
			paintFill(screen, x + 1, y, ocolor, ncolor);
			paintFill(screen, x, y - 1, ocolor, ncolor);
			paintFill(screen, x, y + 1, ocolor, ncolor);
		}
		return true;
	}
	
	boolean paintFill(Color[][] screen, int x, int y, Color ncolor){
		if(screen[y][x] == ncolor)
			return false;
		return paintFill(screen, x, y, screen[y][x], ncolor);
	}
	
	class Point{
		int pos_x, pos_y; 
		Point(int x, int y){
			pos_x = x;
			pos_y = y;
		}
		int x(){
			return pos_x;
		}
		int y(){
			return pos_y;
		}
	}
	
	boolean paintFillBFS(Color[][] screen, int x, int y, Color ocolor, Color ncolor){
		if(x < 0 || y < 0 || x >= screen[0].length || y > screen.length){
			return false;
		}
		LinkedList<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x,y));
		while(!queue.isEmpty()){
			Point current = queue.poll();
			int cur_x = current.x();
			int cur_y = current.y();
			screen[cur_y][cur_x] = ncolor;
			if(cur_y >= 1 && screen[cur_y-1][cur_x] == ocolor){
				queue.offer(new Point(cur_x,cur_y-1));
			}
			if(cur_y < screen.length - 1 && screen[cur_y+1][cur_x] == ocolor){
				queue.offer(new Point(cur_x,cur_y+1));
			}
			if(cur_x >= 1 && screen[cur_y][cur_x-1] == ocolor){
				queue.offer(new Point(cur_x-1,cur_y));
			}
			if(cur_x < screen[0].length - 1 && screen[cur_y][cur_x+1] == ocolor){
				queue.offer(new Point(cur_x+1,cur_y));
			}
		}
		return true;
	}
}
