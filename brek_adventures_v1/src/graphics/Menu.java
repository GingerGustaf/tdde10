/**
 * The panel where the content is drawn
 */

package graphics;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import game.TileMap;

import game.Game;

public class Menu extends JPanel implements Runnable, MouseListener{
	
	private int x;
	private int y;
	private int n = 0;
	private Window window;
	
	public static int HEIGHT = 960; //höjd 40 
	public static int WIDTH = 1536;  //tilesize 24, bredd 64
	
	private Thread thread;
	
	private BufferedImage img;
	private Graphics2D g;
	private Game game;
	
	public Menu(Window window) {
		super();
		this.window = window;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		
		thread = new Thread(this);
		thread.start();
	}
	
	////////////////////////////////////////////////////////////////////////////
	
	public void run() {
		startup();
		while(true) {
		render();
		draw();
		}
	}
	
	public void startup() {
		img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) img.getGraphics();
		addMouseListener(this);
	}
	
	public void render() {
		g.setColor(Color.orange);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.green);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 64));
		g.drawString("BREK ADVENTURES", 500, 200);
		g.drawString("PLAY", 580, 300);
		g.drawString("EXIT", 580, 400);
		
		
	}
	
	public void draw() {
		Graphics g = this.getGraphics();
		g.drawImage(img, 0, 0, null);
		g.dispose();
	}
	
	private void click() {
		if (x > 580 && x < 680 && y < 300 && y > 250 ) {
			window.startGame();
			
		}
		else if (x > 580 && x < 680 && y < 400 && y > 350) {
			System.exit(n);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		click();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
