package leetcode.array;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[10];
        if(board.length != 9 && board[0].length != 9){
            return false;
        }
        int length = board.length;
        int width = board[0].length;
        //check if each row is valid
        for(int i = 0; i < length; ++i){
            resetVisited(visited);
            for(int j = 0; j < width; ++j){
                if(board[i][j] == '.')
                    continue;
                if(visited[board[i][j] - '0'])
                    return false;
                else
                    visited[board[i][j] - '0'] = true;
            }
        }
        
        //check if each column is valid
        for(int j = 0; j < width; ++j){
            resetVisited(visited);
            for(int i = 0; i < length; ++i){
                if(board[i][j] == '.')
                    continue;
                if(visited[board[i][j] - '0'])
                    return false;
                else
                    visited[board[i][j] - '0'] = true;
            }
        }
        //check if each 3 * 3 box is valid
        for(int rstart = 0; rstart < length; rstart+=3){
            for(int lstart = 0; lstart < width; lstart+=3){
                resetVisited(visited);
                for(int i = rstart; i < rstart+3; ++i){
                    for(int j = lstart; j < lstart+3; ++j){
                        if(board[i][j] == '.')
                            continue;
                        if(visited[board[i][j] - '0'])
                            return false;
                        else
                           visited[board[i][j] - '0'] = true; 
                    }
                }
            }
        }
        return true;
    }
    
    private void resetVisited(boolean[] visited){
        for(int i = 0; i < visited.length; ++i){
            visited[i] = false;
        }
    }
}
