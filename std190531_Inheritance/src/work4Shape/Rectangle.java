package work4Shape;

public class Rectangle extends Shape {
	private int width;
	private int height;
	
	
	@Override
	double calcArea() {
		// TODO Auto-generated method stub
		return width * height;
	}
	
	boolean isSquare() {
		return (this.width == this.height) ? true : false ;
	}

}
