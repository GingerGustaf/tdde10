/**
 * The panel where the content is drawn
 */

package graphics;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.*;
import game.TileMap;

import game.Game;

public class Panel extends JPanel {
	
	public static int HEIGHT = 720; //höjd 40 
	public static int WIDTH = 1536;  //tilesize 24, bredd 64
	
	private BufferedImage img;
	private Graphics2D g;
	private Game game;
	public Panel panel = this;
	
	public Panel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		game = new Game(this);
	}
	
	public void startup() {
		img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) img.getGraphics();
	}
	
	public void render() {
		if (!game.getSwitchMap()) {
			game.getMap_1().draw(g);
			game.getKnight1().draw(g);
			game.getKnight2().draw(g);
			game.getInvincible().draw(g);
			game.getJump().draw(g);
		}
		else {
			game.getBossMap().draw(g);
			game.getDragon().draw(g);
			if (game.getGameWon()) {
				g.setFont(new Font("TimesRoman", Font.PLAIN, 64));
				g.drawString("GREAT SUCCESS", 500, 200);
			}
		}
		game.getPlayer().draw(g);
		g.setColor(Color.black);
		g.drawString("Attempts " + game.getTries(), 10, 10);
		
	}
	
	public void draw() {
		Graphics g = this.getGraphics(); // graphics abstract class, cannot be called directly
		g.drawImage(img, 0, 0, null);
	}

}
