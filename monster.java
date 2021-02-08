package final_term_shooting_game;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class monster extends GraphicObject {
	double dx = -10;
	static private int off = 1;
	private Clip clip;

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
	public monster(String name) {
		super(name);
		x = 0;
		y = -500;
	}

	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_O) {
			loadAudio("shoot_music.wav");
			if (off == 1) {
				clip.stop();
				off = 0;
			} else if (off == 0) {
				clip.start();
				off = 1;
			}
		}
	}
	@Override
	public void update() {
		y += dx;
		if (y < 0) {
			dx = +2;
		}
		if (y > 1000) {
			x = 0;
			y = -500;
		}
	}
}