import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MainWindow extends JFrame{
	private static final long serialVersionUID = 1L;

	MainWindow() {
		super();
		
		setTitle("My first Swing application");
		setSize(300, 300);
		setLocation(500, 500);
		
		add(new JLabel("test"), BorderLayout.WEST);
		add(new JButton("OK"), BorderLayout.NORTH);
	}
}
