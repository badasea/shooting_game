package final_term_shooting_game;

public class boss_attack3 extends GraphicObject {
	int dy = -10;

	public boss_attack3(String name) {
		super(name);
		x = 500;
		y = -200;
	}

	@Override
	public void update() {
		y += dy;
		if (y < 0) {
			dy = +5;
		}
		if (y > 1290) {
			x = 500;
			y = 250;
		}
	}
}