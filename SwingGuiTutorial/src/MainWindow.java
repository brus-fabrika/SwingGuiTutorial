import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class MainWindow extends JFrame{
	private static final long serialVersionUID = 1L;

	MainWindow() {
		super();
		
		setTitle("My first Swing application");
		setSize(300, 300);
		setLocation(500, 500);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		GridLayout layout = new GridLayout(3, 2);
		layout.setHgap(10);
		layout.setVgap(10);
		
		panel.setLayout(layout);
		panel.add(new JLabel("Celsium:"));
		panel.add(new JTextField("0.0"));
		panel.add(new JLabel("Fahrenheit:"));
		panel.add(new JTextField("0.0"));
		panel.add(new JButton("OK"));
		panel.add(new JButton("Cancel"));
		
		add(panel);
		
		pack();
	}
}
