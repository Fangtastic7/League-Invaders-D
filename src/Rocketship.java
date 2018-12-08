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
	

	x=250;
	y=700;
		GameObject object = new GameObject( x,  y, width, height);
		//object.x=x;
		//object.y=y;
		
		// TODO Auto-generated constructor stub
	}
void update(int type){
	super.update();
if(motion) {
if(type==RIGHT) {
x = x + speed;
}
else if(type==LEFT) {
x = x - speed;
}
else if(type==DOWN) {
y = y + speed;
}
else if(type==UP) {
y = y - speed;
}
}
	
}
void draw(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(x, y, width, height);
}
	
}


