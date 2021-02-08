package final_term_shooting_game;

public class HP_num extends GraphicObject {
	public HP_num(String name) {
		super(name);
		x = 0;
		y = 25;
	}

	@Override
	public void update() {
		if (y == 10000)
			y = 10000;
	}
}
