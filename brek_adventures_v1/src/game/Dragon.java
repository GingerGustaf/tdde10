/**
 * The dragon boss, spits fire downwards
 */
package game;

import java.awt.*;

public class Dragon extends Enemies{
	
	private Fire fireball;
	
	int n = 0;

	public Dragon(TileMap tilemap, Player player, Game game, int x, int y) {
		super(tilemap, player, game);
		this.x = x;
		this.y = y;
		
		width = 96;
		height = 96;
	}
	
	public void shootFire() {
		n = n + 1;
		if (n==1) {
			fireball = new Fire(tilemap, player, game, (int) x, (int) y);
		}
		else {
			if (fireball.checkGround()) {
				fireball = new Fire(tilemap, player, game, (int) x, (int) y);
			}
		}
		
		
	}
	
	public void update() {
		shootFire();
		playerCollision();
		fireball.update();
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.red);
		g.fillRect((int) ( x - width / 2), (int) ( y - height / 2), width, height);
		if (fireball != null) {
			fireball.draw(g);
		}
		
	}
}
