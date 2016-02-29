import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Field extends JPanel {
	
	private Game game = new Game(this);
	
	public Field() {
		super();
		
			
		
		
		setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
		
		game.addBall(new Ball(100, 100, 20));
		game.addBall(new Ball(200, 200, 20));
		
		Ball ball = new Ball(200, 250, 50);
		
		game.addBall(ball);
		
		//add square
		game.addSquere(new Squere(100, 150, 100, 100));
		//End add square
		
		//MouseClick
		addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("X = " + e.getX());
				System.out.println("Y = " + e.getY());
				game.addBall(new Ball(e.getX() - 20, e.getY() - 20, 40));
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	//End MouseClick
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		for(Shape ball: game.getBall()) {
			g2d.draw(ball);
		}
		
		
	}
	//make square
	public void paint(Graphics g) {
			super.paint(g);
			
		    Graphics2D g2d = (Graphics2D) g;
		    
		    for(Shape r2d: game.getSquere()) {
		    //Rectangle2D r2d = new Rectangle2D.Float(10f, 10f, 130f, 130f);
		    g2d.draw(r2d);
		    }
		  }
	//End make square

	public void startMoving() throws InterruptedException {
		
		Timer timer = new Timer();

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				game.step();
				game.stepSq();
			}
		}, 1000, 10);
		
	}
}
