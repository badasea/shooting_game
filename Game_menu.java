package final_term_shooting_game;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

class Game_menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Game_menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
		setTitle("Dragon Flights Game");
		getContentPane().add(new Game());

		setSize(750, 1000);
		Dimension frameSize = getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}