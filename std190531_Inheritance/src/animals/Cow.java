package animals;

public class Cow extends Animal {

	public Cow(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Is a Cow : " + super.getName());
	}
}
