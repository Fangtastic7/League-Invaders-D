import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	static final int UP = 4;
	static final int DOWN = 3;
	static final int RIGHT = 1;
	static final int LEFT = 2;
	boolean motion = false;
	int speed;
	int type;
	GamePanel key;

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 20;

		x = 250;
		y = 700;
		GameObject object = new GameObject(x, y, width, height);
		// object.x=x;
		// object.y=y;

		// TODO Auto-generated constructor stub
	}

	void update() {
		
		if (motion) {
			if (type == RIGHT) {
				x = x + speed;
				if (x > LeagueInvaders.width - this.width) {
					x = LeagueInvaders.width - this.width;
				}
			} else if (type == LEFT) {
				x = x - speed;
				if (x < 0) {
					x = 0;
				}
			} else if (type == DOWN) {
				y = y + speed;
				if (y > LeagueInvaders.height - this.height) {
					y = LeagueInvaders.height - this.height;
				}
			} else if (type == UP) {
				y = y - speed;
				if (y < 0) {
					y = 0;
				}
			}
		}
		super.update();
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
		// (Color.BLUE);
		// g.fillRect(x, y, width, height);
		// g.setColor(Color.RED);
		// g.drawRect(x, y , width, height);
	}

}
