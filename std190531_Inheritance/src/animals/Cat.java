package animals;

public class Cat extends Animal{

	public Cat(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Is a Cat : " + super.getName());
	}
	
	public void catMethod() {
		System.out.println("무기는 발톱입니다.");
	}
	
}
