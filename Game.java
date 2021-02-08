package final_term_shooting_game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Game extends JPanel implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	map map;
	map map_boss2;
	map map_boss;

	monster monster;
	monster monster2;
	monster monster3;
	monster monster4;
	monster monster5;

	monster2 monster_Y;
	monster2 monster_Y2;
	monster2 monster_Y3;
	monster2 monster_Y4;
	monster2 monster_Y5;

	monster3 monster_P;
	monster3 monster_P2;
	monster3 monster_P3;
	monster3 monster_P4;
	monster3 monster_P5;

	monster4 monster_G;
	monster4 monster_G2;
	monster4 monster_G3;
	monster4 monster_G4;
	monster4 monster_G5;

	monster5 monster_B;
	monster5 monster_B2;
	monster5 monster_B3;
	monster5 monster_B4;
	monster5 monster_B5;

	boss boss1;
	boss boss2;
	boss boss3;

	monster_attack monster_attack;
	monster_attack monster_attack2;
	monster_attack monster_attack3;

	
	boss_attack boss_attack;

	boss_attack boss_attack1;
	boss_attack2 boss_attack2;
	boss_attack3 boss_attack3;
	
	boss_attack boss_attack4;
	boss_attack2 boss_attack5;
	boss_attack3 boss_attack6;

	warning warning;
	warning warning2;
	warning warning3;

	character character;
	attack attack1;
	attack attack2;
	attack attack3;
	attack attack4;
	attack attack5;
	attack attack6;
	attack attack7;
	attack attack8;
	attack attack9;
	attack attack10;
	attack attack11;
	attack attack12;
	attack attack13;
	attack attack14;
	attack attack15;

	attack attack_2;
	attack attack_3;
	attack attack_4;

	bomb bomb;
	bomb bomb2;
	bomb bomb3;
	bomb bomb4;
	bomb bomb5;

	bomb_num bomb_num1;
	bomb_num bomb_num2;
	bomb_num bomb_num3;

	HP_num HP1;
	HP_num HP2;
	HP_num HP3;

	powerup powerup;
	power2 powerup2;
	power2 powerup3;

	Game_menu Game_menu;
	static private int a = 1;
	static private int boss_stage = 0;
	static private int count = 0;
	static private int power = 25;
	static private int power2 = 45;
	static private int power4 = 85;
	public static int point = 0;
	static private int bomb_count = 5;
	static private int character_HP = 3000000;
	
	static private int monster_HP = 50;
	static private int monster_HP2 = 50;
	static private int monster_HP3 = 50;
	static private int monster_HP4 = 50;
	static private int monster_HP5 = 50;

	static private int monsterY_HP = 100;
	static private int monsterY_HP2 = 100;
	static private int monsterY_HP3 = 100;
	static private int monsterY_HP4 = 100;
	static private int monsterY_HP5 = 100;

	static private int monsterP_HP = 150;
	static private int monsterP_HP2 = 150;
	static private int monsterP_HP3 = 150;
	static private int monsterP_HP4 = 150;
	static private int monsterP_HP5 = 150;

	static private int monsterG_HP = 200;
	static private int monsterG_HP2 = 200;
	static private int monsterG_HP3 = 200;
	static private int monsterG_HP4 = 200;
	static private int monsterG_HP5 = 200;

	static private int monsterB_HP = 250;
	static private int monsterB_HP2 = 250;
	static private int monsterB_HP3 = 250;
	static private int monsterB_HP4 = 250;
	static private int monsterB_HP5 = 250;

	static private int boss_HP = 500;
	static private int boss_HP2 = 500;
	static private int boss_HP3 = 500;

	static Clip clip;
	static Clip clip_monster;
	static Clip clip_monster_die;
	static int off = 1;
	static int e_off = 1;
	static Clip clip_boss_die;

	private void loadAudio_monster(String pathName) {
		try {
			clip_monster = AudioSystem.getClip();
			File audioFile = new File(pathName);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip_monster.open(audioStream);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadAudio_monster_die(String pathName) {
		try {
			clip_monster_die = AudioSystem.getClip();
			File audioFile = new File(pathName);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip_monster_die.open(audioStream);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadAudio_boss_die(String pathName) {
		try {
			clip_boss_die = AudioSystem.getClip();
			File audioFile = new File(pathName);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip_boss_die.open(audioStream);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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
	
	public Game() {
		super();
		this.addKeyListener(this);
		this.requestFocus();
		setFocusable(true);
		setLayout(null);
		
		loadAudio("Game_Music.wav");
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);

		map = new map("map.jpg");
		map_boss = new map("map_boss.png");
		map_boss2 = new map("map_boss2.png");

		monster = new monster("white_dragon.png");
		monster2 = new monster("white_dragon.png");
		monster3 = new monster("white_dragon.png");
		monster4 = new monster("white_dragon.png");
		monster5 = new monster("white_dragon.png");

		monster_Y = new monster2("yellow_dragon.png");
		monster_Y2 = new monster2("yellow_dragon.png");
		monster_Y3 = new monster2("yellow_dragon.png");
		monster_Y4 = new monster2("yellow_dragon.png");
		monster_Y5 = new monster2("yellow_dragon.png");

		monster_P = new monster3("pink_dragon.png");
		monster_P2 = new monster3("pink_dragon.png");
		monster_P3 = new monster3("pink_dragon.png");
		monster_P4 = new monster3("pink_dragon.png");
		monster_P5 = new monster3("pink_dragon.png");

		monster_G = new monster4("green_dragon.png");
		monster_G2 = new monster4("green_dragon.png");
		monster_G3 = new monster4("green_dragon.png");
		monster_G4 = new monster4("green_dragon.png");
		monster_G5 = new monster4("green_dragon.png");

		monster_B = new monster5("blue_dragon.png");
		monster_B2 = new monster5("blue_dragon.png");
		monster_B3 = new monster5("blue_dragon.png");
		monster_B4 = new monster5("blue_dragon.png");
		monster_B5 = new monster5("blue_dragon.png");

		boss1 = new boss("boss_1.png");
		boss2 = new boss("boss_2.png");
		boss3 = new boss("boss_3.png");

		monster_attack = new monster_attack("attack_monster.png");
		monster_attack2 = new monster_attack("attack_monster.png");
		monster_attack3 = new monster_attack("attack_monster.png");

		boss_attack = new boss_attack("attack_boss.png");

		boss_attack1 = new boss_attack("attack_boss2.png");
		boss_attack2 = new boss_attack2("attack_boss2.png");
		boss_attack3 = new boss_attack3("attack_boss2.png");
		
		boss_attack4 = new boss_attack("attack_boss3.png");
		boss_attack5 = new boss_attack2("attack_boss3.png");
		boss_attack6 = new boss_attack3("attack_boss3.png");

		warning = new warning("warning.png");
		warning2 = new warning("warning.png");
		warning3 = new warning("warning.png");

		character = new character("knight.png");

		attack1 = new attack("attack_1.png");
		attack2 = new attack("attack_1.png");
		attack3 = new attack("attack_1.png");
		attack4 = new attack("attack_1.png");
		attack5 = new attack("attack_1.png");
		attack6 = new attack("attack_1.png");
		attack7 = new attack("attack_1.png");
		attack8 = new attack("attack_1.png");
		attack9 = new attack("attack_1.png");
		attack10 = new attack("attack_1.png");
		attack11 = new attack("attack_1.png");
		attack12 = new attack("attack_1.png");
		attack13 = new attack("attack_1.png");
		attack14 = new attack("attack_1.png");
		attack15 = new attack("attack_1.png");

		attack_2 = new attack("attack_2.png");
		attack_3 = new attack("attack_3.png");
		attack_4 = new attack("attack_4.png");

		bomb = new bomb("bomb.png");
		bomb2 = new bomb("bomb.png");
		bomb3 = new bomb("bomb.png");
		bomb4 = new bomb("bomb.png");
		bomb5 = new bomb("bomb.png");

		bomb_num1 = new bomb_num("bomb_img.png");
		bomb_num2 = new bomb_num("bomb_img.png");
		bomb_num3 = new bomb_num("bomb_img.png");

		HP1 = new HP_num("HP.png");
		HP2 = new HP_num("HP.png");
		HP3 = new HP_num("HP.png");

		powerup = new powerup("gift.png");
		powerup2 = new power2("gift.png");
		powerup3 = new power2("gift.png");


		////////////////////////////////////////////////////////////////////////
		
		monster2.x = 150;
		monster3.x = 300;
		monster4.x = 450;
		monster5.x = 600;

		monster_Y2.x = 150;
		monster_Y3.x = 300;
		monster_Y4.x = 450;
		monster_Y5.x = 600;

		monster_P2.x = 150;
		monster_P3.x = 300;
		monster_P4.x = 450;
		monster_P5.x = 600;

		monster_G2.x = 150;
		monster_G3.x = 300;
		monster_G4.x = 450;
		monster_G5.x = 600;

		monster_B2.x = 150;
		monster_B3.x = 300;
		monster_B4.x = 450;
		monster_B5.x = 600;

		bomb2.x = 150;
		bomb3.x = 300;
		bomb4.x = 450;
		bomb5.x = 580;

		bomb_num2.x = 600;
		bomb_num3.x = 530;

		HP2.x = 50;
		HP3.x = 100;
		
		monster_attack2.x = 0;
		monster_attack3.x = 600;


		class MyThread extends Thread {

			public void move() {
				if (character.x > 600) {
					character.x -= 55;
				}
				if (character.x < -30) {
					character.x += 55;
				}
				if (character.y > 800) {
					character.y -= 55;
				}
				if (character.y < 0) {
					character.y += 55;
				}
			}

			public void monster_respawn(monster monster, monster monster2, monster monster3, monster monster4,
					monster monster5) {
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster2.y > -10000 && monster.y > -10000 && monster.y < -500 && monster2.y < -500
						&& monster3.y > -10000 && monster4.y > -10000 && monster3.y < -500 && monster4.y < -500
						&& monster5.y > -10000 && monster5.y < -500) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
			}

			public void monster_respawn2(monster2 monster, monster2 monster2, monster2 monster3, monster2 monster4,
					monster2 monster5) {
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster2.y > -10000 && monster.y > -10000 && monster.y < -500 && monster2.y < -500
						&& monster3.y > -10000 && monster4.y > -10000 && monster3.y < -500 && monster4.y < -500
						&& monster5.y > -10000 && monster5.y < -500) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
			}

			public void monster_respawn3(monster3 monster, monster3 monster2, monster3 monster3, monster3 monster4,
					monster3 monster5) {
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster2.y > -10000 && monster.y > -10000 && monster.y < -500 && monster2.y < -500
						&& monster3.y > -10000 && monster4.y > -10000 && monster3.y < -500 && monster4.y < -500
						&& monster5.y > -10000 && monster5.y < -500) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
			}

			public void monster_respawn4(monster4 monster, monster4 monster2, monster4 monster3, monster4 monster4,
					monster4 monster5) {
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster2.y > -10000 && monster.y > -10000 && monster.y < -500 && monster2.y < -500
						&& monster3.y > -10000 && monster4.y > -10000 && monster3.y < -500 && monster4.y < -500
						&& monster5.y > -10000 && monster5.y < -500) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
			}

			public void monster_respawn5(monster5 monster, monster5 monster2, monster5 monster3, monster5 monster4,
					monster5 monster5) {
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y == 1000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y == 1000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y == 1000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y > -10000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y == 1000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster.y == 1000 && monster2.y > -10000 && monster3.y > -10000 && monster4.y > -10000
						&& monster5.y > -10000) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
				if (monster2.y > -10000 && monster.y > -10000 && monster.y < -500 && monster2.y < -500
						&& monster3.y > -10000 && monster4.y > -10000 && monster3.y < -500 && monster4.y < -500
						&& monster5.y > -10000 && monster5.y < -500) {
					monster.y = -500;
					monster2.y = -500;
					monster3.y = -500;
					monster4.y = -500;
					monster5.y = -500;
				}
			}

			public void demage() {
				Rectangle rect = new Rectangle(monster.x, monster.y, monster.img.getWidth(), monster.img.getHeight());
				Rectangle rect2 = new Rectangle(monster2.x, monster2.y, monster2.img.getWidth(),
						monster2.img.getHeight());
				Rectangle rect3 = new Rectangle(monster3.x, monster3.y, monster3.img.getWidth(),
						monster3.img.getHeight());
				Rectangle rect4 = new Rectangle(monster4.x, monster4.y, monster4.img.getWidth(),
						monster4.img.getHeight());
				Rectangle rect5 = new Rectangle(monster5.x, monster5.y, monster5.img.getWidth(),
						monster5.img.getHeight());

				Rectangle rect_Y = new Rectangle(monster_Y.x, monster_Y.y, monster_Y.img.getWidth(),
						monster_Y.img.getHeight());
				Rectangle rect_Y2 = new Rectangle(monster_Y2.x, monster_Y2.y, monster_Y2.img.getWidth(),
						monster_Y2.img.getHeight());
				Rectangle rect_Y3 = new Rectangle(monster_Y3.x, monster_Y3.y, monster_Y3.img.getWidth(),
						monster_Y3.img.getHeight());
				Rectangle rect_Y4 = new Rectangle(monster_Y4.x, monster_Y4.y, monster_Y4.img.getWidth(),
						monster_Y4.img.getHeight());
				Rectangle rect_Y5 = new Rectangle(monster_Y5.x, monster_Y5.y, monster_Y5.img.getWidth(),
						monster_Y5.img.getHeight());

				Rectangle rect_P = new Rectangle(monster_P.x, monster_P.y, monster_P.img.getWidth(),
						monster_P.img.getHeight());
				Rectangle rect_P2 = new Rectangle(monster_P2.x, monster_P2.y, monster_P2.img.getWidth(),
						monster_P2.img.getHeight());
				Rectangle rect_P3 = new Rectangle(monster_P3.x, monster_P3.y, monster_P3.img.getWidth(),
						monster_P3.img.getHeight());
				Rectangle rect_P4 = new Rectangle(monster_P4.x, monster_P4.y, monster_P4.img.getWidth(),
						monster_P4.img.getHeight());
				Rectangle rect_P5 = new Rectangle(monster_P5.x, monster_P5.y, monster_P5.img.getWidth(),
						monster_P5.img.getHeight());

				Rectangle rect_B = new Rectangle(monster_B.x, monster_B.y, monster_B.img.getWidth(),
						monster_B.img.getHeight());
				Rectangle rect_B2 = new Rectangle(monster_B2.x, monster_B2.y, monster_B2.img.getWidth(),
						monster_B2.img.getHeight());
				Rectangle rect_B3 = new Rectangle(monster_B3.x, monster_B3.y, monster_B3.img.getWidth(),
						monster_B3.img.getHeight());
				Rectangle rect_B4 = new Rectangle(monster_B4.x, monster_B4.y, monster_B4.img.getWidth(),
						monster_B4.img.getHeight());
				Rectangle rect_B5 = new Rectangle(monster_B5.x, monster_B5.y, monster_B5.img.getWidth(),
						monster_B5.img.getHeight());

				Rectangle rect_G = new Rectangle(monster_G.x, monster_G.y, monster_G.img.getWidth(),
						monster_G.img.getHeight());
				Rectangle rect_G2 = new Rectangle(monster_G2.x, monster_G2.y, monster_G2.img.getWidth(),
						monster_G2.img.getHeight());
				Rectangle rect_G3 = new Rectangle(monster_G3.x, monster_G3.y, monster_G3.img.getWidth(),
						monster_G3.img.getHeight());
				Rectangle rect_G4 = new Rectangle(monster_G4.x, monster_G4.y, monster_G4.img.getWidth(),
						monster_G4.img.getHeight());
				Rectangle rect_G5 = new Rectangle(monster_G5.x, monster_G5.y, monster_G5.img.getWidth(),
						monster_G5.img.getHeight());

				Rectangle rect_G_attack = new Rectangle(monster_attack.x-20, monster_attack.y, monster_attack.img.getWidth(),
						monster_attack.img.getHeight());
				Rectangle rect_G2_attack = new Rectangle(monster_attack2.x-20, monster_attack2.y, monster_attack2.img.getWidth(),
						monster_attack2.img.getHeight());
				Rectangle rect_G3_attack = new Rectangle(monster_attack3.x-20, monster_attack3.y, monster_attack3.img.getWidth(),
						monster_attack3.img.getHeight());
				
				Rectangle rect_boss1 = new Rectangle(boss1.x, boss1.y, boss1.img.getWidth(), boss1.img.getHeight());
				Rectangle rect_boss1_attack = new Rectangle(boss_attack.x, boss_attack.y, boss_attack.img.getWidth(),
						boss_attack.img.getHeight());
				Rectangle rect_boss21_attack = new Rectangle(boss_attack1.x, boss_attack1.y, boss_attack1.img.getWidth(),
						boss_attack1.img.getHeight());
				Rectangle rect_boss22_attack = new Rectangle(boss_attack2.x, boss_attack2.y, boss_attack2.img.getWidth(),
						boss_attack2.img.getHeight());
				Rectangle rect_boss23_attack = new Rectangle(boss_attack3.x, boss_attack3.y, boss_attack3.img.getWidth(),
						boss_attack3.img.getHeight());
				Rectangle rect_boss31_attack = new Rectangle(boss_attack4.x, boss_attack4.y, boss_attack4.img.getWidth(),
						boss_attack4.img.getHeight());
				Rectangle rect_boss32_attack = new Rectangle(boss_attack5.x, boss_attack5.y, boss_attack5.img.getWidth(),
						boss_attack5.img.getHeight());
				Rectangle rect_boss33_attack = new Rectangle(boss_attack6.x, boss_attack6.y, boss_attack6.img.getWidth(),
						boss_attack6.img.getHeight());

				if (rect.contains(character.x, character.y)) {
					monster.y = -10000;
					character_HP--;
				}
				if (rect2.contains(character.x, character.y)) {
					monster2.y = -10000;
					character_HP--;
				}
				if (rect3.contains(character.x, character.y)) {
					monster3.y = -10000;
					character_HP--;
				}
				if (rect4.contains(character.x, character.y)) {
					monster4.y = -10000;
					character_HP--;
				}

				if (rect5.contains(character.x, character.y)) {
					monster5.y = -10000;
					character_HP--;
				}
				if (rect_Y.contains(character.x, character.y)) {
					monster_Y.y = -10000;
					character_HP--;
				}
				if (rect_Y2.contains(character.x, character.y)) {
					monster_Y2.y = -10000;
					character_HP--;
				}
				if (rect_Y3.contains(character.x, character.y)) {
					monster_Y3.y = -10000;
					character_HP--;
				}
				if (rect_Y4.contains(character.x, character.y)) {
					monster_Y4.y = -10000;
					character_HP--;
				}

				if (rect_Y5.contains(character.x, character.y)) {
					monster_Y5.y = -10000;
					character_HP--;
				}
				if (rect_P.contains(character.x, character.y)) {
					monster_P.y = -10000;
					character_HP--;
				}
				if (rect_P2.contains(character.x, character.y)) {
					monster_P2.y = -10000;
					character_HP--;
				}
				if (rect_P3.contains(character.x, character.y)) {
					monster_Y3.y = -10000;
					character_HP--;
				}
				if (rect_P4.contains(character.x, character.y)) {
					monster_P4.y = -10000;
					character_HP--;
				}
				if (rect_P5.contains(character.x, character.y)) {
					monster_P5.y = -10000;
					character_HP--;
				}
				if (rect_B.contains(character.x, character.y)) {
					monster_B.y = -10000;
					character_HP--;
				}
				if (rect_B2.contains(character.x, character.y)) {
					monster_B2.y = -10000;
					character_HP--;
				}
				if (rect_B3.contains(character.x, character.y)) {
					monster_B3.y = -10000;
					character_HP--;
				}
				if (rect_B4.contains(character.x, character.y)) {
					monster_B4.y = -10000;
					character_HP--;
				}
				if (rect_B5.contains(character.x, character.y)) {
					monster_B5.y = -10000;
					character_HP--;
				}
				if (rect_G.contains(character.x, character.y)) {
					monster_G.y = -10000;
					character_HP--;
				}
				if (rect_G2.contains(character.x, character.y)) {
					monster_G2.y = -10000;
					character_HP--;
				}
				if (rect_G3.contains(character.x, character.y)) {
					monster_G3.y = -10000;
					character_HP--;
				}
				if (rect_G4.contains(character.x, character.y)) {
					monster_G4.y = -10000;
					character_HP--;
				}
				if (rect_G5.contains(character.x, character.y)) {
					monster_G5.y = -10000;
					character_HP--;
				}
				if (rect_G_attack.contains(character.x, character.y)) {
					monster_attack.y = 10000;
					character_HP--;
				}
				if (rect_G2_attack.contains(character.x, character.y)) {
					monster_attack2.y = 10000;
					character_HP--;
				}
				if (rect_G3_attack.contains(character.x, character.y)) {
					monster_attack3.y = 10000;
					character_HP--;
				}
				if (rect_boss1.contains(character.x, character.y)) {
					character_HP--;
				}
				if (rect_boss1_attack.contains(character.x, character.y)) {
					boss_attack.y = 10000;
					character_HP--;
				}
				if (rect_boss21_attack.contains(character.x, character.y)) {
					boss_attack1.y = 10000;
					character_HP--;
				}
				if (rect_boss22_attack.contains(character.x, character.y)) {
					boss_attack2.y = 10000;
					character_HP--;
				}
				if (rect_boss23_attack.contains(character.x, character.y)) {
					boss_attack3.y = 10000;
					character_HP--;
				}
				if (rect_boss31_attack.contains(character.x, character.y)) {
					boss_attack4.y = 10000;
					character_HP--;
				}
				if (rect_boss32_attack.contains(character.x, character.y)) {
					boss_attack5.y = 10000;
					character_HP--;
				}
				if (rect_boss33_attack.contains(character.x, character.y)) {
					boss_attack6.y = 10000;
					character_HP--;
				}
			}

			public void shoot(attack attack) {
				Rectangle rect = new Rectangle(monster.x, monster.y, monster.img.getWidth(), monster.img.getHeight());
				Rectangle rect2 = new Rectangle(monster2.x, monster2.y, monster2.img.getWidth(),
						monster2.img.getHeight());
				Rectangle rect3 = new Rectangle(monster3.x, monster3.y, monster3.img.getWidth(),
						monster3.img.getHeight());
				Rectangle rect4 = new Rectangle(monster4.x, monster4.y, monster4.img.getWidth(),
						monster4.img.getHeight());
				Rectangle rect5 = new Rectangle(monster5.x, monster5.y, monster5.img.getWidth(),
						monster5.img.getHeight());

				Rectangle rect_Y = new Rectangle(monster_Y.x, monster_Y.y, monster_Y.img.getWidth(),
						monster_Y.img.getHeight());
				Rectangle rect_Y2 = new Rectangle(monster_Y2.x, monster_Y2.y, monster_Y2.img.getWidth(),
						monster_Y2.img.getHeight());
				Rectangle rect_Y3 = new Rectangle(monster_Y3.x, monster_Y3.y, monster_Y3.img.getWidth(),
						monster_Y3.img.getHeight());
				Rectangle rect_Y4 = new Rectangle(monster_Y4.x, monster_Y4.y, monster_Y4.img.getWidth(),
						monster_Y4.img.getHeight());
				Rectangle rect_Y5 = new Rectangle(monster_Y5.x, monster_Y5.y, monster_Y5.img.getWidth(),
						monster_Y5.img.getHeight());

				Rectangle rect_P = new Rectangle(monster_P.x, monster_P.y, monster_P.img.getWidth(),
						monster_P.img.getHeight());
				Rectangle rect_P2 = new Rectangle(monster_P2.x, monster_P2.y, monster_P2.img.getWidth(),
						monster_P2.img.getHeight());
				Rectangle rect_P3 = new Rectangle(monster_P3.x, monster_P3.y, monster_P3.img.getWidth(),
						monster_P3.img.getHeight());
				Rectangle rect_P4 = new Rectangle(monster_P4.x, monster_P4.y, monster_P4.img.getWidth(),
						monster_P4.img.getHeight());
				Rectangle rect_P5 = new Rectangle(monster_P5.x, monster_P5.y, monster_P5.img.getWidth(),
						monster_P5.img.getHeight());

				Rectangle rect_B = new Rectangle(monster_B.x, monster_B.y, monster_B.img.getWidth(),
						monster_B.img.getHeight());
				Rectangle rect_B2 = new Rectangle(monster_B2.x, monster_B2.y, monster_B2.img.getWidth(),
						monster_B2.img.getHeight());
				Rectangle rect_B3 = new Rectangle(monster_B3.x, monster_B3.y, monster_B3.img.getWidth(),
						monster_B3.img.getHeight());
				Rectangle rect_B4 = new Rectangle(monster_B4.x, monster_B4.y, monster_B4.img.getWidth(),
						monster_B4.img.getHeight());
				Rectangle rect_B5 = new Rectangle(monster_B5.x, monster_B5.y, monster_B5.img.getWidth(),
						monster_B5.img.getHeight());

				Rectangle rect_G = new Rectangle(monster_G.x, monster_G.y, monster_G.img.getWidth(),
						monster_G.img.getHeight());
				Rectangle rect_G2 = new Rectangle(monster_G2.x, monster_G2.y, monster_G2.img.getWidth(),
						monster_G2.img.getHeight());
				Rectangle rect_G3 = new Rectangle(monster_G3.x, monster_G3.y, monster_G3.img.getWidth(),
						monster_G3.img.getHeight());
				Rectangle rect_G4 = new Rectangle(monster_G4.x, monster_G4.y, monster_G4.img.getWidth(),
						monster_G4.img.getHeight());
				Rectangle rect_G5 = new Rectangle(monster_G5.x, monster_G5.y, monster_G5.img.getWidth(),
						monster_G5.img.getHeight());

				Rectangle rect_boss1 = new Rectangle(boss1.x, boss1.y, boss1.img.getWidth(), boss1.img.getHeight());
				Rectangle rect_boss2 = new Rectangle(boss2.x, boss2.y, boss2.img.getWidth(), boss2.img.getHeight());
				Rectangle rect_boss3 = new Rectangle(boss3.x, boss3.y, boss3.img.getWidth(), boss3.img.getHeight());

				Rectangle rect_powerup = new Rectangle(powerup.x, powerup.y, powerup.img.getWidth(),
						powerup.img.getHeight());
				Rectangle rect_powerup2 = new Rectangle(powerup2.x, powerup2.y, powerup2.img.getWidth(),
						powerup2.img.getHeight());


				if (attack.launched) {

					if (rect_powerup.contains(attack.x, attack.y)) {
						attack.y = -200;
							powerup.y = -1000;
							attack1.img = attack_2.img;
							attack2.img = attack_2.img;
							attack3.img = attack_2.img;
							attack4.img = attack_2.img;
							attack5.img = attack_2.img;
							attack6.img = attack_2.img;
							attack7.img = attack_2.img;
							attack8.img = attack_2.img;
							attack9.img = attack_2.img;
							attack10.img = attack_2.img;
							attack11.img = attack_2.img;
							attack12.img = attack_2.img;
							attack13.img = attack_2.img;
							attack14.img = attack_2.img;
							attack15.img = attack_2.img;
							power = power2;
					}
					if (rect_powerup2.contains(attack.x, attack.y)) {
						attack.y = -200;
							powerup2.y = -1000;
							attack1.img = attack_4.img;
							attack2.img = attack_4.img;
							attack3.img = attack_4.img;
							attack4.img = attack_4.img;
							attack5.img = attack_4.img;
							attack6.img = attack_4.img;
							attack7.img = attack_4.img;
							attack8.img = attack_4.img;
							attack9.img = attack_4.img;
							attack10.img = attack_4.img;
							attack11.img = attack_4.img;
							attack12.img = attack_4.img;
							attack13.img = attack_4.img;
							attack14.img = attack_4.img;
							attack15.img = attack_4.img;
							power = power4;
					}
					if (rect.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monster_HP = monster_HP - power;
						attack.y = -200;
						if (monster_HP <= 0) {
							monster.y = -10000;
							point = point + 10;
							monster_HP = 50;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect2.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monster_HP2 = monster_HP2 - power;
						attack.y = -200;
						if (monster_HP2 <= 0) {
							monster2.y = -10000;
							point = point + 10;
							monster_HP2 = 50;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect3.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monster_HP3 = monster_HP3 - power;
						attack.y = -200;
						if (monster_HP3 <= 0) {
							monster3.y = -10000;
							point = point + 10;
							monster_HP3 = 50;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect4.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monster_HP4 = monster_HP4 - power;
						attack.y = -200;
						if (monster_HP4 <= 0) {
							monster4.y = -10000;
							point = point + 10;
							monster_HP4 = 50;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect5.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monster_HP5 = monster_HP5 - power;
						attack.y = -200;
						if (monster_HP5 <= 0) {
							monster5.y = -10000;
							point = point + 10;
							monster_HP5 = 50;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_Y.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterY_HP = monsterY_HP - power;
						attack.y = -200;
						if (monsterY_HP <= 0) {
							monster_Y.y = -10000;
							point = point + 20;
							monsterY_HP = 100;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_Y2.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterY_HP2 = monsterY_HP2 - power;
						attack.y = -200;
						if (monsterY_HP2 <= 0) {
							monster_Y2.y = -10000;
							point = point + 20;
							monsterY_HP2 = 100;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_Y3.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterY_HP3 = monsterY_HP3 - power;
						attack.y = -200;
						if (monsterY_HP3 <= 0) {
							monster_Y3.y = -10000;
							point = point + 20;
							monsterY_HP3 = 100;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_Y4.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterY_HP4 = monsterY_HP4 - power;
						attack.y = -200;
						if (monsterY_HP4 <= 0) {
							monster_Y4.y = -10000;
							point = point + 20;
							monsterY_HP4 = 100;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_Y5.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterY_HP5 = monsterY_HP5 - power;
						attack.y = -200;
						if (monsterY_HP5 <= 0) {
							monster_Y5.y = -10000;
							point = point + 20;
							monsterY_HP5 = 100;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_P.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterP_HP = monsterP_HP - power;
						attack.y = -200;
						if (monsterP_HP <= 0) {
							monster_P.y = -10000;
							point += 30;
							monsterP_HP = 150;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_P2.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterP_HP2 = monsterP_HP2 - power;
						attack.y = -200;
						if (monsterP_HP2 <= 0) {
							monster_P2.y = -10000;
							point += 30;
							monsterP_HP2 = 150;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_P3.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterP_HP3 = monsterP_HP3 - power;
						attack.y = -200;
						if (monsterP_HP3 <= 0) {
							monster_P3.y = -10000;
							point += 30;
							monsterP_HP3 = 150;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_P4.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterP_HP4 = monsterP_HP4 - power;
						attack.y = -200;
						if (monsterP_HP4 <= 0) {
							monster_P4.y = -10000;
							point += 30;
							monsterP_HP4 = 150;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_P5.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterP_HP5 = monsterP_HP5 - power;
						attack.y = -200;
						if (monsterP_HP5 <= 0) {
							monster_P5.y = -10000;
							point += 30;
							monsterP_HP5 = 150;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_B.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterB_HP = monsterB_HP - power;
						attack.y = -200;
						if (monsterB_HP <= 0) {
							monster_B.y = -10000;
							point += 50;
							monsterB_HP = 250;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_B2.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterB_HP2 = monsterB_HP2 - power;
						attack.y = -200;
						if (monsterB_HP2 <= 0) {
							monster_B2.y = -10000;
							point += 50;
							monsterB_HP2 = 250;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_B3.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterB_HP3 = monsterB_HP3 - power;
						attack.y = -200;
						if (monsterB_HP3 <= 0) {
							monster_B3.y = -10000;
							point += 50;
							monsterB_HP3 = 250;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_B4.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterB_HP4 = monsterB_HP4 - power;
						attack.y = -200;
						if (monsterB_HP4 <= 0) {
							monster_B4.y = -10000;
							point += 50;
							monsterB_HP4 = 250;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_B5.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterB_HP5 = monsterB_HP5 - power;
						attack.y = -200;
						if (monsterB_HP5 <= 0) {
							monster_B5.y = -10000;
							point += 50;
							monsterB_HP5 = 250;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_G.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterG_HP = monsterG_HP - power;
						attack.y = -200;
						if (monsterG_HP <= 0) {
							monster_G.y = -10000;
							point += 40;
							monsterG_HP = 200;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_G2.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterG_HP2 = monsterG_HP2 - power;
						attack.y = -200;
						if (monsterG_HP2 <= 0) {
							monster_G2.y = -10000;
							point += 40;
							monsterG_HP2 = 200;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_G3.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterG_HP3 = monsterG_HP3 - power;
						attack.y = -200;
						if (monsterG_HP3 <= 0) {
							monster_G3.y = -10000;
							point += 40;
							monsterG_HP3 = 200;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_G4.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterG_HP4 = monsterG_HP4 - power;
						attack.y = -200;
						if (monsterG_HP4 <= 0) {
							monster_G4.y = -10000;
							point += 40;
							monsterG_HP4 = 200;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_G5.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						monsterG_HP5 = monsterG_HP5 - power;
						attack.y = -200;
						if (monsterG_HP5 <= 0) {
							monster_G5.y = -10000;
							point += 40;
							monsterG_HP5 = 200;
							count++;
							loadAudio_monster_die("die.wav");
							clip_monster_die.start();
						}
					}
					if (rect_boss1.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						boss_HP = boss_HP - power;
						attack.y = -200;
						if (boss_HP <= 0) {
							boss1.y = 10000;
							point += 1000;
							loadAudio_boss_die("boss_die.wav");
							clip_boss_die.start();
						}
					}
					if (rect_boss2.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						boss_HP2 = boss_HP2 - power;
						attack.y = -200;
						if (boss_HP2 <= 0) {
							boss2.y = 10000;
							point += 2000;
							loadAudio_boss_die("boss_die.wav");
							clip_boss_die.start();
						}
					}
					if (rect_boss3.contains(attack.x, attack.y)) {
						loadAudio_monster("monster_sound.wav");
						clip_monster.start();
						boss_HP3 = boss_HP3 - power;
						attack.y = -200;
						if (boss_HP3 <= 0) {
							boss3.y = 10000;
							point += 3000;
							loadAudio_boss_die("boss_die.wav");
							clip_boss_die.start();
						}
					}
				}

			}

			public void bomb_shoot(bomb bomb) {
				Rectangle rect = new Rectangle(monster.x, monster.y, monster.img.getWidth(), monster.img.getHeight());
				Rectangle rect2 = new Rectangle(monster2.x, monster2.y, monster2.img.getWidth(),
						monster2.img.getHeight());
				Rectangle rect3 = new Rectangle(monster3.x, monster3.y, monster3.img.getWidth(),
						monster3.img.getHeight());
				Rectangle rect4 = new Rectangle(monster4.x, monster4.y, monster4.img.getWidth(),
						monster4.img.getHeight());
				Rectangle rect5 = new Rectangle(monster5.x, monster5.y, monster5.img.getWidth(),
						monster5.img.getHeight());

				Rectangle rect_Y = new Rectangle(monster_Y.x, monster_Y.y, monster_Y.img.getWidth(),
						monster_Y.img.getHeight());
				Rectangle rect_Y2 = new Rectangle(monster_Y2.x, monster_Y2.y, monster_Y2.img.getWidth(),
						monster_Y2.img.getHeight());
				Rectangle rect_Y3 = new Rectangle(monster_Y3.x, monster_Y3.y, monster_Y3.img.getWidth(),
						monster_Y3.img.getHeight());
				Rectangle rect_Y4 = new Rectangle(monster_Y4.x, monster_Y4.y, monster_Y4.img.getWidth(),
						monster_Y4.img.getHeight());
				Rectangle rect_Y5 = new Rectangle(monster_Y5.x, monster_Y5.y, monster_Y5.img.getWidth(),
						monster_Y5.img.getHeight());

				Rectangle rect_P = new Rectangle(monster_P.x, monster_P.y, monster_P.img.getWidth(),
						monster_P.img.getHeight());
				Rectangle rect_P2 = new Rectangle(monster_P2.x, monster_P2.y, monster_P2.img.getWidth(),
						monster_P2.img.getHeight());
				Rectangle rect_P3 = new Rectangle(monster_P3.x, monster_P3.y, monster_P3.img.getWidth(),
						monster_P3.img.getHeight());
				Rectangle rect_P4 = new Rectangle(monster_P4.x, monster_P4.y, monster_P4.img.getWidth(),
						monster_P4.img.getHeight());
				Rectangle rect_P5 = new Rectangle(monster_P5.x, monster_P5.y, monster_P5.img.getWidth(),
						monster_P5.img.getHeight());

				Rectangle rect_B = new Rectangle(monster_B.x, monster_B.y, monster_B.img.getWidth(),
						monster_B.img.getHeight());
				Rectangle rect_B2 = new Rectangle(monster_B2.x, monster_B2.y, monster_B2.img.getWidth(),
						monster_B2.img.getHeight());
				Rectangle rect_B3 = new Rectangle(monster_B3.x, monster_B3.y, monster_B3.img.getWidth(),
						monster_B3.img.getHeight());
				Rectangle rect_B4 = new Rectangle(monster_B4.x, monster_B4.y, monster_B4.img.getWidth(),
						monster_B4.img.getHeight());
				Rectangle rect_B5 = new Rectangle(monster_B5.x, monster_B5.y, monster_B5.img.getWidth(),
						monster_B5.img.getHeight());

				Rectangle rect_G = new Rectangle(monster_G.x, monster_G.y, monster_G.img.getWidth(),
						monster_G.img.getHeight());
				Rectangle rect_G2 = new Rectangle(monster_G2.x, monster_G2.y, monster_G2.img.getWidth(),
						monster_G2.img.getHeight());
				Rectangle rect_G3 = new Rectangle(monster_G3.x, monster_G3.y, monster_G3.img.getWidth(),
						monster_G3.img.getHeight());
				Rectangle rect_G4 = new Rectangle(monster_G4.x, monster_G4.y, monster_G4.img.getWidth(),
						monster_G4.img.getHeight());
				Rectangle rect_G5 = new Rectangle(monster_G5.x, monster_G5.y, monster_G5.img.getWidth(),
						monster_G5.img.getHeight());

				Rectangle rect_boss1 = new Rectangle(boss1.x, boss1.y, boss1.img.getWidth(), boss1.img.getHeight());
				Rectangle rect_boss2 = new Rectangle(boss2.x, boss2.y, boss2.img.getWidth(), boss2.img.getHeight());
				Rectangle rect_boss3 = new Rectangle(boss3.x, boss3.y, boss3.img.getWidth(), boss3.img.getHeight());

				if (bomb.launched) {
					if (bomb2.y == 900) {
						bomb_count = bomb_count - 1;
					}
					if (rect_boss1.contains(bomb.x, bomb.y)) {
						boss_HP = boss_HP - 300;
						if (boss_HP <= 0) {
							point = point + 1000;
						}
					}
					if (rect_boss2.contains(bomb.x, bomb.y)) {
						boss_HP2 = boss_HP2 - 300;
						if (boss_HP2 <= 0) {
							point = point + 2000;
						}
					}
					if (rect_boss3.contains(bomb.x, bomb.y)) {
						boss_HP3 = boss_HP3 - 300;
						if (boss_HP3 <= 0) {
							point = point + 3000;
						}
					}
					if (rect.contains(bomb.x, bomb.y) || rect2.contains(bomb2.x, bomb2.y)
							|| rect3.contains(bomb3.x, bomb3.y) || rect4.contains(bomb4.x, bomb4.y)
							|| rect5.contains(bomb5.x, bomb5.y)) {
						monster.y = -10000;
						monster2.y = -10000;
						monster3.y = -10000;
						monster4.y = -10000;
						monster5.y = -10000;
						point += 50;
						count+=5;
					}
					if (rect_Y.contains(bomb.x, bomb.y) || rect_Y2.contains(bomb2.x, bomb2.y)
							|| rect_Y3.contains(bomb3.x, bomb3.y) || rect_Y4.contains(bomb4.x, bomb4.y)
							|| rect_Y5.contains(bomb5.x, bomb5.y)) {
						monster_Y.y = -10000;
						monster_Y2.y = -10000;
						monster_Y3.y = -10000;
						monster_Y4.y = -10000;
						monster_Y5.y = -10000;
						point += 100;
						count+=5;
					}
					if (rect_P.contains(bomb.x, bomb.y) || rect_P2.contains(bomb2.x, bomb2.y)
							|| rect_P3.contains(bomb3.x, bomb3.y) || rect_P4.contains(bomb4.x, bomb4.y)
							|| rect_P5.contains(bomb5.x, bomb5.y)) {
						monster_P.y = -10000;
						monster_P2.y = -10000;
						monster_P3.y = -10000;
						monster_P4.y = -10000;
						monster_P5.y = -10000;
						point += 150;
						count+=5;
					}
					if (rect_B.contains(bomb.x, bomb.y) || rect_B2.contains(bomb2.x, bomb2.y)
							|| rect_B3.contains(bomb3.x, bomb3.y) || rect_B4.contains(bomb4.x, bomb4.y)
							|| rect_B5.contains(bomb5.x, bomb5.y)) {
						monster_B.y = -10000;
						monster_B2.y = -10000;
						monster_B3.y = -10000;
						monster_B4.y = -10000;
						monster_B5.y = -10000;
						point += 200;
						count+=5;
					}
					if (rect_G.contains(bomb.x, bomb.y) || rect_G2.contains(bomb2.x, bomb2.y)
							|| rect_G3.contains(bomb3.x, bomb3.y) || rect_G4.contains(bomb4.x, bomb4.y)
							|| rect_G5.contains(bomb5.x, bomb5.y)) {
						monster_G.y = -10000;
						monster_G2.y = -10000;
						monster_G3.y = -10000;
						monster_G4.y = -10000;
						monster_G5.y = -10000;
						point += 250;
						count+=5;
					}
				}
			}

			public void Game_end() {
				if (character_HP == 0) {
					int result = JOptionPane.showConfirmDialog(null, "SCORE : " + point + "\n다시 시작하겠습니까?", "점수판",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.CLOSED_OPTION) {
						clip.close();
						character_HP = 3;
						character.y = -15000;
						point = 0;
						count = 0;
						boss_stage = 0;
						setVisible(false);
						new Game_main();
					} else if (result == JOptionPane.YES_OPTION) {
						character.y = -15000;
						clip.close();
						boss_HP = 1000;
						boss_HP2 = 2000;
						boss_HP3 = 3000;
						point = 0;
						count =0;
						boss_stage = 0;
						character_HP = 3;
						repaint();
						setVisible(false);
						new Game_menu();
					} else {
						clip.close();
						character.y = -15000;
						point = 0;
						count =0;
						boss_stage = 0;
						character_HP = 3;
						setVisible(false);
						new Game_main();
					}
				}
			}
			
			@Override
			public void run() {

				while (true) {
					map.update();
					character.update();
					Game_end();
					if (boss_stage == 1) {
						clip.stop();
						warning.update();
						boss_attack.update();
						boss1.update();
						if (boss1.y == 10000) {
							boss_stage = 0;
							map.img = map_boss2.img;
							powerup.update();
						}
					}

					if (boss_stage == 2) {
						warning2.update();
						boss2.update();
						boss_attack1.update();
						boss_attack2.x = 100;
						boss_attack2.update();
						boss_attack3.x = 500;
						boss_attack3.update();
						powerup2.update();
						if (boss2.y == 10000) {
							boss_stage = 0;
							map.img = map_boss.img;
						}
					}
					if (boss_stage == 0 && count < 10) {
						monster.update();
						monster2.update();
						monster3.update();
						monster4.update();
						monster5.update();
					}
					if (boss_stage == 0 && count <= 21 && count >= 10) {
						monster_Y.update();
						monster_Y2.update();
						monster_Y3.update();
						monster_Y4.update();
						monster_Y5.update();
					}

					if (boss_stage == 0 && count <= 30 && count >= 21) {
						monster_P.update();
						monster_P2.update();
						monster_P3.update();
						monster_P4.update();
						monster_P5.update();
					}

					if (boss_stage == 0 && count <= 40 && count >= 30) {
						monster_G.update();
						monster_G2.update();
						monster_G3.update();
						monster_G4.update();
						monster_G5.update();
						if (monster_G3.y == 100) {
							monster_attack.update();
						}
						if (monster_G.y == 100) {
							monster_attack2.update();
						}
						if (monster_G5.y == 100) {
							monster_attack3.update();
						}
					}

					if (boss_stage == 0 && count < 50 && count >= 41) {
						monster_G.update();
						monster_G2.update();
						monster_G3.update();
						monster_G4.update();
						monster_G5.update();
						if (monster_G3.y == 100) {
							monster_attack.update();
						}
						if (monster_G.y == 100) {
							monster_attack2.update();
						}
						if (monster_G5.y == 100) {
							monster_attack3.update();
						}
					}
					if (boss_stage == 0 && count < 61 && count >= 41) {
						monster_B.update();
						monster_B2.update();
						monster_B3.update();
						monster_B4.update();
						monster_B5.update();
					}
					if (count == 20) {
						boss_stage = 1;
					}
					if (count == 40) {
						boss_stage = 2;
					}
					if (count == 60) {
						boss_stage = 3;
					}

					if (boss_stage == 3) {
						warning3.update();
						boss3.update();
						boss_attack4.x = boss3.x;
						boss_attack4.update();
						boss_attack5.x = boss3.x+100;
						boss_attack5.update();
						boss_attack6.x = boss3.x-100;
						boss_attack6.update();
						if (boss3.y == 10000) {
							boss3.y = -700;
							JOptionPane.showMessageDialog(null, "All CLEAR");
							int result = JOptionPane.showConfirmDialog(null, "SCORE : " + point + "\n다시 시작하겠습니까?", "점수판",
									JOptionPane.YES_NO_OPTION);
							if (result == JOptionPane.CLOSED_OPTION) {
								clip.close();
								character_HP = 3;
								character.y = -15000;
								point = 0;
								count = 0;
								boss_stage = 0;
								setVisible(false);
								new Game_main();
							} else if (result == JOptionPane.YES_OPTION) {
								character.y = -15000;
								clip.close();
								point = 0;
								count =0;
								boss_stage = 0;
								character_HP = 3;
								repaint();
								setVisible(false);
								new Game_menu();
							} else {
								clip.close();
								character.y = -15000;
								point = 0;
								count =0;
								boss_stage = 0;
								character_HP = 3;
								setVisible(false);
								new Game_main();
							}
						}
					}
					if (boss_stage == 1 && off == 1) {
						clip.stop();
						if (boss1.y == 10000) {
							clip.start();
						}
					}
					if (boss_stage == 2 && off == 1) {
						clip.stop();
						if (boss2.y == 10000) {
							clip.start();
						}
					}
					if (boss_stage == 3 && off == 1) {
						clip.stop();
						if (boss2.y == 10000) {
							clip.start();
						}
					}
					
					character.update();

					attack1.update();
					attack2.update();
					attack3.update();
					attack4.update();
					attack5.update();
					attack6.update();
					attack7.update();
					attack8.update();
					attack9.update();
					attack10.update();
					attack11.update();
					attack12.update();
					attack13.update();
					attack14.update();
					attack15.update();


					bomb.update();
					bomb2.update();
					bomb3.update();
					bomb4.update();
					bomb5.update();

					bomb_shoot(bomb);

					if (bomb_count == 5) {
						bomb_num1.update();
						bomb_num2.update();
						bomb_num3.update();
					}
					if (bomb_count == 3) {
						bomb_num1.update();
						bomb_num2.update();
						bomb_num3.y = 10000;
					}
					if (bomb_count == 1) {
						bomb_num1.update();
						bomb_num2.y = 10000;
						bomb_num3.y = 10000;
					}
					if (bomb_count == 0) {
						bomb_num1.y = 10000;
						bomb_num2.y = 10000;
						bomb_num3.y = 10000;
					}
					if (character_HP == 3) {
						HP1.update();
						HP2.update();
						HP3.update();
					}
					if (character_HP == 2) {
						HP1.update();
						HP2.update();
						HP3.y = 10000;
					}
					if (character_HP == 1) {
						HP1.update();
						HP2.y = 10000;
						HP3.y = 10000;
					}
					demage();
					move();
					shoot(attack1);
					shoot(attack2);
					shoot(attack3);
					shoot(attack4);
					shoot(attack5);
					shoot(attack6);
					shoot(attack7);
					shoot(attack8);
					shoot(attack9);
					shoot(attack10);
					shoot(attack11);
					shoot(attack12);
					shoot(attack13);
					shoot(attack14);
					shoot(attack15);

					monster_respawn(monster, monster2, monster3, monster4, monster5);
					monster_respawn2(monster_Y, monster_Y2, monster_Y3, monster_Y4, monster_Y5);
					monster_respawn3(monster_P, monster_P2, monster_P3, monster_P4, monster_P5);
					monster_respawn4(monster_G, monster_G2, monster_G3, monster_G4, monster_G5);
					monster_respawn5(monster_B, monster_B2, monster_B3, monster_B4, monster_B5);

					bomb_shoot(bomb);

					repaint();
					try {
						Thread.sleep(25);
					} catch (Exception e) {
						System.out.println(e);
						e.printStackTrace();
					}
				}
			}
		}
		Thread Thread = new MyThread();
		Thread.start();
	}

	public void paint(Graphics g) {
		super.paint(g);

		map.draw(g);
		powerup2.draw(g);
		powerup.draw(g);
		powerup3.draw(g);
		
		monster.draw(g);
		monster2.draw(g);
		monster3.draw(g);
		monster4.draw(g);
		monster5.draw(g);

		monster_Y.draw(g);
		monster_Y2.draw(g);
		monster_Y3.draw(g);
		monster_Y4.draw(g);
		monster_Y5.draw(g);

		monster_P.draw(g);
		monster_P2.draw(g);
		monster_P3.draw(g);
		monster_P4.draw(g);
		monster_P5.draw(g);

		monster_G.draw(g);
		monster_G2.draw(g);
		monster_G3.draw(g);
		monster_G4.draw(g);
		monster_G5.draw(g);

		monster_B.draw(g);
		monster_B2.draw(g);
		monster_B3.draw(g);
		monster_B4.draw(g);
		monster_B5.draw(g);

		if (monster_G3.y == 100) {
			monster_attack.draw(g);
		}
		if (monster_G.y == 100) {
			monster_attack2.draw(g);
		}
		if (monster_G5.y == 100) {
			monster_attack3.draw(g);
		}
		if (boss_stage ==1 ) {
		boss_attack.draw(g);
		}
		if (boss_stage ==2 ) {

		boss_attack1.draw(g);
		boss_attack2.draw(g);
		boss_attack3.draw(g);
		}
		if (boss_stage ==3 ) {

			boss_attack4.draw(g);
			boss_attack5.draw(g);
			boss_attack6.draw(g);
		}
		boss1.draw(g);
		boss2.draw(g);
		boss3.draw(g);

		warning.draw(g);
		warning2.draw(g);
		warning3.draw(g);

		character.draw(g);
		attack1.draw(g);
		attack2.draw(g);
		attack3.draw(g);
		attack4.draw(g);
		attack5.draw(g);
		attack6.draw(g);
		attack7.draw(g);
		attack8.draw(g);
		attack9.draw(g);
		attack10.draw(g);
		attack11.draw(g);
		attack12.draw(g);
		attack13.draw(g);
		attack14.draw(g);
		attack15.draw(g);

		attack_2.draw(g);
		attack_3.draw(g);
		attack_4.draw(g);
		

		bomb.draw(g);
		bomb2.draw(g);
		bomb3.draw(g);
		bomb4.draw(g);
		bomb5.draw(g);

		bomb_num1.draw(g);
		bomb_num2.draw(g);
		bomb_num3.draw(g);

		HP1.draw(g);
		HP2.draw(g);
		HP3.draw(g);
	}

	@Override
	public void keyPressed(KeyEvent event) {
		character.keyPressed(event);
		if (boss_stage == 1) {
			boss1.keyPressed(event);
		}
		if (boss_stage == 2) {
			boss2.keyPressed(event);
		}
		if (boss_stage == 3) {
			boss3.keyPressed(event);
		}
		if (a == 1) {
			attack1.keyPressed(event, character.x, character.y);
			a = 2;
		} else if (a == 2) {
			attack2.keyPressed(event, character.x, character.y);
			a = 3;
		} else if (a == 3) {
			attack3.keyPressed(event, character.x, character.y);
			a = 4;
		} else if (a == 4) {
			attack4.keyPressed(event, character.x, character.y);
			a = 5;
		} else if (a == 5) {
			attack5.keyPressed(event, character.x, character.y);
			a = 6;
		} else if (a == 6) {
			attack6.keyPressed(event, character.x, character.y);
			a = 7;
		} else if (a == 7) {
			attack7.keyPressed(event, character.x, character.y);
			a = 8;
		} else if (a == 8) {
			attack8.keyPressed(event, character.x, character.y);
			a = 9;
		} else if (a == 9) {
			attack9.keyPressed(event, character.x, character.y);
			a = 10;
		} else if (a == 10) {
			attack10.keyPressed(event, character.x, character.y);
			a = 11;
		} else if (a == 11) {
			attack11.keyPressed(event, character.x, character.y);
			a = 12;
		} else if (a == 12) {
			attack12.keyPressed(event, character.x, character.y);
			a = 13;
		} else if (a == 13) {
			attack13.keyPressed(event, character.x, character.y);
			a = 14;
		} else if (a == 14) {
			attack14.keyPressed(event, character.x, character.y);
			a = 15;
		} else if (a == 15) {
			attack15.keyPressed(event, character.x, character.y);
			a = 1;
		}

		if (bomb_count > 0) {
			bomb.keyPressed(event, character.x, character.y);
			bomb2.keyPressed(event, character.x, character.y);
			bomb3.keyPressed(event, character.x, character.y);
			bomb4.keyPressed(event, character.x, character.y);
			bomb5.keyPressed(event, character.x, character.y);
		}
		if (event.getKeyCode() == KeyEvent.VK_P) {
			if (off == 1) {
				clip.stop();
				off = 0;
			} else if (off == 0) {
				clip.start();
				off = 1;
			}
		}

		if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}