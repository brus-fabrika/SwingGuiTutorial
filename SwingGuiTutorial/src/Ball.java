import java.awt.geom.Ellipse2D;


public class Ball extends Ellipse2D.Double {

	private double xPos = 200;
	private double yPos = 200;
	private double radius = 50;
	
	private int directionX = 1;
	private int directionY = 1;
	
	
	public double getRadius(){
		return radius;
	}
	
	public static int getBallRadius(){
		return 20+(int)(Math.random() *50);
	}
	
	private Direction direction = changeDirection();
	
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public void setDirection(int number) {
		if (number ==0) {
			this.direction = Direction.UPLEFT;
			this.directionX = -1;
			this.directionY = -1;
		}
		else if (number ==1) {
			this.direction = Direction.UPRIGHT;
			this.directionX = 1;
			this.directionY = -1;
		}
		else if (number ==2) {
			this.direction = Direction.DOWNLEFT;
			this.directionX = -1;
			this.directionY = 1;
		}
		else if (number ==3) {
			this.direction = Direction.DOWNRIGHT;
			this.directionX = 1;
			this.directionY = 1;
		}
		
	}
	public void setDirection(int x, int y) {
		if (x == -1 && y == -1) {
			this.direction = Direction.UPLEFT;
			this.directionX = -1;
			this.directionY = -1;
		}
		else if (x == 1 && y == -1) {
			this.direction = Direction.UPRIGHT;
			this.directionX = 1;
			this.directionY = -1;
		}
		else if (x == 1 && y == 1) {
			this.direction = Direction.DOWNLEFT;
			this.directionX = -1;
			this.directionY = 1;
			}
		else if (x == 1 && y == 1) {
			this.direction = Direction.DOWNRIGHT;
			this.directionX = 1;
			this.directionY = 1;
		}
	}
	public static Direction changeDirection() { 
		int numb = ((int)(Math.random() * 3));
		Direction dir = null;
		if (numb == 0) dir = Direction.UPLEFT;
		if (numb == 1) dir = Direction.UPRIGHT;
		if (numb == 2) dir = Direction.DOWNLEFT;
		if (numb == 3) dir = Direction.DOWNRIGHT;
		
		return dir;
	}
	
	public static enum Direction {
		UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT;
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
	
	
	
	
	public int getDirectionX() {
		return directionX;
	}

	public void setDirectionX(int directionX) {
		this.directionX = directionX;
	}

	public int getDirectionY() {
		return directionY;
	}

	public void setDirectionY(int directionY) {
		this.directionY = directionY;
	}
}
