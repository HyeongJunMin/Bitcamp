package work4Shape;

public class Circle extends Shape{
	private double r;
	public Circle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Circle(Point p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	public Circle(Point p, double r) {
		super(p);
		this.r = r;
	}

	@Override
	double calcArea() {
		// TODO Auto-generated method stub
		return 3.14 * ( Math.pow(this.r, 2));
	}
	
}
