package animals;

public class Dog extends Animal {

	public Dog(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Is a Dog : " + super.getName());
	}
}
