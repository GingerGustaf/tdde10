package Paint;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShapePanel extends JPanel {
	private int Y;
	private Model model;

	public ShapePanel(Model model) {
		this.model = model;

	}

	public void drawShapes(Graphics g, int width) {
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		g.setColor(Color.ORANGE);
		g.fillOval(0, 410, width, width);
		g.fillRect(0, 410 + width, width, width);
		g.fillPolygon(new int[] { 0, width / 2, width }, new int[] { 530, 490, 530 }, 3);
	}

	public void markShape(Graphics g, int width) {
		g.setColor(Color.BLACK);

		if (410 <= this.Y && this.Y <= 450) {

			for (int i = 0; i < 4; i++) {
				g.drawRect(i, 410 + i, width - i * 2, width - i * 2);
				this.model.setCurrentShape("c");
			}
		} else if (450 <= this.Y && this.Y <= 490) {
			for (int i = 0; i < 4; i++) {
				g.drawRect(i, 410 + width + i, width - i * 2, width - i * 2);
				this.model.setCurrentShape("s");

			}
		} else if (490 <= this.Y && this.Y <= 530) {
			for (int i = 0; i < 4; i++) {
			g.drawRect(i, 410 + 2 * width + i, width - i * 2, width - i * 2);
				this.model.setCurrentShape("t");

			}
		} else { 

		}
	}

	public void setY(int Y) {
		if (410 <= Y && Y <= 530) {
			this.Y = Y;
		}
	}
}
