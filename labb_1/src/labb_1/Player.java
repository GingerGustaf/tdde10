package labb_1;

import java.util.*;

public class Player {

	private boolean allowedCommand = false;
	private Location current;
	private ArrayList<Item> inventory;

	public Player(String name, Location current) {
		// this.name = name;
		this.current = current;
		//this.inventory = inventory;
		inventory = new ArrayList<Item>();
	}

	public Location getLocation() {
		return current;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void printItems() {

		for (int i = 0; i < inventory.size(); ++i) {
			inventory.get(i).printItem();
		}

	}

	// TODO: Komplettering: Denna metod hanterar alldeles för många
	// fall. Ni måste flytta ner i passande klasser, exempelvis borde
	// Location själv ta hand om kommandon relaterade till riktning ex
	// "north". Denna metod får endast innehålla kommandon relaterade
	// till Player. FIXAT?
	public boolean doCommand(String command) {

		// TODO: Komplettering: Ni får inte använda gotos då detta är
		// extremt dålig praxis. Känner man att man behöver använda
		// goto så har man med 99% sannorlikhet fel i sin
		// kontrollstruktur (goto = hopp i koden) FIXAT

		// TODO: Komplettering: Det är inte Players ansvar att köra
		// spelloopen, det bör göras i Game klassen FIXAT
		
		
		if (command.equals("items")) { // skriver ut vilka items man har i inventory
			System.out.println("You have the following items:");
			printItems();
			return false;
		}

	/*	for (int i = 0; i < current.getItems().size(); i++) { //den här kan få vara kvar i player? kommer ju alltid vara samma oavsett hur många items vi lägger till
			if (command.equals("take " + current.getItems().get(i).getName())) {
				current.doCommand(command, inventory);
				allowedCommand = false;
			}
		} */

		else if (current.doCommand(command, inventory) == false) {
			current = Location.getCurrent();
				return false;
			}
			
			
			
			for (int i = 0; i < inventory.size(); i++) {
				if (inventory.get(i).doCommand(command, inventory, this) == false) {
					return false;
				}
			}
			
			return true;
			
		
		//else if (!command.contentEquals("take " + current.getItems()) || !command.contentEquals() ) {
			//allowedCommand = true;
			//System.out.println("LOLTYLER1");
		//}

	}

}
