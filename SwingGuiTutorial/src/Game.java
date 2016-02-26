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
		if(b.isBoarder(parent.getSize().getWidth(), parent.getSize().getHeight())) {
			switch(b.getDirection()) {
			case UPLEFT:
				if (b.getX()==0 && b.getY()==0){
					b.setDirection(Ball.Direction.DOWNRIGHT);
					break;
				}
				else if (b.getX()==0 && b.getY()!=0){
					b.setDirection(Ball.Direction.UPRIGHT);
					break;
				}
				else if (b.getY()==0 && b.getX()!=0){
					b.setDirection(Ball.Direction.DOWNLEFT);
					break;
				}
			case UPRIGHT:
				if (b.getY()==0 && b.getX()+b.getRadius()==parent.getSize().getWidth()){
					b.setDirection(Ball.Direction.DOWNLEFT);
					break;
				}
				else if (b.getY()==0){
					b.setDirection(Ball.Direction.DOWNRIGHT);
					break;
				}
				else {
					b.setDirection(Ball.Direction.UPLEFT);
					break;
				}
			case DOWNLEFT:
				if (b.getX()==0){
					b.setDirection(Ball.Direction.DOWNRIGHT);
					break;}
				else {
					b.setDirection(Ball.Direction.UPLEFT);
					break;
				}
			case DOWNRIGHT:
				if (b.getX() + b.getRadius() == parent.getSize().getWidth()){
					b.setDirection(Ball.Direction.DOWNLEFT);
					break;
				}
				else if (b.getY() + b.getRadius() == parent.getSize().getHeight()){
					b.setDirection(Ball.Direction.UPRIGHT);
					break;
				}
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
