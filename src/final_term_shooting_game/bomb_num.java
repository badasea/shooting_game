package final_term_shooting_game;

public class bomb_num extends GraphicObject {
	boolean launched = false;

	public bomb_num(String name) {
		super(name);
		x = 670;
		y = 900;
	}

	@Override
	public void update() {
		if (y == 10000)
			y = 10000;
	}
}