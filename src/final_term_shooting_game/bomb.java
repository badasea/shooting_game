package final_term_shooting_game;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class bomb extends GraphicObject {
	private Clip clip_shoot;
	boolean launched = false;
	static private int off = 1;

	public bomb(String name) {
		super(name);
		x = 0;
		y = -200;
	}

	private void loadAudio_shoot(String pathName) {
		try {
			clip_shoot = AudioSystem.getClip();
			File audioFile = new File(pathName);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip_shoot.open(audioStream);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void keyPressed(KeyEvent event, int x, int y) {
		if (event.getKeyCode() == KeyEvent.VK_X) {
			launched = true;
			this.y = 1000;
			loadAudio_shoot("bomb_music.wav");
			if (off == 1) {
				clip_shoot.start();
			}
		}
		if (event.getKeyCode() == KeyEvent.VK_O) {
			launched = true;
			loadAudio_shoot("bomb_music.wav");
			if (off == 1) {
				clip_shoot.stop();
				off = 0;
			} else if (off == 0) {
				clip_shoot.start();
				off = 1;
			}
		}
	}

	@Override
	public void update() {
		if (launched) {
			y -= 10;
		}
		if (y < -200) {
			launched = false;
		}
	}
}