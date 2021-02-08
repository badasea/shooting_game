package final_term_shooting_game;

class monster5 extends GraphicObject {
	 double dx = -10;
	 public monster5(String name) {
	  super(name);
	  x = 0;
	  y = -500;
	 }

	 @Override
	 public void update() {
	  y += dx;
	  if (y < 0) {
	   dx = +10;
	  }
	  if (y > 1000) {
		   x = 0;
		   y = -500;
	  }
	 }
}