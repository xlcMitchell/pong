import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.BasicStroke;



public class PongPanel extends JPanel implements ActionListener, KeyListener {
	
	private final static int TIMER_DELAY = 5;
	Ball ball;
	Paddle paddle;
	Paddle paddle1;
	GameState gameState = GameState.INITIALISING;
	public int panelHeight;
	public int panelWidth;
	
	public void createObjects() {
		ball = new Ball();
		paddle = new Paddle(Player.One,getWidth(),getHeight());
		paddle1 = new Paddle(Player.Two,getWidth(),getHeight());
	}
	
	
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
		switch(gameState) {
		case INITIALISING: {
			createObjects();
			gameState = GameState.PLAYING;
			break;
		}
		
		case PLAYING:{
			break;
		}
		
		case GAMEOVER: {
			break;
		}
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
    super.paintComponent(g);
  
    paintDottedLine(g);
    if(gameState != GameState.INITIALISING) {
    	            paintSprite(g, ball);
    	          }
    paintSprite(g,ball);
    paintSprite(g,paddle);
    paintSprite(g,paddle1);
	 }
	
	private void paintDottedLine(Graphics g) {
		     Graphics2D g2d = (Graphics2D) g.create();
		     Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
	         g2d.setStroke(dashed);
             g2d.setPaint(Color.WHITE);
		     g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
	         g2d.dispose();
	        
		 }
	
	private void paintSprite(Graphics g, Sprite sprite) {
	     g.setColor(sprite.getColour());
	     g.fillRect(sprite.getxPosition(), sprite.getyPosition(), sprite.getWidth(), sprite.getHeight());
	}
	
	public void panelSize() {
		this.panelHeight = getHeight();
		this.panelWidth = getWidth();
	}

}
