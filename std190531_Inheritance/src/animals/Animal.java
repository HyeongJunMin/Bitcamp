package animals;

public class Animal {
	private String name;

	public Animal(String name) {
		super();
		this.name = name;
	}
	
	public void print() {
		System.out.println("Animal name : " + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
