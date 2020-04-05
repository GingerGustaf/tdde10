package labb_1;

import java.util.ArrayList;


public class Key extends Tool{

	
    public Key (String name, String ability, String descriptionOfAbility, double weight, boolean owned)	{
	super(name, ability, descriptionOfAbility, weight, owned);
    }
	
    public void performAbility(String command, Player player) { 
		
	if (command.equals(getAbility() + "north") && player.getLocation().getNorth().getUnlocked() == false) {
		
	    player.getLocation().getNorth().openDoor();
	    System.out.println(getDescriptionOfAbility() + player.getLocation().getNorth().getName() + ".");
		 
	}
		 
	if (command.equals(getAbility() + "south") && player.getLocation().getSouth().getUnlocked() == false ) {
				
	    player.getLocation().getSouth().openDoor();
	    System.out.println(getDescriptionOfAbility() + player.getLocation().getSouth().getName() + ".");
		 
	}
		 
	if (command.equals(getAbility() + "west") && player.getLocation().getWest().getUnlocked() == false ) {
				
	    player.getLocation().getWest().openDoor();
	    System.out.println(getDescriptionOfAbility() + player.getLocation().getWest().getName() + ".");
		 
	}
		 
	if (command.equals(getAbility() + "east") && player.getLocation().getEast().getUnlocked() == false ) {
				
	    player.getLocation().getEast().openDoor();
	    System.out.println(getDescriptionOfAbility() + player.getLocation().getEast().getName() + ".");
		 
	}
    }
    
    public boolean doCommand(String command, ArrayList<Item> inventory, Player player) {
    	for (int i = 0; i < inventory.size(); i++) { // specifik för keys
			if (inventory.get(i).getName().equals("key")) {
				if (command.equals(inventory.get(i).getAbility() + "north") && player.getLocation().getNorth() != null) {
					performAbility(command, player);
				}

				else if (command.equals(inventory.get(i).getAbility() + "south") && player.getLocation().getSouth() != null) {
					performAbility(command, player);
				}

				else if (command.equals(inventory.get(i).getAbility() + "east") && player.getLocation().getEast() != null) {
					performAbility(command, player);
				}

				else if (command.equals(inventory.get(i).getAbility() + "west") && player.getLocation().getWest() != null) {
					performAbility(command, player);
				}
				return false;
			}
		} 
    	return true;
    }
    
    
	 
	
}



