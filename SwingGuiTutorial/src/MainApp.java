import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class MainApp {
	
	static class GuiRunner implements Runnable {
		@Override
		public void run() {
			createGui();
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new GuiRunner());
	}
	
	public static void createGui() {
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.setTitle("My first Swing application");
		frame.setSize(300, 300);
		frame.setLocation(500, 500);
		
		frame.add(new JLabel("test"), BorderLayout.WEST);
		frame.add(new JButton("OK"), BorderLayout.NORTH);
		
		frame.setVisible(true);
	}
}
