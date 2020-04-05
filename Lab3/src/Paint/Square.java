package Paint;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shapes {

	private int X;
	private int Y;

	private Color color;

	public Square(int X, int Y, Color currentColor) {
		this.X = X;
		this.Y = Y;
		this.color = currentColor;
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public void paintShape(Graphics g) {
		g.setColor(this.color);
		g.fillRect(X, Y, 50, 50);
	}

}
