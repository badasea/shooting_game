package final_term_shooting_game;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class boss extends GraphicObject {
	double dx = -10;
	double dy = -10;
	boolean launched = false;
	static private int off = 1;
	private Clip clip_boss;

	public void loadAudio(String pathName) {
		try {
			clip_boss = AudioSystem.getClip();
			File audioFile = new File(pathName);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip_boss.open(audioStream);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boss(String name) {
		super(name);
		x = 180;
		y = -700;
	}
	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_I) {
			launched = true;
			loadAudio("boss.wav");
			if (off == 1) {
				clip_boss.stop();
				off = 0;
			} else if (off == 0) {
				clip_boss.start();
				off = 1;
			}
		}
	}

	@Override
	public void update() {
		if (y == -450) {
			loadAudio("boss.wav");
			clip_boss.start();
			clip_boss.loop(Clip.LOOP_CONTINUOUSLY);
		}
		if (y == 10000) {
			off = 1;
			clip_boss.close();
		}
		if (y < 100) {
			y += dy;
			dy = +4;
			if (y >= 60) {
				dy = 0;
				y = 60;
				if (y == 60) {
					x -= dx;
					if (x < 20) {
						x -= dx;
						dx = -9.5;
					}
					if (x >= 380) {
						x += dx;
						dx = +9.5;
					}
				}
			}
		}
	}
}