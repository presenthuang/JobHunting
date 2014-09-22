package dynamicProgramming;

public class MaximalRectangle {
//	Given a 2D binary matrix filled with 0's and 1's, 
//	find the largest rectangle containing all ones and return its area.
	
//	http://blog.csdn.net/muscler/article/details/23641887
	
    public int maximalRectangle(char[][] matrix) {
    	if(matrix == null || matrix.length == 0){
    		return 0;
    	}
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
    	int [] H = new int[n];
    	int [] L = new int[n];
    	int [] R = new int[n];
    	
    	for(int i = 0; i < n; ++i){
    		L[i] = 0;
    		H[i] = 0;
    		R[i] = n;
    	}
    	int res = 0;
    	for(int i = 0; i < m; ++i){
    		int left = 0;
    		int right = n;
    		for(int j = 0; j < n; ++j){
    			if(matrix[i][j] == '1'){
    				H[j]++;
    				L[j] = Math.max(L[j], left);
    			}else {
    	    		L[j] = 0;
    	    		H[j] = 0;
    	    		R[j] = n;
    	    		left = j+1;
				}
    		}
    		for(int j = n - 1; j >= 0; --j){
    			if(matrix[i][j] == '1'){
    				R[j] = Math.min(R[j], right);
    				res = Math.max(res, H[j] * (R[j] - L[j]));
    			}else {
					right = j;
				}
    		}
    	}
    	return res;
    }
}
