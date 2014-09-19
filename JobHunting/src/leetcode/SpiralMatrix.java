package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
//	Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//			For example,
//			Given the following matrix:
//
//			[
//			 [ 1, 2, 3 ],
//			 [ 4, 5, 6 ],
//			 [ 7, 8, 9 ]
//			]
//			You should return [1,2,3,6,9,8,7,4,5].
	
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        	return result;
        int row = matrix.length;
        int col = matrix[0].length;
        int total = row * col;
        int x = 0;
        int y = 0;
        int flag = 0;
        
        while(result.size() != total){
        	switch(flag){
        		case 0://go from left to right
        			for(int k = y; k < col; ++k){
        				result.add(matrix[x][k]);
        			}
        			x++;
        			flag = 1;
        			break;
        		case 1://go from up to down
        			for(int k = x; k < row; ++k){
        				result.add(matrix[k][col-1]);
        			}
        			flag = 2;
        			col--;
        			break;
        		case 2://go from right to left
        			for(int k = col-1; k >= y; --k){
        				result.add(matrix[row-1][k]);
        			}
        			flag = 3;
        			row--;
        			break;
        		case 3:
        			for(int k = row - 1; k >= x; --k){
        				result.add(matrix[k][y]);
        			}
        			flag = 0;
        			y++;
        			break;
        	}
        }
        return result;
    }
}
