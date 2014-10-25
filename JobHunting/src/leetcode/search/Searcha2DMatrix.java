package leetcode.search;

public class Searcha2DMatrix {
//	Write an efficient algorithm that searches for a value in an m x n matrix. 
//	This matrix has the following properties:
//
//		Integers in each row are sorted from left to right.
//		The first integer of each row is greater than the last integer of the 
//		previous row.
//		
//		For example,
//
//		Consider the following matrix:
//
//		[
//		  [1,   3,  5,  7],
//		  [10, 11, 16, 20],
//		  [23, 30, 34, 50]
//		]
//		Given target = 3, return true.
	
//	We could see it as just one-dimension array and query with binary search
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
    		return false;
    	}
    	int height = matrix.length;
    	int width = matrix[0].length;
    	int start = 0;
    	int end = height * width - 1;
    	
    	while(start <= end){
    		int mid = (start + end) / 2;
    		int midX = mid / width;
    		int midY = mid % width;
    		
    		if(matrix[midX][midY] == target){
    			return true;
    		}
    		if(matrix[midX][midY] < target){
    			start = mid + 1;
    		}else{
    			end = mid - 1;
    		}
    	}
    	return false;
    }
	
	
}
