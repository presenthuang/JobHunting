package array;

public class ArraysandStrings1_07 {
//Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0
	public void setZeros(int[][] matrix){
        boolean firstrowzero = false;
        boolean firstcolumnzero = false;
        
        //check if the first column need to set to zero
        for(int i = 0; i < matrix.length; ++i){
            if(matrix[i][0] == 0){
                firstcolumnzero = true;
                break;
            }
        }
        
        //check if the first row need to set to zero
        for(int i = 0; i < matrix[0].length; ++i){
            if(matrix[0][i] == 0){
                firstrowzero = true;
                break;
            }
        }
        
        //set the corresponding row/column to zero for marks
        for(int i = 1; i < matrix.length;++i){
            for(int j = 1; j < matrix[0].length; ++j){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        //make the whole row/column to be zero
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
	
	public static void main(String[] args) {
		int [][] matrix = {{1,2,3},{4,5,6},{7,0,9}};
		ArraysandStrings1_07 s2 = new ArraysandStrings1_07();
		s2.setZeros(matrix);
		for(int i = 0; i < matrix.length; ++i){
			for(int j = 0; j < matrix[0].length; ++j){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
