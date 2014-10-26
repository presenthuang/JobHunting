package leetcode.array;

public class RotateImage {
//	You are given an n x n 2D matrix representing an image.
//
//	Rotate the image by 90 degrees (clockwise).
//
//	Follow up:
//	Could you do this in-place?
	
    public void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return;
        int length = matrix.length;
        int width = matrix[0].length;
        transpose(matrix);
        //clockwise
        for(int j = 0; j < width/2; ++j){
            for(int i = 0; i < length; ++i){
                int temp = matrix[i][width-j-1];
                matrix[i][width-j-1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
    
    
    private void transpose(int[][] matrix){
        for(int i = 0; i < matrix.length; ++i){
            for(int j = i+1; j < matrix[0].length; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
