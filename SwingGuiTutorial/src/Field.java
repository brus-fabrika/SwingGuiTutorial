import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import Ball.Direction;


public class Field extends JPanel {
	
	private Game game = new Game(this);
	JButton button = new JButton("Hello");
	public Field() {
		super();
		//add(button);
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("hello!");
			}
		});
		addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Random rnd = new Random();
				int a = rnd.nextInt(4);
				int r = 10;
				boolean exist = true;
				for (Ball d : game.theCircles){
					if ((d.getCenterX()-2- d.getRadius()/2) <= arg0.getX() & (d.getCenterX()+2+ d.getRadius()/2)>= arg0.getX() & (d.getCenterY()-2-d.getRadius()/2)<=arg0.getY()& (d.getCenterY()+2+ d.getRadius()/2>=arg0.getY())){
						exist = false;
												
						switch(d.getDirection()) {
						case UPLEFT:
							d.setDirection(Ball.Direction.UPRIGHT);
							break;
						case UPRIGHT:
							d.setDirection(Ball.Direction.UPLEFT);
							break;
						case DOWNLEFT:
							d.setDirection(Ball.Direction.DOWNRIGHT);
							break;
						case DOWNRIGHT:
							d.setDirection(Ball.Direction.DOWNLEFT);
							break;
						}
						break;
					}
					}
										
					if (exist){
						Ball ball = new Ball (arg0.getX()-r, arg0.getY()-r, 2*r);
						
						switch(a) {
						case 0:
							ball.setDirection(Ball.Direction.UPRIGHT);
							break;
						case 1:
							ball.setDirection(Ball.Direction.UPLEFT);
							break;
						case 2:
							ball.setDirection(Ball.Direction.DOWNRIGHT);
							break;
						case 3:
							ball.setDirection(Ball.Direction.DOWNLEFT);
							break;
						}
							
						game.addBall(ball);
					}
							
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
		Rectangle rec = new Rectangle(100, 300, 20);
		game.addRec(new Rectangle(50,150,20));
		game.addRec(new Rectangle(250, 200, 40));
		game.addBall(ball);
		game.addRec(rec);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		for(Shape ball: game.getBall()) {
			g2d.draw(ball);
		}
		for(Shape rec: game.getRectangle()){
			g2d.draw(rec);
		}
		
	}

	public void startMoving() throws InterruptedException {
		
		Timer timer = new Timer();

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				game.step();
			}
		}, 1000, 100);
		
	}
}
