import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer timer;
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
	}
	void updateMenuState() {
		
	}
	void updateGameState() {
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		manager.purgeObjects();
		
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
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500 ,800 );  
		manager.draw(g);
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500 ,800 );  
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Game Over", 110, 200);
		g.setFont(clickFont);
		g.drawString("You killed 5 enemies", 115, 350);
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
		if(e.getKeyCode()==KeyEvent.VK_UP) {
		rocket.motion = true;
		System.out.println("KeyPressed");
			rocket.update(rocket.UP);
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			rocket.motion = true;
			rocket.update(rocket.DOWN);
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			rocket.motion = true;
			rocket.update(rocket.RIGHT);
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			rocket.motion = true;
			rocket.update(rocket.LEFT);
		}
		else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			 manager.addProjectile(new Projectile(rocket.x + 20, rocket.y, 10, 10));
		
			
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

