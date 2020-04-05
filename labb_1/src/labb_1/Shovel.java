package labb_1;

public class Shovel extends Tool{

	
	
    public Shovel (String name, String ability, String descriptionOfAbility, double weight, boolean owned)	{
	super(name, ability, descriptionOfAbility, weight, owned);
	
    }
	
    public void performAbility(String command, Player player) {
		 
	if (command.equals(getAbility()) && player.getLocation().canDig()) {
	    System.out.println(getDescriptionOfAbility());
	}
		 
    }
}

