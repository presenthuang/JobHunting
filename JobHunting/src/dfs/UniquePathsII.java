package dfs;

public class UniquePathsII {
//	Follow up for "Unique Paths":
//
//		Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
//		An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
//		For example,
//		There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
//		[
//		  [0,0,0],
//		  [0,1,0],
//		  [0,0,0]
//		]
//		The total number of unique paths is 2.
//
//		Note: m and n will be at most 100.
	
//	easy to deal with a 2d array
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid.length == 0)
			return 0;
		if(obstacleGrid[0].length == 0){
			return 0;
		}
		if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1)
			return 0;
		int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
		dp[0][0] = 1;
		for(int i = 1; i < obstacleGrid[0].length; ++i){
			if(obstacleGrid[0][i] == 1)
				dp[0][i] = 0;
			else
				dp[0][i] = dp[0][i-1];
		}
		for(int i = 1; i < obstacleGrid.length; ++i){
			if(obstacleGrid[i][0] == 1)
				dp[i][0] = 0;
			else
				dp[i][0] = dp[i-1][0];
		}
		for(int i = 1; i < obstacleGrid.length; ++i){
			for(int j = 1; j < obstacleGrid[0].length; ++j){
				if(obstacleGrid[i][j] == 0){
					dp[i][j] = dp[i-1][j]+dp[i][j-1];
				}else{
					dp[i][j] = 0;
				}
			}
		}
		return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
