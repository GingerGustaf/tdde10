/**
 * scans textfile which contain blueprint for maps
 */

package game;

import java.awt.*;
import java.io.*;

public class TileMap {
	
	private String fileName;
	private int tileSize;
	
	private int[] [] map;
	private int mapHeight = 30;
	private int mapWidth = 64;
	
	public TileMap(String fileName, int tileSize) {
		this.tileSize = tileSize;
		this.fileName = fileName;
		read();
	}
	
	public int getColTile(int x) { //vilken tile man är på
		return x / this.tileSize;
	}
	public int getRowTile(int y) {
		return y / this.tileSize;
	}
	
	public int getTile(int row, int col) { 
		return map[row] [col];
	}
	
	
	public int getTileSize() {
		return tileSize;
	}
	
	///////////////////////////////////////////////////////////////
	private void read() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			map = new int[mapHeight] [mapWidth];
			for (int row = 0; row < mapHeight; row++) {
				String space = " ";
				String line = reader.readLine();
				String[] number = line.split(space);
				for (int col = 0; col < mapWidth; col++) {
					map [row] [col] = Integer.parseInt(number[col]);
				}
			}
		}
		catch (Exception e) {
			
		}
		
	}
	
	public void draw(Graphics2D g) {
		for (int row = 0; row < mapHeight; row++) {
			for (int col = 0; col < mapWidth; col++) {
				int tile = map[row] [col];
				
				if (tile == 0) {
					g.setColor(Color.white);
				}
				else if (tile == 1) {
					g.setColor(Color.blue);
				}
				g.fillRect(col * tileSize,row * tileSize, tileSize, tileSize);
			}
		}
	}
}
