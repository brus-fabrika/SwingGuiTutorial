import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class Field extends JPanel {
	
	private Game game = new Game(this);
	
	public Field() {
		super();
		
	addMouseListener(new MouseListener(){
		public void mouseClicked(MouseEvent e){
		System.out.println("The coordinates are " + e.getX() + " " + e.getY());
		game.addBall(new Ball(e.getX() - 100/2, e.getY() - 100/2, 100));
		
		}

	

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		});
		
	   setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
	   
		
		game.addBall(new Ball(100, 100, 20));
		game.addBall(new Ball(200, 200, 20));
		
		Ball ball = new Ball(200, 250, 50);
		
		ball.setDirection(Ball.Direction.values()[(int)(Math.random()*4)]);
		
		game.addBall(ball);
		
		game.addSquare(new Square(100, 100, 100, 100));
		
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		for(Shape ball: game.getBall()) {
			g2d.draw(ball);
		}
		
		
	}
	
	public void paintSquare(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		for(Shape square: game.getSquare()) {
			g2d.draw(square);
		}
		
		
	}

	public void startMoving() throws InterruptedException {
		
		Timer timer = new Timer();

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				game.step();
			}
		}, 1000, 25);
		
	}
}
