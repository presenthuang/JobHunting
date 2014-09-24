package general;

public class ArraysandStrings1_06 {
//Given an image represented by an NxN matrix, 
//	where each pixel in the image is 4 bytes, 
//	write a method to rotate the image by 90 degrees. Can you do this in place?
	public void rotate(int[][] matrix, int n){
		transpose(matrix);
		
		//counter-clockwise
		for(int i = 0; i < n/2; ++i){
			for(int j = 0; j < n; ++j){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-i-1][j];
				matrix[n-i-1][j] = temp;
			}
		}
		
		//clockwise
		for(int j = 0; j < n/2; ++j){
			for(int i = 0; i < n; ++i){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n-j-1];
				matrix[i][n-j-1] = temp;
			}
		}
	}

	private void transpose(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		for(int i = 0; i < row-1; ++i){
			for(int j = i+1; j < col; ++j){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		ArraysandStrings1_06 s2 = new ArraysandStrings1_06();
		s2.rotate(matrix, 3);
		for(int i = 0; i < matrix.length; ++i){
			for(int j = 0; j < matrix[0].length; ++j){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
