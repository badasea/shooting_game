package final_term_shooting_game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class GraphicObject {

	BufferedImage img = null;
	int x = 0, y = 0, dx = 0;

	public GraphicObject(String fileName) {
		try {
			img = ImageIO.read(new File(fileName));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}

	public void keyPressed(KeyEvent e) {
	}

	public void update() {
	}
}

public class Game_main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton start_button;
	private JButton exit_button;
	ImageIcon icon;
	private JMenuBar menuBar;
	private JMenu Menu;
	private JMenuItem MenuItem_exit;
	private JMenuItem MenuItem_developer;
	private JMenuItem MenuItem_start;
	private JMenuItem MenuItem_help;
	private JButton help_button;

	private Clip clip;
	private Clip clip_start;
	private JButton music_Button;
	private int off = 1;

	private void loadAudio(String pathName) {
		try {
			clip = AudioSystem.getClip();
			File audioFile = new File(pathName);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip.open(audioStream);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadAudio_start(String pathName) {
		try {
			clip_start = AudioSystem.getClip();
			File audioFile = new File(pathName);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip_start.open(audioStream);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Game_main() {
		loadAudio("Music.wav");
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
		JPanel p = new JPanel();
		p.setLayout(null);
		start_button = new JButton("");
		start_button.setIcon(new ImageIcon("start_button.png"));
		start_button.addActionListener(new Listener());
		p.add(start_button);
		exit_button = new JButton("");
		exit_button.setIcon(new ImageIcon("exit_button.png"));
		exit_button.addActionListener(new Listener());
		p.add(exit_button);
		start_button.setBounds(104, 352, 85, 48);
		exit_button.setBounds(104, 403, 85, 42);
		getContentPane().add(p);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 42, 23);
		p.add(menuBar);

		Menu = new JMenu("메뉴");
		menuBar.add(Menu);

		MenuItem_start = new JMenuItem("게임 시작");
		MenuItem_start.addActionListener(new Listener());
		Menu.add(MenuItem_start);

		MenuItem_developer = new JMenuItem("제작자");
		MenuItem_developer.addActionListener(new Listener());

		MenuItem_help = new JMenuItem("게임 조작법");
		MenuItem_help.addActionListener(new Listener());
		Menu.add(MenuItem_help);
		Menu.add(MenuItem_developer);

		MenuItem_exit = new JMenuItem("게임 종료");
		MenuItem_exit.addActionListener(new Listener());
		Menu.add(MenuItem_exit);

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("background.jpg"));
		background.setBounds(0, 0, 484, 461);
		p.add(background);

		help_button = new JButton("");
		help_button.setIcon(new ImageIcon("help_button.png"));
		help_button.setBounds(245, 15, 22, 20);
		help_button.addActionListener(new Listener());
		p.add(help_button);

		music_Button = new JButton("");
		music_Button.setIcon(new ImageIcon("music_icon.png"));
		music_Button.setBounds(217, 15, 22, 20);
		music_Button.addActionListener(new Listener());
		p.add(music_Button);

		setTitle("Dragon Flights Game");
		setSize(301, 496);
		Dimension frameSize = getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == start_button) {
				loadAudio_start("start.wav");
				clip_start.start();
				new Game_menu();
				clip.close();
				dispose();
			}
			if (e.getSource() == music_Button) {
				loadAudio_start("start.wav");
				clip_start.start();
				if (off == 1) {
					clip.stop();
					clip_start.stop();
					off = 0;
				} else if (off == 0) {
					clip.start();
					clip_start.start();
					off = 1;
				}
			}
			if (e.getSource() == exit_button) {
				loadAudio_start("start.wav");
				clip_start.start();
				System.exit(0);
			}
			if (e.getSource() == MenuItem_start) {
				loadAudio_start("start.wav");
				clip_start.start();
				new Game_menu();
				clip.stop();
				dispose();
			}
			if (e.getSource() == MenuItem_developer) {
				loadAudio_start("start.wav");
				clip_start.start();
				JOptionPane.showMessageDialog(null, "https://github.com/jungbada269");
			}
			if (e.getSource() == MenuItem_exit) {
				loadAudio_start("start.wav");
				clip_start.start();
				System.exit(0);
			}
			if (e.getSource() == help_button) {
				loadAudio_start("start.wav");
				clip_start.start();
				new Game_Help();
			}
			if (e.getSource() == MenuItem_help) {
				loadAudio_start("start.wav");
				clip_start.start();
				new Game_Help();
			}

		}
	}

	public static void main(String[] args) {
		new Game_main();
	}
}