import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;


public class Game {

	private JPanel parent;
	
	Set<Ball> theCircles = new HashSet<>();
	Set<Rectangle> theRec = new HashSet<>();
	
	public Game(JPanel panel) {
		this.parent = panel;
	}
	
	public void step() {
		for(Ball b: theCircles) {
			nextMove(b);
		}
		for(Rectangle e: theRec){
			nextMoveRec(e);
		}
		parent.repaint();
	}

	private void nextMove(Ball b) {
		double bX = b.getX();
		double bY = b.getY();
		
		checkCollision(b);
		isTouch(b);
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
		System.out.println("b x " + b.getCenterPosX()+ " y " + b.getCenterPosY()+ " "+ b.getRadius()/2 + " dir " + b.getDirection());
		
		b.moveTo(bX, bY);
	}
	
	private void nextMoveRec(Rectangle e) {
		double eX = e.getX();
		double eY = e.getY();
		
		checkCollisionRec(e);
		
		switch(e.getDirection()) {
		case UPLEFT:
			eX -= 1.0;
			eY -= 1.0;
			break;
		case UPRIGHT:
			eX += 1.0;
			eY -= 1.0;
			break;
		case DOWNLEFT:
			eX -= 1.0;
			eY += 1.0;
			break;
		case DOWNRIGHT:
			eX += 1.0;
			eY += 1.0;
			break;
		}
		
		e.moveRecTo(eX, eY);
	}
	
	private void checkCollision(Ball b) {
		if(b.isBoarderX(parent.getSize().getWidth(), parent.getSize().getHeight())) {
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
		else if(b.isBoarderY(parent.getSize().getWidth(), parent.getSize().getHeight())) {
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
	
	private void checkCollisionRec(Rectangle e) {
		if(e.isBoarderY(parent.getSize().getWidth(), parent.getSize().getHeight())||isTouchRecY(e)) {
			switch(e.getDirection()) {
			case UPLEFT:
				e.setDirection(Rectangle.Direction.DOWNLEFT);
				break;
			case UPRIGHT:
				e.setDirection(Rectangle.Direction.DOWNRIGHT);
				break;
			case DOWNLEFT:
				e.setDirection(Rectangle.Direction.UPLEFT);
				break;
			case DOWNRIGHT:
				e.setDirection(Rectangle.Direction.UPRIGHT);
				break;
			}
		}
		else if(e.isBoarderX(parent.getSize().getWidth(), parent.getSize().getHeight())||isTouchRecX(e)) {
			switch(e.getDirection()) {
			case UPLEFT:
				e.setDirection(Rectangle.Direction.UPRIGHT);
				break;
			case UPRIGHT:
				e.setDirection(Rectangle.Direction.UPLEFT);
				break;
			case DOWNLEFT:
				e.setDirection(Rectangle.Direction.DOWNRIGHT);
				break;
			case DOWNRIGHT:
				e.setDirection(Rectangle.Direction.DOWNLEFT);
				break;
			}
		}
	}
	
	public Set<Ball> getBall() {
		return theCircles;
	}
	
	public Set<Rectangle> getRectangle(){
		return theRec;
	}
	
	public void addBall(Ball ball) {
		theCircles.add(ball);
	}
	
	public void addRec(Rectangle rec){
		theRec.add(rec);
	}
	
	
	public void isTouch(Ball b){
		for(Ball c: theCircles) {
			double r = (b.getRadius()+c.getRadius())/2;
			if (c != b){
				if (Math.sqrt(Math.pow(Math.abs(b.getCenterPosX() - c.getCenterPosX()), 2) + (Math.pow(Math.abs(b.getCenterPosY()- c.getCenterPosY()), 2))) <= r
					){
					if (Math.abs(b.getCenterPosX() - c.getCenterPosX()) == Math.abs(b.getCenterPosY()- c.getCenterPosY())){
						switch(c.getDirection()) {
						case UPLEFT:
							c.setDirection(Ball.Direction.DOWNRIGHT);
							break;
						case UPRIGHT:
							c.setDirection(Ball.Direction.DOWNLEFT);
							break;
						case DOWNLEFT:
							c.setDirection(Ball.Direction.UPRIGHT);
							break;
						case DOWNRIGHT:
							c.setDirection(Ball.Direction.UPLEFT);
							break;
						}
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
					else if (Math.abs(b.getCenterPosX() - c.getCenterPosX()) > Math.abs(b.getCenterPosY()- c.getCenterPosY()) 
							& c.getCenterPosX()>b.getCenterPosX()){
																		
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
						
						switch(c.getDirection()) {
						case UPLEFT:
							c.setDirection(Ball.Direction.UPRIGHT);
							break;
						case UPRIGHT:
							c.setDirection(Ball.Direction.UPLEFT);
							break;
						case DOWNLEFT:
							c.setDirection(Ball.Direction.DOWNRIGHT);
							break;
						case DOWNRIGHT:
							c.setDirection(Ball.Direction.DOWNLEFT);
							break;
						}
												
					}
					else if (Math.abs(b.getCenterPosX() - c.getCenterPosX()) > Math.abs(b.getCenterPosY()- c.getCenterPosY()) 
							& c.getCenterPosX()<b.getCenterPosX()){
												
						switch(b.getDirection()) {
						case UPLEFT:
							b.setDirection(Ball.Direction.UPRIGHT);
							break;
						case UPRIGHT:
							b.setDirection(Ball.Direction.DOWNRIGHT);
							break;
						case DOWNLEFT:
							b.setDirection(Ball.Direction.DOWNRIGHT);
							break;
						case DOWNRIGHT:
							b.setDirection(Ball.Direction.UPRIGHT);
							break;
						}

						switch(c.getDirection()) {
						case UPLEFT:
							c.setDirection(Ball.Direction.DOWNLEFT);
							break;
						case UPRIGHT:
							c.setDirection(Ball.Direction.UPLEFT);
							break;
						case DOWNLEFT:
							c.setDirection(Ball.Direction.UPLEFT);
							break;
						case DOWNRIGHT:
							c.setDirection(Ball.Direction.DOWNLEFT);
							break;
						}
						
					}
					
					else if (Math.abs(b.getCenterPosX() - c.getCenterPosX()) < Math.abs(b.getCenterPosY()- c.getCenterPosY())
							& c.getCenterPosY()>b.getCenterPosY()){
												
						switch(b.getDirection()) {
						case UPLEFT:
							b.setDirection(Ball.Direction.DOWNLEFT);
							break;
						case UPRIGHT:
							b.setDirection(Ball.Direction.UPLEFT);
							break;
						case DOWNLEFT:
							b.setDirection(Ball.Direction.UPLEFT);
							break;
						case DOWNRIGHT:
							b.setDirection(Ball.Direction.DOWNLEFT);
							break;
						}
						switch(c.getDirection()) {
						case UPLEFT:
							c.setDirection(Ball.Direction.UPRIGHT);
							break;
						case UPRIGHT:
							c.setDirection(Ball.Direction.DOWNRIGHT);
							break;
						case DOWNLEFT:
							c.setDirection(Ball.Direction.DOWNRIGHT);
							break;
						case DOWNRIGHT:
							c.setDirection(Ball.Direction.UPRIGHT);
							break;
						}
						
					}
					else if (Math.abs(b.getCenterPosX() - c.getCenterPosX()) < Math.abs(b.getCenterPosY()- c.getCenterPosY())
							& c.getCenterPosY()<b.getCenterPosY()){
												
						switch(b.getDirection()) {
						case UPLEFT:
							b.setDirection(Ball.Direction.DOWNLEFT);
							break;
						case UPRIGHT:
							b.setDirection(Ball.Direction.DOWNRIGHT);
							break;
						case DOWNLEFT:
							b.setDirection(Ball.Direction.DOWNRIGHT);
							break;
						case DOWNRIGHT:
							b.setDirection(Ball.Direction.DOWNLEFT);
							break;
						}
						switch(c.getDirection()) {
						case UPLEFT:
							c.setDirection(Ball.Direction.UPRIGHT);
							break;
						case UPRIGHT:
							c.setDirection(Ball.Direction.UPLEFT);
							break;
						case DOWNLEFT:
							c.setDirection(Ball.Direction.UPLEFT);
							break;
						case DOWNRIGHT:
							c.setDirection(Ball.Direction.UPRIGHT);
							break;
						}
						
					}
					else{
						switch(c.getDirection()) {
						case UPLEFT:
							c.setDirection(Ball.Direction.DOWNRIGHT);
							break;
						case UPRIGHT:
							c.setDirection(Ball.Direction.DOWNLEFT);
							break;
						case DOWNLEFT:
							c.setDirection(Ball.Direction.UPRIGHT);
							break;
						case DOWNRIGHT:
							c.setDirection(Ball.Direction.UPLEFT);
							break;
						}
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
			}
		}
		
		}

	
	
	public boolean isTouchRecX(Rectangle e){
		boolean touch = false;
		for(Rectangle c: theRec) {
			if (c != e){
				if (e.getX()<(c.getX()+c.getWidth())&
					c.getX()<(e.getX()+e.getWidth())&
					e.getY()<(c.getY()+c.getHeight())&
					c.getY()<(e.getY()+e.getHeight())
					
					/*	
					((e.getX() > c.getX() & e.getX()< (c.getX()+c.getWidth())||
					((e.getX()+e.getWidth())> c.getX() & (e.getX()+c.getWidth())<(c.getX()+c.getWidth())))&
					(((e.getY() > c.getY())& (e.getY()< (c.getY()+c.getHeight()))) ||
					((e.getY()+e.getHeight())> c.getY() & (e.getY()+e.getHeight())<(c.getY()+c.getHeight()))))||
					((c.getX() > e.getX() & c.getX()< (e.getX()+e.getWidth())||
					((c.getX()+c.getWidth())> e.getX() & (c.getX()+c.getWidth())<(e.getX()+e.getWidth())))&
					(((c.getY() > e.getY())& (c.getY()< (e.getY()+e.getHeight()))) ||
					((c.getY()+c.getHeight())> e.getY() & (c.getY()+c.getHeight())<(e.getY()+e.getHeight()))))
					*/
					//((Math.abs(e.getX()- c.getX()) == w) & (Math.abs(e.getY()- c.getY())) == h) ||
					//((Math.abs(e.getX()+e.getWidth()- c.getX()+c.getWidth()) == w) & (Math.abs(e.getY()+e.getHeight()- c.getY()+c.getHeight())) == h)
					){
					if (Math.abs(e.getX() - c.getX()) == Math.abs(e.getY()- c.getY())){
						switch(c.getDirection()) {
						case UPLEFT:
							c.setDirection(Rectangle.Direction.DOWNRIGHT);
							break;
						case UPRIGHT:
							c.setDirection(Rectangle.Direction.DOWNLEFT);
							break;
						case DOWNLEFT:
							c.setDirection(Rectangle.Direction.UPRIGHT);
							break;
						case DOWNRIGHT:
							c.setDirection(Rectangle.Direction.UPLEFT);
							break;
						}
						switch(e.getDirection()) {
						case UPLEFT:
							e.setDirection(Rectangle.Direction.DOWNRIGHT);
							break;
						case UPRIGHT:
							e.setDirection(Rectangle.Direction.DOWNLEFT);
							break;
						case DOWNLEFT:
							e.setDirection(Rectangle.Direction.UPRIGHT);
							break;
						case DOWNRIGHT:
							e.setDirection(Rectangle.Direction.UPLEFT);
							break;
						}
					}
					else if (Math.abs(e.getCenterX() - c.getCenterX()) >= Math.abs(e.getCenterY()- c.getCenterY())){
						touch = true;
						switch(c.getDirection()) {
						case UPLEFT:
							c.setDirection(Rectangle.Direction.UPRIGHT);
							break;
						case UPRIGHT:
							c.setDirection(Rectangle.Direction.UPLEFT);
							break;
						case DOWNLEFT:
							c.setDirection(Rectangle.Direction.DOWNRIGHT);
							break;
						case DOWNRIGHT:
							c.setDirection(Rectangle.Direction.DOWNLEFT);
							break;
						}
					}
				}
			}
		}
		return touch;
	}
	
	public boolean isTouchRecY(Rectangle e){
		boolean touch = false;
		for(Rectangle c: theRec) {
			if (c != e){
				if (
						e.getX()<(c.getX()+c.getWidth())&
						c.getX()<(e.getX()+e.getWidth())&
						e.getY()<(c.getY()+c.getHeight())&
						c.getY()<(e.getY()+e.getHeight())
						
					/*	
					((Math.abs(e.getX()- c.getX()) <= w) & (Math.abs(e.getY()- c.getY())) <= h) ||
					((Math.abs(e.getX()+e.getWidth()- c.getX()+c.getWidth()) <= w) & (Math.abs(e.getY()+e.getHeight()- c.getY()+e.getHeight())) <= h)	
					*/
					){
					if (Math.abs(e.getCenterX() - c.getCenterX()) <= (Math.abs(e.getCenterY()- c.getCenterY()))){
						touch = true;
						switch(c.getDirection()) {
						case UPLEFT:
							c.setDirection(Rectangle.Direction.DOWNLEFT);
							break;
						case UPRIGHT:
							c.setDirection(Rectangle.Direction.DOWNRIGHT);
							break;
						case DOWNLEFT:
							c.setDirection(Rectangle.Direction.UPLEFT);
							break;
						case DOWNRIGHT:
							c.setDirection(Rectangle.Direction.UPRIGHT);
							break;
						}
					}
				}
			}
		}
		return touch;
	}
	
	public void DirectionX(Ball c){
		switch(c.getDirection()) {
		case UPLEFT:
			c.setDirection(Ball.Direction.UPRIGHT);
			break;
		case UPRIGHT:
			c.setDirection(Ball.Direction.UPLEFT);
			break;
		case DOWNLEFT:
			c.setDirection(Ball.Direction.DOWNRIGHT);
			break;
		case DOWNRIGHT:
			c.setDirection(Ball.Direction.DOWNLEFT);
			break;
		}
	}
}
