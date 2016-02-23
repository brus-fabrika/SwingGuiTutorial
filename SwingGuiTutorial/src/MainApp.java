import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainApp {
	
	static class GuiRunner implements Runnable {
		@Override
		public void run() {
			try {
				createGui();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new GuiRunner());
	}
	
	public static void createGui() throws InterruptedException {
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setTitle("My first Swing application");
		frame.setSize(500, 500);
		frame.setLocation(100, 100);
		
		Field f = new Field();
		
		frame.add(f);
		
		frame.setVisible(true);
		
		f.startMoving();
	}
}