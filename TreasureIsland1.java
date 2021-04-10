package amazo;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 char[][] grid = {{'O', 'O', 'O', 'O'},
                 {'D', 'O', 'D', 'O'},
                 {'O', 'O', 'O', 'O'},
                 {'X', 'D', 'D', 'O'}};
		System.out.println(minSteps(grid));

	}

	static int minSteps(char[][] grid) {
		int steps = 1;
		Queue<int[]> temp = new ArrayDeque<>();
		temp.offer(new int[] { 0, 0 });
		int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
				//{ { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		grid[0][0]='D';
		while (!temp.isEmpty()) {
			for (int i = 0; i < temp.size(); i++) {
				int[] curr = temp.poll();
				System.out.println("polling " + curr[0] + ".."+curr[1]);
				for (int[] dir : dirs) {
					int row = curr[0] + dir[0];
					int col = curr[1] + dir[1];
					if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 'D'
						)
						continue;

					if (grid[row][col] == 'X')
						return steps;
					grid[row][col] = 'D';
					temp.offer(new int[] { row, col });
					System.out.println("inserting "+ row+" " + col);
					

				}
			
			}	steps++;
		}
		return -1;

	}

}
