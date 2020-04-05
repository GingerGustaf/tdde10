package Paint;

import java.awt.Color;
import java.awt.Graphics;

public class ColorButton {
private Color color;
private int y;
private int width;
private int kord; 
private Boolean b = false;
private Model model;

public ColorButton(Color color, int buttonnumber, Model model) {
	this.color = color;
	this.y = 20 + 40*buttonnumber;
	this.width = 40;
	this.model = model;
}

public void paintYourself (Graphics g) {
	g.setColor(this.color);
	g.fillRect(0, this.y, this.width, this.width);
	if (b == true) {
		g.setColor(color.black);
		for (int i = 0; i < 4; i++) {
			g.drawRect(i, this.y + i, this.width - i*2, this.width - i*2);
		}
	}
}

public void setKord(int kord) {
	this.kord = kord;
	if (y <= kord && kord <= y + 40) {
		b = true;
		this.model.setCurrentColor(this.color);
	} else {
		b = false;
	}
}	
	
}
