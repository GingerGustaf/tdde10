/**
 * Contains the game loop
 */

package game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import graphics.Panel;

public class Game implements Runnable {
	
	private int fps = 30;
	
	private Thread thread;
	
	private TileMap map_1;
	private TileMap boss_map;
	private Panel panel;
	private Player player;
	private Knight knight_1;
	private Knight knight_2;
	private Invincible invincible;
	private JumpBonus jumpBonus;
	private Dragon dragon;
	
	private boolean pickUpJumpBonus = false;
	private boolean hit = false;
	private boolean pickUpInvincible = false;
	private boolean switchMap = false;
	private boolean switched = false;
	private boolean gameWon = false;
	
	private int tries = 0;

	public Game(Panel panel) {
		this.panel = panel;
			thread = new Thread(this);
			thread.start();
	}
	
	////////////////////////////////////////////////////////
	public boolean getGameWon() {
		return gameWon;
	}
	
	public Dragon getDragon() {
		return dragon;
	}
	
	public boolean getSwitchMap() {
		return switchMap;
	}
	
	public TileMap getBossMap() {
		return boss_map;
	}
	
	public void setJumpBonus(boolean temp) {
		pickUpJumpBonus = temp;
	}
	
	public boolean getJumpBonus() {
		return pickUpJumpBonus;
	}
	
	public void setInvincible(boolean temp) {
		pickUpInvincible = temp;
	}
	
	public boolean getpickUpInvincible() {
		return pickUpInvincible;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public TileMap getMap_1() {
		return map_1;
	}
	
	public Enemies getKnight1() {
		return knight_1;
	}
	public Enemies getKnight2() {
		return knight_2;
	}
	public boolean getHit() {
		return hit;
	}
	public void setHit(boolean hit) {
		this.hit = hit;
	}
	
	public int getTries() {
		return tries;
	}
	public Invincible getInvincible() {
		return invincible;
	}
	
	public JumpBonus getJump() {
		return jumpBonus;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	public void run() {
		
		long initialTime;
		long newTime;
		long waitTime;
		long targetTime = 1000 / fps; //time per frame in milliseconds
		
		map_1 = new TileMap("resources/map_1.txt", 24);
		boss_map = new TileMap("resources/boss_map.txt", 24);
		player = new Player(map_1, panel, this);
		
		knight_1 = new Knight(map_1, player, this, 1200.0, 640.0, true, false);
		knight_2 = new Knight(map_1, player, this, 1400.0, 640, false, true);
		
		invincible = new Invincible(map_1, player, this, 610, 563, false);
		jumpBonus = new JumpBonus(map_1, player, this, 400, 563, false);
		
		player.setx(50);
		player.sety(620);
		
		panel.startup();
		
		while (true) {
			initialTime = System.nanoTime();
			update();
			panel.render();
			panel.draw();
			
			newTime = System.nanoTime();
			waitTime = targetTime - ((newTime - initialTime) /1000000);
			try {
				
				Thread.sleep(waitTime);
			}
			catch(Exception e) {
				
			}
		}
	}
	
	public void gameOver() {
		if (!pickUpInvincible) {
			hit = true;
			tries ++;
			player.setx(50);
			player.sety(620);
		}
	}
	
	public void gameCompleted() {
		if (player.getx() + player.getWidth() / 2 > 1510 && switched && !gameWon) {
			gameWon = true;
			try(FileWriter writer = new FileWriter("resources/results.txt", true);
				    BufferedWriter bufferedWriter = new BufferedWriter(writer);
				    PrintWriter out = new PrintWriter(bufferedWriter))
				{
				    out.println("Attempts: " + tries);
				    System.out.println("result saved to file successfully");
				} catch (IOException e) {
				    System.out.println("File writing error");
				}
		}
	}
	
	public void switchMap() {
		if (player.getx() + player.getWidth() / 2 > 1530 && !switched) {
			System.out.println("switched map");
			pickUpInvincible = false;
			pickUpJumpBonus = false;
			player = new Player(boss_map, panel, this);
			dragon = new Dragon(boss_map, player, this, 600, 300);
			switchMap = true;
			switched = true;
			player.setx(50);
			player.sety(620);
		}
	}
	
	private void update() {
		
		player.update();
		if (!switchMap) {
			knight_1.update();
			knight_2.update();
			invincible.update();
			jumpBonus.update();
		}
		else {
			dragon.update();
		}
		switchMap();
		gameCompleted();
	}
	
	

	
}
