import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
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
	private final static int POINTS_TO_WIN = 3;
	int player1Score = 0, player2Score = 0;
	Player gameWinner;
	
	public void createObjects() {
		ball = new Ball();
		paddle = new Paddle(Player.One,getWidth(),getHeight());
		paddle1 = new Paddle(Player.Two,getWidth(),getHeight());
	}
	
	public void moveObject(Sprite sprite) {
		
		 sprite.setXPosition(sprite.getxPosition() + sprite.getxVelocity(),getWidth());
	      sprite.setYPosition(sprite.getyPosition() + sprite.getyVelocity(),getHeight());
			
		}
	
public void checkWallBounce(Sprite sprite) {

	//had to add the width of the ball to the x position otherwise it wouldn't reach the side and would not change the velocity
	//This doesn't work going the other way because x position is at the beginning of the ball
	if(sprite.getxPosition() + sprite.getWidth() == getWidth() || sprite.getxPosition()  == 0) {
		sprite.resetInitialPositions();
	}
	
	if(sprite.getyPosition() + sprite.getHeight() == getHeight()) {
		sprite.setYVelocity(-2);
	}else if(sprite.getyPosition() == 0) {
		sprite.setYVelocity(2);
	}
}


//collision detection
//using the rectangle class makes it easy because it has an intersect method

public void checkPaddleBounce() {
	      if(ball.getxVelocity() < 0 && ball.getRectangle().intersects(paddle.getRectangle())) {
		          ball.setXVelocity(2);
		     }
		     if(ball.getxVelocity() > 0 && ball.getRectangle().intersects(paddle1.getRectangle())) {
		        ball.setXVelocity(-2);
		     }
}

   public void addScore() {
	  if(ball.getxPosition() == 0) {
		  player2Score += 1;
		 
		  System.out.println("Player 1 =" + Player.One);
	  }
	  
	  if(ball.getxPosition() + ball.getWidth() == getWidth()) {
		  player1Score += 1;
		  System.out.println("Player 2 score =" + player2Score);
	  }
   }
   
   public void checkWinner() {
	   if(player1Score == POINTS_TO_WIN) {
		   gameWinner = Player.One;
		   gameState = gameState.GAMEOVER;
	   }else if(player2Score == POINTS_TO_WIN) {
		   gameWinner = Player.Two;
		   gameState = gameState.GAMEOVER;
	   }
   }
	
	public PongPanel() {
		setBackground(Color.black);
		Timer timer = new Timer(TIMER_DELAY,this); //object which creates the loop for the game
		timer.start(); //starting the timer
		
		//adding a key listener to the pong panel
		//We need to set focusable variables because the JPanel (PongPanel) must have focus to receive keyboard events. Doing this will call the keyPressed() method when a key is pressed and the keyReleased() method when a key is released.
		addKeyListener(this);
		setFocusable(true);
	}
	
	//methods auttomatically created by using implements action listener and key listener

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_UP) {
			paddle1.setYVelocity(-2);
		}else if(event.getKeyCode() == KeyEvent.VK_DOWN) {
			paddle1.setYVelocity(2);
		}
		
		if(event.getKeyCode() == 87) {
			paddle.setYVelocity(-2);
		}else if(event.getKeyCode() == 83) {
			paddle.setYVelocity(2);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
	    if(event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_DOWN) {
	                 paddle1.setYVelocity(0);
	    	        }
	    
	    if(event.getKeyCode() == 83 || event.getKeyCode() == 87) {
	    	paddle.setYVelocity(0);
	    }
		
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
			checkWallBounce(ball);
			 moveObject(paddle);
             moveObject(paddle1);
			moveObject(ball);
			checkPaddleBounce();
			addScore();
			checkWinner();
			
			
			
			
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
    paintScores(g);
    
    if(gameState == gameState.GAMEOVER) {
    	paintGameOver(g);
    	paintWinner(g);
    }
	 }
	
	//painting our dotted line method
	
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
	
	private void paintScores(Graphics g) {
		int xPadding =  100;
		int yPadding = 100;
		int fontSize = 50;
		Font scoreFont = new Font("Serif", Font.BOLD, fontSize);
		
		//Must have to conver it to a string first because the graphics object method must only work with strings
		
		String leftScore = Integer.toString(player1Score);
		String rightScore = Integer.toString(player2Score);
		g.setFont(scoreFont);
		g.drawString(leftScore, xPadding, yPadding);
		g.drawString(rightScore, getWidth() - xPadding, yPadding);
		
	}
	
	public void paintGameOver(Graphics g) {
		int width = g.getFontMetrics().stringWidth("GAME OVER");
		g.drawString("GAME OVER",getWidth() / 2 - (width / 2),getHeight() / 2);
		
	}
	
	public void paintWinner(Graphics g) {
		int padx = 100;
		int pady = getHeight() / 3;
		int width = g.getFontMetrics().stringWidth("YOU WIN!!");
		if(gameWinner == Player.One) {
			g.drawString("YOU WIN!!",padx,pady);
		}else if(gameWinner == Player.Two) {
			g.drawString("YOU WIN!!", getWidth() - padx - width, pady);
		}
	}
	
	public void panelSize() {
		this.panelHeight = getHeight();
		this.panelWidth = getWidth();
	}

}
