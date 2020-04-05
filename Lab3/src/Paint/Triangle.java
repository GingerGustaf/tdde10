package Paint;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shapes {
	private int[] x;
	private int[] y;
	private Color color;

	public Triangle(int x, int y, Color currentColor) {
		this.x = new int[] { x, x + 25, x + 50 };
		this.y = new int[] { y + 50, y, y + 50 };
		this.color = currentColor;
	}

	@Override
	public void paintShape(Graphics g) {
		g.setColor(this.color);
		g.fillPolygon(this.x, this.y, 3);
	}

}
