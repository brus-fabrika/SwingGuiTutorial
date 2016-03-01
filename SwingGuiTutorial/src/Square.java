import java.awt.geom.Rectangle2D;


public class Square extends Rectangle2D.Double {
	private double xPos = 100;
	private double yPos = 100;
	private double w = 100;
	private double h = 100;
	
	private Direction direction = Direction.DOWN;
	
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public static enum Direction {
		UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT, UP, DOWN, LEFT, RIGHT;
	}
	
	public Square() {
		super();
		setFrame(xPos, yPos, w, h);
	}
	
	public Square(int x, int y, int w, int h) {
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
		
		setFrame(this.xPos, this.yPos, w, h);
	}

	public boolean isBoarderX(double width, double height) {
	
	
		if(xPos == 0 || xPos + w == width) {
			return true;
	
		}
	
		return false;
	}
	
	
	public boolean isBoarderY(double width, double height) {
		
		if(yPos == 0 || yPos + h == height){
			return true;
			}
		return false;
		}


}

	