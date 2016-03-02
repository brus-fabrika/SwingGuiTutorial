import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.Shape;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Field extends JPanel {
		
	private Game game = new Game(this);
//	
//	Field.addMouseListener(new CustomListener());
//	
	
	public Field() {
		super();
		setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
		
		addMouseListener(new CustomListener());
//		game.addBall(new Ball(100, 100, 20));
//		game.addBall(new Ball(150, 150, 30));
//		game.addBall(new Ball(50, 50, 50));
		
		game.addRectangle(new Rectangle(100, 100, 50, 70));
		
	}
	
	public int getBallRadius(){
		int r = 20+(int)(Math.random() *50);
		return r;
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		for(Shape ball: game.getBall()) {
			g2d.draw(ball);
		}
		for(Shape rectangle: game.getRectangle()){
			g2d.draw(rectangle);
		}
		
	}

	public void startMoving() throws InterruptedException {
		
		Timer timer = new Timer();

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				game.step();
			}
		}, 1000, 50);
		
	}
	public class CustomListener implements MouseListener {

        public void mouseClicked(MouseEvent e) {
        	int radius = getBallRadius();
        	game.addBall(new Ball(e.getX(), e.getY(), radius));
        	System.out.println("xx : " + e.getX() + ", yy :" + e.getY() + ", Radius :" + radius);
        }

        public void mouseEntered(MouseEvent e) {        }
        public void mouseExited(MouseEvent e) {        }
        public void mousePressed(MouseEvent e) {        }
        public void mouseReleased(MouseEvent e) {        }
    }
}
