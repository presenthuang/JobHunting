package leetcode.dynamicProgramming;

public class EditDistance {
	
//	Given two words word1 and word2, find the minimum number of steps 
//	required to convert word1 to word2. (each operation is counted as 1 step.)
//
//	You have the following 3 operations permitted on a word:
//
//	a) Insert a character
//	b) Delete a character
//	c) Replace a character
	
//	http://www.programcreek.com/2013/12/edit-distance-in-java/
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        int[][] dp = new int[len1+1][len2+1];
        
        for(int i = 0; i <= len1; ++i)//initiate it to all increase in row.
        	dp[i][0] = i;
        for(int j = 0; j <= len2; ++j)//initiate it to all increase in column.
        	dp[0][j] = j;
        
        for(int i = 0; i < len1; ++i){
        	char wd1 = word1.charAt(i);
        	for(int j = 0; j < len2; ++j){
        		char wd2 = word2.charAt(j);
        		if(wd1 == wd2){//if current two are the same, just copy the value.
        			dp[i+1][j+1] = dp[i][j];
        		}else{
        			int replace = dp[i][j]+1;//num of replace
        			int insert = dp[i][j+1]+1;//num of insert
        			int delete = dp[i+1][j]+1;//num of delete
        			
        			int min = replace > insert ? insert : replace;
        			min = min > delete ? delete : min;
        			dp[i+1][j+1] = min;
        		}
        	}
        }
        return dp[len1][len2];
    }
}
