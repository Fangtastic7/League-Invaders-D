import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class LeagueInvaders implements KeyListener {
	JFrame frame;
	GamePanel panel;
public static void main(String[] args) {
	new LeagueInvaders().setup();
}
public LeagueInvaders() {
	frame = new JFrame("League Invaders");
	panel = new GamePanel();
}
private void setup() {
	// TODO Auto-generated method stub
	frame.setVisible(true);
	final int length = 500;
	final int height = 800;
	frame.setSize(length, height);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(panel);
	frame.getContentPane().setPreferredSize(new Dimension(length, height));

    frame.pack();
    panel.startGame();
    panel.addKeyListener(panel);
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
