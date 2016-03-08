import java.awt.geom.Rectangle2D;



public class Rectangle extends Rectangle2D{
	private double xPos = 200;
	private double yPos = 200;
	private double rHeight = 50;
	private double rWidth = 50;
	
	
	private Direction direction = Direction.DOWNRIGHT;
	
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public static enum Direction {
		UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT;
	}
	
	public Rectangle(){
		super();
		setFrame(this.xPos, this.yPos, this.rHeight,this.rWidth);
	}
	
	public Rectangle(int x, int y, int height){
		super();
		this.xPos = x;
		this.yPos = y;
		this.rHeight = height;
		this.rWidth = height;
		setFrame(this.xPos, this.yPos, this.rHeight, this.rWidth);
	}
	
	public void moveRecTo(double x, double y){
		this.xPos = x;
		this.yPos = y;
		setFrame(this.xPos, this.yPos, rHeight, rWidth);
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
				
	}

	@Override
	public double getHeight() {
		return this.rHeight;
	}

	@Override
	public double getWidth() {
		return this.rWidth;
	}

	@Override
	public double getX() {
		return this.xPos;
	}

	@Override
	public double getY() {
		return this.yPos;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean isBoarderX(double width, double height) {
		if(xPos <= 0 || xPos + rWidth >= width) {
			return true;
		}
		return false;
	}
	public boolean isBoarderY(double width, double height) {
		if(yPos <= 0 || yPos + rHeight >= height) {
			return true;
		}
		return false;
	}
}
