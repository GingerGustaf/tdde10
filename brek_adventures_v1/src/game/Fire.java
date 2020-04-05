/**
 * The fireballs that the dragon spits
 */
package game;

import java.awt.*;

public class Fire extends Dragon{
	
	public Fire(TileMap tilemap, Player player, Game game, int x, int y) {
		super(tilemap, player, game, x, y);
		this.x = x;
		this.y = y;
		height = 24;
		width = 24;
		gravity = 0.62;
		maxFallingSpeed = 11.0;
	}
	public void update() {
		move();
		checkCollision();
		playerCollision();
	}
	
	public boolean checkGround() {
		checkSide(x, toy);
		if (bottomSide) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void move() {
		dy += gravity;
		if (dy >= maxFallingSpeed) {
			dy = maxFallingSpeed;
		}
	}
	
	
	
	public void draw(Graphics2D g) {
		g.setColor(Color.orange);
		g.fillOval((int) (x - width / 2), (int) (y - height / 2), width, height);
	}
}
