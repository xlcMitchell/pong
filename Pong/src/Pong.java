import javax.swing.JFrame;

public class Pong extends JFrame {
	
	//Final variabes declared so that can't be changed
	 static final int  SCREEN_WIDTH = 800;
	 static final int SCREEN_HEIGHT = 600;
	 static final String WINDOW_TITLE = "Pong";
	
	
	public Pong() {
		setTitle(WINDOW_TITLE);
		setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		setResizable(false);
		add(new PongPanel());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
			 
	          public void run() {
	 
	                 new Pong();
	                 
	 
	          }
	 
	        });

	}

}
