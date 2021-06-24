package final_term_shooting_game;

import java.awt.event.KeyEvent;

class character extends GraphicObject {

	public character(String name) {
		super(name);
		x = 300;
		y = 750;
	}
	
	@Override
	public void update() {
		if (y == -15000) {
			y = -15000;
		}
	}
	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= 35;
		}
		if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += 35;
		}
		if (event.getKeyCode() == KeyEvent.VK_UP) {
			y -= 35;
		}
		if (event.getKeyCode() == KeyEvent.VK_DOWN) {
			y += 35;
		}
	}
}