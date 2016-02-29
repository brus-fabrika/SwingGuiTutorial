import java.awt.geom.Rectangle2D;


public class Squere extends Rectangle2D.Double{
	
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
		UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT;
	}
	
	public Squere() {
		super();
		setRect(xPos, yPos, w, h);
		setFrame(xPos, yPos, w, h);
	}
	
	public Squere(int x, int y, int w, int h) {
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
	@Override
	public Rectangle2D createIntersection(Rectangle2D r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle2D createUnion(Rectangle2D r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int outcode(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRect(double x, double y, double w, double h) {
		
		Rectangle2D r2d = new Rectangle2D.Double(x, y, w, h);
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return xPos;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return yPos;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
