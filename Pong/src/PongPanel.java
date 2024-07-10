import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Graphics2D;



public class PongPanel extends JPanel implements ActionListener, KeyListener {
	
	private final static int TIMER_DELAY = 5;
	
	public PongPanel() {
		setBackground(Color.black);
		Timer timer = new Timer(TIMER_DELAY,this); //object which creates the loop for the game
		
		timer.start(); //starting the timer
	}
	
	//methods auttomatically created by using implements action listener and key listener

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		update();
		repaint();
		
	}
	
	//The method which will be used to update each from of the game
	
	public void update(){
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.WHITE);
    g.fillRect(20, 20, 100, 100);
	 }

}
