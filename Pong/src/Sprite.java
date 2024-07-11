import java.awt.Color;
import java.awt.Rectangle;

public class Sprite {
 private int xPosition;
 private int yPosition;
 private int initialXPosition;
 private int initialYPosition;
 private int xVelocity;
 private int yVelocity;
 private int width;
 private int height;
 private Color colour;
 
 public void setXPosition(int x) {
	 this.xPosition = x;
 }
 
 public void setYPosition(int y) {
	 this.yPosition = y;
 }
 
 public void setXPosition(int newX, int panelWidth) {
	 xPosition = newX;
	 if(newX < 0) {
	    xPosition = 0;
	      }else if(xPosition + width > panelWidth) {
	    	  xPosition = panelWidth - width;
	      }
	 
	 }
	 public void setYPosition(int newY, int panelHeight) {
		 yPosition = newY;
		 
		 if(yPosition < 0) {
			 yPosition = 0;
		 }else if(yPosition + height > panelHeight ) {
			 yPosition = panelHeight - height;
		 }
		
	     
	 }
 
 public void setXVelocity(int x) {
	 this.xVelocity = x;
	 
 }
 
 public void setYVelocity(int y) {
	 this.yVelocity = y;
 }
 
 public void setWidth(int width) {
	 this.width = width;
 }
 
 public void setHeight(int height) {
	 this.height = height;
 }
 
 public void setColour(Color colour) {
	 this.colour = colour;
 }
 
 public Color getColour(Color colour) {
	 return this.colour;
 }
 
 public void setInitialPosition(int x, int y) {
	 initialXPosition = x;
	 initialYPosition = y;
 }
 
 public void resetInitialPositions() {
	 setXPosition(initialXPosition);
	 setYPosition(initialYPosition);
 }
 
 public Rectangle getRectangle() {
	 return new Rectangle(getxPosition(),getyPosition(),getWidth(),getHeight());
 }
 
 public int getxPosition() {return xPosition;}
 public int getyPosition() {return yPosition;}
 public int getxVelocity() {return xVelocity;}
 public int getyVelocity() {return yVelocity;}
 public int getWidth() {return width;}
 public int getHeight() {return height;}
}
