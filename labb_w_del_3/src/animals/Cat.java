package animals;

public class Cat extends Animal {

	public Cat(String name, int age) {
		super(name, age);

	}
	
	public void printAnimal() {
		
		System.out.println("Katten " + super.setName() + " är " + super.setAge());
	}
}
