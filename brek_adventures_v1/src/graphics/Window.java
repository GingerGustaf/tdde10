/**
 * Creates and has settings for window
 */

package graphics;

import javax.swing.JFrame;

public class Window extends JFrame{
	private JFrame theWindow;
	private Window window = this;
	
	public Window() {
		theWindow = new JFrame("Brek Adventures");
		theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theWindow.setContentPane(new Menu(window));
		theWindow.setVisible(true);
		theWindow.pack();
	}
	
	public void startGame() {
		theWindow = new JFrame("Brek Adventures");
		theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theWindow.setContentPane(new Panel());
		theWindow.setVisible(true);
		theWindow.pack();
	}

}
