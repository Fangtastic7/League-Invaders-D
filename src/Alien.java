import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject{

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
void update() {
	super.update();
	Random random = new Random();
	int speed = random.nextInt(5);
	y = y + speed;
	
}
void draw(Graphics g) {
	 g.drawImage(GamePanel.alienImg, x, y, width, height, null);
}
}
