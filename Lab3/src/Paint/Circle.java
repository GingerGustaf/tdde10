package Paint;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shapes {
	private int x;
	private int y;
	private Color color;

	public Circle(int x, int y, Color currentColor) {
		this.x = x;
		this.y = y;
		this.color = currentColor;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public void paintShape(Graphics g) {
		g.setColor(this.color);
		g.fillOval(this.x, this.y, 50, 50);
	}
}