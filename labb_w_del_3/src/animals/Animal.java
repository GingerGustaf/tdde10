package animals;

import java.util.ArrayList;

public class Animal {
	private String name;
	private int age;
	protected Toy toy;
	protected Animal friend;
	ArrayList<Toy> toyList = new ArrayList<Toy>();
	
	public Animal(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String setName() {
		return name;
	}
	
	public int setAge() {
		return age;
	}
	
	public void setFriend(Animal animal) {
		friend = animal;
	}
	public void addToy(Toy toy) {
		toyList.add(toy);
		//System.out.println(toy.toyName);
	}
	
	public void printAnimal() {
		
		System.out.println("djuret " + setName() + " är " + setAge() +" gammal");
	}

}
