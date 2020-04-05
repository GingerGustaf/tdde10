/**
 * Powerup that turns the player invincible for 10 s
 */
package game;

import java.awt.*;

public class Invincible extends Object{
	
	private boolean pickUp = false;
	private boolean invinciblePowerUp = false;
	
	private int fps = 30;
	private int time = 0;
	
	public Invincible(TileMap tilemap, Player player, Game game, int x, int y, boolean pickUp) {
		super(tilemap);
		this.player = player;
		this.tilemap = tilemap;
		this.game = game;
		this.x = x;
		this.y = y;
		width = 24;
		height = 24;
	}
	
	//////////////////////////////////////////////
	
	public void update() {
		playerCollision();
		powerUpTime();
	}
	
	protected void playerCollision() {
		if (x + width / 2 > player.getx() 
				&& x - width / 2 < player.getx()
				&& y + height / 2 > player.gety()
				&& y - height / 2 < player.gety() && !invinciblePowerUp) {
			invinciblePowerUp = true;
			pickUp = true;
			game.setInvincible(true);
		}
	}
	
	private void powerUpTime() {
		if (game.getpickUpInvincible()) {
			int duration = fps * 10; //duration 10 seconds
			time ++;
			if (duration == time) {
				game.setInvincible(false);
				time = 0;
			}
		}
		
	}
	
	public void draw(Graphics2D g) {
		
		if (!pickUp) {
			g.setColor(Color.yellow);
		}
		else {
			g.setColor(Color.white);
		}
		g.fillOval((int) (x - width / 2), (int) (y - height / 2), width, height);
	}
	
	

}
