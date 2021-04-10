package amazo;

import java.util.HashSet;
import java.util.Set;

class RottenOranges {
	public int orangesRotting(int[][] grid) {

		Set<String> rotten = new HashSet<>();
		Set<String> fresh = new HashSet<>();
		int minutes = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[i].length; j++)
				if (grid[i][j] == 2)
					rotten.add("" + i + j);
				else if (grid[i][j] == 1)
					fresh.add("" + i + j);

		int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		while (fresh.size() > 0) {

			Set<String> infected = new HashSet<>();
			for (String rott : rotten) {
				int i = rott.charAt(0) - '0';
				int j = rott.charAt(1) - '0';

				for (int[] x : directions) {
					int newI = i + x[0];
					int newJ = j + x[1];
					if (fresh.contains("" + newI + newJ)) {
						fresh.remove("" + newI + newJ);
						infected.add("" + newI + newJ);

					}

				}

			}
			if (infected.size() == 0)
				return -1;
			rotten = infected;
			minutes++;

		}
		return minutes;

	}
}