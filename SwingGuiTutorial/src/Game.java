import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;


public class Game {

	private JPanel parent;
	
	Set<Ball> theCircles = new HashSet<>();
	Set<Rectangle>theSquares  = new HashSet<>();
	public Game(JPanel panel) {
		this.parent = panel;
	}
	
	public void step() {
		for(Ball b: theCircles) {
			nextMove(b);
		}
		
		parent.repaint();
	}
	public void steprect() {
		for(Rectangle r: theSquares ) {
			nextMove(r);
		}
		
		parent.repaint();
	}	
	private void nextMove(Rectangle r) {
		double bX = r.getX();
		double bY = r.getY();
		
		checkCollision(r);
		
		
	switch(r.getDirection()) {
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
		
		r.moveTo(bX, bY);
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
	private void checkCollision(Rectangle r) {
		if(r.isBoarder(parent.getSize().getWidth(), parent.getSize().getHeight())) {
			switch(r.getDirection()) {
			case UPLEFT:
				if (r.getX() == 0){
					r.setDirection(Rectangle.Direction.UPRIGHT);
				}else 
					r.setDirection(Rectangle.Direction.DOWNLEFT);
								break;
			case UPRIGHT:
				if (r.getX() + r.getWidth()  == parent.getSize().getWidth()&&r.getY()+r.getHeight()==parent.getSize().getHeight()
				&&r.getX()==0&& r.getY()==0){
					r.setDirection(Rectangle.Direction.DOWNRIGHT);
				}else
					r.setDirection(Rectangle.Direction.DOWNLEFT);
				break;
			case DOWNLEFT:
				if (r.getX() == 0){
					r.setDirection(Rectangle.Direction.DOWNRIGHT);
				}else
					r.setDirection(Rectangle.Direction.UPLEFT);
				break;
			case DOWNRIGHT:
				if (r.getY() + r.getHeight() == parent.getSize().getHeight()){
					r.setDirection(Rectangle.Direction.UPRIGHT);
				}else
					r.setDirection(Rectangle.Direction.DOWNLEFT);
				break;
			}
			
		}
			else if(Touch(r)){
				switch(r.getDirection()) {
				case UPLEFT:
					r.setDirection(Rectangle.Direction.DOWNRIGHT);
					break;
				case UPRIGHT:
					r.setDirection(Rectangle.Direction.DOWNLEFT);
					break;
				case DOWNLEFT:
					r.setDirection(Rectangle.Direction.UPRIGHT);
					break;
				case DOWNRIGHT:
					r.setDirection(Rectangle.Direction.UPLEFT);
					break;
							}
				
				
			}
		}
	
	private void checkCollision(Ball b) {
		if(b.isBoarder(parent.getSize().getWidth(), parent.getSize().getHeight())) {
			switch(b.getDirection()) {
			case UPLEFT:
				if (b.getX() == 0){
					b.setDirection(Ball.Direction.UPRIGHT);
				}else 
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

	
		else if(Touch(b)){
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
						}
			
					
			}
			}
		
	public boolean Touch(Ball b){
		boolean touch = false;
		for(Ball c: theCircles) {
			double distance=Math.sqrt(((b.getX() - c.getX()) * (b.getX() - c.getX()))
		            + ((b.getY() - c.getY()) * (b.getY() - c.getY())));
			double rb = b.getRadius()/2;
			double rc = c.getRadius()/2;
			if (c != b){
				if (distance < rb + rc)
						touch = true;
					}
					
				}
			return touch;
	}
	public boolean Touch(Rectangle r){
		boolean touch = false;
		for(Rectangle x: theSquares) {
			if (r != x){
					if (
							r.getX()<(x.getX()+x.getWidth())&
							x.getX()<(r.getX()+r.getWidth())&
							r.getY()<(x.getY()+x.getHeight())&
							x.getY()<(r.getY()+r.getHeight())
							
						){
						if (Math.abs(r.getCenterX() - x.getCenterX()) <= (Math.abs(r.getCenterY()- x.getCenterY()))){
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
	public void addRectangle(Rectangle Squere) {
		 		theSquares.add(Squere);
				
			}
			public Set<Rectangle> getRectangle() {
				return theSquares;
			}
			
		
				    }

