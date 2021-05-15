public class Solver {

	private Integer sudoku[][];
	private int n = 9;

	public Solver(Integer[][] sudoku) {
		this.sudoku = sudoku;
	}

	public Integer[][] solve(SolutionGeneration a) {

		if (!backtrackSolve()) {
			System.out.println("Cannot solve trying");
			Integer[][] b;
			b = a.GenerateSolution();
			Solver f = new Solver(b);
			sudoku = f.solve(a);
			return sudoku;

		} else {
			return sudoku;
		}
	}

	public boolean isSuitableToPutXThere(int i, int j, Integer x) {

		// Is 'x' used in row.
		for (int jj = 0; jj < n; jj++) {
			if (sudoku[i][jj] == x) {
				return false;
			}
		}

		// Is 'x' used in column.
		for (int ii = 0; ii < n; ii++) {
			if (sudoku[ii][j] == x) {
				return false;
			}
		}

		// Is 'x' used in sudoku 3x3 box.
		int boxRow = i - i % 3;
		int boxColumn = j - j % 3;

		for (int ii = 0; ii < 3; ii++) {
			for (int jj = 0; jj < 3; jj++) {
				if (sudoku[boxRow + ii][boxColumn + jj] == x) {
					return false;
				}
			}
		}

		// Everything looks good.
		return true;
	}

	public boolean backtrackSolve() {
		int i = 0, j = 0;
		boolean isThereEmptyCell = false;

		for (int ii = 0; ii < n && !isThereEmptyCell; ii++) {
			for (int jj = 0; jj < n && !isThereEmptyCell; jj++) {
				if (sudoku[ii][jj] == null) {
					isThereEmptyCell = true;
					i = ii;
					j = jj;
				}
			}
		}

		// We've done here.
		if (!isThereEmptyCell) {
			return true;
		}

		for (int x = 1; x < 10; x++) {

			if (isSuitableToPutXThere(i, j, x)) {
				sudoku[i][j] = x;

				if (backtrackSolve()) {
					return true;
				}

				sudoku[i][j] = null; // We've failed.
			}

		}

		return false; // Backtracking
	}
}