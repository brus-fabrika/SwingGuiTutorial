import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Ball extends Ellipse2D.Double {

	private double xPos = 200;
	private double yPos = 200;
	private double radius = 50;
	
	private Direction direction = Direction.UPLEFT;
	
	
public Direction rndDir() {
		
		Random rnd = new Random();
		
		int n = rnd.nextInt(4);
		
		switch(n){
			case 0:
				setDirection(Direction.UPRIGHT);
				break;
			case 1:
				setDirection(Direction.UPLEFT);
				break;
			case 2:
				setDirection(Direction.DOWNLEFT);
				break;
			case 3:
				setDirection(Direction.DOWNRIGHT);
				break;
		}
		return direction;}
	
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public static enum Direction {
		UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT;
	}
	
	public Ball() {
		super();
		rndDir();
		setFrame(xPos, yPos, radius, radius);
	}
	
	public Ball(int x, int y, int r) {
		super();
		rndDir();
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
public double getRadius(){
	return this.radius;
}
public double getXpos() {
	return this.xPos;
}

public double getYpos() {
	return this.yPos;
}
}