package labb_1;

import java.util.ArrayList;

public abstract class Item {
    private String name;
    private double weight;
 
    private boolean owned;
	
    public Item (String name, double weight, boolean owned) {
	this.name = name;
	this.weight = weight;
	this.owned = owned;
    }
 

 
    public String getName() {
	return name;
    }
 
    public boolean pickUpItem () {
	//Kommentar: Ska detta vara ett booleanskt uttryck eller en
	//tilldelning? Är det ett booleanskt uttryck är det
	//felformulerat, annars ska det va på egen rad
	return owned = true;
    }

    public void printItem () {
	if (owned) {
	    System.out.println(this.name + " (" + this.weight + ") " + "kg.");
	}
    }
 
    public abstract void performAbility(String command, Player player);
    public abstract String getAbility();
    public boolean doCommand(String command, ArrayList<Item> inventory, Player player) {
    	for (int i = 0; i < inventory.size(); i++) { // för items förutom keys
			if (command.equals(inventory.get(i).getAbility())) {
				inventory.get(i).performAbility(command, player);
				return false;
			}
		}
    	return true;
    }

}
 
