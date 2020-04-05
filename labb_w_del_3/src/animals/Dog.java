package animals;

public class Dog extends Animal {
	
	public Dog(String name, int age) {
		super(name, age);
	}

	public void printAnimal() {
		System.out.println("Hunden " + super.setName() + " är " + super.setAge());
	}
}
