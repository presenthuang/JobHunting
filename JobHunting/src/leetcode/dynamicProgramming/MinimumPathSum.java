package leetcode.dynamicProgramming;

public class MinimumPathSum {
//	Given a m x n grid filled with non-negative numbers, 
//	find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
//	Note: You can only move either down or right at any point in time.
	
//	traditional dp prob should be improved.
    public int minPathSum(int[][] grid) {
        if(grid == null)
        	return 0;
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] path = new int[m][n];
        path[0][0] = grid[0][0];
        
        for(int i = 1; i < m; ++i){
        	path[i][0] = path[i-1][0] + grid[i][0];
        }
        
        for(int j = 1; j < n; ++j){
        	path[0][j] = path[0][j-1] + grid[0][j];
        }
        
        for(int i = 1; i < m; ++i){
        	for(int j = 1; j < n; ++j){
        		path[i][j] = Math.min(path[i-1][j], path[i][j-1])+grid[i][j];
        	}
        }
        return path[m-1][n-1];
    }
}
