import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer timer;
	public static BufferedImage alienImg;
    public static BufferedImage rocketImg;
    public static BufferedImage bulletImg;
    public static BufferedImage spaceImg;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int CURRENT_STATE = MENU_STATE; 
	int key=0;
	Font titleFont;
	Font clickFont;
	Rocketship rocket ;
	GameObject object;
	ObjectManager manager;
	public GamePanel() {
	timer = new Timer(1000/60,this);
	titleFont = new Font("Arial", Font.BOLD, 48 );
	clickFont = new Font("Arial", Font.BOLD, 28);
	rocket = new Rocketship(225  , 750  , 50, 50);
	manager = new ObjectManager(rocket);
    try {

        alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));

        rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));

        bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));

        spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));

} catch (IOException e) {

        // TODO Auto-generated catch block

        e.printStackTrace();

}
	}
	void updateMenuState() {
		
	}
	void updateGameState() {
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		manager.purgeObjects();
		if(rocket.isAlive==false) {
			CURRENT_STATE = END_STATE;
			
		}
		
	}
	void updateEndState() {
		
		
		
	}
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500 ,800 );  
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
        g.drawString("LEAGUE INVADERS", 20, 200 );
        g.setFont(clickFont);
        g.setColor(Color.YELLOW);
        g.drawString("Press ENTER to start", 100, 350);
        g.drawString("Press SPACE for instructions", 50, 500);

	}
	void drawGameState(Graphics g) {
	
		 g.drawImage(GamePanel.spaceImg, 0, 0, 500, 800, null);
		manager.draw(g);
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500 ,800 );  
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Game Over", 110, 200);
		g.setFont(clickFont);
		g.drawString("You killed " + manager.score + " enemies", 115, 350);
		g.drawString("Press ENTER to restart", 95, 500);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		
		  if(CURRENT_STATE == MENU_STATE){

              updateGameState();

      }else if(CURRENT_STATE == GAME_STATE){

              updateGameState();

      }else if(CURRENT_STATE == END_STATE){

              updateEndState();

      }
	}
	
	public void startGame(){
		timer.start();
		//object = new GameObject(100,100,20,20);
	}
	 @Override

	public void paintComponent(Graphics g) {
		//object.draw(g);
		 if(CURRENT_STATE == MENU_STATE){

             drawMenuState(g);

     }else if(CURRENT_STATE == GAME_STATE){

             drawGameState(g);

     }else if(CURRENT_STATE == END_STATE){

             drawEndState(g);

     }

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("KeyTYPES");
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("KeyPressed");
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(CURRENT_STATE >= END_STATE) {
				rocket = new Rocketship(225  , 750  , 50, 50);
				manager = new ObjectManager(rocket);
			}
			System.out.println("Enter is pressed");
			if(CURRENT_STATE >= END_STATE){
				
                CURRENT_STATE = MENU_STATE;
        }
			else if(CURRENT_STATE == MENU_STATE) {
				CURRENT_STATE = GAME_STATE;
			}
			else if(CURRENT_STATE == GAME_STATE) {
				CURRENT_STATE = END_STATE;
			}
			
		}
		else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			 manager.addProjectile(new Projectile(rocket.x + 20, rocket.y, 10, 10));
		}
		else {
			if(!rocket.motion) {
				
			
			
		
		if(e.getKeyCode()==KeyEvent.VK_UP) {
		rocket.motion = true;
		System.out.println("KeyPressed");
			rocket.type=(rocket.UP);
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			rocket.motion = true;
			rocket.type=(rocket.DOWN);
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			rocket.motion = true;
			rocket.type=(rocket.RIGHT);
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			rocket.motion = true;
			rocket.type=(rocket.LEFT);
		}
		}
		}
//object.update();
		
		repaint();
	
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("keyReleased");
		rocket.motion = false;
	}
		}

