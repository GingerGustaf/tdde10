/**
 * Some collision logic that enemies has in common
 */
package game;

import java.awt.*;

public abstract class Enemies extends Object {
	
	public Enemies(TileMap tilemap, Player player, Game game) {
		super(tilemap);
		this.player = player;
		this.game = game;
	}
	
	protected void playerCollision() {
		if (x +  width / 2 > player.getx() 
			&& x - width / 2 < player.getx()
			&& y + height / 2 > player.gety()
			&& y - height / 2 < player.gety()) {
				game.gameOver();
		}
	}

	public abstract void draw(Graphics2D g); 
	
	/////////////////////////////////////////////////////////////
	
	
}
