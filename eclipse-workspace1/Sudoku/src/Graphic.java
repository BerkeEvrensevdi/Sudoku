import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Graphic extends JFrame implements ActionListener {

	JButton Easy, Medium, Hard;
	public int DifficultyDegree = -1;

	public Graphic() {
		JPanel frame = new JPanel();

		frame.setLayout(null);
        frame.setBackground(Color.ORANGE);
		Easy = new JButton("Easy");

		Medium = new JButton("Medium");

		Hard = new JButton("Hard");

		Easy.setBounds(140, 200, 80, 30);
		frame.add(Easy);

		Medium.setBounds(230, 200, 80, 30);
		frame.add(Medium);

		Hard.setBounds(320, 200, 80, 30);
		frame.add(Hard);

		frame.setVisible(true);
		frame.setSize(540, 540);
		this.setSize(540, 540);
		add(frame);

		Easy.addActionListener(this);
		Medium.addActionListener(this);
		Hard.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Easy")) {
			DifficultyDegree = 0;

		} else if (e.getActionCommand().equals("Medium")) {
			DifficultyDegree = 1;
		} else {
			DifficultyDegree = 2;

		}
		setVisible(false);
		new GameFrame(DifficultyDegree);
	}

}
