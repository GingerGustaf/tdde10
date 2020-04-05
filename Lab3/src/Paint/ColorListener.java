package Paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColorListener implements MouseListener {

	private EastPanel panel;

	public ColorListener(EastPanel eastPanel) {
		this.panel = eastPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.panel.getcolorPanel().setY(e.getY());
		this.panel.repaint();

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