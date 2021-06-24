package final_term_shooting_game;

class warning extends GraphicObject {
	double dx = -10;

	public warning(String name) {
		super(name);
		x = -350;
		y = 300;
	}

	@Override
	public void update() {
		x += dx;
		if (x < 1000) {
			dx = +4;
		}
	}
}