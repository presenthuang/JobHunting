package dynamicProgramming;

public class MaximumSubarray {
//	Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//
//	For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
//	the contiguous subarray [4,−1,2,1] has the largest sum = 6.
//
//	click to show more practice.
//
//	More practice:
//	If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
    
	//Easy dp, but be careful what we save is the last biggest num.
	public int maxSubArray(int[] A) {
        if(A == null || A.length == 0){
        	return 0;
        }
        int[] sum = new int[A.length];
        sum[0] = A[0];
        int max = A[0];
        for(int i = 1; i < A.length; ++i){
        	sum[i] = Math.max(A[i], sum[i-1]+A[i]);
        	max = Math.max(sum[i], max);
        }
        return max;
    }
}
