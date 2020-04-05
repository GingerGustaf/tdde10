/**
 * Knight class, enemy that walks in a straight line
 */
package game;

import java.awt.Color;
import java.awt.Graphics2D;

public class Knight extends Enemies{
	
	private boolean left;
	private boolean right;
	
	public Knight(TileMap tilemap, Player player, Game game, double x, double y, boolean left, boolean right) {
		super(tilemap, player, game);
		
		this.x = x;
		this.y = y;
		this.left = left;
		this.right = right;
		
		movementSpeed = 0.5;
		maxMovementSpeed = 4.0;
		gravity = 0.62;
		maxFallingSpeed = 11.0;
		fall = true;
		
		width = 24;
		height = 24;
	}
	
	public void update() {
		move();
		checkCollision();
		changeDirection();
		playerCollision();
	}
	
	public void changeDirection() {
		
		checkSide(tox, y);
		if (leftSide) {
			this.left = false;
			this.right = true;
		}
		if (rightSide) {
			this.left = true;
			this.right = false;
			}
		}
	
	public void draw(Graphics2D g) {
		
		g.setColor(Color.gray);
		g.fillRect((int) ( x - width / 2), (int) ( y - height / 2), width, height);
	}
	
	public void move() {
		if (right) {
			dx += movementSpeed;
			if (dx >= movementSpeed) {
				dx = maxMovementSpeed;
				
			}
		}
		else if (left) {
			dx -= movementSpeed;
			if (dx <= movementSpeed) {
				dx = - maxMovementSpeed;
			}
		}
		if (fall) {
			dy += gravity;
			if (dy >= maxFallingSpeed) {
				dy = maxFallingSpeed;
			}
		}
	}
	
}
