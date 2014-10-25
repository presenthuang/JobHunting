package leetcode.dynamicProgramming;

public class UniquePaths {
//	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//	The robot can only move either down or right at any point in time. The robot is trying to reach 
//	the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//	How many possible unique paths are there?
	
	//simple dp
	public int uniquePaths(int m, int n) {
        if(m < 0 || n < 0)
            return 0;
        if(m == 0 || n == 0)
            return 1;
        int[][] table = new int[m][n];
        for(int i = 0; i < table.length; i++){
            table[i][0] = 1;
        }
        for(int j = 0; j < table[0].length; j++){
            table[0][j] = 1;
        }
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                table[i][j] = table[i-1][j] + table[i][j-1];
            }
        }
        return table[m-1][n-1];
    }
	
}
