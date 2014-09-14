package edu.columbia.xh2211.leetcode;

public class Sqrt_x_ {
//	Implement int sqrt(int x).
//
//	Compute and return the square root of x.
    public int sqrt(int x) {
    	if(x == 0 || x == 1)
    		return x;
    	return binarySearch(1,x,x);
    }
    
    private int binarySearch(long left, long right, long target){
    	if(left > right)
    		return (int)right;
    	
    	long mid = (left+right)/2;
    	
    	if(mid * mid == target)
    		return (int)mid;
    	else if(mid * mid < target){
    		return binarySearch(mid+1,right,target);
    	}else{
    		return binarySearch(left,mid-1,target);
    	}
    }
}
