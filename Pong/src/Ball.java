import java.awt.Color;

public class Ball extends Sprite {
	

	//final static Color colour;
	final static int WIDTH = 25;
	final static int HEIGHT = 25;
	final static Color COLOUR = Color.WHITE;
	
	
	public Ball() {
		setWidth(WIDTH);
		setHeight(HEIGHT);
		setColour(COLOUR);
		
		//800 for width and 600 for height. Don't know where to access screenWidth and screenHeight
		
		//The set initial position is being calculated with the first parameter which divides the width by 2 so it is centered, then the width of
		//the ball also gets divided by 2 so that the ball is in the center otherwise it would be slightly offset
		
		setInitialPosition(784 / 2 - (getWidth() / 2), 564 / 2 - (getHeight() / 2));
		resetInitialPositions();
	}


}
