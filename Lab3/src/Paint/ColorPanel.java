package Paint;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class ColorPanel extends JPanel {
	private int Y;
	private Model model;
	private int width;
	private ArrayList<ColorButton> colorbuttons;

	public ColorPanel(Model model) {
		this.setLayout(new FlowLayout());
		this.model = model;

		this.colorbuttons = new ArrayList();
		this.colorbuttons.add(new ColorButton(Color.black, 0, model));
		this.colorbuttons.add(new ColorButton(Color.white, 1, model));
		this.colorbuttons.add(new ColorButton(Color.blue, 2, model));
		this.colorbuttons.add(new ColorButton(Color.red, 3, model));
		this.colorbuttons.add(new ColorButton(Color.yellow, 4, model));
		this.colorbuttons.add(new ColorButton(Color.green, 5, model));
		this.colorbuttons.add(new ColorButton(Color.magenta, 6, model));
		this.colorbuttons.add(new ColorButton(Color.cyan, 7, model));

		this.setVisible(true);
		this.repaint();
	}

	public void drawColors(Graphics g, int width) {
		for (ColorButton c : colorbuttons) {
			c.paintYourself(g);
		}

	}

	public void markColor(Graphics g, int width) {
		g.setColor(Color.BLACK);
		for (ColorButton c : colorbuttons) {
		}

	}

	public void setY(int Y) {
		if (20 <= Y && Y <= 340) {
			this.Y = Y;
		}
		for (ColorButton c : colorbuttons) {
			c.setKord(Y);
		}

	}

}
