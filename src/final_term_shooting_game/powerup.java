package final_term_shooting_game;

class powerup extends GraphicObject {
	double dx = -10;

	public powerup(String name) {
		super(name);
		x = 300;
		y = -400;
	}

	@Override
	public void update() {
		if (y < 100) {
			y += dx;
			dx = +4;
			if (y >= 100) {
				dx = 0;
				y = 100;
			}
		}
	}
}