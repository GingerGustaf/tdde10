/**
 * Player movement
 */

package game;

import java.awt.*;
import java.awt.event.*;
import graphics.Panel;

public class Player extends Object implements KeyListener {
	
	private boolean right;
	private boolean left;
	private boolean jump;
	
	private Game game;
	
	public Player(TileMap tilemap, Panel panel, Game game) {
		super(tilemap);
		this.tilemap = tilemap;
		this.game = game;
		
		width = 24;
		height = 24;
		
		gravity = 0.6;
		maxFallingSpeed = 11.0;
		movementSpeed = 0.5; 
		maxMovementSpeed = 4.0;
		jumpSpeed = - 10.0;
		breakingSpeed = 0.4;
		
		panel.addKeyListener(this);
	} 
	
	////////////////////////////////////////////////////////////////////////////
	public void update() {
		move();
		jump();
		checkCollision();
		jumpPowerUp();
	}
	
	public void jumpPowerUp() {
		if (game.getJumpBonus()) {
			jumpSpeed = -15;
		}
		else {
			jumpSpeed = -10;
		}
	}
	
	private void move() {
		if(left) {
			dx -= movementSpeed;
			if (dx <= - maxMovementSpeed) {
				dx = - maxMovementSpeed;
			}
		}
		else if (right) {
			dx += movementSpeed;
			if (dx >= maxMovementSpeed) {
				dx = maxMovementSpeed;
			}
		}
		else {
			if (dx > 0) {
				dx -= breakingSpeed;
				if (dx <= 0) {
					dx = 0;
				}
			}
			if (dx < 0) {
				dx += breakingSpeed;
				if (dx >= 0) {
					dx = 0;
				}
			}
		}
	}
	
	private void jump() {
		if (jump) {
			dy = jumpSpeed;
			jump = false;
			fall = true;
		}
		
		if (fall) {
			dy += gravity;
			if (dy >= maxFallingSpeed) {
				dy = maxFallingSpeed;
			}
		}
		else {
			dy = 0;
		}
 }
	
public void draw(Graphics2D g) {
		if (game.getHit()) {
			g.setColor(Color.red);
			game.setHit(false);
		}
		else {
			g.setColor(Color.green);
		}
		g.fillRect((int) ( x - width / 2), (int) ( y - height / 2), width, height);
	
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_A) {
			left  = true;
		}
		if (keyCode == KeyEvent.VK_D) {
			right = true;
		}
		if (keyCode == KeyEvent.VK_W) {
			if (dy == 0) {
				jump = true;
			}
		}
		
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_A) {
			left  = false;
		}
		if (keyCode == KeyEvent.VK_D) {
			right = false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
