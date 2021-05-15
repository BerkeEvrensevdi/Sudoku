import java.util.ArrayList;

public class Board {

	Integer[][] cells;
	protected ArrayList<Integer[][]> boxes;
	protected ArrayList<Integer[][]> columns;
	protected ArrayList<Integer[][]> rows;

	public Board() {
		cells = new Integer[9][9];

		rows = new ArrayList<Integer[][]>();
		for (int j = 0; j < 9; j++) {
			rows.add(new Integer[1][9]);
		}
		columns = new ArrayList<Integer[][]>();
		for (int j = 0; j < 9; j++) {
			columns.add(new Integer[9][1]);
		}
		boxes = new ArrayList<Integer[][]>();
		for (int j = 0; j < 9; j++) {
			boxes.add(new Integer[3][3]);
		}
		
	}

	public void AssignRowColumnBox() {

		for (int i = 0; i < 9; i++) {
			for (int k = 0; k < 9; k++) {

				rows.get(i)[0][k] = cells[i][k];

			}

		}

		for (int k = 0; k < 9; k++) {
			for (int i = 0; i < 9; i++) {

				columns.get(k)[i][0] = cells[i][k];

			}

		}

		for (int i = 0; i < 9; i++) {
			int y = 0;
			for (int k = 0; k < 9; k++) {
				if (i < 3) {
					if (k != 0 && k % 3 == 0) {
						y++;
					}

					boxes.get(i)[y][k % 3] = cells[y][k % 3 + 3 * i];

				} else if (i < 6) {
					if (k != 0 && k % 3 == 0) {
						y++;
					}
					boxes.get(i)[y][k % 3] = cells[y + 3][k % 3 + 3 * (i % 3)];

				} else {
					if (k != 0 && k % 3 == 0) {
						y++;
					}
					boxes.get(i)[y][k % 3] = cells[y + 6][k % 3 + 3 * (i % 3)];

				}
			}

		}

	}

}
