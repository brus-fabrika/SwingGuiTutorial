import javax.swing.JFrame;
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
		JFrame frame = new MainWindow();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
