package final_term_shooting_game;

class map extends GraphicObject {
	double dx = -10;

	public map(String name) {
		super(name);
		x = 0;
		y = -1000;
	}
	@Override
	public void update() {
		y += dx;
		if (y < 0) {
			dx = +5;
		}
		if (y == 0) {
			x = 0;
			y = -1000;
		}
	}
}
