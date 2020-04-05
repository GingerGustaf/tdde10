package Paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyListener implements MouseListener {

	private DrawArea area;

	public MyListener(DrawArea area) {
		this.area = area;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.area.getModel().createShape(e.getX(), e.getY());
		this.area.repaint();
		System.out.println("Vi klickade i komponenten! på " + e.getX() + "," + e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

}