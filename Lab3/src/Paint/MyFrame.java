package Paint;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JFrame;


public class MyFrame extends JFrame {

	public MyFrame() {
		super("Välkommen till Ritprogrammet!");

		Container container = getContentPane();

		Model model = new Model();

		ShapePanel shapePanel = new ShapePanel(model);

		ColorPanel colorPanel = new ColorPanel(model);

		EastPanel eastPanel = new EastPanel(colorPanel, shapePanel);

		DrawArea drawArea = new DrawArea(eastPanel, model);

		SouthPanel southPanel = new SouthPanel(drawArea);

		container.setLayout(new BorderLayout());
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));

		container.add(drawArea, BorderLayout.CENTER);
		container.add(southPanel, BorderLayout.SOUTH);
		container.add(eastPanel, BorderLayout.EAST);

		this.setSize(1000, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		JFrame theWindow = new MyFrame();

	}

}
