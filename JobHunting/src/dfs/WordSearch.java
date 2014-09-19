package dfs;

public class WordSearch {
//	Given a 2D board and a word, find if the word exists in the grid.
//
//	The word can be constructed from letters of sequentially adjacent cell, 
//	where "adjacent" cells are those horizontally or vertically neighboring. 
//	The same letter cell may not be used more than once.
//
//	For example,
//	Given board =
//
//	[
//	  ["ABCE"],
//	  ["SFCS"],
//	  ["ADEE"]
//	]
//	word = "ABCCED", -> returns true,
//	word = "SEE", -> returns true,
//	word = "ABCB", -> returns false.
	
    public boolean exist(char[][] board, String word) {
        boolean [][] used = new boolean [board.length][board[0].length];
        for(int row = 0; row < board.length; ++row){
        	for(int col = 0; col < board[0].length; ++col){
        		if(helper(board,word,used,row,col,0))
        			return true;
        	}
        }
        return false;
    }

	private boolean helper(char[][] board, String word, boolean[][] used, int i, int j, int current) {
		if (board[i][j]!=word.charAt(current)|| used[i][j])
			return false;
		used[i][j] = true;
		if(current == word.length()-1)
			return true;
		if(i - 1 >= 0 && helper(board,word,used,i-1,j,current+1))
			return true;
		
		if(j - 1 >= 0 && helper(board,word,used,i,j-1,current+1))
			return true;
		
		if(i + 1 < board.length && helper(board,word,used,i+1,j,current+1))
			return true;
		
		if(j + 1 < board[0].length && helper(board,word,used,i,j+1,current+1))
			return true;
		
		used[i][j] = false;
		return false;
	}
}
