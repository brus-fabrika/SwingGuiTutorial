import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;


public class Game {

	private JPanel parent;
	
	Set<Ball> theCircles = new HashSet<>();
	Set<Square> theSquares = new HashSet<>();
	public Game(JPanel panel) {
		this.parent = panel;
	}
	
	public void step() {
		for(Ball b: theCircles) {
			nextMove(b);
		
		}
		parent.repaint();
		
	}
	
	public void SqSstep(){
	
	for(Square s: theSquares){
		nextSqMove(s);
	}
	parent.repaint();
		}
	
	
	private void nextSqMove(Square s){
		double sX = s.getX();
		double sY = s.getY();
	
		//checkCollision(s);
		
		switch(s.getDirection()) {
		case UPLEFT:
			sX -= 1.0;
			sY -= 1.0;
			break;
		case UPRIGHT:
			sX += 1.0;
			sY -= 1.0;
			break;
		case DOWNLEFT:
			sX -= 1.0;
			sY += 1.0;
			break;
		case UP:
			sX += 0.0;
			sY += 1.0;
			break;
		case DOWN:
			sX += 0.0;
			sY -= 1.0;
			break;
		case RIGHT:
			sX += 1.0;
			sY += 0.0;
			break;
		case LEFT:
			sX -= 1.0;
			sY += 0.0;
			break;
		case DOWNRIGHT:
			sX += 1.0;
			sY += 1.0;
			break;
			
				
		}
		s.moveTo(sX, sY);
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
				//if(b.getX() ==0){
				//b.setDirection(Ball.Direction.UPRIGHT);}
				break;
			case UPRIGHT:
					b.setDirection(Ball.Direction.DOWNRIGHT);
					//if(b.getX() ==parent.WIDTH){
					//b.setDirection(Ball.Direction.UPLEFT);}
					break;
			case DOWNLEFT:
					b.setDirection(Ball.Direction.UPLEFT);
					 //if(b.getX() ==0){
					//b.setDirection(Ball.Direction.DOWNRIGHT);}
					break;
			case DOWNRIGHT:
					b.setDirection(Ball.Direction.UPRIGHT);
					// if(b.getX() ==parent.WIDTH){
					//b.setDirection(Ball.Direction.DOWNLEFT);}
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
					break;	}
			}
		
		else if(xBCol(b)){
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
			
			  
		}
	
	
		
	public boolean xBCol(Ball b){
		boolean Ballx = false;
		for(Ball c: theCircles ){
			double r = (b.getRadius() + c.getRadius())/2;
			if(c!=b){
				if((Math.abs(b.getCenterX() - c.getCenterX()) <= r) & (Math.abs(b.getCenterY() - c.getCenterY()) <= r)){
					if(Math.abs(b.getCenterX() - c.getCenterX()) >= (Math.abs(b.getCenterY() - c.getCenterY()))){
						Ballx = true;
						
						
					}
					
					
				}
				
				
			}
		}
		
		return Ballx;
		
		
	}
	
	public Set<Ball> getBall() {
		return theCircles;
	}
	public Set<Square> getSquare() {
		return theSquares;
	}


	public void addBall(Ball ball) {
		theCircles.add(ball);
		
	}

	public void addSquare(Square square) {
      theSquares.add(square);
	}
	
}
