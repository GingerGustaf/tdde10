package labb_1;

public class WearableItem extends Item{
	
	private String ability;
	private String descriptionOfAbility;
	private boolean equipped;
	
	public WearableItem (String name, String ability, String descriptionOfAbility, double armor, double weight, boolean owned) {
		super(name, weight, owned);	
		this.ability = ability;
		this.descriptionOfAbility = descriptionOfAbility;
	}
	
	 public String getAbility() {
		 return ability;
	 }
	
	
	public void performAbility(String command, Player player) {
	 if (command.equals(getAbility()) && equipped == false) {
		 equipped = true;
		 System.out.println(descriptionOfAbility);
	 } 
		 else  {
			 System.out.println("The " + getName() + " is already equipped");
		 }
	 
	}
	
}

