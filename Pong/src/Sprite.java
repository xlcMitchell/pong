import java.awt.Color;
import java.awt.Rectangle;

//sprite class will be the parent class for both the pong and paddle. It contains the position,velocity,colour etc

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
 
 //can use the same name for methods. We just have to have different different parameters
 
 public void setXPosition(int newX, int panelWidth) {
	 xPosition = newX;
	 
	 //this conditional statement checks to make sure that object has not gone off the screen
	 //if the xPosition is less than 0 then it will have gone off the screen so we reset it to 0
	 
	 if(xPosition < 0) { 
	    xPosition = 0;
	    //if the xPosition + the width is greater than panels width then it will go off screen in
	    //the other direction so we need to set the x position to the panels width less the width of 
	    //the object
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
 
 public Color getColour() {
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
