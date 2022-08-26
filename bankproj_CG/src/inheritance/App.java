package inheritance;

public class App {
	public static void main(String[] args) {
		Cat c = new Cat();
		Dog d = new Dog();
		c.traits();
		c.sound();
		d.traits();
		d.sound();
	}

}

class Animal{
	public void traits() {
		System.out.println("Animal trait");
	}
}

class Cat extends Animal{
	public void sound() {
		System.out.println("Meow");
	}
}

class Dog extends Animal{
	public void traits() {
		System.out.println("Dog trait");
	}
	
	public void sound() {
		System.out.println("Bhao");
	}
}
