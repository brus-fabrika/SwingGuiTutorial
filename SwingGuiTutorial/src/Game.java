import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;


public class Game {

	private JPanel parent;
	
	Set<Ball> theCircles = new HashSet<>();
	
	//add square is hashset
	Set<Squere> theSquere = new HashSet<>();
	
	public Game(JPanel panel) {
		this.parent = panel;
	}
	
	public void step() {
		for(Ball b: theCircles) {
			nextMove(b);
		}
		
		parent.repaint();
	}
	//move square
	public void stepSq() {
		for(Squere s: theSquere) {
			nextMoveS(s);
		}
		
		parent.repaint();
	}
	//End move square
	
	//Full move square
	private void nextMoveS(Squere s) {
		double bX = s.getX();
		double bY = s.getY();
		
		//checkCollision(b);
		//checkCollisionBall(b);
		
		switch(s.getDirection()) {
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
		
		s.moveTo(bX, bY);
	}
	//End Full move square

	private void nextMove(Ball b) {
		double bX = b.getX();
		double bY = b.getY();
		
		checkCollision(b);
		checkCollisionBall(b);
		
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
	
	private void checkCollisionBall(Ball b) {
		//isBall(b);
		if (isBall(b)){
			//b.rndDir();
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
	}/*
	private boolean isBall(Ball b) {
		for(Ball z: theCircles) {
			if (Math.pow( ((b.getX() + b.getRadius()/2) - (z.getX() + z.getRadius()/2)), 2) + Math.pow( ( (b.getY() + b.getRadius()/2) - (z.getY() + z.getRadius()/2) ), 2) <= Math.pow( (b.getRadius()/2 + z.getRadius()/2), 2)){
				   return true;
			}  }return false;
	}*/
	private void checkCollision(Ball b) {
		if(b.isBoarder(parent.getSize().getWidth(), parent.getSize().getHeight())) {
			switch(b.getDirection()) {
			case UPLEFT:
				if (b.getX() == 0){
					b.setDirection(Ball.Direction.UPRIGHT);
				}else if (b.getX() == 0 && b.getY() == 0) {
					b.setDirection(Ball.Direction.DOWNRIGHT);
				}
				b.setDirection(Ball.Direction.DOWNLEFT);
				break;
			case UPRIGHT:
				if (b.getY() == 0){
					b.setDirection(Ball.Direction.DOWNRIGHT);
				}else
				b.setDirection(Ball.Direction.UPLEFT);
				break;
			case DOWNLEFT:
				if (b.getX() == 0){
					b.setDirection(Ball.Direction.DOWNRIGHT);
				}else
				b.setDirection(Ball.Direction.UPLEFT);
				break;
			case DOWNRIGHT:
				if (b.getY() + b.getRadius() == parent.getSize().getHeight()){
					b.setDirection(Ball.Direction.UPRIGHT);
				}else
				b.setDirection(Ball.Direction.DOWNLEFT);
				break;
			}
		}

	}
public boolean isBall(Ball b){
	boolean touch = false;
	for(Ball c: theCircles) {
 		double d = (b.getRadius()+c.getRadius())/2;
 		
 		if (c != b){
 			
 			if ((Math.abs(b.getCenterX() - c.getCenterX()) <= d) & (Math.abs(b.getCenterY()- c.getCenterY())) <= d){
 		 		
				if (Math.abs(b.getCenterX() - c.getCenterX()) >= Math.abs(b.getCenterY()- c.getCenterY()) || Math.abs(b.getCenterX() - c.getCenterX()) <= Math.abs(b.getCenterY()- c.getCenterY())){
 					
					touch = true;
					
				}
					
			}
		}
	}
	return touch;
}
	
	public Set<Ball> getBall() {
		return theCircles;
	}

	public void addBall(Ball ball) {
		theCircles.add(ball);
		
	}
	public void addSquere(Squere Squere) {
		theSquere.add(Squere);
		
	}
	public Set<Squere> getSquere() {
		return theSquere;
	}
}
