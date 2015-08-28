import javax.swing.JFrame;

public class MainApp {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.setTitle("My first Swing application");
		frame.setSize(300, 300);
		frame.setLocation(500, 500);
		
		frame.setVisible(true);
	}
}
