package interviewQuestions;


import java.util.LinkedList;
import java.util.Queue;

class Point {
	int row;
	int col;

	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
	// setter and getter
}

public class ShortestDistanceToTargets {

	private static void bfs(int row, int col, int[][] maze, boolean[][] helper) {

		Queue<Point> queue = new LinkedList<Point>();
		Queue<Integer> intQueue = new LinkedList<Integer>();

		queue.add(new Point(row, col));
		intQueue.add(0);
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int distance = intQueue.poll();

			int curRow = p.row;
			int curCol = p.col;
			maze[curRow][curCol] += distance; // visit it

			if (curRow - 1 >= 0 && !helper[curRow - 1][curCol]) {
				queue.add(new Point(curRow - 1, curCol));
				intQueue.add(distance + 1);
				helper[curRow - 1][curCol] = true; // visit it
			}
			if (curRow + 1 < maze.length && !helper[curRow + 1][curCol]) {
				queue.add(new Point(curRow + 1, curCol));
				intQueue.add(distance + 1);
				helper[curRow + 1][curCol] = true; // visit it
			}
			if (curCol - 1 >= 0 && !helper[curRow][curCol - 1]) {
				queue.add(new Point(curRow, curCol - 1));
				intQueue.add(distance + 1);
				helper[curRow][curCol - 1] = true; // visit it
			}
			if (curCol + 1 < maze[0].length && !helper[curRow][curCol + 1]) {
				queue.add(new Point(curRow, curCol + 1));
				intQueue.add(distance + 1);
				helper[curRow][curCol + 1] = true; // visit it
			}

		}
	}

	public static void initializeHelperMatrix(boolean[][] helper, int[][] matrix) {
		for (int i = 0; i < helper.length; i++) {
			for (int j = 0; j < helper[0].length; j++) {
				if (matrix[i][j] == -1 || matrix[i][j] == -99) {
					helper[i][j] = true;
				} else {
					helper[i][j] = false;
				}
			}
		}
	}

	public static void printMatrix(int[][] matrix) {
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(String.format("%8d", matrix[i][j]));
			}
			System.out.println();
		}
	}

	// init the maze !!!
	public static int[][] initMaze() {
		int rows = 7;
		int columns = 7;
		int[][] maze = new int[rows][columns];

		// init maze: -99 means walls
		maze[5][4] = maze[5][5] = maze[4][0] = maze[4][1] = maze[0][3] = maze[1][3] = -99;
		// init maze: -1 means targets
		maze[2][1] = maze[5][2] = maze[4][5] = -1;

		return maze;
	}

	public static void main(String[] args) {
		int[][] maze = initMaze();
		int rows = maze.length;
		int columns = maze[0].length;
		boolean[][] helper = new boolean[rows][columns];

		printMatrix(maze);

		// this part can also be converted into a for-loop
		initializeHelperMatrix(helper, maze); // whenever needed
		bfs(2, 1, maze, helper);

		initializeHelperMatrix(helper, maze); // whenever needed
		bfs(5, 2, maze, helper);

		initializeHelperMatrix(helper, maze); // whenever needed
		bfs(4, 5, maze, helper);

		printMatrix(maze);
	}
}
