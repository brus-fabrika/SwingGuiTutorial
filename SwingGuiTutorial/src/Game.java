import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;




public class Game {

	JPanel parent;
	
	Set<Ball> theCircles = new HashSet<>();
	Set<Rectangle> theRectangular = new HashSet<>();	
	
	
	
	
	public Game(JPanel panel) {
		this.parent = panel;
	}
	
	public void step() {
		for(Ball b: theCircles) {
			nextMove(b);
		}
		for(Rectangle x: theRectangular) {
			nextMove(x);
		}
		parent.repaint();
	}

	private void nextMove(Ball b) {
		double bX = b.getX();
		double bY = b.getY();
		
		checkBallCollision(b);
		checkCollision(b);
		
		switch(b.getDirection()) {
		case UPLEFT:
			bX -= 1.0;
			bY -= 1.0;
			break;
		case UPRIGHT:
			bX += 1.0;
			bY -= 1.0;
			break;
		case DOWNLEFT:
			bX -= 1.0;
			bY += 1.0;
			break;
		case DOWNRIGHT:
			bX += 1.0;
			bY += 1.0;
			break;
		}
		
		b.moveTo(bX, bY);
	}
	
	private void nextMove(Rectangle b) {
		double bX = b.getX();
		double bY = b.getY();
		
//		checkBallCollision(b);
//		checkCollision(b);
		
		switch(b.getDirection()) {
		case UPLEFT:
			bX -= 1.0;
			bY -= 1.0;
			break;
		case UPRIGHT:
			bX += 1.0;
			bY -= 1.0;
			break;
		case DOWNLEFT:
			bX -= 1.0;
			bY += 1.0;
			break;
		case DOWNRIGHT:
			bX += 1.0;
			bY += 1.0;
			break;
		}
		
		b.moveTo(bX, bY);
	}
	
	private void checkBallCollision(Ball b){
		for (Ball x : theCircles){
			if (!b.equals(x)){
				double x0 = Math.abs(b.getX() - x.getX());
				double y0 = Math.abs(b.getY() - x.getY());
				
				double r0 = Math.round((b.getRadius()+x.getRadius())/2)+1;
				
				if ((x0*x0) + (y0*y0) <= r0*r0){
//					System.out.println("Столкнулись!!!");
//					System.out.println("шар В " + b.getX() + " : " + b.getY());
//					System.out.println("шар X " + x.getX() + " : " + x.getY());
//					System.out.println("Radius " + r0);
//					System.out.println("X0 :" + x0 + ", Y0 : " + y0);
//					System.out.println(b.getDirection());
//					System.out.println(x.getDirection());
					
				if (x0 < y0){
					if (b.getDirection()!=x.getDirection()){
							b.setDirection(-b.getDirectionX(), b.getDirectionY());
//							x.setDirection(-x.getDirectionX(), x.getDirectionY());
							}
					else {
						b.setDirection(b.getDirectionX(), -b.getDirectionY());
//						x.setDirection(-x.getDirectionX(), x.getDirectionY());
					}
				}
				if (x0 > y0){
					if (b.getDirection()!=x.getDirection()){
					b.setDirection(b.getDirectionX(), -b.getDirectionY());
//					x.setDirection(x.getDirectionX(), -x.getDirectionY());
					}
					else{
						b.setDirection(-b.getDirectionX(), b.getDirectionY());
//						x.setDirection(x.getDirectionX(), -x.getDirectionY());
					}
				}
				if (x0 == y0){
					b.setDirection(-b.getDirectionX(), -b.getDirectionY());
//					x.setDirection(-x.getDirectionX(), -x.getDirectionY());
				}
//						System.out.println(b.getDirection());
//						System.out.println(x.getDirection());
				}
			}
		}
	}
	
	private void checkCollision(Ball b) {
		if(b.isBoarder(parent.getSize().getWidth(), parent.getSize().getHeight())) {
			
			double valueBorderX = parent.getSize().getWidth();
			double valueBorderY = parent.getSize().getHeight();
			
			switch(b.getDirection()) {
			
			case UPLEFT:
				if (b.getX()==0 && b.getY()!=0){
					b.setDirection(Ball.Direction.UPRIGHT);
				}
				else if (b.getY()==0 && b.getX()!=0){
					b.setDirection(Ball.Direction.DOWNLEFT);
				}
				else if (b.getX()==0 && b.getY()==0){
					b.setDirection(Ball.Direction.DOWNRIGHT);
				}
				break;
				
			case UPRIGHT:
				if (b.getY()==0 && b.getX()+b.getRadius()!=valueBorderX){
					b.setDirection(Ball.Direction.DOWNRIGHT);
				}
				else if (b.getX()+b.getRadius()==valueBorderX && b.getY()!=0){
					b.setDirection(Ball.Direction.UPLEFT);
				}
				else if (b.getY()==0 && b.getX()+b.getRadius()==valueBorderX){
					b.setDirection(Ball.Direction.DOWNLEFT);
				}
				break;
				
			case DOWNLEFT:
				if (b.getX()==0){
					b.setDirection(Ball.Direction.DOWNRIGHT);
				}
				else if (b.getY()+b.getRadius()==valueBorderY){
					b.setDirection(Ball.Direction.UPLEFT);
				}
				else if (b.getX()==0 && b.getY()+b.getRadius() == valueBorderY){
					b.setDirection(Ball.Direction.UPRIGHT);
				}
				break;

			case DOWNRIGHT:
				if (b.getX() + b.getRadius() == valueBorderX){
					b.setDirection(Ball.Direction.DOWNLEFT);
				}
				else if (b.getY() + b.getRadius() == valueBorderY){
					b.setDirection(Ball.Direction.UPRIGHT);
				}
				if (b.getX() + b.getRadius() == valueBorderX && b.getY() + b.getRadius() == valueBorderY){
					b.setDirection(Ball.Direction.UPLEFT);
				}
				break;

			}
		}
	}
	
	public boolean isBallCollistion(int xx, int yy, int radius) {
		for (Ball x : theCircles){
			
				double x0 = Math.abs(xx - x.getX());
				double y0 = Math.abs(yy - x.getY());
				
				double r0 = Math.round((radius+x.getRadius())/2)+1;
				
				if ((x0*x0) + (y0*y0) <= r0*r0){
					x.setDirection(-x.getDirectionX(), -x.getDirectionY());
					return true;
				}
		}
		return false;
	}
	
	public Set<Ball> getBall() {
		return theCircles;
	}

	public void addBall(Ball ball) {
		theCircles.add(ball);
		
	}
	public Set<Rectangle> getRectangle() {
		return theRectangular;
	}

	public void addRectangle(Rectangle rectangle) {
		theRectangular.add(rectangle);
		
	}
}
