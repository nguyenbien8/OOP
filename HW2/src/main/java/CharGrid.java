// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {

		int min_row = grid.length, max_row = -1;
		int min_col = grid[0].length, max_col = -1;

		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(grid[i][j] == ch){
					if(i < min_row) min_row = i;
					if(i > max_row) max_row = i;
					if(j < min_col) min_col = j;
					if(j > max_col) max_col = j;
				}
			}
		}
		if(min_row == grid.length || max_row == -1){
			return 0;
		}

		return (max_row - min_row + 1) * (max_col - min_col + 1);
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */

	private int branch_length(int i, int j, int di, int dj, char ch){
		int length = 1;
		int x = i + di;
		int y = j + dj;
		while(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == ch){
			length++;
			x += di;
			y += dj;
		}
		return length;
	}

	public int countPlus() {
		int cnt = 0;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				char ch = grid[i][j];

				int up = branch_length(i, j, -1, 0, ch);
				int down = branch_length(i, j, 1, 0, ch);
				int left = branch_length(i, j, 0, -1, ch);
				int right = branch_length(i, j, 0, 1, ch);

				if(up >= 2 && down >= 2 && left >= 2 && right >= 2 && up == down && left == right){
					cnt++;
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		char[][] grid = {
				{'p', ' ', 'p', ' ', 'p'},
				{'p', 'p', 'x', 'p', 'p'},
				{'p', 'x', 'x', 'x', 'p'},
				{' ', 'p', 'x', 'p', ' '},
				{' ', ' ', 'p', ' ', ' '}
		};
		CharGrid cg = new CharGrid(grid);
		System.out.println(cg.countPlus());

//		char[][] grid = new char[][] {
//				{'c', 'a', 'x'},
//				{'b', ' ', 'b'},
//				{' ', ' ', 'a'},
//		};
//
//		CharGrid cg = new CharGrid(grid);
//		System.out.println(cg.charArea('a'));
	}
	
}
