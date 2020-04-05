package animals;

import java.util.ArrayList; 

public class House {
	
	static ArrayList<Animal> animalList = new ArrayList<Animal>();
	
	
	public void addAnimal(Animal animal) {
		animalList.add(animal);
		
	}
	
	public void print() {
	    System.out.println("Följande djur finns i huset:");
	    for (Animal animal : animalList) { //versal innebär statisk, liten bokstav dynamisk??
	    	animal.printAnimal();
	    	
	    	for (Toy toy : animal.toyList) {
	    		System.out.println("Min leksak är " + toy.toyName);
	    	}
	    	
	    	/*
	    	if (animal.toy != null) {
	    		System.out.println("Min leksak är " + animal.toy.toyName);
	    	}
	    	else {
	    		System.out.println("Jag har ingen leksak");
	    	}
			*/
	    	
	    	if (animal.friend != null) {
	    	       System.out.println("Här är uppgifter om min kompis:");
	    	       animal.friend.printAnimal();
	    	    } else {
	    	        System.out.println("Jag har ingen kompis.");
	    	    }
	    	System.out.println("------------------");

	    }
	}

}
