import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;
	int type;
	GamePanel key;
public Rocketship(int x, int y, int width, int height) {
	super(x, y, width, height);
	speed = 5;
	key = new GamePanel();
	key.key=type;
	x=250;
	y=700;
		GameObject object = new GameObject( x,  y, width, height);
		//object.x=x;
		//object.y=y;
		
		// TODO Auto-generated constructor stub
	}
void update(){
if(type==1) {
x = x + speed;
}
else if(type==2) {
x = x - speed;
}
else if(type==3) {
y = y + speed;
}
else if(type==4) {
y = y - speed;
}

	
}
void draw(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(x, y, width, height);
}
	
}


