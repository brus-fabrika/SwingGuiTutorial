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
		setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		
		game.addBall(new Ball(100, 100, 20));
		game.addBall(new Ball(200, 200, 20));
		game.addBall(new Ball(200, 250, 50));
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		for(Shape s: game.getBall()) {
			g2d.draw(s);
		}
		
		
	}

	public void startMoving() throws InterruptedException {
		
		Timer timer = new Timer();

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				game.start();
			}
		}, 2000, 50);
		
	}
}
