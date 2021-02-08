package final_term_shooting_game;

public class boss_attack extends GraphicObject {
	int dy = -10;

	public boss_attack(String name) {
		super(name);
		x = 300;
		y = -200;
	}

	@Override
	public void update() {
		y += dy;
		if (y < 0) {
			dy = +5;
		}
		if (y > 1140) {
			x = 300;
			y = 250;
		}
	}
}