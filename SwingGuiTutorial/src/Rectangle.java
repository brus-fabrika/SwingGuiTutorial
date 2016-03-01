import java.awt.geom.Rectangle2D;
 
 
  public class Rectangle extends Rectangle2D.Double{
  	
  	private double xPos = 200;
  	private double yPos = 200;
  	private double w = 100;
  	private double h = 100;
  	
  	private Direction direction = Direction.UPRIGHT;
  	
  	public Direction getDirection() {
  		return direction;
  	}
  	public void setDirection(Direction direction) {
  		this.direction = direction;
  	}
  
  	public static enum Direction {
  		UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT, LEFT, RIGHT;
  	}
  	
  	public Rectangle () {
  		super();
  		setRect(xPos, yPos, w, h);
  		setFrame(xPos, yPos, w, h);
  	}
  	
  	public Rectangle (int x, int y, int w, int h) {
  		super();
  		this.xPos = x;
  		this.yPos = y;
  		this.w = w;
  		this.h = h;
  		setFrame(this.xPos, this.yPos, this.w, this.h);
  		
  	}
  	
  	public void moveTo(double x, double y) {
  		this.xPos = x;
  		this.yPos = y;
  		
  		setFrame(this.xPos, this.yPos, this.w, this.h);
  	}
  	
  	public boolean isBoarder(double width, double height) {
		if(xPos == 0 || xPos + w == width || yPos == 0 || yPos + h== height) {
			return true;
		}
		return false;
	}
  }	
