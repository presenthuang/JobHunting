package array;

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
    	int r = A[0];
    	int max_p = A[0];
    	int min_p = A[0];
    	
    	for(int i = 1; i < length; ++i){
    		int temp_max = max_p * A[i];
    		int temp_min = min_p * A[i];
    		int current = A[i];
    		max_p = Math.max(Math.max(temp_max, temp_min), current);
    		min_p = Math.min(Math.min(temp_max, temp_min), current);
    		if(max_p > r)
    			r = max_p;
    	}
    	return r;
    }
    
    public static void main(String[] args) {
		int [] A = {-2,3,-2,-4};
		MaximumProductSubarray ma = new MaximumProductSubarray();
		System.out.println(ma.maxProduct(A));
	}

}
