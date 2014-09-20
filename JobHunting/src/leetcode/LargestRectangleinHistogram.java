package leetcode;

import java.util.Stack;

public class LargestRectangleinHistogram {
//	Given n non-negative integers representing the histogram's bar 
//	height where the width of each bar is 1, find the area of largest rectangle in the histogram.
//
//
//	Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//
//	The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//	For example,
//	Given height = [2,1,5,6,2,3],
//	return 10.
	
//	http://blog.csdn.net/abcbc/article/details/8943485
	
    public int largestRectangleArea(int[] height) {
        int area = 0;
        Stack<Integer> heightStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        
        for(int i = 0; i < height.length; ++i){
        	if(heightStack.empty() || heightStack.peek() <= height[i]){
        		heightStack.push(height[i]);
        		indexStack.push(i);
        	}else if(heightStack.peek() > height[i]){
        		int j = 0;
        		while(!heightStack.empty() && heightStack.peek() > height[i]){
        			j = indexStack.pop(); 
        			int currArea = (i - j) * heightStack.pop();
        			if(currArea > area)
        				area = currArea;
        		}
        		heightStack.push(height[i]);
        		indexStack.push(j);
        	}
        }
        while(!heightStack.empty()){
        	int currArea = (height.length - indexStack.pop()) * heightStack.pop();
        	if(currArea > area)
				area = currArea;
        }
        return area;
    }
}
