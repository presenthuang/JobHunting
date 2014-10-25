package leetcode.array;

public class MaximumProductSubarray {
//	Find the contiguous subarray within an array (containing at least one number) 
//	which has the largest product.
//
//	For example, given the array [2,3,-2,4],
//	the contiguous subarray [2,3] has the largest product = 6.
    public int maxProduct(int[] A) {
    	int length = A.length;
    	if(length < 1){
    		return 0;
    	}
    	int result = A[0];
    	int max = A[0];
    	int min = A[0];
    	
    	for(int i = 1; i < length; ++i){
    		int current = A[i];
    		int temp_max = max * current;
    		int temp_min = min * current;
    		max = Math.max(Math.max(temp_max, temp_min), current);//compare with three value: max * cur, min * cur, cur
    		min = Math.min(Math.min(temp_max, temp_min), current);//compare with three value: max * cur, min * cur, cur
    		if(max > result)//update current max value.
    			result = max;
    	}
    	return result;
    }
    public static void main(String[] args) {
		int [] A = {-2,3,-2,-4};
		MaximumProductSubarray ma = new MaximumProductSubarray();
		System.out.println(ma.maxProduct(A));
	}
}
