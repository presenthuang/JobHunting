package cc150.Question09;

import java.util.ArrayList;
import java.util.HashMap;

public class RecursionandDynamicProgramming9_02 {
//Imagine a robot sitting on the upper left corner of an X by Y grid. The robot can only
//move in two directions: right and down. How many possible paths are there for the
//robot to go from (0,0) to (X,Y)?
//
//Imagine certain spots are "off limits", such that the robot cannot step only them.
//Design an algorithm to find a path for the robot from the top left to the bottom right.
	public class Point{
		int x_pos, y_pos;
		public Point(int x, int y){
			x_pos = x;
			y_pos = y;
		}
	}
	
	public boolean getPath(int x, int y, ArrayList<Point> path, HashMap<Point, Boolean> cache){
		Point p = new Point(x,y);
		if(cache.containsKey(p)){
			return cache.get(p);
		}
		if(x == 0 && y == 0)
			return true;
		boolean success = false;
		if(x >= 1 && isFree(x-1,y)){//Try left.
			success = getPath(x-1, y, path, cache);//Free! Go left.
		}
		
		if(y >= 1 && isFree(x, y-1)){//Try right.
			success = getPath(x, y-1, path, cache);
		}
		if(success){
			path.add(p);//Right way, add to path.
		}
		cache.put(p, success);//Cache result.
		return success;
		
	}

	private boolean isFree(int i, int y) {
		// TODO Auto-generated method stub
		return false;
	}
}
