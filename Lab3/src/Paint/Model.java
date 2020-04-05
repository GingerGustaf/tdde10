package Paint;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel; 

public class Model extends JPanel {
	private Color currentColor = Color.black;
	private String currentShape = "c";
	private ArrayList<Shapes> shapeList = new ArrayList<Shapes>();
	
	public void clearShapes() {
		shapeList.clear();
	}
	
	public void addShape(Shapes shape) {
		shapeList.add(shape);
	}
	
	
	
	public void createShape(int X, int Y) {
		if (this.currentShape == "c") {
			addShape(new Circle(X -24, Y - 24, this.currentColor));
		} else if (this.currentShape == "s") {
			addShape(new Square(X-24, Y-24, this.currentColor));
		} else if (this.currentShape == "t") {
			addShape(new Triangle(X-24, Y-24, this.currentColor));
		}
	}

	public ArrayList getShapes() {
		return this.shapeList;
	}
	
	public void setCurrentColor (Color color) {
		this.currentColor = color;
	}
	
	public Color getCurrentColor() {
		return this.currentColor;
	}
	
	public void setCurrentShape(String shape) {
		this.currentShape = shape;
	}
	
	public String getCurrentShape() {
		return this.currentShape;
	}
	
	public void PaintShapes(Graphics g) {
		for (int i = 0; i < this.shapeList.size(); i++) {
			this.shapeList.get(i).paintShape(g);
		}
	}
	
}
