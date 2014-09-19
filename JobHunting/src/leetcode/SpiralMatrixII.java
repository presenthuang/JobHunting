package leetcode;

public class SpiralMatrixII {
//	Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
//	For example,
//	Given n = 3,
//
//	You should return the following matrix:
//	[
//	 [ 1, 2, 3 ],
//	 [ 8, 9, 4 ],
//	 [ 7, 6, 5 ]
//	]
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int x = 0;
        int y = 0;
        int row = n;
        int col = n;
        int cur = 0;
        int total = n * n;
        while(cur != total){
        	for(int k = y; k < col; ++k){
				result[x][k] = ++cur;
			}
			x++;
			
			for(int k = x; k < row; ++k){
				result[k][col-1] = ++cur;
			}
			col--;
			
			for(int k = col-1; k >= y; --k){
				result[row-1][k] = ++cur;
			}
			row--;
			
			for(int k = row - 1; k >= x; --k){
				result[k][y] = ++cur;
			}
			y++;
        }
        return result;
    }
    
    public static void main(String[] args){
    	SpiralMatrixII s =  new SpiralMatrixII();
    	int[][] result = s.generateMatrix(3);
    	for(int i = 0; i < result.length; ++i){
    		for(int j = 0; j < result[0].length; ++j){
    			System.out.print(result[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
}
