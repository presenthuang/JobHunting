package array;

public class SetMatrixZeroes {
//	Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
//
//	click to show follow up.
//
//	Follow up:
//	Did you use extra space?
//	A straight forward solution using O(mn) space is probably a bad idea.
//	A simple improvement uses O(m + n) space, but still not the best solution.
//	Could you devise a constant space solution?

//	check if first row and column are zero or not
//	mark zeros on first row and column
//	use mark to set elements
//	set first column and row by using marks in step 1	
	
//	have an solution with only constant space
	public void setZeroes(int[][] matrix) {
        boolean firstrowzero = false;
        boolean firstcolumnzero = false;
        
        for(int i = 0; i < matrix.length; ++i){
            if(matrix[i][0] == 0){
                firstcolumnzero = true;
                break;
            }
        }
        for(int i = 0; i < matrix[0].length; ++i){
            if(matrix[0][i] == 0){
                firstrowzero = true;
                break;
            }
        }
        
        for(int i = 1; i < matrix.length;++i){
            for(int j = 1; j < matrix[0].length; ++j){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < matrix.length; ++i){
            for(int j = 1; j < matrix[0].length; ++j){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(firstcolumnzero == true){
            for(int i = 0; i < matrix.length; ++i){
                matrix[i][0] = 0;
            }
        }
        if(firstrowzero == true){
            for(int i = 0; i < matrix[0].length; ++i){
                matrix[0][i] = 0;
            }
        }
    }
}
