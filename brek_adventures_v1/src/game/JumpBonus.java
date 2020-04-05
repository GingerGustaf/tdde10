/**
 * jump bonus powerup, increase jump height
 */
package game;

import java.awt.*;

public class JumpBonus extends Object {

	private boolean pickUp = false;
	private boolean jumpBonusPowerUp = false;
	
	private int time = 0;
	private int fps = 30;

	public JumpBonus(TileMap tilemap, Player player, Game game, int x, int y, boolean pickUp) {
		super(tilemap);
		this.tilemap = tilemap;
		this.game = game;
		this.player = player;
		this.x = x;
		this.y = y;
		width = 24;
		height = 24;
	}

//////////////////////////////////////////

	public boolean getPickUp() {
		return pickUp;
	}

	public void setPickUp(boolean temp) {
		pickUp = temp;
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
				&& y - height / 2 < player.gety() && !jumpBonusPowerUp) {
			jumpBonusPowerUp = true;
			pickUp = true;
			game.setJumpBonus(true);
		}
	}
	
	private void powerUpTime() {
		if (game.getJumpBonus()) {
			int duration = fps * 10; //duration 10 seconds
			time ++;
			if (duration == time) {
				game.setJumpBonus(false);
				time = 0;
			}
		}
		
	}

	public void draw(Graphics2D g) {
		if (!pickUp) {
			g.setColor(Color.cyan);
		} else {
			g.setColor(Color.white);
		}
		g.fillOval((int) (x - width / 2), (int) (y - height / 2), width, height);
	}

}
