package labb_1;

import java.util.ArrayList;

public class Location {

	// tog bort abstract, kan inte skapa nya objekt av abstract klasser

	// Kommentar: Det är generellt dålig praxis att deklarera flera
	// variabler på samma rad då det försämrar kodens läslighet.
	private String name;
	protected String shortDescription, longDescription;
	protected boolean visited;
	private boolean unlocked;
	private Location north, east, south, west;
	private static Location current;
	private ArrayList<Item> items = new ArrayList<Item>();

	public Location(String name, String longDescription, String shortDescription, boolean visited, boolean unlocked) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.visited = visited;
		this.unlocked = unlocked;
	}

	public void addItems(Item item) {
		this.items.add(item);
	}

	public boolean canDig() {
		return false;
	}

	public static Location getCurrent() {
		return current;
	}

	public void addNeighbor(Location loc, String direction) {
		if (direction.equals("east")) {
			this.east = loc;
		}

		if (direction.equals("west")) {
			this.west = loc;
		}

		if (direction.equals("north")) {
			this.north = loc;
		}

		if (direction.equals("south")) {
			this.south = loc;
		}

	}

	// TODO: Komplettering: Ni har väldigt många getters/setters här,
	// behövs verkligen alla? Går det att strukturera om er labb så att
	// ni kan ta bort vissa av dessa? Om inte, motivera varför. FIXAT?

	public String getName() { // används i player och i key
		return name;
	}

	public ArrayList<Item> getItems() { // används i player
		return items;
	}

	public boolean getUnlocked() { // används i player
		return unlocked;
	}

	public Location getNorth() {
		return north;
	}

	public Location getEast() {
		return east;
	}

	public Location getSouth() {
		return south;
	}

	public Location getWest() {
		return west;
	}

	public void describeYourself() {

		if (visited) {
			System.out.println(shortDescription);
		} else {
			System.out.println(longDescription);
			visited = true;
		}
	}

	public void openDoor() {
		unlocked = true;
	}

	public boolean doCommand(String command, ArrayList<Item> inventory) {

		for (int i = 0; i < items.size(); ++i) {
			if (command.equals("take " + items.get(i).getName()) && items.get(i) != null) {
				items.get(i).pickUpItem();
				inventory.add(items.get(i));
				System.out.println("you picked up the " + items.get(i).getName() + "," + " type the command " + "'"
						+ items.get(i).getAbility() + "'" + " to use it.");
				items.remove(items.get(i));
				return false;
			}
		}

		if (command.equals("north")) {
			// System.out.println("LOLTYLER1");

			if (north == null) {
				System.out.println("This direction is not allowed, please try another direction");

			}

			else if (north != null && north.getUnlocked() == true) {
				current = north;

			}

			else if (north != null && north.getUnlocked() == false) {
				System.out.println("The door to this location is locked, you need a key to open it.");

			}
			return false;
		} else if (command.equals("south")) {

			if (south == null) {
				System.out.println("This direction is not allowed, please try another direction");

			}

			else if (south != null && south.getUnlocked() == true) {
				current = south;

			}

			else if (south != null && south.getUnlocked() == false) {
				System.out.println("The door to this location is locked, you need a key to open it.");

			}
			return false;
		}

		else if (command.equals("west")) {
			// System.out.println(west.getUnlocked());

			if (west == null) {
				System.out.println("This direction is not allowed, please try another direction");

			}

			else if (west != null && west.getUnlocked() == true) {
				current = west;

			}

			else if (west != null && west.getUnlocked() == false) {
				System.out.println("The door to this location is locked, you need a key to open it.");

			}
			return false;
		}

		else if (command.equals("east")) {

			if (east == null) {
				System.out.println("This direction is not allowed, please try another direction");

			}

			else if (east != null && east.getUnlocked() == true) {
				current = east;
			}

			else if (east != null && east.getUnlocked() == false) {
				System.out.println("The door to this location is locked, you need a key to open it.");
			}
			return false;
		}

		else if (command.equals("look")) {
			System.out.println("You are at " + getName() + ".");

			if (east != null) {
				System.out.println("There is a road leading east.");
			}

			if (west != null) {
				System.out.println("There is a road leading west.");
			}

			if (south != null) {
				System.out.println("There is a road leading south.");
			}

			if (north != null) {
				System.out.println("There is a road leading north.");
			}
			return false;
		}
		else {
			return true;
		}

	}

}
