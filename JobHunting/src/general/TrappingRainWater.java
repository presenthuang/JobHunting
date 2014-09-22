package general;

public class TrappingRainWater {
//	Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//	For example, 
//	Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

//	http://fisherlei.blogspot.com/2013/01/leetcode-trapping-rain-water.html
//	对于任何一个坐标，检查其左右的最大坐标，然后相减就是容积。所以，
//	1. 从左往右扫描一遍，对于每一个坐标，求取左边最大值。
//	2. 从右往左扫描一遍，对于每一个坐标，求最大右值。
//	3. 再扫描一遍，求取容积并加和。
//	#2和#3可以合并成一个循环，
	
    public int trap(int[] A) {
      int length = A.length;
      if(length < 2)//if the length is smaller than 2, then no water can be trapped.
    	  return 0;
      int [] maxL = new int[length];//from left to right
      int [] maxR = new int[length];//from right to left
      maxL[0] = 0;//no water can be trapped in the left.
      int max = A[0];
      for(int i = 1; i < length-1; ++i){//iterate from left to see the max value from left
    	  maxL[i] = max;
    	  if(max < A[i])
    		  max = A[i];
      }
      max = A[length-1];
      maxR[length - 1] = 0;
      int ctrap = 0, ttrap = 0;
      for(int i = length-2; i > 0; --i){
    	  maxR[i] = max;//iterate from right to see the max value from right.
    	  ctrap = Math.min(maxL[i], maxR[i]) - A[i];//select the minimum to calculate the volume
    	  if(ctrap > 0)
    		  ttrap += ctrap;
    	  if(max < A[i])
    		  max = A[i];
      }
      return ttrap;
    }
}
