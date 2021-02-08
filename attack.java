package final_term_shooting_game;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class attack extends GraphicObject {
	boolean launched = false;
	private Clip clip_shoot;
	static private int off = 1;

	public attack(String name) {
		super(name);
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
		if (event.getKeyCode() == KeyEvent.VK_Z) {
			launched = true;
			this.x = x + 50;
			this.y = y;
			loadAudio_shoot("shoot_music.wav");
			if (off == 1) {
				clip_shoot.start();
			}
		}
		if (event.getKeyCode() == KeyEvent.VK_O) {
			launched = true;
			loadAudio_shoot("shoot_music.wav");
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
		if (launched)
			y -= 15;
		if (y < -150)
			launched = false;
	}
}