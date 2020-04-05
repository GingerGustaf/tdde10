package Paint;

import java.awt.*;
import javax.swing.*;

public class EastPanel extends JComponent {
private ColorPanel colorpanel;
private ShapePanel shapepanel;

public EastPanel(ColorPanel colorpanel, ShapePanel shapepanel) {
	this.colorpanel = colorpanel;
	this.shapepanel = shapepanel;
	
	this.setLayout(new FlowLayout());
	JLabel colorLabel = new JLabel("Färg");
	
	this.add(colorLabel);
	this.addMouseListener(new ColorListener(this));
	this.addMouseListener(new ShapeListener(this));
	repaint();
	setVisible(true);
	
}

@Override
public void paintComponent( Graphics g) {
	g.drawString("Form", 5, 400);
	this.colorpanel.drawColors(g, getWidth());
	this.shapepanel.drawShapes(g, getWidth());
	this.colorpanel.markColor(g, getWidth());
	this.shapepanel.markShape(g,getWidth());
}

public ColorPanel getcolorPanel() {
	return this.colorpanel;
}

public ShapePanel getshapePanel() {
	return this.shapepanel;
}
}
