package labb_1;

import java.util.*;

public class Game {
	private Scanner keyboard;
	private static ArrayList<Location> locations;
	private boolean isAllowed;

	// TODO: Komplettering: Denna variabel hör inte till game, är det
	// players inventory borde den endast ligga i player inte i game
	// där den inte ska användas FIXAT
	//private ArrayList<Item> playerInventory;
	private Player player;

	public Game() { // games konstruktor
		keyboard = new Scanner(System.in);
		locations = new ArrayList<Location>();
		//playerInventory = new ArrayList<Item>();

		Outside startingLocation = new Outside("The Crossroads",
				"You start off your adventure in the middle of a crossroad. Far away in the north you see a red house, west of you there is a blue house, east of you is a road which seem to continue on forever, and south of you, you see the ocean. It's now up to you to choose which path to take!",
				"You are back at the crossroads.", false, true); // ordningen north, east, south, west
		Room redHouse = new Room("Red house",
				"You enter the red house and find yourself inside a beautiful home with some nice decorations and a cool jacket hanging by the entrance. To the east of the house there is a garden.",
				"You enter the red house again.", false, true, "red room");
		Outside garden = new Outside("Garden",
				"You go out to the garden which doesn't seem to have been taken care of very well, all you see is a shovel and tons of holes in the ground as if someone has been on a treasure hunt.",
				"You enter the garden again.", false, true);
		Outside emptyRoad = new Outside("Empty road",
				"You walk and walk for miles and after all this time you see a huge wall stopping you from continuing down this road, all you can do is go back west. At least someone left a pair of sandals here, so it's more comfortable to go back.",
				"You go down the empty road again and end up at the wall.", false, true);
		Room blueRoom = new Room("Blue house",
				"You enter the blue room which is almost completely empty, there is multiple lamps lighting at a superman_cape hanging in the middle of the room.",
				"You enter the blue house again.", false, false, "blue room");
		Outside beach = new Outside("Beach",
				"You walk towards the ocean and end up at a beach, as you walk in the sand you stumble upon a key lying in the sand. Who knows which door it is for?",
				"You are at the beach again.", false, true);

		locations.add(startingLocation); // index 0 är starting location
		locations.add(redHouse); // 1 redRoom
		locations.add(garden); // 2 garden
		locations.add(emptyRoad); // 3 emptyRoad
		locations.add(blueRoom); // 4 blueRoom
		locations.add(beach); // 5 beach

		// locations.add(new Room("Starting location", "long description", "short
		// description", false));

		// Här skapar vi kartan
		startingLocation.addNeighbor(beach, "south");
		startingLocation.addNeighbor(blueRoom, "west");
		startingLocation.addNeighbor(redHouse, "north");
		startingLocation.addNeighbor(emptyRoad, "east");

		redHouse.addNeighbor(startingLocation, "south");
		redHouse.addNeighbor(garden, "east");

		garden.addNeighbor(redHouse, "west");

		emptyRoad.addNeighbor(startingLocation, "west");

		blueRoom.addNeighbor(startingLocation, "east");

		beach.addNeighbor(startingLocation, "north");

		// Skapar items
		Shovel shovel = new Shovel("shovel", "dig", "You dig a hole in the ground but find nothing.", 20.5, false);
		Key key = new Key("key", "use key ", "You use the key to open the door to the ", 1.5, false);

		WearableItem jacket = new WearableItem("jacket", "wear jacket", "You put on the jacket.", 10, 3, false);
		WearableItem sandals = new WearableItem("sandals", "wear sandals", "You put on the sandals.", 0.5, 0.25, false);
		WearableItem superman_cape = new WearableItem("superman_cape", "wear superman_cape",
				"You put on the legendary superman_cape!!!", 10000, 1, false);

		// lägger till items i locations
		beach.addItems(key);
		redHouse.addItems(jacket);
		garden.addItems(shovel);
		emptyRoad.addItems(sandals);
		blueRoom.addItems(superman_cape);
	}

	public void run() {
		String name;

		System.out.println("Welcome to the adventure game!\nWhat is your name?");
		name = keyboard.nextLine(); // tar in inmatning från spelare
		player = new Player(name, (Location) locations.get(0)); // varför (Location) ???? + eventuellt
																					// ta bort location ur konstruktor
		System.out.println("Hello " + name
				+ ", welcome to this magical world of wonder! You can move around by typing north/south/west/east. You will have to learn more commands as you play the game! (Hint: there is a command \"help\").");

		String command = "north";
		while (true) {
					
				player.getLocation().describeYourself(); // getLocation bestämmer för vilket objekt man vill kalla på
															// describeYourself
			System.out.println("What do you want to do?");
			command = keyboard.nextLine();

			if (command.equals("help")) {
				System.out.println(
						"You move around by typing 'north', 'east', ´south' or 'west'. If you want to pick ut an item, write 'take item' (i.e 'take shovel'). To open doors with a key you write 'use key' and the direction of the door you want to open (i.e 'use key east'). If you want to know which directions are possible and where you are currently located, use the command 'look'. To view your inventory, type the command 'items'.");
			continue;
			}

			 isAllowed = player.doCommand(command);
			
			if (isAllowed) {
				System.out.println("Unknown command, please try again.");

				continue;
			} 
		}
	}

}
