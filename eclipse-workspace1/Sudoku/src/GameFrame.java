import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class GameFrame {

	
	public GameFrame(int DifficultyDegree) {
		
		
		final Font FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 20);
		Graph g = new Graph();
		JFrame f1 = g;
		Integer[][] oyuncuyaverilicekolan = g.oyuncu_arrayi(DifficultyDegree);
		f1.setLayout(new FlowLayout());
		g.board.setPreferredSize(new Dimension(540, 540));
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				Integer xy = oyuncuyaverilicekolan[i][j];
				if (xy != null) {

					g.cells[i][j].setText(String.valueOf(xy));
					g.cells[i][j].setFocusable(false);
					g.cells[i][j].setEditable(false);
					g.cells[i][j].setBackground(Color.YELLOW);
				}
				g.cells[i][j].setHorizontalAlignment(JTextField.CENTER);
				g.cells[i][j].setFont(FONT_NUMBERS);

			}

		}

		f1.setSize(1366,768);
		f1.setVisible(true);
	}
}
