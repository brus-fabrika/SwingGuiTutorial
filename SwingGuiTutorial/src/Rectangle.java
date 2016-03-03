import java.awt.geom.Rectangle2D;

public class Rectangle extends Rectangle2D.Double {
	private double xPos = 200;
	private double yPos = 200;
	private double width = 50;
	private double heigth = 70;

	private Direction direction = Direction.UPRIGHT;
	
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public void setDirection(int number) {
		if (number ==0) this.direction = Direction.UPLEFT;
		else if (number ==1) this.direction = Direction.UPRIGHT;
		else if (number ==2) this.direction = Direction.DOWNLEFT;
		else if (number ==3) this.direction = Direction.DOWNRIGHT;
		
	}
	
	public static enum Direction {
		UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT;
	}
	
	public Rectangle() {
		super();
		setFrame(xPos, yPos, width, heigth);
	}
	
	public Rectangle(int x, int y, int w, int h) {
		super();
		this.xPos = x;
		this.yPos = y;
		this.width = w;
		this.heigth = h;
		setFrame(this.xPos, this.yPos, this.width, this.heigth);
	}
	
	public void moveTo(double x, double y) {
		this.xPos = x;
		this.yPos = y;
		
		setFrame(this.xPos, this.yPos, width, heigth);
	}

	public boolean isBoarder(double width, double height) {
		if(xPos == 0 || xPos + width == width || yPos == 0 || yPos + heigth== height) {
			return true;
		}
		return false;
	}
}
