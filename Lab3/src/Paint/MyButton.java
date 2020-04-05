package Paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton implements ActionListener {
	private DrawArea area;

	public MyButton(DrawArea area) {
		this.area = area;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("Rensar!");
		this.area.getModel().clearShapes();
		this.area.repaint();

	}

}