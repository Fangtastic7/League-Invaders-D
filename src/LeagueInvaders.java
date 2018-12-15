


import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders  {
	static final int width = 500;
	static final int height = 800;
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
	
	frame.setSize(width, height);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(panel);
	frame.getContentPane().setPreferredSize(new Dimension(width, height));

    frame.pack();
    panel.startGame();
    frame.addKeyListener(panel);
}


}
