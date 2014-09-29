package interviewQuestions;

import java.util.Scanner;

public class SudokuVerifier {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String numbers = scan.nextLine();
		scan.close();
		int length = numbers.length();
		if(length != 81){
			System.out.println(0);
			return;
		}
		int [][] sudoku = new int[(int)Math.sqrt(length)][(int)Math.sqrt(length)];
		for(int i = 0; i < sudoku.length; ++i){
			for(int j = 0; j < sudoku[0].length; ++j){
				try {
					sudoku[i][j] = Integer.parseInt(numbers.substring(i*sudoku.length+j,i*sudoku.length+j+1));
				} catch (NumberFormatException e) {
					e.printStackTrace();
					return;
				}
			}
		}
		if(validSudoku(sudoku)){
			System.out.println(1);
		}else{
			System.out.println(0);
		}
	}
	
	
	
	private static boolean validSudoku(int[][] sudoku) {
		int row = sudoku.length;
		int col = sudoku[0].length;
		boolean [] visited;
		
		for(int i = 0; i < row; ++i){
			visited = new boolean [row+1];
			for(int j = 0; j < col; ++j){
				if(visited[sudoku[i][j]]){
					return false;
				}else{
					visited[sudoku[i][j]] = true;
				}
			}
		}
		
		for(int j = 0; j < col; ++j){
			visited = new boolean [row+1];
			for(int i = 0; i < row; ++i){
				if(visited[sudoku[i][j]]){
					return false;
				}else{
					visited[sudoku[i][j]] = true;
				}
			}
		}
		
		for(int step_i = 0; step_i < row; step_i += 3){
			for(int step_j = 0; step_j < col; step_j += 3){
				visited = new boolean [row+1];
				for(int i = step_i; i < step_i + 3; ++i){
					for(int j = step_j; j < step_j + 3; ++j){
						if(visited[sudoku[i][j]])
							return false;
						else 
							visited[sudoku[i][j]] = true;
					}
				}
			}
		}
		return true;
	}
}
