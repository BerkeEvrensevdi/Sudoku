import java.util.Random;

public class SolutionGeneration {
	public Integer[][] cýkan = new Integer[9][9];

	public boolean check(Board y, int rowNum, int columnNum) { // check null
		if (y.cells[rowNum][columnNum] == null)
			return true;
		else
			return false;

	}

	public boolean checkRCB(Board y, int rowNum, int columnNum, Integer Num) {

		for (int i = 0; i < 9; i++) {

			if (y.rows.get(rowNum)[0][i] == Num) {

				return false;
			}

			if (y.columns.get(columnNum)[i][0] == Num) {
				return false;

			}
		}
		int p = 0;
		if (rowNum < 3)
			p = 1;

		else if (rowNum > 2 && rowNum < 6)
			p = 2;
		else if (rowNum > 5)
			p = 3;
		int n = 0;
		if (columnNum < 3)
			n = 1;

		else if (columnNum > 2 && columnNum < 6)
			n = 2;
		else if (columnNum > 5)
			n = 3;

		if (p == 1 && n == 1)
			for (int k = 0; k < 3; k++) {
				for (int i1 = 0; i1 < 3; i1++) {

					if (y.boxes.get(0)[k][i1] == Num) {
						return false;

					}

				}
			}
		if (p == 1 && n == 2)
			for (int k = 0; k < 3; k++) {
				for (int i = 0; i < 3; i++) {

					if (y.boxes.get(1)[k][i] == Num) {
						return false;

					}

				}

			}
		if (p == 1 && n == 3)
			for (int k = 0; k < 3; k++) {
				for (int i = 0; i < 3; i++) {

					if (y.boxes.get(2)[k][i] == Num) {

						return false;
					}

				}

			}
		if (p == 2 && n == 1)
			for (int k = 0; k < 3; k++) {
				for (int i = 0; i < 3; i++) {

					if (y.boxes.get(3)[k][i] == Num) {
						return false;

					}
				}

			}
		if (p == 2 && n == 2)
			for (int k = 0; k < 3; k++) {
				for (int i = 0; i < 3; i++) {

					if (y.boxes.get(4)[k][i] == Num) {
						return false;

					}

				}

			}
		if (p == 2 && n == 3)
			for (int k = 0; k < 3; k++) {
				for (int i = 0; i < 3; i++) {

					if (y.boxes.get(5)[k][i] == Num) {
						return false;

					}

				}

			}

		if (p == 3 && n == 1)
			for (int k = 0; k < 3; k++) {
				for (int i = 0; i < 3; i++) {

					if (y.boxes.get(6)[k][i] == Num) {
						return false;

					}

				}

			}
		if (p == 3 && n == 2)
			for (int k = 0; k < 3; k++) {
				for (int i = 0; i < 3; i++) {

					if (y.boxes.get(7)[k][i] == Num) {
						return false;

					}

				}

			}
		if (p == 3 && n == 3)
			for (int k = 0; k < 3; k++) {
				for (int i = 0; i < 3; i++) {

					if (y.boxes.get(8)[k][i] == Num) {
						return false;

					}

				}

			}
		return true;

	}

	public Integer[][] GenerateSolution() {
		Board y = new Board();
		int counter = 0;
		while (counter != 20) {

			Random generate = new Random();
			Integer Num = generate.nextInt(9) + 1; // 1 den 9 kadar sayý üretiyot
			int rowNum;
			int boxNum = generate.nextInt(9); // box arrayinden 0 dan 8 bir sayý seciyor
			int columnNum;

			switch (boxNum) {
			case 0:
				columnNum = generate.nextInt(3);
				rowNum = generate.nextInt(3);

				if (check(y, rowNum, columnNum))
					if (checkRCB(y, rowNum, columnNum, Num)) {
						y.cells[rowNum][columnNum] = Num;
						y.AssignRowColumnBox();;
						counter++;
					}
				break;
			case 1:
				columnNum = generate.nextInt(3) + 3;
				rowNum = generate.nextInt(3);
				if (check(y, rowNum, columnNum))
					if (checkRCB(y, rowNum, columnNum, Num)) {
						y.cells[rowNum][columnNum] = Num;
						y.AssignRowColumnBox();;
						counter++;
					}
				break;
			case 2:
				columnNum = generate.nextInt(3) + 6;
				rowNum = generate.nextInt(3);
				if (check(y, rowNum, columnNum))
					if (checkRCB(y, rowNum, columnNum, Num)) {
						y.cells[rowNum][columnNum] = Num;
						y.AssignRowColumnBox();;
						counter++;
					}
				break;

			case 3:
				columnNum = generate.nextInt(3);
				rowNum = generate.nextInt(3) + 3;
				if (check(y, rowNum, columnNum))
					if (checkRCB(y, rowNum, columnNum, Num)) {
						y.cells[rowNum][columnNum] = Num;
						y.AssignRowColumnBox();;
						counter++;
					}
				break;

			case 4:
				columnNum = generate.nextInt(3) + 3;
				rowNum = generate.nextInt(3) + 3;
				if (check(y, rowNum, columnNum))
					if (checkRCB(y, rowNum, columnNum, Num)) {
						y.cells[rowNum][columnNum] = Num;
						y.AssignRowColumnBox();;
						counter++;
					}
				break;
			case 5:
				columnNum = generate.nextInt(3) + 6;
				rowNum = generate.nextInt(3) + 3;
				if (check(y, rowNum, columnNum))
					if (checkRCB(y, rowNum, columnNum, Num)) {
						y.cells[rowNum][columnNum] = Num;
						y.AssignRowColumnBox();;
						counter++;
					}
				break;
			case 6:
				columnNum = generate.nextInt(3);

				rowNum = generate.nextInt(3) + 6;
				if (check(y, rowNum, columnNum))
					if (checkRCB(y, rowNum, columnNum, Num)) {
						y.cells[rowNum][columnNum] = Num;
						y.AssignRowColumnBox();;
						counter++;
					}
				break;
			case 7:
				columnNum = generate.nextInt(3) + 3;
				rowNum = generate.nextInt(3) + 6;
				if (check(y, rowNum, columnNum))
					if (checkRCB(y, rowNum, columnNum, Num)) {
						y.cells[rowNum][columnNum] = Num;
						y.AssignRowColumnBox();;
						counter++;
					}
				break;
			case 8:
				columnNum = generate.nextInt(3) + 6;
				rowNum = generate.nextInt(3) + 6;
				if (check(y, rowNum, columnNum))
					if (checkRCB(y, rowNum, columnNum, Num)) {
						y.cells[rowNum][columnNum] = Num;
						y.AssignRowColumnBox();;
						counter++;
					}
				break;
			}

		}

		return y.cells;
	}

	public Integer[][] CreateGAme(int x, Integer[][] c) { // x=0 kolay x=1 orta x=2 zor
		;
		Random generate = new Random();
		int counter = 0;

		switch (x) {
		case 0: { // 30 tane verilice
			while (counter != 30) {

				int row = generate.nextInt(9);
				int column = generate.nextInt(9);
				if (cýkan[row][column] == null) {
					cýkan[row][column] = c[row][column];

					counter++;
				}
			}
		}
			break;
		case 1: { // 25 tane verilicek
			while (counter != 25) {

				int row = generate.nextInt(9);
				int column = generate.nextInt(9);
				if (cýkan[row][column] == null) {
					cýkan[row][column] = c[row][column];

					counter++;
				}
			}
		}
			break;
		case 2: { // 20 tane verilicek
			while (counter != 20) {

				int row = generate.nextInt(9);
				int column = generate.nextInt(9);
				if (cýkan[row][column] == null) {
					cýkan[row][column] = c[row][column];

					counter++;
				}
			}

		}
			break;
		}

		return cýkan;

	}

	public boolean usercheck(int row, int colum, Integer[][] doluaray, Integer[][] oyuncu, int number) {
		if (oyuncu[row][colum] != null)
			return false;
		else {
			if (number == doluaray[row][colum]) {

				return true;
			} else
				return false;
		}
	}

}
