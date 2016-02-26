import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;


public class Game {

	private JPanel parent;
	
	Set<Ball> theCircles = new HashSet<>();
	
	public Game(JPanel panel) {
		this.parent = panel;
	}
	
	public void step() {
		for(Ball b: theCircles) {
			nextMove(b);
		}
		
		parent.repaint();
	}

	private void nextMove(Ball b) {
		double bX = b.getX();
		double bY = b.getY();
		
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
	
	private void checkCollision(Ball b) {
		if(b.isBoarderY(parent.getSize().getWidth(), parent.getSize().getHeight())) {
			switch(b.getDirection()) {
			case UPLEFT:
				b.setDirection(Ball.Direction.DOWNLEFT);
				break;
			case UPRIGHT:
				b.setDirection(Ball.Direction.DOWNRIGHT);
				break;
			case DOWNLEFT:
				b.setDirection(Ball.Direction.UPLEFT);
				break;
			case DOWNRIGHT:
				b.setDirection(Ball.Direction.UPRIGHT);
				break;
			}
		}
		else if(b.isBoarderX(parent.getSize().getWidth(), parent.getSize().getHeight())) {
			switch(b.getDirection()) {
			case UPLEFT:
				b.setDirection(Ball.Direction.UPRIGHT);
				break;
			case UPRIGHT:
				b.setDirection(Ball.Direction.UPLEFT);
				break;
			case DOWNLEFT:
				b.setDirection(Ball.Direction.DOWNRIGHT);
				break;
			case DOWNRIGHT:
				b.setDirection(Ball.Direction.DOWNLEFT);
				break;
			}
		}
		else if(isTouchx(b)) {
			switch(b.getDirection()) {
			case UPLEFT:
				b.setDirection(Ball.Direction.UPRIGHT);
				break;
			case UPRIGHT:
				b.setDirection(Ball.Direction.UPLEFT);
				break;
			case DOWNLEFT:
				b.setDirection(Ball.Direction.DOWNRIGHT);
				break;
			case DOWNRIGHT:
				b.setDirection(Ball.Direction.DOWNLEFT);
				break;
			}
		}
		else if(isTouchy(b)) {
			switch(b.getDirection()) {
			case UPLEFT:
				b.setDirection(Ball.Direction.DOWNLEFT);
				break;
			case UPRIGHT:
				b.setDirection(Ball.Direction.DOWNRIGHT);
				break;
			case DOWNLEFT:
				b.setDirection(Ball.Direction.UPLEFT);
				break;
			case DOWNRIGHT:
				b.setDirection(Ball.Direction.UPRIGHT);
				break;
			}
		}
	}
	
	public Set<Ball> getBall() {
		return theCircles;
	}

	public void addBall(Ball ball) {
		theCircles.add(ball);
		
	}
	
	public boolean isTouchx(Ball b){
		boolean touch = false;
		for(Ball c: theCircles) {
			double r = (b.getRadius()+c.getRadius())/2;
			if (c != b){
				if ((Math.abs(b.getCenterX() - c.getCenterX()) <= r) & (Math.abs(b.getCenterY()- c.getCenterY())) <= r){
					if (Math.abs(b.getCenterX() - c.getCenterX()) >= Math.abs(b.getCenterY()- c.getCenterY())){
						touch = true;
					}
					
				}
			}
		}
		return touch;
	}
	
	public boolean isTouchy(Ball b){
		boolean touch = false;
		for(Ball c: theCircles) {
			double r = (b.getRadius()+c.getRadius())/2;
			if (c != b){
				if ((Math.abs(b.getCenterX() - c.getCenterX()) <= r) & (Math.abs(b.getCenterY()- c.getCenterY())) <= r){
					if (Math.abs(b.getCenterX() - c.getCenterX()) <= Math.abs(b.getCenterY()- c.getCenterY())){
						touch = true;
					}
					
				}
			}
		}
		return touch;
	}
	
}
