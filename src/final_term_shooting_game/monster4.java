package final_term_shooting_game;

class monster4 extends GraphicObject {
	double dx = -10;

	public monster4(String name) {
		super(name);
		x = 0;
		y = -500;
	}

	@Override
	public void update() {
		y += dx;
		if (y < 0) {
			dx = +5;
		}
		if (y >= 100) {
			dx = 0;
			y = 100;
		}
//		if (y > 1000) {
//			x = 0;
//			y = -500;
//		}
	}
}