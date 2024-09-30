//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	private boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		int rows = grid.length;
		int cols = grid[0].length;
		for(int i = 0; i < rows; i++){
			boolean fullRow = true;
			for(int j = 0; j < cols; j++){
				if(!grid[i][j]){
					fullRow = false;
					break;
				}
			}
			if(fullRow){
				for(int k = i; k < rows - 1; k++){
					for(int j = 0; j < cols; j++){
						grid[k][j] = grid[k + 1][j];
					}
				}
				for(int j = 0; j < cols; j++){
					grid[rows - 1][j] = false;
				}
				i--;
			}
		}
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid;
	}
}
