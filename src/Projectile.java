import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
int speed = 10;
	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
void update() {
	super.update();
	y =y - speed;
	//System.out.println("check");
	if(y<0) {
		isAlive = false;
		
	}
}
void draw(Graphics g) {
	g.setColor(Color.RED);
	g.drawRect(x, y, width, height);
}

}