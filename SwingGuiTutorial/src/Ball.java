import java.awt.geom.Ellipse2D;


public class Ball extends Ellipse2D.Double {

	private double xPos = 200;
	private double yPos = 200;
	private double radius = 50;
	
	private Direction direction = Direction.UPLEFT;
	
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public static enum Direction {
		UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT, LEFT, RIGHT;
	}
	
	public Ball() {
		super();
		setFrame(xPos, yPos, radius, radius);
	}
	
	public Ball(int x, int y, int r) {
		super();
		this.xPos = x;
		this.yPos = y;
		this.radius = r;
		setFrame(this.xPos, this.yPos, this.radius, this.radius);
	}
	
	public void moveTo(double x, double y) {
		this.xPos = x;
		this.yPos = y;
		
		setFrame(this.xPos, this.yPos, radius, radius);
	}

	public boolean isBoarder(double width, double height) {
		if(xPos == 0 || xPos + radius == width || yPos == 0 || yPos + radius == height) {
			return true;
		}
		return false;
	}
}
