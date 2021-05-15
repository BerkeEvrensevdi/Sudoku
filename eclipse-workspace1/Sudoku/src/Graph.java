
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.text.DateFormat.Field;
import java.util.EventListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MouseInputListener;

public class Graph extends JFrame implements ActionListener {

	public int SelectedX = -1;
	public int SelectedY = -1;
	JButton[] buttons = new JButton[10];
	public JTextField cells[][] = new JTextField[9][9];
	public JPanel board = new JPanel();
	public SolutionGeneration x;
	public Integer[][] b;
	public Integer[][] v;
	int score = 0;
	JLabel yazi = new JLabel("(Please Press Submit Button When You Finish)");
	JLabel scoreLabel = new JLabel("Score: 0");
	JLabel hintLabel = new JLabel("Hint: 3");

	JButton hint = new JButton("Hint");
	JButton giveup = new JButton("Give Up");
	JButton clear = new JButton("Clear");
	JButton submit = new JButton("Submit");
	JButton restart = new JButton("Restart");
	JButton hintbuy = new JButton("Hint Buy");
	public int counter = 3;

	public Graph() {
		super("Sudoku");

		add(yazi);
		add(hintLabel);
		add(scoreLabel);
		add(hintbuy);
		hintbuy.addActionListener(this);

		add(hint);

		hint.addActionListener(this);
		add(giveup);
		giveup.addActionListener(this);
		add(clear);
		clear.addActionListener(this);
		add(submit);
		submit.addActionListener(this);
		add(restart);
		restart.addActionListener(this);

		x = new SolutionGeneration();
		b = x.GenerateSolution(); // 20 sayýlýk array üretiyor generator
		Solver f = new Solver(b);
		this.v = f.solve(x); // b çözülmüþ hali // b yi yani 20 lik arrayi
								// çözüyor

		setLayout(new GridLayout());

		for (int a = 0; a < 9; a++) {
			for (int b = 0; b < 9; b++) {
				cells[a][b] = new JTextField(1);
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board = new JPanel(new GridLayout(9, 9));
			}

		}

		for (int i = 0; i < 9; i++) {
			for (int k = 0; k < 9; k++) {
				board.add(cells[i][k]);
			}
		}
		add(board);

		for (int i = 0; i < 9; i++) {
			for (int k = 0; k < 9; k++) {
				cells[i][k].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

				if (k == 2 || k == 5 || k == 8) {
					if (i == 2 || i == 5 || i == 8) {
						cells[i][k].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, Color.BLACK));
					} else {

						cells[i][k].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, Color.BLACK));
					}
				}
				if (i == 2 || i == 5 || i == 8) {
					if (k != 2 && k != 5 && k != 8) {
						cells[i][k].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 1, Color.BLACK));
					}
				}
				if (k == 0) {
					if (i % 3 != 2) {
						cells[i][k].setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.BLACK));
					} else {
						cells[i][k].setBorder(BorderFactory.createMatteBorder(1, 5, 5, 1, Color.BLACK));
					}
				}
				if (i == 0) {
					if (k % 3 != 2) {
						cells[i][k].setBorder(BorderFactory.createMatteBorder(5, 1, 1, 1, Color.BLACK));
						if (k == 0) {
							cells[i][k].setBorder(BorderFactory.createMatteBorder(5, 5, 1, 1, Color.BLACK));
						}
					}

					else {
						cells[i][k].setBorder(BorderFactory.createMatteBorder(5, 1, 1, 5, Color.BLACK));
					}
				}

			}
		}

		for (int i = 1; i < buttons.length; i++) {
			buttons[i] = new JButton(i + "");

			add(buttons[i]);
			buttons[i].addActionListener(this);
		}
		for (int i = 0; i < 9; i++) {
			for (int k = 0; k < 9; k++) {
				cells[i][k].addFocusListener(new FocusListener() {

					public void focusGained(FocusEvent e) {

						SelectedX = e.getComponent().getX() / 60;
						SelectedY = e.getComponent().getY() / 60;
						cells[SelectedY][SelectedX].setBackground(Color.lightGray);

					}

					public void focusLost(FocusEvent e) {
						cells[SelectedY][SelectedX].setBackground(Color.WHITE);

					}
				});
			}
		}

	}

	public Integer[][] oyuncu_arrayi(int b) {
		Integer[][] oyuncuyaverilicekolan;
		oyuncuyaverilicekolan = x.CreateGAme(b, v);
		return oyuncuyaverilicekolan;

	}

	public static void restartttt() {
		Graphic login = new Graphic();
		login.setVisible(true);
	}

	public static void infoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(cells.length);
		String str = e.getActionCommand();
		System.out.println(str);
		if (str.equals("Restart")) {
			setVisible(false);
			restartttt();

		}

		else if (str.equals("Hint Buy")) {
			if (score >= 25) {
				counter++;
				hintLabel.setText("hint : " + counter);
				score = score - 25;
				scoreLabel.setText("Score: " + score);

			} else
				infoBox("There is no enough score for buy hint\nscore: " + score, "hint buy");
		} else if (str.equals("Hint")) {
			if (counter > 0) {
				cells[SelectedY][SelectedX].setText("" + v[SelectedY][SelectedX]);
				cells[SelectedY][SelectedX].setFocusable(false);
				cells[SelectedY][SelectedX].setEditable(false);
				cells[SelectedY][SelectedX].setBackground(Color.green);
				counter--;
				hintLabel.setText("hint : " + counter);
			} else
				infoBox("There is no hint", "hint");
		}

		else if (str.equals("Give Up")) {
			System.out.println("cc" + cells[0][0].getText());
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (cells[i][j].getText().equals("")) {
						cells[i][j].setText("" + v[i][j]);
						cells[i][j].setFocusable(false);
						cells[i][j].setEditable(false);
						cells[i][j].setBackground(Color.BLUE);
						score = score - 5;
						scoreLabel.setText("Score: " + score);

					}
				}
			}

			infoBox("Game finish\n" + "score:" + score + "\nNot this time,Maybe Later", "game status");
		} else if (str.equals("Clear")) {
			cells[SelectedY][SelectedX].setText(null);
			cells[SelectedY][SelectedX].setBackground(Color.WHITE);
		} else if (str.equals("Submit")) {
			infoBox("Game finish\n" + "score:" + score, "game status");
		}

		else {
			cells[SelectedY][SelectedX].setText(str);

			if (Integer.parseInt(cells[SelectedY][SelectedX].getText()) == v[SelectedY][SelectedX]) {
				cells[SelectedY][SelectedX].setEditable(false);
				cells[SelectedY][SelectedX].setFocusable(false);

				cells[SelectedY][SelectedX].setBackground(Color.green);
				score = score + 5;

				scoreLabel.setText("Score: " + score);

			} else {
				cells[SelectedY][SelectedX].setBackground(Color.RED);
				score--;

				scoreLabel.setText("Score: " + score);

			}
		}
	}

}