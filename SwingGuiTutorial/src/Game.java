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
	double radius;
	public void setRadius(double r) {
        radius = r;
    }

    public double getRadius() {
        return radius;
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
		case RIGHT:
			bX += 1.0;
			bY += 0.0;
			break;
		case LEFT:
			bX -= 1.0;
			bY -= 0.0;
			break;	
		}
		
		b.moveTo(bX, bY);
	}
	
	private void checkCollision(Ball b) {
		if(b.isBoarder(parent.getSize().getWidth(), parent.getSize().getHeight())) {
			switch(b.getDirection()) {
			case UPLEFT:
				b.setDirection(Ball.Direction.DOWNRIGHT);
				break;
			case UPRIGHT:
				b.setDirection(Ball.Direction.DOWNLEFT);
				break;
			case DOWNLEFT:
				b.setDirection(Ball.Direction.UPRIGHT);
				break;
			case DOWNRIGHT:
				b.setDirection(Ball.Direction.UPLEFT);
				break;
			case LEFT:
				b.setDirection(Ball.Direction.RIGHT);
				break;

			case RIGHT:
				b.setDirection(Ball.Direction.LEFT);
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
	
}
