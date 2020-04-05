/**
 * Contains collision logic, 
 */

package game;

public class Object {

	private int currentCol;
	private int currentRow;
	
	protected double x;
	protected double y;
	protected double dx;
	protected double dy;
	protected double tox;
	protected double toy;
	
	protected double movementSpeed;
	protected double maxMovementSpeed;
	
	protected int width;
	protected int height;
	
	protected boolean leftSide;
	protected boolean rightSide;
	protected boolean topSide;
	protected boolean bottomSide;
	
	protected boolean fall;
	
	protected double breakingSpeed;
	protected double jumpSpeed;
	protected double gravity;
	protected double maxFallingSpeed;
	
	
	protected TileMap tilemap;
	protected Player player;
	protected Game game;
	
	public Object(TileMap tilemap) {
		this.tilemap = tilemap;
	}
	
	///////////////////////////////////////////////////////////////
	
	public void setx(int temp) {
		x = temp;
	}
	
	public void setJump(int temp) {
		jumpSpeed = temp;
	}
	
	public void sety(int temp) {
		y = temp;
	}
	
	public double getx() {
		return x;
	} 
	public double gety() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setdx(int dx) {
		this.dx = dx;
	}
	
	public void setdy(int dy) {
		this.dy = dy;
	}
	
	////////////////////////////////////////
	
	protected void checkSide(double x, double y) {
		int leftTile = tilemap.getColTile((int) (x - width / 2));
		int rightTile = tilemap.getColTile((int) (x + width / 2));
		int topTile = tilemap.getRowTile((int) (y - height / 2));
		int bottomTile = tilemap.getColTile((int) (y + width / 2));
		
		currentCol = tilemap.getColTile((int) x);
		currentRow = tilemap.getRowTile((int) y);
		
		if (tilemap.getTile(currentRow, leftTile) == 1) {
			leftSide = true;
		}
		else {
			leftSide = false;
		}
		if (tilemap.getTile(currentRow, rightTile) == 1) {
			rightSide = true;
		}
		else {
			rightSide = false;
		}
		if (tilemap.getTile(topTile, currentCol) == 1) {
			topSide = true;
		}
		else {
			topSide = false;
		}
		if (tilemap.getTile(bottomTile, currentCol) == 1) {
			bottomSide = true;
		}
		else {
			bottomSide = false;
		}
		
	}
	
	
	
	protected void checkCollision() {
		
		tox = x + dx;
		toy = y + dy;
		
		checkSide(x, toy);
		if (dy < 0) {
			if (topSide) {
				dy = 0;
				y = currentRow * tilemap.getTileSize() + height / 2;
				
			}
			else {
				y += dy;
			}
		}
		if (dy > 0) {
			if (bottomSide) {
				dy = 0;
				fall = false;
				y = (currentRow + 1) * tilemap.getTileSize() - height / 2;
			}
			else {
				y += dy;
			}
		}
		checkSide(tox, y);
		if (dx < 0) {
			if (leftSide) {
				dx = 0;
				x = currentCol * tilemap.getTileSize() + width / 2;
			}
			else {
				x += dx;
			}
		}
		if (dx > 0) {
			if (rightSide) {
				dx = 0;
				x = (currentCol + 1) * tilemap.getTileSize() - width / 2; 
			}
			else {
				x += dx;
			}
		}
		
		if (!fall) {
			checkSide(x, y + 1);
			if (!bottomSide) {
				fall = true;
			}
		}
	}
	
	
	
}
