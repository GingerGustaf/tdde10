package Paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class DrawArea extends JComponent {

	private Model model;
	private EastPanel eastpanel;

	public DrawArea(EastPanel eastpanel, Model model) {
		this.eastpanel = eastpanel;
		this.setBackground(Color.blue);
		this.addMouseListener(new MyListener(this));
		setVisible(true);
		this.model = model;

	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		this.model.PaintShapes(g);

	}

	public Model getModel() {
		return this.model;
	}

	public EastPanel geteastPanel() {
		return this.eastpanel;
	}

}