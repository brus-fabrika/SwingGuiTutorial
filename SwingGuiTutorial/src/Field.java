import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class Field extends JPanel {
	
	private Game game = new Game(this);
	
	public Field() {
		super();
		setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
		
		game.addBall(new Ball(100, 100, 20));
		game.addBall(new Ball(150, 150, 35));
		game.addBall(new Ball(50, 50, 100));
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		for(Shape ball: game.getBall()) {
			g2d.draw(ball);
		}
		
		
	}

	public void startMoving() throws InterruptedException {
		
		Timer timer = new Timer();

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				game.step();
			}
		}, 1000, 2);
		
	}
}
