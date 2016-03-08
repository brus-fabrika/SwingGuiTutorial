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
import java.util.Random;

public class Field extends JPanel {
	
	private Game game = new Game(this);
	
	public Field() {
		super();
		setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
		
		addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e){
			
			System.out.println(e.getX()+" "+ e.getY());	
			System.out.println(e.getPoint());
			Random rand = new Random();
			rand.nextInt(4);
			for (Ball f:game.theCircles){
				
			}
				
				
			game.addBall(new Ball((e.getX()-(50/2)), (e.getY()-(50/2)), 50));
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
		
		
		game.addBall(new Ball(100, 100, 20));
		game.addBall(new Ball(200, 200, 20));
		
		Ball ball = new Ball(200, 250, 50);
		Rectangle square = new Rectangle(150,150, 40,80);
		
		game.addRectangle(new Rectangle(100,100,30,60));
		
		game.addBall(ball);
		game.addRectangle(square);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		for(Shape ball: game.getBall()) {
			g2d.draw(ball);
		}
		for(Shape rectangle: game.getRectangle()) {
			g2d.draw(rectangle);
		}
	}

	public void startMoving() throws InterruptedException {
		
		Timer timer = new Timer();

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				game.step();
				game.steprect();
			}
		}, 1000, 5);
		
	}
}
