package Paint;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public abstract class Shapes extends JPanel {

	public Shapes() {
	}

	public abstract void paintShape(Graphics g);

}