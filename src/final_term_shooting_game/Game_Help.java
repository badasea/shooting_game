package final_term_shooting_game;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game_Help extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon icon;

	public Game_Help() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
		JPanel p = new JPanel();
		p.setLayout(null);
		getContentPane().add(p);

		JLabel help_background = new JLabel("");
		help_background.setIcon(new ImageIcon("help_menu.png"));
		help_background.setBounds(0, 0, 400, 539);
		p.add(help_background);

		setTitle("Dragon Flights Game 조작법");
		setSize(415, 580);
		Dimension frameSize = getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Game_main();
	}
}
