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
		int min_col = grid[0].length, max_cow = -1;

		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(grid[i][j] == ch){
					if(i < min_row) min_row = i;
					if(i > max_row) max_row = i;
					if(j < min_col) min_col = j;
					if(j > max_cow) max_cow = j;
				}
			}
		}
		if(min_row == grid.length || max_row == -1){
			return 0;
		}

		return (max_row - min_row + 1) * (max_cow - min_col + 1);
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {


		return 0;
	}

	public static void main(String[] args) {
		char[][] arr = {
				{'a', 'a', 'b'},
				{'a', 'c', 'c'},
				{'a', 'a', 'b'}
		};
		CharGrid cg = new CharGrid(arr);
		System.out.println(cg.charArea('a'));
	}
	
}
