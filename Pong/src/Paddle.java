import java.awt.Color;

public class Paddle extends Sprite {
	
	final static int WIDTH = 10;
	final static int HEIGHT = 100;
	final static int EDGE = 40;
	final static Color COLOUR = Color.WHITE;
	
	public Paddle(Player player, int PanelWidth, int PanelHeight) {
		setWidth(WIDTH);
		setHeight(HEIGHT);
		setColour(COLOUR);
		if(player == player.One) {
			setInitialPosition(EDGE, PanelHeight / 2 - (HEIGHT / 2));
		}else if(player == player.Two) {
			setInitialPosition(PanelWidth - EDGE, PanelHeight / 2 - (HEIGHT / 2));
		}
		resetInitialPositions();
	}
}
