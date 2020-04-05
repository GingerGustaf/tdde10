package labb_1;

public abstract class Tool extends Item {

	private String ability;
	private String descriptionOfAbility;
	
	public Tool(String name, String ability, String descriptionOfAbility, double weight, boolean owned) {
		super(name, weight, owned);
		this.ability = ability;
		this.descriptionOfAbility = descriptionOfAbility;
		
	}
	
	 public String getAbility() {
		 return ability;
	 }
	 
	 public String getDescriptionOfAbility() {
		 return descriptionOfAbility;
	 }
	 
	 public abstract void performAbility(String command, Player player);
	
}
