package Paint;

import javax.swing.*;

public class SouthPanel extends JPanel {

private JButton rensa;
private DrawArea area;

public SouthPanel(DrawArea area) {
	this.area = area;
	setVisible(true);
	rensa = new JButton("Rensa");
	add(rensa);
	rensa.addActionListener(new MyButton(this.area));
}

}
