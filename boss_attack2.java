package final_term_shooting_game;

public class boss_attack2 extends GraphicObject {
	double dy = -10;

	public boss_attack2(String name) {
		super(name);
		x = 100;
		y = -200;
	}

	@Override
	public void update() {
		y += dy;
		if (y < 0) {
			dy = +5.5;
		}
		if (y > 1000) {
			x = 100;
			y = 250;
		}
	}
}